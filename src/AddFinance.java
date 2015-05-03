import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

class AddFinance extends JFrame{
    JLabel welcome = new JLabel();
    JLabel carno = new JLabel();
    JLabel l1 = new JLabel("Finance Company");
    JLabel l2 = new JLabel("Finance Agent");
    JLabel l3 = new JLabel("Starting Date");
    JLabel l4 = new JLabel("Expiary Date");
    JComboBox cb1;
    JComboBox cb2;
    JButton b1 = new JButton("New Company");
    JButton b2 = new JButton("New Agent");
    
    JXDatePicker tf1 = new JXDatePicker();
    JXDatePicker tf2 = new JXDatePicker();
    
    gcon k=new gcon();
    Connection d;
    Statement stm;
    ResultSet rs;
    String sql,s2;
    JPanel p1;
    public AddFinance(String car, String name) {
        super("Finance");
        
        s2 = name;
        ButtonHandler l=new ButtonHandler();
        welcome.setText(name);
        welcome.setBounds(1100, 20, 100, 30);
        
        carno.setText("Add insurance for car number "+car);
        carno.setBounds(500, 90, 150, 30);
        
        tf1.setDate(Calendar.getInstance().getTime());
	tf1.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
        
        tf2.setDate(Calendar.getInstance().getTime());
	tf2.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
        
        d = k.getDBConnection();
        try {
            stm = d.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AddInsurance.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "select * from finance_company";
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        try {
            rs = stm.executeQuery(sql);
            while(rs.next())
                model1.addElement(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(AddInsurance.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "select * from finance_agent";
        DefaultComboBoxModel model2 = new DefaultComboBoxModel();
        try {
            rs = stm.executeQuery(sql);
            while(rs.next())
                model2.addElement(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(AddInsurance.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            d.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddInsurance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cb1 = new JComboBox(model1);
        cb2 = new JComboBox(model2);
        
        l1.setBounds(400, 130, 150, 30);
        l2.setBounds(400, 180, 150, 30);
        
        cb1.setBounds(580, 130, 150, 30);
        cb2.setBounds(580, 180, 150, 30);
        
        b1.setBounds(760, 130, 150, 30);
        b2.setBounds(760, 180, 150, 30);
        b1.addActionListener(l);
        b2.addActionListener(l);
        
        tf1.setBounds(580, 230, 150, 30);
        tf2.setBounds(580, 380, 250, 30);
        
        l3.setBounds(400, 230, 150, 30);
        l4.setBounds(400, 380, 150, 30);
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.add(carno);
        p1.add(welcome);
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(cb1);
        p1.add(cb2);
        p1.add(tf1);
        p1.add(tf2);
        p1.add(b1);
        p1.add(b2);
        
        getContentPane().add(p1);
    }

    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == b1)
            {
                AddFinanceCompany pw = new AddFinanceCompany(s2); // create ButtonFrame
		pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Toolkit tk=Toolkit.getDefaultToolkit();
		pw.setSize(400,400); // set frame size
		pw.setVisible(true);
		setVisible(false);
            }
            if(ae.getSource() == b2)
            {
                AddFinanceAgent pw = new AddFinanceAgent(s2); // create ButtonFrame
		pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Toolkit tk=Toolkit.getDefaultToolkit();
		pw.setSize(400,400); // set frame size
		pw.setVisible(true);
		setVisible(false);
            }
        }
    }
    
}

