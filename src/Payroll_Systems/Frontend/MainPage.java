package Payroll_Systems.Frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class MainPage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==admin){
                x.setVisible(false);
                Client.adminLoginPage.getJFrame().setVisible(true);
            }
            else if(e.getSource()==HR){
                x.setVisible(false);
                Client.hrLoginPage.getJFrame().setVisible(true);
            }
            else if(e.getSource()==employee){
                x.setVisible(false);
                Client.employeeLoginPage.getJFrame().setVisible(true);
            }
            
            else if(e.getSource()==quit){
                System.exit(0);
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
    private JFrame x;
    private Panel p0,p1,p2,p3,p4;
    private Label title;
    private Button admin,HR,employee,quit;
    public MainPage(){
        x = new JFrame("Main Menu Page");
        x.setSize(500,500);
        x.setLocation(700,300);
        p0 = new Panel();
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        
        title = new Label("PPlease Select Interface");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p0.add(title);
        
        admin = new Button("Login as Admin");
        p1.add(admin);

        HR = new Button("Login as HR");
        p2.add(HR);

        employee = new Button("Login as Employee");
        p3.add(employee);
        
        quit = new Button("Quit");
        p4.add(quit);

        admin.addActionListener(this);
        HR.addActionListener(this);
        employee.addActionListener(this);
        quit.addActionListener(this);
        
        x.setLayout(new GridLayout(5,1));
        x.add(p0);
        x.add(p1);
        x.add(p2);
        x.add(p3);
        x.add(p4);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(true);
    }
}