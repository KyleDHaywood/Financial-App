import java.util.Scanner;

public class MortgageCalculator {

    public static double calculateMonthlyPayment(double principal, double annualInterestRate, int termInYears) {
        double monthlyInterestRate = annualInterestRate / 100 / 12;
        int numberOfPayments = termInYears * 12;
        
        return (principal * monthlyInterestRate) / 
               (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (in %): ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Enter the term in years: ");
        int termInYears = scanner.nextInt();

        double monthlyPayment = calculateMonthlyPayment(principal, annualInterestRate, termInYears);
        System.out.println("Monthly Payment: " + monthlyPayment);

        scanner.close();
    }
}