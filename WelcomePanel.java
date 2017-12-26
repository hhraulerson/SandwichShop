/**
Program that creates a Welcome Panel class to be
added to a JFrame that displays a sandwich shop's
menu.

@author Hiram Raulerson
@version 1.3
 
E-mail Address: hhr3@students.uwf.edu.
 
Last Changed: December 6, 2015.
 
COP5007	Project #: 6
File Name: WelcomePanel.java
*/

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class WelcomePanel extends JPanel
{
   /**
   Creates a label for the JPanel, specifically a
   welcome greeting to the sandwich shop
   */
   private JLabel welcomeLabel;
   
   /**
   Default constructor sets all instance variables to 
   their default values.  Also, adds the label to the JPanel
   and formats the layout of the JPanel.
   */
   public WelcomePanel()
   {
      welcomeLabel = new JLabel("Welcome to Murphy and Shepard's Deli!");
      
      welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
      
      setLayout(new BorderLayout());
      
      add(welcomeLabel, BorderLayout.CENTER);
   }
   
}