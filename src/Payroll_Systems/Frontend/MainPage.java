package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class MainPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==admin){
                x.setVisible(false);
                Client.adminLoginPage.getJFrame().setVisible(true);
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
    private Label usernameText,passwordText, title;
    private TextField usernameInput,passwordInput;
    private Button admin,HR,employee;
    public MainPage(){
        x = new JFrame("Main Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel();
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        
        title = new Label("Admin Main Page");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p0.add(title);
        
        admin = new Button("Login as Admin");
        p1.add(admin);

        HR = new Button("Login as HR");
        p2.add(HR);

        employee = new Button("Login as Employee");
        p3.add(employee);

        admin.addActionListener(this);
        HR.addActionListener(this);
        employee.addActionListener(this);
        
        x.setLayout(new GridLayout(4,1));
        x.add(p0);
        x.add(p1);
        x.add(p2);
        x.add(p3);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(true);
    }
}