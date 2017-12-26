/**
Program that creates a Bread Panel class to be
added to a JFrame that displays a sandwich shop's
menu.  This panel allows the user to select which 
type of bread that they want for their sandwich.

@author Hiram Raulerson
@version 1.3
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: December 5, 2015.
 
COP5007	Project #: 6
File Name: BreadPanel.java
*/

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BreadPanel extends JPanel implements ActionListener
{
   /**
   Creates a JLabel to label the panel
   */
   private JLabel label;
   
   /**
   Creates a JRadioButton to allow the user to choose rye as their sandwich bread
   */
   private JRadioButton rye;
   
   /**
   Creates a JRadioButton to allow the user to choose white bread as their sandwich bread
   */
   private JRadioButton white;
   
   /**
   Creates a JRadioButton to allow the user to choose whole wheat bread
   as their sandwich bread
   */
   private JRadioButton wholeWheat;
   
   /**
   Creates a JRadioButton to allow the user to choose gluten free bread
   as their sandwich bread
   */
   private JRadioButton glutenFree;
   
   /**
   Creates a button group to add the JRadioButtons to (makes them mutually
   exclusive)
   */
   private ButtonGroup group;
   
   /**
   Stores the price of the bread the user chooses (based on the radio button that
   is selected)
   */
   private double breadPrice;
   
   /**
   Creates a constant price for rye bread
   */
   private final double RYE_PRICE = 1.80;
   
   /**
   Creates a constant price for white bread
   */
   private final double WHITE_PRICE = 1.50;
   
   /**
   Creates a constant price for whole wheat bread
   */
   private final double WHEAT_PRICE = 1.75;
   
   /**
   Creates a constant price for gluten free bread
   */
   private final double GLUTEN_FREE_PRICE = 2.75;
   
   /**
   Stores the constant width of the bread panel
   */
   private final int WIDTH = 10;
   
   /**
   Stores the constant height of the bread panel
   */
   private final int HEIGHT = 30;
   
   /**
   Default constructor sets all instance variables to 
   their default values.  Also, creates action listeners 
   for the radio buttons, adds the buttons to a button group,
   adds the buttons to the JPanel, and formats the layout of the JPanel.
   */
   public BreadPanel()
   {
      setSize(WIDTH, HEIGHT);
      label = new JLabel("\nChoose your bread");
      rye = new JRadioButton("Rye");
      white = new JRadioButton("White");
      wholeWheat = new JRadioButton("Whole Wheat");
      glutenFree = new JRadioButton("Gluten Free");
      group = new ButtonGroup();
      
      rye.addActionListener(this);
      white.addActionListener(this);
      wholeWheat.addActionListener(this);
      glutenFree.addActionListener(this);
      
      breadPrice = 0;
      
      group.add(rye); 
      group.add(white); 
      group.add(wholeWheat); 
      group.add(glutenFree); 
   
      setLayout(new GridLayout(0, 1));
      
      add(label);
      add(rye);
      add(white);
      add(wholeWheat);
      add(glutenFree);
   }
   
   /**
   Sets the bread price based on the radio button
   selected
   */
   public void setBreadPrice()
   {
      if (rye.isSelected()) 
      { 
         breadPrice = RYE_PRICE; 
      }
      else if (white.isSelected())
      {
         breadPrice = WHITE_PRICE;
      }
      else if (wholeWheat.isSelected())
      {
         breadPrice = WHEAT_PRICE;
      }
      else if (glutenFree.isSelected())
      {
         breadPrice = GLUTEN_FREE_PRICE;
      }
   }
   
   /**
   Returns the total for the bread choosen
   @return the total for the bread selected
   */
   public double getBreadPrice()
   {
      return breadPrice;
   }
   
   /**
   Sets the bread price based on the button selected
   @param e the action event passed to the listener from
   the event
   */
   public void actionPerformed(ActionEvent e)
   {
      setBreadPrice();
   }
   
}