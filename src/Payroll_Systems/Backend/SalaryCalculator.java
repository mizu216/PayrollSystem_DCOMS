package Payroll_Systems.Backend;
public class SalaryCalculator {
    public static class grossPayCalculator extends Thread{
        private double bs;
        private double allowance; 
        private double grossPay;

        public grossPayCalculator(double bs, double allowance) {
            this.bs = bs;
            this.allowance = allowance;
        }
        
        public void run(){
            this.grossPay = this.bs + this.allowance ;
        }

        public double getGrossPay() {
            return grossPay;
        }
    }
    public static class netDeductCalculator extends Thread{
        private double absencePenalty;
        private double latePenalty;
        private double netDeduct;

        public netDeductCalculator(double absencePenalty, double latePenalty) {
            this.absencePenalty = absencePenalty;
            this.latePenalty = latePenalty;
        }

        
        
        public void run(){
            this.netDeduct = this.absencePenalty + this.latePenalty;
        }

        public double getNetDeduct() {
            return netDeduct;
        }
    }
}
