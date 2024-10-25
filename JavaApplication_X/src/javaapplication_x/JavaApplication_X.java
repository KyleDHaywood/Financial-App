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
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CategoricalCalcs calcFrame = new CategoricalCalcs();
                    calcFrame.setVisible(true);
                    // Close the current frame
                    dispose();
                }
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
                    // Show message when clicked
                    JOptionPane.showMessageDialog(null, "Auto Loan Calculator will come soon");
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
                    // Show message when clicked
                    JOptionPane.showMessageDialog(null, "Rent vs. Buy Calculator will come soon");
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
                    // Show message when clicked
                    JOptionPane.showMessageDialog(null, "Mortgage Calculator will come soon");
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
                    // Show message when clicked
                    JOptionPane.showMessageDialog(null, "House Affordability Calculator will come soon");
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

// New JFrame class for the curency calculator
class CurrencyCalculator extends JFrame{
    private final Image backgroundImage;
    
    private JTextField amountField;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JLabel resultsLabel;
    
     // Currency codes and names
    private final String[] currencyCodes = {
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
                backButton.setBounds(1100, 10, 80, 40); // Position the back button (adjust size as necessary)
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
                titleLabel.setBounds(80, 70, 700, 100); // Position and size of the label
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
                amountField.setBounds(220, 250, 300, 40);
                add(amountField);

                // Create and set up the "From" JLabel
                fromLabel = new JLabel("From:");
                fromLabel.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
                fromLabel.setForeground(Color.BLACK); // Set label color to black
                fromLabel.setBounds(75, 350, 100, 30); // Position and size of the label
                add(fromLabel); // Add label to the panel
                
                // Create an input field from
                fromCurrencyComboBox = new JComboBox<>(currencyCodes);
                fromCurrencyComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 32));
                fromCurrencyComboBox.setBounds(220, 350, 300, 40);
                add(fromCurrencyComboBox);

                // Create and set up the "To" JLabel
                toLabel = new JLabel("To:");
                toLabel.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
                toLabel.setForeground(Color.BLACK); // Set label color to black
                toLabel.setBounds(75, 450, 100, 30); // Position and size of the label
                add(toLabel); // Add label to the panel
                
                // Create an input to
                toCurrencyComboBox = new JComboBox<>(currencyCodes);
                toCurrencyComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 32));
                toCurrencyComboBox.setBounds(220, 450, 300, 40);
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

                        // Reset text color to black if input is valid
                        amountField.setForeground(Color.BLACK);

                        String fromCurrency = fromCurrencyComboBox.getSelectedItem().toString();
                        String toCurrency = toCurrencyComboBox.getSelectedItem().toString();

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
    public static void main(String[] args) {
        // Create and display the form
        SwingUtilities.invokeLater(() -> {
            JavaApplication_X frame = new JavaApplication_X();
            frame.setVisible(true);
        });
    }
}
