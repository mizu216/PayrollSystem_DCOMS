package Payroll_Systems.Frontend;

import Payroll_Systems.Backend.Interface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class HRUpdateSalaryPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==confirm){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String salary =salaryInput.getText();
                String allowance = allowanceInput.getText();
                Double.parseDouble(salary);
                Double.parseDouble(allowance);
                salaryInput.setText("");
                allowanceInput.setText("");
                if (object.hrUpdateSalary(employee,salary,allowance)== true){
                   JOptionPane.showMessageDialog(x,"Emplooyee Salary Modify Sucessfully");
                   x.setVisible(false);
                   Client.hrMainPage.getJFrame().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(x,"Error Loading!!");
                }
            }
                        
            else if(e.getSource() == back){
                String username = salaryInput.getText();
                String password = allowanceInput.getText();
                salaryInput.setText("");
                allowanceInput.setText("");
                x.setVisible(false);
                Client.hrMainPage.getJFrame().setVisible(true);
            }
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Error Loading/Invalid Format!!!");
            ex.printStackTrace();
        }
    }
    public JFrame getJFrame(){
        return x;
    }
    public void setEmployee(String employee){
        this.employee = employee;
    }
    private String employee;
    private JFrame x;
    private Panel p0,p1,p2,p3,p4, p5,p6,p7;
    private Label salaryText,allowanceText, title;
    private TextField salaryInput,allowanceInput;
    private Button confirm,back;
    public HRUpdateSalaryPage(){
        x = new JFrame("HR Update Employee Salary/Allowances Page");
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
        
        salaryText = new Label("Basic Salary",Label.CENTER);
        salaryInput = new TextField(30);
        p2.add(salaryInput);
        p0.add(salaryText);
        p0.add(p2);
        
        allowanceText = new Label("Allowance",Label.CENTER);
        allowanceInput = new TextField(30);
        p3.add(allowanceInput);
        p1.add(allowanceText);
        p1.add(p3);
        
        confirm = new Button("Confirm");
        back = new Button("Back");
        confirm.addActionListener(this);
        back.addActionListener(this);
        p4.add(back);
        p5.add(confirm);
        p6.add(p4);
        p6.add(p5);

        title = new Label("Modify Employee Salary");
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