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
public class HRGeneratePayrollPage implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==confirm){
                Interface object = (Interface)Naming.lookup("rmi://localhost:1044/payroll");
                String late = lateInput.getText();
                String absence = absenceInput.getText();
                Double latePenalty = Double.parseDouble(late);
                Double absencePenalty = Double.parseDouble(absence); 
                if (object.HRGeneratePayroll(employee,latePenalty,absencePenalty)==true){
                    x.setVisible(false);
                    Client.hrMainPage.getJFrame().setVisible(true);
                }
                else{
                    System.out.println("hi");
                }
            }
            else if(e.getSource()== back){
                String late = lateInput.getText();
                String absence = absenceInput.getText();
                lateInput.setText("");
                absenceInput.setText("");
                employee="";
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
    public void setEmployee(String employee){
            this.employee = employee;
    }
    private String employee;
    private JFrame x;
    private Panel p0,p1,p2,p3,p4,p5,p6,p7;
    private Label lateText,absenceText;
    private TextField lateInput,absenceInput;
    private Button confirm,back;
    public HRGeneratePayrollPage(){
        x = new JFrame("Register Staff Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel(new GridLayout(2,1));
        p1 = new Panel();
        p2 = new Panel(new GridLayout(2,1));
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();
        p6 = new Panel();
        p7 = new Panel(new GridLayout(3,1));

        lateText = new Label("Late Penalty",Label.CENTER);
        lateInput = new TextField(30);
        p0.add(lateText);
        p1.add(lateInput);
        p0.add(p1);
        
        absenceText = new Label("Absence Penalty",Label.CENTER);
        absenceInput = new TextField(30);
        p2.add(absenceText);
        p3.add(absenceInput);
        p2.add(p3);
            
        back = new Button("BACK");
        confirm= new Button("CONFIRM");
        confirm.addActionListener(this);
        back.addActionListener(this);
        p4.add(back);
        p5.add(confirm);
        p6.add(p4);
        p6.add(p5);
        
        p7.add(p0);
        p7.add(p2);
        x.add(p7,BorderLayout.CENTER);
        x.add(p6,BorderLayout.SOUTH);
    }
}
