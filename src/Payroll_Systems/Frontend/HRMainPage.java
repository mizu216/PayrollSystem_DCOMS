package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class HRMainPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==register){
                x.setVisible(false);
                Client.hrRegisterStaffPage.getJFrame().setVisible(true);
            }
            else if(e.getSource()==update){
                x.setVisible(false);
                Client.hrUpdatePasswordPage.getJFrame().setVisible(true);
            }
            else if(e.getSource()==staff){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String[][] staffData = object.HRViewStaff();
                for (int i = 0; i < staffData.length; i++) {
                    Client.hrViewStaffPage.getTableModel().insertRow(i, staffData[i]);
                }
                x.setVisible(false);
                Client.hrViewStaffPage.getJFrame().setVisible(true);
            }
            else if(e.getSource()==payroll){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String[][] staffData = object.HRViewPayroll();
                for (int i = 0; i < staffData.length; i++) {
                    Client.hrViewPayrollPage.getTableModel().insertRow(i, staffData[i]);
                }
                x.setVisible(false);
                Client.hrViewPayrollPage.getJFrame().setVisible(true);
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
    private Button update,staff,register,payroll,logout;
    public HRMainPage(){
        x = new JFrame("HR Main Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel();
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();
        
        title = new Label("HR Main Page");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p0.add(title);
        
        update = new Button("Update Password");
        p1.add(update);
        
        register = new Button("Register New Staff");
        p2.add(register);

        staff = new Button("View All Staff");
        p3.add(staff);
        
        payroll = new Button("View All Payroll");
        p4.add(payroll);
        
        logout = new Button("Logout");
        p5.add(logout);

        update.addActionListener(this);
        staff.addActionListener(this);
        register.addActionListener(this);
        payroll.addActionListener(this);
        logout.addActionListener(this);
        
        x.setLayout(new GridLayout(6,1));
        x.add(p0);
        x.add(p1);
        x.add(p2);
        x.add(p3);
        x.add(p4);
        x.add(p5);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(false);
    }
}