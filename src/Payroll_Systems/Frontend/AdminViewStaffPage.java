package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class AdminViewStaffPage implements ActionListener{
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
            JOptionPane.showMessageDialog(x,"Error Loading!!!");
        }
        
    }
    
    private JFrame x;
    private Panel p0,p1;
    private JTable table;
    private DefaultTableModel tableModel;
    private Label CD;
    private Button back;
    public AdminViewStaffPage(){
        x = new JFrame("View Employee Page");
        x.setSize(1200,500);
        x.setLocation(700,300);
        x.setLayout(new BorderLayout());
        p0 = new Panel();
        p0.setLayout(new BorderLayout());
        p1 = new Panel();
        
        CD = new Label("__Employees Detail__",Label.CENTER);
        CD.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("USERNAME");
        tableModel.addColumn("NAME");
        tableModel.addColumn("IC_NO");
        tableModel.addColumn("BASIC SALARY");
        tableModel.addColumn("ALLOWANCES");
        table = new JTable(tableModel);
        table.setEnabled(false);
        x.add(new JScrollPane(table),BorderLayout.CENTER);
        back = new Button("Back");
        back.addActionListener(this);
        p1.add(back);
        x.add(p1,BorderLayout.SOUTH);
        x.add(CD,BorderLayout.NORTH);
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
}
