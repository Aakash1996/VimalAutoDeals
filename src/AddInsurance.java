import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

class AddInsurance extends JFrame{
    JLabel welcome = new JLabel();
    JLabel carno = new JLabel();
    JLabel l1 = new JLabel("Company");
    JLabel l2 = new JLabel("Agent");
    JLabel l3 = new JLabel("Starting Date");
    JLabel l4 = new JLabel("Expiary Date");
    JLabel l5 = new JLabel("Premium");
    JLabel l6 = new JLabel("Cover amount");
    JLabel l7 = new JLabel("Be careful as you can't change these later");
    
    JComboBox cb1;
    JComboBox cb2;
    
    JButton b1 = new JButton("New Company");
    JButton b2 = new JButton("New Agent");
    JButton b3 = new JButton("Save");
    JButton b4 = new JButton("Back");
    
    JXDatePicker tf1 = new JXDatePicker();
    JXDatePicker tf2 = new JXDatePicker();
    
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    
    gcon k=new gcon();
    Connection d;
    Statement stm;
    ResultSet rs;
    String sql,s2,carno1;
    JPanel p1;
    public AddInsurance(String car, String name) {
        super("Insurance");
        s2 = name;
        carno1 = car;
        ButtonHandler l=new ButtonHandler();
        welcome.setText(name);
        welcome.setBounds(1100, 20, 100, 30);
        
        carno.setText("Add insurance for vehicle number "+car);
        carno.setFont(new Font("Serif", Font.BOLD, 30));
        carno.setBounds(450, 70, 600, 40);
        
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
        sql = "select * from company";
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        try {
            rs = stm.executeQuery(sql);
            while(rs.next())
                model1.addElement(rs.getString("name"));
        } catch (SQLException ex) {
            Logger.getLogger(AddInsurance.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql = "select * from agent";
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
        l3.setBounds(400, 230, 150, 30);
        l4.setBounds(400, 280, 150, 30);
        l5.setBounds(400,330,150,30);
        l6.setBounds(400,380,150,30);
        l7.setBounds(400,440,300,30);
        
        cb1.setBounds(580, 130, 150, 30);
        cb2.setBounds(580, 180, 150, 30);
        
        b1.setBounds(760, 130, 150, 30);
        b2.setBounds(760, 180, 150, 30);
        b3.setBounds(400,500,100,30);
        b4.setBounds(520,500,100,30);
        b1.addActionListener(l);
        b2.addActionListener(l);
        b3.addActionListener(l);
        b4.addActionListener(l);
        
        tf1.setBounds(580, 230, 150, 30);
        tf2.setBounds(580, 280, 150, 30);
        
        t1.setBounds(580,330,150,30);
        t2.setBounds(580,380,150,30);
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.add(carno);
        p1.add(welcome);
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(cb1);
        p1.add(cb2);
        p1.add(tf1);
        p1.add(tf2);
        p1.add(t1);
        p1.add(t2);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        getContentPane().add(p1);
    }

    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == b1)
            {
                addCompany pw = new addCompany(s2); // create ButtonFrame
		pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		pw.setSize(400,400); // set frame size
		pw.setVisible(true);
		setVisible(false);
            }
            
            else if(ae.getSource() == b2)
            {
                addAgent pw = new addAgent(s2); // create ButtonFrame
		pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		pw.setSize(400,400); // set frame size
		pw.setVisible(true);
		setVisible(false);
            }
            
            else if(ae.getSource() == b3)
            {
                d = k.getDBConnection();
                boolean flag = false;
                try {
                    stm = d.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(AddInsurance.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String sql;
                String s1,s2;
                try{
                    s1 = cb1.getSelectedItem().toString();
                }catch(Exception e){
                    s1 = null;
                }
                
                try{
                    s2 = cb2.getSelectedItem().toString();
                }catch(Exception e){
                    s2 = null;
                }
                
                sql = "delete from insurance where car_no='"+carno1+"'";
                
                try {
                    stm.executeUpdate(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(AddInsurance.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                sql = "insert into insurance values('"+carno1+"','"+cb1.getSelectedItem().toString()+"','"+cb2.getSelectedItem().toString()+"',"+tf1.getDate()+","+tf2.getDate()+","+t1.getText()+","+t2.getText()+")";
                try {
                    stm.executeUpdate(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(AddInsurance.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                sql = "update table carpurchased set repair_misc=repair_misc+"+t1.getText()+" where car_no="+carno1;
                try {
                    stm.executeUpdate(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(AddInsurance.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                doit pw = new doit(s2); // create ButtonFrame
		pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Toolkit tk=Toolkit.getDefaultToolkit();
		pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		pw.setVisible(true);
		setVisible(false);   
            }
            
            else if(ae.getSource() == b4)
            {
                doit pw = new doit(s2); // create ButtonFrame
		pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Toolkit tk=Toolkit.getDefaultToolkit();
		pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		pw.setVisible(true);
		setVisible(false);    
            }
        }
    }
}
