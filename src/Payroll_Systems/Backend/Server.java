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
                conn.close();
                return 1;
            }
            if(icNo.length()!=12){
                conn.commit();
                conn.close();
                return 2;
            }
            else{
                long IcNum = Long.parseLong(icNo);
                PreparedStatement pstmt2 = conn.prepareStatement("INSERT INTO HR_Table (USERNAME, PASSWORD, NAME,IC_NO) VALUES (?, ?, ?, ?)");
                pstmt2.setString(1, username);
                pstmt2.setString(2, password);
                pstmt2.setString(3, name);
                pstmt2.setLong(4, IcNum);
                conn.commit();
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
            Integer.parseInt(numberString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
