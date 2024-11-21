package javaapplication_x;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.text.DecimalFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;              
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.awt.Color;
import java.awt.BasicStroke;
import org.json.JSONObject;


public class JavaApplication_X extends JFrame {
    private final Image backgroundImage;

    public JavaApplication_X() {
        // Load the background image
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/Main_background.png")).getImage();

        // Set up the JFrame
        setTitle("FinCalC Pro");
        setSize(1200, 800); // Set the size of the window
        setResizable(false);
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
        setResizable(false);
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
        setResizable(false);
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
        setResizable(false);
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
                     Retirment_Calculator  Retirment_CalculatorFrame = new  Retirment_Calculator();
                      Retirment_CalculatorFrame.setVisible(true);
                      dispose();
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
                    RothIRACalculator RothIRACalculatorFrame = new RothIRACalculator();
                    RothIRACalculatorFrame.setVisible(true);
                    dispose();
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
    setResizable(false);
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
                    RentCalculator RentCalculatorFrame = new RentCalculator();
                    RentCalculatorFrame.setVisible(true);
                    dispose();
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
                    RefinanceCalculator RefinanceCalculatorFrame = new RefinanceCalculator();
                    RefinanceCalculatorFrame.setVisible(true);
                    dispose();
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
                    DownPaymentCalculator DownPaymentCalculatorFrame = new DownPaymentCalculator();
                    DownPaymentCalculatorFrame.setVisible(true);
                    dispose();
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
        setResizable(false);
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
                    InterestCalculator InterestCalculatorFrame = new InterestCalculator();
                    InterestCalculatorFrame.setVisible(true);
                    dispose();
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
    private JPanel PieChartPanel;
   
    public Auto_loan_calculator() {
        // Load the background image
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/auto_loan_cal_background.jpg")).getImage();

        // Set up the JFrame
        setTitle("Auto Loan Calculator");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
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
            loanAmountField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            loanAmountField.setBounds(320, 200, 200, 40);
            loanAmountField.addFocusListener(new CurrencyFormatFocusListener());
            add(loanAmountField);

            // Interest Rate label and field setup
            interestRateLabel = new JLabel("Interest Rate:");
            interestRateLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            interestRateLabel.setBounds(50, 250, 200, 40);
            add(interestRateLabel);

            interestRateField = new JTextField("                                             %");
            interestRateField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
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
            loanTermField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            loanTermField.setBounds(320, 300, 200, 40);
            // Add KeyListener to validate input
            loanTermField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(loanTermField);
           
            //cash incentives label and field
            CashIncentivesLabel = new JLabel("Cash Incentives");
            CashIncentivesLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            CashIncentivesLabel.setBounds(50, 350, 200, 40);
            add(CashIncentivesLabel);

            CashIncentivesField = new JTextField("$");
            CashIncentivesField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            CashIncentivesField.setBounds(320, 350, 200, 40);
            CashIncentivesField.addFocusListener(new CurrencyFormatFocusListener());
            add(CashIncentivesField);
           
            //downpayment label and field
            downPaymentLabel = new JLabel("Down Payment");
            downPaymentLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            downPaymentLabel.setBounds(50, 400, 200, 40);
            add(downPaymentLabel);

            downPaymentField = new JTextField("$");
            downPaymentField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            downPaymentField.setBounds(320, 400, 200, 40);
            downPaymentField.addFocusListener(new CurrencyFormatFocusListener());
            add(downPaymentField);
           
            //tradeIn label and field
            TradeInLabel = new JLabel("Trade-In Value");
            TradeInLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            TradeInLabel.setBounds(50, 450, 200, 40);
            add(TradeInLabel);

            TradeInField = new JTextField("$");
            TradeInField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            TradeInField.setBounds(320, 450, 200, 40);
            TradeInField.addFocusListener(new CurrencyFormatFocusListener());
            add(TradeInField);
           
            //amountowed label and field
            AmountOwedLabel = new JLabel("<html>Amount Owed<br> on Trade-in</html>");
            AmountOwedLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            AmountOwedLabel.setBounds(50, 500, 200, 40);
            add(AmountOwedLabel);

            AmountOwedField = new JTextField("$");
            AmountOwedField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            AmountOwedField.setBounds(320, 500, 200, 40);
            AmountOwedField.addFocusListener(new CurrencyFormatFocusListener());
            add(AmountOwedField);
           
            //salesTax label and field
            SaleTaxLabel = new JLabel("Sales Tax");
            SaleTaxLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            SaleTaxLabel.setBounds(50, 550, 200, 40);
            add(SaleTaxLabel);

            SalesTaxField = new JTextField("                                             %");
            SalesTaxField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
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
        
        // Remove any existing chart
            for (Component component : getComponents()) {
                if (component instanceof ChartPanel) {
                    remove(component);
                    break;
                }
            }
            
            double initialInvestment = totalLoanAmount;
            
            // Create dataset for the pie chart
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Principal", initialInvestment);
            dataset.setValue("Interest", totalLoanInterest);
            
            // Create the pie chart
            JFreeChart pieChart = ChartFactory.createPieChart(
                    "Loan Breakdown",
                    dataset,
                    true,
                    true,
                    false
            );

            // Add the chart to the panel
            PieChartPanel = new ChartPanel(pieChart);
            PieChartPanel.setBounds(720, 450, 280, 200); // Position in the bottom-right corner
            add(PieChartPanel);
            revalidate();
            repaint();
        
        
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
        if (PieChartPanel != null) {
                remove(PieChartPanel); // Remove the pie chart panel from the container
                PieChartPanel = null; // Set the PieChartPanel reference to null
                revalidate();  // Revalidate the layout
                repaint();     // Repaint the panel to reflect the changes
        }
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
        setResizable(false);
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
        loanTermField = new JTextField("");
        loanTermField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        loanTermField.setBounds(320, 342, 160, 35);
        // Add KeyListener to validate input
            loanTermField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
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
        setResizable(false);
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
        setResizable(false);
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
            // Add KeyListener to validate input
            loanTermField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
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
            // Add KeyListener to validate input
            yearField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
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
        setResizable(false);
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
            "10%", "15%", "20%", "25%", "30%", "35%", "40%" 
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
        + "&nbsp;&nbsp;&nbsp;&nbsp;30 Years: <span style='color:3161b7; text-decoration:underline;'>6.699%</span><br>"
        + "&nbsp;&nbsp;&nbsp;&nbsp;15 Years: <span style='color:3161b7; text-decoration:underline;'>6.047%</span><br>"
        + "&nbsp;&nbsp;&nbsp;&nbsp;10 Years: <span style='color:3161b7; text-decoration:underline;'>6.017%</span>"
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
            perYearLabel1.setBounds(610, 450, 200, 40);
            add(perYearLabel1);

            perYearLabel2 = new JLabel("per year");
            perYearLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            perYearLabel2.setBounds(610, 500, 200, 40);
            add(perYearLabel2);

            perYearLabel3 = new JLabel("per year");
            perYearLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            perYearLabel3.setBounds(610, 550, 200, 40);
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
            // Add KeyListener to validate input
            loanTermField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
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

            downPaymentField = new JTextField("                                    %");
            downPaymentField.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            downPaymentField.setBounds(400, 400, 200, 40); // Position next to downPaymentLabel
            add(downPaymentField);
            
            // ComboBox symbols for down payment
            symbolsComboBox = new JComboBox<>(symbolsOptions);
            symbolsComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            symbolsComboBox.setBounds(605, 400, 60, 40);
            //add(symbolsComboBox);
            
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

            propertyTaxField = new JTextField("                                    %");
            propertyTaxField.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            propertyTaxField.setBounds(400, 450, 200, 40); // Position next to propertyTaxLabel
            add(propertyTaxField);
            
            // ComboBox symbols for property Tax field
            symbolsComboBox2 = new JComboBox<>(symbolsOptions);
            symbolsComboBox2.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            symbolsComboBox2.setBounds(605, 450, 60, 40);
            //add(symbolsComboBox2);
            
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

            hoaFeeField = new JTextField("                                    %");
            hoaFeeField.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            hoaFeeField.setBounds(400, 500, 200, 40); // Position next to hoaFeeLabel
            add(hoaFeeField);
            
            // ComboBox symbols for hoa fee
            symbolsComboBox3 = new JComboBox<>(symbolsOptions);
            symbolsComboBox3.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            symbolsComboBox3.setBounds(605, 500, 60, 40);
            //add(symbolsComboBox3);
            
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
            
            insuranceField = new JTextField("                                    %");
            insuranceField.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            insuranceField.setBounds(400, 550, 200, 40); // Position next to insuranceLabel
            add(insuranceField);
            
            // ComboBox symbols for Insurance
            symbolsComboBox4 = new JComboBox<>(symbolsOptions);
            symbolsComboBox4.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            symbolsComboBox4.setBounds(605, 550, 60, 40);
            //add(symbolsComboBox4);
            
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
            
    // Helper method to retrieve the selected DTI ratio
    private double getSelectedDtiRatio(String selectedOption) {
        switch (selectedOption) {
            case "Conventional loan (28/36 rule)":
                return 0.28;
            case "FHA loan (31% front-end, 43% back-end)":
                return 0.31;
            case "10%":
                return 0.10;
            case "15%":
                return 0.15;
            case "20%":
                return 0.20;
            case "25%":
                return 0.25;
            case "30%":
                return 0.30;
            case "35%":
                return 0.35;
            case "40%":
                return 0.40;
            default:
                return 0.28; // Default value
        }
    }

    private class CalculateButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Extract values from fields
            double annualIncome = parseDouble(incomeField.getText());
            double loanTerm = parseDouble(loanTermField.getText());
            double interestRate = parseDouble(interestRateField.getText());
            double hoaFee = parseDouble(hoaFeeField.getText());
            double insurance = parseDouble(insuranceField.getText());

            // Property tax parsing
            String propertyTaxText = propertyTaxField.getText().trim();
            String selectedPropertyTaxFormat = (String) symbolsComboBox2.getSelectedItem();
            double propertyTax;
            if ("%".equals(selectedPropertyTaxFormat)) {
                double propertyTaxPercent = parseDouble(propertyTaxText.replace("%", "").trim());
                propertyTax = propertyTaxPercent / 1200;
            } else if ("$".equals(selectedPropertyTaxFormat)) {
                propertyTax = parseDouble(propertyTaxText.replace("$", "").replace(",", "").trim()) / 12;
            } else {
                propertyTax = 0;
            }

            interestRate /= 1200;
            insurance /= 1200;
            hoaFee /= 1200;
            loanTerm *= 12;

            // Get selected DTI ratio from ComboBox
            String selectedDtiOption = (String) dtiRatioComboBox.getSelectedItem();
            double dtiRatio = getSelectedDtiRatio(selectedDtiOption);

            // Calculate monthly income and maximum monthly housing cost
            double monthlyIncome = annualIncome / 12;
            double monthlyCost = monthlyIncome * dtiRatio;

            // Handle down payment as percentage or dollar amount
            String downPaymentText = downPaymentField.getText().trim();
            double downPaymentAmount;
            double fullPrice;
            boolean isPercentage = downPaymentText.endsWith("%");

            if (isPercentage) {
                double downPaymentPercent = parseDouble(downPaymentText.replace("%", "").trim());
                double downPaymentReduced = 1 - (downPaymentPercent / 100);

                double restCalculations = propertyTax + insurance + hoaFee +
                    (downPaymentReduced * (interestRate * Math.pow(1 + interestRate, loanTerm)) / 
                    (Math.pow(1 + interestRate, loanTerm) - 1));

                fullPrice = Math.round(monthlyCost / restCalculations);
                downPaymentAmount = Math.round(fullPrice * downPaymentPercent / 100);
            } else {
                downPaymentAmount = parseDouble(downPaymentText.replace("$", "").replace(",", "").trim());
                double restCalculations = propertyTax + insurance + hoaFee + 
                    (interestRate * Math.pow(1 + interestRate, loanTerm)) / (Math.pow(1 + interestRate, loanTerm) - 1);

                fullPrice = Math.round((monthlyCost / restCalculations) + downPaymentAmount);
            }

            double estimatedClosingCost = Math.round(fullPrice * 0.03);
            double totalOneTimePayment = downPaymentAmount + estimatedClosingCost;
            double annualPropertyTax = Math.round(fullPrice * propertyTax * 12);
            double annualInsurance = Math.round(fullPrice * insurance * 12);
            double annualHoa = Math.round(fullPrice * hoaFee * 12);
            double loanAmount = Math.round(fullPrice - downPaymentAmount);

            // Format the result message
            DecimalFormat currencyFormat = new DecimalFormat("$###,###,###.##");

            // Set up the result in table format
            String[] columnNames = {"Description", "Amount"};
            Object[][] data = {
                {"You can borrow", currencyFormat.format(loanAmount)},
                {"Total price of the house", "<html><b>" + currencyFormat.format(fullPrice) + "</b></html>"},
                {"Down payment", currencyFormat.format(downPaymentAmount)},
                {"Estimated closing cost", currencyFormat.format(estimatedClosingCost)},
                {"Front-end DTI ratio", String.format("%.2f%%", dtiRatio * 100)},
                {"Back-end DTI ratio", String.format("%.2f%%", dtiRatio * 100)},
                {"Total one-time payment at closing", currencyFormat.format(totalOneTimePayment)},
                {"Monthly mortgage payment", currencyFormat.format(loanAmount / loanTerm)},  // Approximation
                {"Annual property tax", currencyFormat.format(annualPropertyTax)},
                {"Annual HOA or co-op fee", currencyFormat.format(annualHoa)},
                {"Annual insurance cost", currencyFormat.format(annualInsurance)},
                {"Estimated annual maintenance cost", currencyFormat.format(fullPrice * 0.015)},
                {"Total monthly cost on the house", "<html><b>" + currencyFormat.format((loanAmount / loanTerm + annualPropertyTax / 12 + annualHoa / 12 + annualInsurance / 12)*2) + "</b></html>"}
            };

            // Create table model
            DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
            JTable table = new JTable(tableModel);
            table.setRowHeight(30);
            table.setFont(new Font("Times New Roman", Font.PLAIN, 14));

            // Customize table appearance
            table.setBackground(new Color(169, 223, 191));
            table.setForeground(Color.BLACK);
            table.setSelectionBackground(Color.GRAY);
            table.setSelectionForeground(Color.WHITE);

            // Create result window with table
            JFrame resultWindow = new JFrame("House Affordability Result");
            resultWindow.setSize(600, 400);
            resultWindow.setLocationRelativeTo(null);  // Center window
            setResizable(false);
            resultWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Add table to a JScrollPane
            JScrollPane scrollPane = new JScrollPane(table);
            resultWindow.add(scrollPane);

            // Display the result window
            resultWindow.setVisible(true);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(HouseAffordabilityCalc.this, 
                "Please enter valid input values.", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}

    // Helper method to parse double and remove unwanted characters
    private double parseDouble(String input) {
        // Remove everything except digits and decimal point
        String cleanInput = input.replaceAll("[^\\d.]", "");
        return Double.parseDouble(cleanInput);
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
}


public class Retirment_Calculator extends JFrame {
    private final Image backgroundImage;
    private JComboBox<String> symbolsComboBox1;
    private JComboBox<String> symbolsComboBox2;
    private JTextField CurrentAgeField;
    private JTextField PlannedRetirementField;
    private JTextField LifeExpectancyField;
    private JLabel resultScreen;
    private JPanel graph_result;
    private JTextField PreTaxField;
    private JTextField CurrentIncomeField;
    private JTextField IncomeNeededField;
    private JTextField AverageInvestmentField;
    private JTextField InflationRateField;
    private JTextField OtherIncomeField;
    private JTextField CurrentSavingsField;
    private JTextField FutureSavingsField;
    private NumberFormat currencyFormat;

    public Retirment_Calculator() {
        // Load the background image
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/retirement_calculator_background.png")).getImage();

        // Set up the JFrame
        setTitle("Retirement Calculator");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        // Create currency formatter for USD
        currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

        // Add content to the JFrame (background panel)
        setContentPane(new ImagePanel());
    }

    // Inner class to handle the background image panel
    private class ImagePanel extends JPanel {
        private final JButton backButton;
        private final JLabel titleLabel;
        private final JLabel resultLabel;
        private final JLabel CurrentAgeLabel;
        private final JLabel PlannedRetirementLabel;
        private final JLabel LifeExpectancyLabel;
        private final JLabel PreTaxLabel;
        private final JLabel CurrentIncomeLabel;
        private final JLabel IncomeNeededLabel;
        private final JLabel AverageInvestmentLabel;
        private final JLabel InflationRateLabel;
        private final JLabel OtherIncomeLabel;
        private final JLabel CurrentSavingsLabel;
        private final JLabel FutureSavingsLabel;
        private final JButton calculateButton;
        private final JButton clearButton;
        private final JLabel yearLabel1,yearLabel2, yearLabel3, yearLabel4, monthLabel;
       
        // ComboBox symbols $ and % creation
            private final String[] symbolsOptions = {
                "%", "$"};

        public ImagePanel() {
            setLayout(null);

            // Back button setup
            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png")));
            backButton.setBounds(20, 20, 80, 40);
            add(backButton);
            backButton.addActionListener(e -> {
                RetirementCategory RetirementCategoryFrame = new RetirementCategory();
                RetirementCategoryFrame.setVisible(true);
                dispose();
            });

            // Title label setup
            titleLabel = new JLabel("Retirement Calculator");
            titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
            titleLabel.setForeground(Color.BLACK);
            titleLabel.setBounds(190, 10, 800, 200);
            add(titleLabel);

            // Setting up fields and labels for input data
           
            // Current Age label and field
            CurrentAgeLabel = new JLabel("Current Age:");
            CurrentAgeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            CurrentAgeLabel.setBounds(40, 180, 200, 40);
            add(CurrentAgeLabel);

            CurrentAgeField = new JTextField();
            CurrentAgeField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            CurrentAgeField.setBounds(380, 180, 200, 35);
            // Add KeyListener to validate input
            CurrentAgeField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(CurrentAgeField);
           
            // Planned Retirement label and field
            PlannedRetirementLabel = new JLabel("Planned Retirement Age:");
            PlannedRetirementLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            PlannedRetirementLabel.setBounds(40, 220, 300, 40);
            add(PlannedRetirementLabel);

            PlannedRetirementField = new JTextField();
            PlannedRetirementField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            PlannedRetirementField.setBounds(380, 220, 200, 35);
            // Add KeyListener to validate input
            PlannedRetirementField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(PlannedRetirementField);
           
            // Life Expectancy lable and field
            LifeExpectancyLabel = new JLabel("Life Expectancy:");
            LifeExpectancyLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            LifeExpectancyLabel.setBounds(40, 260, 200, 40);
            add(LifeExpectancyLabel);

            LifeExpectancyField = new JTextField();
            LifeExpectancyField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            LifeExpectancyField.setBounds(380, 260, 200, 35);
            // Add KeyListener to validate input
            LifeExpectancyField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(LifeExpectancyField);

           
            // Current Pre Tax income
            PreTaxLabel = new JLabel("Current Pre-Tax Income:");
            PreTaxLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            PreTaxLabel.setBounds(40, 300, 300, 40);
            add(PreTaxLabel);
            
            yearLabel1 = new JLabel("/year");
            yearLabel1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            yearLabel1.setBounds(580,300,100,40);
            add(yearLabel1);
            
            PreTaxField = new JTextField("$");
            PreTaxField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            PreTaxField.setBounds(380, 300, 200, 35);
            PreTaxField.addFocusListener(new CurrencyFormatFocusListener());
            add(PreTaxField);
           
            // Current income label and field
            CurrentIncomeLabel = new JLabel("Current Income Increase:");
            CurrentIncomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            CurrentIncomeLabel.setBounds(40, 340, 350, 40);
            add(CurrentIncomeLabel);

            CurrentIncomeField = new JTextField("                                    %");
            CurrentIncomeField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            CurrentIncomeField.setBounds(380, 340, 200, 35);
            // Add KeyListener to validate input
            CurrentIncomeField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });

            // Add a FocusListener to manage the % symbol
            CurrentIncomeField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (CurrentIncomeField.getText().endsWith("%")) {
                        CurrentIncomeField.setText(CurrentIncomeField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!CurrentIncomeField.getText().isEmpty() && !CurrentIncomeField.getText().endsWith("%")) {
                        CurrentIncomeField.setText(CurrentIncomeField.getText().trim() + "%");
                    }
                }
            });
            add(CurrentIncomeField);
            
            yearLabel2 = new JLabel("/year");
            yearLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            yearLabel2.setBounds(580,340,100,40);
            add(yearLabel2);
           
            // Income Needed label and field
            IncomeNeededLabel = new JLabel("Income Needed After Retirement:");
            IncomeNeededLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            IncomeNeededLabel.setBounds(40, 380, 350, 40);
            add(IncomeNeededLabel);

            IncomeNeededField = new JTextField("                                            %");
            IncomeNeededField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            IncomeNeededField.setBounds(380, 380, 200, 35);
            // Add KeyListener to validate input
            IncomeNeededField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(IncomeNeededField);

            // ComboxBox for income needed
            symbolsComboBox1 = new JComboBox<>(symbolsOptions);
            symbolsComboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            symbolsComboBox1.setBounds(580, 380, 60, 35);
            add(symbolsComboBox1);
            
            // ActionListener for ComboBox symbolsComboBox1
            symbolsComboBox1.addActionListener((ActionEvent e) -> {
            String selectedFormat = (String) symbolsComboBox1.getSelectedItem();
            String text = IncomeNeededField.getText().replaceAll("[^\\d.]", ""); // Remove previous symbols
            double pretaxIncome = parseCurrencyField(PreTaxField.getText()); // Convert PreTaxField value to double

            if ("%".equals(selectedFormat)) {
                // Convert from $ to %
                if (pretaxIncome != 0 && !text.isEmpty()) {
                    double valueInDollars = Double.parseDouble(text);
                    double percentageValue = (valueInDollars / pretaxIncome) * 100;
                    IncomeNeededField.setText(String.format("%.2f%%", percentageValue));
                }
            } else if ("$".equals(selectedFormat)) {
                // Convert from % to $
                if (!text.isEmpty()) {
                    double percentageValue = Double.parseDouble(text);
                    double valueInDollars = (percentageValue / 100) * pretaxIncome;
                    IncomeNeededField.setText(NumberFormat.getCurrencyInstance().format(valueInDollars));
                }
            }
        });

            // Add FocusListener to downPaymentField
            IncomeNeededField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    String selectedFormat = (String) symbolsComboBox1.getSelectedItem();
                    String text = IncomeNeededField.getText().replaceAll("[^\\d.]", ""); // Remove symbols

                    if ("%".equals(selectedFormat) && !text.isEmpty()) {
                        // Append % when focus is lost and "%" is selected
                        IncomeNeededField.setText(text + "%");
                    } else if ("$".equals(selectedFormat) && !text.isEmpty()) {
                        // Format as currency with "$" symbol
                        double value = Double.parseDouble(text);
                        IncomeNeededField.setText(NumberFormat.getCurrencyInstance().format(value));
                    }
                }
            });
            
            // Average investment label and field
            AverageInvestmentLabel = new JLabel("Average Investment Return:");
            AverageInvestmentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            AverageInvestmentLabel.setBounds(40, 420, 350, 40);
            add(AverageInvestmentLabel);

            AverageInvestmentField = new JTextField("                                            %");
            AverageInvestmentField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            AverageInvestmentField.setBounds(380, 420, 200, 35);
            // Add KeyListener to validate input
            AverageInvestmentField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            // Add a FocusListener to manage the % symbol
            AverageInvestmentField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (AverageInvestmentField.getText().endsWith("%")) {
                        AverageInvestmentField.setText(AverageInvestmentField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!AverageInvestmentField.getText().isEmpty() && !AverageInvestmentField.getText().endsWith("%")) {
                        AverageInvestmentField.setText(AverageInvestmentField.getText().trim() + "%");
                    }
                }
            });
            add(AverageInvestmentField);
            
            yearLabel3 = new JLabel("/year");
            yearLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            yearLabel3.setBounds(580,420,100,40);
            add(yearLabel3);
           
            // Inflation Rate label and field
            InflationRateLabel = new JLabel("Inflation Rate:");
            InflationRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            InflationRateLabel.setBounds(40, 460, 200, 40);
            add(InflationRateLabel);

            InflationRateField = new JTextField("                                            %");
            InflationRateField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            InflationRateField.setBounds(380, 460, 200, 35);
            // Add KeyListener to validate input
            InflationRateField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            // Add a FocusListener to manage the % symbol
            InflationRateField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (InflationRateField.getText().endsWith("%")) {
                        InflationRateField.setText(InflationRateField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!InflationRateField.getText().isEmpty() && !InflationRateField.getText().endsWith("%")) {
                        InflationRateField.setText(InflationRateField.getText().trim() + "%");
                    }
                }
            });
            add(InflationRateField);
            
            yearLabel4 = new JLabel("/year");
            yearLabel4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            yearLabel4.setBounds(580,460,100,40);
            add(yearLabel4);
           
            // Other Income label and field
            OtherIncomeLabel = new JLabel("Other Income After Retirement:");
            OtherIncomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            OtherIncomeLabel.setBounds(40, 500, 350, 40);
            add(OtherIncomeLabel);

            OtherIncomeField = new JTextField("$");
            OtherIncomeField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            OtherIncomeField.setBounds(380, 500, 200, 35);
            OtherIncomeField.addFocusListener(new CurrencyFormatFocusListener());
            add(OtherIncomeField);
            
            monthLabel = new JLabel("/month");
            monthLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            monthLabel.setBounds(580,500,100,40);
            add(monthLabel);
           
            // Current savings label and field
            CurrentSavingsLabel = new JLabel("Current Retirement Savings:");
            CurrentSavingsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            CurrentSavingsLabel.setBounds(40, 540, 350, 40);
            add(CurrentSavingsLabel);

            CurrentSavingsField = new JTextField("$");
            CurrentSavingsField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            CurrentSavingsField.setBounds(380, 540, 200, 35);
            CurrentSavingsField.addFocusListener(new CurrencyFormatFocusListener());
            add(CurrentSavingsField);

           
            // Future savings label and field
            FutureSavingsLabel = new JLabel("Future Retirement Savings:");
            FutureSavingsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            FutureSavingsLabel.setBounds(40, 580, 350, 40);
            add(FutureSavingsLabel);

            FutureSavingsField = new JTextField("                                            %");
            FutureSavingsField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            FutureSavingsField.setBounds(380, 580, 200, 35);
            // Add KeyListener to validate input
            FutureSavingsField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(FutureSavingsField);

            // ComboBox symbols for future savings
            symbolsComboBox2 = new JComboBox<>(symbolsOptions);
            symbolsComboBox2.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set font
            symbolsComboBox2.setBounds(580, 580, 60, 35);
            add(symbolsComboBox2);
            
            // ActionListener for ComboBox symbolsComboBox2 (Future Savings)
            symbolsComboBox2.addActionListener((ActionEvent e) -> {
                String selectedFormat = (String) symbolsComboBox2.getSelectedItem();
                String text = FutureSavingsField.getText().replaceAll("[^\\d.]", ""); // Remove previous symbols
                double pretaxIncome = parseCurrencyField(PreTaxField.getText()); // Convert PreTaxField value to double

                if ("%".equals(selectedFormat)) {
                    // Convert from $ to %
                    if (pretaxIncome != 0 && !text.isEmpty()) {
                        double valueInDollars = Double.parseDouble(text);
                        double percentageValue = (valueInDollars / pretaxIncome) * 100;
                        FutureSavingsField.setText(String.format("%.2f%%", percentageValue));
                    }
                } else if ("$".equals(selectedFormat)) {
                    // Convert from % to $
                    if (!text.isEmpty()) {
                        double percentageValue = Double.parseDouble(text);
                        double valueInDollars = (percentageValue / 100) * pretaxIncome;
                        FutureSavingsField.setText(NumberFormat.getCurrencyInstance().format(valueInDollars));
                    }
                }
            });

            // Add FocusListener to downPaymentField
            FutureSavingsField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    String selectedFormat = (String) symbolsComboBox2.getSelectedItem();
                    String text = FutureSavingsField.getText().replaceAll("[^\\d.]", ""); // Remove symbols

                    if ("%".equals(selectedFormat) && !text.isEmpty()) {
                        // Append % when focus is lost and "%" is selected
                        FutureSavingsField.setText(text + "%");
                    } else if ("$".equals(selectedFormat) && !text.isEmpty()) {
                        // Format as currency with "$" symbol
                        double value = Double.parseDouble(text);
                        FutureSavingsField.setText(NumberFormat.getCurrencyInstance().format(value));
                    }
                }
            });
            
            // Calculate button setup
            calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
            calculateButton.setBounds(150, 650, 175, 50);
            calculateButton.setBackground(new Color(169, 223, 191));
            add(calculateButton);
            calculateButton.addActionListener(e -> calculateRetirementEquation());

            // Clear button setup
            clearButton = new JButton("Clear");
            clearButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
            clearButton.setBounds(370, 650, 130, 50);
            clearButton.setForeground(Color.WHITE);
            clearButton.setBackground(Color.GRAY);
            add(clearButton);
            clearButton.addActionListener(e -> clearFields());
            
            // result name
            resultLabel = new JLabel("Results");
            resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
            resultLabel.setBounds(690,180,120,40);
            resultLabel.setForeground(Color.WHITE);
            add(resultLabel);
            
            // Result label setup
            resultScreen = new JLabel("");
            resultScreen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            resultScreen.setBounds(680, 240, 490, 95);
            //resultScreen.setOpaque(true);
            //resultScreen.setBackground(new Color(184, 228, 202));
            add(resultScreen);
            
            // Graph result
            graph_result = new JPanel();
            graph_result.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            graph_result.setBounds(680, 340, 490, 400);
            graph_result.setBackground(Color.WHITE);
            graph_result.setLayout(new BorderLayout());
            add(graph_result);
            
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    // Utility method to parse currency fields
    private double parseCurrencyField(String text) {
        try {
            // Remove any non-numeric characters before parsing
            String numericText = text.replaceAll("[^\\d.]", "");
            return Double.parseDouble(numericText);
        } catch (NumberFormatException ex) {
            return 0.0;
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

    public void calculateRetirementEquation() {
        try{
            // Get values from fields, stripping out symbols where necessary
           int currentAge = Integer.parseInt(CurrentAgeField.getText().trim());
           int retirementAge = Integer.parseInt(PlannedRetirementField.getText().trim());
           int lifeExpectancy = Integer.parseInt(LifeExpectancyField.getText().trim());
           double preTaxIncome = parseCurrency(PreTaxField.getText());
           double currentIncomeIncrease = parsePercentage(CurrentIncomeField.getText());
           double incomeNeededAfterRetirement = parseCurrencyOrPercentage(IncomeNeededField, symbolsComboBox1);
           double avgInvestmentReturn = parsePercentage(AverageInvestmentField.getText());
           double inflationRate = parsePercentage(InflationRateField.getText());
           double otherIncomeAfterRetirement = parseCurrency(OtherIncomeField.getText());
           double currentSavings = parseCurrency(CurrentSavingsField.getText());
           double futureSavings = parseCurrencyOrPercentage(FutureSavingsField, symbolsComboBox2);
           
           // Calculate years until retirement and years in retirement
           int yearsToRetirement = retirementAge - currentAge;
           int yearsInRetirement = lifeExpectancy - retirementAge;

           // Calculate final income before retirement
           double finalIncome = preTaxIncome * Math.pow(1 + (currentIncomeIncrease/100), yearsToRetirement);

           // Check if incomeNeededAfterRetirement is a percentage or a dollar amount
            if (IncomeNeededField.getText().contains("%")) {
                // If it's a percentage, divide by 100 to convert to decimal form
                incomeNeededAfterRetirement /= 100;
            } else if (IncomeNeededField.getText().contains("$")) {
                // If it's a dollar amount, convert it to percentage of preTaxIncome
                incomeNeededAfterRetirement = (incomeNeededAfterRetirement / preTaxIncome);
            }
            
            // Check if futureSavings is a percentage or a dollar amount
            if (FutureSavingsField.getText().contains("%")) {
                // If it's a percentage, divide by 100 to convert to decimal form
                futureSavings /= 100;
            } else if (FutureSavingsField.getText().contains("$")) {
                // If it's a dollar amount, convert it to percentage of preTaxIncome
                futureSavings = (futureSavings / preTaxIncome);
            }
           
           
           // Calculate annual income needed in retirement (in future dollars)
           double annualRetirementIncomeNeeded = finalIncome * incomeNeededAfterRetirement;
           double annualOtherIncome = otherIncomeAfterRetirement * 12;

           // Adjust for inflation
           double realReturnRate = (1 + (avgInvestmentReturn/100)) / (1 + (inflationRate/100)) - 1;

           // Calculate total retirement savings needed
           double netAnnualNeed = annualRetirementIncomeNeeded - annualOtherIncome;
           double totalNeeded = netAnnualNeed * (1 - Math.pow(1 + realReturnRate, -yearsInRetirement)) / realReturnRate;

           // Calculate projected savings at retirement
           double projectedSavings = currentSavings * Math.pow(1 + (avgInvestmentReturn/100), yearsToRetirement);

           // Calculate and add future contributions
           for (int year = 0; year < yearsToRetirement; year++) {
               double currentIncomeYear = preTaxIncome * Math.pow(1 + (currentIncomeIncrease/100), year);
               double annualContribution = currentIncomeYear * futureSavings;
               int yearsToGrow = yearsToRetirement - year - 1;
               projectedSavings += annualContribution * Math.pow(1 + (avgInvestmentReturn/100), yearsToGrow);
           }

           
        // Format the result text with HTML for display
        DecimalFormat df = new DecimalFormat("###,###,###.##");
        resultScreen.setText ("<html>You will need about <b><u>$" + df.format(totalNeeded / 1e6) + "M</u></b> at age " + retirementAge + " to retire.<br>" +
                            "Based on your current plan, you will have about $" + df.format(projectedSavings / 1e6) + "M at age " + retirementAge + ", " +
                            (projectedSavings >= totalNeeded 
                             ? "which means you are on track for retirement." 
                             : "which is less than what you need for retirement.") + "<br>" + "</html>");
        
        
        // Create the dataset for the bar chart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(projectedSavings / 1e6, "Savings", "You will have");
        dataset.addValue(totalNeeded / 1e6, "Needs", "You will need");

        // Create the bar chart
        JFreeChart barChart = ChartFactory.createBarChart(
                "Retirement Savings Comparison at Age " + retirementAge,
                "Category",
                "Amount in Millions ($)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Create a ChartPanel to hold the bar chart
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(400, 300));

        // Display the chart in graph_result panel
        graph_result.removeAll();  // Clear previous contents
        graph_result.add(chartPanel, BorderLayout.CENTER); // Add chartPanel to graph_result
        graph_result.revalidate();
        graph_result.repaint();

    }catch  (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please ensure all fields are filled with valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    // Helper method to parse currency inputs (removes "$" and commas)
    private double parseCurrency(String text) {
        text = text.replaceAll("[^\\d.]", ""); // Remove everything except digits and decimals
        return text.isEmpty() ? 0 : Double.parseDouble(text);
    }

    // Helper method to parse percentage inputs (removes "%")
    private double parsePercentage(String text) {
        text = text.replaceAll("[^\\d.]", ""); // Remove everything except digits and decimals
        return text.isEmpty() ? 0 : Double.parseDouble(text);
    }

    // Helper method to parse either currency or percentage based on ComboBox selection
    private double parseCurrencyOrPercentage(JTextField field, JComboBox<String> comboBox) {
        String selectedFormat = (String) comboBox.getSelectedItem();
        String text = field.getText().replaceAll("[^\\d.]", "");

        double value = text.isEmpty() ? 0 : Double.parseDouble(text);
        if ("%".equals(selectedFormat)) {
            return value; // As percentage
        } else {
            return value; // As dollar amount
        }
    }
    private void clearFields() {
        CurrentAgeField.setText("");
        PlannedRetirementField.setText("");
        LifeExpectancyField.setText("");
        PreTaxField.setText("");
        CurrentIncomeField.setText("");
        IncomeNeededField.setText("0");
        AverageInvestmentField.setText("");
        InflationRateField.setText("");
        OtherIncomeField.setText("");
        CurrentSavingsField.setText("");
        FutureSavingsField.setText("0");
        resultScreen.setText("");
        // Clear the graph result panel
        graph_result.removeAll();
        graph_result.revalidate(); // Refresh the layout to show it's cleared
        graph_result.repaint();    // Repaint to make the change visible
        symbolsComboBox1.setSelectedIndex(0);
        symbolsComboBox2.setSelectedIndex(0);
    }
}
public class RefinanceCalculator extends JFrame {    
    private final Image backgroundImage;
    private JTextField remainingBalanceField, monthlyPaymentField, currentRateField, 
                        newTermYearsField, newRateField, pointsField, costsFeesField, cashOutField;
    private JLabel resultLabel,result_monthlyLabel;
    private NumberFormat currencyFormat;

    public RefinanceCalculator() {        
        // Load the background image
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/refinance_calculator_background.png")).getImage();

        // Setting up the JFrame
        setTitle("Refinance Calculator");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Create currency formatter for USD
        currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        
        // Add content to the JFrame (background panel)
        setContentPane(new ImagePanel()); 
}
   // Inner class to handle the background image panel
    private class ImagePanel extends JPanel {
        private final JLabel titleLabel;
        private final JLabel remaining_balanceLabel, monthly_paymentLabel, current_interestRateLabel,
                            new_term_yearLabel, new_interest_rateLabel, pointsLabel, costsFeesLabel, cashOutLabel;
        private final JButton calculateButton, backButton, clearButton;
        
        public ImagePanel() {
            setLayout(null);
            
            titleLabel = new JLabel("Refinance Calculator");
            titleLabel.setFont(new Font("Times New Roman", Font.BOLD,60));
            titleLabel.setForeground(Color.BLACK);
            titleLabel.setBounds(180,70,800,100);
            add(titleLabel);
            
            // Back button setup
            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png")));
            backButton.setBounds(20, 20, 80, 40);
            add(backButton);
            backButton.addActionListener(e -> {
                MortgageAndRealCategory MortgageAndRealCategoryFrame = new MortgageAndRealCategory();
                MortgageAndRealCategoryFrame.setVisible(true);
                dispose(); // Close the current frame
            });
            
            result_monthlyLabel = new JLabel("New Monthly Pay:");
            result_monthlyLabel.setFont(new Font("Times New Roman", Font.BOLD,40));
            result_monthlyLabel.setForeground(Color.WHITE);
            result_monthlyLabel.setBounds(590,190,600,50);
            add(result_monthlyLabel);
            
            remaining_balanceLabel = new JLabel("Remaining Balance");
            remaining_balanceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            remaining_balanceLabel.setBounds(40,200,250,40);
            add(remaining_balanceLabel);

            remainingBalanceField = new JTextField("$");
            remainingBalanceField.setFont(new Font("Times New Roman", Font.PLAIN,24));
            remainingBalanceField.setBounds(320,200,200,40);
            remainingBalanceField.addFocusListener(new CurrencyFormatFocusListener());
            add(remainingBalanceField);

            monthly_paymentLabel = new JLabel("Monthly Payment");
            monthly_paymentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            monthly_paymentLabel.setBounds(40,250,250,40);
            add(monthly_paymentLabel);

            monthlyPaymentField = new JTextField("$");
            monthlyPaymentField.setFont(new Font("Times New Roman", Font.PLAIN,24));
            monthlyPaymentField.setBounds(320, 250,200,40);
            monthlyPaymentField.addFocusListener(new CurrencyFormatFocusListener());
            add(monthlyPaymentField);

            current_interestRateLabel = new JLabel("Current Interest Rate");
            current_interestRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            current_interestRateLabel.setBounds(40,300,250,40);
            add(current_interestRateLabel);

            currentRateField = new JTextField("                                              %");
            currentRateField.setFont(new Font("Times New Roman", Font.PLAIN,24));
            currentRateField.setBounds(320,300,200,40);
            // Add KeyListener to validate input
            currentRateField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            // Add a FocusListener to manage the % symbol
            currentRateField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (currentRateField.getText().endsWith("%")) {
                        currentRateField.setText(currentRateField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!currentRateField.getText().isEmpty() && !currentRateField.getText().endsWith("%")) {
                        currentRateField.setText(currentRateField.getText().trim() + "%");
                    }
                }
            });
            add(currentRateField);

            new_term_yearLabel = new JLabel("New loan term (years)");
            new_term_yearLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            new_term_yearLabel.setBounds(40,350,250,40);
            add(new_term_yearLabel);

            newTermYearsField = new JTextField("");
            newTermYearsField.setFont(new Font("Times New Roman", Font.PLAIN,24));
            newTermYearsField.setBounds(320,350,200,40);
            // Add KeyListener to validate input
            newTermYearsField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(newTermYearsField);

            new_interest_rateLabel = new JLabel("New Interest Rate");
            new_interest_rateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            new_interest_rateLabel.setBounds(40,400,250,40);
            add(new_interest_rateLabel);

            newRateField = new JTextField("                                              %");
            newRateField.setFont(new Font("Times New Roman", Font.PLAIN,24));
            newRateField.setBounds(320,400,200,40);
            // Add KeyListener to validate input
            newRateField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            // Add a FocusListener to manage the % symbol
            newRateField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (newRateField.getText().endsWith("%")) {
                        newRateField.setText(newRateField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!newRateField.getText().isEmpty() && !newRateField.getText().endsWith("%")) {
                        newRateField.setText(newRateField.getText().trim() + "%");
                    }
                }
            });
            add(newRateField);

            pointsLabel = new JLabel("Points");
            pointsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            pointsLabel.setBounds(40,450,250,40);
            add(pointsLabel);

            pointsField = new JTextField("");
            pointsField.setFont(new Font("Times New Roman", Font.PLAIN,24));
            pointsField.setBounds(320,450,200,40);
            // Add KeyListener to validate input
            pointsField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(pointsField);

            costsFeesLabel = new JLabel("Costs and Fees");
            costsFeesLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            costsFeesLabel.setBounds(40,500,250,40);
            add(costsFeesLabel);

            costsFeesField = new JTextField("$");
            costsFeesField.setFont(new Font("Times New Roman", Font.PLAIN,24));
            costsFeesField.setBounds(320,500,200,40);
            costsFeesField.addFocusListener(new CurrencyFormatFocusListener());
            add(costsFeesField);

            cashOutLabel = new JLabel("Cash out amount");
            cashOutLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            cashOutLabel.setBounds(40,550,250,40);
            add(cashOutLabel);

            cashOutField = new JTextField("$");
            cashOutField.setFont(new Font("Times New Roman", Font.PLAIN,24));
            cashOutField.setBounds(320,550,200,40);
            cashOutField.addFocusListener(new CurrencyFormatFocusListener());
            add(cashOutField);

            // Clear button setup
            clearButton = new JButton("Clear");
            clearButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
            clearButton.setBounds(320, 630, 130, 50);
            clearButton.setForeground(Color.WHITE);
            clearButton.setBackground(Color.GRAY);
            add(clearButton);
            clearButton.addActionListener(e -> clearFields());
            
            // Button to calculate
            calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
            calculateButton.setBackground(new Color(169, 223, 191));
            calculateButton.setBounds(100, 630, 175, 50);
            add(calculateButton);

            // Action listener for the button
            calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the values from input fields
                    double remainingBalance = parseCurrency(remainingBalanceField.getText());
                    double monthlyPayment = parseCurrency(monthlyPaymentField.getText());
                    double currentRate = parsePercentage(currentRateField.getText());
                    int newTermYears = Integer.parseInt(newTermYearsField.getText().trim());
                    double newRate = parsePercentage(newRateField.getText());
                    double points = Integer.parseInt(pointsField.getText().trim());
                    double costsFees = parseCurrency(costsFeesField.getText());
                    double cashOut = parseCurrency(cashOutField.getText());

                    // Call the refinance calculation method
                    RefinanceResults results = refinanceCalculator(remainingBalance, monthlyPayment, currentRate, 
                                                                   newTermYears, newRate, points, costsFees, cashOut);

                    // Build the results text
                    String resultText = "<html>";

                    // APR: Always bold and black
                    resultText += "The APR for the new loan: <b>" + formatCurrency(results.APR) + "%</b><br>";

                    // Monthly Savings or Extra Cost
                    if (results.monthlySavings >= 0) {
                        resultText += "Saving in monthly pay: <b><span style='color:green;'>"
                                + formatCurrency(results.monthlySavings) + "/month</span></b><br>";
                    } else {
                        resultText += "Extra cost in monthly pay: <b><span style='color:red;'>"
                                + formatCurrency(Math.abs(results.monthlySavings)) + "/month</span></b><br>";
                    }

                    // Time Saved or Time Extended
                    if (results.timeSaved >= 0) {
                        resultText += "Time Saved (months): <b><span style='color:green;'>"
                                + results.timeSaved + " months</span></b><br>";
                    } else {
                        resultText += "Time Extended (months): <b><span style='color:red;'>"
                                + Math.abs(results.timeSaved) + " months</span></b><br>";
                    }

                    // Lifetime Savings or Total Extra Cost
                    if (results.lifetimeSavings >= 0) {
                        resultText += "Lifetime Savings: <b><span style='color:green;'>"
                                + formatCurrency(results.lifetimeSavings) + "</span></b><br>";
                    } else {
                        resultText += "Total extra cost for the new loan: <b><span style='color:red;'>"
                                + formatCurrency(Math.abs(results.lifetimeSavings)) + "</span></b><br>";
                    }

                    // Upfront Cost: Always red
                    resultText += "Upfront Cost: <b><span style='color:red;'>"
                            + formatCurrency(results.upfrontCost) + "</span></b><br>";

                    resultText += "</html>";

                    // Set the results to the labels
                    resultLabel.setText(resultText);

                    // New Monthly Pay: Remains unchanged
                    result_monthlyLabel.setText("New Monthly Pay: " + formatCurrency(results.newMonthlyPayment));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Result label
        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        resultLabel.setBounds(578, 230, 570, 300);
        //resultLabel.setOpaque(true);
        //resultLabel.setBackground(new Color(169, 223, 191));
        add(resultLabel);
    }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    // Helper method to parse currency inputs (removes "$" and commas)
    public double parseCurrency(String text) {
        text = text.replaceAll("[^\\d.]", ""); // Remove everything except digits and decimals
        return text.isEmpty() ? 0 : Double.parseDouble(text);
    }
    
    // Helper method to parse percentage inputs (removes "%")
    private double parsePercentage(String text) {
        text = text.replaceAll("[^\\d.]", ""); // Remove everything except digits and decimals
        return text.isEmpty() ? 0 : Double.parseDouble(text);
    }
        
    // Method for refinance calculation
    public RefinanceResults refinanceCalculator(double remainingBalance, double monthlyPayment, double currentRate, 
                                                int newTermYears, double newRate, double points, double costsFees, double cashOut) {
        final int MONTHS_IN_YEAR = 12;
        
        // Current Loan Calculation
        double rCurrent = currentRate / 100 / MONTHS_IN_YEAR;
        double PCurrent = remainingBalance;
        
        // Calculate remaining payments more accurately
        double nCurrent = -Math.log(1 - (rCurrent * PCurrent) / monthlyPayment) / Math.log(1 + rCurrent);
        nCurrent = Math.ceil(nCurrent); // Round up to nearest month
        
        // Calculate remaining interest on current loan
        double remainingInterestCurrent = (monthlyPayment * nCurrent) - PCurrent;
        
        // New Loan Calculation
        double PNew = remainingBalance + cashOut;
        double rNew = newRate / 100 / MONTHS_IN_YEAR;
        int nNew = newTermYears * MONTHS_IN_YEAR;
        
        // Calculate new monthly payment
        double MNew = PNew * (rNew * Math.pow(1 + rNew, nNew)) / (Math.pow(1 + rNew, nNew) - 1);
        
        // Calculate total interest on new loan
        double totalNewPayments = MNew * nNew;
        double totalInterestNew = totalNewPayments - PNew;
        
        // Calculate lifetime savings
        double lifetimeSavings = remainingInterestCurrent - totalInterestNew - upfrontCosts(PNew, points, costsFees) - monthlyPayment;
        
        // Calculate other metrics
        double monthlySavings = monthlyPayment - MNew;
        long timeSaved = (long)nCurrent - nNew;
        double upfrontCost = upfrontCosts(PNew, points, costsFees);
        
        // Calculate APR (simplified)
        double APR = newRate + (upfrontCost / PNew) * MONTHS_IN_YEAR;

        return new RefinanceResults(APR, MNew, monthlySavings, timeSaved, lifetimeSavings, upfrontCost);
    }

    // Method to calculate upfront costs
    public double upfrontCosts(double loanAmount, double points, double costsFees) {
        return (points / 100 * loanAmount) + costsFees;
    }

    // Method to format numbers as currency
    public String formatCurrency(double value) {
         return currencyFormat.format(value);
    }

    // Class to hold refinance results
    public static class RefinanceResults {
        double APR, newMonthlyPayment, monthlySavings, lifetimeSavings, upfrontCost;
        long timeSaved;

        public RefinanceResults(double APR, double newMonthlyPayment, double monthlySavings, long timeSaved, 
                                double lifetimeSavings, double upfrontCost) {
            this.APR = APR;
            this.newMonthlyPayment = newMonthlyPayment;
            this.monthlySavings = monthlySavings;
            this.timeSaved = timeSaved;
            this.lifetimeSavings = lifetimeSavings;
            this.upfrontCost = upfrontCost;
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
    
    private void clearFields(){
        remainingBalanceField.setText("$");
        monthlyPaymentField.setText("$");
        currentRateField.setText("%");
        newTermYearsField.setText("");
        newRateField.setText("%");
        pointsField.setText("");
        costsFeesField.setText("$");
        cashOutField.setText("$");
        resultLabel.setText("");
        result_monthlyLabel.setText("New Monthly Pay:");
    }
}

// New JFrame class for the currency calculator
class DownPaymentCalculator extends JFrame{
    private final Image backgroundImage;
    private final NumberFormat currencyFormat;
    private JButton calculateButton, clearButton;
    private JTextField cashAvailableField, downPaymentField, closingCostsField;
    private JTextField interestRateField, loanTermField;
    private JLabel homePriceResult, downPaymentResult, closingCostsResult;
    private JLabel loanAmountResult, monthlyPaymentResult;
    
    public DownPaymentCalculator() {
       // Load the background image
       backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/downpayment_calculator_background.png")).getImage();
       // Set up the JFrame
       setTitle("Down Payment Calculator");
       setSize(1200, 800);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setLocationRelativeTo(null);
       setResizable(false);
       // Create currency formatter for USD
       currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
       
       // Add content to the JFrame (background panel)
       setContentPane(new ImagePanel());
    }
    
    // Inner class to handle the background image panel
    private class ImagePanel extends JPanel{
        private final JButton backButton;
        private final JLabel titleLabel;
        private final JLabel cashAvailableLabel, downPaymentLabel, closingCostsLabel;
        private final JLabel interestRateLabel, loanTermLabel;
        private final JLabel homePriceLabel, homePriceLabel2, downPaymentLabelName, closingCostsLabelName;
        private final JLabel loanAmountLabel, monthlyPaymentLabel;
        
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
            titleLabel = new JLabel("Down Payment Calculator");
            titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
            titleLabel.setForeground(Color.BLACK);
            titleLabel.setBounds(175, 10, 800, 200);
            add(titleLabel);
            
            // Create and set up the "Calculate" JButton
            calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
            calculateButton.setForeground(Color.BLACK); // Set text color to black
            calculateButton.setBackground(new Color(169, 223, 191)); // Set background color to green
            calculateButton.setBounds(100, 630, 200, 50); // Position and size of the button
            add(calculateButton); // Add button to the panel
            calculateButton.addActionListener(e -> calculate_home_puurchase());
            
            // Create and set up the "Clear" JButton
            clearButton = new JButton("Clear");
            clearButton.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
            clearButton.setForeground(Color.WHITE); // Set text color to white
            clearButton.setBackground(Color.GRAY); // Set background color to gray
            clearButton.setBounds(350, 630, 150, 50); // Position and size of the button
            add(clearButton); // Add button to the panel
            clearButton.addActionListener(e -> clearFields());
            
            cashAvailableLabel = new JLabel("Upfront Cash Avail.");
            cashAvailableLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32)); // Set font and style
            cashAvailableLabel.setForeground(Color.BLACK); // Set text color
            cashAvailableLabel.setBounds(40, 200, 300, 40);
            add(cashAvailableLabel);
            
            cashAvailableField = new JTextField("$");
            cashAvailableField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            cashAvailableField.setForeground(Color.BLACK);
            cashAvailableField.setBounds(340, 200, 200,50);
            cashAvailableField.addFocusListener(new CurrencyFormatFocusListener());
            add(cashAvailableField);
            
            downPaymentLabel = new JLabel("Down Payment");
            downPaymentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32)); // Set font and style
            downPaymentLabel.setForeground(Color.BLACK); // Set text color
            downPaymentLabel.setBounds(40, 280, 250, 40);
            add(downPaymentLabel);
            
            downPaymentField = new JTextField("                                           %");
            downPaymentField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            downPaymentField.setForeground(Color.BLACK);
            downPaymentField.setBounds(340, 280, 200,50);
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
            
            closingCostsLabel = new JLabel("Closing Costs");
            closingCostsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32)); // Set font and style
            closingCostsLabel.setForeground(Color.BLACK); // Set text color
            closingCostsLabel.setBounds(40, 360, 250, 40);
            add(closingCostsLabel);
            
            closingCostsField = new JTextField("                                   %");
            closingCostsField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            closingCostsField.setForeground(Color.BLACK);
            closingCostsField.setBounds(340, 360, 200,50);
            // Add a FocusListener to manage the % symbol
            closingCostsField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (closingCostsField.getText().endsWith("%")) {
                        closingCostsField.setText(closingCostsField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!closingCostsField.getText().isEmpty() && !closingCostsField.getText().endsWith("%")) {
                        closingCostsField.setText(closingCostsField.getText().trim() + "%");
                    }
                }
            });
            add(closingCostsField);
            
            interestRateLabel = new JLabel("Interest Rate");
            interestRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32)); // Set font and style
            interestRateLabel.setForeground(Color.BLACK); // Set text color
            interestRateLabel.setBounds(40, 440, 250, 40);
            add(interestRateLabel);
            
            interestRateField = new JTextField("                                %");
            interestRateField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            interestRateField.setForeground(Color.BLACK);
            interestRateField.setBounds(340, 440, 200,50);
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
            
            loanTermLabel = new JLabel("Loan Term (years)");
            loanTermLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32)); // Set font and style
            loanTermLabel.setForeground(Color.BLACK); // Set text color
            loanTermLabel.setBounds(40, 520, 250, 40);
            add(loanTermLabel);
            
            loanTermField = new JTextField("");
            loanTermField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            loanTermField.setForeground(Color.BLACK);
            loanTermField.setBounds(340, 520, 200,50);
            // Add KeyListener to validate input
            loanTermField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(loanTermField);
            
            homePriceLabel = new JLabel("Home Price:");
            homePriceLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
            homePriceLabel.setForeground(Color.WHITE);
            homePriceLabel.setBounds(590,200,600,50);
            add(homePriceLabel);
            
            homePriceLabel2 = new JLabel("Home Price ");
            homePriceLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 32));
            homePriceLabel2.setForeground(Color.BLACK);
            homePriceLabel2.setBounds(590,310,250,50);
            add(homePriceLabel2);
            
            downPaymentLabelName = new JLabel("Down Payment");
            downPaymentLabelName.setFont(new Font("Times New Roman", Font.PLAIN, 32));
            downPaymentLabelName.setForeground(Color.BLACK);
            downPaymentLabelName.setBounds(590,380,250,50);
            add(downPaymentLabelName);
            
            closingCostsLabelName = new JLabel("Closing Costs");
            closingCostsLabelName.setFont(new Font("Times New Roman", Font.PLAIN, 32));
            closingCostsLabelName.setForeground(Color.BLACK);
            closingCostsLabelName.setBounds(590,450,250,50);
            add(closingCostsLabelName);
            
            loanAmountLabel = new JLabel("Loan Amount");
            loanAmountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
            loanAmountLabel.setForeground(Color.BLACK);
            loanAmountLabel.setBounds(590,520,250,50);
            add(loanAmountLabel);
            
            monthlyPaymentLabel = new JLabel("Monthly Payment");
            monthlyPaymentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
            monthlyPaymentLabel.setForeground(Color.BLACK);
            monthlyPaymentLabel.setBounds(590,590,250,50);
            add(monthlyPaymentLabel);
            
            homePriceResult = new JLabel("");
            homePriceResult.setFont(new Font("Times New Roman", Font.BOLD, 32));
            homePriceResult.setForeground(Color.BLACK);
            homePriceResult.setBounds(880,310,250,50);
            add(homePriceResult);
            
            downPaymentResult = new JLabel("");
            downPaymentResult.setFont(new Font("Times New Roman", Font.BOLD, 32));
            downPaymentResult.setForeground(Color.BLACK);
            downPaymentResult.setBounds(880,380,250,50);
            add(downPaymentResult);
            
            closingCostsResult = new JLabel("");
            closingCostsResult.setFont(new Font("Times New Roman", Font.BOLD, 32));
            closingCostsResult.setForeground(Color.BLACK);
            closingCostsResult.setBounds(880,450,250,50);
            add(closingCostsResult);
            
            loanAmountResult = new JLabel("");
            loanAmountResult.setFont(new Font("Times New Roman", Font.BOLD, 32));
            loanAmountResult.setForeground(Color.BLACK);
            loanAmountResult.setBounds(880,520,250,50);
            add(loanAmountResult);
            
            monthlyPaymentResult = new JLabel("");
            monthlyPaymentResult.setFont(new Font("Times New Roman", Font.BOLD, 32));
            monthlyPaymentResult.setForeground(Color.BLACK);
            monthlyPaymentResult.setBounds(880,590,250,50);
            add(monthlyPaymentResult);
            
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
        
        public void calculate_home_puurchase(){
            try{
                double cashAvailable = parseCurrency(cashAvailableField.getText());
                double downPayment_pct = parsePercentage(downPaymentField.getText());
                double closingCosts_pct = parsePercentage(closingCostsField.getText());
                double interestRate = parsePercentage(interestRateField.getText());
                double loanTerm = Integer.parseInt(loanTermField.getText().trim());
                
                double down_payment_rate = downPayment_pct / 100;
                double closing_cost_rate = closingCosts_pct / 100;
                
                double home_price = cashAvailable / (down_payment_rate + closing_cost_rate);
                
                double down_payment = home_price * down_payment_rate;
                double closing_costs = home_price * closing_cost_rate;
                double loan_amount = home_price - down_payment;
                
                double monthly_rate = (interestRate/100) / 12;
                double num_payments = loanTerm * 12;
                
                double monthly_payment = loan_amount * (monthly_rate * Math.pow(1 + monthly_rate, num_payments)) / 
                         (Math.pow(1 + monthly_rate, num_payments) - 1);
                
                // Display results
                homePriceResult.setText(currencyFormat.format(home_price));
                downPaymentResult.setText(currencyFormat.format(down_payment));
                closingCostsResult.setText(currencyFormat.format(closing_costs));
                loanAmountResult.setText(currencyFormat.format(loan_amount));
                monthlyPaymentResult.setText(currencyFormat.format(monthly_payment));
                homePriceLabel.setText("Home Price: " + currencyFormat.format(home_price));

                
        }catch  (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please ensure all fields are filled with valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
    }
        // Helper method to parse currency inputs (removes "$" and commas)
        private double parseCurrency(String text) {
            text = text.replaceAll("[^\\d.]", ""); // Remove everything except digits and decimals
            return text.isEmpty() ? 0 : Double.parseDouble(text);
        }
        
        // Helper method to parse percentage inputs (removes "%")
        private double parsePercentage(String text) {
            text = text.replaceAll("[^\\d.]", ""); // Remove everything except digits and decimals
            return text.isEmpty() ? 0 : Double.parseDouble(text);
        }

        private void clearFields(){
            cashAvailableField.setText("$");
            downPaymentField.setText("");
            closingCostsField.setText("");
            interestRateField.setText("");
            loanTermField.setText("");
            homePriceLabel.setText("Home Price: ");
            homePriceResult.setText("");
            downPaymentResult.setText("");
            closingCostsResult.setText("");
            loanAmountResult.setText("");
            monthlyPaymentResult.setText("");
        }
        
        @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
    }
    
}

class RentCalculator extends JFrame{
    private final Image backgroundImage;
    private final NumberFormat currencyFormat;
    private JButton calculateButton, clearButton;
    private JTextField preTaxIncomeField, debtPaybackFField;
    private JComboBox selectionComboBox;
    private JLabel resultsInfoLabel;
    
    public RentCalculator(){
       // Load the background image
       backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/rentCalculator_background.png")).getImage();
       // Set up the JFrame
       setTitle("Rent Calculator");
       setSize(1200, 800);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setLocationRelativeTo(null);
       setResizable(false);
       // Create currency formatter for USD
       currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
       
       // Add content to the JFrame (background panel)
       setContentPane(new ImagePanel());
    }
    
    // Inner class to handle the background image panel
    private class ImagePanel extends JPanel{
        private final JButton backButton, calculateButton, clearButton;
        private final JLabel titleLabel, resultLabel, preTaxIncomeLabel, debtPaybackLabel;
        private final JLabel restOfInfo;
        private final String[] selectionIncome = {
          "per year", "per month"  
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
            titleLabel = new JLabel("Rent Calculator");
            titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
            titleLabel.setForeground(Color.BLACK);
            titleLabel.setBounds(175, 10, 800, 200);
            add(titleLabel);
            
            // Create and set up the "Calculate" JButton
            calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
            calculateButton.setForeground(Color.BLACK); // Set text color to black
            calculateButton.setBackground(new Color(169, 223, 191)); // Set background color to green
            calculateButton.setBounds(400, 430, 200, 50); // Position and size of the button
            add(calculateButton); // Add button to the panel
            calculateButton.addActionListener(e -> calculate_rent_payment());
            
            // Create and set up the "Clear" JButton
            clearButton = new JButton("Clear");
            clearButton.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
            clearButton.setForeground(Color.WHITE); // Set text color to white
            clearButton.setBackground(Color.GRAY); // Set background color to gray
            clearButton.setBounds(650, 430, 150, 50); // Position and size of the button
            add(clearButton); // Add button to the panel
            clearButton.addActionListener(e -> clearFields());
            
            preTaxIncomeLabel = new JLabel("Your pre-tax income");
            preTaxIncomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            preTaxIncomeLabel.setForeground(Color.BLACK);
            preTaxIncomeLabel.setBounds(90,210,350,50);
            add(preTaxIncomeLabel);
            
            preTaxIncomeField = new JTextField("$");
            preTaxIncomeField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            preTaxIncomeField.setForeground(Color.BLACK);
            preTaxIncomeField.setBounds(460,215,250,40);
            preTaxIncomeField.addFocusListener(new CurrencyFormatFocusListener());
            add(preTaxIncomeField);
            
            selectionComboBox = new JComboBox<>(selectionIncome);
            selectionComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            selectionComboBox.setBounds(720,215,170,40);
            add(selectionComboBox);
            
            debtPaybackLabel = new JLabel("Your monthly debt payback");
            debtPaybackLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            debtPaybackLabel.setForeground(Color.BLACK);
            debtPaybackLabel.setBounds(90,300,350,50);
            add(debtPaybackLabel);
            
            debtPaybackFField = new JTextField("$");
            debtPaybackFField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            debtPaybackFField.setForeground(Color.BLACK);
            debtPaybackFField.setBounds(460,300,250,50);
            debtPaybackFField.addFocusListener(new CurrencyFormatFocusListener());
            add(debtPaybackFField);
            
            restOfInfo = new JLabel("car/student loan, credit cards, etc.");
            restOfInfo.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            restOfInfo.setForeground(Color.BLACK);
            restOfInfo.setBounds(720,305,500,50);
            add(restOfInfo);
            
            resultLabel = new JLabel("Result");
            resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
            resultLabel.setForeground(Color.WHITE);
            resultLabel.setBounds(90,530,150,50);
            add(resultLabel);
            
            resultsInfoLabel = new JLabel("");
            resultsInfoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
            resultsInfoLabel.setForeground(Color.BLACK);
            resultsInfoLabel.setBounds(85,540,1100,200);
            add(resultsInfoLabel);
        }
        
        public void calculate_rent_payment() {
            try {
                // Parse the pre-tax income
                double preTaxIncome = Double.parseDouble(preTaxIncomeField.getText().replace(",", "").replace("$", ""));

                // Determine if the input is annual or monthly
                String incomeSelection = (String) selectionComboBox.getSelectedItem();
                if ("per year".equals(incomeSelection)) {
                    preTaxIncome /= 12; // Convert annual income to monthly income
                }

                // Parse the monthly debt payback
                double monthlyDebt = Double.parseDouble(debtPaybackFField.getText().replace(",", "").replace("$", ""));

                // Calculate affordability
                double maxRent3Percent = preTaxIncome * 0.36 - monthlyDebt; // Maximum based on 40% rule
                double recommendedRent = preTaxIncome * 0.28 - monthlyDebt; // Conservative recommendation (28% rule)

                // Check if affordability is viable
                if (maxRent3Percent <= 0 || recommendedRent <= 0) {
                    resultsInfoLabel.setText("<html><div style='color:red;'>"
                            + "At that income and debt level, it will be hard to meet rent payments."
                            + "</div></html>");
                } else {
                    // Format results as currency, without decimals
                    DecimalFormat currencyFormat = new DecimalFormat("$#,##0");

                    // Format results
                    String maxRentFormatted = currencyFormat.format(maxRent3Percent);
                    String recommendedRentFormatted = currencyFormat.format(recommendedRent);

                    // Display results with numbers in green and bold
            resultsInfoLabel.setText("<html>"
                    + "You can afford up to <span style='color:green; font-weight:bold;'>" + maxRentFormatted + "</span> per month on a rental payment. "
                    + "It is recommended to keep your rental payment below <span style='color:green; font-weight:bold;'>" + recommendedRentFormatted + "</span> per month."
                    + "</html>");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values for all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }


        private void clearFields(){
            preTaxIncomeField.setText("$");
            selectionComboBox.setSelectedIndex(0);
            debtPaybackFField.setText("$");
            resultsInfoLabel.setText("");
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
}

public class InterestCalculator extends JFrame {
    private final Image backgroundImage;
    private final NumberFormat currencyFormat;
    private JButton calculateButton, clearButton;
    private JLabel resultNamesLabel;
    private JTextField initialInvestmentField, annualContribField, monthlyContribField, interestRateField;
    private JTextField investmentLengthField, taxRateField, inflationRateField;
    private JComboBox<String> compoundComboxBox;
    private JPanel PieChartPanel;
    
    public InterestCalculator(){
        // Load the background image
        backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/interest_calculator_background.png")).getImage();
        // Set up the JFrame
        setTitle("Interest Calculator");
        setSize(1200, 820);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        // Create currency formatter for USD
        currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

        // Add content to the JFrame (background panel)
        setContentPane(new ImagePanel());
    }
    
    private class ImagePanel extends JPanel{
        private final JLabel titleLabel, resultTitleLabel;
        private final JButton backButton;
        private final JLabel initialInvestmentLabel, annualContribLabel, monthlyContribLabel, interestRateLabel;
        private final JLabel compoundLabel, investmentLengthLabel, taxRateLabel, inflationRateLabel;
        
        private final String[] timeOptions = {
            " annually", " semianually", " quaterly", " monthly", " semimonthly", " biweekly", " weekly", " daily", " continuously"
        };
        
        
        public ImagePanel(){
            setLayout(null);
            
            // Back button setup
            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png")));
            backButton.setBounds(20, 20, 80, 40);
            add(backButton);
            backButton.addActionListener(e -> {
                InvestmentCategory InvestmentCategoryFrame = new InvestmentCategory();
                InvestmentCategoryFrame.setVisible(true);
                dispose();
            });
            
            // Title label setup
            titleLabel = new JLabel("Interest Calculator");
            titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
            titleLabel.setForeground(Color.BLACK);
            titleLabel.setBounds(175, 10, 800, 200);
            add(titleLabel);
            
            // Create and set up the "Calculate" JButton
            calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
            calculateButton.setForeground(Color.BLACK); // Set text color to black
            calculateButton.setBackground(new Color(169, 223, 191)); // Set background color to green
            calculateButton.setBounds(100, 630, 200, 60); // Position and size of the button
            calculateButton.addActionListener(e -> {
                try {
                    double initialInvestment = parseCurrency(initialInvestmentField.getText());
                    double annualContrib = parseCurrency(annualContribField.getText());
                    double monthlyContrib = parseCurrency(monthlyContribField.getText());
                    double interestRate = parsePercentage(interestRateField.getText());
                    int years = Integer.parseInt(investmentLengthField.getText().trim());
                    double taxRate = parsePercentage(taxRateField.getText());
                    double inflationRate = parsePercentage(inflationRateField.getText());
                    int compoundPeriod = compoundComboxBox.getSelectedIndex() + 1;  // Example, depends on selected period

                    // Call the method to calculate results
                    Map<String, Double> results = calculate_endingBalance(initialInvestment, annualContrib, monthlyContrib,
                            interestRate, years, taxRate, inflationRate, compoundPeriod);

                    // Update the result label
                    resultNamesLabel.setText("<html>" +
                        "<body style='margin: 0; padding: 0;'>" +
                        "<table style='margin: 5px 0; padding: 0;'>" +
                            "<tr><td><b>Ending balance</b></td><td><td><span style='font-weight: bold;'>" + currencyFormat.format(results.get("ending_balance")) + "</span></td></td></tr>" +
                            "<tr><td>Total principal</td><td><td>" + currencyFormat.format(results.get("total_principal")) + "</td></td></tr>" +
                            "<tr><td>Total contributions</td><td><td>" + currencyFormat.format(results.get("total_contrib")) + "</td></td></tr>" +
                            "<tr><td><b>Total interest</b></td><td><td><span style='font-weight: bold;'>" + currencyFormat.format(results.get("total_interest")) + "</span></td></td></tr>" +
                            "<tr><td>Interest of initial investment</td><td><td>" + currencyFormat.format(results.get("interest_of_initial_investment")) + "</td></td></tr>" +
                            "<tr><td>Interest of the contributions</td><td><td>" + currencyFormat.format(results.get("interest_of_contrib")) + "</td></td></tr>" +
                            "<tr><td>Total tax</td><td><td>" + currencyFormat.format(results.get("total_tax")) + "</td></td></tr>" +        
                            "<tr><td>Total interest after tax</td><td><td>" + currencyFormat.format(results.get("total_interest_after_tax")) + "</td></td></tr>" +        
                            "<tr><td>Buying power of the end balance</td><td><td>" + currencyFormat.format(results.get("buying_power")) + "</td<</td></tr>" +
                        "</table>" +
                        "</body>" +
                        "</html>");
                    
                    // Update results on UI
                    updateResultLabel(results);

                    // Create and display the pie chart
                    addPieChart(results);
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                }
            });
            add(calculateButton); // Add button to the panel
            
            // Create and set up the "Clear" JButton
            clearButton = new JButton("Clear");
            clearButton.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
            clearButton.setForeground(Color.WHITE); // Set text color to white
            clearButton.setBackground(Color.GRAY); // Set background color to gray
            clearButton.setBounds(350, 630, 150, 60); // Position and size of the button
            clearButton.addActionListener(e -> clearFields());
            add(clearButton); // Add button to the panel
            
            resultTitleLabel = new JLabel("Results");
            resultTitleLabel.setFont(new Font("Times New Roman",Font.BOLD, 44));
            resultTitleLabel.setForeground(Color.WHITE);
            resultTitleLabel.setBounds(615,185,200,50);
            add(resultTitleLabel);
            
           resultNamesLabel = new JLabel("""
            <html>
                <body style="margin: ; padding: 0;">
                    <p style="margin: 5; padding: 0;"><b>Ending balance</b></p>
                    <p style="margin: 5; padding: 0;">Total principal</p>
                    <p style="margin: 5; padding: 0;">Total contributions</p>
                    <p style="margin: 5; padding: 0;"><b>Total interest</b></p>
                    <p style="margin: 5; padding: 0;">Interest of initial investment</p>
                    <p style="margin: 5; padding: 0;">Interest of the contributions</p>
                    <p style="margin: 5; padding: 0;">Total tax</p>
                    <p style="margin: 5; padding: 0;">Total interest after tax</p>
                    <p style="margin: 5; padding: 0;">Buying power of the end balance</p>
                </body>
            </html>
            """);

            resultNamesLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            resultNamesLabel.setForeground(Color.BLACK);
            resultNamesLabel.setBounds(595, 180, 550,450);
            add(resultNamesLabel);

            
            // Initial investment label and field set up
            initialInvestmentLabel = new JLabel("Initial Investment");
            initialInvestmentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            initialInvestmentLabel.setForeground(Color.BLACK);
            initialInvestmentLabel.setBounds(40,200,350,40);
            add(initialInvestmentLabel);
            
            initialInvestmentField = new JTextField("$");
            initialInvestmentField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            initialInvestmentField.setForeground(Color.BLACK);
            initialInvestmentField.setBounds(340,200,220,40);
            initialInvestmentField.addFocusListener(new CurrencyFormatFocusListener());
            add(initialInvestmentField);
            
            // Annual contribution label and field set up
            annualContribLabel = new JLabel("Annual Contribution");
            annualContribLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            annualContribLabel.setForeground(Color.BLACK);
            annualContribLabel.setBounds(40,250,350,40);
            add(annualContribLabel);
            
            annualContribField = new JTextField("$");
            annualContribField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            annualContribField.setForeground(Color.BLACK);
            annualContribField.setBounds(340,250,220,40);
            annualContribField.addFocusListener(new CurrencyFormatFocusListener());
            add(annualContribField);
            
            // Monthly contribution label and field set up
            monthlyContribLabel = new JLabel("Monthly Contribution");
            monthlyContribLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            monthlyContribLabel.setForeground(Color.BLACK);
            monthlyContribLabel.setBounds(40,300,350,40);
            add(monthlyContribLabel);
            
            monthlyContribField = new JTextField("$");
            monthlyContribField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            monthlyContribField.setForeground(Color.BLACK);
            monthlyContribField.setBounds(340,300,220,40);
            monthlyContribField.addFocusListener(new CurrencyFormatFocusListener());
            add(monthlyContribField);
            
            // Interest Rate label and field set up
            interestRateLabel = new JLabel("Interest Rate");
            interestRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            interestRateLabel.setForeground(Color.BLACK);
            interestRateLabel.setBounds(40,350,350,40);
            add(interestRateLabel);
            
            interestRateField = new JTextField("                                        %");
            interestRateField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            interestRateField.setForeground(Color.BLACK);
            interestRateField.setBounds(340,350,220,40);
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
            
            // Compound label and field set up
            compoundLabel = new JLabel("Compound");
            compoundLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            compoundLabel.setForeground(Color.BLACK);
            compoundLabel.setBounds(40,400,350,40);
            add(compoundLabel);
            
            compoundComboxBox = new JComboBox<>(timeOptions);
            compoundComboxBox.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            compoundComboxBox.setBounds(340,400,220,40);
            add(compoundComboxBox);
            
            // Investment Length label and field set up
            investmentLengthLabel = new JLabel("Investment length (years)");
            investmentLengthLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            investmentLengthLabel.setForeground(Color.BLACK);
            investmentLengthLabel.setBounds(40,450,350,40);
            add(investmentLengthLabel);
            
            investmentLengthField = new JTextField("");
            investmentLengthField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            investmentLengthField.setForeground(Color.BLACK);
            investmentLengthField.setBounds(340,450,220,40);
            // Add KeyListener to validate input
            investmentLengthField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(investmentLengthField);
            
            // Tax Rate label and field set up
            taxRateLabel = new JLabel("Tax Rate");
            taxRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            taxRateLabel.setForeground(Color.BLACK);
            taxRateLabel.setBounds(40,500,350,40);
            add(taxRateLabel);
            
            taxRateField = new JTextField("                                        %");
            taxRateField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            taxRateField.setForeground(Color.BLACK);
            taxRateField.setBounds(340,500,220,40);
             // Add a FocusListener to manage the % symbol
            taxRateField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (taxRateField.getText().endsWith("%")) {
                        taxRateField.setText(taxRateField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!taxRateField.getText().isEmpty() && !taxRateField.getText().endsWith("%")) {
                        taxRateField.setText(taxRateField.getText().trim() + "%");
                    }
                }
            });
            add(taxRateField);
            
            // Inflation Rate label and field set up
            inflationRateLabel = new JLabel("Inflation Rate");
            inflationRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            inflationRateLabel.setForeground(Color.BLACK);
            inflationRateLabel.setBounds(40,550,350,40);
            add(inflationRateLabel);
            
            inflationRateField = new JTextField("                                        %");
            inflationRateField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
            inflationRateField.setForeground(Color.BLACK);
            inflationRateField.setBounds(340,550,220,40);
             // Add a FocusListener to manage the % symbol
            inflationRateField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (inflationRateField.getText().endsWith("%")) {
                        inflationRateField.setText(inflationRateField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!inflationRateField.getText().isEmpty() && !inflationRateField.getText().endsWith("%")) {
                        inflationRateField.setText(inflationRateField.getText().trim() + "%");
                    }
                }
            });
            add(inflationRateField);   
        }
        
        public Map<String, Double> calculate_endingBalance(double initialInvestment, double annualContrib, 
                                                   double monthlyContrib, double interestRate, 
                                                   int years, double taxRate, 
                                                   double inflationRate, int compoundPeriod) {
            Map<String, Double> results = new HashMap<>();

            // Convert rates to decimal
            double annualInterestRate = interestRate / 100.0;
            double annualTaxRate = taxRate / 100.0;
            double annualInflationRate = inflationRate / 100.0;

            // Total contributions
            double totalContributions = initialInvestment + 
                                        (annualContrib * years) + 
                                        (monthlyContrib * 12 * years);

            // Compound calculation based on periods
            double endingBalance;
            endingBalance = switch (compoundPeriod) {
                case 1 -> initialInvestment * Math.pow(1 + annualInterestRate, years);
                case 2 -> initialInvestment * Math.pow(1 + (annualInterestRate/2), years*2);
                case 3 -> initialInvestment * Math.pow(1 + (annualInterestRate/4), years*4);
                case 4 -> initialInvestment * Math.pow(1 + (annualInterestRate/12), years*12);
                case 5 -> initialInvestment * Math.pow(1 + (annualInterestRate/24), years*24);
                case 6 -> initialInvestment * Math.pow(1 + (annualInterestRate/26), years*26);
                case 7 -> initialInvestment * Math.pow(1 + (annualInterestRate/52), years*52);
                case 8 -> initialInvestment * Math.pow(1 + (annualInterestRate/365), years*365);
                case 9 -> initialInvestment * Math.exp(annualInterestRate * years);
                default -> initialInvestment * Math.pow(1 + annualInterestRate, years);
            }; 

            // Add periodic contributions with compound interest
            double periodicContribution = annualContrib + (monthlyContrib * 12);
            for (int i = 0; i < years; i++) {
                endingBalance += periodicContribution * Math.pow(1 + annualInterestRate, years - i);
            }

            // Calculate interest amounts
            double totalInterest = endingBalance - totalContributions;
            double initialInvestmentInterest = initialInvestment * (Math.pow(1 + annualInterestRate, years) - 1);
            double contributionsInterest = totalInterest - initialInvestmentInterest;

            // Calculate tax
            double totalTax = totalInterest * annualTaxRate;
            double afterTaxInterest = totalInterest - totalTax;

            // Calculate buying power (inflation adjustment)
            double buyingPower = endingBalance / Math.pow(1 + annualInflationRate, years);

            // Populate results map
            results.put("ending_balance", endingBalance);
            results.put("total_principal", totalContributions);
            results.put("total_contrib", totalContributions - initialInvestment);
            results.put("total_interest", totalInterest);
            results.put("interest_of_initial_investment", initialInvestmentInterest);
            results.put("interest_of_contrib", contributionsInterest);
            results.put("total_tax", totalTax);
            results.put("total_interest_after_tax", afterTaxInterest);
            results.put("buying_power", buyingPower);

            return results;
        }
        
        private void clearFields(){
            resultNamesLabel.setText("""
            <html>
                <body style="margin: ; padding: 0;">
                    <p style="margin: 5; padding: 0;"><b>Ending balance</b></p>
                    <p style="margin: 5; padding: 0;">Total principal</p>
                    <p style="margin: 5; padding: 0;">Total contributions</p>
                    <p style="margin: 5; padding: 0;"><b>Total interest</b></p>
                    <p style="margin: 5; padding: 0;">Interest of initial investment</p>
                    <p style="margin: 5; padding: 0;">Interest of the contributions</p>
                    <p style="margin: 5; padding: 0;">total tax</p>
                    <p style="margin: 5; padding: 0;">total interest after tax</p>
                    <p style="margin: 5; padding: 0;">Buying power of the end balance</p>
                </body>
            </html>
            """);
            initialInvestmentField.setText("$");
            annualContribField.setText("$");
            monthlyContribField.setText("$");
            interestRateField.setText("                                    %");
            investmentLengthField.setText("");
            taxRateField.setText("                                    %");
            inflationRateField.setText("                                    %");
            compoundComboxBox.setSelectedIndex(0);
            
            // Remove the pie chart if it exists
            if (PieChartPanel != null) {
                remove(PieChartPanel); // Remove the pie chart panel from the container
                PieChartPanel = null; // Set the PieChartPanel reference to null
                revalidate();  // Revalidate the layout
                repaint();     // Repaint the panel to reflect the changes
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
        
        private void addPieChart(Map<String, Double> results) {
            // Remove any existing chart
            for (Component component : getComponents()) {
                if (component instanceof ChartPanel) {
                    remove(component);
                    break;
                }
            }
            
            double initialInvestment = parseCurrency(initialInvestmentField.getText());
            
            // Create dataset for the pie chart
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Initial Investment", initialInvestment);
            dataset.setValue("Total Contributions", results.get("total_contrib"));
            dataset.setValue("Total Tax", results.get("total_tax"));
            dataset.setValue("Total Interest After Tax", results.get("total_interest_after_tax"));

            // Create the pie chart
            JFreeChart pieChart = ChartFactory.createPieChart(
                    "Investment Breakdown",
                    dataset,
                    true,
                    true,
                    false
            );

            // Add the chart to the panel
            PieChartPanel = new ChartPanel(pieChart);
            PieChartPanel.setBounds(750, 560, 280, 200); // Position in the bottom-right corner
            add(PieChartPanel);
            revalidate();
            repaint();
        }
        
        private void updateResultLabel(Map<String, Double> results) {
            resultNamesLabel.setText("<html>" +
                "<body style='margin: 0; padding: 0;'>" +
                "<table style='margin: 5px 0; padding: 0;'>" +
                    "<tr><td><b>Ending balance</b></td><td><td><span style='font-weight: bold;'>" + currencyFormat.format(results.get("ending_balance")) + "</span></td></td></tr>" +
                    "<tr><td>Total principal</td><td><td>" + currencyFormat.format(results.get("total_principal")) + "</td></td></tr>" +
                    "<tr><td>Total contributions</td><td><td>" + currencyFormat.format(results.get("total_contrib")) + "</td></td></tr>" +
                    "<tr><td><b>Total interest</b></td><td><td><span style='font-weight: bold;'>" + currencyFormat.format(results.get("total_interest")) + "</span></td></td></tr>" +
                    "<tr><td>Interest of initial investment</td><td><td>" + currencyFormat.format(results.get("interest_of_initial_investment")) + "</td></td></tr>" +
                    "<tr><td>Interest of the contributions</td><td><td>" + currencyFormat.format(results.get("interest_of_contrib")) + "</td></td></tr>" +
                    "<tr><td>Total tax</td><td><td>" + currencyFormat.format(results.get("total_tax")) + "</td></td></tr>" +        
                    "<tr><td>Total interest after tax</td><td><td>" + currencyFormat.format(results.get("total_interest_after_tax")) + "</td></td></tr>" +        
                    "<tr><td>Buying power of the end balance</td><td><td>" + currencyFormat.format(results.get("buying_power")) + "</td<</td></tr>" +
                "</table>" +
                "</body>" +
                "</html>");
        }
        
         // Helper method to parse currency inputs (removes "$" and commas)
        public double parseCurrency(String text) {
            text = text.replaceAll("[^\\d.]", ""); // Remove everything except digits and decimals
            return text.isEmpty() ? 0 : Double.parseDouble(text);
        }

        // Helper method to parse percentage inputs (removes "%")
        private double parsePercentage(String text) {
            text = text.replaceAll("[^\\d.]", ""); // Remove everything except digits and decimals
            return text.isEmpty() ? 0 : Double.parseDouble(text);
        }
        
        @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
    }
}

public class RothIRACalculator extends JFrame{
    private final Image backgroundImage;
    private final NumberFormat currencyFormat;
    private JLabel titleLabel;
    private ChartPanel chartPanelGraph;
    private JTable resultsTable;
    private JScrollPane scrollPaneTable;
    private JTextField currentBalanceField, annualContributionField, returnRateField, currentAgeField, retirementAgeField, taxRateField;
    private JLabel resultsInfoLabel;
    
    public RothIRACalculator(){
       // Load the background image
       backgroundImage = new ImageIcon(getClass().getResource("/javaapplication_x/images/RothIRA_calculator_background.png")).getImage();
       // Set up the JFrame
       setTitle("Roth IRA Calculator");
       setSize(1200, 800);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setLocationRelativeTo(null);
       setResizable(false);
       // Create currency formatter for USD
       currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
       
       // Add content to the JFrame (background panel)
       setContentPane(new ImagePanel()); 
    }
    
    // Inner class to handle the background image panel
    private class ImagePanel extends JPanel{
        private final JButton backButton, calculateButton, clearButton;
        private final JLabel resultNameLabel;
        private final JLabel currentBalanceLabel, annualContributionLabel, returnRateLabel, currentAgeLabel, retirementAgeLabel, taxRateLabel;
        
        public ImagePanel(){
            setLayout(null);
            
            // Back button setup
            backButton = new JButton(new ImageIcon(getClass().getResource("/javaapplication_x/images/back_button.png")));
            backButton.setBounds(20, 20, 80, 40);
            add(backButton);
            backButton.addActionListener(e -> {
                RetirementCategory RetirementCategoryFrame = new RetirementCategory();
                RetirementCategoryFrame.setVisible(true);
                dispose();
            });
            
            // Title label setup
            titleLabel = new JLabel("Roth IRA Calculator");
            titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
            titleLabel.setForeground(Color.BLACK);
            titleLabel.setBounds(175, 10, 800, 200);
            add(titleLabel);
            
            // Create and set up the "Calculate" JButton
            calculateButton = new JButton("Calculate");
            calculateButton.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
            calculateButton.setForeground(Color.BLACK); // Set text color to black
            calculateButton.setBackground(new Color(169, 223, 191)); // Set background color to green
            calculateButton.setBounds(70, 530, 200, 60); // Position and size of the button
            add(calculateButton); // Add button to the panel
            calculateButton.addActionListener(e -> calculate_Roth_IRA());
            
            // Create and set up the "Clear" JButton
            clearButton = new JButton("Clear");
            clearButton.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Set font
            clearButton.setForeground(Color.WHITE); // Set text color to white
            clearButton.setBackground(Color.GRAY); // Set background color to gray
            clearButton.setBounds(320, 530, 150, 60); // Position and size of the button
            add(clearButton); // Add button to the panel
            clearButton.addActionListener(e -> clearFields());
            
            resultNameLabel = new JLabel("Results");
            resultNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
            resultNameLabel.setForeground(Color.WHITE);
            resultNameLabel.setBounds(570, 180, 200, 50);
            add(resultNameLabel);
            
            // Current Balance JLabel and Field set up
            currentBalanceLabel = new JLabel("Current balance");
            currentBalanceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            currentBalanceLabel.setForeground(Color.BLACK);
            currentBalanceLabel.setBounds(40,200,350,40);
            add(currentBalanceLabel);
            
            currentBalanceField = new JTextField("$");
            currentBalanceField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            currentBalanceField.setForeground(Color.BLACK);
            currentBalanceField.setBounds(300,200,220,40);
            currentBalanceField.addFocusListener(new CurrencyFormatFocusListener());
            add(currentBalanceField);
            
            // Annual Contribution JLabel and Field set up
            annualContributionLabel = new JLabel("Annual contribution");
            annualContributionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            annualContributionLabel.setForeground(Color.BLACK);
            annualContributionLabel.setBounds(40,250,350,40);
            add(annualContributionLabel);
            
            annualContributionField = new JTextField("$");
            annualContributionField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            annualContributionField.setForeground(Color.BLACK);
            annualContributionField.setBounds(300,250,220,40);
            annualContributionField.addFocusListener(new CurrencyFormatFocusListener());
            add(annualContributionField);
            
            // Return Rate JLabel and Field set up
            returnRateLabel = new JLabel("Expected rate of return");
            returnRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            returnRateLabel.setForeground(Color.BLACK);
            returnRateLabel.setBounds(40,300,350,40);
            add(returnRateLabel);
            
            returnRateField = new JTextField("                                      %");
            returnRateField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            returnRateField.setForeground(Color.BLACK);
            returnRateField.setBounds(300,300,220,40);
            // Add a FocusListener to manage the % symbol
            returnRateField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (returnRateField.getText().endsWith("%")) {
                        returnRateField.setText(returnRateField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!returnRateField.getText().isEmpty() && !returnRateField.getText().endsWith("%")) {
                        returnRateField.setText(returnRateField.getText().trim() + "%");
                    }
                }
            });
            add(returnRateField);
            
            // Current Age JLabel and Field set up
            currentAgeLabel = new JLabel("Current age");
            currentAgeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            currentAgeLabel.setForeground(Color.BLACK);
            currentAgeLabel.setBounds(40,350,350,40);
            add(currentAgeLabel);
            
            currentAgeField = new JTextField("");
            currentAgeField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            currentAgeField.setForeground(Color.BLACK);
            currentAgeField.setBounds(300,350,220,40);
            // Add KeyListener to validate input
            currentAgeField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(currentAgeField);
            
            // Retirement Age JLabel and Field set up
            retirementAgeLabel = new JLabel("Retirement age");
            retirementAgeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            retirementAgeLabel.setForeground(Color.BLACK);
            retirementAgeLabel.setBounds(40,400,350,40);
            add(retirementAgeLabel);
            
            retirementAgeField = new JTextField("");
            retirementAgeField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            retirementAgeField.setForeground(Color.BLACK);
            retirementAgeField.setBounds(300,400,220,40);
            // Add KeyListener to validate input
            retirementAgeField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Allow only digits and control characters (e.g., backspace)
                    if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                        e.consume(); // Ignore the invalid character
                        JOptionPane.showMessageDialog(null, "Please enter only numeric values.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            add(retirementAgeField);
            
            // Tax Rate JLabel and Field set up
            taxRateLabel = new JLabel("Marginal tax rate");
            taxRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            taxRateLabel.setForeground(Color.BLACK);
            taxRateLabel.setBounds(40,450,350,40);
            add(taxRateLabel);
            
            taxRateField = new JTextField("                                      %");
            taxRateField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
            taxRateField.setForeground(Color.BLACK);
            taxRateField.setBounds(300,450,220,40);
            // Add a FocusListener to manage the % symbol
            taxRateField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Remove % when field is clicked for editing
                    if (taxRateField.getText().endsWith("%")) {
                        taxRateField.setText(taxRateField.getText().replace("%", "").trim());
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Append % when focus is lost
                    if (!taxRateField.getText().isEmpty() && !taxRateField.getText().endsWith("%")) {
                        taxRateField.setText(taxRateField.getText().trim() + "%");
                    }
                }
            });
            add(taxRateField);
            
            resultsInfoLabel = new JLabel("");
            resultsInfoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            resultsInfoLabel.setForeground(Color.BLACK);
            resultsInfoLabel.setBounds(20,570,1100,200);
            add(resultsInfoLabel);
            
        }
        
        // Method to calculate retirement savings
        private void calculate_Roth_IRA() {
            try {
                // Parse input values
                double currentBalance = parseMonetaryValue(currentBalanceField.getText());
                double annualContribution = parseMonetaryValue(annualContributionField.getText());
                double returnRate = parsePercentage(returnRateField.getText()) / 100.0;
                int currentAge = Integer.parseInt(currentAgeField.getText());
                int retirementAge = Integer.parseInt(retirementAgeField.getText());
                double marginalTaxRate = parsePercentage(taxRateField.getText()) / 100.0;

                // Perform calculations
                RetirementResults results = calculateRetirementSavings(
                    currentBalance, 
                    annualContribution, 
                    returnRate, 
                    currentAge, 
                    retirementAge, 
                    marginalTaxRate
                );

                // Display results in the table
                displayResultsInTable(results);
                
                // Display the graph
                displayBalanceGraph(results);

                // Optional: Display difference in resultsInfoLabel
                double difference = results.rothBalance - results.taxableBalance;
                resultsInfoLabel.setText(String.format("<html>According to provided information, the Roth IRA account can<br> accumulate $%,.0f more than a regular taxable account by age %d.</html>", difference,retirementAge));
                    
            } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(this, "Please ensure all fields are filled with valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Inner class to hold calculation results
        private static class RetirementResults {
            double rothBalance;
            double rothPrincipal;
            double rothInterest;
            double rothTax;

            double taxableBalance;
            double taxablePrincipal;
            double taxableInterest;
            double taxableTax;
        }

        // Calculation method equivalent to Python function
        private RetirementResults calculateRetirementSavings(
            double currentBalance, 
            double annualContribution, 
            double rateOfReturn, 
            int currentAge, 
            int retirementAge, 
            double marginalTaxRate
        ) {
            RetirementResults results = new RetirementResults();
            int years = retirementAge - currentAge;

            // Roth IRA calculations
            double rothBalance = currentBalance;
            for (int i = 0; i < years; i++) {
                rothBalance = rothBalance * (1 + rateOfReturn) + annualContribution;
            }

            results.rothPrincipal = currentBalance + (annualContribution * years);
            results.rothBalance = rothBalance;
            results.rothInterest = rothBalance - results.rothPrincipal;
            results.rothTax = 0;

            // Taxable account calculations
            double taxableBalance = currentBalance;
            double totalInterest = 0;

            for (int i = 0; i < years; i++) {
                // Calculate interest earned this year
                double yearlyInterest = taxableBalance * rateOfReturn;
                totalInterest += yearlyInterest;

                // Apply tax drag to the interest
                double afterTaxInterest = yearlyInterest * (1 - marginalTaxRate);

                // Update balance with after-tax interest and new contribution
                taxableBalance = taxableBalance + afterTaxInterest + annualContribution;
            }

            results.taxablePrincipal = currentBalance + (annualContribution * years);
            results.taxableBalance = taxableBalance;
            results.taxableInterest = totalInterest;
            results.taxableTax = totalInterest * marginalTaxRate;

            return results;
        }

        // Method to display results in a table
        private void displayResultsInTable(RetirementResults results) {
            // Create table model with 3 columns
            String[] columnNames = {"", "Roth IRA", "Taxable Account"};
            Object[][] data = {
                {"Balance at Age " + Integer.valueOf(retirementAgeField.getText()), 
                 String.format("$%,.0f", results.rothBalance), 
                 String.format("$%,.0f", results.taxableBalance)},
                {"Total Principal", 
                 String.format("$%,.0f", results.rothPrincipal), 
                 String.format("$%,.0f", results.taxablePrincipal)},
                {"Total Interest", 
                 String.format("$%,.0f", results.rothInterest), 
                 String.format("$%,.0f", results.taxableInterest)},
                {"Total Tax", 
                 String.format("$%,.0f", results.rothTax), 
                 String.format("$%,.0f", results.taxableTax)},                
            };

            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            
            // Check if resultsTable already exists
            if (resultsTable == null) {
                resultsTable = new JTable(model);
                resultsTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                resultsTable.setRowHeight(30);
                
                

                // Create scroll pane for table
                scrollPaneTable = new JScrollPane(resultsTable);
                scrollPaneTable.setBounds(560, 260, 580, 143);
                add(scrollPaneTable);
            } else {
                // Just update the existing table's model
                resultsTable.setModel(model);
            }

            // Update the results info label
            double difference = results.rothBalance - results.taxableBalance;
            resultsInfoLabel.setText(String.format("<html>According to provided information, the Roth IRA account can<br> accumulate $%,.0f more than a regular taxable account by age %d.</html>", 
                difference, Integer.parseInt(retirementAgeField.getText())));
                
            // Repaint the frame
            revalidate();
            repaint();
                }

        // Helper method to parse monetary values
        private double parseMonetaryValue(String value) {
            // Remove '$' and ',' characters
            String cleanValue = value.replace("$", "").replace(",", "").trim();
            return Double.parseDouble(cleanValue);
        }

        // Helper method to parse percentage values
        private double parsePercentage(String value) {
            // Remove '%' character
            String cleanValue = value.replace("%", "").trim();
            return Double.parseDouble(cleanValue);
        }
        
        // Add this method to your ImagePanel class
        private void displayBalanceGraph(RetirementResults results) {
            // Create series for each line
            XYSeries rothSeries = new XYSeries("Roth IRA");
            XYSeries taxableSeries = new XYSeries("Taxable Account");
            XYSeries principalSeries = new XYSeries("Total Principal");

            // Get input values
            double currentBalance = parseMonetaryValue(currentBalanceField.getText());
            double annualContribution = parseMonetaryValue(annualContributionField.getText());
            double returnRate = parsePercentage(returnRateField.getText()) / 100.0;
            int currentAge = Integer.parseInt(currentAgeField.getText());
            int retirementAge = Integer.parseInt(retirementAgeField.getText());
            double marginalTaxRate = parsePercentage(taxRateField.getText()) / 100.0;

            // Calculate yearly balances
            double rothBalance = currentBalance;
            double taxableBalance = currentBalance;
            double totalPrincipal = currentBalance;

            // Add initial points
            rothSeries.add(currentAge, rothBalance);
            taxableSeries.add(currentAge, taxableBalance);
            principalSeries.add(currentAge, totalPrincipal);

            // Calculate and add points for each year
            for (int age = currentAge + 1; age <= retirementAge; age++) {
                // Update Roth IRA
                rothBalance = rothBalance * (1 + returnRate) + annualContribution;

                // Update Taxable Account
                double yearlyInterest = taxableBalance * returnRate;
                double afterTaxInterest = yearlyInterest * (1 - marginalTaxRate);
                taxableBalance = taxableBalance + afterTaxInterest + annualContribution;

                // Update Total Principal
                totalPrincipal += annualContribution;

                // Add data points
                rothSeries.add(age, rothBalance);
                taxableSeries.add(age, taxableBalance);
                principalSeries.add(age, totalPrincipal);
            }

            // Create dataset
            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(rothSeries);
            dataset.addSeries(taxableSeries);
            dataset.addSeries(principalSeries);

            // Create chart
            JFreeChart chart = ChartFactory.createXYLineChart(
                "Balance Accumulation Over Time",  // Title
                "Age",                            // X-axis label
                "Balance ($)",                    // Y-axis label
                dataset                           // Dataset
            );

            // Customize the plot
            XYPlot plot = chart.getXYPlot();
            plot.setBackgroundPaint(Color.WHITE);
            plot.setDomainGridlinePaint(Color.GRAY);
            plot.setRangeGridlinePaint(Color.GRAY);

            // Customize the renderer
            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            // Roth IRA line (blue)
            renderer.setSeriesPaint(0, new Color(0, 0, 255));
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            // Taxable Account line (green)
            renderer.setSeriesPaint(1, new Color(0, 150, 0));
            renderer.setSeriesStroke(1, new BasicStroke(2.0f));
            // Principal line (orange, dashed)
            renderer.setSeriesPaint(2, new Color(255, 150, 0));
            renderer.setSeriesStroke(2, new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[]{10.0f}, 0.0f));

            plot.setRenderer(renderer);

            // Customize axes
            NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
            rangeAxis.setNumberFormatOverride(NumberFormat.getCurrencyInstance());

            // Create chart panel
            chartPanelGraph = new ChartPanel(chart);
            chartPanelGraph.setBounds(560, 430, 580, 300);
            chartPanelGraph.setMouseWheelEnabled(true);

            // Remove existing chart if it exists
            Component[] components = getComponents();
            for (Component component : components) {
                if (component instanceof ChartPanel) {
                    remove(component);
                }
            }

            // Add new chart
            add(chartPanelGraph);
            revalidate();
            repaint();
        }
        
        private void clearFields(){
            currentBalanceField.setText("$");
            annualContributionField.setText("$");
            returnRateField.setText("                                        %");
            currentAgeField.setText("");
            retirementAgeField.setText("");
            taxRateField.setText("                                          %");
            resultsInfoLabel.setText("");
            
            if (resultsTable != null) {
            remove(resultsTable); // Remove the table's scroll pane
            resultsTable = null;            // Clear the table reference
            revalidate();      // Refresh the layout
            repaint();         // Redraw the UI
        }
            
            if (scrollPaneTable != null) {
            // Remove the JScrollPane containing the JTable
            remove(scrollPaneTable);
            scrollPaneTable = null; // Optional: Nullify reference for clarity
            resultsTable = null; // Optional: Nullify reference for clarity
            
            // Refresh the frame
            revalidate();
            repaint();
        }
                
            // Remove graph if it exists
            if (chartPanelGraph != null) {
                remove(chartPanelGraph); // Remove the pie chart panel from the container
                chartPanelGraph = null; // Set the PieChartPanel reference to null
                revalidate();  // Revalidate the layout
                repaint(); 
                
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
        
        @Override
        protected void paintComponent(Graphics g){
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
