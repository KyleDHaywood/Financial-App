import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MortgageCalculatorWindow extends JFrame {

    private JTextField principalField;
    private JTextField interestRateField;
    private JTextField termField;
    private JLabel resultLabel;

    public MortgageCalculatorWindow() {
        setTitle("Mortgage Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JLabel principalLabel = new JLabel("Principal:");
        principalField = new JTextField(10);

        JLabel interestRateLabel = new JLabel("Annual Interest Rate (%):");
        interestRateField = new JTextField(10);

        JLabel termLabel = new JLabel("Term (years):");
        termField = new JTextField(10);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMonthlyPayment();
            }
        });

        resultLabel = new JLabel("Monthly Payment: ");

        JPanel panel = new JPanel();
        panel.add(principalLabel);
        panel.add(principalField);
        panel.add(interestRateLabel);
        panel.add(interestRateField);
        panel.add(termLabel);
        panel.add(termField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        add(panel);
    }

    private void calculateMonthlyPayment() {
        double principal = Double.parseDouble(principalField.getText());
        double annualInterestRate = Double.parseDouble(interestRateField.getText());
        int termInYears = Integer.parseInt(termField.getText());

        double monthlyPayment = MortgageCalculator.calculateMonthlyPayment(principal, annualInterestRate, termInYears);
        resultLabel.setText("Monthly Payment: " + monthlyPayment);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MortgageCalculatorWindow().setVisible(true);
            }
        });
    }
}

class MortgageCalculator {

    public static double calculateMonthlyPayment(double principal, double annualInterestRate, int termInYears) {
        double monthlyInterestRate = annualInterestRate / 100 / 12;
        int numberOfPayments = termInYears * 12;

        return (principal * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }
}