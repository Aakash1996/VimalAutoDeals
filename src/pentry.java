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

public class pentry extends JFrame{
	JLabel l1 = new JLabel("Car Details");
	JLabel l2 = new JLabel("Seller Details");
	JLabel l3 = new JLabel("Car No.");
	JTextField t3 = new JTextField();
	JLabel l4 = new JLabel("Chassis No.");
	JTextField t4 = new JTextField();
	JLabel l5 = new JLabel("Model");
	JTextField t5 = new JTextField();
	JLabel l6 = new JLabel("Colour");
	JTextField t6 = new JTextField();
	JLabel l7 = new JLabel("Cost Price");
	JTextField t7 = new JTextField();
	JLabel l8 = new JLabel("Name");
	JTextField t8 = new JTextField();
	JLabel l9 = new JLabel("Contact No.");
	JTextField t9 = new JTextField();
	JLabel l10 = new JLabel();
	
	JLabel l11 = new JLabel("Odometer reading");
	JLabel l12 = new JLabel("Estd. reapirs cost");
	JLabel l13 = new JLabel("Engine Number");
	JLabel l14 = new JLabel();
	
	JTextField t10 = new JTextField();
	JTextField t11 = new JTextField();
	JTextField t12 = new JTextField();
	
	JButton b1 = new JButton("Save");
	JButton b2 = new JButton("Back");
	JButton b3 = new JButton("Calculate total cost");
	JButton b4 = new JButton("Print");
	
	JPanel p1 = new JPanel();
	String s1 = new String();
	
	Statement stm;
	gcon g = new gcon();
	Connection d;
	
	public pentry(String s2) {
	super("Purchase Menu");
	s1=s2;
	p1.setLayout(null);
	l10.setText("Welcome "+s2);
	l10.setBounds(1100, 20, 100, 30);	
	l1.setBounds(300,50, 300, 60);
	l1.setFont(new Font("Serif", Font.BOLD, 30));
	l3.setBounds(350,50+30,100,60);
	l4.setBounds(350,50+60, 100, 60);
	l13.setBounds(350,50+90,100,60);
	l5.setBounds(350,50+120,100,60);
	l6.setBounds(350,50+150, 100, 60);
	l7.setBounds(350,50+180,100,60);
	l12.setBounds(350,50+210,100,65);
	l11.setBounds(350,50+240,110,60);
	l2.setBounds(300,50+300, 300, 60);
	l2.setFont(new Font("Serif", Font.BOLD, 30));
	l8.setBounds(350,350+30,100,60);
	l9.setBounds(350,350+60, 100, 60);
	l14.setBounds(620,50+210,200,60);
	
	t3.setBounds(500,50+30+20,100,25);
	t4.setBounds(500,50+60+20,100,25);
	t5.setBounds(500,50+90+20,100,25);
	t6.setBounds(500,50+120+20,100,25);
	t7.setBounds(500,50+150+20,100,25);
	t8.setBounds(500,50+180+20,100,25);
	t9.setBounds(500,50+210+20,100,25);
	t10.setBounds(500,50+240+20,100,25);
	t11.setBounds(500,350+30+20,100,25);
	t12.setBounds(500,350+60+20,100,25);
        
	b1.setBounds(450,500,100,30);
	b2.setBounds(650,500,100,30);
	b3.setBounds(620,50+200,300,25);
	b4.setBounds(850,500,100,30);
	
	ButtonHandler l=new ButtonHandler();
	b1.addActionListener(l);
	b2.addActionListener(l);
	b3.addActionListener(l);
	b4.addActionListener(l);
	p1.add(l1);
	p1.add(b1);
	p1.add(l2);
	p1.add(l3);
	p1.add(l4);
	p1.add(l5);
	p1.add(l6);
	p1.add(l7);
	p1.add(l8);
	p1.add(l9);
	p1.add(l10);
	p1.add(l11);
	p1.add(l12);
	p1.add(l13);
	p1.add(l14);
	
	p1.add(t3);
	p1.add(t4);
	p1.add(t5);
	p1.add(t6);
	p1.add(t7);
	p1.add(t8);
	p1.add(t9);
	p1.add(t10);
	p1.add(t11);
	p1.add(t12);

	p1.add(b1);
	p1.add(b2);
	p1.add(b3);
	p1.add(b4);

	getContentPane().add(p1);
	}
	
private class ButtonHandler implements ActionListener
{

	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1)
	{
		String s3 = t3.getText();
		String s4 = t4.getText();
		String s5 = t5.getText();
		String s6 = t6.getText();
		String s7 = t7.getText();
		String s8 = t8.getText();
		String s9 = t9.getText();
		String s10 = t10.getText();
		String s11 = t11.getText();
		String s12 = t12.getText();
                
                if(s8.equals(""))
                    s8="0";
                
                if(s9.equals(""));
                    s9="0";
                    
                if(s10.equals(""))
                    s10="0";
		
		d = g.getDBConnection();
		try{
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
			Calendar cal = Calendar.getInstance();
			String dat = df.format(cal.getTime());
			String total_cost = Integer.toString(Integer.parseInt(s8)+Integer.parseInt(s9));
			String sql = new String("insert into carpurchased values('"+s3+"','"+dat+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"',"+s8+","+s9+","+total_cost+","+s10+")");
			System.out.println(sql);
			stm = d.createStatement();
			stm.executeUpdate(sql);
			String sql1 = new String("insert into seller values('"+s3+"','"+dat+"','"+s11+"',"+s12+")");
			stm.executeUpdate(sql1);
			String sql2 = new String("insert into stock values('"+s3+"',"+total_cost+",'"+s6+"','"+s4+"','"+s5+"','"+s7+"')");
			stm.executeUpdate(sql2);
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
	
	if(e.getSource()==b2){
		doit dit = new doit(s1);
		Toolkit tk = Toolkit.getDefaultToolkit();
		dit.setSize((int)tk.getScreenSize().getWidth(), (int)tk.getScreenSize().getHeight());
		dit.setVisible(true);
		setVisible(false);
	}
	
	if(e.getSource()==b3){
		double p1 = Double.parseDouble(t8.getText());
		double p2 = Double.parseDouble(t9.getText());
		l14.setText("The total cost is "+Double.toString(p1+p2));
	}
	
	if(e.getSource()==b4)
	{
		// TODO
	}
	}
	
}
}
