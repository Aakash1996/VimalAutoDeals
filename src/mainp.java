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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class mainp extends JFrame{
	JButton b1=new JButton("Log In");
	JLabel l1=new JLabel("VIMAL AUTO DEALS");
	JLabel l4=new JLabel();
	private JLabel l2=new JLabel("Username");
	private JLabel l3=new JLabel("Password");
	private JTextField tf1=new JTextField();
	private JPasswordField tf2=new JPasswordField();
	gcon k=new gcon();
	Connection d=k.getDBConnection();
	
	Statement stm=null;
	JPanel p1;
	
	public mainp(){
		super("Vimal Auto Deals");
		p1=new JPanel();
		p1.setLayout(null);
		l1.setFont(new Font("Serif", Font.ITALIC, 50));
		l1.setAlignmentX(CENTER_ALIGNMENT);
		System.out.println(this.getWidth());
		l1.setBounds(400,300 , 600, 75);
		//l1.setAlignmentX(CENTER_ALIGNMENT);
		l2.setBounds(900, 40, 120, 40);
		tf1.setBounds(1100, 40, 120, 40);
		l3.setBounds(900, 110, 120, 40);
		tf2.setBounds(1100, 110, 120, 40);
		b1.setBounds(1000, 170, 100, 40);
		l4.setBounds(900, 230, 300, 40);
		l4.setAlignmentX(CENTER_ALIGNMENT);
		l4.setVisible(false);
		p1.add(b1);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(tf1);
		p1.add(tf2);
		getContentPane().add(p1);
		ButtonHandler l=new ButtonHandler();
		b1.addActionListener(l);
	}
	
	private class ButtonHandler implements ActionListener
	{

		
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("there1    ");
			String s1=tf1.getText();
			String s2=String.valueOf(tf2.getPassword());
			String sql="Select * from LOGIN";
			try {
				System.out.println("there2    ");
				stm = d.createStatement();
				System.out.println("there3    ");
				ResultSet rs = stm.executeQuery(sql);
				System.out.println("there4    ");
				int i=0;
				while (rs.next())
				{
					System.out.println("there5    ");
					String us = rs.getString("username");
					String pa = rs.getString("pwd");
					if(s1.equals(us)&&s2.equals(pa))
					{
						i=1;
						break;
					}
				}
				System.out.println("there6    ");
			if(i==1)
				{
					d.close(); 
					doit pw = new doit(s1); // create ButtonFrame
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				else
				{
					l4.setText("Username or Password is Incorrect");
					l4.setVisible(true);
				}
			} 
			catch (SQLException ef) {
				// TODO Auto-generated catch block
				
				System.out.println("lelllo erroresss    ");
				ef.printStackTrace();
				
			
		
			}
		}
	}
}
