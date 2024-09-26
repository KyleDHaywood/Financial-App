/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Samir Rojas
 */
public class Helper {
    
    public static int addTwo(int a, int b){
        return a + b;
    }
    
    public static double monthlyPayment(double amt, double yearlyInterestrate, int numberofYears){
      // Convert annual interest rate to a monthly interest rate
        double monthlyInterestRate = yearlyInterestrate / 100 / 12;
        // Calculate the total number of payments
        int numberOfPayments = numberofYears * 12;

        // Calculate the monthly payment using the formula
        double monthlyPayment = (amt * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        return (int)monthlyPayment;
    }
    
    public static boolean validate(double amt, double yearlyInterestrate, int numberofYears){
            if (amt <= 0){
                System.out.println("Amount must be greater than 0.");
                return false;
    }
            if (yearlyInterestrate <= 0) {
                System.out.println("Yearly interest rate must be greater than 0.");
                return false;
    }
            if (numberofYears <= 0) {
                System.out.println("Number of years must be greater than 0.");
                return false;
    }
            return true;
}   

    
    public static boolean isPositive(int n){
        return n > 0;
    }
    
    public static int largest(int a, int b){
        if (a>b) return a;
        return b;
    }
}
