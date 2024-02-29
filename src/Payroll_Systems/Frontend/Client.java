/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payroll_Systems.Frontend;

/**
 *
 * @author limzi
 */
public class Client {
    public static AdminLoginPage adminLoginPage;
    public static AdminMainPage adminMainPage;
    public static MainPage mainPage;

    
    public static void main(String[] args) {
        adminLoginPage = new AdminLoginPage();
        adminMainPage = new AdminMainPage();
        mainPage = new MainPage();
    }
}
