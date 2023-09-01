import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    JButton add,view,update,remove;
    Home(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ima = new JLabel(i3);
        ima.setBounds(0,0,1100,650);
        add(ima);

        JLabel heading = new JLabel("EMPLOYEE MANAGMENT SYSTEM");
        heading.setBounds(650,20,400,40);
        heading.setFont(new Font("serif",Font.BOLD,20));
        ima.add(heading);

        add =new JButton("ADD employee");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        ima.add(add);

        view =new JButton("VIEW employee");
        view.setBounds(850,80,150,40);
        view.addActionListener(this);
        ima.add(view);

        update=new JButton("UPDATE employee");
        update.setBounds(650,150,150,40);
        update.addActionListener(this);
        ima.add(update);

        remove =new JButton("REMOVE employee");
        remove.setBounds(850,150,150,40);
        remove.addActionListener(this);
        ima.add(remove);

        setSize(1100,650);
        setVisible(true);
        setLocation(100, 30);
        
   
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {   
            setVisible(false);
            new Addemployee();

        }
        else if(ae.getSource()==view)
        {
            setVisible(false);
            new Viewemployee();

        }
        else if(ae.getSource()==update)
        {
            setVisible(false);
            new Viewemployee();

        }
        else
        {
            setVisible(false);
            new Removeemployee();

        }

    }
    public static void main(String ags[])
    {
        new Home();
    }
}
