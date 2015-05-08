import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddFinanceAgent extends JFrame{
	
	JLabel l1=new JLabel("Name");
	JLabel l2=new JLabel();
        JLabel l3 = new JLabel("Contact No.");
	JTextField t1=new JTextField();
        JTextField t3 = new JTextField();
	JButton b1=new JButton("Ok");
	JButton b2=new JButton("Back");
	JPanel p1=new JPanel();
	String s1=null;
	Statement stm=null;
	gcon ka= new gcon();
	Connection d=ka.getDBConnection();
	public AddFinanceAgent(String s2) 
        {
            ButtonHandler l=new ButtonHandler();
            p1.setLayout(null);
            l2.setText(s2);
            s1=s2;
            l2.setBounds(250, 10, 100, 30);
            l1.setBounds(20, 50, 100, 30);
            t1.setBounds(140, 50, 100, 30);
            l3.setBounds(20, 100, 100, 30);
            t3.setBounds(140, 100, 100, 30);
            b1.setBounds(10, 200, 60, 30);
            b2.setBounds(100, 200, 100, 30);
            b1.addActionListener(l);
            b2.addActionListener(l);
            p1.add(b1);p1.add(b2);
            p1.add(l1);
            p1.add(l2);
            p1.add(t1);
            p1.add(l3);
            p1.add(t3);
            getContentPane().add(p1);
	}
	private class ButtonHandler implements ActionListener
	{

	String s,s1;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1){
			s = t1.getText();
                        s1 = t3.getText();
			try
			{
				stm=d.createStatement();
				String sql="insert into finance_agent values('"+s+"',"+s1+")";
				stm.executeUpdate(sql);
				d.close();
				doit pw = new doit(s1); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				Toolkit tk=Toolkit.getDefaultToolkit();
				pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				pw.setVisible(true);
				setVisible(false);
			}
			catch(SQLException fe)
			{
				JOptionPane.showMessageDialog(null,"Fill All Fields and Try Again");
				//e.printStackTrace();
			}
		}
			if(e.getSource()==b2)
			{
				try {
					d.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
