/**
Program that creates a Toppings Panel class to be
added to a JFrame that displays a sandwich shop's
menu.  This panel allows the user to select which 
type of toppings that they want for their sandwich.

@author Hiram Raulerson
@version 1.4
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: December 6, 2015.
 
COP5007	Project #: 6
File Name: ToppingsPanel.java
*/

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ToppingsPanel extends JPanel implements ItemListener
{
   /**
   Creates a JLabel to label the panel
   */
   private JLabel label;
   
   /**
   Creates a check box to allow the user to add mustard as a topping on
   their sandwich bread
   */
   private JCheckBox mustard;
   
   /**
   Creates a check box to allow the user to add mayo as a topping on
   their sandwich bread
   */
   private JCheckBox mayo;
   
   /**
   Creates a check box to allow the user to add ketchup as a topping on
   their sandwich bread
   */
   private JCheckBox ketchup;
   
   /**
   Creates a check box to allow the user to add pickles as a topping on
   their sandwich bread
   */
   private JCheckBox pickles;
   
   /**
   Creates a check box to allow the user to add lettuce as a topping on
   their sandwich bread
   */
   private JCheckBox lettuce;
   
   /**
   Creates a check box to allow the user to add tomatoes as a topping on
   their sandwich bread
   */
   private JCheckBox tomatoes;
   
   /**
   Creates a check box to allow the user to add onions as a topping on
   their sandwich bread
   */
   private JCheckBox onions;
   
   /**
   Stores the price of the toppings the user chooses (based on the check boxes that
   are selected)
   */
   private double toppingsTotal;
   
   /**
   Creates a constant price for mustard
   */
   private final double MUSTARD_PRICE = 0.03;
   
   /**
   Creates a constant price for mayo
   */
   private final double MAYO_PRICE = 0.05;
   
   /**
   Creates a constant price for ketchup
   */
   private final double KETCHUP_PRICE = 0.07;
   
   /**
   Creates a constant price for pickles
   */
   private final double PICKLES_PRICE = 0.25;
   
   /**
   Creates a constant price for lettuce
   */
   private final double LETTUCE_PRICE = 0.11;
   
   /**
   Creates a constant price for tomatoes
   */
   private final double TOMATOES_PRICE = 0.36;
   
   /**
   Creates a constant price for onions
   */
   private final double ONIONS_PRICE = 0.14;
   
   /**
   Stores the constant width of the toppings panel
   */
   private final int WIDTH = 10;
   
   /**
   Stores the constant height of the toppings panel
   */
   private final int HEIGHT = 30;
   
   /**
   Default constructor sets all instance variables to 
   their default values.  Also, creates item listeners 
   for the check boxes buttons, adds the check boxes to
   the JPanel, and formats the layout of the JPanel.
   */
   public ToppingsPanel()
   {
      setSize(WIDTH, HEIGHT);
      label = new JLabel("\nChoose your toppings");
      mustard = new JCheckBox("Mustard");
      mayo = new JCheckBox("Mayo");
      ketchup = new JCheckBox("Ketchup");
      pickles = new JCheckBox("Pickles");
      lettuce = new JCheckBox("Lettuce");
      tomatoes = new JCheckBox("Tomatoes");
      onions = new JCheckBox("Onions");
      
      mustard.addItemListener(this);
      mayo.addItemListener(this);
      ketchup.addItemListener(this);
      pickles.addItemListener(this);
      lettuce.addItemListener(this);
      tomatoes.addItemListener(this);
      onions.addItemListener(this);
      
      toppingsTotal = 0; 
   
      setLayout(new GridLayout(0, 1));
      
      add(label);
      add(mustard);
      add(mayo);
      add(ketchup);
      add(pickles);
      add(lettuce);
      add(tomatoes);
      add(onions);
   }
   
   /**
   Sets the toppings total based on the check box(es)
   selected
   @param price the price that the total will change by
   @param addOrSubtract whether to add or subtract the price change to/from
   the total for the toppings selected
   */
   public void setToppingsTotal(double price, boolean addOrSubtract)
   {
      if (addOrSubtract) 
      { 
         toppingsTotal += price; 
      }
      else
      {
         toppingsTotal -= price;
      }
   }
   
   /**
   Returns the total for the toppings choosen
   @return the total for the toppings selected
   */
   public double getToppingsTotal()
   {
      return toppingsTotal;
   }
   
   /**
   Sets the toppings total based on the check box(es) selected
   @param e the item event passed to the listener from
   the event
   */
   public void itemStateChanged(ItemEvent e)
   {
      boolean addTopping = true;
      
      double priceChange = 0.0;
      
      Object checkBoxSource = e.getItemSelectable();
      
      if (checkBoxSource == mustard) 
      {
         priceChange = MUSTARD_PRICE;
      }
      else if (checkBoxSource == mayo) 
      {
         priceChange = MAYO_PRICE;
      } 
      else if (checkBoxSource == ketchup) 
      {
         priceChange = KETCHUP_PRICE;
      } 
      else if (checkBoxSource == pickles) 
      {
         priceChange = PICKLES_PRICE;
      }  
      else if (checkBoxSource == lettuce) 
      {
         priceChange = LETTUCE_PRICE;
      }  
      else if (checkBoxSource == tomatoes) 
      {
         priceChange = TOMATOES_PRICE;
      }  
      else if (checkBoxSource == onions) 
      {
         priceChange = ONIONS_PRICE;
      }  
      
      if (e.getStateChange() == ItemEvent.DESELECTED)
      {
         addTopping = false;
      }
      
      setToppingsTotal(priceChange, addTopping);
   }
   
}