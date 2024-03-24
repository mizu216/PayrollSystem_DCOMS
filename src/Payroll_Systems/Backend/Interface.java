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
    public boolean adminRegisterHR(String username,String password,String name)throws RemoteException;
    public String[][] adminViewHR()throws RemoteException;
    public boolean hrLogin(String username, String password)throws RemoteException;
    public boolean hrUpdatePassword(String username, String oldPassword, String newPassword)throws RemoteException;
    public boolean hrRegisterStaff(String username,String password,String name,String icNo,String bs,String allowance)throws RemoteException;
    public String[][] HRViewStaff()throws RemoteException;
    public boolean checkStaffUsername(String username)throws RemoteException;
    public boolean HRGeneratePayroll(String username,double lp,double ap,int month,int year)throws RemoteException;
    public boolean hrUpdateSalary(String username, String bs, String allowance)throws RemoteException;
    public String[][] HRViewPayroll()throws RemoteException, InterruptedException;
    public double calgrossSalary(double basicSalary,double allowance) throws RemoteException, InterruptedException;
    public double calnetDeduct(double absencePenalty,double latePenalty) throws RemoteException, InterruptedException;
    public boolean employeeLogin(String username, String password)throws RemoteException;
    public boolean employeeUpdatePassword(String username, String oldPassword, String newPassword)throws RemoteException;
    public String[][] employeeViewPayroll(String Username)throws RemoteException, InterruptedException;
    public String[][] employeeViewStaff(String username)throws RemoteException;
}

//asdasda
