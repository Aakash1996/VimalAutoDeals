import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class doit extends JFrame{

	JPanel p1 = new JPanel();
	JButton b1 = new JButton("Purchase");
	JButton b2 = new JButton("Sale");
	JLabel l1 = new JLabel();
	String s2 = new String();
	public doit(String s1) {
		// TODO Auto-generated constructor stub
		ButtonHandler l=new ButtonHandler();
		s2=s1;
		p1.setLayout(null);
		l1=new JLabel("Welcome "+s1);
		l1.setBounds(1100, 20, 100, 30);
		b1.setBounds(500, 70, 300, 40);
		b2.setBounds(500, 130, 300, 40);
		b1.addActionListener(l);
		b2.addActionListener(l);
		p1.add(b1);
		p1.add(b2);
		p1.add(l1);
		getContentPane().add(p1);
	}
	private class ButtonHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1)
			{
				 pentry pw = new pentry(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
			/*if(e.getSource()==b2)
			{
				 sentry pw = new sentry(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				 setVisible(false);
			}
			if(e.getSource()==b3)
			{
				 workeropt pw = new workeropt(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
				setVisible(false);
			}
			if(e.getSource()==b4)
			{
				 ml pw = new ml(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
				setVisible(false);
				
			}
			if(e.getSource()==b5)
			{
				 mainp pw = new mainp(); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
				setVisible(false);
			}
			if(e.getSource()==b6)
			{
				
				Statement stm=null;
				gcon k=new gcon();
				Connection d=k.getDBConnection();
				try
				{
					d.setAutoCommit(false);
					String sql="savepoint beforebill";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					//System.out.println("Savepoint is to be created");
					Date d1=null; 
					billing pw = new billing(s2,d1, "null", "null", 0, 0, 0, 0, 0, "null","null", "null","null", "null","null","null","null","null","null",d); // create ButtonFrame
					 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					 Toolkit tk=Toolkit.getDefaultToolkit();
					 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
					 pw.setVisible(true);
					 setVisible(false);
				}
				catch(SQLException fe)
				{
					JOptionPane.showMessageDialog(null, "Savepoint not created");
					//System.out.println("Savepoint not created");
				}
				
				 
			}
			if(e.getSource()==b7)
			{
				 pdet pw = new pdet(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
				setVisible(false);
				
			}
			if(e.getSource()==b8)
			{
				 vbe pw = new vbe(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
				setVisible(false);
				
			}*/
		}
		
	}
	
}
