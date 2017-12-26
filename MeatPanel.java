/**
Program that creates a Meat Panel class to be
added to a JFrame that displays a sandwich shop's
menu.  This panel allows the user to select which 
type of meat(s) that they want for their sandwich.

@author Hiram Raulerson
@version 1.2
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: December 6, 2015.
 
COP5007	Project #: 6
File Name: MeatPanel.java
*/

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MeatPanel extends JPanel implements ItemListener
{
   /**
   Creates a JLabel to label the panel
   */
   private JLabel label;
   
   /**
   Creates a check box to allow the user to add roast beef as a meat on
   their sandwich
   */
   private JCheckBox roastBeef;
   
   /**
   Creates a check box to allow the user to add turkey as a meat on
   their sandwich
   */
   private JCheckBox turkey;
   
   /**
   Creates a check box to allow the user to add ham as a meat on
   their sandwich
   */
   private JCheckBox ham;
   
   /**
   Creates a check box to allow the user to add salami as a meat on
   their sandwich
   */
   private JCheckBox salami;
   
   /**
   Stores the price of the meat(s) the user chooses (based on the check boxes that
   are selected)
   */
   private double meatTotal;
   
   /**
   Creates a constant price for roast beef
   */
   private final double ROAST_BEEF_PRICE = 3.50;
   
   /**
   Creates a constant price for turkey
   */
   private final double TURKEY_PRICE = 2.75;
   
   /**
   Creates a constant price for ham
   */
   private final double HAM_PRICE = 2.95;
   
   /**
   Creates a constant price for salami
   */
   private final double SALAMI_PRICE = 3.15;
   
   /**
   Stores the constant width of the meat panel
   */
   private final int WIDTH = 10;
   
   /**
   Stores the constant height of the meat panel
   */
   private final int HEIGHT = 30;
   
   /**
   Default constructor sets all instance variables to 
   their default values.  Also, creates item listeners 
   for the check boxes buttons, adds the check boxes to
   the JPanel, and formats the layout of the JPanel.
   */
   public MeatPanel()
   {
      setSize(WIDTH, HEIGHT);
      label = new JLabel("\nChoose your meat");
      roastBeef = new JCheckBox("Roast Beef");
      turkey = new JCheckBox("Turkey");
      ham = new JCheckBox("Ham");
      salami = new JCheckBox("Salami");
      
      roastBeef.addItemListener(this);
      turkey.addItemListener(this);
      ham.addItemListener(this);
      salami.addItemListener(this);
      
      meatTotal = 0; 
   
      setLayout(new GridLayout(0, 1));
      
      add(label);
      add(roastBeef);
      add(turkey);
      add(ham);
      add(salami);
   }
   
   /**
   Sets the meat total based on the check box(es)
   selected
   @param price the price that the total will change by
   @param addOrSubtract whether to add or subtract the price change to/from
   the total for the meats selected
   */
   public void setMeatTotal(double price, boolean addOrSubtract)
   {
      if (addOrSubtract) 
      { 
         meatTotal += price; 
      }
      else
      {
         meatTotal -= price;
      }
   }
   
   /**
   Returns the total for the meat(s) choosen
   @return the total for the meat(s) selected
   */
   public double getMeatTotal()
   {
      return meatTotal;
   }
   
   /**
   Sets the meat total based on the check box(es) selected
   @param e the item event passed to the listener from
   the event
   */
   public void itemStateChanged(ItemEvent e)
   {
      boolean addMeat = true;
      
      double priceChange = 0.0;
      
      Object checkBoxSource = e.getItemSelectable();
      
      if (checkBoxSource == roastBeef) 
      {
         priceChange = ROAST_BEEF_PRICE;
      }
      else if (checkBoxSource == turkey) 
      {
         priceChange = TURKEY_PRICE;
      } 
      else if (checkBoxSource == ham) 
      {
         priceChange = HAM_PRICE;
      } 
      else if (checkBoxSource == salami) 
      {
         priceChange = SALAMI_PRICE;
      }  
      
      if (e.getStateChange() == ItemEvent.DESELECTED)
      {
         addMeat = false;
      }
      
      setMeatTotal(priceChange, addMeat);
   }
   
   
}