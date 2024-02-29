/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payroll_Systems.Backend;

import Payroll_Systems.Backend.Interface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
    
    public boolean adminRegisterHR(String Username,String Name,String Password,String icNo,String staffType){
        return false;
    
    }
}
