/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payroll_Systems.Backend;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author limzi
 */
public class Server extends UnicastRemoteObject implements Interface {
    public Server()throws RemoteException{
        super();
    }
    
    @Override
    
    public boolean adminLogin(String username, String password)throws RemoteException{
        return (username.equals("Admin123") && password.equals("admin123"));
    }
    
   
    @Override
    public int adminRegisterHR(String username,String password,String name,String icNo)throws RemoteException{
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/payroll_system_staff","root","root");
            System.out.println("Database Connected");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM HR_Table WHERE Username = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                conn.commit();
                rs.close();
                pstmt.close();
                conn.close();
                return 1;
            }
            if(icNo.length()!=12||isParseSuccessful(icNo) == false){
                conn.commit();
                conn.close();
                return 2;
            }
            else{
                PreparedStatement pstmt2 = conn.prepareStatement("INSERT INTO HR_Table (Username, Password, name,IC_No) VALUES (?, ?, ?, ?)");
                pstmt2.setString(1, username);
                pstmt2.setString(2, password);
                pstmt2.setString(3, name);
                pstmt2.setString(4,icNo);
                pstmt2.executeUpdate();
                conn.commit();
                pstmt2.close();
                conn.close();
                return 3;
            }
        }
        catch (SQLException e){
            System.out.println(e);
            return 4;
        }
    }
    
    private static boolean isParseSuccessful(String numberString) {
        try {
            Long.parseLong(numberString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    @Override
    public String[][] adminViewHR()throws RemoteException{
        String[][] hrDataList = null;
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/payroll_system_staff", "root", "root");
            PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS rowCount FROM HR_Table");
            ResultSet rs = pstmt.executeQuery();
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt("rowCount");
            }
            rs.close();
            pstmt.close();
            
            hrDataList = new String[rowCount][3];
            PreparedStatement pstmt2 = conn.prepareStatement("SELECT * FROM HR_Table");
            ResultSet rs2 = pstmt2.executeQuery();
            int i=0;
            while (rs2.next()) {
                hrDataList[i][0] = rs2.getString("Username");                
                hrDataList[i][1] = rs2.getString("Name");
                hrDataList[i][2] = rs2.getString("IC_No"); 
                i++;
            }
            rs2.close();
            pstmt2.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return hrDataList;
    }
    
    @Override
    public boolean hrLogin(String username, String password)throws RemoteException{
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/payroll_system_staff", "root", "root");
            PreparedStatement pstmt = conn.prepareStatement("SELECT Password FROM HR_Table WHERE Username = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("Password");
                if (storedPassword.equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean hrUpdatePassword(String username, String oldPassword, String newPassword)throws RemoteException{
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/payroll_system_staff", "root", "root");
            PreparedStatement pstmt = conn.prepareStatement("SELECT Password FROM HR_Table WHERE Username = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("Password");
                if (storedPassword.equals(oldPassword)) {
                    System.out.println("good");
                    pstmt = conn.prepareStatement("UPDATE HR_Table SET Password = ? WHERE Username = ?");
                    pstmt.setString(1, newPassword);
                    pstmt.setString(2, username);
                    int executeUpdate = pstmt.executeUpdate();
                    if (executeUpdate > 0) {
                        return true;//sucess
                    } else {
                        return false;//errorr modify,try again
                    }
                }
            }
            rs.close();
            pstmt.close();
            conn.close(); 
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean hrRegisterStaff(String username,String password,String name,String icNo,String bs, String allowance)throws RemoteException{
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/payroll_system_staff","root","root");
            System.out.println("Database Connected");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEE_Table WHERE Username = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                conn.commit();
                rs.close();
                pstmt.close();
                conn.close();
                return false;
            }
            else{
                PreparedStatement pstmt2 = conn.prepareStatement("INSERT INTO EMPLOYEE_Table (username, password, name,ic_no,bs,allowance) VALUES (?, ?, ?, ?, ?, ?)");
                pstmt2.setString(1, username);
                pstmt2.setString(2, password);
                pstmt2.setString(3, name);
                pstmt2.setString(4,icNo);
                pstmt2.setString(5, bs);
                pstmt2.setString(6,allowance);
                pstmt2.executeUpdate();
                conn.commit();
                pstmt2.close();
                conn.close();
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }
    public String[][] HRViewStaff()throws RemoteException{
        String[][] staffDataList = null;
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/payroll_system_staff", "root", "root");
            PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS rowCount FROM Employee_Table");
            ResultSet rs = pstmt.executeQuery();
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt("rowCount");
            }
            rs.close();
            pstmt.close();
            
            staffDataList = new String[rowCount][5];
            PreparedStatement pstmt2 = conn.prepareStatement("SELECT * FROM Employee_Table");
            ResultSet rs2 = pstmt2.executeQuery();
            int i=0;
            while (rs2.next()) {
                staffDataList[i][0] = rs2.getString("Username");                
                staffDataList[i][1] = rs2.getString("Name");
                staffDataList[i][2] = rs2.getString("IC_No"); 
                staffDataList[i][3] = rs2.getString("bs");                
                staffDataList[i][4] = rs2.getString("Allowance");
                i++;
            }
            rs2.close();
            pstmt2.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return staffDataList;
    }
    
    public boolean checkStaffUsername(String username)throws RemoteException{
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/payroll_system_staff","root","root");
            System.out.println("Database Connected");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEE_Table WHERE Username = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                conn.commit();
                rs.close();
                pstmt.close();
                conn.close();
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    @Override
    public boolean HRGeneratePayroll(String username,double lp,double ap)throws RemoteException{
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/payroll_system_staff","root","root");
            System.out.println("Database Connected");
            PreparedStatement pstmt = conn.prepareStatement("SELECT bs, allowance FROM EMPLOYEE_Table WHERE Username = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                double basicSalary = Double.parseDouble(rs.getString("bs"));
                double allowance = Double.parseDouble(rs.getString("allowance"));
                PreparedStatement pstmt2 = conn.prepareStatement("INSERT INTO Payroll_Table (username, BasicSalary, Allowance,AbsencePenalty,LatePenalty) VALUES (?, ?, ?, ?, ?)");
                pstmt2.setString(1, username);
                pstmt2.setDouble(2, basicSalary);
                pstmt2.setDouble(3, allowance);
                pstmt2.setDouble(4,ap);
                pstmt2.setDouble(5, lp);
                pstmt2.executeUpdate();
                conn.commit();
                rs.close();
                pstmt.close();
                pstmt2.close();
                conn.close();                
                System.out.println("hi");
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public String[][] HRViewPayroll()throws RemoteException, InterruptedException{
        String[][] staffDataList = null;
        try{
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/payroll_system_staff", "root", "root");
            PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS rowCount FROM Payroll_Table");
            ResultSet rs = pstmt.executeQuery();
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt("rowCount");
            }
            rs.close();
            pstmt.close();
            
            staffDataList = new String[rowCount][8];
            PreparedStatement pstmt2 = conn.prepareStatement("SELECT * FROM Payroll_Table");
            ResultSet rs2 = pstmt2.executeQuery();
            int i=0;
            while (rs2.next()) {
                double grossSalary = calgrossSalary(rs2.getDouble("BasicSalary"),rs2.getDouble("Allowance"));
                double netDeduction = calnetDeduct(rs2.getDouble("LatePenalty"),rs2.getDouble("AbsencePenalty"));
                staffDataList[i][0] = rs2.getString("Username");
                staffDataList[i][1] = Double.toString(rs2.getDouble("BasicSalary"));
                staffDataList[i][2] = Double.toString(rs2.getDouble("Allowance"));
                staffDataList[i][3] = Double.toString(grossSalary);
                staffDataList[i][4] = Double.toString(rs2.getDouble("LatePenalty"));
                staffDataList[i][5] = Double.toString(rs2.getDouble("AbsencePenalty"));
                staffDataList[i][6] = Double.toString(netDeduction);
                staffDataList[i][7] = Double.toString(grossSalary - netDeduction);
                i++;
            }
            rs2.close();
            pstmt2.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return staffDataList;
    }
    
    @Override
    public double calgrossSalary(double basicSalary,double allowance) throws RemoteException, InterruptedException{
        SalaryCalculator.grossPayCalculator gpThread = new SalaryCalculator.grossPayCalculator(basicSalary, allowance);
        gpThread.start();
        gpThread.join();
        return gpThread.getGrossPay();
    }
    
    @Override
    public double calnetDeduct(double absencePenalty,double latePenalty) throws RemoteException, InterruptedException{
        SalaryCalculator.netDeductCalculator ndThread = new SalaryCalculator.netDeductCalculator(absencePenalty, latePenalty);
        ndThread.start();
        ndThread.join();
        return ndThread.getNetDeduct();
    }
}
