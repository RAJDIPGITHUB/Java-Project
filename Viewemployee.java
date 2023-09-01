import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Viewemployee extends JFrame implements ActionListener{

    JTable table;
    Choice jcemp;
    JButton search,print,update,back;
    Viewemployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        table = new JTable();

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from emp");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.getStackTrace();
        }

        JLabel heading = new JLabel("EMPLOYEE DETAIL");
        heading.setBounds(200,0,300,40);
        heading.setFont(new Font("serif",Font.PLAIN,30));
        add(heading);

        JLabel jbs = new JLabel("SEARCH EMPLOYEE(EMPID)");
        jbs.setBounds(0,60,200,40);
        jbs.setFont(new Font("serif",Font.PLAIN,15));
        add(jbs);

        jcemp = new Choice();
        jcemp.setBackground(Color.WHITE);
        jcemp.setBounds(300,60,150,30);
        add(jcemp);

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from emp");

            while(rs.next())
            {
                jcemp.add(rs.getString("eid"));
            }
            
        } catch (Exception e) {
            e.getStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,150,900,750);
        add(jsp);

        search =new JButton("SEARCH");
        search.setBounds(20,120,100,20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        print =new JButton("PRINT");
        print.setBounds(140,120,100,20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        update =new JButton("UPDATE");
        update.setBounds(260,120,100,20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back =new JButton("BACK");
        back.setBounds(380,120,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1000,750);
        setVisible(true);
        setLocation(100, 30);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== search)
        {
            String query= "select * from emp where eid = '"+jcemp.getSelectedItem()+"'";
            try {
                
                Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.getStackTrace();
            }

        }
        else if(ae.getSource()== print)
        {
            try {

                table.print();
                
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        else if(ae.getSource()== update)
        {
            setVisible(false);
            new Updateemployee(jcemp.getSelectedItem());

        }
        else
        {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String ags[])
    {
        new Viewemployee();
    }
    
}
