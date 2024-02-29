/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payroll_Systems.Backend;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author limzi
 */
public class RMIregistry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1044);
        reg.rebind("payroll", new Server());
    }
    
}
