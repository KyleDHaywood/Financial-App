package javaapplication_x;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.util.Locale;
import java.text.DecimalFormat;
import org.json.JSONObject;

public class JavaApplication_X extends JFrame {
    private final Image backgroundImage;

    public JavaApplication_X() {
        // Load the background image
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/Main_background.png")).getImage();

        // Set up the JFrame
        setTitle("FinCalC Pro");
        setSize(1200, 800); // Set the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Add the custom panel with background image
        setContentPane(new ImagePanel());
    }

    private class ImagePanel extends JPanel {
        private final JButton startButton;
        private final JLabel fincalLabel;
        
        public ImagePanel(){
            setLayout(null); // Use null layout for absolute positioning
            
            // Initialize the "Start" button
            startButton = new JButton("Start");
            startButton.setBounds(850, 580, 180, 60); // Position and size of the button
            startButton.setBackground(new Color(169, 223, 191));// Set button color to green
            startButton.setForeground(Color.BLACK);
            startButton.setFont(new Font("Times New Roman", Font.BOLD, 28)); // Font name, style, size
            add(startButton); // Add button to the panel
            
            // Add action listener to the "Start" button
            startButton.addActionListener((ActionEvent e) -> {
                CategoricalCalcs calcFrame = new CategoricalCalcs();
                calcFrame.setVisible(true);
                // Close the current frame
                dispose();
            });
            // Initialize the "FINCAL PRO" label
            fincalLabel = new JLabel("FINCALC PRO");
            fincalLabel.setFont(new Font("Times New Roman", Font.BOLD, 72)); // Font name, style, size
            fincalLabel.setForeground(Color.WHITE); // Set label color to white
            fincalLabel.setBounds(50, 635, 500, 140); // Position and size of the label (adjust if needed)
            add(fincalLabel); // Add label to the panel
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
// New JFrame class for the categorical calcs
class CategoricalCalcs extends JFrame{
    private final Image backgroundImage;
    
    public CategoricalCalcs(){
        // Load the background image
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/categorical_img.png")).getImage();

        // Set up the JFrame   
        setTitle("Categorical Calcs");
        setSize(1200,800); // Set size of the new window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the 'X' is clicked
        setLocationRelativeTo(null); // Center the window
        
        //Add the custom panel with background image
        setContentPane(new ImagePanel());
    }
    
    private class ImagePanel extends JPanel{
        private final JButton autoButton;
        private final JButton retirementButton;
        private final JButton mortgageButton;
        private final JButton investmentButton;
        private final JButton currencyButton;
        private final JLabel autoImageLabel;
        private final JLabel retirementImageLabel;
        private final JLabel mortgageImageLabel;
        private final JLabel investmentImageLabel;
        private final JLabel currencyImageLabel;
        private final JButton backButton; // Back button
        
        public ImagePanel(){
            setLayout(null); // Use null layout for absolute positioning
            
            // Initiate the buttons
            autoButton = new JButton("Auto");
            retirementButton = new JButton("Retirement");
            mortgageButton = new JButton("Mortgage & Real Estate");
            investmentButton = new JButton("Investment");
            currencyButton = new JButton("Currency");
            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png"))); // Load back button image
            
            // Set bounds (position and size) for the buttons
            autoButton.setBounds(175, 420, 100, 40);
            retirementButton.setBounds(300, 495, 140, 40);
            mortgageButton.setBounds(470, 420, 220, 40);
            investmentButton.setBounds(725, 495, 140, 40);
            currencyButton.setBounds(890, 420, 140, 40);
            backButton.setBounds(20, 20, 80, 40); // Position the back button (adjust size as necessary)
            
            // Set button styles (Optional)
            Font buttonFont = new Font("Times New Roman", Font.BOLD, 16);
            autoButton.setFont(buttonFont);
            autoButton.setBackground(new Color(169, 223, 191));
            retirementButton.setFont(buttonFont);
            retirementButton.setBackground(new Color(169, 223, 191));
            mortgageButton.setFont(buttonFont);
            mortgageButton.setBackground(new Color(169, 223, 191));
            investmentButton.setFont(buttonFont);
            investmentButton.setBackground(new Color(169, 223, 191));
            currencyButton.setFont(buttonFont);
            currencyButton.setBackground(new Color(169, 223, 191));
                        
            // Add buttons to the panel
            add(autoButton);
            add(retirementButton);
            add(mortgageButton);
            add(investmentButton);
            add(currencyButton);
            //add(backButton);
            
            // Add action listeners for buttons (example for Auto button)
            autoButton.addActionListener(e -> {
                AutoCategory AutoCategoryFrame = new AutoCategory();
                AutoCategoryFrame.setVisible(true);
                dispose();
            });
            
            retirementButton.addActionListener(e -> {
                RetirementCategory RetirementCategoryFrame = new RetirementCategory();
                RetirementCategoryFrame.setVisible(true);
                dispose();
            });
            
            mortgageButton.addActionListener(e -> {
                MortgageAndRealCategory MortgageAndRealCategoryFrame = new MortgageAndRealCategory();
                MortgageAndRealCategoryFrame.setVisible(true);
                dispose();
            });
            
            investmentButton.addActionListener(e -> {
                InvestmentCategory InvestmentCategoryFrame = new InvestmentCategory();
                InvestmentCategoryFrame.setVisible(true);
                dispose();
            });
            
            // Add action listener for the Currency button to open CurrencyCalculator JFrame
            currencyButton.addActionListener(e -> {
                CurrencyCalculator currencyFrame = new CurrencyCalculator();
                currencyFrame.setVisible(true);
                dispose();
            });
            
            // Add action listener for the back button
            backButton.addActionListener(e -> {
                // Create a new instance of the main frame and make it visible
                JavaApplication_X mainFrame = new JavaApplication_X();
                mainFrame.setVisible(true);
                dispose(); // Closes the current frame
            });
            
            // Initialize and load the images into labels
            autoImageLabel = new JLabel(new ImageIcon(getClass().getResource("/javaapplication_x/images/auto_img.png")));
            retirementImageLabel = new JLabel(new ImageIcon(getClass().getResource("/javaapplication_x/images/retirement_img.png")));
            mortgageImageLabel = new JLabel(new ImageIcon(getClass().getResource("/javaapplication_x/images/mortgage&real_img.png")));
            investmentImageLabel = new JLabel(new ImageIcon(getClass().getResource("/javaapplication_x/images/investment_img.png")));
            currencyImageLabel = new JLabel(new ImageIcon(getClass().getResource("/javaapplication_x/images/currency_img.png")));
            
            // Set bounds for the image labels (position and size)
            autoImageLabel.setBounds(150, 315, 150, 100);
            retirementImageLabel.setBounds(300, 395, 150, 100);
            mortgageImageLabel.setBounds(500, 315, 150, 100);
            investmentImageLabel.setBounds(720, 400, 150, 100);
            currencyImageLabel.setBounds(880, 325, 150, 100);

            // Add image labels to the panel
            add(autoImageLabel);
            add(retirementImageLabel);
            add(mortgageImageLabel);
            add(investmentImageLabel);
            add(currencyImageLabel);
        }
       
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

// New JFrame class for the Auto Category
class AutoCategory extends JFrame{
    private final Image backgroundImage;
    
    public AutoCategory(){
        // Load the background Image
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/autocategory_background.jpg")).getImage();
        
        // Set up the JFrame
        setTitle("Auto Category");
        setSize(1200,800); // Set the size of the new window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the 'X' is clicked
        setLocationRelativeTo(null); // Center the window
        
        // Add the content panel with the background image
        setContentPane(new ImagePanel());
    }
    private class ImagePanel extends JPanel{
        private final JButton backButton;
        private final JLabel AutoLabel;
        private final JLabel AutoLoanLabel;
        
        public ImagePanel() {
            setLayout(null); // Use null layout for absolute positioning
            
            // Create a back button to return to the categorical page
            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png")));
            backButton.setBounds(20, 20, 80, 40); // Position the back button
            add(backButton);
            
            // Add action listener for the back button
            backButton.addActionListener(e -> {
                CategoricalCalcs categoricalFrame = new CategoricalCalcs();
                categoricalFrame.setVisible(true);
                dispose(); // Close the current frame
            });
            
            // Create a JLabel for the title "Auto"
            AutoLabel = new JLabel("Auto");
            AutoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 66)); // Set font
            AutoLabel.setForeground(Color.BLACK); // Set label color to white
            AutoLabel.setBounds(100, 200, 350, 100); // Position and size of the label
            add(AutoLabel); // Add label to the panel
            
            // Create the access to Auto Loan Calculator
            AutoLoanLabel = new JLabel("<html>&#8226; Auto Loan Calculator</html>");
            AutoLoanLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set font size and style
            AutoLoanLabel.setForeground(Color.BLACK); // Set text color
            AutoLoanLabel.setBounds(100, 350, 400, 50); // Adjust position and size
            
            // Add mouse listener to make the label look like a link on hover
            AutoLoanLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    // Change to link style when mouse hovers over
                    AutoLoanLabel.setText("<html><span style='color: blue; text-decoration: underline;'>&#8226; Auto Loan Calculator</span></html>");
                }
                @Override
                public void mouseExited(MouseEvent evt) {
                    // Revert to normal style when mouse exits
                    AutoLoanLabel.setText("<html>&#8226; Auto Loan Calculator </html>");
                }
                @Override
                public void mouseClicked(MouseEvent evt) {
                    Auto_loan_calculator Auto_loan_calculatorFrame = new Auto_loan_calculator();
                    Auto_loan_calculatorFrame.setVisible(true);
                    dispose();
                }
            });
            // Add the label to the panel
            add(AutoLoanLabel);
            
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

// New JFrame class for the Retirement Category
class RetirementCategory extends JFrame{
    private final Image  backgroundImage;
    
    public RetirementCategory(){
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/RetirementCategory_background.jpg")).getImage();
        
        // Set up the JFrame
        setTitle("Retirement Category");
        setSize(1200, 800); // Set the size of the new window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the 'X' is clicked
        setLocationRelativeTo(null); // Center the window

        // Add the content panel with the background image
        setContentPane(new ImagePanel());
        }
    private class ImagePanel extends JPanel{
        private final JButton backButton;
        private final JLabel RetirementLabel;
        private final JLabel RetirementCalculatorLabel;
        private final JLabel RothCalculatorLabel;
        
        public ImagePanel() {
            setLayout(null); // Use null layout for absolute positioning
            
            // Create a back button to return to the categorical page
            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png")));
            backButton.setBounds(20, 20, 80, 40); // Position the back button
            add(backButton);
            
            // Add action listener for the back button
            backButton.addActionListener(e -> {
                CategoricalCalcs categoricalFrame = new CategoricalCalcs();
                categoricalFrame.setVisible(true);
                dispose(); // Close the current frame
            });
            
            // Create a JLabel for the title "Retirement"
            RetirementLabel = new JLabel("Retirement");
            RetirementLabel.setFont(new Font("Times New Roman", Font.PLAIN, 66)); // Set font
            RetirementLabel.setForeground(Color.BLACK); // Set label color to white
            RetirementLabel.setBounds(100, 200, 350, 100); // Position and size of the label
            add(RetirementLabel); // Add label to the panel
            
            // Create the access to Retirement Calculator
            RetirementCalculatorLabel = new JLabel("<html>&#8226; Retirement Calculator</html>");
            RetirementCalculatorLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set font size and style
            RetirementCalculatorLabel.setForeground(Color.BLACK); // Set text color
            RetirementCalculatorLabel.setBounds(100, 340, 400, 50); // Adjust position and size
            
            // Add mouse listener to make the label look like a link on hover
            RetirementCalculatorLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    // Change to link style when mouse hovers over
                    RetirementCalculatorLabel.setText("<html><span style='color: blue; text-decoration: underline;'>&#8226; Retirement Calculator</span></html>");
                }
                @Override
                public void mouseExited(MouseEvent evt) {
                    // Revert to normal style when mouse exits
                    RetirementCalculatorLabel.setText("<html>&#8226; Retirement Calculator </html>");
                }
                @Override
                public void mouseClicked(MouseEvent evt) {
                    // Show message when clicked
                    JOptionPane.showMessageDialog(null, "Retirement Calculator will come soon");
                }
            });
            // Add the label to the panel
            add(RetirementCalculatorLabel); 
            
            // Create the access to Roth IRA Calculator
            RothCalculatorLabel = new JLabel("<html>&#8226; Roth IRA Calculator</html>");
            RothCalculatorLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set font size and style
            RothCalculatorLabel.setForeground(Color.BLACK); // Set text color
            RothCalculatorLabel.setBounds(100, 380, 400, 50); // Adjust position and size
            
            // Add mouse listener to make the label look like a link on hover
            RothCalculatorLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    // Change to link style when mouse hovers over
                    RothCalculatorLabel.setText("<html><span style='color: blue; text-decoration: underline;'>&#8226; Roth IRA Calculator</span></html>");
                }
                @Override
                public void mouseExited(MouseEvent evt) {
                    // Revert to normal style when mouse exits
                    RothCalculatorLabel.setText("<html>&#8226; Roth IRA Calculator </html>");
                }
                @Override
                public void mouseClicked(MouseEvent evt) {
                    // Show message when clicked
                    JOptionPane.showMessageDialog(null, "Roth IRA Calculator will come soon");
                }
            });
            // Add the label to the panel
            add(RothCalculatorLabel);
            
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

// New JFrame class for the Mortgage & Real Estate Category
class MortgageAndRealCategory extends JFrame{
    private final Image backgroundImage;
    
    public MortgageAndRealCategory(){
    // Load the background image
    backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/mortgage&real_background.jpg")).getImage();
    
    // Set up the JFrame
    setTitle("Mortgage & Real Estate Category");
    setSize(1200, 800); // Set the size of the new window
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the 'X' is clicked
    setLocationRelativeTo(null); // Center the window
    
    // Add the content panel with the background image
    setContentPane(new ImagePanel());
}
        private class ImagePanel extends JPanel {
        private final JButton backButton;
        private final JLabel Mortgage_RealLabel;
        private final JLabel rentBuyLabel;
        private final JLabel mortgagecalculatorLabel;
        private final JLabel houseaffordabilityLabel;
        private final JLabel rentcalculatorLabel;
        private final JLabel refinancecalculatorLabel;
        private final JLabel downpaymentcalcLabel;
        private final JLabel mortgagepayoffLabel;

        public ImagePanel() {
            setLayout(null); // Use null layout for absolute positioning

            // Create a back button to return to the categorical page
            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png")));
            backButton.setBounds(20, 20, 80, 40); // Position the back button
            add(backButton);
            
            // Add action listener for the back button
            backButton.addActionListener(e -> {
                CategoricalCalcs categoricalFrame = new CategoricalCalcs();
                categoricalFrame.setVisible(true);
                dispose(); // Close the current frame
            });
            
            // Create a JLabel for the title "Mortgage & Real Estate"
            Mortgage_RealLabel = new JLabel("<html>Mortgage &<br>Real Estate</html>");
            Mortgage_RealLabel.setFont(new Font("Times New Roman", Font.PLAIN, 60)); // Set font
            Mortgage_RealLabel.setForeground(Color.BLACK); // Set label color to white
            Mortgage_RealLabel.setBounds(100, 110, 350, 200); // Position and size of the label
            add(Mortgage_RealLabel); // Add label to the panel
            
            // Create the access to rentvsBuy Calculator
            rentBuyLabel = new JLabel("<html>&#8226; Rent vs. Buy Calculator</html>");
            rentBuyLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set font size and style
            rentBuyLabel.setForeground(Color.BLACK); // Set text color
            rentBuyLabel.setBounds(100, 350, 300, 50); // Adjust position and size
            
            // Add mouse listener to make the label look like a link on hover
            rentBuyLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    // Change to link style when mouse hovers over
                    rentBuyLabel.setText("<html><span style='color: blue; text-decoration: underline;'>&#8226; Rent vs. Buy Calculator</span></html>");
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    // Revert to normal style when mouse exits
                    rentBuyLabel.setText("<html>&#8226; Rent vs. Buy Calculator</html>");
                }

                @Override
                public void mouseClicked(MouseEvent evt) {
                    RentVsBuyCalculator RentVsBuyCalculatorFrame = new RentVsBuyCalculator();
                    RentVsBuyCalculatorFrame.setVisible(true);
                    dispose();
                }
            });
            // Add the label to the panel
            add(rentBuyLabel);
            
            // Create the access to mortgage Calculator
            mortgagecalculatorLabel = new JLabel("<html>&#8226; Mortgage Calculator</html>");
            mortgagecalculatorLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set font size and style
            mortgagecalculatorLabel.setForeground(Color.BLACK); // Set text color
            mortgagecalculatorLabel.setBounds(100, 390, 300, 50); // Adjust position and size
            
            // Add mouse listener to make the label look like a link on hover
            mortgagecalculatorLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    // Change to link style when mouse hovers over
                    mortgagecalculatorLabel.setText("<html><span style='color: blue; text-decoration: underline;'>&#8226; Mortgage Calculator</span></html>");
                }
                @Override
                public void mouseExited(MouseEvent evt) {
                    // Revert to normal style when mouse exits
                    mortgagecalculatorLabel.setText("<html>&#8226; Mortgage Calculator </html>");
                }
                @Override
                public void mouseClicked(MouseEvent evt) {
                    MortgageCalculator MortgageCalculatorFrame = new MortgageCalculator();
                    MortgageCalculatorFrame.setVisible(true);
                    dispose();
                }
            });
            // Add the label to the panel
            add(mortgagecalculatorLabel);
            
            // Create the access to House Affordability Calculator
            houseaffordabilityLabel = new JLabel("<html>&#8226; House Affordability Calculator</html>");
            houseaffordabilityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set font size and style
            houseaffordabilityLabel.setForeground(Color.BLACK); // Set text color
            houseaffordabilityLabel.setBounds(100, 440, 400, 50); // Adjust position and size
            
            // Add mouse listener to make the label look like a link on hover
            houseaffordabilityLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    // Change to link style when mouse hovers over
                    houseaffordabilityLabel.setText("<html><span style='color: blue; text-decoration: underline;'>&#8226; House Affordability Calculator</span></html>");
                }
                @Override
                public void mouseExited(MouseEvent evt) {
                    // Revert to normal style when mouse exits
                    houseaffordabilityLabel.setText("<html>&#8226; House Affordability Calculator </html>");
                }
                @Override
                public void mouseClicked(MouseEvent evt) {
                    // Open house affordability calculator
                    HouseAffordabilityCalc HouseAffordabilityCalcFrame = new HouseAffordabilityCalc();
                    HouseAffordabilityCalcFrame.setVisible(true);
                    dispose();
                }
            });
            // Add the label to the panel
            add(houseaffordabilityLabel);
            
            // Create the access to Rent Calculator
            rentcalculatorLabel = new JLabel("<html>&#8226; Rent Calculator</html>");
            rentcalculatorLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set font size and style
            rentcalculatorLabel.setForeground(Color.BLACK); // Set text color
            rentcalculatorLabel.setBounds(100, 490, 400, 50); // Adjust position and size
            
            // Add mouse listener to make the label look like a link on hover
            rentcalculatorLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    // Change to link style when mouse hovers over
                    rentcalculatorLabel.setText("<html><span style='color: blue; text-decoration: underline;'>&#8226; Rent Calculator</span></html>");
                }
                @Override
                public void mouseExited(MouseEvent evt) {
                    // Revert to normal style when mouse exits
                    rentcalculatorLabel.setText("<html>&#8226; Rent Calculator </html>");
                }
                @Override
                public void mouseClicked(MouseEvent evt) {
                    // Show message when clicked
                    JOptionPane.showMessageDialog(null, "Rent Calculator will come soon");
                }
            });
            // Add the label to the panel
            add(rentcalculatorLabel);
            
            // Create the access to Refinance Calculator
            refinancecalculatorLabel = new JLabel("<html>&#8226; Refinance Calculator</html>");
            refinancecalculatorLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set font size and style
            refinancecalculatorLabel.setForeground(Color.BLACK); // Set text color
            refinancecalculatorLabel.setBounds(100, 540, 400, 50); // Adjust position and size
            
            // Add mouse listener to make the label look like a link on hover
            refinancecalculatorLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    // Change to link style when mouse hovers over
                    refinancecalculatorLabel.setText("<html><span style='color: blue; text-decoration: underline;'>&#8226; Refinance Calculator</span></html>");
                }
                @Override
                public void mouseExited(MouseEvent evt) {
                    // Revert to normal style when mouse exits
                    refinancecalculatorLabel.setText("<html>&#8226; Refinance Calculator </html>");
                }
                @Override
                public void mouseClicked(MouseEvent evt) {
                    // Show message when clicked
                    JOptionPane.showMessageDialog(null, "Refinance Calculator will come soon");
                }
            });
            // Add the label to the panel
            add(refinancecalculatorLabel);
            
            // Create the access to Down Payment Calculator
            downpaymentcalcLabel = new JLabel("<html>&#8226; Down Payment Calculator</html>");
            downpaymentcalcLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set font size and style
            downpaymentcalcLabel.setForeground(Color.BLACK); // Set text color
            downpaymentcalcLabel.setBounds(100, 590, 400, 50); // Adjust position and size
            
            // Add mouse listener to make the label look like a link on hover
            downpaymentcalcLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    // Change to link style when mouse hovers over
                    downpaymentcalcLabel.setText("<html><span style='color: blue; text-decoration: underline;'>&#8226; Down Payment Calculator</span></html>");
                }
                @Override
                public void mouseExited(MouseEvent evt) {
                    // Revert to normal style when mouse exits
                    downpaymentcalcLabel.setText("<html>&#8226; Down Payment Calculator </html>");
                }
                @Override
                public void mouseClicked(MouseEvent evt) {
                    // Show message when clicked
                    JOptionPane.showMessageDialog(null, "Down Payment Calculator will come soon");
                }
            });
            // Add the label to the panel
            add(downpaymentcalcLabel);
            
            // Create the access to Mortgage Payoff Calculator
            mortgagepayoffLabel = new JLabel("<html>&#8226; Mortgage Payoff Calculator</html>");
            mortgagepayoffLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set font size and style
            mortgagepayoffLabel.setForeground(Color.BLACK); // Set text color
            mortgagepayoffLabel.setBounds(100, 640, 400, 50); // Adjust position and size
            
            // Add mouse listener to make the label look like a link on hover
            mortgagepayoffLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    // Change to link style when mouse hovers over
                    mortgagepayoffLabel.setText("<html><span style='color: blue; text-decoration: underline;'>&#8226; Mortgage Payoff Calculator</span></html>");
                }
                @Override
                public void mouseExited(MouseEvent evt) {
                    // Revert to normal style when mouse exits
                    mortgagepayoffLabel.setText("<html>&#8226; Mortgage Payoff Calculator </html>");
                }
                @Override
                public void mouseClicked(MouseEvent evt) {
                    // Show message when clicked
                    JOptionPane.showMessageDialog(null, "Mortgage Payoff Calculator will come soon");
                }
            });
            // Add the label to the panel
            add(mortgagepayoffLabel);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

// New JFrame class for the Investment Category
class InvestmentCategory extends JFrame{
    private final Image backgroundImage;
    
    public InvestmentCategory(){
        // Load the background Image
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/InvestmentCategory_background.jpg")).getImage();
        
        // Set up the JFrame
        setTitle("Investment Category");
        setSize(1200,800); // Set the size of the new window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window when the 'X' is clicked
        setLocationRelativeTo(null); // Center the window
        
        // Add the content panel with the background image
        setContentPane(new ImagePanel());
    }
    private class ImagePanel extends JPanel{
        private final JButton backButton;
        private final JLabel InvestmentLabel;
        private final JLabel InterestCalculatorLabel;
        
        public ImagePanel() {
            setLayout(null); // Use null layout for absolute positioning
            
            // Create a back button to return to the categorical page
            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png")));
            backButton.setBounds(20, 20, 80, 40); // Position the back button
            add(backButton);
            
            // Add action listener for the back button
            backButton.addActionListener(e -> {
                CategoricalCalcs categoricalFrame = new CategoricalCalcs();
                categoricalFrame.setVisible(true);
                dispose(); // Close the current frame
            });
            
            // Create a JLabel for the title "Investment"
            InvestmentLabel = new JLabel("Investment");
            InvestmentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 66)); // Set font
            InvestmentLabel.setForeground(Color.BLACK); // Set label color to white
            InvestmentLabel.setBounds(100, 200, 350, 100); // Position and size of the label
            add(InvestmentLabel); // Add label to the panel
            
            // Create the access to Interest Calculator
            InterestCalculatorLabel = new JLabel("<html>&#8226; Interest Calculator</html>");
            InterestCalculatorLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set font size and style
            InterestCalculatorLabel.setForeground(Color.BLACK); // Set text color
            InterestCalculatorLabel.setBounds(100, 350, 400, 50); // Adjust position and size
            
            // Add mouse listener to make the label look like a link on hover
            InterestCalculatorLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    // Change to link style when mouse hovers over
                    InterestCalculatorLabel.setText("<html><span style='color: blue; text-decoration: underline;'>&#8226; Interest Calculator</span></html>");
                }
                @Override
                public void mouseExited(MouseEvent evt) {
                    // Revert to normal style when mouse exits
                    InterestCalculatorLabel.setText("<html>&#8226; Interest Calculator </html>");
                }
                @Override
                public void mouseClicked(MouseEvent evt) {
                    // Show message when clicked
                    JOptionPane.showMessageDialog(null, "Interest Calculator will come soon");
                }
            });
            // Add the label to the panel
            add(InterestCalculatorLabel);
            
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

// New JFrame class for the Auto Loan calculator
class Auto_loan_calculator extends JFrame{
    private final Image backgroundImage;
    private final NumberFormat currencyFormat;
    private JLabel result_monthly_pay_Label;
    private JLabel results_Label;
    private JTextField loanAmountField;
    private JTextField interestRateField;
    private JTextField loanTermField;
    private JTextField CashIncentivesField;
    private JTextField downPaymentField;
    private JTextField TradeInField;
    private JTextField AmountOwedField;
    private JTextField SalesTaxField;
    private JTextField OtherFeeField;
   
    public Auto_loan_calculator() {
        // Load the background image
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/auto_loan_cal_background.jpg")).getImage();

        // Set up the JFrame
        setTitle("Auto Loan Calculator");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create currency formatter for USD
        currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
       
        // Add content to the JFrame (background panel)
        setContentPane(new ImagePanel());
    }

    // Inner class to handle the background image panel
    private class ImagePanel extends JPanel {
        private final JButton backButton;
        private final JLabel titleLabel;
        private final JLabel loanAmountLabel;
        private final JLabel interestRateLabel;
        private final JLabel loanTermLabel;
        private final JLabel CashIncentivesLabel;
        private final JLabel downPaymentLabel;
        private final JLabel TradeInLabel;
        private final JLabel AmountOwedLabel;
        private final JLabel SaleTaxLabel;
        private final JLabel otherFeeLabel;
        private final JButton calculateButton;
        private final JButton clearButton;

        public ImagePanel() {
            setLayout(null);

            // Back button setup
            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png")));
            backButton.setBounds(20, 20, 80, 40);
            add(backButton);
            backButton.addActionListener(e -> {
                CategoricalCalcs categoricalFrame = new CategoricalCalcs();
                categoricalFrame.setVisible(true);
                dispose();
            });

            // Title label setup
            titleLabel = new JLabel("Auto Loan Calculator");
            titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
            titleLabel.setForeground(Color.BLACK);
            titleLabel.setBounds(175, 10, 800, 200);
            add(titleLabel);
            
            result_monthly_pay_Label = new JLabel("Monthly Pay: ");
            result_monthly_pay_Label.setFont(new Font("Times New Roman", Font.BOLD, 36));
            result_monthly_pay_Label.setForeground(Color.WHITE);
            result_monthly_pay_Label.setBounds(580,190,500,40);
            add(result_monthly_pay_Label);

            // Loan Amount label and field setup
            loanAmountLabel = new JLabel("Auto Price");
            loanAmountLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            loanAmountLabel.setBounds(50, 200, 200, 40);
            add(loanAmountLabel);

            loanAmountField = new JTextField("$");
            loanAmountField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            loanAmountField.setBounds(320, 200, 200, 40);
            loanAmountField.addFocusListener(new CurrencyFormatFocusListener());
            add(loanAmountField);

            // Interest Rate label and field setup
            interestRateLabel = new JLabel("Interest Rate:");
            interestRateLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            interestRateLabel.setBounds(50, 250, 200, 40);
            add(interestRateLabel);

            interestRateField = new JTextField("                                             %");
            interestRateField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            interestRateField.setBounds(320, 250, 200, 40);
            // Add a FocusListener to manage the % symbol
            interestRateField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (interestRateField.getText().endsWith("%")) {
                        interestRateField.setText(interestRateField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!interestRateField.getText().isEmpty() && !interestRateField.getText().endsWith("%")) {
                        interestRateField.setText(interestRateField.getText().trim() + "%");
                    }
                }
            });
            add(interestRateField);

            // Loan Term label and field setup
            loanTermLabel = new JLabel("Loan Term (months): ");
            loanTermLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            loanTermLabel.setBounds(50, 300, 200, 40);
            add(loanTermLabel);

            loanTermField = new JTextField("");
            loanTermField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            loanTermField.setBounds(320, 300, 200, 40);
            add(loanTermField);
           
            //cash incentives label and field
            CashIncentivesLabel = new JLabel("Cash Incentives");
            CashIncentivesLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            CashIncentivesLabel.setBounds(50, 350, 200, 40);
            add(CashIncentivesLabel);

            CashIncentivesField = new JTextField("$");
            CashIncentivesField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            CashIncentivesField.setBounds(320, 350, 200, 40);
            CashIncentivesField.addFocusListener(new CurrencyFormatFocusListener());
            add(CashIncentivesField);
           
            //downpayment label and field
            downPaymentLabel = new JLabel("Down Payment");
            downPaymentLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            downPaymentLabel.setBounds(50, 400, 200, 40);
            add(downPaymentLabel);

            downPaymentField = new JTextField("$");
            downPaymentField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            downPaymentField.setBounds(320, 400, 200, 40);
            downPaymentField.addFocusListener(new CurrencyFormatFocusListener());
            add(downPaymentField);
           
            //tradeIn label and field
            TradeInLabel = new JLabel("Trade-In Value");
            TradeInLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            TradeInLabel.setBounds(50, 450, 200, 40);
            add(TradeInLabel);

            TradeInField = new JTextField("$");
            TradeInField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            TradeInField.setBounds(320, 450, 200, 40);
            TradeInField.addFocusListener(new CurrencyFormatFocusListener());
            add(TradeInField);
           
            //amountowed label and field
            AmountOwedLabel = new JLabel("<html>Amount Owed<br> on Trade-in</html>");
            AmountOwedLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            AmountOwedLabel.setBounds(50, 500, 200, 40);
            add(AmountOwedLabel);

            AmountOwedField = new JTextField("$");
            AmountOwedField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            AmountOwedField.setBounds(320, 500, 200, 40);
            AmountOwedField.addFocusListener(new CurrencyFormatFocusListener());
            add(AmountOwedField);
           
            //salesTax label and field
            SaleTaxLabel = new JLabel("Sales Tax");
            SaleTaxLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            SaleTaxLabel.setBounds(50, 550, 200, 40);
            add(SaleTaxLabel);

            SalesTaxField = new JTextField("                                             %");
            SalesTaxField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            SalesTaxField.setBounds(320, 550, 200, 40);
            SalesTaxField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (SalesTaxField.getText().endsWith("%")) {
                        SalesTaxField.setText(SalesTaxField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!SalesTaxField.getText().isEmpty() && !SalesTaxField.getText().endsWith("%")) {
                        SalesTaxField.setText(SalesTaxField.getText().trim() + "%");
                    }
                }
            });
            add(SalesTaxField);
            
            //fees label and field
            otherFeeLabel = new JLabel("<html>Title, Registration<br>and Other Fees</html>");
            otherFeeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            otherFeeLabel.setBounds(50, 600, 200, 40);
            add(otherFeeLabel);

            OtherFeeField = new JTextField("$");
            OtherFeeField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            OtherFeeField.setBounds(320, 600, 200, 40);
            OtherFeeField.addFocusListener(new CurrencyFormatFocusListener());
            add(OtherFeeField);
            
            //results labels with all
            results_Label = new JLabel("");
            results_Label.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            results_Label.setBounds(580,200,500,300);
            results_Label.setForeground(Color.BLACK);
            add(results_Label);
            
            // Calculate button setup
            calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            calculateButton.setBounds(120, 670, 175, 50);
            calculateButton.setBackground(new Color(169, 223, 191)); // Set background color to green
            add(calculateButton);
            calculateButton.addActionListener(e -> calculateMonthlyPayment());

            // Clear button setup
            clearButton = new JButton("Clear");
            clearButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            clearButton.setBounds(310, 670, 130, 50);
            clearButton.setForeground(Color.WHITE);
            clearButton.setBackground(Color.GRAY);
            add(clearButton);
            clearButton.addActionListener(e -> clearFields());

        }
        @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    // FocusListener to format JTextField input as currency on focus loss
    private class CurrencyFormatFocusListener extends FocusAdapter {
        @Override
        public void focusLost(FocusEvent e) {
            JTextField source = (JTextField) e.getSource();
            try {
                // Parse and format the value as currency
                double value = Double.parseDouble(source.getText().replace(",", "").replace("$", ""));
                source.setText(currencyFormat.format(value));
            } catch (NumberFormatException ex) {
                source.setText(""); // Clear field if input is invalid
            }
        }
    }

    // Method to remove dollar signs and commas for parsing
    private double parseDollarField(JTextField field) {
        return Double.parseDouble(field.getText().replaceAll("[$,]", ""));
    }

    // Method to remove percent signs for parsing
    private double parsePercentField(JTextField field) {
        return Double.parseDouble(field.getText().replace("%", ""));
    }

   // Method to calculate the monthly payment
// Method to calculate the monthly payment with input validation and error handling
private void calculateMonthlyPayment() {
    try {
        // Step 1: Retrieve and parse the input values with error handling
        double autoPrice = parseDollarField(loanAmountField);
        if (autoPrice <= 0) throw new IllegalArgumentException("Auto Price must be positive.");

        double loanTermMonths;
        try {
            loanTermMonths = Double.parseDouble(loanTermField.getText().trim());
            if (loanTermMonths <= 0) throw new IllegalArgumentException("Loan term must be a positive number of months.");
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Loan Term must be a valid integer.");
        }

        double annualInterestRate;
        try {
            annualInterestRate = parsePercentField(interestRateField);
            if (annualInterestRate < 0) throw new IllegalArgumentException("Interest Rate cannot be negative.");
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Interest Rate must be a valid number.");
        }

        double downPayment = parseDollarField(downPaymentField);
        double tradeInValue = parseDollarField(TradeInField);
        double amountOwedOnTradeIn = parseDollarField(AmountOwedField);

        double salesTaxRate;
        try {
            salesTaxRate = parsePercentField(SalesTaxField);
            if (salesTaxRate < 0) throw new IllegalArgumentException("Sales Tax Rate cannot be negative.");
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Sales Tax must be a valid number.");
        }

        double titleRegistrationFees = parseDollarField(OtherFeeField);
        double cashIncentives = parseDollarField(CashIncentivesField);

        // Step 2: Apply sales tax and other adjustments to calculate loan amount
        double autoLoanPayment = autoPrice - downPayment - tradeInValue + amountOwedOnTradeIn - cashIncentives;
        double salesTaxAmount = (autoPrice - tradeInValue) * (salesTaxRate / 100);
        double autoLoanPaymentFees = autoLoanPayment + salesTaxAmount + titleRegistrationFees;
        double totalLoanAmount = autoLoanPaymentFees;

        // Step 3: Monthly interest rate
        double monthlyInterestRate = (annualInterestRate / 100) / 12;

        // Step 4: Calculate monthly payment with fees included
        double paymentWithFees;
        if (monthlyInterestRate == 0) {
            paymentWithFees = autoLoanPaymentFees / loanTermMonths;
        } else {
            paymentWithFees = (autoLoanPaymentFees * monthlyInterestRate) /
                              (1 - Math.pow(1 + monthlyInterestRate, -loanTermMonths));
        }
        paymentWithFees = Math.round(paymentWithFees * 100) / 100.0;

        // Additional Calculations
        double totalPayments = paymentWithFees * loanTermMonths;  // Total of all monthly payments
        double totalLoanInterest = totalPayments - totalLoanAmount;  // Total interest paid
        double totalCost = autoPrice + totalLoanInterest + salesTaxAmount + titleRegistrationFees;  // Overall cost including interest, tax, and fees
        double upfrontPayment = downPayment;  // Upfront payment

        // Step 5: Display the results in the result label
        result_monthly_pay_Label.setText("Monthly Payment: " + currencyFormat.format(paymentWithFees));

        // Display additional results
        results_Label.setText(
            "<html>" +
            "<p>Total Loan Amount: " + currencyFormat.format(totalLoanAmount) + "</p>" +
            "<p>Sales Tax: " + currencyFormat.format(salesTaxAmount) + "</p>" +
            "<p>Upfront Payment: " + currencyFormat.format(upfrontPayment) + "</p>" +
            "<p>Total of " + (int)loanTermMonths + " Loan Payments: " + currencyFormat.format(totalPayments) + "</p>" +
            "<p>Total Loan Interest: " + currencyFormat.format(totalLoanInterest) + "</p>" +
            "<p>Total Cost (Price, Interest, Tax, Fees): " + currencyFormat.format(totalCost) + "</p>" +
            "</html>"
        );
    } catch (IllegalArgumentException ex) {
        // Display error message if any input is invalid
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        // Display general error message for unexpected exceptions
        JOptionPane.showMessageDialog(this, "An error occurred during calculation. Please check all inputs.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
    }
}
    // Method to clear the input fields
    private void clearFields() {
        loanAmountField.setText("$");
        interestRateField.setText("                                             %");
        loanTermField.setText("");
        result_monthly_pay_Label.setText("Monthly Pay: ");
        CashIncentivesField.setText("$");
        downPaymentField.setText("$");
        TradeInField.setText("$");
        AmountOwedField.setText("$");
        SalesTaxField.setText("                                             %");
        OtherFeeField.setText("$");
        results_Label.setText("");
    }
}


// New JFrame class for the currency calculator
class RentVsBuyCalculator extends JFrame{
    private final Image backgroundImage;
    private final NumberFormat currencyFormat;
    private JComboBox TaxStatusComboBox;
    private JTextField homePriceField, downPaymentField, interestRateField;
    private JTextField loanTermField, buyingClosingField, propertyTaxField;
    private JTextField propertyTaxIncreaseField, homeInsuranceField, HOAFeeField;
    private JTextField maintenanceCostField,homeValueField, CostIncreaseField, sellingCostsField;
    private JTextField monthlyRentalFeeField, rentalFeeIncreaseField, renterInsuranceField,securityDepositField, upfrontCostField;
    private JTextField averageReturnField, marginalFederalField,marginalStateField;
    private JButton calculateButton, clearButton;
    
    public RentVsBuyCalculator() {
       // Load the background image
       backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/RentVsBuyCalculator_background.jpg")).getImage();
       // Set up the JFrame
        setTitle("Rent Vs. Buy Calculator");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create currency formatter for USD
        currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
       
        // Add content to the JFrame (background panel)
        setContentPane(new ImagePanel());
    }
    
    // Inner class to handle the background image panel
    private class ImagePanel extends JPanel{
        private final JButton backButton;
        private final JLabel titleLabel, homePurchaseLabel, homeRentLabel, infoLabel;
        private final JLabel homePriceLabel, downPaymentLabel, interestRateLabel, loanTermLabel,
                buyingClosingLabel, propertyTaxLabel, propertyTaxIncreaseLabel, homeInsuranceLabel, HOAFeeLabel, maintenanceCostLabel,
                homeValueAppreciationLabel, costIncreaseLabel, sellingCostsLabel;
        private final JLabel monthlyRentalFeeLabel, rentalFeeIncreaseLabel, renterInsuranceLabel, securityDepositLabel, upfrontCostLabel;
        private final JLabel averageReturnLabel, marginalFederalLabel, marginalStateLabel, taxFilingLabel;
        
        
        private final String[] TaxStatusOptions = {
            "single", "married filing jointly",
            "married filing separately", "head of household",
            "qualified widow"
        }; 
        
        public ImagePanel(){
            setLayout(null);
            
            // Back button setup
            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png")));
            backButton.setBounds(20, 20, 80, 40);
            add(backButton);
            backButton.addActionListener(e -> {
                MortgageAndRealCategory MortgageAndRealCategoryFrame = new MortgageAndRealCategory();
                MortgageAndRealCategoryFrame.setVisible(true);
                dispose();
            });
            
            // Title label setup
            titleLabel = new JLabel("Rent Vs. Buy Calculator");
            titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
            titleLabel.setForeground(Color.BLACK);
            titleLabel.setBounds(175, 10, 800, 200);
            add(titleLabel);
            
            // Home purchase label setup
            homePurchaseLabel = new JLabel("Home Purchase");
            homePurchaseLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
            homePurchaseLabel.setForeground(Color.WHITE);
            homePurchaseLabel.setBounds(55,180,250,40);
            add(homePurchaseLabel);
            
            // Home Renr label setup
            homeRentLabel = new JLabel("Home Rent");
            homeRentLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
            homeRentLabel.setForeground(Color.WHITE);
            homeRentLabel.setBounds(590,180,250,40);
            add(homeRentLabel);
            
            // Your Information label setup
            infoLabel = new JLabel("Your Information");
            infoLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
            infoLabel.setForeground(Color.WHITE);
            infoLabel.setBounds(590,440,250,40);
            add(infoLabel);
            
            // home price label setup
            homePriceLabel = new JLabel("Home price");
            homePriceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            homePriceLabel.setForeground(Color.BLACK);
            homePriceLabel.setBounds(50,220,220,40);
            add(homePriceLabel);
            
            // down payment label setup
            downPaymentLabel = new JLabel("Down payment");
            downPaymentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            downPaymentLabel.setForeground(Color.BLACK);
            downPaymentLabel.setBounds(50,260,220,40);
            add(downPaymentLabel);
            
            // Interest rate label setup
            interestRateLabel = new JLabel("Interest rate");
            interestRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            interestRateLabel.setForeground(Color.BLACK);
            interestRateLabel.setBounds(50,300,220,40);
            add(interestRateLabel);
            
            // Loan term label setup
            loanTermLabel = new JLabel("Loan term");
            loanTermLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            loanTermLabel.setForeground(Color.BLACK);
            loanTermLabel.setBounds(50,340,220,40);
            add(loanTermLabel);
            
            // Buying closing costs label setup
            buyingClosingLabel = new JLabel("Buying closing costs");
            buyingClosingLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            buyingClosingLabel.setForeground(Color.BLACK);
            buyingClosingLabel.setBounds(50,380,220,40);
            add(buyingClosingLabel);
            
            // Property tax label setup
            propertyTaxLabel = new JLabel("Property Tax");
            propertyTaxLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            propertyTaxLabel.setForeground(Color.BLACK);
            propertyTaxLabel.setBounds(50,420,220,40);
            add(propertyTaxLabel);
            
            // property Tax Increase Label setup
            propertyTaxIncreaseLabel = new JLabel("Property tax increase");
            propertyTaxIncreaseLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            propertyTaxIncreaseLabel.setForeground(Color.BLACK);
            propertyTaxIncreaseLabel.setBounds(50,460,220,40);
            add(propertyTaxIncreaseLabel);
            
            // home insurance Label setup
            homeInsuranceLabel = new JLabel("Home insurance");
            homeInsuranceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            homeInsuranceLabel.setForeground(Color.BLACK);
            homeInsuranceLabel.setBounds(50,500,220,40);
            add(homeInsuranceLabel);
            
            // HOA Fee Label setup
            HOAFeeLabel = new JLabel("HOA fee");
            HOAFeeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            HOAFeeLabel.setForeground(Color.BLACK);
            HOAFeeLabel.setBounds(50,540,220,40);
            add(HOAFeeLabel);
            
            // maintenance Cost Label setup
            maintenanceCostLabel = new JLabel("Maintenance cost");
            maintenanceCostLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            maintenanceCostLabel.setForeground(Color.BLACK);
            maintenanceCostLabel.setBounds(50,580,220,40);
            add(maintenanceCostLabel);
            
            // home Value Appreciation Label setup
            homeValueAppreciationLabel = new JLabel("Home value appreciation");
            homeValueAppreciationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            homeValueAppreciationLabel.setForeground(Color.BLACK);
            homeValueAppreciationLabel.setBounds(50,620,220,40);
            add(homeValueAppreciationLabel);
            
            // cost Increase Label setup
            costIncreaseLabel = new JLabel("Cost/Insurance increase");
            costIncreaseLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            costIncreaseLabel.setForeground(Color.BLACK);
            costIncreaseLabel.setBounds(50,660,220,40);
            add(costIncreaseLabel);
            
            // selling Costs Label setup
            sellingCostsLabel = new JLabel("Selling closing costs");
            sellingCostsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            sellingCostsLabel.setForeground(Color.BLACK);
            sellingCostsLabel.setBounds(50,700,220,40);
            add(sellingCostsLabel);
            
            // monthly Rental Fee Label setup
            monthlyRentalFeeLabel = new JLabel("Monthly rental fee");
            monthlyRentalFeeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            monthlyRentalFeeLabel.setForeground(Color.BLACK);
            monthlyRentalFeeLabel.setBounds(590,220,220,40);
            add(monthlyRentalFeeLabel);
            
            // Rental Fee Increase Label setup
            rentalFeeIncreaseLabel = new JLabel("Rental fee increase");
            rentalFeeIncreaseLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            rentalFeeIncreaseLabel.setForeground(Color.BLACK);
            rentalFeeIncreaseLabel.setBounds(590,260,220,40);
            add(rentalFeeIncreaseLabel);
            
            // renter Insurance Label setup
            renterInsuranceLabel = new JLabel("Renter's insurance");
            renterInsuranceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            renterInsuranceLabel.setForeground(Color.BLACK);
            renterInsuranceLabel.setBounds(590,300,220,40);
            add(renterInsuranceLabel);
            
            // security Deposit Label setup
            securityDepositLabel = new JLabel("Security deposit");
            securityDepositLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            securityDepositLabel.setForeground(Color.BLACK);
            securityDepositLabel.setBounds(590,340,220,40);
            add(securityDepositLabel);
            
            // upfront Cost Label setup
            upfrontCostLabel = new JLabel("Upfront cost");
            upfrontCostLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            upfrontCostLabel.setForeground(Color.BLACK);
            upfrontCostLabel.setBounds(590,380,220,40);
            add(upfrontCostLabel);
            
            // average Return Label setup
            averageReturnLabel = new JLabel("Average investment return");
            averageReturnLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            averageReturnLabel.setForeground(Color.BLACK);
            averageReturnLabel.setBounds(590,480,250,40);
            add(averageReturnLabel);
            
            // marginal Federal Label setup
            marginalFederalLabel = new JLabel("Marginal federal tax rate");
            marginalFederalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            marginalFederalLabel.setForeground(Color.BLACK);
            marginalFederalLabel.setBounds(590,520,220,40);
            add(marginalFederalLabel);
            
            // marginal State Label setup
            marginalStateLabel = new JLabel("Marginal state tax return");
            marginalStateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            marginalStateLabel.setForeground(Color.BLACK);
            marginalStateLabel.setBounds(590,560,220,40);
            add(marginalStateLabel);
            
            // tax Filing Label setup
            taxFilingLabel = new JLabel("Tax filing status:");
            taxFilingLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            taxFilingLabel.setForeground(Color.BLACK);
            taxFilingLabel.setBounds(590,600,220,40);
            add(taxFilingLabel);
            
            // home price Field setup
            homePriceField = new JTextField("$0");
            homePriceField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            homePriceField.setBounds(320, 222, 200, 35);
           // homePriceField.setBackground(new Color(169,223,191)); // Set background color
            homePriceField.addFocusListener(new CurrencyFormatFocusListener());
            homePriceField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Clear field when focused if it's the default "$0"
                    if (homePriceField.getText().equals("$0")) {
                        homePriceField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Set default "$0" if field is left empty
                    if (homePriceField.getText().isEmpty()) {
                        homePriceField.setText("$0");
                    } else if (!homePriceField.getText().startsWith("$")) {
                        // Ensure field starts with "$" if not empty
                        homePriceField.setText("$" + homePriceField.getText().trim());
                    }
                }
            });
            add(homePriceField);
            
            // down payment Field setup
            downPaymentField = new JTextField("0%");
            downPaymentField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            downPaymentField.setBounds(320, 263, 200, 35);
          //  downPaymentField.setBackground(new Color(169,223,191));
            downPaymentField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Clear "%" when field is clicked for editing
                    if (downPaymentField.getText().equals("0%")) {
                        downPaymentField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Set default "0%" if field is left empty
                    if (downPaymentField.getText().isEmpty()) {
                        downPaymentField.setText("0%");
                    } else if (!downPaymentField.getText().endsWith("%")) {
                        // Append "%" if not empty and doesn't already end with "%"
                        downPaymentField.setText(downPaymentField.getText().trim() + "%");
                    }
                }
            });
            add(downPaymentField);
            
            // interest rate Field setup
            interestRateField = new JTextField("0%");
            interestRateField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            interestRateField.setBounds(320, 302, 200, 35);
           // interestRateField.setBackground(new Color(169,223,191));
            interestRateField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Clear "%" when field is clicked for editing
                if (interestRateField.getText().equals("0%")) {
                    interestRateField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Set default "0%" if field is left empty
                if (interestRateField.getText().isEmpty()) {
                    interestRateField.setText("0%");
                } else if (!interestRateField.getText().endsWith("%")) {
                    // Append "%" if not empty and doesn't already end with "%"
                    interestRateField.setText(interestRateField.getText().trim() + "%");
                }
            }
        });
        add(interestRateField);
        
        // loan term Field setup
        loanTermField = new JTextField("0");
        loanTermField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        loanTermField.setBounds(320, 342, 160, 35);
        //loanTermField.setBackground(new Color(169,223,191));
        loanTermField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
            // Clear field when focused if it's the default "$0"
            if (loanTermField.getText().equals("0")) {
                    loanTermField.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                // Set default "$0" if field is left empty
                if (loanTermField.getText().isEmpty()) {
                    loanTermField.setText("0");
                } else if (!loanTermField.getText().startsWith("")) {
                    // Ensure field starts with "$" if not empty
                    loanTermField.setText(loanTermField.getText().trim());
                }
            }
        });
        add(loanTermField);
            
        // property tax Field setup
        buyingClosingField = new JTextField("0%");
        buyingClosingField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        buyingClosingField.setBounds(320, 382, 160, 35);
        //buyingClosingField.setBackground(new Color(169,223,191));
        buyingClosingField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            // Clear "%" when field is clicked for editing
            if (buyingClosingField.getText().equals("0%")) {
                buyingClosingField.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            // Set default "0%" if field is left empty
            if (buyingClosingField.getText().isEmpty()) {
                buyingClosingField.setText("0%");
            } else if (!buyingClosingField.getText().endsWith("%")) {
                // Append "%" if not empty and doesn't already end with "%"
                buyingClosingField.setText(buyingClosingField.getText().trim() + "%");
                }
            }
        });
        add(buyingClosingField);
        
        // property tax Field setup
        propertyTaxField = new JTextField("0%");
        propertyTaxField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        propertyTaxField.setBounds(320, 422, 160, 35);
       // propertyTaxField.setBackground(new Color(169,223,191));
        propertyTaxField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            // Clear "%" when field is clicked for editing
            if (propertyTaxField.getText().equals("0%")) {
                propertyTaxField.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            // Set default "0%" if field is left empty
            if (propertyTaxField.getText().isEmpty()) {
                propertyTaxField.setText("0%");
            } else if (!propertyTaxField.getText().endsWith("%")) {
                // Append "%" if not empty and doesn't already end with "%"
                propertyTaxField.setText(propertyTaxField.getText().trim() + "%");
                }
            }
        });
        add(propertyTaxField);
        
        // property tax increase Field setup
        propertyTaxIncreaseField = new JTextField("0%");
        propertyTaxIncreaseField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        propertyTaxIncreaseField.setBounds(320, 462, 160, 35);
        //propertyTaxIncreaseField.setBackground(new Color(169,223,191));
        propertyTaxIncreaseField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            // Clear "%" when field is clicked for editing
            if (propertyTaxIncreaseField.getText().equals("0%")) {
                propertyTaxIncreaseField.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            // Set default "0%" if field is left empty
            if (propertyTaxIncreaseField.getText().isEmpty()) {
                propertyTaxIncreaseField.setText("0%");
            } else if (!propertyTaxIncreaseField.getText().endsWith("%")) {
                // Append "%" if not empty and doesn't already end with "%"
                propertyTaxIncreaseField.setText(propertyTaxIncreaseField.getText().trim() + "%");
                }
            }
        });
        add(propertyTaxIncreaseField);
        
        // home insurance Field setup
            homeInsuranceField = new JTextField("$0");
            homeInsuranceField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            homeInsuranceField.setBounds(320, 502, 160, 35);
            //homeInsuranceField.setBackground(new Color(169,223,191));
            homeInsuranceField.addFocusListener(new CurrencyFormatFocusListener());
            homeInsuranceField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Clear field when focused if it's the default "$0"
                    if (homeInsuranceField.getText().equals("$0")) {
                        homeInsuranceField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Set default "$0" if field is left empty
                    if (homeInsuranceField.getText().isEmpty()) {
                        homeInsuranceField.setText("$0");
                    } else if (!homeInsuranceField.getText().startsWith("$")) {
                        // Ensure field starts with "$" if not empty
                        homeInsuranceField.setText("$" + homeInsuranceField.getText().trim());
                    }
                }
            });
            add(homeInsuranceField);
            
        // home insurance Field setup
            HOAFeeField = new JTextField("$0");
            HOAFeeField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            HOAFeeField.setBounds(320, 542, 160, 35);
           // HOAFeeField.setBackground(new Color(169,223,191));
            HOAFeeField.addFocusListener(new CurrencyFormatFocusListener());
            HOAFeeField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Clear field when focused if it's the default "$0"
                    if (HOAFeeField.getText().equals("$0")) {
                        HOAFeeField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Set default "$0" if field is left empty
                    if (HOAFeeField.getText().isEmpty()) {
                        HOAFeeField.setText("$0");
                    } else if (!HOAFeeField.getText().startsWith("$")) {
                        // Ensure field starts with "$" if not empty
                        HOAFeeField.setText("$" + HOAFeeField.getText().trim());
                    }
                }
            });
            add(HOAFeeField);
        
        // maintenance cost Field setup
        maintenanceCostField = new JTextField("0%");
        maintenanceCostField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        maintenanceCostField.setBounds(320, 582, 160, 35);
        //maintenanceCostField.setBackground(new Color(169,223,191));
        maintenanceCostField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            // Clear "%" when field is clicked for editing
            if (maintenanceCostField.getText().equals("0%")) {
                maintenanceCostField.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            // Set default "0%" if field is left empty
            if (maintenanceCostField.getText().isEmpty()) {
                maintenanceCostField.setText("0%");
            } else if (!maintenanceCostField.getText().endsWith("%")) {
                // Append "%" if not empty and doesn't already end with "%"
                maintenanceCostField.setText(maintenanceCostField.getText().trim() + "%");
                }
            }
        });
        add(maintenanceCostField);    
        
        // Home value Field setup
        homeValueField = new JTextField("0%");
        homeValueField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        homeValueField.setBounds(320, 622, 160, 35);
        //homeValueField.setBackground(new Color(169,223,191));
        homeValueField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            // Clear "%" when field is clicked for editing
            if (homeValueField.getText().equals("0%")) {
                homeValueField.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            // Set default "0%" if field is left empty
            if (homeValueField.getText().isEmpty()) {
                homeValueField.setText("0%");
            } else if (!homeValueField.getText().endsWith("%")) {
                // Append "%" if not empty and doesn't already end with "%"
                homeValueField.setText(homeValueField.getText().trim() + "%");
                }
            }
        });
        add(homeValueField);
        
        // cost increase Field setup
        CostIncreaseField = new JTextField("0%");
        CostIncreaseField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        CostIncreaseField.setBounds(320, 662, 160, 35);
        //CostIncreaseField.setBackground(new Color(169,223,191));
        CostIncreaseField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            // Clear "%" when field is clicked for editing
            if (CostIncreaseField.getText().equals("0%")) {
                CostIncreaseField.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            // Set default "0%" if field is left empty
            if (CostIncreaseField.getText().isEmpty()) {
                CostIncreaseField.setText("0%");
            } else if (!CostIncreaseField.getText().endsWith("%")) {
                // Append "%" if not empty and doesn't already end with "%"
                CostIncreaseField.setText(CostIncreaseField.getText().trim() + "%");
                }
            }
        });
        add(CostIncreaseField);
        
        // selling costs Field setup
        sellingCostsField = new JTextField("0%");
        sellingCostsField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        sellingCostsField.setBounds(320, 702, 160, 35);
        //sellingCostsField.setBackground(new Color(169,223,191));
        sellingCostsField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            // Clear "%" when field is clicked for editing
            if (sellingCostsField.getText().equals("0%")) {
                sellingCostsField.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            // Set default "0%" if field is left empty
            if (sellingCostsField.getText().isEmpty()) {
                sellingCostsField.setText("0%");
            } else if (!sellingCostsField.getText().endsWith("%")) {
                // Append "%" if not empty and doesn't already end with "%"
                sellingCostsField.setText(sellingCostsField.getText().trim() + "%");
                }
            }
        });
        add(sellingCostsField);
        
        // monthly Rental Fee Field setup
            monthlyRentalFeeField = new JTextField("$0");
            monthlyRentalFeeField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            monthlyRentalFeeField.setBounds(840, 225, 160, 35);
           // monthlyRentalFeeField.setBackground(new Color(169,223,191));
            monthlyRentalFeeField.addFocusListener(new CurrencyFormatFocusListener());
            monthlyRentalFeeField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Clear field when focused if it's the default "$0"
                    if (monthlyRentalFeeField.getText().equals("$0")) {
                        monthlyRentalFeeField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Set default "$0" if field is left empty
                    if (monthlyRentalFeeField.getText().isEmpty()) {
                        monthlyRentalFeeField.setText("$0");
                    } else if (!monthlyRentalFeeField.getText().startsWith("$")) {
                        // Ensure field starts with "$" if not empty
                        monthlyRentalFeeField.setText("$" + monthlyRentalFeeField.getText().trim());
                    }
                }
            });
            add(monthlyRentalFeeField);
        
        // rental Fee Increase Field setup
        rentalFeeIncreaseField = new JTextField("0%");
        rentalFeeIncreaseField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        rentalFeeIncreaseField.setBounds(840, 265, 160, 35);
        //rentalFeeIncreaseField.setBackground(new Color(169,223,191));
        rentalFeeIncreaseField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            // Clear "%" when field is clicked for editing
            if (rentalFeeIncreaseField.getText().equals("0%")) {
                rentalFeeIncreaseField.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            // Set default "0%" if field is left empty
            if (rentalFeeIncreaseField.getText().isEmpty()) {
                rentalFeeIncreaseField.setText("0%");
            } else if (!rentalFeeIncreaseField.getText().endsWith("%")) {
                // Append "%" if not empty and doesn't already end with "%"
                rentalFeeIncreaseField.setText(rentalFeeIncreaseField.getText().trim() + "%");
                }
            }
        });
        add(rentalFeeIncreaseField);
            
        // renter Insurance Field setup
            renterInsuranceField = new JTextField("$0");
            renterInsuranceField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            renterInsuranceField.setBounds(840, 305, 160, 35);
           // renterInsuranceField.setBackground(new Color(169,223,191));
            renterInsuranceField.addFocusListener(new CurrencyFormatFocusListener());
            renterInsuranceField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Clear field when focused if it's the default "$0"
                    if (renterInsuranceField.getText().equals("$0")) {
                        renterInsuranceField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Set default "$0" if field is left empty
                    if (renterInsuranceField.getText().isEmpty()) {
                        renterInsuranceField.setText("$0");
                    } else if (!renterInsuranceField.getText().startsWith("$")) {
                        // Ensure field starts with "$" if not empty
                        renterInsuranceField.setText("$" + renterInsuranceField.getText().trim());
                    }
                }
            });
            add(renterInsuranceField);
        
        // security Deposit Field setup
            securityDepositField = new JTextField("$0");
            securityDepositField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            securityDepositField.setBounds(840, 345, 160, 35);
           // securityDepositField.setBackground(new Color(169,223,191));
            securityDepositField.addFocusListener(new CurrencyFormatFocusListener());
            securityDepositField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Clear field when focused if it's the default "$0"
                    if (securityDepositField.getText().equals("$0")) {
                        securityDepositField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Set default "$0" if field is left empty
                    if (securityDepositField.getText().isEmpty()) {
                        securityDepositField.setText("$0");
                    } else if (!securityDepositField.getText().startsWith("$")) {
                        // Ensure field starts with "$" if not empty
                        securityDepositField.setText("$" + securityDepositField.getText().trim());
                    }
                }
            });
            add(securityDepositField);
            
        // upfront Cost Field setup
            upfrontCostField = new JTextField("$0");
            upfrontCostField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
            upfrontCostField.setBounds(840, 385, 160, 35);
           // upfrontCostField.setBackground(new Color(169,223,191));
            upfrontCostField.addFocusListener(new CurrencyFormatFocusListener());
            upfrontCostField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Clear field when focused if it's the default "$0"
                    if (upfrontCostField.getText().equals("$0")) {
                        upfrontCostField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Set default "$0" if field is left empty
                    if (upfrontCostField.getText().isEmpty()) {
                        upfrontCostField.setText("$0");
                    } else if (!upfrontCostField.getText().startsWith("$")) {
                        // Ensure field starts with "$" if not empty
                        upfrontCostField.setText("$" + upfrontCostField.getText().trim());
                    }
                }
            });
            add(upfrontCostField);
        
        // average Return Field setup
        averageReturnField = new JTextField("0%");
        averageReturnField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        averageReturnField.setBounds(870, 485, 160, 35);
        //averageReturnField.setBackground(new Color(169,223,191));
        averageReturnField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            // Clear "%" when field is clicked for editing
            if (averageReturnField.getText().equals("0%")) {
                averageReturnField.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            // Set default "0%" if field is left empty
            if (averageReturnField.getText().isEmpty()) {
                averageReturnField.setText("0%");
            } else if (!averageReturnField.getText().endsWith("%")) {
                // Append "%" if not empty and doesn't already end with "%"
                averageReturnField.setText(averageReturnField.getText().trim() + "%");
                }
            }
        });
        add(averageReturnField);
        
        // marginal Federal Field setup
        marginalFederalField = new JTextField("0%");
        marginalFederalField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        marginalFederalField.setBounds(870, 525, 160, 35);
        //marginalFederalField.setBackground(new Color(169,223,191));
        marginalFederalField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            // Clear "%" when field is clicked for editing
            if (marginalFederalField.getText().equals("0%")) {
                marginalFederalField.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            // Set default "0%" if field is left empty
            if (marginalFederalField.getText().isEmpty()) {
                marginalFederalField.setText("0%");
            } else if (!marginalFederalField.getText().endsWith("%")) {
                // Append "%" if not empty and doesn't already end with "%"
                marginalFederalField.setText(marginalFederalField.getText().trim() + "%");
                }
            }
        });
        add(marginalFederalField);
        
        // marginal State Field setup
        marginalStateField = new JTextField("0%");
        marginalStateField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        marginalStateField.setBounds(870, 565, 160, 35);
        //marginalStateField.setBackground(new Color(169,223,191));
        marginalStateField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            // Clear "%" when field is clicked for editing
            if (marginalStateField.getText().equals("0%")) {
                marginalStateField.setText("");
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            // Set default "0%" if field is left empty
            if (marginalStateField.getText().isEmpty()) {
                marginalStateField.setText("0%");
            } else if (!marginalStateField.getText().endsWith("%")) {
                // Append "%" if not empty and doesn't already end with "%"
                marginalStateField.setText(marginalStateField.getText().trim() + "%");
                }
            }
        });
        add(marginalStateField);
        
        TaxStatusComboBox = new JComboBox<>(TaxStatusOptions);
        TaxStatusComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        TaxStatusComboBox.setBounds(590,635,240,35);
        add(TaxStatusComboBox);
        
        // Calculate button setup
        calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        calculateButton.setBounds(680, 690, 175, 50);
        calculateButton.setBackground(new Color(169, 223, 191)); // Set background color to green
        add(calculateButton);
        calculateButton.addActionListener(e -> calculateResults());

            // Clear button setup
        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        clearButton.setBounds(880, 690, 130, 50);
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.GRAY);
        add(clearButton);
        clearButton.addActionListener(e -> clearFields());
          
        }
        
        private void calculateResults(){
            
        }
        private void clearFields(){
        // Set up default empty or zero values
            TaxStatusComboBox.setSelectedIndex(0); // Unselect any option initially
            homePriceField.setText("");
            downPaymentField.setText("");
            interestRateField.setText("");
            loanTermField.setText("");
            buyingClosingField.setText("");
            propertyTaxField.setText("");
            propertyTaxIncreaseField.setText("");
            homeInsuranceField.setText("");
            HOAFeeField.setText("");
            maintenanceCostField.setText("");
            homeValueField.setText("");
            CostIncreaseField.setText("");
            sellingCostsField.setText("");
            monthlyRentalFeeField.setText("");
            rentalFeeIncreaseField.setText("");
            renterInsuranceField.setText("");
            securityDepositField.setText("");
            upfrontCostField.setText("");
            averageReturnField.setText("");
            marginalFederalField.setText("");
            marginalStateField.setText("");
    }
        
        @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
    }
// FocusListener to format JTextField input as currency on focus loss
    private class CurrencyFormatFocusListener extends FocusAdapter {
        @Override
        public void focusLost(FocusEvent e) {
            JTextField source = (JTextField) e.getSource();
            try {
                // Parse and format the value as currency
                double value = Double.parseDouble(source.getText().replace(",", "").replace("$", ""));
                source.setText(currencyFormat.format(value));
            } catch (NumberFormatException ex) {
                source.setText(""); // Clear field if input is invalid
            }
        }
    }
}

// New JFrame class for the curency calculator
class CurrencyCalculator extends JFrame{
    private final Image backgroundImage;
    
    private JTextField amountField;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JLabel resultsLabel;
    
    // Currency codes and names
    private final String[] currencyCodes = {
        "AUD: Australian Dollar", 
        "BRL: Brazilian Real", 
        "BTC: Bitcoin", 
        "CAD: Canadian Dollar", 
        "CHF: Swiss Franc", 
        "CNY: Chinese Yuan", 
        "EUR: Euro", 
        "GBP: British Pound", 
        "HKD: Hong Kong Dollar", 
        "INR: Indian Rupee", 
        "JPY: Japanese Yen", 
        "KRW: South Korean Won", 
        "MXN: Mexican Peso", 
        "RUB: Russian Ruble", 
        "SGD: Singapore Dollar", 
        "USD: United States Dollar", 
        "ZAR: South African Rand"
    };
    
    // Currency codes extracted from full names for conversion
    private final String[] currencyCodesOnly = {
        "AUD", "BRL", "BTC", "CAD", "CHF", "CNY", "EUR", "GBP", "HKD", 
        "INR", "JPY", "KRW", "MXN", "RUB", "SGD", "USD", "ZAR"
    };
    
    public CurrencyCalculator(){
        // Load the background image
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/currency_calculator_background.png")).getImage();

        // Set up the JFrame
        setTitle("Currency Calculator");
        setSize(1200,800); //Set sixe of the new window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Close only this window when the 'X' is clicked
        setLocationRelativeTo(null); // Center the window
        
        // Add content to the JFrame (background panel)
        setContentPane(new ImagePanel());
    }
    
    // Inner class to handle the background image panel
        private class ImagePanel extends JPanel {
            private final JButton backButton; // Back button
            private final JLabel titleLabel;
            private final JLabel resultsLabel;
            private final JLabel amountLabel;
            private final JLabel fromLabel;
            private final JLabel toLabel;
            private final JButton calculateButton;
            private final JButton clearButton;
            private final JLabel resultExchangeLabel;
            private final JLabel resultExchange2Label;
            private final JLabel timestampLabel;
            
            public ImagePanel() {
                setLayout(null); // Use null layout for custom positioning
                
                // Create a back button to come back to categorical page
                backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png"))); // Load back button image
                backButton.setBounds(20, 20, 80, 40); // Position the back button (adjust size as necessary)
                add(backButton);
                
                // Add action listener for the back button
            backButton.addActionListener(e -> {
                // Create a new instance of the CategoricalCalcs and make it visible
                CategoricalCalcs categoricalFrame = new CategoricalCalcs();
                categoricalFrame.setVisible(true);
                dispose(); // Closes the current frame
            });
                
                // Create and set up the JLabel
                titleLabel = new JLabel("Currency Calculator");
                titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 60)); // Set font
                titleLabel.setForeground(Color.BLACK); // Set label color to white
                titleLabel.setBounds(180, 70, 700, 100); // Position and size of the label
                add(titleLabel); // Add label to the panel
                
                // Create and set up the "Results" JLabel
                resultsLabel = new JLabel("Results");
                resultsLabel.setFont(new Font("Times New Roman", Font.BOLD, 34)); // Set font for results label
                resultsLabel.setForeground(Color.WHITE); // Set label color to white
                resultsLabel.setBounds(670, 218, 450, 30); // Position and size of the results label
                add(resultsLabel); // Add results label to the panel
                
                // Create and set up the "result Exhange" JLabel
                resultExchangeLabel = new JLabel("");
                resultExchangeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 34)); // Set for result exchange rate
                resultExchangeLabel.setForeground(Color.BLACK); // Set label color to white
                resultExchangeLabel.setBackground(new Color(184, 228, 202)); // Set background color
                resultExchangeLabel.setOpaque(true); // Make the Jlabel's background visible
                resultExchangeLabel.setBounds(660, 285, 510, 70); // Position and size of the results label
                add(resultExchangeLabel); // Add results label to the panel
                
                // Create and set up the "result Exhange" JLabel 2
                resultExchange2Label = new JLabel("");
                resultExchange2Label.setFont(new Font("Times New Roman", Font.PLAIN, 34)); // Set for result exchange rate
                resultExchange2Label.setForeground(Color.BLACK); // Set label color to white
                resultExchange2Label.setBackground(new Color(184, 228, 202)); // Set background color
                resultExchange2Label.setOpaque(true); // Make the Jlabel's background visible
                resultExchange2Label.setBounds(660, 355, 510, 70); // Position and size of the results label
                add(resultExchange2Label); // Add results label to the panel
                
                // Add a new JLabel for the timestamp
                timestampLabel = new JLabel("");
                timestampLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20)); // Set font and style
                timestampLabel.setForeground(Color.BLACK); // Set text color
                timestampLabel.setBounds(150, 710, 900, 60); // Position of the timestamp label
                add(timestampLabel); // Add timestamp label to the panel
                
                 // Create and set up the "Amount" JLabel
                amountLabel = new JLabel("Amount:");
                amountLabel.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
                amountLabel.setForeground(Color.BLACK); // Set label color to black
                amountLabel.setBounds(75, 250, 130, 30); // Position and size of the label
                add(amountLabel); // Add label to the panel
                
                // Create an input field for amount
                amountField = new JTextField();
                amountField.setFont(new Font("Times New Roman", Font.PLAIN, 32));
                amountField.setBounds(220, 250, 350, 40);
                add(amountField);

                // Create and set up the "From" JLabel
                fromLabel = new JLabel("From:");
                fromLabel.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
                fromLabel.setForeground(Color.BLACK); // Set label color to black
                fromLabel.setBounds(75, 350, 100, 30); // Position and size of the label
                add(fromLabel); // Add label to the panel
                
                // Create an input field from
                fromCurrencyComboBox = new JComboBox<>(currencyCodes);
                fromCurrencyComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 30));
                fromCurrencyComboBox.setBounds(220, 350, 350, 40);
                add(fromCurrencyComboBox);

                // Create and set up the "To" JLabel
                toLabel = new JLabel("To:");
                toLabel.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
                toLabel.setForeground(Color.BLACK); // Set label color to black
                toLabel.setBounds(75, 450, 100, 30); // Position and size of the label
                add(toLabel); // Add label to the panel
                
                // Create an input to
                toCurrencyComboBox = new JComboBox<>(currencyCodes);
                toCurrencyComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 30));
                toCurrencyComboBox.setBounds(220, 450, 350, 40);
                add(toCurrencyComboBox);

                // Create and set up the "Calculate" JButton
                calculateButton = new JButton("Calculate");
                calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
                calculateButton.setForeground(Color.BLACK); // Set text color to black
                calculateButton.setBackground(new Color(169, 223, 191)); // Set background color to green
                calculateButton.setBounds(150, 550, 200, 50); // Position and size of the button
                calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    performCurrencyConversion();
                    }
                });
                add(calculateButton); // Add button to the panel
                
                 // Create and set up the "Clear" JButton
                clearButton = new JButton("Clear");
                clearButton.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
                clearButton.setForeground(Color.WHITE); // Set text color to white
                clearButton.setBackground(Color.GRAY); // Set background color to gray
                clearButton.setBounds(400, 550, 150, 50); // Position and size of the button
                clearButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearFields(); // Call the clearFields method when clicked
                    }
                });
                add(clearButton); // Add button to the panel
}
                // Function for the currency calculator
                private void performCurrencyConversion() {
                    try {
                        String amountText = amountField.getText();
                        // Check if the amount is empty
                        if (amountText.trim().isEmpty()) {
                            showError("Please enter an amount.");
                            amountField.setForeground(Color.BLACK); // Change text color to red
                            return;
                        }

                        // Remove any spaces and replace comma with dot for parsing
                        amountText = amountText.trim().replace(',', '.');

                        // Attempt to parse the amount to a double
                        double amount = Double.parseDouble(amountText);
                        
                        // Check if the amount is negative
                        if (amount < 0) {
                            showError("Amount cannot be negative. Please enter a positive amount.");
                            amountField.setForeground(Color.BLACK); // Reset text color
                            return;
                        }

                        // Reset text color to black if input is valid
                        amountField.setForeground(Color.BLACK);

                        String fromCurrency = fromCurrencyComboBox.getSelectedItem().toString().split(":")[0];;
                        String toCurrency = toCurrencyComboBox.getSelectedItem().toString().split(":")[0];;

                        // Get the exchange rate from the Open Exchange Rates API
                        double exchangeRateFromTo = getExchangeRate(fromCurrency, toCurrency);
                        double exchangeRateToFrom = getExchangeRate(toCurrency, fromCurrency);

                        double convertedAmountFromTo = amount * exchangeRateFromTo;
                        double convertedAmountToFrom = amount * exchangeRateToFrom;

                        // Update the two labels for the conversion results
                        resultExchangeLabel.setText(String.format("<html>%.2f %s = <b><font color='green'>%.4f</font></b> %s</html>", amount, fromCurrency, convertedAmountFromTo, toCurrency));
                        resultExchange2Label.setText(String.format("<html>%.2f %s = <b><font color='green'>%.4f</font></b> %s</html>", amount, toCurrency, convertedAmountToFrom, fromCurrency));

                        // Get the current date and time
                        LocalDateTime currentDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM. dd, yyyy, HH:mm:ss");

                        // Format the date and time
                        String formattedDateTime = currentDateTime.format(formatter);

                        // Update the timestamp label with the current time and source
                        timestampLabel.setText("The results above are based on the " + formattedDateTime + " exchange rate from openexchangerates.org.");

                    } catch (NumberFormatException e) {
                        showError("Please enter a valid numerical amount. Correct format: 123.45");
                        amountField.setForeground(Color.BLACK); // Change text color to red
                    }
                }

// Method to show error messages
private void showError(String message) {
    JOptionPane.showMessageDialog(this, message, "Input Error", JOptionPane.ERROR_MESSAGE);
}
        private double getExchangeRate(String fromCurrency, String toCurrency) {
            try {
                // Replace 'YOUR_APP_ID' with your actual app id from Open Exchange Rates
                String apiKey = "d114504c41be44cf99274c2feca3856b";
                String urlString = String.format("https://openexchangerates.org/api/latest.json?app_id=" + apiKey);
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder jsonString = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    jsonString.append(line);
                }
                reader.close();

                JSONObject json = new JSONObject(jsonString.toString());
                double fromRate = json.getJSONObject("rates").getDouble(fromCurrency);
                double toRate = json.getJSONObject("rates").getDouble(toCurrency);
                return toRate / fromRate; // Calculate the exchange rate
            } catch (Exception e) {
                e.printStackTrace();
                return 0; // Return 0 if there's an error
            }
        }
        
        // Method to clear input fields and result label
        private void clearFields() {
            amountField.setText(""); // Clear the amount field
            fromCurrencyComboBox.setSelectedIndex(0); // Reset 'From' currency combo box
            toCurrencyComboBox.setSelectedIndex(0); // Reset 'To' currency combo box
            resultExchangeLabel.setText(""); // Reset the results label
            resultExchange2Label.setText(""); // Reset the results label
        }
        
       @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
    }
}

// New JFrame class for the Mortgage calculator
public class MortgageCalculator extends JFrame {
    private final Image backgroundImage;
    private final NumberFormat currencyFormat;
    private JTextField loanAmountField, interestRateField, loanTermField, downPaymentField, yearField;
    private JLabel monthlyPayResultLabel, HomePriceLabel,HomePriceResultLabel,resultLabel;
    private JComboBox symbolsComboBox, monthField;
    
    public MortgageCalculator() {
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/mortgageCalculator_background.png")).getImage();
        
        setTitle("Mortgage Calculator");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create currency formatter for USD
        currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        
        setContentPane(new ImagePanel());
    }

    private class ImagePanel extends JPanel {
        private final JButton backButton, calculateButton, clearButton;
        private final JLabel titleLabel, loanAmountLabel,downPaymentLabel, interestRateLabel, loanTermLabel, yearLabel, startDateLabel;
        
        // ComboBox symbols $ and % creation
            private final String[] symbolsOptions = {
                "%", "$"};
        
        // ComboBox for months
            private final String[] months = {
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
            };
            
            
        public ImagePanel() {
            setLayout(null);

            titleLabel = new JLabel("Mortgage Calculator");
            titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
            titleLabel.setForeground(Color.BLACK);
            titleLabel.setBounds(170, 50, 800, 200);
            add(titleLabel);

            loanAmountLabel = new JLabel("Home Price: ");
            loanAmountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            loanAmountLabel.setBounds(95, 250, 250, 40);
            add(loanAmountLabel);

            loanAmountField = new JTextField("$");
            loanAmountField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            loanAmountField.setBounds(300, 250, 200, 40);
            loanAmountField.addFocusListener(new CurrencyFormatFocusListener());
            add(loanAmountField);
            
            downPaymentLabel = new JLabel("Down Payment: ");
            downPaymentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            downPaymentLabel.setBounds(95, 310, 250, 40);
            add(downPaymentLabel);
            
            downPaymentField = new JTextField("                                    %");
            downPaymentField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            downPaymentField.setBounds(300, 310, 200, 40);
            // Add a FocusListener to manage the % symbol
            downPaymentField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (downPaymentField.getText().endsWith("%")) {
                        downPaymentField.setText(downPaymentField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!downPaymentField.getText().isEmpty() && !downPaymentField.getText().endsWith("%")) {
                        downPaymentField.setText(downPaymentField.getText().trim() + "%");
                    }
                }
            });
            add(downPaymentField);
            
            // ComboBox symbols for down payment
            symbolsComboBox = new JComboBox<>(symbolsOptions);
            symbolsComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            symbolsComboBox.setBounds(510, 310, 60, 40);
            add(symbolsComboBox);
            
            // ActionListener for ComboBox
            symbolsComboBox.addActionListener((ActionEvent e) -> {
                String selectedFormat = (String) symbolsComboBox.getSelectedItem();
                String text = downPaymentField.getText().replaceAll("[^\\d.]", ""); // Remove previous symbols

                try {
                    if ("%".equals(selectedFormat)) {
                        // Convert dollar amount to percentage based on loan amount
                        double loanAmount = Double.parseDouble(loanAmountField.getText().replace("$", "").replace(",", "").trim());
                        double value = text.isEmpty() ? 0 : Double.parseDouble(text);
                        double percentage = (value / loanAmount) * 100;
                        downPaymentField.setText(String.format("%.2f%%", percentage));
                    } else if ("$".equals(selectedFormat)) {
                        // Convert percentage to dollar amount based on loan amount
                        double loanAmount = Double.parseDouble(loanAmountField.getText().replace("$", "").replace(",", "").trim());
                        double percentageValue = text.isEmpty() ? 0 : Double.parseDouble(text);
                        double dollarValue = (percentageValue / 100) * loanAmount;
                        downPaymentField.setText(NumberFormat.getCurrencyInstance().format(dollarValue));
                    }
                } catch (NumberFormatException ex) {
                    downPaymentField.setText("0.00");
                }
            });

            // Add FocusListener to manage the % symbol
            downPaymentField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (downPaymentField.getText().endsWith("%")) {
                        downPaymentField.setText(downPaymentField.getText().replace("%", "").trim());
                    } else if (downPaymentField.getText().startsWith("$")) {
                        // Remove $ when field is clicked for editing
                        downPaymentField.setText(downPaymentField.getText().replace("$", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    String selectedFormat = (String) symbolsComboBox.getSelectedItem();
                    String text = downPaymentField.getText().replaceAll("[^\\d.]", "").trim();

                    if ("%".equals(selectedFormat) && !text.isEmpty()) {
                        // Append % when focus is lost and "%" is selected
                        downPaymentField.setText(text + "%");
                    } else if ("$".equals(selectedFormat) && !text.isEmpty()) {
                        // Format as currency with "$" symbol
                        double value = Double.parseDouble(text);
                        downPaymentField.setText(NumberFormat.getCurrencyInstance().format(value));
                    }
                }
            });
            
            loanTermLabel = new JLabel("Loan Term: ");
            loanTermLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            loanTermLabel.setBounds(95, 370, 250, 40);
            add(loanTermLabel);

            loanTermField = new JTextField();
            loanTermField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            loanTermField.setBounds(300, 370, 200, 40);
            add(loanTermField);
            
            yearLabel = new JLabel("years");
            yearLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            yearLabel.setBounds(510, 370, 100, 40);
            add(yearLabel);
            
            interestRateLabel = new JLabel("Interest Rate: ");
            interestRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            interestRateLabel.setBounds(95, 430, 250, 40);
            add(interestRateLabel);

            interestRateField = new JTextField("                                    %");
            interestRateField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            interestRateField.setBounds(300, 430, 200, 40);
            // Add a FocusListener to manage the % symbol
            interestRateField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (interestRateField.getText().endsWith("%")) {
                        interestRateField.setText(interestRateField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!interestRateField.getText().isEmpty() && !interestRateField.getText().endsWith("%")) {
                        interestRateField.setText(interestRateField.getText().trim() + "%");
                    }
                }
            });
            add(interestRateField);
            
            startDateLabel = new JLabel("Start Date ");
            startDateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            startDateLabel.setBounds(95, 490, 250, 40);
            add(startDateLabel);
            
            monthField = new JComboBox<>(months);
            monthField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            monthField.setBounds(300, 490, 80, 40);
            add(monthField);
            
            yearField = new JTextField("");
            yearField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            yearField.setBounds(400, 490, 80, 40);
            add(yearField);
            
            calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 32));
            calculateButton.setForeground(Color.BLACK); // Set text color to black
            calculateButton.setBackground(new Color(169, 223, 191)); // Set background color to green
            calculateButton.setBounds(130, 600, 230, 60); // Position and size of the button
            calculateButton.addActionListener(e -> calculateMonthlyPayment());
            add(calculateButton); // Add button to the panel

            clearButton = new JButton("Clear");
            clearButton.setFont(new Font("Times New Roman", Font.PLAIN, 32)); // Set font
            clearButton.setForeground(Color.WHITE); // Set text color to white
            clearButton.setBackground(Color.GRAY); // Set background color to gray
            clearButton.setBounds(390, 600, 140, 60);
            add(clearButton);
            clearButton.addActionListener(e -> clearFields());

            monthlyPayResultLabel = new JLabel("Monthly Payment: ");
            monthlyPayResultLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
            monthlyPayResultLabel.setBounds(640, 240, 520, 50);
            monthlyPayResultLabel.setForeground(Color.WHITE);
            monthlyPayResultLabel.setBackground(Color.WHITE);
            add(monthlyPayResultLabel);
            
            HomePriceLabel = new JLabel(" Home Price");
            HomePriceLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
            HomePriceLabel.setBackground(new Color(169, 223,191));
            HomePriceLabel.setOpaque(true); // Make label opaque to show background color
            HomePriceLabel.setBounds(630, 320, 300, 50);
            HomePriceLabel.setForeground(Color.BLACK);
            add(HomePriceLabel);
            
            HomePriceResultLabel = new JLabel("");
            HomePriceResultLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            HomePriceResultLabel.setBackground(new Color(169, 223,191));
            HomePriceResultLabel.setOpaque(true); // Make label opaque to show background color
            HomePriceResultLabel.setBounds(955, 320, 195, 50);
            HomePriceResultLabel.setForeground(Color.BLACK);
            add(HomePriceResultLabel);
            
            resultLabel = new JLabel("<html>"
                    + "Loan Amount:<br><br>"
                    + "Down Payment:<br><br>"
                    + "Total of # Mortgage Payments: <br><br>"
                    + "Total Interest:<br><br>"
                    + "Mortgage Payoff Date:"
                    + "</html>");
            resultLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            resultLabel.setBounds(630, 340, 520, 300);
            add(resultLabel);

            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png")));
            backButton.setBounds(20, 20, 80, 40);
            add(backButton);
            backButton.addActionListener(e -> {
                MortgageAndRealCategory MortgageAndRealCategoryFrame = new MortgageAndRealCategory();
                MortgageAndRealCategoryFrame.setVisible(true);
                dispose();
            });
        }
        
        // FocusListener to format JTextField input as currency on focus loss
        private class CurrencyFormatFocusListener extends FocusAdapter {
            @Override
            public void focusLost(FocusEvent e) {
                JTextField source = (JTextField) e.getSource();
                try {
                    // Parse and format the value as currency
                    double value = Double.parseDouble(source.getText().replace(",", "").replace("$", ""));
                    source.setText(currencyFormat.format(value));
                } catch (NumberFormatException ex) {
                    source.setText(""); // Clear field if input is invalid
                }
            }
        }
 
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    private void calculateMonthlyPayment() {
    try {
        // Validate loan amount field
        if (loanAmountField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Loan Amount field is empty. Please enter a value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double loanAmount = Double.parseDouble(loanAmountField.getText().replaceAll("[$,]", ""));
        if (loanAmount <= 0) {
            JOptionPane.showMessageDialog(this, "Loan Amount must be a positive number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate interest rate field
        if (interestRateField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Interest Rate field is empty. Please enter a value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double interestRate = Double.parseDouble(interestRateField.getText().replaceAll("[%]", "")) / 100;
        if (interestRate < 0) {
            JOptionPane.showMessageDialog(this, "Interest Rate cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate loan term field
        if (loanTermField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Loan Term field is empty. Please enter a value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int loanTermYears = Integer.parseInt(loanTermField.getText());
        if (loanTermYears <= 0) {
            JOptionPane.showMessageDialog(this, "Loan Term must be a positive number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int loanTermMonths = loanTermYears * 12;

        // Validate down payment field
        if (downPaymentField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Down Payment field is empty. Please enter a value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String downPaymentText = downPaymentField.getText();
        double downPaymentAmount = 0.0;

        if (downPaymentText.endsWith("%")) {
            double downPaymentPercentage = Double.parseDouble(downPaymentText.replace("%", "").trim());
            if (downPaymentPercentage < 0) {
                JOptionPane.showMessageDialog(this, "Down Payment percentage cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            downPaymentAmount = loanAmount * (downPaymentPercentage / 100);
        } else if (downPaymentText.startsWith("$")) {
            downPaymentAmount = Double.parseDouble(downPaymentText.replaceAll("[$,]", "").trim());
            if (downPaymentAmount < 0) {
                JOptionPane.showMessageDialog(this, "Down Payment amount cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Calculate loan amount after down payment
        double loanAmountAfterDownPayment = loanAmount - downPaymentAmount;

        // Monthly interest rate
        double monthlyInterestRate = interestRate / 12;

        // Monthly payment calculation
        double monthlyPayment;
        if (monthlyInterestRate > 0) {
            monthlyPayment = (loanAmountAfterDownPayment * monthlyInterestRate) /
                    (1 - Math.pow(1 + monthlyInterestRate, -loanTermMonths));
        } else {
            monthlyPayment = loanAmountAfterDownPayment / loanTermMonths;
        }

        // Total interest and final payoff date
        double totalPayment = monthlyPayment * loanTermMonths;
        double totalInterest = totalPayment - loanAmountAfterDownPayment;
        String payoffDate = "In " + loanTermYears + " years";

        // Display the formatted result with HTML layout
        resultLabel.setText("<html>"
                + "Loan Amount: " + currencyFormat.format(loanAmount) + "<br><br>"
                + "Down Payment: " + currencyFormat.format(downPaymentAmount) + "<br><br>"
                + "Total of " + loanTermMonths + " Mortgage Payments: " + currencyFormat.format(totalPayment) + "<br><br>"
                + "Total Interest: " + currencyFormat.format(totalInterest) + "<br><br>"
                + "Mortgage Payoff Date: " + payoffDate
                + "</html>");
                
        // Update the monthly payment label specifically
        monthlyPayResultLabel.setText("Monthly Payment: " + currencyFormat.format(monthlyPayment));
        HomePriceResultLabel.setText(" " + currencyFormat.format(loanAmount));

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid input detected. Please ensure all fields contain valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    private void clearFields() {
        loanAmountField.setText("");
        interestRateField.setText("");
        loanTermField.setText("");
        resultLabel.setText("<html>"
                    + "Loan Amount:<br><br>"
                    + "Down Payment:<br><br>"
                    + "Total of # Mortgage Payments: <br><br>"
                    + "Total Interest:<br><br>"
                    + "Mortgage Payoff Date:"
                    + "</html>");
        downPaymentField.setText("                                    %");
        yearField.setText("");
        HomePriceResultLabel.setText("");
        symbolsComboBox.setSelectedIndex(0);
        monthField.setSelectedIndex(0);
        monthlyPayResultLabel.setText("Monthly Payment: ");
    }
}


// New JFrame class for the House Affordability calculator
class HouseAffordabilityCalc extends JFrame{
    private final Image backgroundImage;
    private final NumberFormat currencyFormat;
    
    public HouseAffordabilityCalc(){
        // Load the background Image
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/houseaffordability_background.png")).getImage();
        
        // Set up the JFrame
        setTitle("House Affordability Calculator");
        setSize(1200,800); //Set sixe of the new window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Close only this window when the 'X' is clicked
        setLocationRelativeTo(null); // Center the window
        
        // Create currency formatter for USD
        currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        
        // Add content to the JFrame (background panel)
        setContentPane(new ImagePanel());
    }
        private class ImagePanel extends JPanel{
            private final JButton backButton;
            private final JLabel HouseAffordabilityLabel;
            private final JLabel mortgageRateLabel;
            
            // Create JLabels for various inputs
            private final JLabel incomeLabel;
            private final JLabel loanTermLabel;
            private final JLabel interestRateLabel;
            private final JLabel debtPaybackLabel;
            private final JLabel downPaymentLabel;
            private final JLabel propertyTaxLabel;
            private final JLabel hoaFeeLabel;
            private final JLabel insuranceLabel;
            private final JLabel dtiRatioLabel;
            
            // Create JTextFields for user input
            private final JTextField incomeField;
            private final JTextField loanTermField;
            private final JTextField interestRateField;
            private final JTextField debtPaybackField;
            private final JTextField downPaymentField;
            private final JTextField propertyTaxField;
            private final JTextField hoaFeeField;
            private final JTextField insuranceField;
            private final JComboBox<String> dtiRatioComboBox;
            private final JButton calculateButton;
            private final JButton clearButton;
            private final JComboBox<String> symbolsComboBox;
            private final JComboBox<String> symbolsComboBox2;
            private final JComboBox<String> symbolsComboBox3;
            private final JComboBox<String> symbolsComboBox4;
            
            // Addtional Jlabels
            private final JLabel salaryLabel;
            private final JLabel yearsLabel;
            private final JLabel longTermDebtLabel;
            private final JLabel perYearLabel1;
            private final JLabel perYearLabel2;
            private final JLabel perYearLabel3;
            
            // DTI Ratio options
            private final String[] dtiRatioOptions = {
                "Conventional loan (28/36 rule)",
            "FHA loan (31% front-end, 43% back-end)",
            "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%"
            };
            
            // ComboBox symbols $ and % creation
            private final String[] symbolsOptions = {
                "%", "$"};
            
            public ImagePanel(){
                setLayout(null); // Use null layout for absolute positioning

            // Create a back button to return to the categorical page
            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png")));
            backButton.setBounds(20, 20, 80, 40); // Position the back button
            add(backButton);
            
            // Create and set up the "Calculate" JButton
                calculateButton = new JButton("Calculate");
                calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
                calculateButton.setForeground(Color.BLACK); // Set text color to black
                calculateButton.setBackground(new Color(169, 223, 191)); // Set background color to green
                calculateButton.setBounds(200, 680, 250, 60); // Position and size of the button
                calculateButton.addActionListener(new CalculateButtonListener());
                add(calculateButton); // Add button to the panel
                
                 // Create and set up the "Clear" JButton
                clearButton = new JButton("Clear");
                clearButton.setFont(new Font("Times New Roman", Font.PLAIN, 32)); // Set font
                clearButton.setForeground(Color.WHITE); // Set text color to white
                clearButton.setBackground(Color.GRAY); // Set background color to gray
                clearButton.setBounds(500, 680, 150, 60); // Position and size of the button
                clearButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearFields(); // Call the clearFields method when clicked
                    }
                });
                add(clearButton); // Add button to the panel
            
            // Add action listener for the back button
            backButton.addActionListener(e -> {
                MortgageAndRealCategory MortgageAndRealCategoryFrame = new MortgageAndRealCategory();
                MortgageAndRealCategoryFrame.setVisible(true);
                dispose(); // Close the current frame
            });
            
            // Create a JLabel for the title "House Affordability Calculator"
            HouseAffordabilityLabel = new JLabel("House Affordability Calculator");
            HouseAffordabilityLabel.setFont(new Font("Times New Roman", Font.BOLD, 60)); // Set font
            HouseAffordabilityLabel.setForeground(Color.BLACK); // Set label color to white
            HouseAffordabilityLabel.setBounds(150, 15, 800, 200); // Position and size of the label
            add(HouseAffordabilityLabel); // Add label to the panel
            
            // Create a Jlabel for the latest mortgage rate
            mortgageRateLabel = new JLabel("<html>"
        + "<b><span style='font-size:26px;'>Latest Mortgage</span></b><br>"
        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><span style='font-size:26px;'>Rate:</span></b><br>"
        + "&nbsp;&nbsp;&nbsp;&nbsp;30 Years: <span style='color:3161b7; text-decoration:underline;'>6.727%</span><br>"
        + "&nbsp;&nbsp;&nbsp;&nbsp;15 Years: <span style='color:3161b7; text-decoration:underline;'>6.079%</span><br>"
        + "&nbsp;&nbsp;&nbsp;&nbsp;10 Years: <span style='color:3161b7; text-decoration:underline;'>6.021%</span>"
        + "</html>");
            mortgageRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set font
            mortgageRateLabel.setForeground(Color.BLACK); // Set label color to white
            mortgageRateLabel.setBounds(920, 65, 300, 400); // Position and size of the label
            add(mortgageRateLabel); // Add label to the panel
            
            // Create JLabels for other fields
            incomeLabel = new JLabel("<html><b><span style='font-size:16px;'>Annual household income</span></b></html>");
            incomeLabel.setBounds(35, 200, 400, 40); // Adjust position
            add(incomeLabel);

            loanTermLabel = new JLabel("<html><b><span style='font-size:16px;'>Mortgage loan term</span></b></html>");
            loanTermLabel.setBounds(35, 250, 400, 40); // Adjust position
            add(loanTermLabel);

            interestRateLabel = new JLabel("<html><b><span style='font-size:16px;'>Interest Rate</span></b></html>");
            interestRateLabel.setBounds(35, 300, 400, 40); // Adjust position
            add(interestRateLabel);

            debtPaybackLabel = new JLabel("<html><b><span style='font-size:16px;'>Monthly debt payback</span></b></html>");
            debtPaybackLabel.setBounds(35, 350, 400, 40); // Adjust position
            add(debtPaybackLabel);
            
            downPaymentLabel = new JLabel("<html><b><span style='font-size:16px;'>Down Payment</span></b></html>");
            downPaymentLabel.setBounds(35, 400, 400, 40); // Adjust position
            add(downPaymentLabel);

            propertyTaxLabel = new JLabel("<html><b><span style='font-size:16px;'>Property Tax</span></b></html>");
            propertyTaxLabel.setBounds(35, 450, 400, 40); // Adjust position
            add(propertyTaxLabel);

            hoaFeeLabel = new JLabel("<html><b><span style='font-size:16px;'>HOA or co-op fee</span></b></html>");
            hoaFeeLabel.setBounds(35, 500, 400, 40); // Adjust position
            add(hoaFeeLabel);

            insuranceLabel = new JLabel("<html><b><span style='font-size:16px;'>Insurance</span></b></html>");
            insuranceLabel.setBounds(35, 550, 400, 40); // Adjust position
            add(insuranceLabel);

            dtiRatioLabel = new JLabel("<html><b><span style='font-size:16px;'>Debt-to-income (DTI) ratio</span></b></html>");
            dtiRatioLabel.setBounds(35, 600, 400, 40); // Adjust position
            add(dtiRatioLabel);
            
            // Additional Labels
            salaryLabel = new JLabel("salary + other incomes (before tax)");
            salaryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            salaryLabel.setBounds(610, 200, 350, 40);
            add(salaryLabel);

            yearsLabel = new JLabel("years");
            yearsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            yearsLabel.setBounds(610, 250, 200, 40);
            add(yearsLabel);

            longTermDebtLabel = new JLabel("long-term debts, car, student loan, etc");
            longTermDebtLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
            longTermDebtLabel.setBounds(610, 350, 350, 40);
            add(longTermDebtLabel);

            perYearLabel1 = new JLabel("per year");
            perYearLabel1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            perYearLabel1.setBounds(675, 450, 200, 40);
            add(perYearLabel1);

            perYearLabel2 = new JLabel("per year");
            perYearLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            perYearLabel2.setBounds(675, 500, 200, 40);
            add(perYearLabel2);

            perYearLabel3 = new JLabel("per year");
            perYearLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            perYearLabel3.setBounds(675, 550, 200, 40);
            add(perYearLabel3);
            
            // Create JTextFields for user input next to the corresponding JLabels
            incomeField = new JTextField("$");
            incomeField.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            incomeField.setBounds(400, 200, 200, 40); // Position next to incomeLabel
            incomeField.addFocusListener(new CurrencyFormatFocusListener());
            add(incomeField);

            loanTermField = new JTextField();
            loanTermField.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            loanTermField.setBounds(400, 250, 200, 40); // Position next to loanTermLabel
            add(loanTermField);

            interestRateField = new JTextField("                                    %");
            interestRateField.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            interestRateField.setBounds(400, 300, 200, 40); // Position next to interestRateLabel
            
        // Add a FocusListener to manage the % symbol
        interestRateField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Remove % when field is clicked for editing
                if (interestRateField.getText().endsWith("%")) {
                    interestRateField.setText(interestRateField.getText().replace("%", "").trim());
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Append % when focus is lost
                if (!interestRateField.getText().isEmpty() && !interestRateField.getText().endsWith("%")) {
                    interestRateField.setText(interestRateField.getText().trim() + "%");
                }
            }
        });
            add(interestRateField);

            debtPaybackField = new JTextField("$");
            debtPaybackField.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            debtPaybackField.setBounds(400, 350, 200, 40); // Position next to debtPaybackLabel
            debtPaybackField.addFocusListener(new CurrencyFormatFocusListener());
            add(debtPaybackField);

            downPaymentField = new JTextField();
            downPaymentField.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            downPaymentField.setBounds(400, 400, 200, 40); // Position next to downPaymentLabel
            add(downPaymentField);
            
            // ComboBox symbols for down payment
            symbolsComboBox = new JComboBox<>(symbolsOptions);
            symbolsComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            symbolsComboBox.setBounds(605, 400, 60, 40);
            add(symbolsComboBox);
            
            // ActionListener for ComboBox
            symbolsComboBox.addActionListener((ActionEvent e) -> {
                String selectedFormat = (String) symbolsComboBox.getSelectedItem();
                String text = downPaymentField.getText().replaceAll("[^\\d.]", ""); // Remove previous symbols
                
                if ("%".equals(selectedFormat)) {
                    downPaymentField.setText(text + "%");
                } else if ("$".equals(selectedFormat)) {
                    double value = text.isEmpty() ? 0 : Double.parseDouble(text);
                    downPaymentField.setText(NumberFormat.getCurrencyInstance().format(value));
                }
                });

            // Add FocusListener to downPaymentField
            downPaymentField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    String selectedFormat = (String) symbolsComboBox.getSelectedItem();
                    String text = downPaymentField.getText().replaceAll("[^\\d.]", ""); // Remove symbols

                    if ("%".equals(selectedFormat) && !text.isEmpty()) {
                        // Append % when focus is lost and "%" is selected
                        downPaymentField.setText(text + "%");
                    } else if ("$".equals(selectedFormat) && !text.isEmpty()) {
                        // Format as currency with "$" symbol
                        double value = Double.parseDouble(text);
                        downPaymentField.setText(NumberFormat.getCurrencyInstance().format(value));
                    }
                }
            });

            propertyTaxField = new JTextField();
            propertyTaxField.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            propertyTaxField.setBounds(400, 450, 200, 40); // Position next to propertyTaxLabel
            add(propertyTaxField);
            
            // ComboBox symbols for property Tax field
            symbolsComboBox2 = new JComboBox<>(symbolsOptions);
            symbolsComboBox2.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            symbolsComboBox2.setBounds(605, 450, 60, 40);
            add(symbolsComboBox2);
            
            // ActionListener for ComboBox
            symbolsComboBox2.addActionListener((ActionEvent e) -> {
                String selectedFormat = (String) symbolsComboBox2.getSelectedItem();
                String text = propertyTaxField.getText().replaceAll("[^\\d.]", ""); // Remove previous symbols
                
                if ("%".equals(selectedFormat)) {
                    propertyTaxField.setText(text + "%");
                } else if ("$".equals(selectedFormat)) {
                    double value = text.isEmpty() ? 0 : Double.parseDouble(text);
                    propertyTaxField.setText(NumberFormat.getCurrencyInstance().format(value));
                }
                });

            // Add FocusListener to downPaymentField
            propertyTaxField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    String selectedFormat = (String) symbolsComboBox2.getSelectedItem();
                    String text = propertyTaxField.getText().replaceAll("[^\\d.]", ""); // Remove symbols

                    if ("%".equals(selectedFormat) && !text.isEmpty()) {
                        // Append % when focus is lost and "%" is selected
                        propertyTaxField.setText(text + "%");
                    } else if ("$".equals(selectedFormat) && !text.isEmpty()) {
                        // Format as currency with "$" symbol
                        double value = Double.parseDouble(text);
                        propertyTaxField.setText(NumberFormat.getCurrencyInstance().format(value));
                    }
                }
            });

            hoaFeeField = new JTextField();
            hoaFeeField.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            hoaFeeField.setBounds(400, 500, 200, 40); // Position next to hoaFeeLabel
            add(hoaFeeField);
            
            // ComboBox symbols for hoa fee
            symbolsComboBox3 = new JComboBox<>(symbolsOptions);
            symbolsComboBox3.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            symbolsComboBox3.setBounds(605, 500, 60, 40);
            add(symbolsComboBox3);
            
            // ActionListener for ComboBox
            symbolsComboBox3.addActionListener((ActionEvent e) -> {
                String selectedFormat = (String) symbolsComboBox3.getSelectedItem();
                String text = hoaFeeField.getText().replaceAll("[^\\d.]", ""); // Remove previous symbols
                
                if ("%".equals(selectedFormat)) {
                    hoaFeeField.setText(text + "%");
                } else if ("$".equals(selectedFormat)) {
                    double value = text.isEmpty() ? 0 : Double.parseDouble(text);
                    hoaFeeField.setText(NumberFormat.getCurrencyInstance().format(value));
                }
                });
            // Add FocusListener to hoaFeeField
            hoaFeeField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    String selectedFormat = (String) symbolsComboBox3.getSelectedItem();
                    String text = hoaFeeField.getText().replaceAll("[^\\d.]", ""); // Remove symbols

                    if ("%".equals(selectedFormat) && !text.isEmpty()) {
                        // Append % when focus is lost and "%" is selected
                        hoaFeeField.setText(text + "%");
                    } else if ("$".equals(selectedFormat) && !text.isEmpty()) {
                        // Format as currency with "$" symbol
                        double value = Double.parseDouble(text);
                        hoaFeeField.setText(NumberFormat.getCurrencyInstance().format(value));
                    }
                }
            });
            
            insuranceField = new JTextField();
            insuranceField.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            insuranceField.setBounds(400, 550, 200, 40); // Position next to insuranceLabel
            add(insuranceField);
            
            // ComboBox symbols for Insurance
            symbolsComboBox4 = new JComboBox<>(symbolsOptions);
            symbolsComboBox4.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            symbolsComboBox4.setBounds(605, 550, 60, 40);
            add(symbolsComboBox4);
            
            // ActionListener for ComboBox
            symbolsComboBox4.addActionListener((ActionEvent e) -> {
                String selectedFormat = (String) symbolsComboBox4.getSelectedItem();
                String text = insuranceField.getText().replaceAll("[^\\d.]", ""); // Remove previous symbols
                
                if ("%".equals(selectedFormat)) {
                    insuranceField.setText(text + "%");
                } else if ("$".equals(selectedFormat)) {
                    double value = text.isEmpty() ? 0 : Double.parseDouble(text);
                    insuranceField.setText(NumberFormat.getCurrencyInstance().format(value));
                }
                });
            
            // Add FocusListener to hoaFeeField
            insuranceField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    String selectedFormat = (String) symbolsComboBox4.getSelectedItem();
                    String text = insuranceField.getText().replaceAll("[^\\d.]", ""); // Remove symbols

                    if ("%".equals(selectedFormat) && !text.isEmpty()) {
                        // Append % when focus is lost and "%" is selected
                        insuranceField.setText(text + "%");
                    } else if ("$".equals(selectedFormat) && !text.isEmpty()) {
                        // Format as currency with "$" symbol
                        double value = Double.parseDouble(text);
                        insuranceField.setText(NumberFormat.getCurrencyInstance().format(value));
                    }
                }
            });
            
            dtiRatioComboBox = new JComboBox<>(dtiRatioOptions);
            dtiRatioComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            dtiRatioComboBox.setBounds(400, 600, 350, 40); // Position next to dtiRatioLabel
            add(dtiRatioComboBox);
            
            }
        private class CalculateButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
    try {
        // Extract only numeric values from the input fields
        double annualIncome = parseDouble(incomeField.getText());
        double loanTerm = parseDouble(loanTermField.getText());
        double interestRate = parseDouble(interestRateField.getText());
        double hoaFee = parseDouble(hoaFeeField.getText());
        double insurance = parseDouble(insuranceField.getText());
        
        // Get property tax input based on selected symbol in symbolsComboBox2
        String propertyTaxText = propertyTaxField.getText().trim();
        String selectedPropertyTaxFormat = (String) symbolsComboBox2.getSelectedItem();
        double propertyTax;

        if ("%".equals(selectedPropertyTaxFormat)) {
            // Parse property tax as a percentage
            double propertyTaxPercent = parseDouble(propertyTaxText.replace("%", "").trim());
            propertyTax = propertyTaxPercent / 1200; // Convert annual percentage to monthly rate
        } else if ("$".equals(selectedPropertyTaxFormat)) {
            // Parse property tax as an annual dollar amount
            propertyTax = parseDouble(propertyTaxText.replace("$", "").replace(",", "").trim()) / 12; // Convert annual dollar to monthly rate
        } else {
            propertyTax = 0; // Fallback in case no valid option is selected
        }
        
        // Adjust input values
        interestRate /= 1200;       // Convert annual rate to monthly
        insurance /= 1200;          // Convert annual insurance rate to monthly
        hoaFee /= 1200;             // Convert HOA fees to monthly
        loanTerm *= 12;             // Convert loan term to months
        
         // Get selected DTI ratio from ComboBox and parse percentage value
            String selectedDtiOption = (String) dtiRatioComboBox.getSelectedItem();
            double dtiRatio = 0.28; // Default to 28% for Conventional loan

            if (selectedDtiOption.equals("Conventional loan (28/36 rule)")) {
                dtiRatio = 0.28;
            } else if (selectedDtiOption.equals("FHA loan (31% front-end, 43% back-end)")) {
                dtiRatio = 0.31;
            } else if (selectedDtiOption.endsWith("%")) {
                dtiRatio = parseDouble(selectedDtiOption.replace("%", "").trim()) / 100;
            }
        
        // Calculate monthly income and maximum monthly housing cost (40% of income)
        double monthlyIncome = annualIncome / 12;
        double monthlyCost = monthlyIncome * dtiRatio;

        // Check down payment field input (percentage or dollar amount)
        String downPaymentText = downPaymentField.getText().trim();
        double downPaymentAmount;
        double fullPrice;
        boolean isPercentage = downPaymentText.endsWith("%");

        if (isPercentage) {
            // Parse down payment as a percentage and calculate full house price
            double downPaymentPercent = parseDouble(downPaymentText.replace("%", "").trim());
            double downPaymentReduced = 1 - (downPaymentPercent / 100); // Convert to decimal

            // Calculate combined monthly rate for taxes, HOA, insurance, and mortgage
            double restCalculations = propertyTax + insurance + hoaFee +
                (downPaymentReduced * (interestRate * Math.pow(1 + interestRate, loanTerm)) / 
                (Math.pow(1 + interestRate, loanTerm) - 1));

            // Calculate maximum house price and down payment amount
            fullPrice = Math.round(monthlyCost / restCalculations);
            downPaymentAmount = Math.round(fullPrice * downPaymentPercent / 100);

        } else {
            // Parse down payment as a dollar amount and calculate full house price
            downPaymentAmount = parseDouble(downPaymentText.replace("$", "").replace(",", "").trim());

            // Calculate combined monthly rate for taxes, HOA, insurance, and mortgage
            double restCalculations = propertyTax + insurance + hoaFee + 
                (interestRate * Math.pow(1 + interestRate, loanTerm)) / (Math.pow(1 + interestRate, loanTerm) - 1);

            // Calculate maximum house price based on monthly cost minus the down payment amount
            fullPrice = Math.round((monthlyCost / restCalculations) + downPaymentAmount);
        }

        // Adjust calculations for other costs based on fullPrice
        double estimatedClosingCost = Math.round(fullPrice * 0.03);  // Assuming closing cost at 3% of house price
        double totalOneTimePayment = downPaymentAmount + estimatedClosingCost;
        double annualPropertyTax = Math.round(fullPrice * propertyTax * 12);
        double annualInsurance = Math.round(fullPrice * insurance * 12);
        double annualHoa = Math.round(fullPrice * hoaFee * 12);
        double loanAmount = Math.round(fullPrice - downPaymentAmount);

        // Create the result message
        String resultMessage = String.format(
            "You can borrow up to %s.\nHouse price: %s\nDown payment: %s\nEstimated closing cost: %s\nTotal one-time payment: %s\nAnnual property tax: %s\nAnnual insurance: %s\nAnnual HOA: %s",
            currencyFormat.format(loanAmount),
            currencyFormat.format(fullPrice),
            currencyFormat.format(downPaymentAmount),
            currencyFormat.format(estimatedClosingCost),
            currencyFormat.format(totalOneTimePayment),
            currencyFormat.format(annualPropertyTax),
            currencyFormat.format(annualInsurance),
            currencyFormat.format(annualHoa)
        );

        // Show the result in a message box
        JOptionPane.showMessageDialog(HouseAffordabilityCalc.this, resultMessage, "Affordability Result", JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(HouseAffordabilityCalc.this, "Please enter valid input values.", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
}


    // Helper method to parse double and remove unwanted characters
    private double parseDouble(String input) {
        // Remove everything except digits and decimal point
        String cleanInput = input.replaceAll("[^\\d.]", "");
        return Double.parseDouble(cleanInput);
    }
}
            
            // Method to clear input fields and result label
            private void clearFields() {
                incomeField.setText("$"); // Clear the Income field
                loanTermField.setText(""); // Clear the Loan Term field
                interestRateField.setText("                                    %"); // Clear the interest rate field
                debtPaybackField.setText("$"); // Clear the debt payback field
                downPaymentField.setText(""); // Clear the down payment field
                propertyTaxField.setText(""); // Clear the property tax field
                hoaFeeField.setText(""); // Clear the Income field
                insuranceField.setText(""); // Clear the insurance field
                dtiRatioComboBox.setSelectedIndex(0); // Reset 'dti Ratio' currency combo box
                symbolsComboBox.setSelectedIndex(0); // Reset "symbols" to "%"
                symbolsComboBox2.setSelectedIndex(0); // Reset "symbols" to "%"
                symbolsComboBox3.setSelectedIndex(0); // Reset "symbols" to "%"
                symbolsComboBox4.setSelectedIndex(0); // Reset "symbols" to "%"
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
   } 
    
    // FocusListener to format JTextField input as currency on focus loss
    private class CurrencyFormatFocusListener extends FocusAdapter {
        @Override
        public void focusLost(FocusEvent e) {
            JTextField source = (JTextField) e.getSource();
            try {
                // Parse and format the value as currency
                double value = Double.parseDouble(source.getText().replace(",", "").replace("$", ""));
                source.setText(currencyFormat.format(value));
            } catch (NumberFormatException ex) {
                source.setText(""); // Clear field if input is invalid
            }
        }
    }
}

    public static void main(String[] args) {
        // Create and display the form
        SwingUtilities.invokeLater(() -> {
            JavaApplication_X frame = new JavaApplication_X();
            frame.setVisible(true);
        });
    }
}
