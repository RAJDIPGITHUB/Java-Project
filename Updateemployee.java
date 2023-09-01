import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.sql.*;

public class Updateemployee extends JFrame implements ActionListener {
    JButton add,back;
    JTextField jtname,jtfname,jtsalary,jtadd,jtphone,jtemail,jtdegi,jtaddhar,jcedu;
    JLabel jbemid,jladdhar;
    String id;
    Updateemployee(String id)
    {
        this.id=id;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("UPDATE EMPLOYEE DETAIL");
        heading.setBounds(320,30,500,60);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel jbname = new JLabel("NAME");
        jbname.setBounds(50,150,100,30);
        add(jbname);

        JLabel jtname = new JLabel();
        jtname.setBounds(150,150,150,30);
        add(jtname);

        JLabel jbfname = new JLabel("FATHER'S NAME");
        jbfname.setBounds(450,150,100,30);
        add(jbfname);

        jtfname = new JTextField();
        jtfname.setBounds(550,150,150,30);
        add(jtfname);

        JLabel jbdob = new JLabel("D.O.B");
        jbdob.setBounds(50,200,100,30);
        add(jbdob);

        JLabel jddob = new JLabel();
        jddob.setBounds(150,200,150,30);
        add(jddob);

        JLabel jbsalary = new JLabel("SALARY");
        jbsalary.setBounds(450,200,100,30);
        add(jbsalary);

        jtsalary= new JTextField();
        jtsalary.setBounds(550,200,150,30);
        add(jtsalary);

        JLabel jbadd = new JLabel("ADDRESS");
        jbadd.setBounds(50,250,100,30);
        add(jbadd);

        jtadd = new JTextField();
        jtadd.setBounds(150,250,150,30);
        add(jtadd);

        JLabel jbphone = new JLabel("PHONE");
        jbphone.setBounds(450,250,100,30);
        add(jbphone);

        jtphone = new JTextField();
        jtphone.setBounds(550,250,150,30);
        add(jtphone);

        JLabel jbemail = new JLabel("EMAIL");
        jbemail.setBounds(50,300,100,30);
        add(jbemail);

        jtemail = new JTextField();
        jtemail.setBounds(150,300,150,30);
        add(jtemail);

        JLabel jbedu = new JLabel("EDUCATION");
        jbedu.setBounds(450,300,100,30);
        add(jbedu);

        
        jcedu = new JTextField();
        jcedu.setBounds(550,300,150,30);
        add(jcedu);

        JLabel jbdegi = new JLabel("DESIGNATION");
        jbdegi.setBounds(50,350,100,30);
        add(jbdegi);

        jtdegi = new JTextField();
        jtdegi.setBounds(150,350,150,30);
        add(jtdegi);

        JLabel jbaddhar = new JLabel("ADHAAR NO.");
        jbaddhar.setBounds(450,350,100,30);
        add(jbaddhar);

        jladdhar = new JLabel();
        jladdhar.setBounds(550,350,150,30);
        add(jladdhar);

        JLabel jbempid = new JLabel("Employee ID");
        jbempid.setBounds(50,400,100,30);
        add(jbempid);

       
        jbemid = new JLabel();
        jbemid.setBounds(200,400,100,30);
        add(jbemid);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from emp where eid ='"+id+"'");

            while(rs.next())
            {
                jtname.setText(rs.getString("name"));
                jtfname.setText(rs.getString("fname"));
                jddob.setText(rs.getString("dob"));
                jtsalary.setText(rs.getString("salary"));
                jtadd.setText(rs.getString("address"));
                jtphone.setText(rs.getString("phone"));
                jtemail.setText(rs.getString("email"));
                jcedu.setText(rs.getString("education"));
                jtdegi.setText(rs.getString("desi"));
                jladdhar.setText(rs.getString("adhno"));
                jbemid.setText(rs.getString("eid"));

            }
            
        } catch (Exception e) {
            e.getStackTrace();
        }

        add =new JButton("UPDATE DETAILS");
        add.setBounds(300,450,150,50);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back =new JButton("BACK");
        back.setBounds(500,450,150,50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(1100,650);
        setVisible(true);
        setLocation(100, 30);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
           
            
            String fname = jtfname.getText();
            String salary = jtsalary.getText();
            String add = jtadd.getText();
            String ph = jtphone.getText();
            String email = jtemail.getText();
            String edu = jcedu.getText();
            String desi = jtdegi.getText();

            try {
                
                Conn c = new Conn();
                String query = "update emp set fname='"+fname+"',salary='"+salary+"',address='"+add+"',phone='"+ph+"',email='"+email+"',education='"+edu+"',desi='"+desi+"' where eid='"+id+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details update Successfully");
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
        new Updateemployee("");
    }
    
}

