package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class HRUpdatePasswordPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==confirm){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String oldPassword = oldPassInput.getText();
                String newPassword = newPassInput.getText();
                String confirmPassword = confirmPassInput.getText();
                oldPassInput.setText("");
                newPassInput.setText("");
                confirmPassInput.setText("");
                if (newPassword.equals(confirmPassword)){
                    if (object.hrUpdatePassword(Client.loginUser, oldPassword, newPassword)==true){
                       System.out.println("ok");
                    }
                    else{
                        System.out.println("not ok");
                    }
                }
                else{
                    System.out.println("not ok");
                }
            }
                        
            else if(e.getSource() == back){
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
    private Panel p0,p1,p2,p3,p4, p5,p6,p7;
    private Label oldPass,newPass,confirmPass,title;
    private TextField oldPassInput,newPassInput,confirmPassInput;
    private Button confirm,back;
    public HRUpdatePasswordPage(){
        x = new JFrame("HR Update Password Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel(new GridLayout(2,1));
        p1 = new Panel(new GridLayout(2,1));
        p2 = new Panel(new GridLayout(2,1));
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();
        p6 = new Panel();
        p7 = new Panel();
        
        oldPass = new Label("OLD PASSWORD",Label.CENTER);
        oldPassInput = new TextField(30);
        p3.add(oldPassInput);
        p0.add(oldPass);
        p0.add(p3);
        
        newPass = new Label("NEW PASSWORD",Label.CENTER);
        newPassInput = new TextField(30);
        p4.add(newPassInput);
        p1.add(newPass);
        p1.add(p4);
        
        confirmPass = new Label("Confirm PASSWORD",Label.CENTER);
        confirmPassInput = new TextField(30);
        p5.add(confirmPassInput);
        p2.add(confirmPass);
        p2.add(p5);
        
        confirm = new Button("Confirm");
        back = new Button("Back");
        confirm.addActionListener(this);
        back.addActionListener(this);
        p6.add(back);
        p6.add(confirm);

        title = new Label("HR Update Password Page");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p7.add(title);
        
        x.setLayout(new GridLayout(5,1));
        x.add(p7);
        x.add(p0);
        x.add(p1);
        x.add(p2);
        x.add(p6);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(false);
    }
}