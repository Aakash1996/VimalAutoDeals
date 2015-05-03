import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.text.*;

public class sentry extends JFrame {
	JLabel l1 = new JLabel("Car Details");
	JLabel l2 = new JLabel("Customer Details");
	
	JLabel l3 = new JLabel("Car No");
	JLabel l30 = new JLabel();

	JLabel l4 = new JLabel("Chassis No.");
	JLabel l40 = new JLabel();
	JLabel l5 = new JLabel("Model");
	JLabel l50 = new JLabel();
	JLabel l6 = new JLabel("Colour");
	JLabel l60 = new JLabel();
	JLabel l7 = new JLabel("Cost");
	JLabel l70 = new JLabel();
	
	JLabel l8 = new JLabel("Name");
	JTextField t8 = new JTextField();
	JLabel l9 = new JLabel("Contact No.");
	JTextField t9 = new JTextField();
	JLabel l11 = new JLabel("Address");
	JTextArea textarea = new JTextArea();
	JLabel l15 = new JLabel("Selling Price");
	JTextField t15 = new JTextField();
	JLabel l10 = new JLabel();
	JLabel l14 = new JLabel();
	
	
	JButton b1 = new JButton("Save Without Finance");
	JButton b4 = new JButton("Save With Finance");
	JButton b2 = new JButton("Calculate Profit");
	JButton b3 = new JButton("Back");
	JPanel p1= new JPanel();
	String s1 = new String();
	String s = new String();
	
	String s4 = null;
	String s5 = null;
	String s6 = null;
	String s7 = null;
	
	
	Statement stm;
	gcon g = new gcon();
	Connection d;
	
	public sentry (String carno, String s2) {
		s=s2;
		p1.setLayout(null);
		
		l10.setText("Welcome "+s2);
		l10.setBounds(1100, 20, 100, 30);	
		l1.setBounds(300,50, 300, 60);
		l1.setFont(new Font("Serif", Font.BOLD, 30));
		
		l3.setBounds(350,50+30,100,60);
		l30.setBounds(500,50+30,100,60);
		l30.setText(carno);
		l4.setBounds(350,50+60, 100, 60);
		l40.setBounds(500,50+60, 100, 60);
		l5.setBounds(350,50+90,100,60);
		l50.setBounds(500,50+90,100,60);
		l6.setBounds(350,50+120, 100, 60);
		l60.setBounds(500,50+120, 100, 60);
		l7.setBounds(350,50+150,100,60);
		l70.setBounds(500,50+150,100,60);
		
		l2.setBounds(300,300, 300, 60);
		l2.setFont(new Font("Serif", Font.BOLD, 30));
		
		l8.setBounds(350,300+30,100,60);
		l9.setBounds(350,300+60,100,60);
		l11.setBounds(350,300+90,100,60);
		l15.setBounds(350,300+230,100,60);
		l14.setBounds(650,350,400,50);
		
		t8.setBounds(500,300+30+20,100,25);
		t9.setBounds(500,300+60+20,100,25);
		textarea.setBounds(500,300+90+20,300,125);
		t15.setBounds(500,300+230+20,100,25);
		
                t15.setText("0");
		
		b3.setBounds(650,500+100,75,25);
		b2.setBounds(650,380,125,25);
		b1.setBounds(300,500+100,150,25);
		b4.setBounds(475,500+100,150,25);
		
		ButtonHandler l = new ButtonHandler();
		b3.addActionListener(l);
		b2.addActionListener(l);
		b1.addActionListener(l);
		b4.addActionListener(l);
		
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l30);
		p1.add(l4);
		p1.add(l40);
		p1.add(l5);
		p1.add(l50);
		p1.add(l6);
		p1.add(l60);
		p1.add(l7);
		p1.add(l70);
		p1.add(l8);
		p1.add(l9);
		p1.add(l10);
		p1.add(l11);
		p1.add(l14);
		p1.add(l15);
		
		p1.add(t8);
		p1.add(t9);
		p1.add(textarea);
		p1.add(t15);
		
		p1.add(b3);
		p1.add(b2);
		p1.add(b1);
		
		s1 = carno;
		
		
		ResultSet rs = null;
		d = g.getDBConnection();
		try {
			stm = d.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs = stm.executeQuery("SELECT * FROM stock where car_no ='"+s1+"'");
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		try {
				rs.next();
				s4 = rs.getString ("chassis_no");
				l40.setText(s4);
				s5 = rs.getString ("model");
				l50.setText(s5);
				s6 = rs.getString ("colour");
				l60.setText(s6);
				s7 = rs.getString ("total_cost");
				l70.setText(s7);
		}
			catch (SQLException se) {
				se.printStackTrace();
			}
		
		getContentPane().add(p1);	
		
	}
	
	private class ButtonHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == b1) {
				String s8 = t8.getText();
				String s9 = t9.getText();
				String s10 = textarea.getText();
				
				d = g.getDBConnection();
				try{
					DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
					Calendar cal = Calendar.getInstance();
					String dat = df.format(cal.getTime());
					String total_cost = Integer.toString(Integer.parseInt(s8)+Integer.parseInt(s9));
					String sql = new String("insert into carsold values('"+s1+"','"+dat+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"',"+s8+","+s9+","+total_cost+")");
					System.out.println(sql);
					stm = d.createStatement();
					stm.executeUpdate(sql);
					String sql1 = new String("insert into customers values('"+s1+"','"+dat+"','"+s8+"','"+s9+"','"+s10+")");
					stm.executeUpdate(sql1);
					d.close();
					doit dit = new doit(s1);
					Toolkit tk = Toolkit.getDefaultToolkit();
					dit.setSize((int)tk.getScreenSize().getWidth(), (int)tk.getScreenSize().getHeight());
					dit.setVisible(true);
					setVisible(false);
				}catch(SQLException error){
					JOptionPane.showMessageDialog(null,"Refill all fields and try again");
					error.printStackTrace();
				}
			}
			
			if (e.getSource() == b4) {
				AddFinanceSearch pw = new AddFinanceSearch(s); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				Toolkit tk=Toolkit.getDefaultToolkit();
				pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				pw.setVisible(true);
				setVisible(false);
			}
			
			if (e.getSource() == b2) {
				Double p1 = Double.parseDouble(s7);
				Double p2 = Double.parseDouble(t15.getText());
				l14.setText("The Total Profit is "+Double.toString(p1-p2));
			}
			
			if (e.getSource() == b3) {
				doit dit = new doit(s);
				Toolkit tk = Toolkit.getDefaultToolkit();
				dit.setSize((int)tk.getScreenSize().getWidth(), (int)tk.getScreenSize().getHeight());
				dit.setVisible(true);
				setVisible(false);
			}
			
		}
	}
	
	
}
