import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Log extends JFrame implements ActionListener {
    JTextField jtuser,jtpass;
    Log()
    {   
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel jbusername = new JLabel("USERNAME");
        jbusername.setBounds(40,20,100,30);
        add(jbusername);

        jtuser = new JTextField();
        jtuser.setBounds(150,20,150,30);
        add(jtuser);

        JLabel jbpass = new JLabel("PASSWORD");
        jbpass.setBounds(40,70,100,30);
        add(jbpass);

        jtpass = new JTextField();
        jtpass.setBounds(150,70,150,30);
        add(jtpass);

        JButton click =new JButton("LOGIN");
        click.setBounds(150,140,150,30);
        click.setBackground(Color.BLACK);
        click.setForeground(Color.WHITE);
        click.addActionListener(this);
        add(click);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ima = new JLabel(i3);
        ima.setBounds(350,0,200,200);
        add(ima);

        setSize(600,300);
        setVisible(true);
        setLocation(300, 200);
    }
    public void actionPerformed(ActionEvent ae)
    {
        try {
            String username= jtuser.getText();
            String password= jtpass.getText();

            Conn c=new Conn();

            String query="select * from login where Username='"+username+"'and Password='"+password+"'";

            ResultSet rs=c.s.executeQuery(query);

            if(rs.next())
            {
                setVisible(false);
                new Home();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "INVALID Username or Password");
                setVisible(false);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String ags[])
    {
        new Log();
    }
    
}