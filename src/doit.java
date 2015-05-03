import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class doit extends JFrame{

	JPanel p1 = new JPanel();
	JButton b1 = new JButton("Purchase");
	JButton b2 = new JButton("Sale");
        JButton b3 = new JButton("Vstock");
        JButton b4 = new JButton("View Sales");
        JButton b5 = new JButton("Add Insurance");
        JButton b6 = new JButton("Finance a vehicle");
	JButton b7 = new JButton("Logout");
        JLabel l1 = new JLabel();
	String s2 = new String();
	public doit(String s1) {
		super("Main Menu");
		ButtonHandler l=new ButtonHandler();
		s2=s1;
		p1.setLayout(null);
		l1=new JLabel("Welcome "+s1);
		l1.setBounds(1100, 20, 100, 30);
		b1.setBounds(500, 70, 300, 40);
		b2.setBounds(500, 130, 300, 40);
                b3.setBounds(500, 190, 300, 40);
                b4.setBounds(500, 250, 300, 40);
                b5.setBounds(500, 310, 300, 40);
                b6.setBounds(500, 370, 300, 40);
                b7.setBounds(200, 530, 100, 40);
		b1.addActionListener(l);
		b2.addActionListener(l);
                b3.addActionListener(l);
                b4.addActionListener(l);
                b5.addActionListener(l);
                b6.addActionListener(l);
		b7.addActionListener(l);
                p1.add(b1);
		p1.add(b2);
                p1.add(b3);
                p1.add(b4);
                p1.add(b5);
                p1.add(b6);
                p1.add(b7);
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
			if(e.getSource()==b2)
			{
				carsearch pw = new carsearch(s2); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				Toolkit tk=Toolkit.getDefaultToolkit();
				pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				pw.setVisible(true);
				setVisible(false);
			}
			if(e.getSource()==b3)
			{
				 VStock pw = new VStock(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
				 setVisible(false);
			}
			if(e.getSource()==b4)
			{
				 vsales pw = new vsales(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
				 setVisible(false);
				
			}
			if(e.getSource()==b5)
			{
				AddInsuranceSearch pw = new AddInsuranceSearch(s2); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				Toolkit tk=Toolkit.getDefaultToolkit();
				pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				pw.setVisible(true);
				setVisible(false);
			}
			if(e.getSource()==b6)
			{
				AddFinanceSearch pw = new AddFinanceSearch(s2);
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				Toolkit tk=Toolkit.getDefaultToolkit();
				pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				pw.setVisible(true);
				setVisible(false);
			}
				
				
				 
			
			if(e.getSource()==b7)
			{
				mainp pw = new mainp(); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				Toolkit tk=Toolkit.getDefaultToolkit();
				pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				pw.setVisible(true);
				setVisible(false);
				
			}
			/*if(e.getSource()==b8)
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
