package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class EmployeeLoginPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==login){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String username = usernameInput.getText();
                String password = passwordInput.getText();
                usernameInput.setText("");
                passwordInput.setText("");
                if (object.employeeLogin(username, password)== true){
                    Client.loginUser = username;
                    x.setVisible(false);
                    Client.employeeMainPage.getJFrame().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(x,"Invalid Credential!!!");
                }
            }
                        
            else if(e.getSource()==back){
                String username = usernameInput.getText();
                String password = passwordInput.getText();
                usernameInput.setText("");
                passwordInput.setText("");
                x.setVisible(false);
                Client.mainPage.getJFrame().setVisible(true);
            }
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Error Loading!!!");
            ex.printStackTrace();
        }
        
    }
    public JFrame getJFrame(){
        return x;
    }
    private JFrame x;
    private Panel p0,p1,p2,p3,p4, p5,p6,p7;
    private Label usernameText,passwordText, title;
    private TextField usernameInput,passwordInput;
    private Button login,back;
    public EmployeeLoginPage(){
        x = new JFrame("Employee Login Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel(new GridLayout(2,1));
        p1 = new Panel(new GridLayout(2,1));
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();
        p6 = new Panel();
        p7 = new Panel();
        
        usernameText = new Label("USERNAME",Label.CENTER);
        usernameInput = new TextField(30);
        p2.add(usernameInput);
        p0.add(usernameText);
        p0.add(p2);
        
        passwordText = new Label("PASSWORD",Label.CENTER);
        passwordInput = new TextField(30);
        p3.add(passwordInput);
        p1.add(passwordText);
        p1.add(p3);
        
        login = new Button("Login");
        back = new Button("Back");
        login.addActionListener(this);
        back.addActionListener(this);
        p4.add(login);
        p5.add(back);
        p6.add(p5);
        p6.add(p4);

        title = new Label("Employee Login Page");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p7.add(title);
        
        x.setLayout(new GridLayout(4,1));
        x.add(p7);
        x.add(p0);
        x.add(p1);
        x.add(p6);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(false);
    }
}