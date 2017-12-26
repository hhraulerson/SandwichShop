button/**
Program that creates a Order Calculation class that 
adds the appropriate panels to a JFrame to display 
a sandwich shop's menu.  This class allows a user to select
what they want on their sandwich and allows the user to 
calculate the subtotal, tax, and total for their order based
on their selections.

@author Hiram Raulerson
@version 1.6
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: December 6, 2015.
 
COP5007	Project #: 6
File Name: OrderCalculation.java
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.SwingConstants;

public class OrderCalculation extends JFrame
{  
   /**
   Stores the total for the user's order
   */
   private double total;
   
   /**
   Stores the subtotal for the user's order
   */
   private double subtotal;
   
   /**
   Stores the tax for the user's order
   */
   private double tax;
   
   /**
   Creates the welcome panel
   */
   private WelcomePanel greeting;
   
   /**
   Creates the bread panel
   */
   private BreadPanel bread;
   
   /**
   Creates the toppings panel
   */
   private ToppingsPanel toppings;
   
   /**
   Creates the cheese panel
   */
   private CheesePanel cheese;
   
   /**
   Creates the meat panel
   */
   private MeatPanel meat;
   
   /**
   Creates a panel to store all of the other panels
   */
   private JPanel orderPanel;
   
   /**
   Creates a panel to store the calculate and exit buttons
   */
   private JPanel buttonPanel;
   
   /**
   Creates the calculate button
   */
   private JButton calculateButton;
   
   /**
   Creates the exit button
   */
   private JButton exitButton;
  
   /**
   Creates an action listener for the calculate button
   */
   private ActionListener calculateListener;
   
   /**
   Creates an action listener for the exit button
   */
   private ActionListener exitListener;
   
   /**
   Stores the width of the JFrame
   */
   private final int WIDTH = 600;
   
   /**
   Stores the height of the JFrame
   */
   private final int HEIGHT = 300;
   
   /**
   Default constructor sets all instance variables to 
   their default values.  Also, creates action listeners 
   for the exit and calculate buttons by creating inner classes
   for the two different action listeners, adds the buttons to the JFrame
   by calling the appropriate method, and formats the layout of the JPanel.
   */
   public OrderCalculation()
   {
      super("Order Calculator");
      setSize(WIDTH, HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      setVisible(true);
      
      greeting = new WelcomePanel();
      bread = new BreadPanel();
      toppings = new ToppingsPanel();
      cheese = new CheesePanel();
      meat = new MeatPanel();
     
      orderPanel = new JPanel();
      orderPanel.setLayout(new GridLayout(1, 4));

      orderPanel.add(bread);
      orderPanel.add(toppings);
      orderPanel.add(cheese);
      orderPanel.add(meat);
      
      total = 0;
      subtotal = 0;
      tax = 0;
      
      add(greeting, BorderLayout.NORTH);
      add(orderPanel, BorderLayout.CENTER);
      
      class CalculateListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            calculateTotal();
         }
      }
   
      class ExitListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            System.exit(0);
         }
      }
      
      calculateListener = new CalculateListener();
      exitListener = new ExitListener();
      
      createButtons();
   }
   
   /**
   Creates the exit and calculate buttons, adds action listeners
   for them, and adds them to the JFrame
   */
   public void createButtons()
   {
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(0, 2));
      
      calculateButton = new JButton("Calculate");
      calculateButton.addActionListener(calculateListener);
      
      exitButton = new JButton("Exit");
      exitButton.addActionListener(exitListener);
      
      buttonPanel.add(calculateButton);
      buttonPanel.add(exitButton);
      
      add(buttonPanel, BorderLayout.SOUTH);
   }
   
   /**
   Creates a new JFrame for the total to be displayed in and
   calculates the subtotal, tax, and total for the user's order
   */
   public void calculateTotal()
   {
      NumberFormat formatter = NumberFormat.getCurrencyInstance();
      
      JFrame totalFrame = new JFrame("Order Total");
      totalFrame.setSize(300, 300);
      totalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      totalFrame.setLayout(new GridLayout(0, 1));
      totalFrame.setVisible(true);
      
      subtotal = bread.getBreadPrice() + toppings.getToppingsTotal() +
      cheese.getCheeseTotal() + meat.getMeatTotal();
      
      tax = 0.07 * subtotal;
      
      total = subtotal + tax;
      
      String subtotalMsg = "Subtotal: " + formatter.format(subtotal) + "\n";
      String taxMsg = "Tax: " + formatter.format(tax) + "\n";
      String totalMsg = "Total: " + formatter.format(total);
      
      JLabel subtotalMessage = new JLabel(subtotalMsg);
      JLabel taxMessage = new JLabel(taxMsg);
      JLabel totalMessage = new JLabel(totalMsg);
      
      subtotalMessage.setHorizontalAlignment(SwingConstants.CENTER);
      taxMessage.setHorizontalAlignment(SwingConstants.CENTER);
      totalMessage.setHorizontalAlignment(SwingConstants.CENTER);
      
      totalFrame.add(subtotalMessage);
      totalFrame.add(taxMessage);
      totalFrame.add(totalMessage);
   }
}
