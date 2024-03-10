package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
import java.awt.BorderLayout;
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
public class HRRegisterStaffPage implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==confirm){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String username = usernameInput.getText();
                String name = nameInput.getText();
                String icNo = icNoInput.getText();
                String password = "staff" + name + icNo;
                String bs = basicSalaryInput.getText();
                String hra = hraInput.getText();
                String da = daInput.getText();
                String allowance = allowanceInput.getText();
                String otp = otpInput.getText();
                Long.parseLong(icNo);
                Float.parseFloat(bs);
                Float.parseFloat(hra);
                Float.parseFloat(da);
                Float.parseFloat(allowance);
                Float.parseFloat(otp);
                if(icNo.length()!=12){
                    JOptionPane.showMessageDialog(x,"Invalid IC No");
                }
                else{
                    if (object.hrRegisterStaff(username, password, name, icNo, bs, hra, da, allowance, otp) == false){
                        JOptionPane.showMessageDialog(x,"Username has been taken");
                    }
                    else{
                        JOptionPane.showMessageDialog(x,"Register Successfully/n Temporarily Password :" + password);;
                    }
                }
            }
            else if(e.getSource()== back){
                String username = usernameInput.getText();
                String name = nameInput.getText();
                String icNo = icNoInput.getText();
                String bs = basicSalaryInput.getText();
                String hra = hraInput.getText();
                String da = daInput.getText();
                String allowance = allowanceInput.getText();
                String otp = otpInput.getText();
                usernameInput.setText("");
                nameInput.setText("");
                icNoInput.setText("");
                basicSalaryInput.setText("");
                hraInput.setText("");
                daInput.setText("");
                allowanceInput.setText("");
                otpInput.setText("");
                x.setVisible(false);
                Client.hrMainPage.getJFrame().setVisible(true);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Invalid Format Input!!!");
        }
        
    }
    public JFrame getJFrame(){
        return x;
    }
    
    private JFrame x;
    private Panel p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19;
    private Label usernameText,nameText,icNoText,basicSalaryText,hraText,daText,allowanceText,otpText;
    private TextField usernameInput,nameInput,icNoInput,basicSalaryInput,hraInput,daInput,allowanceInput,otpInput;
    private Button confirm,back;
    public HRRegisterStaffPage(){
        x = new JFrame("Register Staff Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel(new GridLayout(2,1));
        p1 = new Panel();
        p2 = new Panel(new GridLayout(2,1));
        p3 = new Panel();
        p4 = new Panel(new GridLayout(2,1));
        p5 = new Panel();
        p6 = new Panel(new GridLayout(2,1));
        p7 = new Panel();
        p8 = new Panel(new GridLayout(2,1));
        p9 = new Panel();
        p10 = new Panel(new GridLayout(2,1));
        p11 = new Panel();
        p12 = new Panel(new GridLayout(2,1));
        p13 = new Panel();
        p14 = new Panel(new GridLayout(2,1));
        p15 = new Panel();
        p16 = new Panel();
        p17 = new Panel();
        p18 = new Panel();
        p19 = new Panel(new GridLayout(4,2));

        usernameText = new Label("USERNAME",Label.CENTER);
        usernameInput = new TextField(30);
        p0.add(usernameText);
        p1.add(usernameInput);
        p0.add(p1);
        
        nameText = new Label("NAME",Label.CENTER);
        nameInput = new TextField(30);
        p2.add(nameText);
        p3.add(nameInput);
        p2.add(p3);
        
        icNoText = new Label("IC NO",Label.CENTER);
        icNoInput = new TextField(30);
        p4.add(icNoText);
        p5.add(icNoInput);
        p4.add(p5);
        
        basicSalaryText = new Label("BASIC SALARY",Label.CENTER);
        basicSalaryInput = new TextField(30);
        p6.add(basicSalaryText);
        p7.add(basicSalaryInput);
        p6.add(p7);
        
        hraText = new Label("HOUSE RENT ALLOWANCE",Label.CENTER);
        hraInput = new TextField(30);
        p8.add(hraText);
        p9.add(hraInput);
        p8.add(p9);
        
        daText = new Label("DEARNESS ALLOWANCE",Label.CENTER);
        daInput = new TextField(30);
        p10.add(daText);
        p11.add(daInput);
        p10.add(p11);
        
        allowanceText = new Label("OTHER ALLOWANCE",Label.CENTER);
        allowanceInput = new TextField(30);
        p12.add(allowanceText);
        p13.add(allowanceInput);
        p12.add(p13);
        
        otpText = new Label("ONE-TIME PAYMENT",Label.CENTER);
        otpInput = new TextField(30);
        p14.add(otpText);
        p15.add(otpInput);
        p14.add(p15);
        
        back = new Button("BACK");
        confirm= new Button("CONFIRM");
        confirm.addActionListener(this);
        back.addActionListener(this);
        p16.add(back);
        p17.add(confirm);
        p18.add(p16);
        p18.add(p17);
        
        p19.add(p0);
        p19.add(p2);
        p19.add(p4);
        p19.add(p6);
        p19.add(p8);
        p19.add(p10);
        p19.add(p12);
        p19.add(p14);
        x.add(p19,BorderLayout.CENTER);
        x.add(p18,BorderLayout.SOUTH);
    }
}
