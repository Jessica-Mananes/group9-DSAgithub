package com.mycompany.master;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class bookPackage extends JFrame implements ActionListener {
    
    //Components Declaration
    private JPanel bgColor;
    private JLabel packages,lblDate1, lblDate2, lblDate3, lblDate4, packageID;
    private JLabel hoverImage;
    private JLabel hotelLabel, locationLabel, ratingLabel, destinationLabel, departureLabel, arrivalLabel1, travelclassLabel;
    private JLabel hotelName, locationName, ratingName, destinationName, departureName, arrivalName, travelclassName;
    private JLabel hotelName2, locationName2, ratingName2, destinationName2, departureName2, arrivalName2, travelclassName2;
    private JLabel hotelLabel2, locationLabel2, ratingLabel2, destinationLabel2, departureLabel2, arrivalLabel12, travelclassLabel2;
    private JLabel hotelName3, locationName3, ratingName3, destinationName3, departureName3, arrivalName3, travelclassName3;
    private JLabel hotelLabel3, locationLabel3, ratingLabel3, destinationLabel3, departureLabel3, arrivalLabel13, travelclassLabel3;
    private JLabel hotelName4, locationName4, ratingName4, destinationName4, departureName4, arrivalName4, travelclassName4;
    private JLabel hotelLabel4, locationLabel4, ratingLabel4, destinationLabel4, departureLabel4, arrivalLabel14, travelclassLabel4;
    private JTextArea dialog1, dialog2, dialog3, dialog4;
    private JButton btnCountry, btnCountry2, btnCountry3, btnCountry4, btnSort;
    private LinkedList<String> lblfeatures;
    private double price2 = 44350;
    private double price3 = 19850;
    private double price4 = 60000;
    private PreparedStatement pst;
    private Connection con;
    private int traveltime[] = {8, 12, 3, 18};
    
    
    //constructor for bookPackage class
    bookPackage() {
        Connect();
        bgColor = new JPanel();
        bgColor.setSize(1000, 600);
        bgColor.setBackground(new Color(37, 113, 128));
        bgColor.setLayout(null);
        
        
        //
        setSize(1000, 600);
        setTitle("Hotel Packages");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        add(bgColor);
        
        ArrayList<JLabel> features1 = new ArrayList<>();
        ArrayList<JLabel> features2 = new ArrayList<>();
        ArrayList<JLabel> features3 = new ArrayList<>();
        ArrayList<JLabel> features4 = new ArrayList<>();
        
        features1.add(new JLabel("FEATURES:"));
        features1.add(new JLabel("● 4 Nights Hotel"));
        features1.add(new JLabel("● Overall Dining"));
        features1.add(new JLabel("● Access to Hotel Pool"));
        features1.add(new JLabel("HOTEL INCLUDED:"));
        features1.add(new JLabel("Shangri-La Hotel, Sydney"));
        
        features2.add(new JLabel("FEATURES:"));
        features2.add(new JLabel("● 5 Nights Hotel"));
        features2.add(new JLabel("● Private Dining"));
        features2.add(new JLabel("● Access to Casino"));
        features2.add(new JLabel("HOTEL INCLUDED:"));
        features2.add(new JLabel("Andaz Maui at Wailea Resort"));
        
        features3.add(new JLabel("FEATURES:"));
        features3.add(new JLabel("● 6 Nights Hotel"));
        features3.add(new JLabel("● Daily Breakfast"));
        features3.add(new JLabel("● Access to Live Entertainment"));
        features3.add(new JLabel("HOTEL INCLUDED:"));
        features3.add(new JLabel("Mandarin Oriental, Bangkok"));
        
        features4.add(new JLabel("FEATURES:"));
        features4.add(new JLabel("● 7 Nights Hotel"));
        features4.add(new JLabel("● Private Dining"));
        features4.add(new JLabel("● Access to Relaxing Zone"));
        features4.add(new JLabel("HOTEL INCLUDED:"));
        features4.add(new JLabel("Le Meurice"));
        
            for (int i = 0; i < features1.size(); i++) {
            JLabel feature = features1.get(i);
            feature.setFont(new Font("Garet", Font.BOLD, 13));
            feature.setForeground(new Color(234, 216, 177));
            feature.setBounds(85, 370 + (i * 20), 180, 150);
            bgColor.add(feature);
        }
            for (int i = 0; i < features2.size(); i++) {
            JLabel feature = features2.get(i);
            feature.setFont(new Font("Garet", Font.BOLD, 13));
            feature.setForeground(new Color(234, 216, 177));
            feature.setBounds(295, 370 + (i * 20), 180, 150);
            bgColor.add(feature);
        }
            for (int i = 0; i < features3.size(); i++) {
            JLabel feature = features3.get(i);
            feature.setFont(new Font("Garet", Font.BOLD, 13));
            feature.setForeground(new Color(234, 216, 177));
            feature.setBounds(505, 370 + (i * 20), 200, 150);
            bgColor.add(feature);
        }      
            for (int i = 0; i < features4.size(); i++) {
            JLabel feature = features4.get(i);
            feature.setFont(new Font("Garet", Font.BOLD, 13));
            feature.setForeground(new Color(234, 216, 177));
            feature.setBounds(715, 370 + (i * 20), 180, 150);
            bgColor.add(feature);
        }
       
        hotelName = new JLabel("HOTEL:");
        hotelName.setBounds(85, 65, 250, 30);
        hotelName.setFont(new Font("Garet", Font.BOLD, 12)); 
        hotelName.setForeground(new Color(234, 216, 177));
        hotelName.setVisible(false);
        bgColor.add(hotelName);

        hotelLabel = new JLabel("Shangri-La Hotel");
        hotelLabel.setBounds(85, 80, 250, 30);
        hotelLabel.setFont(new Font("Garet", Font.BOLD, 12)); 
        hotelLabel.setForeground(new Color(255, 255, 255));
        hotelLabel.setVisible(false);
        bgColor.add(hotelLabel);

        locationName = new JLabel("LOCATION:");
        locationName.setBounds(85, 100, 250, 30);
        locationName.setFont(new Font("Garet", Font.BOLD, 12)); 
        locationName.setForeground(new Color(234, 216, 177));
        locationName.setVisible(false);
        bgColor.add(locationName);

        locationLabel = new JLabel("Sydney. Australia");
        locationLabel.setBounds(85, 115, 250, 30);
        locationLabel.setFont(new Font("Garet", Font.BOLD, 12)); 
        locationLabel.setForeground(new Color(255, 255, 255));
        locationLabel.setVisible(false);
        bgColor.add(locationLabel);

        ratingLabel = new JLabel("RATING:");
        ratingLabel.setBounds(85, 135, 400, 30);
        ratingLabel.setFont(new Font("Garet", Font.BOLD, 12)); 
        ratingLabel.setForeground(new Color(234, 216, 177));
        ratingLabel.setVisible(false);
        bgColor.add(ratingLabel);

        ratingName = new JLabel("4 Star");
        ratingName.setBounds(85, 150, 400, 30);
        ratingName.setFont(new Font("Garet", Font.BOLD, 12)); 
        ratingName.setForeground(new Color(255, 255, 255));
        ratingName.setVisible(false);
        bgColor.add(ratingName);

        destinationLabel = new JLabel("DESTINATION:");
        destinationLabel.setBounds(85, 170, 400, 30);
        destinationLabel.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        destinationLabel.setForeground(new Color(234, 216, 177));
        destinationLabel.setVisible(false);
        bgColor.add(destinationLabel);

        destinationName = new JLabel("Sydney, Australia");
        destinationName.setBounds(85, 185, 400, 30);
        destinationName.setFont(new Font("Garet", Font.BOLD, 12)); 
        destinationName.setForeground(new Color(255, 255, 255));
        destinationName.setVisible(false);
        bgColor.add(destinationName);

        departureLabel = new JLabel("DEPARTURE:");
        departureLabel.setBounds(85, 205, 400, 30);
        departureLabel.setFont(new Font("Garet", Font.BOLD, 12)); 
        departureLabel.setForeground(new Color(234, 216, 177));
        departureLabel.setVisible(false);
        bgColor.add(departureLabel);

        departureName = new JLabel(LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")) + " " + LocalTime.of(21, 30).format(DateTimeFormatter.ofPattern("h:mm a")));
        departureName.setBounds(85, 220, 400, 30);
        departureName.setFont(new Font("Garet", Font.BOLD, 12)); 
        departureName.setForeground(new Color(255, 255, 255));
        departureName.setVisible(false);
        bgColor.add(departureName);
            

        arrivalName = new JLabel("ARRIVAL:");
        arrivalName.setBounds(85, 240, 400, 30);
        arrivalName.setFont(new Font("Garet", Font.BOLD, 12)); 
        arrivalName.setForeground(new Color(234, 216, 177));
        arrivalName.setVisible(false);
        bgColor.add(arrivalName);

        
        String departureTxt = departureName.getText();
        
        try {
        LocalDateTime departureDT = LocalDateTime.parse(departureTxt, DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a"));

        int travelHrs = traveltime[0]; 

        LocalDateTime arrivalDT = departureDT.plusHours(travelHrs);

        String arrival = arrivalDT.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a"));
        
        arrivalLabel1 = new JLabel(arrival);
        arrivalLabel1.setBounds(85, 255, 400, 30);
        arrivalLabel1.setFont(new Font("Garet", Font.BOLD, 12)); 
        arrivalLabel1.setForeground(new Color(255, 255, 255));
        arrivalLabel1.setVisible(false);
        bgColor.add(arrivalLabel1);

        } catch (Exception e) {
         System.out.println("Error parsing: " + e.getMessage());
        }

        travelclassName = new JLabel("TRAVEL CLASS:");
        travelclassName.setBounds(85, 285, 400, 30);
        travelclassName.setFont(new Font("Garet", Font.BOLD, 12)); 
        travelclassName.setForeground(new Color(234, 216, 177));
        travelclassName.setVisible(false);
        bgColor.add(travelclassName);

        travelclassLabel = new JLabel("Economy");
        travelclassLabel.setBounds(85, 300, 400, 30);
        travelclassLabel.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        travelclassLabel.setForeground(new Color(255, 255, 255));
        travelclassLabel.setVisible(false);
        bgColor.add(travelclassLabel);
        
        //PACKAGE DETAILS NUMBER 2
        
        hotelName2 = new JLabel("HOTEL:");
        hotelName2.setBounds(295, 65, 250, 30);
        hotelName2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        hotelName2.setForeground(new Color(234, 216, 177));
        hotelName2.setVisible(false);
        bgColor.add(hotelName2);

        hotelLabel2 = new JLabel("Andaz Maui at Wailea Resort");
        hotelLabel2.setBounds(295, 80, 250, 30);
        hotelLabel2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        hotelLabel2.setForeground(new Color(255, 255, 255));
        hotelLabel2.setVisible(false);
        bgColor.add(hotelLabel2);

        locationName2 = new JLabel("LOCATION:");
        locationName2.setBounds(295, 100, 250, 30);
        locationName2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        locationName2.setForeground(new Color(234, 216, 177));
        locationName2.setVisible(false);
        bgColor.add(locationName2);

        locationLabel2 = new JLabel("Maui, Hawaii");
        locationLabel2.setBounds(295, 115, 250, 30);
        locationLabel2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        locationLabel2.setForeground(new Color(255, 255, 255));
        locationLabel2.setVisible(false);
        bgColor.add(locationLabel2);

        ratingLabel2 = new JLabel("RATING:");
        ratingLabel2.setBounds(295, 135, 400, 30);
        ratingLabel2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        ratingLabel2.setForeground(new Color(234, 216, 177));
        ratingLabel2.setVisible(false);
        bgColor.add(ratingLabel2);

        ratingName2 = new JLabel("4 Star");
        ratingName2.setBounds(295, 150, 400, 30);
        ratingName2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        ratingName2.setForeground(new Color(255, 255, 255));
        ratingName2.setVisible(false);
        bgColor.add(ratingName2);

        destinationLabel2 = new JLabel("DESTINATION:");
        destinationLabel2.setBounds(295, 170, 400, 30);
        destinationLabel2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        destinationLabel2.setForeground(new Color(234, 216, 177));
        destinationLabel2.setVisible(false);
        bgColor.add(destinationLabel2);

        destinationName2 = new JLabel("Hawaii, USA");
        destinationName2.setBounds(295, 185, 400, 30);
        destinationName2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        destinationName2.setForeground(new Color(255, 255, 255));
        destinationName2.setVisible(false);
        bgColor.add(destinationName2);

        departureLabel2 = new JLabel("DEPARTURE:");
        departureLabel2.setBounds(295, 205, 400, 30);
        departureLabel2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        departureLabel2.setForeground(new Color(234, 216, 177));
        departureLabel2.setVisible(false);
        bgColor.add(departureLabel2);

        departureName2 = new JLabel(LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")) + " " + LocalTime.of(22, 0).format(DateTimeFormatter.ofPattern("h:mm a")));
        departureName2.setBounds(295, 220, 400, 30);
        departureName2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        departureName2.setForeground(new Color(255, 255, 255));
        departureName2.setVisible(false);
        bgColor.add(departureName2);

        arrivalName2 = new JLabel("ARRIVAL:");
        arrivalName2.setBounds(295, 240, 400, 30);
        arrivalName2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        arrivalName2.setForeground(new Color(234, 216, 177));
        arrivalName2.setVisible(false);
        bgColor.add(arrivalName2);
        
        String departureTxt2 = departureName2.getText();
        
        try {
        LocalDateTime departureDT = LocalDateTime.parse(departureTxt2, DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a"));

        int travelHrs = traveltime[1]; 

        LocalDateTime arrivalDT = departureDT.plusHours(travelHrs);

        String arrival = arrivalDT.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a"));
        
        arrivalLabel12 = new JLabel(arrival);
        arrivalLabel12.setBounds(295, 255, 400, 30);
        arrivalLabel12.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        arrivalLabel12.setForeground(new Color(255, 255, 255));
        arrivalLabel12.setVisible(false);
        bgColor.add(arrivalLabel12);

        } catch (Exception e) {
         System.out.println("Error parsing: " + e.getMessage());
        }
        
        travelclassName2 = new JLabel("TRAVEL CLASS:");
        travelclassName2.setBounds(295, 285, 400, 30);
        travelclassName2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        travelclassName2.setForeground(new Color(234, 216, 177));
        travelclassName2.setVisible(false);
        bgColor.add(travelclassName2);
        
        travelclassLabel2 = new JLabel("Economy");
        travelclassLabel2.setBounds(295, 300, 400, 30);
        travelclassLabel2.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        travelclassLabel2.setForeground(new Color(255, 255, 255));
        travelclassLabel2.setVisible(false);
        bgColor.add(travelclassLabel2);
        
        //PACKAGE NUMBER THREE
        
        hotelName3 = new JLabel("HOTEL:");
        hotelName3.setBounds(505, 65, 250, 30);
        hotelName3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        hotelName3.setForeground(new Color(234, 216, 177));
        hotelName3.setVisible(false);
        bgColor.add(hotelName3);

        hotelLabel3 = new JLabel("Mandarin Oriental, Bangkok");
        hotelLabel3.setBounds(505, 80, 250, 30);
        hotelLabel3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        hotelLabel3.setForeground(new Color(255, 255, 255));
        hotelLabel3.setVisible(false);
        bgColor.add(hotelLabel3);

        locationName3 = new JLabel("LOCATION:");
        locationName3.setBounds(505, 100, 250, 30);
        locationName3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        locationName3.setForeground(new Color(234, 216, 177));
        locationName3.setVisible(false);
        bgColor.add(locationName3);

        locationLabel3 = new JLabel("Bangkok, Thailand");
        locationLabel3.setBounds(505, 115, 250, 30);
        locationLabel3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        locationLabel3.setForeground(new Color(255, 255, 255));
        locationLabel3.setVisible(false);
        bgColor.add(locationLabel3);

        ratingLabel3 = new JLabel("RATING:");
        ratingLabel3.setBounds(505, 135, 400, 30);
        ratingLabel3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        ratingLabel3.setForeground(new Color(234, 216, 177));
        ratingLabel3.setVisible(false);
        bgColor.add(ratingLabel3);

        ratingName3 = new JLabel("4 Star");
        ratingName3.setBounds(505, 150, 400, 30);
        ratingName3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        ratingName3.setForeground(new Color(255, 255, 255));
        ratingName3.setVisible(false);
        bgColor.add(ratingName3);

        destinationLabel3 = new JLabel("DESTINATION:");
        destinationLabel3.setBounds(505, 170, 400, 30);
        destinationLabel3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        destinationLabel3.setForeground(new Color(234, 216, 177));
        destinationLabel3.setVisible(false);
        bgColor.add(destinationLabel3);

        destinationName3 = new JLabel("Bangkok, Thailand");
        destinationName3.setBounds(505, 185, 400, 30);
        destinationName3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        destinationName3.setForeground(new Color(255, 255, 255));
        destinationName3.setVisible(false);
        bgColor.add(destinationName3);

        departureLabel3 = new JLabel("DEPARTURE:");
        departureLabel3.setBounds(505, 205, 400, 30);
        departureLabel3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        departureLabel3.setForeground(new Color(234, 216, 177));
        departureLabel3.setVisible(false);
        bgColor.add(departureLabel3);

        departureName3 = new JLabel(LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")) + " " + LocalTime.of(19, 45).format(DateTimeFormatter.ofPattern("h:mm a")));
        departureName3.setBounds(505, 220, 400, 30);
        departureName3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        departureName3.setForeground(new Color(255, 255, 255));
        departureName3.setVisible(false);
        bgColor.add(departureName3);

        arrivalName3 = new JLabel("ARRIVAL:");
        arrivalName3.setBounds(505, 240, 400, 30);
        arrivalName3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        arrivalName3.setForeground(new Color(234, 216, 177));
        arrivalName3.setVisible(false);
        bgColor.add(arrivalName3);
        
        String departureTxt3 = departureName3.getText();
        
        try {
        LocalDateTime departureDT = LocalDateTime.parse(departureTxt3, DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a"));

        int travelHrs = traveltime[2]; 

        LocalDateTime arrivalDT = departureDT.plusHours(travelHrs);

        String arrival = arrivalDT.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a"));
        
        arrivalLabel13 = new JLabel(arrival);
        arrivalLabel13.setBounds(505, 255, 400, 30);
        arrivalLabel13.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        arrivalLabel13.setForeground(new Color(255, 255, 255));
        arrivalLabel13.setVisible(false);
        bgColor.add(arrivalLabel13);

        } catch (Exception e) {
         System.out.println("Error parsing: " + e.getMessage());
        }

        travelclassName3 = new JLabel("TRAVEL CLASS:");
        travelclassName3.setBounds(505, 285, 400, 30);
        travelclassName3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        travelclassName3.setForeground(new Color(234, 216, 177));
        travelclassName3.setVisible(false);
        bgColor.add(travelclassName3);

        travelclassLabel3 = new JLabel("Economy");
        travelclassLabel3.setBounds(505, 300, 400, 30);
        travelclassLabel3.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        travelclassLabel3.setForeground(new Color(255, 255, 255));
        travelclassLabel3.setVisible(false);
        bgColor.add(travelclassLabel3);

        //PACKAGE NUMBER FOUR
        
        hotelName4 = new JLabel("HOTEL:");
        hotelName4.setBounds(715, 65, 250, 30);
        hotelName4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        hotelName4.setForeground(new Color(234, 216, 177));
        hotelName4.setVisible(false);
        bgColor.add(hotelName4);

        hotelLabel4 = new JLabel("Le Meurice");
        hotelLabel4.setBounds(715, 80, 250, 30);
        hotelLabel4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        hotelLabel4.setForeground(new Color(255, 255, 255));
        hotelLabel4.setVisible(false);
        bgColor.add(hotelLabel4);

        locationName4 = new JLabel("LOCATION:");
        locationName4.setBounds(715, 100, 250, 30);
        locationName4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        locationName4.setForeground(new Color(234, 216, 177));
        locationName4.setVisible(false);
        bgColor.add(locationName4);

        locationLabel4 = new JLabel("Paris, France");
        locationLabel4.setBounds(715, 115, 250, 30);
        locationLabel4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        locationLabel4.setForeground(new Color(255, 255, 255));
        locationLabel4.setVisible(false);
        bgColor.add(locationLabel4);

        ratingLabel4 = new JLabel("RATING:");
        ratingLabel4.setBounds(715, 135, 400, 30);
        ratingLabel4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        ratingLabel4.setForeground(new Color(234, 216, 177));
        ratingLabel4.setVisible(false);
        bgColor.add(ratingLabel4);

        ratingName4 = new JLabel("4 Star");
        ratingName4.setBounds(715, 150, 400, 30);
        ratingName4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        ratingName4.setForeground(new Color(255, 255, 255));
        ratingName4.setVisible(false);
        bgColor.add(ratingName4);

        destinationLabel4 = new JLabel("DESTINATION:");
        destinationLabel4.setBounds(715, 170, 400, 30);
        destinationLabel4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        destinationLabel4.setForeground(new Color(234, 216, 177));
        destinationLabel4.setVisible(false);
        bgColor.add(destinationLabel4);

        destinationName4 = new JLabel("Paris, France");
        destinationName4.setBounds(715, 185, 400, 30);
        destinationName4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        destinationName4.setForeground(new Color(255, 255, 255));
        destinationName4.setVisible(false);
        bgColor.add(destinationName4);

        departureLabel4 = new JLabel("DEPARTURE:");
        departureLabel4.setBounds(715, 205, 400, 30);
        departureLabel4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        departureLabel4.setForeground(new Color(234, 216, 177));
        departureLabel4.setVisible(false);
        bgColor.add(departureLabel4);

        departureName4 = new JLabel(LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")) + " " + LocalTime.of(8, 0).format(DateTimeFormatter.ofPattern("h:mm a")));
        departureName4.setBounds(715, 220, 400, 30);
        departureName4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        departureName4.setForeground(new Color(255, 255, 255));
        departureName4.setVisible(false);
        bgColor.add(departureName4);

        arrivalName4 = new JLabel("ARRIVAL:");
        arrivalName4.setBounds(715, 240, 400, 30);
        arrivalName4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        arrivalName4.setForeground(new Color(234, 216, 177));
        arrivalName4.setVisible(false);
        bgColor.add(arrivalName4);
        
        String departureTxt4 = departureName4.getText();
        
        try {
        LocalDateTime departureDT = LocalDateTime.parse(departureTxt4, DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a"));

        int travelHrs = traveltime[3]; 

        LocalDateTime arrivalDT = departureDT.plusHours(travelHrs);

        String arrival = arrivalDT.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a"));
        
        arrivalLabel14 = new JLabel(arrival);
        arrivalLabel14.setBounds(715, 255, 400, 30);
        arrivalLabel14.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        arrivalLabel14.setForeground(new Color(255, 255, 255));
        arrivalLabel14.setVisible(false);
        bgColor.add(arrivalLabel14);

        } catch (Exception e) {
         System.out.println("Error parsing: " + e.getMessage());
        }

        travelclassName4 = new JLabel("TRAVEL CLASS:");
        travelclassName4.setBounds(715, 285, 400, 30);
        travelclassName4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        travelclassName4.setForeground(new Color(234, 216, 177));
        travelclassName4.setVisible(false);
        bgColor.add(travelclassName4);

        travelclassLabel4 = new JLabel("Economy");
        travelclassLabel4.setBounds(715, 300, 400, 30);
        travelclassLabel4.setFont(new Font("Fira Code", Font.BOLD, 12)); 
        travelclassLabel4.setForeground(new Color(255, 255, 255));
        travelclassLabel4.setVisible(false);
        bgColor.add(travelclassLabel4);


        
            
        //add the first label from bookPackage Tab
        packages = new JLabel("TRAVEL PACKAGES");
        packages.setBounds(300, 15, 400, 30);
        packages.setFont(new Font("Fira Code", Font.BOLD, 40)); 
        packages.setForeground(new Color(234, 216, 177));
        bgColor.add(packages);
        
        
        //Flight information label from bookPackage Tab
        lblDate1 = new JLabel("PRICE: PHP 24206");
        lblDate1.setFont(new Font("Garet", Font.BOLD, 13)); 
        lblDate1.setForeground(new Color(234, 216, 177));
        lblDate1.setBounds(85, 390, 180 ,40);
        bgColor.add(lblDate1);
        
        //Flight information label from bookPackage Tab
        lblDate2 = new JLabel("PRICE: PHP 31045");
        lblDate2.setFont(new Font("Garet", Font.BOLD, 13)); 
        lblDate2.setForeground(new Color(234, 216, 177));
        lblDate2.setBounds(295, 390, 180 ,40);
        bgColor.add(lblDate2);
        
        //Flight information label from bookPackage Tab
        lblDate3 = new JLabel("PRICE: PHP 15695");
        lblDate3.setFont(new Font("Garet", Font.BOLD, 13)); 
        lblDate3.setForeground(new Color(234, 216, 177));
        lblDate3.setBounds(505, 390, 180 ,40);
        bgColor.add(lblDate3);
        
        //Flight information label from bookPackage Tab
        lblDate4 = new JLabel("PRICE: PHP 42000");
        lblDate4.setFont(new Font("Garet", Font.BOLD, 13)); 
        lblDate4.setForeground(new Color(234, 216, 177));
        lblDate4.setBounds(715, 390, 180 ,40);
        bgColor.add(lblDate4);
        
        //Book button of Sydney Austrialia Package from the bookPackage
        btnCountry = new JButton("Sydney, Australia");
        btnCountry.setFont(new Font("Garet", Font.BOLD, 12)); 
        btnCountry.setBackground(new Color(253, 252, 233));
        btnCountry.setForeground(new Color(37, 113, 128));
        btnCountry.setBounds(85, 350, 180 ,40);
        bgColor.add(btnCountry);
        
        //Book button of Maui Hawaii USA Package from the bookPackage
        btnCountry2 = new JButton("Hawaii, USA");
        btnCountry2.setFont(new Font("Garet", Font.BOLD, 12)); 
        btnCountry2.setBackground(new Color(253, 252, 233));
        btnCountry2.setForeground(new Color(37, 113, 128));
        btnCountry2.setBounds(295, 350, 180 ,40);
        bgColor.add(btnCountry2);
        
        //Book button of Bangok Thailand Package from the bookPackage
        btnCountry3 = new JButton("Bangkok, Thailand");
        btnCountry3.setFont(new Font("Garet", Font.BOLD, 12)); 
        btnCountry3.setBackground(new Color(253, 252, 233));
        btnCountry3.setForeground(new Color(37, 113, 128));
        btnCountry3.setBounds(505, 350, 180 ,40);
        bgColor.add(btnCountry3);
        
        //Book button of Parice France Package from the bookPackage
        btnCountry4 = new JButton("Paris, France");
        btnCountry4.setFont(new Font("Garet", Font.BOLD, 12)); 
        btnCountry4.setBackground(new Color(253, 252, 233));
        btnCountry4.setForeground(new Color(37, 113, 128));
        btnCountry4.setBounds(715, 350, 180 ,40);
        bgColor.add(btnCountry4);
        
        btnSort = new JButton("SORT");
        btnSort.setFont(new Font("Garet", Font.BOLD, 12)); 
        btnSort.setBackground(new Color(253, 252, 233));
        btnSort.setForeground(new Color(37, 113, 128));
        btnSort.setBounds(730, 20, 150 ,25);
        bgColor.add(btnSort);
       
        
        
        //Image use to show the Sydney Austriala Package frm the bookPackage
        ImageIcon imageIcon = new ImageIcon("sydney.jpg");
        Image imageScale = imageIcon.getImage().getScaledInstance(180, 300, Image.SCALE_SMOOTH);
        ImageIcon imageNew = new ImageIcon(imageScale);
        JLabel backgroundLabel = new JLabel(imageNew);
        backgroundLabel.setBounds(50, 70, 250, 290);
        Frame frame = null;
        
        JDialog hoverImage1 = new JDialog(frame, "Package Details", false);
        hoverImage1.setBounds(400, 500, 200, 70);
        hoverImage1.setUndecorated(true);
       
        dialog1 = new JTextArea("Click the picture to see \npackage details");
        dialog1.setFont(new Font("Garet", Font.BOLD, 15)); 
        dialog1.setEditable(false);
        hoverImage1.add(dialog1, BorderLayout.CENTER);     
        
        backgroundLabel.addMouseListener(new java.awt.event.MouseAdapter() {
   
               @Override
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                  backgroundLabel.setVisible(false);
                  hoverImage1.setVisible(false);
                  hotelName.setVisible(true);
                  locationName.setVisible(true);
                  destinationName.setVisible(true);
                  departureName.setVisible(true);
                  ratingName.setVisible(true);
                  arrivalName.setVisible(true);
                  travelclassName.setVisible(true);
                  hotelLabel.setVisible(true);
                  locationLabel.setVisible(true);
                  destinationLabel.setVisible(true);
                  departureLabel.setVisible(true);
                  ratingLabel.setVisible(true);
                  arrivalLabel1.setVisible(true);
                  travelclassLabel.setVisible(true);
                  

               }
               @Override
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                  hoverImage1.setVisible(true);
               }

               @Override
               public void mouseExited(java.awt.event.MouseEvent evt) {
                  backgroundLabel.setVisible(true);
                  hoverImage1.setVisible(false);
                  hotelName.setVisible(false);
                  locationName.setVisible(false);
                  destinationName.setVisible(false);
                  departureName.setVisible(false);
                  ratingName.setVisible(false);
                  arrivalName.setVisible(false);
                  travelclassName.setVisible(false);
                  ratingName.setVisible(false);
                  hotelLabel.setVisible(false);
                  locationLabel.setVisible(false);
                  destinationLabel.setVisible(false);
                  departureLabel.setVisible(false);
                  ratingLabel.setVisible(false);
                  arrivalLabel1.setVisible(false);
                  travelclassLabel.setVisible(false);
               } 
        });
        bgColor.add(backgroundLabel);
        
        //Image use to show the Maui Hawaii Package frm the bookPackage
        ImageIcon imageIcon2 = new ImageIcon("hawaii.jpg");
        Image imageScale2 = imageIcon2.getImage().getScaledInstance(180, 300, Image.SCALE_SMOOTH);
        ImageIcon imageNew2 = new ImageIcon(imageScale2);
        JLabel backgroundLabel2 = new JLabel(imageNew2);
        backgroundLabel2.setBounds(260, 70, 250, 290);
        Frame frame2 = null;

        JDialog hoverImage2 = new JDialog(frame, "Package ID", false);
        hoverImage2.setBounds(600, 500, 250, 70);
        hoverImage2.setUndecorated(true);
        
        dialog2 = new JTextArea("Click the picture to see \npackage details");
        dialog2.setFont(new Font("Garet", Font.BOLD, 15)); 
        dialog2.setEditable(false);
        hoverImage2.add(dialog2, BorderLayout.CENTER);

        
        backgroundLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
                
            @Override
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                  backgroundLabel2.setVisible(false);
                  hoverImage1.setVisible(false);
                  hotelName2.setVisible(true);
                  locationName2.setVisible(true);
                  destinationName2.setVisible(true);
                  departureName2.setVisible(true);
                  ratingName2.setVisible(true);
                  arrivalName2.setVisible(true);
                  travelclassName2.setVisible(true);
                  hotelLabel2.setVisible(true);
                  locationLabel2.setVisible(true);
                  destinationLabel2.setVisible(true);
                  departureLabel2.setVisible(true);
                  ratingLabel2.setVisible(true);
                  arrivalLabel12.setVisible(true);
                  travelclassLabel2.setVisible(true);
               }
               @Override
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                  hoverImage2.setVisible(true);
               }

               @Override
               public void mouseExited(java.awt.event.MouseEvent evt) {
                  backgroundLabel2.setVisible(true);
                  hoverImage2.setVisible(false);
                  hotelName2.setVisible(false);
                  locationName2.setVisible(false);
                  destinationName2.setVisible(false);
                  departureName2.setVisible(false);
                  ratingName2.setVisible(false);
                  arrivalName2.setVisible(false);
                  travelclassName2.setVisible(false);
                  ratingName2.setVisible(false);
                  hotelLabel2.setVisible(false);
                  locationLabel2.setVisible(false);
                  destinationLabel2.setVisible(false);
                  departureLabel2.setVisible(false);
                  ratingLabel2.setVisible(false);
                  arrivalLabel12.setVisible(false);
                  travelclassLabel2.setVisible(false);
               } 
        });
        bgColor.add(backgroundLabel2);

        ImageIcon imageIcon3 = new ImageIcon("bangkok.jpg");
        Image imageScale3 = imageIcon3.getImage().getScaledInstance(180, 300, Image.SCALE_SMOOTH);
        ImageIcon imageNew3 = new ImageIcon(imageScale3);
        JLabel backgroundLabel3 = new JLabel(imageNew3);
        backgroundLabel3.setBounds(470, 70, 250, 290);
        Frame frame3 = null;
        
        JDialog hoverImage3 = new JDialog(frame, "Package ID", false);
        hoverImage3.setBounds(800, 500, 250, 70);
        hoverImage3.setUndecorated(true);
        
        dialog3 = new JTextArea("Click the picture to see \npackage details");
        dialog3.setFont(new Font("Garet", Font.BOLD, 15)); 
        dialog3.setEditable(false);
        hoverImage3.add(dialog3, BorderLayout.CENTER);

        
        backgroundLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
   
            @Override
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                  backgroundLabel3.setVisible(false);
                  hoverImage1.setVisible(false);
                  hotelName3.setVisible(true);
                  locationName3.setVisible(true);
                  destinationName3.setVisible(true);
                  departureName3.setVisible(true);
                  ratingName3.setVisible(true);
                  arrivalName3.setVisible(true);
                  travelclassName3.setVisible(true);
                  hotelLabel3.setVisible(true);
                  locationLabel3.setVisible(true);
                  destinationLabel3.setVisible(true);
                  departureLabel3.setVisible(true);
                  ratingLabel3.setVisible(true);
                  arrivalLabel13.setVisible(true);
                  travelclassLabel3.setVisible(true);
               }
               @Override
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                  hoverImage3.setVisible(true);
               }

               @Override
               public void mouseExited(java.awt.event.MouseEvent evt) {
                  backgroundLabel3.setVisible(true);
                  hoverImage3.setVisible(false);
                  hotelName3.setVisible(false);
                  locationName3.setVisible(false);
                  destinationName3.setVisible(false);
                  departureName3.setVisible(false);
                  ratingName3.setVisible(false);
                  arrivalName3.setVisible(false);
                  travelclassName3.setVisible(false);
                  ratingName3.setVisible(false);
                  hotelLabel3.setVisible(false);
                  locationLabel3.setVisible(false);
                  destinationLabel3.setVisible(false);
                  departureLabel3.setVisible(false);
                  ratingLabel3.setVisible(false);
                  arrivalLabel13.setVisible(false);
                  travelclassLabel3.setVisible(false);
               } 
        });
        bgColor.add(backgroundLabel3);
       
        ImageIcon imageIcon4 = new ImageIcon("paris.jpg");
        Image imageScale4 = imageIcon4.getImage().getScaledInstance(180, 300, Image.SCALE_SMOOTH);
        ImageIcon imageNew4 = new ImageIcon(imageScale4);
        JLabel backgroundLabel4 = new JLabel(imageNew4);
        backgroundLabel4.setBounds(680, 70, 250, 290);
        Frame frame4 = null;
        
        JDialog hoverImage4 = new JDialog(frame, "Package ID", false);
        hoverImage4.setBounds(1000, 500, 250, 70);
        hoverImage4.setUndecorated(true);
        
        dialog4 = new JTextArea("Click the picture to see \npackage details");
        dialog4.setFont(new Font("Garet", Font.BOLD, 15)); 
        dialog4.setEditable(false);
        hoverImage4.add(dialog4, BorderLayout.CENTER);

        
        backgroundLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
   
            @Override
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                  backgroundLabel4.setVisible(false);
                  hoverImage4.setVisible(false);
                  hotelName4.setVisible(true);
                  locationName4.setVisible(true);
                  destinationName4.setVisible(true);
                  departureName4.setVisible(true);
                  ratingName4.setVisible(true);
                  arrivalName4.setVisible(true);
                  travelclassName4.setVisible(true);
                  hotelLabel4.setVisible(true);
                  locationLabel4.setVisible(true);
                  destinationLabel4.setVisible(true);
                  departureLabel4.setVisible(true);
                  ratingLabel4.setVisible(true);
                  arrivalLabel14.setVisible(true);
                  travelclassLabel4.setVisible(true);
               }
               @Override
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                  hoverImage4.setVisible(true);
               }

               @Override
               public void mouseExited(java.awt.event.MouseEvent evt) {
                  backgroundLabel4.setVisible(true);
                  hoverImage4.setVisible(false);
                  hotelName4.setVisible(false);
                  locationName4.setVisible(false);
                  destinationName4.setVisible(false);
                  departureName4.setVisible(false);
                  ratingName4.setVisible(false);
                  arrivalName4.setVisible(false);
                  travelclassName4.setVisible(false);
                  ratingName4.setVisible(false);
                  hotelLabel4.setVisible(false);
                  locationLabel4.setVisible(false);
                  destinationLabel4.setVisible(false);
                  departureLabel4.setVisible(false);
                  ratingLabel4.setVisible(false);
                  arrivalLabel14.setVisible(false);
                  travelclassLabel4.setVisible(false);
               } 
        });
        bgColor.add(backgroundLabel4);

        btnCountry.addActionListener(this);
        btnCountry2.addActionListener(this);
        btnCountry3.addActionListener(this);
        btnCountry4.addActionListener(this);
                
       
        setVisible(true);
    }

    // ResultSet rs;
    
    public void Connect(){
  
        String url = "jdbc:mysql://localhost:3306/groupninedsaproject";
            String username = "root";
            String password = "admin123";
                  
        try {
             con =  DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(bookPackage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    
    public void actionPerformed(ActionEvent e) {
        JLabel hotelID = new JLabel("SSH001");
        JLabel flightID = new JLabel("FLSY001");
        JLabel price1 = new JLabel("24206.00");
        
        // Labels for information of the hotel
        
        if (e.getSource() == btnCountry) {
            
        int userChoice = JOptionPane.showConfirmDialog(bookPackage.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (userChoice == JOptionPane.YES_OPTION) {            
                       // String userid=.getText();
                        String flightid=flightID.getText();
                        String hotelid=hotelID.getText();
                        String destination=destinationName.getText();
                        String departure=departureName.getText();
                        String arrival=arrivalLabel1.getText();
                        String travelclass=travelclassLabel.getText();
                        String price = price1.getText();
                        String hotelname = hotelLabel.getText();
                        String locationname = locationLabel.getText();
                        String rating = ratingName.getText();
                        
                                               
                        try{
                           pst = con.prepareStatement("insert into package (FlightID,HotelID,Destination,Departure,Arrival,TravelClass,Price,HotelName,Location,Rating) values (?,?,?,?,?,?,?,?,?,?)");
                           pst.setString(1,flightid);
                           pst.setString(2,hotelid);
                           pst.setString(3,destination);
                           pst.setString(4,departure);
                           pst.setString(5,arrival);
                           pst.setString(6,travelclass);
                           pst.setString(7,price);
                           pst.setString(8,hotelname);
                           pst.setString(9,locationname);
                           pst.setString(10,rating);
                        
                           pst.executeUpdate();
                       
                        }catch (SQLException a){
                           a.printStackTrace();
                    } 
            dispose();            
        }

        } 
        
        JLabel hotelID2 = new JLabel("SSH002");
        JLabel flightID2 = new JLabel("FLHU002");
        JLabel price2 = new JLabel("31045.00");
        
        if (e.getSource() == btnCountry2) {
            
        int userChoice2 = JOptionPane.showConfirmDialog(bookPackage.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (userChoice2 == JOptionPane.YES_OPTION) {            
                       // String userid=.getText();
                        String flightid=flightID2.getText();
                        String hotelid=hotelID2.getText();
                        String destination=destinationName2.getText();
                        String departure=departureName2.getText();
                        String arrival=arrivalLabel12.getText();
                        String travelclass=travelclassLabel2.getText();
                        String price = price2.getText();
                        String hotelname = hotelLabel2.getText();
                        String locationname = locationLabel2.getText();
                        String rating = ratingName2.getText();
                        
                                               
                        try{
                           pst = con.prepareStatement("insert into package (FlightID,HotelID,Destination,Departure,Arrival,TravelClass,Price,HotelName,Location,Rating) values (?,?,?,?,?,?,?,?,?,?)");
                           pst.setString(1,flightid);
                           pst.setString(2,hotelid);
                           pst.setString(3,destination);
                           pst.setString(4,departure);
                           pst.setString(5,arrival);
                           pst.setString(6,travelclass);
                           pst.setString(7,price);
                           pst.setString(8,hotelname);
                           pst.setString(9,locationname);
                           pst.setString(10,rating);
                        
                           pst.executeUpdate();
                       
                        }catch (SQLException a){
                           a.printStackTrace();
                    } 
            dispose();            
        }

        } 
        JLabel hotelID3 = new JLabel("SSH003");
        JLabel flightID3 = new JLabel("FLBT003");
        JLabel price3 = new JLabel("15695.00");
        
        if (e.getSource() == btnCountry3) {
            
        int userChoice3 = JOptionPane.showConfirmDialog(bookPackage.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (userChoice3 == JOptionPane.YES_OPTION) {            
                       // String userid=.getText();
                        String flightid=flightID3.getText();
                        String hotelid=hotelID3.getText();
                        String destination=destinationName3.getText();
                        String departure=departureName3.getText();
                        String arrival=arrivalLabel13.getText();
                        String travelclass=travelclassLabel3.getText();
                        String price = price3.getText();
                        String hotelname = hotelLabel3.getText();
                        String locationname = locationLabel3.getText();
                        String rating = ratingName3.getText();
                        
                                               
                        try{
                           pst = con.prepareStatement("insert into package (FlightID,HotelID,Destination,Departure,Arrival,TravelClass,Price,HotelName,Location,Rating) values (?,?,?,?,?,?,?,?,?,?)");
                           pst.setString(1,flightid);
                           pst.setString(2,hotelid);
                           pst.setString(3,destination);
                           pst.setString(4,departure);
                           pst.setString(5,arrival);
                           pst.setString(6,travelclass);
                           pst.setString(7,price);
                           pst.setString(8,hotelname);
                           pst.setString(9,locationname);
                           pst.setString(10,rating);
                        
                           pst.executeUpdate();
                       
                        }catch (SQLException a){
                           a.printStackTrace();
                    } 
            dispose();            
        }

        }
        JLabel hotelID4 = new JLabel("SSH004");
        JLabel flightID4 = new JLabel("FLPF004");
        JLabel price4 = new JLabel("42000.00");
        
        if (e.getSource() == btnCountry4) {
            
        int userChoice4 = JOptionPane.showConfirmDialog(bookPackage.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (userChoice4 == JOptionPane.YES_OPTION) {            
                       // String userid=.getText();
                        String flightid=flightID4.getText();
                        String hotelid=hotelID4.getText();
                        String destination=destinationName4.getText();
                        String departure=departureName4.getText();
                        String arrival=arrivalLabel14.getText();
                        String travelclass=travelclassLabel4.getText();
                        String price = price4.getText();
                        String hotelname = hotelLabel4.getText();
                        String locationname = locationLabel4.getText();
                        String rating = ratingName4.getText();
                        
                                               
                        try{
                           pst = con.prepareStatement("insert into package (FlightID,HotelID,Destination,Departure,Arrival,TravelClass,Price,HotelName,Location,Rating) values (?,?,?,?,?,?,?,?,?,?)");
                           pst.setString(1,flightid);
                           pst.setString(2,hotelid);
                           pst.setString(3,destination);
                           pst.setString(4,departure);
                           pst.setString(5,arrival);
                           pst.setString(6,travelclass);
                           pst.setString(7,price);
                           pst.setString(8,hotelname);
                           pst.setString(9,locationname);
                           pst.setString(10,rating);
                        
                           pst.executeUpdate();
                       
                        }catch (SQLException a){
                           a.printStackTrace();
                    } 
            dispose();            
        }

        }
    }      
       

}