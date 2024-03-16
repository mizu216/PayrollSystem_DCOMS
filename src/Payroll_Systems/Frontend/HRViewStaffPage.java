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
public class HRViewStaffPage implements ActionListener{
    
    private JFrame x;
    private Panel p0,p1,p2,p3,p4,p5,p6,p2a;
    private JTable table;
    private DefaultTableModel tableModel;
    private TextField payrollInput;
    private Label CD,payroll;
    private Button back,update,generate;
    public HRViewStaffPage(){
        x = new JFrame("View Employee Page");
        x.setSize(1200,500);
        x.setLocation(700,300);
        x.setLayout(new BorderLayout());
        p0 = new Panel();
        p0.setLayout(new BorderLayout());
        p1 = new Panel();
        p2 = new Panel();
        p2a = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel(new GridLayout(2,1));
        p6 = new Panel();
        p6.setLayout(new BorderLayout());
        
        CD = new Label("__Employee Detail__",Label.CENTER);
        CD.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        p0.add(CD,BorderLayout.NORTH);
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("USERNAME");
        tableModel.addColumn("NAME");
        tableModel.addColumn("IC_NO");
        tableModel.addColumn("BASIC SALARY");
        tableModel.addColumn("ALLOWANCES");
        table = new JTable(tableModel);
        p0.add(new JScrollPane(table),BorderLayout.CENTER);
        table.setEnabled(false);
        x.add(p0,BorderLayout.CENTER);
        
        back = new Button("Back");
        back.addActionListener(this);
        update = new Button("Update Salary/Allowance");
        update.addActionListener(this);
        generate = new Button("Generate Payroll");
        generate.addActionListener(this);
        p1.add(back);
        p2.add(update);
        p2a.add(generate);
        p3.add(p1);
        p3.add(p2);
        p3.add(p2a);
        
        payroll = new Label("Enter Username To Manage Salary",Label.CENTER);
        payrollInput = new TextField(30);
        p4.add(payrollInput);
        p5.add(payroll);
        p5.add(p4);
        
        p6.add(p3,BorderLayout.SOUTH);
        p6.add(p5,BorderLayout.CENTER);
        
        x.add(p0,BorderLayout.CENTER);
        x.add(p6,BorderLayout.NORTH);
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
                Client.hrMainPage.getJFrame().setVisible(true);
            }
            else if(e.getSource()==generate){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String username = payrollInput.getText();
                if(object.checkStaffUsername(username)==true){
                    x.setVisible(false);
                    Client.hrGeneratePayrollPage.getJFrame().setVisible(true);
                    Client.hrGeneratePayrollPage.setEmployee(username);
                    clearAllRow();
                }
                else{
                    JOptionPane.showMessageDialog(x,"Invalid Username");
                }
            }
        }
        
        catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(x,"Error!!! Please Try Again");
        }
        
    }
    
    
    
}
