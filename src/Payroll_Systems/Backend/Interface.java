/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payroll_Systems.Backend;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author limzi
 */
public interface Interface extends Remote {
    public boolean adminLogin(String username, String password)throws RemoteException;
    public int adminRegisterHR(String username,String password,String name,String icNo)throws RemoteException;
    public String[][] adminViewHR()throws RemoteException;
    public boolean hrLogin(String username, String password)throws RemoteException;
    public boolean hrUpdatePassword(String username, String oldPassword, String newPassword)throws RemoteException;
    public boolean hrRegisterStaff(String username,String password,String name,String icNo,String bs,String hra, String da, String allowance, String otp)throws RemoteException;
}

//asdasda
