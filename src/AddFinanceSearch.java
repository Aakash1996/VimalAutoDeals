import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

import org.jdesktop.swingx.JXDatePicker;

public class AddFinanceSearch extends JFrame{
	JLabel welcome = new JLabel();
	JComboBox cb1;
        JPanel p1;
        JButton b1 = new JButton("Continue");
        JButton b2 = new JButton("Back");
        
        String name;
        Statement stm;
        gcon g = new gcon();
        Connection d;
        ResultSet rs;
	public AddFinanceSearch(String s1)
	{
            super("Vimal Auto Deals");
            
            DefaultComboBoxModel model1 = new DefaultComboBoxModel();
            d = g.getDBConnection();
            String sql = "select car_no from stock";
            try {
                stm = d.createStatement();
                rs = stm.executeQuery(sql);
                while(rs.next())
                    model1.addElement(rs.getString("car_no"));
                cb1 = new JComboBox(model1);
                d.close();
            } catch (SQLException ex) {
                Logger.getLogger(VStock.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ButtonHandler l = new ButtonHandler();
            p1 = new JPanel();
            welcome.setBounds(1100, 20, 100, 30);
            p1.setLayout(null);
            b1.setBounds(500, 130, 150, 30);
            b1.addActionListener(l);
            b2.setBounds(680, 130, 150, 30);
            b2.addActionListener(l);
            welcome.setText(s1);
            name = s1;
         
            cb1.setEditable(true);
            cb1.setBounds(500,70,300,40);
            p1.add(welcome);
            p1.add(b1);
            p1.add(b2);
            p1.add(cb1);
            getContentPane().add(p1);
	}
       
    private class ButtonHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
                {
                    if(e.getSource()==b1)
                    {   AddFinance pw = new AddFinance(String.valueOf(cb1.getSelectedItem()),name); // create ButtonFrame
                        pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                        Toolkit tk=Toolkit.getDefaultToolkit();
                        pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
                        pw.setVisible(true);
                        setVisible(false);
                    }
                    
                    else if(e.getSource()==b2)
                    {
                        doit pw = new doit(name); // create ButtonFrame
                        pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                        Toolkit tk=Toolkit.getDefaultToolkit();
                        pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
                        pw.setVisible(true);
                        setVisible(false);
                    }
                }
        
    }
}
