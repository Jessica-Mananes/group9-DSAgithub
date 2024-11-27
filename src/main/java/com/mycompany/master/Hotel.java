/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.master;

/**
 *
 * @author Jovel
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.util.logging.*;

public class Hotel extends JPanel implements ActionListener {

    private JLabel lblSearch, lblHotelID, lblHotelLocation, lblHotelLocExt, lblHotelName, lblparkRating, lblHotelRate, lblRating;
    private JTextField jtfSearch;
    private JButton btnSearch, btnImgeparisParkhyatt, btnImgparisshangri, btnImgparisQT, btnImgenewyorkPlaza, btnImgenewyorkPeninsula, btnImgenewyorkHighline,
            btnImgeafricaCapetown, btnImgeafricaSilo,btnImgeafricaBelmond,btnImgehawaiiFourseasons, btnImgehawaiiAndaz,btnImgehawaiiRitz,
            btnImgespainArts,btnImgespainMandarin, btnImgespainPalace, btnImgthailandMandarin, btnImgthailandSiam, btnImgthailandPeninsula, btnImgfranceRitz, btnImgfranceLemeurice, btnImgfranceShangrila, btnImgjapanCarlton, 
            btnImgjapanHoshinoya, btnImgjapanAman, btnImgitalyRussie, btnImgitalyEden, btnImgitalyRegis, btnImgsouthkoreaFS, btnImgsouthkoreaShilla, btnImgsouthkoreaSigniel;;
    private Font font = new Font("Garet", Font.BOLD, 25),
            hotelFont = new Font("Garet", Font.BOLD, 15),
            fontHotelName = new Font("Arial", Font.BOLD, 20);

    private URL imgparisParkhyatt, imgparisShangri, imgparisQT,imgnewyorkPlaza,imgnewyorkPeninsula,imgnewyorkHighline,imgafricaCapetown,imgafricaSilo,imgafricaBelmond,
            imghawaiiFourseasons, imghawaiiAndaz, imghawaiiRitz, imgspainArts, imgspainMandarin, imgspainPalace,imgparkRating, imgshangriRating, imgplazaRating,
            imgpeninsulaRating, imghighlineRating, imgcapetownRating, imgsiloRating, imgbelmondRating, imgfourseasonRating, imgfandazRating,imgfritzRating,
            imgartsRating, imgmandarinRating, imgpalaceRating, imgthailandMandarin, imgsiamRating, imgthailandSiam, imgthailandPeninsula, imgritzRating, imgfranceRitz, 
            imglemeuriceRating,imgshangrilaRating,imgfranceLemeurice, imgfranceShangrila, imgcarltonRating, imgjapanCarlton, imghoshinoyaRating, imgamanRating, imgjapanHoshinoya,
            imgjapanAman, imgitalyRussie, imgrussieRating, imgedenRating, imgitalyEden, imgregisrating, imgitalyRegis, imgFSRating, imgsouthkoreaFS, imgshillaRating, imgsouthkoreaShilla,
            imgsignielRating, imgsouthkoreaSigniel = null;
    private JPanel framePanel, framePanelsydney,framePanelnewyork,framePanelAfrica,framePanelHawaii, framePanelSpain, framePanelthailand, framePanelfrance, framePaneljapan, framePanelitaly,
            framePanelsouthkorea;;
    private ImageIcon imgIconparisParkhyatt, imgnewiconParkhyatt, imgIconparisShangri, imgiconparisShangri, imgIconparisQT, imgiconparisQT, imgIconnewyorkPlaza, imgnewiconnewyorkPlaza, 
            imgIconnewyorkPeninsula, imgnewiconnewyorkPeninsula, imgIconnewyorkHighline, imgnewiconnewyorkHighline, imgIconafricaCapetown, imgnewiconafricaCapetown, imgIconafricaSilo, 
            imgnewiconafricaSilo, imgIconafricaBelmond, imgnewiconafricaBelmond, imgIconhawaiiFourseasons, imgnewiconhawaiiFourseasons, imgIconhawaiiAndaz, imgnewiconhawaiiAndaz, 
            imgIconhawaiiRitz, imgnewiconhawaiiRitz, imgIconspainArts, imgnewiconspainArts, imgIconspainMandarin, imgnewiconspainMandarin, imgIconspainPalace, imgnewiconspainPalace, 
            imgRating, imgIconRating, imgnewiconRating, imgIconthailandMandarin, imgnewiconMandarin, imgIconthailandSiam, imgnewiconSiam, imgIconthailandPeninsula, imgnewiconPeninsula, 
            imgIconthailandRitz, imgnewiconRitz, imgIconfranceLemeurice, imgnewiconLemeurice, imgIconfranceShangrila, imgnewiconShangrila, imgIconjapanCarlton, imgnewiconCarlton, 
            imgIconjapanHoshinoya, imgnewiconHoshinoya, imgIconjapanAman, imgnewiconAman, imgIconitalyRussie, imgnewiconRussie,imgIconitalyEden, imgnewiconEden, imgIconitalyRegis,
            imgnewiconRegis,imgIconsouthkoreaFS, imgnewiconFS, imgIconsouthkoreaShilla, imgnewiconShilla, imgIconsouthkoreaSigniel, imgnewiconSigniel;
    private JLayeredPane layer;

    Hotel() {
        setSize(1000, 600);
        setLayout(null);
        setBackground(new Color(37, 113, 128));
        
        //allows the componets to don't overlap in on every panel
        layer = new JLayeredPane();
        layer.setBounds(0, 0, 1000, 600);
        add(layer);  

        //search bar 
        jtfSearch = new JTextField();
        jtfSearch.setForeground(new Color(0,0,0));
        jtfSearch.setBackground(new Color(180,204,224));
        jtfSearch.setBounds(230, 50, 415, 30);
        add(jtfSearch);

        lblSearch = new JLabel("PLACE:");
        lblSearch.setFont(font);
        lblSearch.setForeground(new Color(0,0,0));
        lblSearch.setBounds(100, 40, 350, 50);
        add(lblSearch);

        //search button 
        btnSearch = new JButton("SEARCH");
        btnSearch.setFont(font);
        btnSearch.setForeground(new Color(0,0,0));
        btnSearch.setBackground(new Color(180,204,224));
        btnSearch.setBounds(710, 50, 150, 30);
        add(btnSearch);
        

        btnSearch.addActionListener(this);

        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
               //show the specific panel per location
        String place = jtfSearch.getText().trim();
        if (e.getSource() == btnSearch) {
            if (place.equalsIgnoreCase("sydney")) {
                layer.removeAll(); 
                jtfSearch.setText(" "); 
                
                //Panel for the location Sydney
                framePanelsydney = new JPanel();
                framePanelsydney.setBounds(40, 120, 900,450 );
                framePanelsydney.setBackground(new Color(37, 113, 128));
                framePanelsydney.setLayout(null);
                layer.add(framePanelsydney, Integer.valueOf(0)); 
                
                // Labels for information of the hotel
                // Park Hyatt
                
                lblHotelName = new JLabel("Park Hyatt Hotel, Sydney");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(20, 300, 320, 70);
                framePanelsydney.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 7 Hickson Road,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(20, 320, 310, 70);
                framePanelsydney.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Sydney, 2000, Australia");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(20, 340, 320, 70);
                framePanelsydney.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: SPH001");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(20, 360, 320, 70);
                framePanelsydney.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING: ");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(20, 380, 320, 70);
                framePanelsydney.add(lblHotelRate);
                
               
                //Image for rating of Park Hyyat           
    
        try {
                    imgparkRating= new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgparkRating);
                Image imgscaleparkRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleparkRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(85, 380, 200, 90);
                framePanelsydney.add(lblRating);
               
                //Image for every button on the panel
                
        try {
                    imgparisParkhyatt = new URL("https://i.pinimg.com/564x/3e/ec/79/3eec79db610cfed2438a14a762317c0b.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconparisParkhyatt = new ImageIcon(imgparisParkhyatt);
                Image imgscaleParkhyatt = imgIconparisParkhyatt.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconParkhyatt = new ImageIcon(imgscaleParkhyatt);
                btnImgeparisParkhyatt = new JButton(imgnewiconParkhyatt);
                btnImgeparisParkhyatt.setBounds(20, 10, 250, 300);
                 
                btnImgeparisParkhyatt.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                    
                }
                  });                
                framePanelsydney.add(btnImgeparisParkhyatt);
                
                
              // Labels for information of the hotel
              // Shangri
              
                lblHotelName = new JLabel("Shangri-La Hotel, Sydney");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(325, 300, 320, 70);
                framePanelsydney.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 176 Cumberland St,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(325, 320, 310, 70);
                framePanelsydney.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("The Rocks NSW 2000, Australia");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(325, 340, 320, 70);
                framePanelsydney.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: SSH002");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(325, 360, 320, 70);
                framePanelsydney.add(lblHotelID);
                
                lblHotelRate = new JLabel("RATING: ");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(325, 380, 320, 70);
                framePanelsydney.add(lblHotelRate);
                 
                    //Image for rating of Shangri       
    
         try {
                    imgparkRating= new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgparkRating);
                Image imgscaleshangriRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleshangriRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(390, 380, 200, 90);
                framePanelsydney.add(lblRating);
                
                
                //Image for every button on the panel
                
        try {
                    imgparisShangri = new URL("https://i.pinimg.com/564x/f2/71/0e/f2710e37285de62b984df4a004ee793b.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconparisShangri = new ImageIcon(imgparisShangri);
                Image imgscaleparisShangri = imgIconparisShangri.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgiconparisShangri = new ImageIcon(imgscaleparisShangri);
                btnImgparisshangri = new JButton(imgiconparisShangri);
                btnImgparisshangri.setBounds(325, 10, 250, 300);
                
               
                btnImgparisshangri.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
                    new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  });
                framePanelsydney.add(btnImgparisshangri);
                
                
                // Labels for information of the hotel
                // QT
                
                lblHotelName = new JLabel("QT Hotel, Sydney");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(630, 300, 320, 70);
                framePanelsydney.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 49 Market St,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(630, 320, 310, 70);
                framePanelsydney.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("The Rocks NSW 2000, Australia");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(630, 340, 320, 70);
                framePanelsydney.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: SQH003");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(630, 360, 320, 70);
                framePanelsydney.add(lblHotelID);
                
                lblHotelRate = new JLabel("RATING: ");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(630, 380, 320, 70);
                framePanelsydney.add(lblHotelRate);
                
                //Image for rating of QT       
    
        try {
                    imgparkRating= new URL("https://i.pinimg.com/736x/83/ba/60/83ba60cbe75a12d50435de0a3bdc5343.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgparkRating);
                Image imgscaleqtRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleqtRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(690, 380, 200, 90);
                framePanelsydney.add(lblRating);
                
                
                //Image for every button on the panel
            
        try {
                    imgparisQT = new URL("https://i.pinimg.com/564x/6c/b2/fb/6cb2fb581d0cf4264ac68134c2cada0d.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconparisQT = new ImageIcon(imgparisQT);
                Image imgscaleparisQT = imgIconparisQT.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgiconparisQT = new ImageIcon(imgscaleparisQT);
                btnImgparisQT = new JButton(imgiconparisQT);
                btnImgparisQT.setBounds(630, 10, 250, 300);
                
                btnImgparisQT.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  });     
                framePanelsydney.add(btnImgparisQT);
           
                }
            
            
                //show the specific panel per location
            
    else if 
                (place.equalsIgnoreCase("new york")) {
                layer.removeAll();                
                jtfSearch.setText(" ");
                
                //Panel for the location New York
                framePanelnewyork = new JPanel();
                framePanelnewyork.setBounds(40, 120, 900, 450);
                framePanelnewyork.setBackground(new Color(37, 113, 128));
                framePanelnewyork.setLayout(null);
                layer.add(framePanelnewyork, Integer.valueOf(0)); 
                
                // Labels for information of the hotel
                    // The Plaza Hotel, New York
                
                lblHotelName = new JLabel("The Plaza Hotel, NY");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(20, 300, 320, 70);
                framePanelnewyork.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 5th Avenue, Central Park,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(20, 320, 310, 70);
                framePanelnewyork.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("New York, NY, USA");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(20, 340, 320, 70);
                framePanelnewyork.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: NYH004");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(20, 360, 320, 70);
                framePanelnewyork.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(20, 380, 320, 70);
                framePanelnewyork.add(lblHotelRate);
                
                 //Image for rating of Plaza          
    
        try {
                    imgplazaRating= new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgplazaRating);
                Image imgscaleplazaRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleplazaRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(85, 380, 200, 90);
                framePanelnewyork.add(lblRating);
               
                //Image for every button on the panel
                
        try {
                    imgnewyorkPlaza = new URL("https://i.pinimg.com/enabled_lo/564x/eb/5f/06/eb5f060b15a978684b04f7dd39812a53.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconnewyorkPlaza = new ImageIcon(imgnewyorkPlaza);
                Image imgscalenewyorkPlaza = imgIconnewyorkPlaza.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconnewyorkPlaza = new ImageIcon(imgscalenewyorkPlaza);
                btnImgenewyorkPlaza = new JButton(imgnewiconnewyorkPlaza);
                btnImgenewyorkPlaza.setBounds(20, 10, 250, 300);
                btnImgenewyorkPlaza.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelnewyork.add(btnImgenewyorkPlaza);
                
                
                // Labels for information of the hotel
                    // The Peninsula Hotel, New York
                
                lblHotelName = new JLabel("The Peninsula Hotel, NY");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(325, 300, 320, 70);
                framePanelnewyork.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 700 5th Avenue,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(325, 320, 310, 70);
                framePanelnewyork.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("New York, NY 10019, United States");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(325, 340, 320, 70);
                framePanelnewyork.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: NYH005");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(325, 360, 320, 70);
                framePanelnewyork.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(325, 380, 320, 70);
                framePanelnewyork.add(lblHotelRate);
                
                //Image for rating of Peninsula          
    
        try {
                    imgpeninsulaRating= new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgpeninsulaRating);
                Image imgscalepeninsulaRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalepeninsulaRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(390, 380, 200, 90);
                framePanelnewyork.add(lblRating);
                
                //Image for every button on the panel
                
        try {
                    imgnewyorkPeninsula = new URL("https://i.pinimg.com/564x/4f/1b/fe/4f1bfe304485aeaae2d8b46a1115230e.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconnewyorkPeninsula = new ImageIcon(imgnewyorkPeninsula);
                Image imgscalenewyorkPeninsula = imgIconnewyorkPeninsula.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconnewyorkPeninsula = new ImageIcon(imgscalenewyorkPeninsula);
                btnImgenewyorkPeninsula = new JButton(imgnewiconnewyorkPeninsula);
                btnImgenewyorkPeninsula.setBounds(325, 10, 250, 300);
                btnImgenewyorkPeninsula.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelnewyork.add(btnImgenewyorkPeninsula);
                
                
                  // Labels for information of the hotel
                    // The High Line Hotel, New York
                
                lblHotelName = new JLabel("The Standard High Line, NY");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(630, 300, 320, 70);
                framePanelnewyork.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 848 Washington St,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(630, 320, 310, 70);
                framePanelnewyork.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("New York, NY 10014, United State");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(630, 340, 320, 70);
                framePanelnewyork.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: NYH006");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(630, 360, 320, 70);
                framePanelnewyork.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(630, 380, 320, 70);
                framePanelnewyork.add(lblHotelRate);
                
                //Image for rating of High Line          
    
        try {
                    imghighlineRating= new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imghighlineRating);
                Image imgscalehighlineRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalehighlineRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(690, 380, 200, 90);
                framePanelnewyork.add(lblRating);
                
                //Image for every button on the panel
                
        try {
                    imgnewyorkHighline = new URL("https://i.pinimg.com/564x/8f/41/4d/8f414d4cd9f7f163f9450470cdf88623.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconnewyorkHighline = new ImageIcon(imgnewyorkHighline);
                Image imgscalenewyorkHighline = imgIconnewyorkHighline.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconnewyorkHighline = new ImageIcon(imgscalenewyorkHighline);
                btnImgenewyorkHighline = new JButton(imgnewiconnewyorkHighline);
                btnImgenewyorkHighline.setBounds(630, 10, 250, 300);
                btnImgenewyorkHighline.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelnewyork.add(btnImgenewyorkHighline);
            }
    
                //show the specific panel per location
        
    else if 
                (place.equalsIgnoreCase("south africa")) {
                layer.removeAll();                
                jtfSearch.setText(" ");

                //Panel for the location  South Africa
                framePanelAfrica = new JPanel();
                framePanelAfrica.setBounds(40, 120, 900, 450);
                framePanelAfrica.setBackground(new Color(37, 113, 128));
                framePanelAfrica.setLayout(null);
                layer.add(framePanelAfrica, Integer.valueOf(0));  
                
                
                // Labels for information of the hotel
                    // One&Only Cape Town Hotel
                
                lblHotelName = new JLabel("One&Only Cape Town Hotel");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(20, 300, 320, 70);
                framePanelAfrica.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: Dock Rd, Victoria & Alfred");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(20, 320, 310, 70);
                framePanelAfrica.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Waterfront, Cape Town, 8001, SA");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(20, 340, 320, 70);
                framePanelAfrica.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: ACH007");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(20, 360, 320, 70);
                framePanelAfrica.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(20, 380, 320, 70);
                framePanelAfrica.add(lblHotelRate);

                    //Image for rating of cape town          
    
        try {
                    imgcapetownRating = new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgcapetownRating);
                Image imgscalecapetownRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalecapetownRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(85, 380, 200, 90);
                framePanelAfrica.add(lblRating);
                
                //Image for every button on the panel
                
        try {
                    imgafricaCapetown = new URL("https://i.pinimg.com/564x/da/a0/ea/daa0ea4f0b7568585c02a8944de57983.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconafricaCapetown = new ImageIcon(imgafricaCapetown);
                Image imgscaleafricaCapetown = imgIconafricaCapetown.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconafricaCapetown = new ImageIcon(imgscaleafricaCapetown);
                btnImgeafricaCapetown = new JButton(imgnewiconafricaCapetown);
                btnImgeafricaCapetown.setBounds(20, 10, 250, 300);
                btnImgeafricaCapetown.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                 
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelAfrica.add(btnImgeafricaCapetown);
               
                
                 // Labels for information of the hotel
                    // Silo Hotel
                
                lblHotelName = new JLabel("Silo Hotel");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(325, 300, 320, 70);
                framePanelAfrica.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: Silo Square, Victoria &");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(325, 320, 310, 70);
                framePanelAfrica.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Alfred Waterfront, Cape Town, 8001, SA");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(325, 340, 320, 70);
                framePanelAfrica.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: ASH008");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(325, 360, 320, 70);
                framePanelAfrica.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(325, 380, 320, 70);
                framePanelAfrica.add(lblHotelRate);
                
                 //Image for rating of Silo        
    
        try {
                    imgsiloRating = new URL("https://i.pinimg.com/736x/83/ba/60/83ba60cbe75a12d50435de0a3bdc5343.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgsiloRating);
                Image imgscalesiloRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalesiloRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(390, 380, 200, 90);
                framePanelAfrica.add(lblRating);
                
                //Image for every button on the panel
                
        try {
                    imgafricaSilo = new URL("https://i.pinimg.com/564x/f7/e6/61/f7e66172b1d598a92bc3ef5ff6d192b1.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconafricaSilo = new ImageIcon(imgafricaSilo);
                Image imgscaleafricaSilo = imgIconafricaSilo.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconafricaSilo = new ImageIcon(imgscaleafricaSilo);
                btnImgeafricaSilo = new JButton(imgnewiconafricaSilo);
                btnImgeafricaSilo.setBounds(325, 10, 250, 300);
                btnImgeafricaSilo.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelAfrica.add(btnImgeafricaSilo);
                
                
                // Labels for information of the hotel
                // Belmond Hotel
                
                lblHotelName = new JLabel("Belmond M.N. Hotel");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(630, 300, 320, 70);
                framePanelAfrica.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 76 Orange St, Gardens,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(630, 320, 310, 70);
                framePanelAfrica.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Cape Town, 8001, South Africa");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(630, 340, 320, 70);
                framePanelAfrica.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: ABH009");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(630, 360, 320, 70);
                framePanelAfrica.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(630, 380, 320, 70);
                framePanelAfrica.add(lblHotelRate);
                
                //Image for rating of Belmond       
    
        try {
                    imgbelmondRating = new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgbelmondRating);
                Image imgscalebelmondRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalebelmondRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(690, 380, 200, 90);
                framePanelAfrica.add(lblRating);
                
                //Image for every button on the panel
                
        try {
                    imgafricaBelmond = new URL("https://i.pinimg.com/564x/3b/05/e4/3b05e4ba8da4d36e241e236539fbc3e5.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconafricaBelmond = new ImageIcon(imgafricaBelmond);
                Image imgscaleafricaBelmond = imgIconafricaBelmond.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconafricaBelmond = new ImageIcon(imgscaleafricaBelmond);
                btnImgeafricaBelmond = new JButton(imgnewiconafricaBelmond);
                btnImgeafricaBelmond.setBounds(630, 10, 250, 300);
                btnImgeafricaBelmond.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelAfrica.add(btnImgeafricaBelmond);
               }
                  
                
                //show the specific panel per location
            
    else if       
               (place.equalsIgnoreCase("hawaii")) {
                layer.removeAll();
                jtfSearch.setText(" ");
                
                //Panel for the location Sydney Hawaii
                framePanelHawaii = new JPanel();
                framePanelHawaii.setBounds(40, 120, 900, 450);
                framePanelHawaii.setBackground(new Color(37, 113, 128));
                framePanelHawaii.setLayout(null);
                layer.add(framePanelHawaii, Integer.valueOf(0));  
                
                
                // Labels for information of the hotel
                // Four Seasons Resort Maui at Wailea
                
                lblHotelName = new JLabel("Four Seasons Resort");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(20, 300, 320, 70);
                framePanelHawaii.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 3900 Wailea Alanui Dr,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(20, 320, 310, 70);
                framePanelHawaii.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Kihei, HI 96753, United States");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(20, 340, 320, 70);
                framePanelHawaii.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: HFH0010");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(20, 360, 320, 70);
                framePanelHawaii.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(20, 380, 320, 70);
                framePanelHawaii.add(lblHotelRate);
                
                
                //Image for rating of Four Seasons Resort Maui at Wailea     
                
        try {
                    imgfourseasonRating = new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgfourseasonRating);
                Image imgscalefourseasoRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalefourseasoRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(85, 380, 200, 90);
                framePanelHawaii.add(lblRating);
                
                //Image for every button on the panel
                
        try {
                    imghawaiiFourseasons = new URL("https://i.pinimg.com/564x/25/c0/0a/25c00aacc1335e2c2f6e274516862caf.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconhawaiiFourseasons = new ImageIcon(imghawaiiFourseasons);
                Image imgscalehawaiiFourseasons = imgIconhawaiiFourseasons.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconhawaiiFourseasons = new ImageIcon(imgscalehawaiiFourseasons);
                btnImgehawaiiFourseasons = new JButton(imgnewiconhawaiiFourseasons);
                btnImgehawaiiFourseasons.setBounds(20, 10, 250, 300);
                btnImgehawaiiFourseasons.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelHawaii.add(btnImgehawaiiFourseasons);
                
                
                // Labels for information of the hotel
                // Andaz Maui At Wailea Resort
                
                lblHotelName = new JLabel("Andaz Maui At Wailea Resort");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(325, 300, 320, 70);
                framePanelHawaii.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 3550 Wailea Alanui Dr,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(325, 320, 310, 70);
                framePanelHawaii.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Wailea, HI 96753, United States");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(325, 340, 320, 70);
                framePanelHawaii.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: HAH011");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(325, 360, 320, 70);
                framePanelHawaii.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(325, 380, 320, 70);
                framePanelHawaii.add(lblHotelRate);
                
                 //Image for rating of Andaz Maui At Wailea Resort    
                
        try {
                    imgfandazRating = new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgfandazRating);
                Image imgscaleandazRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleandazRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(390, 380, 200, 90);
                framePanelHawaii.add(lblRating);
                
                //Image for every button on the panel
                
        try {
                    imghawaiiAndaz = new URL("https://i.pinimg.com/564x/8b/1d/3c/8b1d3cbc80e576f7e65929aff79e70b5.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconhawaiiAndaz = new ImageIcon(imghawaiiAndaz);
                Image imgscalehawaiiAndaz = imgIconhawaiiAndaz.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconhawaiiAndaz = new ImageIcon(imgscalehawaiiAndaz);
                btnImgehawaiiAndaz = new JButton(imgnewiconhawaiiAndaz);
                btnImgehawaiiAndaz.setBounds(325, 10, 250, 300);
                btnImgehawaiiAndaz.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelHawaii.add(btnImgehawaiiAndaz);
                
                
                // Labels for information of the hotel
                // The Ritz-Carlton, Kapalua
                
                lblHotelName = new JLabel("The Ritz-Carlton, Kapalua");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(630, 300, 320, 70);
                framePanelHawaii.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 1 Ritz Carlton Dr, Lahaina,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(630, 320, 310, 70);
                framePanelHawaii.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("HI 96761, United States");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(630, 340, 320, 70);
                framePanelHawaii.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: HRH012");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(630, 360, 320, 70);
                framePanelHawaii.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(630, 380, 320, 70);
                framePanelHawaii.add(lblHotelRate);
                
                //Image for rating of Andaz Maui At Wailea Resort    
                
                 try {
                    imgfritzRating = new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgfritzRating);
                Image imgscaleritzRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleritzRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(690, 380, 200, 90);
                framePanelHawaii.add(lblRating);
                
                
                //Image for every button on the panel
                
         try {
                    imghawaiiRitz = new URL("https://i.pinimg.com/564x/4a/10/a6/4a10a6576d9671d216156c928e268613.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconhawaiiRitz = new ImageIcon(imghawaiiRitz);
                Image imgscalehawaiiRitz = imgIconhawaiiRitz.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconhawaiiRitz = new ImageIcon(imgscalehawaiiRitz);
                btnImgehawaiiRitz = new JButton(imgnewiconhawaiiRitz);
                btnImgehawaiiRitz.setBounds(630, 10, 250, 300);
                btnImgehawaiiRitz.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelHawaii.add(btnImgehawaiiRitz);
                
                }
    
                
                   //show the specific panel per location

    else if
                (place.equalsIgnoreCase("Spain")) {
                layer.removeAll();
                jtfSearch.setText(" ");
                
                //Panel for the location Spain
                framePanelSpain = new JPanel();
                framePanelSpain.setBounds(40, 120, 900, 450);
                framePanelSpain.setBackground(new Color(37, 113, 128));
                framePanelSpain.setLayout(null);
                layer.add(framePanelSpain, Integer.valueOf(0));  
                
                // Labels for information of the hotel
                    // Hotel Arts Barcelona
                
                lblHotelName = new JLabel("Hotel Arts Barcelona");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(20, 300, 320, 70);
                framePanelSpain.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: Carrer de la Marina, 19-21,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(20, 320, 310, 70);
                framePanelSpain.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Ciutat Vella, 08005 Barcelona, Spain");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(20, 340, 320, 70);
                framePanelSpain.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: SAH013");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(20, 360, 320, 70);
                framePanelSpain.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(20, 380, 320, 70);
                framePanelSpain.add(lblHotelRate);
                 
                       
                   //Image for rating of Hotel Arts Barcelona     
                
        try {
                    imgartsRating = new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgartsRating);
                Image imgscaleartsRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleartsRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(85, 380, 200, 90);
                framePanelSpain.add(lblRating);
                
                //Image for every button on the panel
                
        try {
                    imgspainArts = new URL("https://i.pinimg.com/564x/65/d4/37/65d43744520ebca141c6df40f83e3874.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconspainArts = new ImageIcon(imgspainArts);
                Image imgscalespainArts = imgIconspainArts.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconspainArts = new ImageIcon(imgscalespainArts);
                btnImgespainArts = new JButton(imgnewiconspainArts);
                btnImgespainArts.setBounds(20, 10, 250, 300);
                btnImgespainArts.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  });
                framePanelSpain.add(btnImgespainArts);
                
                
                // Labels for information of the hotel
                // Mandarin Oriental, Barcelona
                
                lblHotelName = new JLabel("Mandarin Oriental, Barcelona");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(325, 300, 320, 70);
                framePanelSpain.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: Pg. de Gràcia, 38-40,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(325, 320, 310, 70);
                framePanelSpain.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("L'Eixample, 08007 Barcelona, Spain");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(325, 340, 320, 70);
                framePanelSpain.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: SMH014");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(325, 360, 320, 70);
                framePanelSpain.add(lblHotelID);
                
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(325, 380, 320, 70);
                framePanelSpain.add(lblHotelRate);
                
                
                //Image for rating of Mandarin Oriental, Barcelona 
                
       try {
                    imgmandarinRating = new URL("https://i.pinimg.com/736x/83/ba/60/83ba60cbe75a12d50435de0a3bdc5343.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgmandarinRating);
                Image imgscalemandarinRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalemandarinRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(390, 380, 200, 90);
                framePanelSpain.add(lblRating);
                
                //Image for every button on the panel
                    
        try {
                    imgspainMandarin = new URL("https://i.pinimg.com/564x/0c/49/65/0c4965a6787723d7e12b174c2c871745.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconspainMandarin = new ImageIcon(imgspainMandarin);
                Image imgscalespainMandarin = imgIconspainMandarin.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconspainMandarin = new ImageIcon(imgscalespainMandarin);
                btnImgespainMandarin = new JButton(imgnewiconspainMandarin);
                btnImgespainMandarin.setBounds(325, 10, 250, 300);
                btnImgespainMandarin.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  });
                framePanelSpain.add(btnImgespainMandarin);
                
                
                // Labels for information of the hotel
                // El Palace Hotel, Barcelona
                
                lblHotelName = new JLabel("El Palace Hotel");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(630, 300, 320, 70);
                framePanelSpain.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION:Gran Via de les Corts Catalanes,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(630, 320, 310, 70);
                framePanelSpain.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("668, L'Eixample, 08010 Barcelona, Spain");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(630, 340, 320, 70);
                framePanelSpain.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: SPH015");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(630, 360, 320, 70);
                framePanelSpain.add(lblHotelID);
                
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(630, 380, 320, 70);
                framePanelSpain.add(lblHotelRate);
                
                //Image for rating of El Palace Hotel, Barcelona
                
        try {
                    imgpalaceRating = new URL("https://i.pinimg.com/736x/83/ba/60/83ba60cbe75a12d50435de0a3bdc5343.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgpalaceRating);
                Image imgscalepalaceRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalepalaceRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(690, 380, 200, 90);
                framePanelSpain.add(lblRating);
                
                //Image for every button on the panel
                       
        try {
                    imgspainPalace = new URL("https://i.pinimg.com/736x/ae/7b/eb/ae7beb7ca820ace88a28b1455387d941.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconspainPalace = new ImageIcon(imgspainPalace);
                Image imgscalespainPalace = imgIconspainPalace.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconspainPalace = new ImageIcon(imgscalespainPalace);
                btnImgespainPalace = new JButton(imgnewiconspainPalace);
                btnImgespainPalace.setBounds(630, 10, 250, 300);
                btnImgespainPalace.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  });
                framePanelSpain.add(btnImgespainPalace);
                
                }    

                
                //show the specific panel per location

    
        else if(place.equalsIgnoreCase("thailand")) {
                layer.removeAll();
                jtfSearch.setText(" ");

                //Panel for the location for Thailand
                framePanelthailand = new JPanel();
                framePanelthailand.setBounds(40, 120, 900, 400);
                framePanelthailand.setBackground(new Color(37, 113, 128));
                framePanelthailand.setLayout(null);
                layer.add(framePanelthailand, Integer.valueOf(0));
          
                //Labels for the information of the hotel
                //Mandarin
                lblHotelName = new JLabel("Mandarin Oriental");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(20, 300, 320, 70);
                framePanelthailand.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 48 Oriental Avenue,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(20, 320, 310, 70);
                framePanelthailand.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Bangkok 10500, Thailand");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(20, 340, 320, 70);
                framePanelthailand.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: BKK001");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(20, 360, 320, 70);
                framePanelthailand.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING: ");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(20, 380, 320, 70);
                framePanelthailand.add(lblHotelRate);
                
                //Image rating for Mandarin
                try {
                    imgmandarinRating = new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgmandarinRating);
                Image imgscalemandarinRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalemandarinRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(85, 380, 200, 90);
                framePanelthailand.add(lblRating);

                //Image button for Mandarin
                try {
                    imgthailandMandarin = new URL("https://i.pinimg.com/564x/5c/b9/e7/5cb9e782c2c1c272c9ed252e7d90d1cf.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }
             
                imgIconthailandMandarin = new ImageIcon(imgthailandMandarin);
                Image imgscaleMandarin = imgIconthailandMandarin.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconMandarin = new ImageIcon(imgscaleMandarin);
                btnImgthailandMandarin = new JButton(imgnewiconMandarin);
                btnImgthailandMandarin.setBounds(20, 10, 250, 300);
                 
                btnImgthailandMandarin.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  });                
                framePanelthailand.add(btnImgthailandMandarin);

                
                //Labels for the information of the hotel
                //Siam
                lblHotelName = new JLabel("The Siam");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(325, 300, 320, 70);
                framePanelthailand.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 3/2 Thanon Khao,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(325, 320, 310, 70);
                framePanelthailand.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Bangkok 10300, Thailand");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(325, 340, 320, 70);
                framePanelthailand.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: BKK001");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(325, 360, 320, 70);
                framePanelthailand.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING: ");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(325, 380, 320, 70);
                framePanelthailand.add(lblHotelRate);
                
                
                //Image rating for Siam
                try {
                    imgsiamRating = new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgsiamRating);
                Image imgscalesiamRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalesiamRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(390, 380, 200, 90);
                framePanelthailand.add(lblRating);

                
                //Image button for Siam
                try {
                    imgthailandSiam = new URL("https://i.pinimg.com/564x/50/97/90/5097908389f8bba668a3f1b61275c760.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }
             
                imgIconthailandSiam = new ImageIcon(imgthailandSiam);
                Image imgscaleSiam = imgIconthailandSiam.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconSiam = new ImageIcon(imgscaleSiam);
                btnImgthailandSiam = new JButton(imgnewiconSiam);
                btnImgthailandSiam.setBounds(325, 10, 250, 300);
                 
                btnImgthailandSiam.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  });                
                framePanelthailand.add(btnImgthailandSiam);
                
                
                //Labels for the information of the hotel
                //Peninsula
                lblHotelName = new JLabel("The Peninsula");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(630, 300, 320, 70);
                framePanelthailand.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 333 Charoennakorn");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(630, 320, 310, 70);
                framePanelthailand.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Road, Bangkok 10600, Thailand ");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(630, 340, 320, 70);
                framePanelthailand.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: BKK003");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(630, 360, 320, 70);
                framePanelthailand.add(lblHotelID);
                
                lblHotelRate = new JLabel("RATING: ");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(630, 380, 320, 70);
                framePanelthailand.add(lblHotelRate);
    
                //Image rating for Peninsula
                try {
                    imgpeninsulaRating= new URL("https://i.pinimg.com/736x/83/ba/60/83ba60cbe75a12d50435de0a3bdc5343.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgpeninsulaRating);
                Image imgscalepeninsulaRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalepeninsulaRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(690, 380, 200, 90);
                framePanelthailand.add(lblRating);
    
                //Image button for Peninsula
            
                try {
                    imgthailandPeninsula = new URL("https://i.pinimg.com/564x/a6/9a/dd/a69add4f64984c533740a01fcd178c5e.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconthailandPeninsula = new ImageIcon(imgthailandPeninsula);
                Image imgscalepeninsula = imgIconthailandPeninsula.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconPeninsula = new ImageIcon(imgscalepeninsula);
                btnImgthailandPeninsula = new JButton(imgnewiconPeninsula);
                btnImgthailandPeninsula.setBounds(630, 10, 250, 300);
                
                btnImgthailandPeninsula.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  });     
                framePanelthailand.add(btnImgthailandPeninsula);
                
               

                
                //Show the specific panel for location
                } else if 
                (place.equalsIgnoreCase("france")) {
                layer.removeAll();                
                jtfSearch.setText(" ");
                
                //Panel for the location for France
                framePanelfrance = new JPanel();
                framePanelfrance.setBounds(40, 120, 900, 450);
                framePanelfrance.setBackground(new Color(37, 113, 128));
                framePanelfrance.setLayout(null);
                layer.add(framePanelfrance, Integer.valueOf(0));
                
                
                //Labels for the information of the hotel
                //Ritz
                lblHotelName = new JLabel("The Ritz");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(20, 300, 320, 70);
                framePanelfrance.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 15 Place Vendôme,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(20, 320, 310, 70);
                framePanelfrance.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("75001 Paris, France");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(20, 340, 320, 70);
                framePanelfrance.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: PAR001");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(20, 360, 320, 70);
                framePanelfrance.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING: ");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(20, 380, 320, 70);
                framePanelfrance.add(lblHotelRate);
                
                
                //Image rating for Ritz
                try {
                    imgritzRating = new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgritzRating);
                Image imgscaleritzRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleritzRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(85, 380, 200, 90);
                framePanelfrance.add(lblRating);
                
                
                //Image button for Ritz
                try {
                    imgfranceRitz = new URL("https://i.pinimg.com/564x/7f/f1/18/7ff11870d27c8df2e0ddd9415111d0eb.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }
             
                imgIconthailandRitz = new ImageIcon(imgfranceRitz);
                Image imgscaleRitz = imgIconthailandRitz.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconRitz = new ImageIcon(imgscaleRitz);
                btnImgfranceRitz = new JButton(imgnewiconRitz);
                btnImgfranceRitz.setBounds(20, 10, 250, 300);
                 
                btnImgfranceRitz.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  });                
                framePanelfrance.add(btnImgfranceRitz);
                
                
                //Labels for the information of the hotel
                //Le Meurice
                lblHotelName = new JLabel("Le Meurice");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(325, 300, 320, 70);
                framePanelfrance.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 228 Rue de Rivoli,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(325, 320, 310, 70);
                framePanelfrance.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("75001 Paris, France");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(325, 340, 320, 70);
                framePanelfrance.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: PAR002");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(325, 360, 320, 70);
                framePanelfrance.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING: ");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(325, 380, 320, 70);
                framePanelfrance.add(lblHotelRate);
                
                
                //Image rating for Le Meurice
                try {
                    imglemeuriceRating = new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imglemeuriceRating);
                Image imgscalelemeuriceRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalelemeuriceRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(390, 380, 200, 90);
                framePanelfrance.add(lblRating);

                
                //Image button for Le Meurice
                try {
                    imgfranceLemeurice = new URL("https://i.pinimg.com/564x/32/fc/5c/32fc5ca458109054786030cc9de7b9d1.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }
             
                imgIconfranceLemeurice = new ImageIcon(imgfranceLemeurice);
                Image imgscalelemeurice = imgIconfranceLemeurice.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconLemeurice = new ImageIcon(imgscalelemeurice);
                btnImgfranceLemeurice = new JButton(imgnewiconLemeurice);
                btnImgfranceLemeurice.setBounds(325, 10, 250, 300);
                 
                btnImgfranceLemeurice.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  });                
                framePanelfrance.add(btnImgfranceLemeurice);
                
                
                //Labels for the information of the hotel
                //Shangri-La
                lblHotelName = new JLabel("Shangri-La");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(630, 300, 320, 70);
                framePanelfrance.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 10 Avenue d'Iéna,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(630, 320, 310, 70);
                framePanelfrance.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("75116 Paris, France ");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(630, 340, 320, 70);
                framePanelfrance.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: PAR003");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(630, 360, 320, 70);
                framePanelfrance.add(lblHotelID);
                
                lblHotelRate = new JLabel("RATING: ");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(630, 380, 320, 70);
                framePanelfrance.add(lblHotelRate);
    
    
                //Image rating for Shangrila
                try {
                    imgshangrilaRating= new URL("https://i.pinimg.com/736x/83/ba/60/83ba60cbe75a12d50435de0a3bdc5343.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgshangrilaRating);
                Image imgscaleshangrilaRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleshangrilaRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(690, 380, 200, 90);
                framePanelfrance.add(lblRating);
    
            
                //Image button for Shangrila
                try {
                    imgfranceShangrila = new URL("https://i.pinimg.com/564x/86/4f/98/864f98d4b666bc0fee5fcaf133c82146.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconfranceShangrila = new ImageIcon(imgfranceShangrila);
                Image imgscaleShangrila = imgIconfranceShangrila.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconShangrila = new ImageIcon(imgscaleShangrila);
                btnImgfranceShangrila = new JButton(imgnewiconShangrila);
                btnImgfranceShangrila.setBounds(630, 10, 250, 300);
                
                btnImgfranceShangrila.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  });     
                framePanelfrance.add(btnImgfranceShangrila);
                
                

                //Show the specific panel for location
                } else if 
                (place.equalsIgnoreCase("japan")) {
                layer.removeAll();                
                jtfSearch.setText(" ");
                
                //Panel for the location for Japan
                framePaneljapan = new JPanel();
                framePaneljapan.setBounds(40, 120, 900, 450);
                framePaneljapan.setBackground(new Color(37, 113, 128));
                framePaneljapan.setLayout(null);
                layer.add(framePaneljapan, Integer.valueOf(0));
                
                
                //Labels for the information of the hotel
                //Ritz-Carlton
                lblHotelName = new JLabel("The Ritz-Carlton");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(20, 300, 320, 70);
                framePaneljapan.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: Kamogawa Nijo-Ohashi");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(20, 320, 310, 70);
                framePaneljapan.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Hotori, Kyoto 604-0902, Japan");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(20, 340, 320, 70);
                framePaneljapan.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: KYT001");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(20, 360, 320, 70);
                framePaneljapan.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(20, 380, 320, 70);
                framePaneljapan.add(lblHotelRate);
           
    
                //Image rating for Carlton
                try {
                    imgcarltonRating= new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgcarltonRating);
                Image imgscalecarltonRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalecarltonRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(85, 380, 200, 90);
                framePaneljapan.add(lblRating);

                
                //Image button for Carlton
                try {
                    imgjapanCarlton = new URL("https://i.pinimg.com/564x/ec/eb/48/eceb48e550b40855f112a6a52c3a84d5.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconjapanCarlton = new ImageIcon(imgjapanCarlton);
                Image imgscaleCarlton = imgIconjapanCarlton.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconCarlton = new ImageIcon(imgscaleCarlton);
                btnImgjapanCarlton = new JButton(imgnewiconCarlton);
                btnImgjapanCarlton.setBounds(20, 10, 250, 300);
                btnImgjapanCarlton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePaneljapan.add(btnImgjapanCarlton);
                
                
                
                //Labels for the information of the hotel
                //Hoshinoya
                lblHotelName = new JLabel("Hoshinoya");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(325, 300, 320, 70);
                framePaneljapan.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 11-2 Arashiyama");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(325, 320, 310, 70);
                framePaneljapan.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Genrokuzancho, Kyoto 616-0007, Japan");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(325, 340, 320, 70);
                framePaneljapan.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: KYT002");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(325, 360, 320, 70);
                framePaneljapan.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(325, 380, 320, 70);
                framePaneljapan.add(lblHotelRate);
        
                
                //Image rating for Hoshinoya
                try {
                    imghoshinoyaRating= new URL("https://i.pinimg.com/736x/83/ba/60/83ba60cbe75a12d50435de0a3bdc5343.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imghoshinoyaRating);
                Image imgscalehoshinoyaRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalehoshinoyaRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(390, 380, 200, 90);
                framePaneljapan.add(lblRating);
                
                
                //Image button for Hoshinoya
                try {
                    imgjapanHoshinoya = new URL("https://i.pinimg.com/564x/9a/a6/86/9aa68657bc61ebd569c0cb39c342d239.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconjapanHoshinoya = new ImageIcon(imgjapanHoshinoya);
                Image imgscaleHoshinoya = imgIconjapanHoshinoya.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconHoshinoya = new ImageIcon(imgscaleHoshinoya);
                btnImgjapanHoshinoya = new JButton(imgnewiconHoshinoya);
                btnImgjapanHoshinoya.setBounds(325, 10, 250, 300);
                btnImgjapanHoshinoya.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePaneljapan.add(btnImgjapanHoshinoya);
                
                
                
                //Labels for the information of the hotel
                //Aman
                lblHotelName = new JLabel("Aman");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(630, 300, 320, 70);
                framePaneljapan.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 1 Okitayama Washimine");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(630, 320, 310, 70);
                framePaneljapan.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("cho, Kyoto 603-8458, Japan");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(630, 340, 320, 70);
                framePaneljapan.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: KYT003");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(630, 360, 320, 70);
                framePaneljapan.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(630, 380, 320, 70);
                framePaneljapan.add(lblHotelRate);
                
                       
                //Image rating for Aman
                try {
                    imgamanRating= new URL("https://i.pinimg.com/736x/83/ba/60/83ba60cbe75a12d50435de0a3bdc5343.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgamanRating);
                Image imgscaleamanRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleamanRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(690, 380, 200, 90);
                framePaneljapan.add(lblRating);
                
                
                //Image button for Aman
                try {
                    imgjapanAman = new URL("https://i.pinimg.com/564x/35/30/fd/3530fd4d4dd2937dbb7168e90e102735.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconjapanAman = new ImageIcon(imgjapanAman);
                Image imgscaleAman = imgIconjapanAman.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconAman = new ImageIcon(imgscaleAman);
                btnImgjapanAman = new JButton(imgnewiconAman);
                btnImgjapanAman.setBounds(630, 10, 250, 300);
                btnImgjapanAman.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePaneljapan.add(btnImgjapanAman);
                
                
                
               

                //Show the specific panel for location
                } else if 
                (place.equalsIgnoreCase("italy")) {
                layer.removeAll();                
                jtfSearch.setText(" ");
                
                //Panel for the location for Italy
                framePanelitaly = new JPanel();
                framePanelitaly.setBounds(40, 120, 900, 450);
                framePanelitaly.setBackground(new Color(37, 113, 128));
                framePanelitaly.setLayout(null);
                layer.add(framePanelitaly, Integer.valueOf(0));
                
                
                //Labels for the information of the hotel
                //Russie
                lblHotelName = new JLabel("Hotel de Russie");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(20, 300, 320, 70);
                framePanelitaly.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: Via del Babuino, 9,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(20, 320, 310, 70);
                framePanelitaly.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("00187 Rome, Italy");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(20, 340, 320, 70);
                framePanelitaly.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: ROM001");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(20, 360, 320, 70);
                framePanelitaly.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(20, 380, 320, 70);
                framePanelitaly.add(lblHotelRate);
                
                         
                //Image rating for Russie
                try {
                    imgrussieRating= new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgrussieRating);
                Image imgscalerussieRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalerussieRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(85, 380, 200, 90);
                framePanelitaly.add(lblRating);
               
                
                //Image button for Russie
                try {
                    imgitalyRussie = new URL("https://i.pinimg.com/564x/0b/19/4e/0b194e2cde11b26b5a45e9c6f2b81b41.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconitalyRussie = new ImageIcon(imgitalyRussie);
                Image imgscaleRussie = imgIconitalyRussie.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconRussie = new ImageIcon(imgscaleRussie);
                btnImgitalyRussie = new JButton(imgnewiconRussie);
                btnImgitalyRussie.setBounds(20, 10, 250, 300);
                btnImgitalyRussie.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelitaly.add(btnImgitalyRussie);
                
                
                
                //Labels for the information of the hotel
                //Eden
                lblHotelName = new JLabel("Hotel Eden");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(325, 300, 320, 70);
                framePanelitaly.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: Via Ludovisi, 49,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(325, 320, 310, 70);
                framePanelitaly.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("00187 Rome, Italy");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(325, 340, 320, 70);
                framePanelitaly.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: ROM002");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(325, 360, 320, 70);
                framePanelitaly.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(325, 380, 320, 70);
                framePanelitaly.add(lblHotelRate);
                
               
                //Image rating for Eden
                try {
                    imgedenRating= new URL("https://i.pinimg.com/736x/83/ba/60/83ba60cbe75a12d50435de0a3bdc5343.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgedenRating);
                Image imgscaleedenRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleedenRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(390, 380, 200, 90);
                framePanelitaly.add(lblRating);
                
                
                //Image button for Eden
                try {
                    imgitalyEden = new URL("https://i.pinimg.com/564x/90/7e/67/907e677810403b732d41e3085e60655c.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconitalyEden = new ImageIcon(imgitalyEden);
                Image imgscaleEden = imgIconitalyEden.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconEden = new ImageIcon(imgscaleEden);
                btnImgitalyEden = new JButton(imgnewiconEden);
                btnImgitalyEden.setBounds(325, 10, 250, 300);
                btnImgitalyEden.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelitaly.add(btnImgitalyEden);
                
                
                //Labels for the information of the hotel
                //Regis
                lblHotelName = new JLabel("The St. Regis");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(630, 300, 320, 70);
                framePanelitaly.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: Via Vittorio E. Orlando, 3,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(630, 320, 310, 70);
                framePanelitaly.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("00185 Rome, Italy");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(630, 340, 320, 70);
                framePanelitaly.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: ROM003");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(630, 360, 320, 70);
                framePanelitaly.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(630, 380, 320, 70);
                framePanelitaly.add(lblHotelRate);
                
                         
                //Image rating for Regis
                try {
                    imgregisrating= new URL("https://i.pinimg.com/736x/83/ba/60/83ba60cbe75a12d50435de0a3bdc5343.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgregisrating);
                Image imgscaleregisRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleregisRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(690, 380, 200, 90);
                framePanelitaly.add(lblRating);
                
                
                //Image button for Regis
                try {
                    imgitalyRegis = new URL("https://i.pinimg.com/564x/d3/18/c6/d318c6832fa04864bd5a508653a0a45f.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconitalyRegis = new ImageIcon(imgitalyRegis);
                Image imgscaleRegis = imgIconitalyRegis.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconRegis = new ImageIcon(imgscaleRegis);
                btnImgitalyRegis = new JButton(imgnewiconRegis);
                btnImgitalyRegis.setBounds(630, 10, 250, 300);
                btnImgitalyRegis.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelitaly.add(btnImgitalyRegis);
                
                
                

                
                //Show the specific panel for location
                } else if 
                (place.equalsIgnoreCase("south korea")) {
                layer.removeAll();                
                jtfSearch.setText(" ");
                
                //Panel for the location for South Korea
                framePanelsouthkorea = new JPanel();
                framePanelsouthkorea.setBounds(40, 120, 900, 450);
                framePanelsouthkorea.setBackground(new Color(37, 113, 128));
                framePanelsouthkorea.setLayout(null);
                layer.add(framePanelsouthkorea, Integer.valueOf(0));
                
 
                //Labels for the information of the hotel
                //Four Season
                lblHotelName = new JLabel("Four Seasons Hotel");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(20, 300, 320, 70);
                framePanelsouthkorea.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 97 Saemunan-ro,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(20, 320, 310, 70);
                framePanelsouthkorea.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Seoul 03183, South Korea");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(20, 340, 320, 70);
                framePanelsouthkorea.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: SEO001");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(20, 360, 320, 70);
                framePanelsouthkorea.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(20, 380, 320, 70);
                framePanelsouthkorea.add(lblHotelRate);

                           
                //Image rating for FS
                try {
                    imgFSRating = new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgFSRating);
                Image imgscaleFSRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleFSRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(85, 380, 200, 90);
                framePanelsouthkorea.add(lblRating);
                
                    
                //Image button for FS
                try {
                    imgsouthkoreaFS = new URL("https://i.pinimg.com/564x/4e/f6/35/4ef635e10558669a0dc203e9f7b7e36b.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconsouthkoreaFS = new ImageIcon(imgsouthkoreaFS);
                Image imgscaleFS = imgIconsouthkoreaFS.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconFS = new ImageIcon(imgscaleFS);
                btnImgsouthkoreaFS = new JButton(imgnewiconFS);
                btnImgsouthkoreaFS.setBounds(20, 10, 250, 300);
                btnImgsouthkoreaFS.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelsouthkorea.add(btnImgsouthkoreaFS);
                
                
               
                //Labels for the information of the hotel
                //Shilla
                lblHotelName = new JLabel("The Shilla");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(325, 300, 320, 70);
                framePanelsouthkorea.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 249 Dongho-ro,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(325, 320, 310, 70);
                framePanelsouthkorea.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Seoul 04605, South Korea");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(325, 340, 320, 70);
                framePanelsouthkorea.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: SEO002");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(325, 360, 320, 70);
                framePanelsouthkorea.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(325, 380, 320, 70);
                framePanelsouthkorea.add(lblHotelRate);
                
                      
                //Image rating for Shilla
                try {
                    imgshillaRating = new URL("https://i.pinimg.com/736x/a3/ba/8f/a3ba8f74180b78219801a365d688acf6.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgshillaRating);
                Image imgscaleshillaRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscaleshillaRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(390, 380, 200, 90);
                framePanelsouthkorea.add(lblRating);
                
                
                //Image button for Shilla
                try {
                    imgsouthkoreaShilla = new URL("https://i.pinimg.com/564x/96/99/5c/96995c838d0824d8fa0309bbb91be95a.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconsouthkoreaShilla = new ImageIcon(imgsouthkoreaShilla);
                Image imgscaleShilla = imgIconsouthkoreaShilla.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconShilla = new ImageIcon(imgscaleShilla);
                btnImgsouthkoreaShilla = new JButton(imgnewiconShilla);
                btnImgsouthkoreaShilla.setBounds(325, 10, 250, 300);
                btnImgsouthkoreaShilla.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelsouthkorea.add(btnImgsouthkoreaShilla);
                
                
                
                //Labels for the information of the hotel
                //Signiel
                lblHotelName = new JLabel("Signiel");
                lblHotelName.setFont(fontHotelName);
                lblHotelName.setForeground(Color.BLACK);
                lblHotelName.setBounds(630, 300, 320, 70);
                framePanelsouthkorea.add(lblHotelName);
                
                lblHotelLocation = new JLabel("LOCATION: 300 Olympic-ro,");
                lblHotelLocation.setFont(hotelFont);
                lblHotelLocation.setForeground(Color.WHITE);
                lblHotelLocation.setBounds(630, 320, 310, 70);
                framePanelsouthkorea.add(lblHotelLocation);
                
                lblHotelLocExt = new JLabel("Seoul 05551, South Korea");
                lblHotelLocExt.setFont(hotelFont);
                lblHotelLocExt.setForeground(Color.WHITE);
                lblHotelLocExt.setBounds(630, 340, 320, 70);
                framePanelsouthkorea.add(lblHotelLocExt);
                
                lblHotelID = new JLabel("HOTELID: SEO003");
                lblHotelID.setFont(hotelFont);
                lblHotelID.setForeground(Color.WHITE);
                lblHotelID.setBounds(630, 360, 320, 70);
                framePanelsouthkorea.add(lblHotelID);
               
                lblHotelRate = new JLabel("RATING:");
                lblHotelRate.setFont(hotelFont);
                lblHotelRate.setForeground(Color.WHITE);
                lblHotelRate.setBounds(630, 380, 320, 70);
                framePanelsouthkorea.add(lblHotelRate);
                
                    
                //Image rating for Signiel
                try {
                    imgsignielRating = new URL("https://i.pinimg.com/736x/83/ba/60/83ba60cbe75a12d50435de0a3bdc5343.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconRating = new ImageIcon(imgsignielRating);
                Image imgscalesignielRating = imgIconRating.getImage().getScaledInstance(200, 90, Image.SCALE_SMOOTH);
                imgnewiconRating = new ImageIcon(imgscalesignielRating);
                lblRating = new JLabel(imgnewiconRating);
                lblRating.setBounds(690, 380, 200, 90);
                framePanelsouthkorea.add(lblRating);
                
               
                //Image button for Signiel
         
        try {
                    imgsouthkoreaSigniel = new URL("https://i.pinimg.com/564x/31/14/10/311410d559a2c055ca2c3b983c647acf.jpg");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                }

                imgIconsouthkoreaSigniel = new ImageIcon(imgsouthkoreaSigniel);
                Image imgscaleSigniel = imgIconsouthkoreaSigniel.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconSigniel = new ImageIcon(imgscaleSigniel);
                btnImgsouthkoreaSigniel = new JButton(imgnewiconSigniel);
                btnImgsouthkoreaSigniel.setBounds(630, 10, 250, 300);
                btnImgsouthkoreaSigniel.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
                new BookingFormTwo(firstName,lastName,userID,phoneNumber);
                }
                  }); 
                framePanelsouthkorea.add(btnImgsouthkoreaSigniel);  
                }
            
                //JOption if the search bar delivered is empty 
    else {
                JOptionPane.showMessageDialog(this, "Please Enter Your Destination First", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                   
            }             
            }         
        }
    }
