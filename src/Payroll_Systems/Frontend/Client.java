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
    public static AdminViewStaffPage adminViewStaffPage;
    public static AdminRegisterHRPage adminRegisterHRPage;
    public static HRMainPage hrMainPage;
    public static HRLoginPage hrLoginPage;
    public static HRUpdatePasswordPage hrUpdatePasswordPage;
    public static HRRegisterStaffPage hrRegisterStaffPage;
    public static HRViewStaffPage hrViewStaffPage;
    public static HRGeneratePayrollPage hrGeneratePayrollPage;
    public static HRViewPayrollPage hrViewPayrollPage;
    public static HRUpdateSalaryPage hrUpdateSalaryPage;
    public static EmployeeLoginPage employeeLoginPage;
    public static EmployeeMainPage employeeMainPage;
    public static EmployeeViewPersonalDetailPage employeeViewPersonalDetailPage;
    public static EmployeeUpdatePasswordPage employeeUpdatePasswordPage;
    public static EmployeeViewPayrollPage employeeViewPayrollPage;
    public static MainPage mainPage;
    public static String loginUser = null;

    public static void main(String[] args) {
        adminLoginPage = new AdminLoginPage();
        adminMainPage = new AdminMainPage();
        adminViewHRPage = new AdminViewHRPage();
        adminViewStaffPage = new AdminViewStaffPage();
        adminRegisterHRPage = new AdminRegisterHRPage();
        hrMainPage = new HRMainPage();
        hrLoginPage = new HRLoginPage();
        hrUpdatePasswordPage = new HRUpdatePasswordPage();
        hrRegisterStaffPage = new HRRegisterStaffPage();
        hrViewStaffPage = new HRViewStaffPage();
        hrGeneratePayrollPage = new HRGeneratePayrollPage();
        hrViewPayrollPage = new HRViewPayrollPage();
        hrUpdateSalaryPage = new HRUpdateSalaryPage();
        employeeLoginPage = new EmployeeLoginPage();
        employeeMainPage = new EmployeeMainPage();
        employeeViewPersonalDetailPage = new EmployeeViewPersonalDetailPage();
        employeeUpdatePasswordPage = new EmployeeUpdatePasswordPage();
        employeeViewPayrollPage = new EmployeeViewPayrollPage();
        mainPage = new MainPage();
    }
}