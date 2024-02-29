package Payroll_Systems.Frontend;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
public class AdminRegisterHRPage implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==confirm){
                String username = usernameInput.getText();
                String password = passwordInput.getText();
                String gender = genderInput();
                String email = emailInput.getText();
                String address = addressInput.getText();
                String phone = phoneInput.getText();
                int age = Integer.parseInt(ageInput.getText());
                
                Admin found2 = AdminDataIO.checkUsername(username);
                Customer found = CustomerDataIO.checkUsername(username);
                if(username.equals("")||password.equals("")|| email.equals("")||address.equals("")||phone.equals("")){
                    throw new Exception();
                }
                else if(found != null||found2!=null||username.equals(Main.sa.getUsername())){
                    JOptionPane.showMessageDialog(x,"This username has been used");
                }
                else if(gender.equals("")){
                    JOptionPane.showMessageDialog(x,"Please choose your gender");
                }
                else if(age<18||age>100){
                    JOptionPane.showMessageDialog(x,"Only age between 18 and 100 can registered");
                }
                else{
                    JOptionPane.showMessageDialog(x,"Account has registered,approve letter will send to email once account has approved.");
                    usernameInput.setText("");
                    passwordInput.setText("");
                    emailInput.setText("");
                    addressInput.setText("");
                    phoneInput.setText("");
                    ageInput.setText("");
                    CustomerDataIO.allCustomers.add(new Customer(username,password,gender,email,address,phone,age,"Pending","Normal"));
                    CustomerDataIO.writeToFile();
                    x.setVisible(false);
                    Main.homepage.getJFrame().setVisible(true);
                }
            }
            else if(e.getSource()== back){
                usernameInput.getText();
                passwordInput.getText();
                emailInput.getText();
                addressInput.getText();
                phoneInput.getText();                
                ageInput.getText();
                usernameInput.setText("");
                passwordInput.setText("");
                emailInput.setText("");
                addressInput.setText("");
                phoneInput.setText("");
                ageInput.setText("");
                x.setVisible(false);
                Main.homepage.getJFrame().setVisible(true);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Invalid input!!!");
        }
        
    }
    public JFrame getJFrame(){
        return x;
    }
    
    public String genderInput(){
        String genders = "";
        if(Male.isSelected()){
            genders = "Male";
        }
        else if (Female.isSelected()){
            genders = "Female";
        }
        return genders;
    }
    
    private JFrame x;
    private Panel p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16;
    private JRadioButton Male,Female;
    private ButtonGroup gendergrp;
    private Label usernameText,passwordText,genderText,emailText,addressText,phoneText,ageText;
    private TextField usernameInput,passwordInput,emailInput,addressInput,phoneInput,ageInput;
    private Button confirm,back;
    public AdminRegisterHRPage(){
        x = new JFrame("Register Page");
        x.setSize(800,400);
        x.setLocation(700,300);
        p0 = new Panel(new GridLayout(2,1));
        p1 = new Panel(new GridLayout(2,1));
        p2 = new Panel(new GridLayout(2,1));
        p3 = new Panel(new GridLayout(2,1));
        p4 = new Panel(new GridLayout(2,1));
        p5 = new Panel(new GridLayout(2,1));
        p6 = new Panel(new GridLayout(2,1));
        p7 = new Panel();
        p8 = new Panel();
        p9 = new Panel();
        p10 = new Panel();
        p11 = new Panel();
        p12 = new Panel();
        p13 = new Panel();
        p14 = new Panel();
        
        
        
        usernameText = new Label("USERNAME",Label.CENTER);
        usernameInput = new TextField(30);
        p7.add(usernameInput);
        p0.add(usernameText);
        p0.add(p7);
        
        passwordText = new Label("PASSWORD",Label.CENTER);
        passwordInput = new TextField(30);
        p8.add(passwordInput);
        p1.add(passwordText);
        p1.add(p8);
        
        genderText = new Label("GENDER(Male/Female)",Label.CENTER);
        Male = new JRadioButton("Male");
        Female = new JRadioButton("Female");
        Male.addActionListener(this);
        Female.addActionListener(this);
        gendergrp = new ButtonGroup();
        gendergrp.add(Male);
        gendergrp.add(Female);
        p9.add(Male);
        p9.add(Female);
        p2.add(genderText);
        p2.add(p9);
        
        emailText = new Label("Email",Label.CENTER);
        emailInput = new TextField(30);
        p10.add(emailInput);
        p3.add(emailText);
        p3.add(p10);
        
        addressText = new Label("ADDRESS",Label.CENTER);
        addressInput = new TextField(30);
        p11.add(addressInput);
        p4.add(addressText);
        p4.add(p11);
        
        phoneText = new Label("PHONE_NO",Label.CENTER);
        phoneInput = new TextField(30);
        p12.add(phoneInput);
        p5.add(phoneText);
        p5.add(p12);
        
        ageText = new Label("AGE",Label.CENTER);
        ageInput = new TextField(30);
        p13.add(ageInput);
        p6.add(ageText);
        p6.add(p13);
        
        confirm= new Button("Confirm");
        back = new Button("Back");
        confirm.addActionListener(this);
        back.addActionListener(this);
        p14.add(confirm);
        p14.add(back);
        
        x.setLayout(new GridLayout(4,2));
        x.add(p0);
        x.add(p1);
        x.add(p2);
        x.add(p3);
        x.add(p4);
        x.add(p5);
        x.add(p6);
        x.add(p14);
    }
   
}
