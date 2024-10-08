/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samir Rojas
 */
public class HelperTest {
    
    public HelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of monthlyPayment method, of class Helper.
     */
    @Test
    public void testMonthlyPayment() {
        System.out.println("monthlyPayment");
        double amt = 240000;
        double yearlyInterestrate = 6.904;
        int numberofYears = 30;
        double expResult = 1581;
        double result = Helper.monthlyPayment(amt, yearlyInterestrate, numberofYears);
        assertEquals(expResult, result, 0);
    }
    
   /** Test for Zero Loan Amount */
    @Test
    public void testMonthlyPaymentZeroAmount() {
        System.out.println("monthlyPaymentZeroAmount");
        double amt = 0;
        double yearlyInterestrate = 5.0;
        int numberofYears = 30;
        double expResult = 0;
        double result = Helper.monthlyPayment(amt, yearlyInterestrate, numberofYears);
        assertEquals(expResult, result, 0);
    }
    
    /** Test for Zero Interest Rate */
    @Test
    public void testMonthlyPaymentZeroInterestRate() {
        System.out.println("monthlyPaymentZeroInterestRate");
        double amt = 100000;
        double yearlyInterestrate = 0.0;
        int numberofYears = 30;
        double expResult = amt / (numberofYears * 12); // No interest, just principal divided by months
        double result = Helper.monthlyPayment(amt, yearlyInterestrate, numberofYears);
        assertEquals(expResult, result, 0);
    }

    /** Test for High Interest Rate */
    @Test
    public void testMonthlyPaymentHighInterestRate() {
        System.out.println("monthlyPaymentHighInterestRate");
        double amt = 100000;
        double yearlyInterestrate = 99.0;
        int numberofYears = 30;
        double expResult = 8250;
        double result = Helper.monthlyPayment(amt, yearlyInterestrate, numberofYears);
        assertEquals(expResult, result, 0);
    }
    
    /** Test for one Year term */
    @Test
    public void testMonthlyPaymentOneYearTerm() {
        System.out.println("monthlyPaymentOneYearTerm");
        double amt = 100000;
        double yearlyInterestrate = 5.0;
        int numberofYears = 1;
        double expResult = 8560.75;
        double result = Helper.monthlyPayment(amt, yearlyInterestrate, numberofYears);
        assertEquals(expResult, result, 0);
    }

    /** Test for Negative Loan Amount (Boundary Case) */
    @Test
    public void testMonthlyPaymentShortTerm() {
        System.out.println("monthlyPaymentShortTerm");
        double amt = 50000;
        double yearlyInterestrate = 5.0;
        int numberofYears = 0; // Half a year (6 months)
        double expResult = 8455.28;
        double result = Helper.monthlyPayment(amt, yearlyInterestrate, numberofYears);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of validate method, of class Helper.
     */
    @Test
       public void testValidate() {
           System.out.println("validate");
           double amt = 0.0;
           double yearlyInterestrate = 0.0;
           int numberofYears = 0;
           boolean expResult = false;
           boolean result = Helper.validate(amt, yearlyInterestrate, numberofYears);
           assertEquals(expResult, result);
       }

    @Test
    public void testValidatePositiveValues() {
        System.out.println("validatePositiveValues");
        double amt = 1000.0;
        double yearlyInterestrate = 5.0;
        int numberofYears = 10;
        boolean expResult = true;
        boolean result = Helper.validate(amt, yearlyInterestrate, numberofYears);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateNegativeAmount() {
        System.out.println("validateNegativeAmount");
        double amt = -1000.0;
        double yearlyInterestrate = 5.0;
        int numberofYears = 10;
        boolean expResult = false;
        boolean result = Helper.validate(amt, yearlyInterestrate, numberofYears);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateZeroInterestRate() {
        System.out.println("validateZeroInterestRate");
        double amt = 1000.0;
        double yearlyInterestrate = 0.0;
        int numberofYears = 10;
        boolean expResult = false;
        boolean result = Helper.validate(amt, yearlyInterestrate, numberofYears);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateNegativeYears() {
        System.out.println("validateNegativeYears");
        double amt = 1000.0;
        double yearlyInterestrate = 5.0;
        int numberofYears = -10;
        boolean expResult = false;
        boolean result = Helper.validate(amt, yearlyInterestrate, numberofYears);
        assertEquals(expResult, result);
    }
}
 
