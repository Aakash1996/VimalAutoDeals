import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

class pentry2 extends JFrame {
    JLabel welcome = new JLabel();
    JLabel l1 = new JLabel("Customer Details");
    JLabel l2 = new JLabel("Name");
    JLabel l4 = new JLabel("Address");
    JLabel l3 = new JLabel("Contact Number");
    
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextArea t3 = new JTextArea();
    
    JCheckBox cb1 = new JCheckBox("Same details for registerd owner",true);
       
    JButton b1 = new JButton("Proceed");
    JButton b2 = new JButton("Back");
    
    ButtonHandler l = new ButtonHandler();
   
    Statement stm;
    gcon g = new gcon();
    Connection d;
    
    JPanel p1 = new JPanel();
    String carno;
    
    pentry2(String s1,String s2)
    {
        super("Customer Details");
        p1.setLayout(null);
        carno=s2;
        welcome.setText(s1);
        welcome.setBounds(620,50+410,200,60);
        
        l1.setFont(new Font("Serif", Font.BOLD, 30));
        l1.setBounds(300,50,300,60);
        l2.setBounds(300,50+30,300,60);
        l3.setBounds(300,50+60,300,60);
        l4.setBounds(300,50+90,300,60);
        
        t1.setBounds(500,50+50,100,25);
        t2.setBounds(500,50+50+30,100,25);
        t3.setBounds(500,50+50+60,300,125);
        
        b1.addActionListener(l);
        b2.addActionListener(l);
        
        b1.setBounds(350,400,100,25);
        b2.setBounds(500,400,100,25);
        
        cb1.setBounds(300,350,400,25);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        
        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        
        p1.add(b1);
        p1.add(b2);
        
        p1.add(cb1);
        
        getContentPane().add(p1);
    }

    private class ButtonHandler implements ActionListener{

        public void actionPerformed(ActionEvent ae) {
            
            if(ae.getSource() == b1)
            {
                if(cb1.isSelected())
                {
                    
                }
            }
            
            if(ae.getSource() == b2)
            {
                
            }
           
        }
    }
}
