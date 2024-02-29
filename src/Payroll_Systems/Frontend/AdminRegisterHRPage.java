package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
public class AdminRegisterHRPage implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==confirm){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String username = usernameInput.getText();
                String name = nameInput.getText();
                String icNo = icNoInput.getText();
                String password = "payroll" + name + icNo;
                switch (object.adminRegisterHR(username,password,name, icNo)) {
                    case 1:
                        JOptionPane.showMessageDialog(x,"Username has been taken");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(x,"Invalid IC Number");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(x,"Register Successfully/n Temporarily Password :" + password);
                        x.setVisible(false);
                        Client.adminMainPage.getJFrame().setVisible(true);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(x,"Error!!! Please Try Again");
                        x.setVisible(false);
                        Client.adminMainPage.getJFrame().setVisible(true);
                }
            }
            else if(e.getSource()== back){
                usernameInput.getText();
                nameInput.getText();
                icNoInput.getText();
                usernameInput.setText("");
                nameInput.setText("");
                icNoInput.setText("");
                x.setVisible(false);
                Client.adminMainPage.getJFrame().setVisible(true);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Invalid input!!!");
        }
        
    }
    public JFrame getJFrame(){
        return x;
    }
    
    private JFrame x;
    private Panel p0,p1,p2,p3,p4,p5,p6,p7,p8;
    private Label usernameText,nameText,icNoText;
    private TextField usernameInput,nameInput,icNoInput;
    private Button confirm,back;
    public AdminRegisterHRPage(){
        x = new JFrame("Register HR Page");
        x.setSize(800,400);
        x.setLocation(700,300);
        p0 = new Panel(new GridLayout(2,1));
        p1 = new Panel();
        p2 = new Panel(new GridLayout(2,1));
        p3 = new Panel();
        p4 = new Panel(new GridLayout(2,1));
        p5 = new Panel();
        p6 = new Panel();
        p7 = new Panel();
        p8 = new Panel();

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
        
        icNoText = new Label("icNo",Label.CENTER);
        icNoInput = new TextField(30);
        p4.add(icNoText);
        p5.add(icNoInput);
        p4.add(p5);
        
        back = new Button("Back");
        confirm= new Button("Confirm");
        confirm.addActionListener(this);
        back.addActionListener(this);
        p6.add(back);
        p7.add(confirm);
        p8.add(back);
        p8.add(confirm);
        
        x.setLayout(new GridLayout(4,1));
        x.add(p0);
        x.add(p2);
        x.add(p4);
        x.add(p6);
        x.add(p8);
    }
   
}
