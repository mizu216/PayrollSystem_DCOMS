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
    public static AdminViewHRPage adminViewHRPage;
    public static AdminRegisterHRPage adminRegisterHRPage;
    public static HRMainPage hrMainPage;
    public static HRLoginPage hrLoginPage;
    public static HRUpdatePasswordPage hrUpdatePasswordPage;
    public static HRRegisterStaffPage hrRegisterStaffPage;
    public static MainPage mainPage;
    public static String loginUser = null;


    
    public static void main(String[] args) {
        adminLoginPage = new AdminLoginPage();
        adminMainPage = new AdminMainPage();
        adminViewHRPage = new AdminViewHRPage();
        adminRegisterHRPage = new AdminRegisterHRPage();
        hrMainPage = new HRMainPage();
        hrLoginPage = new HRLoginPage();
        hrUpdatePasswordPage = new HRUpdatePasswordPage();
        hrRegisterStaffPage = new HRRegisterStaffPage();
        mainPage = new MainPage();
    }
}
