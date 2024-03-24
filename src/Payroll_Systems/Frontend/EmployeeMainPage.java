package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class EmployeeMainPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==update){
                x.setVisible(false);
                Client.employeeUpdatePasswordPage.getJFrame().setVisible(true);
            }
            else if (e.getSource()==pd){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String[][] staffData = object.employeeViewStaff(Client.loginUser);
                Client.employeeViewPersonalDetailPage.getUsernameInput().setText(staffData[0][0]);
                Client.employeeViewPersonalDetailPage.getNameInput().setText(staffData[0][1]);
                Client.employeeViewPersonalDetailPage.getIcNoInput().setText(staffData[0][2]);
                Client.employeeViewPersonalDetailPage.getBasicSalaryInput().setText(staffData[0][3]);
                Client.employeeViewPersonalDetailPage.getAllowanceInput().setText(staffData[0][4]);
                x.setVisible(false);
                Client.employeeViewPersonalDetailPage.getJFrame().setVisible(true);
            }
            else if(e.getSource()==pp){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String[][] staffData = object.employeeViewPayroll(Client.loginUser);
                for (int i = 0; i < staffData.length; i++) {
                    Client.employeeViewPayrollPage.getTableModel().insertRow(i, staffData[i]);
                }
                x.setVisible(false);
                Client.employeeViewPayrollPage.getJFrame().setVisible(true);
            }
            else if(e.getSource()==logout){
                Client.loginUser = null;
                x.setVisible(false);
                Client.mainPage.getJFrame().setVisible(true);
            }
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Error!!! Please Try Again");
            ex.printStackTrace();
        }
    }
    
    public JFrame getJFrame(){
        return x;
    }
    private JFrame x;
    private Panel p0,p1,p2,p3,p4, p5;
    private Label title;
    private Button pd,pp,update,logout;
    public EmployeeMainPage(){
        x = new JFrame("Employee Main Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel();
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        
        title = new Label("Employee Main Menu");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p0.add(title);
        
        pd = new Button("View Personal Detail");
        p1.add(pd);

        pp = new Button("View Personal Payroll");
        p2.add(pp);

        update = new Button("Update Password");
        p3.add(update);
        
        logout = new Button("Logout");
        p4.add(logout);

        pd.addActionListener(this);
        pp.addActionListener(this);
        update.addActionListener(this);
        logout.addActionListener(this);
        
        x.setLayout(new GridLayout(5,1));
        x.add(p0);
        x.add(p1);
        x.add(p2);
        x.add(p3);
        x.add(p4);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(false);
    }
}