import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class VStock extends JFrame
{
    String name;
    JPanel p1;
    JTable t1;
    JButton b1 = new JButton("Back");
    JLabel welcome = new JLabel();
    
    gcon g = new gcon();
    Statement stm;
    Connection d;
    ResultSet rs;
    
    public VStock(String s1)
    {
        super("Vimal Auto Deals");
        String sql = new String("select * from stock");
        name = s1;
        welcome.setText(name);
        welcome.setBounds(1100, 20, 100, 30);
        d = g.getDBConnection();
        try {
            stm = d.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(VStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            t1 = new JTable(BuildTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(VStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            d.close();
        } catch (SQLException ex) {
            Logger.getLogger(VStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, new JScrollPane(t1));
    }

    private TableModel BuildTableModel(ResultSet rs) throws SQLException{
        
        ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);
    }
    
}