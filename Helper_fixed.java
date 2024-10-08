/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Samir Rojas
 */
public class Helper {    
    public static double monthlyPayment(double amt, double yearlyInterestrate, int numberofYears){
      // Convert annual interest rate to a monthly interest rate
        double monthlyInterestRate = yearlyInterestrate / 100 / 12;
        // Calculate the total number of payments
        int numberOfPayments = numberofYears * 12;

        // Calculate the monthly payment using the formula        
        double monthlyPayment;
        if (monthlyInterestRate == 0) {
             monthlyPayment = amt / numberOfPayments; // Simple division for zero interest
        } else {
        monthlyPayment = (amt * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                            / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
       }
        return (double)monthlyPayment;
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
}
