/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.master;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Jessica
 */


public class homePage extends JFrame {
    
   //declare components and variables
    private JPanel firstTab, secondTab, thirdTab, fourthTab, fifthTab;  
    private final JTabbedPane jtpHome;
    private JLabel txtLabel, secondLabel, thirdLabel, dashLine; 
    private URL pic = null;
    
   //constructor for homePage class 
   homePage(){
       setSize(1000, 650); //set size of the frame 
       setTitle("Travel Booking System"); //set title to window frame
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close operation when exiting
    
  //Panel for tabs
        firstTab = new JPanel();
        firstTab.setLayout(null);
        firstTab.setSize(1000, 650);
  
  //initialize the first label to the HOME tab 
        txtLabel = new JLabel("Book Your Next");
        txtLabel.setBounds(30, 200, 400, 100); 
        txtLabel.setFont(new Font("Times New Roman", Font.BOLD , 40)); 
        txtLabel.setForeground(new Color(0, 151, 178));
        firstTab.add(txtLabel); 
       
  //initialize the second label to the HOME tab 
        secondLabel = new JLabel("Destination With Us");
        secondLabel.setBounds(30, 250, 400, 110); 
        secondLabel.setFont(new Font("Times New Roman", Font.BOLD , 40)); 
        secondLabel.setForeground(new Color(0, 151, 178));
        firstTab.add(secondLabel); 

  //initialize the third label to the HOME tab 
        thirdLabel = new JLabel("Get Your Flight From _ _ _ _ _ _ _ ");
        thirdLabel.setBounds(30, 300, 400, 120); 
        thirdLabel.setFont(new Font("GARET", Font.PLAIN , 25)); 
        thirdLabel.setForeground(new Color(175, 168, 140));
        firstTab.add(thirdLabel);
        
  // Add a decorative dashed line label to the HOME tab
        dashLine = new JLabel("_ _ _ _ _ _ _ _ _ _  ");
        dashLine.setBounds(30, 320, 400, 130);
        dashLine.setForeground(new Color(0, 151, 178));
        dashLine.setFont(new Font("Times New Roman", Font.BOLD , 25)); 
        firstTab.add(dashLine);
        
  // Attempt to load a background image from a URL
            try {
                pic = new URL ("https://i.imgur.com/SON68g6.png"); //Load the image from URL 
            } catch (MalformedURLException ex) {
                Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex); //log any error
            }
 //add background image as a scaled Jlabel      
            ImageIcon imageIcon = new ImageIcon(pic);
            Image imageScale = imageIcon.getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
            ImageIcon imageNew = new ImageIcon(imageScale);
            JLabel backgroundLabel = new JLabel(imageNew);
            backgroundLabel.setBounds(0, 0, 1000, 600);
            firstTab.add(backgroundLabel);
           
 //initialize other tabs with empty panels
        Flight secondTab = new Flight();
        
        Hotel thirdTab = new Hotel();
        
        bookPackage fourthTab = new bookPackage();
        
        history fifth = new history();
              
 // Create the TabbedPane and add the tabs
        jtpHome = new JTabbedPane();
        jtpHome.setSize(1000, 600);
        jtpHome.addTab("HOME", firstTab);
        jtpHome.addTab("Flight", secondTab);
        jtpHome.addTab("Hotel", thirdTab);
        jtpHome.addTab("Package", fourthTab);
        jtpHome.addTab("History", fifthTab);
        add(jtpHome); 

 //set JFrame properties
        setResizable(false); //Disable resizing
        setLocationRelativeTo(null); //Center the frame on the screen
        setVisible(true); //make the frame visible 
    
   
    }

}

    
