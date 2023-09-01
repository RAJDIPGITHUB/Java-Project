import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class Removeemployee extends JFrame implements ActionListener {
    Choice ed;
    JButton delete,back;
    Removeemployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel employeeid = new JLabel("EMPLOYEE ID");
        employeeid.setBounds(30,20,100,50);
        add(employeeid);

        ed = new Choice();
        ed.setBounds(150,30,200,50);
        
        add(ed);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from emp");
            while(rs.next())
            {
                ed.add(rs.getString("eid"));
            }

            
        } catch (Exception e) {
            e.getStackTrace();
        }
        JLabel jbname = new JLabel("NAME");
        jbname.setBounds(50,70,100,30);
        add(jbname);

        JLabel jtname = new JLabel();
        jtname.setBounds(150,70,150,30);
        add(jtname);

        JLabel jbphone = new JLabel("PHONE");
        jbphone.setBounds(50,120,100,30);
        add(jbphone);

        JLabel jtphone = new JLabel();
        jtphone.setBounds(150,120,150,30);
        add(jtphone);

        JLabel jbemail = new JLabel("EMAIL");
        jbemail.setBounds(50,180,100,30);
        add(jbemail);

        JLabel jtemail = new JLabel();
        jtemail.setBounds(150,180,150,30);
        add(jtemail);

        try {
            Conn c = new Conn();
            String query="select * from emp where eid ='"+ed.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                jtname.setText(rs.getString("name"));
                jtphone.setText(rs.getString("phone"));
                jtemail.setText(rs.getString("email"));
            }

            
        } catch (Exception e) {
            e.getStackTrace();
        }

        ed.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                try {
                    Conn c = new Conn();
                    String query="select * from emp where eid ='"+ed.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next())
                    {
                        jtname.setText(rs.getString("name"));
                        jtphone.setText(rs.getString("phone"));
                        jtemail.setText(rs.getString("email"));
                    }
        
                    
                } catch (Exception e) {
                    e.getStackTrace();
                } 
            }
        });

        delete =new JButton("DELETE DETAILS");
        delete.setBounds(150,230,150,50);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back =new JButton("BACK");
        back.setBounds(330,230,150,50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ima = new JLabel(i3);
        ima.setBounds(300,0,600,400);
        add(ima);



        setSize(1000,400);
        setVisible(true);
        setLocation(150, 70);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==delete)
       { try {
                
            Conn c = new Conn();
            String query = "delete from emp where eid = '"+ed.getSelectedItem()+"'";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"DELETE Emplyee Successfully");
            setVisible(false);
            new Home();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    else
    {
        setVisible(false);
        new Home();
    }

       
}

    public static void main(String ags[])
    {
        new Removeemployee();
    }
}
