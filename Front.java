import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Front extends JFrame implements ActionListener
{
    Front()
    {   
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGMENT SYSTEM");
        heading.setBounds(80,30,1200,60);
        heading.setFont(new Font("serif",Font.BOLD,60));
        heading.setForeground(Color.RED);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel ima = new JLabel(i3);
        ima.setBounds(50,100,1050,500);
        add(ima);

        JButton click =new JButton("CLICK HERE TO CONTINUE");
        click.setBounds(400,400,300,50);
        click.setBackground(Color.BLACK);
        click.setForeground(Color.WHITE);
        click.addActionListener(this);
        ima.add(click);

        setSize(1170,650);
        setVisible(true);
        setLocation(100, 30);

        while(true)
        {
            heading.setVisible(false);

            try {
                Thread.sleep(300);
            } catch (Exception e) {
                
            }

            heading.setVisible(true);
            try {
                Thread.sleep(700);
            } catch (Exception e) {
                
            }
        }
    }
        public void actionPerformed(ActionEvent ae)
        {
            setVisible(false);
            new Log();
        }
    
    public static void main(String ags[])
    {
        new Front();
    }
}