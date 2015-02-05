import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pentry extends JFrame{
	JButton b1=new JButton("Frame");
	JButton b2=new JButton("Lens");
	JButton b3=new JButton("SunGlasses");
	JButton b6=new JButton("Contact Lens");
	JButton b7=new JButton("Lens Solution");
	JButton b4=new JButton("View Purchase");
	JButton b5=new JButton("Back");
	JLabel l1=new JLabel();
	JPanel p1=new JPanel();
	String s1; 
	public pentry(String s2) {
		// TODO Auto-generated constructor stub
	s1=s2;
	p1.setLayout(null);
	l1.setText("Welcome "+s2);
	l1.setBounds(1100, 20, 100, 30);
	b1.setBounds(500, 60, 300, 40);
	b2.setBounds(500, 120, 300, 40);
	b3.setBounds(500, 180, 300, 40);
	b6.setBounds(500, 240, 300, 40);
	b7.setBounds(500, 300, 300, 40);
	b4.setBounds(500, 360, 300, 40);
	b5.setBounds(100, 20, 100, 30);
	ButtonHandler l=new ButtonHandler();
	b1.addActionListener(l);
	b2.addActionListener(l);
	b3.addActionListener(l);
	b4.addActionListener(l);
	b5.addActionListener(l);
	b6.addActionListener(l);
	b7.addActionListener(l);
	p1.add(l1);
	p1.add(b1);
	p1.add(b2);
	p1.add(b3);
	p1.add(b4);
	p1.add(b5);
	p1.add(b6);
	p1.add(b7);
	getContentPane().add(p1);
	}
private class ButtonHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource()==b1||e.getSource()==b2||e.getSource()==b3||e.getSource()==b6||e.getSource()==b7)
	{
		String op = null;
		if(e.getSource()==b1)
		{
			op="frame"; 
		
		}
		if(e.getSource()==b2)
		{
			op="lens"; 
			
		}
		if(e.getSource()==b3)
		{
			op="sunglasses"; 
		}
		if(e.getSource()==b6)
		{
			op="contact lens"; 
		}
		if(e.getSource()==b7)
		{
			op="solution"; 
		}
		 pframe pw = new pframe(s1,op); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);
	}
		if(e.getSource()==b4)
		{
			 vpur pw = new vpur(s1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			setVisible(false);
		}
		if(e.getSource()==b5)
		{
			doit pw = new doit(s1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			 setVisible(false);
		}
		
	}
	
}
}
