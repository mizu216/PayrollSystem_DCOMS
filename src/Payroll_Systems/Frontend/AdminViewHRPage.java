package Payroll_Systems.Frontend;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class AdminViewHRPage implements ActionListener{
    
    private JFrame x;
    private Panel p0,p1;
    private JTable table;
    private DefaultTableModel tableModel;
    private Label CD;
    private Button back;
    public AdminViewHRPage(){
        x = new JFrame("Customer Booking Page");
        x.setSize(1200,500);
        x.setLocation(700,300);
        x.setLayout(new BorderLayout());
        p0 = new Panel();
        p0.setLayout(new BorderLayout());
        p1 = new Panel();
        
        CD = new Label("__HR Detail__",Label.CENTER);
        CD.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        p0.add(CD,BorderLayout.NORTH);
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("USERNAME");
        tableModel.addColumn("NAME");
        tableModel.addColumn("IC_NO");
        table = new JTable(tableModel);
        p0.add(new JScrollPane(table),BorderLayout.CENTER);
        table.setEnabled(false);
        x.add(p0,BorderLayout.CENTER);
        
        back = new Button("Back");
        back.addActionListener(this);
        p1.add(back);
        x.add(p1,BorderLayout.SOUTH);
    }
    
    public JFrame getJFrame(){
        return x;
    }
    
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    public void clearAllRow(){
        int row = tableModel.getRowCount();
        for(int i = 0;i<row;i++){
            tableModel.removeRow(0);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==back){
                clearAllRow();
                x.setVisible(false);
                Client.adminMainPage.getJFrame().setVisible(true);
            }
        }
        
        catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(x,"Error!!! Please Try Again");
        }
        
    }
    
    
    
}
