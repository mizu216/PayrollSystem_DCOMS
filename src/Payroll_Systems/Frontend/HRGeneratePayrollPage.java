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
                Double latePenalty = Double.parseDouble(lateInput.getText());
                Double absencePenalty = Double.parseDouble(absenceInput.getText()); 
                int month = Integer.parseInt(monthInput.getText());
                int year = Integer.parseInt(yearInput.getText());
                if (month<1||month>12||year <2000||year>9999){
                    JOptionPane.showMessageDialog(x,"Please Input Correct Year and Month");
                }
                else{
                    if (object.HRGeneratePayroll(employee,latePenalty,absencePenalty,month,year)==true){
                        lateInput.setText("");
                        absenceInput.setText("");
                        monthInput.setText("");
                        yearInput.setText("");
                        JOptionPane.showMessageDialog(x,"Payroll Generate Successfully");
                        x.setVisible(false);
                        Client.hrMainPage.getJFrame().setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(x,"Error Loading!");
                    }
                }
            }
            else if(e.getSource()== back){
                String late = lateInput.getText();
                String absence = absenceInput.getText();                
                String month = monthInput.getText();
                String year = yearInput.getText();
                lateInput.setText("");
                absenceInput.setText("");
                monthInput.setText("");
                yearInput.setText("");
                employee="";
                x.setVisible(false);
                Client.hrMainPage.getJFrame().setVisible(true);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Error Loading/Invalid Format!!!");
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
    private Panel p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
    private Label lateText,absenceText,monthText,yearText,title;
    private TextField lateInput,absenceInput,monthInput,yearInput;
    private Button confirm,back;
    public HRGeneratePayrollPage(){
        x = new JFrame("HR Generate Payroll Page");
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
        p8 = new Panel();
        p9 = new Panel();
        p10 = new Panel();
        p11 = new Panel(new GridLayout(4,1));
        p12 = new Panel();

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
        
        monthText = new Label("Input 1-12 (Month)",Label.CENTER);
        monthInput = new TextField(30);
        p4.add(monthText);
        p5.add(monthInput);
        p4.add(p5);
        
        yearText = new Label("Input **** (Year)",Label.CENTER);
        yearInput = new TextField(30);
        p6.add(yearText);
        p7.add(yearInput);
        p6.add(p7);
            
        back = new Button("Back");
        confirm= new Button("Confirm");
        confirm.addActionListener(this);
        back.addActionListener(this);
        p8.add(back);
        p9.add(confirm);
        p10.add(p8);
        p10.add(p9);
        
        title = new Label("Generate Payroll");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p12.add(title);
        
        p11.add(p0);
        p11.add(p2);
        p11.add(p4);
        p11.add(p6);     
        x.add(p12,BorderLayout.NORTH);
        x.add(p11,BorderLayout.CENTER);
        x.add(p10,BorderLayout.SOUTH);
    }
}
