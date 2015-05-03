import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.text.*;

class pentry2 extends JFrame {
    JLabel welcome = new JLabel();
    JLabel l1 = new JLabel("Customer Details");
    JLabel l2 = new JLabel("Name");
    JLabel l4 = new JLabel("Address");
    JLabel l3 = new JLabel("Contact Number");
    
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    
    JButton b1 = new JButton("Proceed");
    JButton b2 = new JButton("Back");
    
    Statement stm;
    gcon g = new gcon();
    Connection d;
    
    JPanel p1 = new JPanel();
    
    pentry2(String s1,String s2)
    {
        super("Customer Details");
        p1.setLayout(null);
        welcome.setBounds(620,50+410,200,60);
        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l1.setBounds(300,50,300,60);
        l2.setBounds(300,50+30,300,60);
        l3.setBounds(300,50+60,300,60);
        l4.setBounds(300,50+90,300,60);
        
        t1.setBounds(500,50+20,100,25);
        t2.setBounds(500,50+20+30,100,25);
        t3.setBounds(500,50+20+60,400,225);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        
        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        
        getContentPane().add(p1);
    }
}
