import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Addemployee extends JFrame implements ActionListener {
    Random rn=new Random();
    int number = rn.nextInt(999999);
    JButton add,back;
    JTextField jtname,jtfname,jtsalary,jtadd,jtphone,jtemail,jtdegi,jtaddhar;
    JDateChooser jddob;
    JComboBox jcedu;
    JLabel jbemid ;
    Addemployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD EMPLOYEE DETAIL");
        heading.setBounds(320,30,500,60);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel jbname = new JLabel("NAME");
        jbname.setBounds(50,150,100,30);
        add(jbname);

        jtname = new JTextField();
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

        jddob = new JDateChooser();
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

        String course[]={"SELECT","BBA","BCA","B.TECH","BA","B.COM","BSC","MBA","MCA","M.TECH","MA","M.COM","MSC"};
        jcedu = new JComboBox(course);
        jcedu.setBackground(Color.WHITE);
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

        jtaddhar = new JTextField();
        jtaddhar.setBounds(550,350,150,30);
        add(jtaddhar);

        JLabel jbempid = new JLabel("Employee ID");
        jbempid.setBounds(50,400,100,30);
        add(jbempid);

       
        jbemid = new JLabel(""+number);
        jbemid.setBounds(200,400,100,30);
        add(jbemid);

        add =new JButton("ADD DETAILS");
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
            String name = jtname.getText();
            String fname = jtfname.getText();
            String dob = ((JTextField)jddob.getDateEditor().getUiComponent()).getText();
            String salary = jtsalary.getText();
            String add = jtadd.getText();
            String ph = jtphone.getText();
            String email = jtemail.getText();
            String edu = (String)jcedu.getSelectedItem();
            String desi = jtdegi.getText();
            String adhno = jtaddhar.getText();
            String empid = jbemid.getText();

            try {
                
                Conn c = new Conn();
                String query = "insert into emp values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+add+"','"+ph+"','"+email+"','"+edu+"','"+desi+"','"+adhno+"','"+empid+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully");
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
        new Addemployee();
    }
    
}
