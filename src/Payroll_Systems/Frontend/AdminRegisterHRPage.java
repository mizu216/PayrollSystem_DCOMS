package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
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
public class AdminRegisterHRPage implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==confirm){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String username = usernameInput.getText();
                String name = nameInput.getText();
                String password = "payroll" + name;
                if(name.length()<=2 || username.length()<=2){
                    JOptionPane.showMessageDialog(x,"Name and Username Length Must At Least Contain 2 Words");
                }
                else{
                    if(object.adminRegisterHR(username,password,name)==true) {
                            JOptionPane.showMessageDialog(x,"Register Successfully/n Temporarily Password :" + password);
                            usernameInput.setText("");
                            nameInput.setText("");
                            x.setVisible(false);
                            Client.adminMainPage.getJFrame().setVisible(true);
                    }
                    else{
                            JOptionPane.showMessageDialog(x,"Username has been taken");
                    }
                }
            }
            else if(e.getSource()== back){
                usernameInput.getText();
                nameInput.getText();
                usernameInput.setText("");
                nameInput.setText("");
                x.setVisible(false);
                Client.adminMainPage.getJFrame().setVisible(true);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Error Loading!!!");
        }
        
    }
    public JFrame getJFrame(){
        return x;
    }
    
    private JFrame x;
    private Label title;
    private Panel p0,p1,p2,p3,p4,p5,p6,p7;
    private Label usernameText,nameText;
    private TextField usernameInput,nameInput;
    private Button confirm,back;
    public AdminRegisterHRPage(){
        x = new JFrame("Register HR Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel(new GridLayout(2,1));
        p1 = new Panel();
        p2 = new Panel(new GridLayout(2,1));
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();
        p6 = new Panel();
        p7 = new Panel();
        
        usernameText = new Label("USERNAME",Label.CENTER);
        usernameInput = new TextField(30);
        p0.add(usernameText);
        p1.add(usernameInput);
        p0.add(p1);
        
        nameText = new Label("Name",Label.CENTER);
        nameInput = new TextField(30);
        p2.add(nameText);
        p3.add(nameInput);
        p2.add(p3);
        
        title = new Label("Register New HR");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p4.add(title);
        
        back = new Button("Back");
        confirm= new Button("Confirm");
        confirm.addActionListener(this);
        back.addActionListener(this);
        p5.add(back);
        p6.add(confirm);
        p7.add(p5);
        p7.add(p6);
        
        x.setLayout(new GridLayout(4,1));
        x.add(p4);
        x.add(p0);
        x.add(p2);
        x.add(p7);
    }
   
}
