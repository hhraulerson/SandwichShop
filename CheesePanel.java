/**
Program that creates a Cheese Panel class to be
added to a JFrame that displays a sandwich shop's
menu.  This panel allows the user to select which 
type of cheese(s) that they want for their sandwich.

@author Hiram Raulerson
@version 1.3
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: December 6, 2015.
 
COP5007	Project #: 6
File Name: CheesePanel.java
*/

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheesePanel extends JPanel implements ItemListener
{  
   /**
   Creates a JLabel to label the panel
   */
   private JLabel label;
   
   /**
   Creates a check box to allow the user to add cheddar as a cheese on
   their sandwich
   */
   private JCheckBox cheddar;
   
   /**
   Creates a check box to allow the user to add swiss as a cheese on
   their sandwich
   */
   private JCheckBox swiss;
   
   /**
   Creates a check box to allow the user to add provolone as a cheese on
   their sandwich
   */
   private JCheckBox provolone;
   
   /**
   Creates a check box to allow the user to add pepper jack as a cheese on
   their sandwich
   */
   private JCheckBox pepperJack;
   
   /**
   Stores the price of the cheese(s) the user chooses (based on the check boxes that
   are selected)
   */
   private double cheeseTotal;
   
   /**
   Creates a constant price for cheddar
   */
   private final double CHEDDAR_PRICE = 0.50;
   
   /**
   Creates a constant price for swiss
   */
   private final double SWISS_PRICE = 0.65;
   
   /**
   Creates a constant price for provolone
   */
   private final double PROVOLONE_PRICE = 0.55;
   
   /**
   Creates a constant price for pepper jack
   */
   private final double PEPPER_JACK_PRICE = 0.70;
   
   /**
   Stores the constant width of the cheese panel
   */
   private final int WIDTH = 10;
   
   /**
   Stores the constant height of the cheese panel
   */
   private final int HEIGHT = 30;
   
   /**
   Default constructor sets all instance variables to 
   their default values.  Also, creates item listeners 
   for the check boxes buttons, adds the check boxes to
   the JPanel, and formats the layout of the JPanel.
   */
   public CheesePanel()
   {
      setSize(WIDTH, HEIGHT);
      label = new JLabel("\nChoose your cheese");
      cheddar = new JCheckBox("Cheddar");
      swiss = new JCheckBox("Swiss");
      provolone = new JCheckBox("Provolone");
      pepperJack = new JCheckBox("Pepper Jack");
      
      cheddar.addItemListener(this);
      swiss.addItemListener(this);
      provolone.addItemListener(this);
      pepperJack.addItemListener(this);
      
      cheeseTotal = 0; 
   
      setLayout(new GridLayout(0, 1));
      
      add(label);
      add(cheddar);
      add(swiss);
      add(provolone);
      add(pepperJack);
   }
   
   /**
   Sets the cheese total based on the check box(es)
   selected
   @param price the price that the total will change by
   @param addOrSubtract whether to add or subtract the price change to/from
   the total for the cheeses selected
   */
   public void setCheeseTotal(double price, boolean addOrSubtract)
   {
      if (addOrSubtract) 
      { 
         cheeseTotal += price; 
      }
      else
      {
         cheeseTotal -= price;
      }
   }
   
   /**
   Returns the total for the cheese(s) choosen
   @return the total for the cheese(s) selected
   */
   public double getCheeseTotal()
   {
      return cheeseTotal;
   }
   
   /**
   Sets the cheese total based on the check box(es) selected
   @param e the item event passed to the listener from
   the event
   */
   public void itemStateChanged(ItemEvent e)
   {
      boolean addCheese = true;
      
      double priceChange = 0.0;
      
      Object checkBoxSource = e.getItemSelectable();
      
      if (checkBoxSource == cheddar) 
      {
         priceChange = CHEDDAR_PRICE;
      }
      else if (checkBoxSource == swiss) 
      {
         priceChange = SWISS_PRICE;
      } 
      else if (checkBoxSource == provolone) 
      {
         priceChange = PROVOLONE_PRICE;
      } 
      else if (checkBoxSource == pepperJack) 
      {
         priceChange = PEPPER_JACK_PRICE;
      }  
      
      if (e.getStateChange() == ItemEvent.DESELECTED)
      {
         addCheese = false;
      }
      
      setCheeseTotal(priceChange, addCheese);
   }

}