package Payroll_Systems;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class AdminLoginPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==login){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String username = usernameInput.getText();
                String password = passwordInput.getText();
                usernameInput.setText("");
                passwordInput.setText("");
                if (object.adminLogin(username, password)== true){
                    System.out.println("ok");
                }
                else{
                    System.out.println("not ok");
                }
            }
                        
            else if(e.getSource() == exit){
                System.exit(0);
            }
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Invalid input!!!");
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
    private Button login,register,exit;
    public AdminLoginPage(){
        x = new JFrame("Admin Login Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel(new GridLayout(2,1));
        p1 = new Panel(new GridLayout(2,1));
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();
        
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
        exit = new Button("Exit");
        login.addActionListener(this);
        exit.addActionListener(this);
        p4.add(login);

        title = new Label("Admin Login Page");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p5.add(title);
        
        x.setLayout(new GridLayout(4,1));
        x.add(p5);
        x.add(p0);
        x.add(p1);
        x.add(p4);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(true);
    }
}