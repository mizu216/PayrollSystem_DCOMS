package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class AdminMainPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
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
    private Button modify,view,register;
    public AdminMainPage(){
        x = new JFrame("Admin Login Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel();
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        
        title = new Label("Admin Main Page");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p0.add(title);
        
        modify = new Button("Modify Profile");
        p1.add(modify);

        view = new Button("View Staff");
        p2.add(view);

        register = new Button("Register New HR");
        p3.add(register);

        modify.addActionListener(this);
        view.addActionListener(this);
        register.addActionListener(this);
        
        x.setLayout(new GridLayout(4,1));
        x.add(p0);
        x.add(p1);
        x.add(p2);
        x.add(p3);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(false);
    }
}