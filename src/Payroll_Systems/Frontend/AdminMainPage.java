package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class AdminMainPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==register){
                x.setVisible(false);
                Client.adminRegisterHRPage.getJFrame().setVisible(true);
            }
            else if (e.getSource()==hr){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String[][] hrData = object.adminViewHR();
                for (int i = 0; i < hrData.length; i++) {
                    Client.adminViewHRPage.getTableModel().insertRow(i, hrData[i]);
                }
                x.setVisible(false);
                Client.adminViewHRPage.getJFrame().setVisible(true);
            }
            else if(e.getSource()==logout){
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
    private Button hr,staff,register,logout;
    public AdminMainPage(){
        x = new JFrame("Admin Login Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel();
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        
        title = new Label("Admin Main Page");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p0.add(title);
        
        hr = new Button("View HR");
        p1.add(hr);

        staff = new Button("View Staff");
        p2.add(staff);

        register = new Button("Register New HR");
        p3.add(register);
        
        logout = new Button("Logout");
        p4.add(logout);

        hr.addActionListener(this);
        staff.addActionListener(this);
        register.addActionListener(this);
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