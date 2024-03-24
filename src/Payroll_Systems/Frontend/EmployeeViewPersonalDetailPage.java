package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
import java.awt.BorderLayout;
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
public class EmployeeViewPersonalDetailPage implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()== back){
                String username = usernameInput.getText();
                String name = nameInput.getText();
                String icNo = icNoInput.getText();
                String bs = basicSalaryInput.getText();
                String allowance = allowanceInput.getText();
                usernameInput.setText("");
                nameInput.setText("");
                icNoInput.setText("");
                basicSalaryInput.setText("");
                allowanceInput.setText("");
                x.setVisible(false);
                Client.employeeMainPage.getJFrame().setVisible(true);
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

    public TextField getUsernameInput() {
        return usernameInput;
    }

    public TextField getNameInput() {
        return nameInput;
    }

    public TextField getIcNoInput() {
        return icNoInput;
    }

    public TextField getBasicSalaryInput() {
        return basicSalaryInput;
    }

    public TextField getAllowanceInput() {
        return allowanceInput;
    }
    
    private JFrame x;
    private Panel p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14;
    private Label usernameText,nameText,icNoText,basicSalaryText,allowanceText,title;
    private TextField usernameInput,nameInput,icNoInput,basicSalaryInput,allowanceInput;
    private Button confirm,back;
    public EmployeeViewPersonalDetailPage(){
        x = new JFrame("View Personal Detail Page");
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
        p10 = new Panel();
        p11 = new Panel();
        p12 = new Panel();
        p13 = new Panel(new GridLayout(4,2));
        p14 = new Panel();

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
           
        allowanceText = new Label("ALLOWANCES",Label.CENTER);
        allowanceInput = new TextField(30);
        p8.add(allowanceText);
        p9.add(allowanceInput);
        p8.add(p9);
        
            
        back = new Button("Back");
        back.addActionListener(this);
        p10.add(back);
        p12.add(p10);
        
        p13.add(p0);
        p13.add(p2);
        p13.add(p4);
        p13.add(p6);
        p13.add(p8);
        
        title = new Label("Personal Detail");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p14.add(title);
        
        x.add(p14,BorderLayout.NORTH);
        x.add(p13,BorderLayout.CENTER);
        x.add(p12,BorderLayout.SOUTH);
      
        usernameInput.setEditable(false);
        nameInput.setEditable(false);
        icNoInput.setEditable(false);
        basicSalaryInput.setEditable(false);
        allowanceInput.setEditable(false);
    }
}
