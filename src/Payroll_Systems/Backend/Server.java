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
}
