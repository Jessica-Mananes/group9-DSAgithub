/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HotelPackage;

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

public class Hotel extends JFrame implements ActionListener {

    private JLabel lblSearch, lblHotelID, lblHotelLocation, lblHotelLocExt, lblHotelName, lblparkRating, lblHotelRate, lblRating;
    private JTextField jtfSearch;
    private JButton btnSearch, btnImgeparisParkhyatt, btnImgparisshangri, btnImgparisQT, btnImgenewyorkPlaza, btnImgenewyorkPeninsula, btnImgenewyorkHighline,
            btnImgeafricaCapetown, btnImgeafricaSilo,btnImgeafricaBelmond,btnImgehawaiiFourseasons, btnImgehawaiiAndaz,btnImgehawaiiRitz,
            btnImgespainArts,btnImgespainMandarin, btnImgespainPalace;
    private Font font = new Font("Garet", Font.BOLD, 25),
            hotelFont = new Font("Garet", Font.BOLD, 15),
            fontHotelName = new Font("Arial", Font.BOLD, 20);

    private URL imgparisParkhyatt, imgparisShangri, imgparisQT,imgnewyorkPlaza,imgnewyorkPeninsula,imgnewyorkHighline,imgafricaCapetown,imgafricaSilo,imgafricaBelmond,
            imghawaiiFourseasons, imghawaiiAndaz, imghawaiiRitz, imgspainArts, imgspainMandarin, imgspainPalace,imgparkRating, imgshangriRating, imgplazaRating,
            imgpeninsulaRating, imghighlineRating, imgcapetownRating, imgsiloRating, imgbelmondRating, imgfourseasonRating, imgfandazRating,imgfritzRating,
            imgartsRating, imgmandarinRating, imgpalaceRating = null;
    private JPanel framePanel, framePanelsydney,framePanelnewyork,framePanelAfrica,framePanelHawaii, framePanelSpain;
    private ImageIcon imgIconparisParkhyatt, imgnewiconParkhyatt, imgIconparisShangri, imgiconparisShangri, imgIconparisQT, imgiconparisQT, imgIconnewyorkPlaza, imgnewiconnewyorkPlaza, 
            imgIconnewyorkPeninsula, imgnewiconnewyorkPeninsula, imgIconnewyorkHighline, imgnewiconnewyorkHighline, imgIconafricaCapetown, imgnewiconafricaCapetown, imgIconafricaSilo, 
            imgnewiconafricaSilo, imgIconafricaBelmond, imgnewiconafricaBelmond, imgIconhawaiiFourseasons, imgnewiconhawaiiFourseasons, imgIconhawaiiAndaz, imgnewiconhawaiiAndaz, 
            imgIconhawaiiRitz, imgnewiconhawaiiRitz, imgIconspainArts, imgnewiconspainArts, imgIconspainMandarin, imgnewiconspainMandarin, imgIconspainPalace, imgnewiconspainPalace, 
            imgRating, imgIconRating, imgnewiconRating;
    private JLayeredPane layer;

    Hotel() {
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(37, 113, 128));
        setLocationRelativeTo(null);

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
                    JOptionPane.showMessageDialog(framePanelsydney, "ERROR");
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
                    JOptionPane.showMessageDialog(framePanelsydney, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgparisQT, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgenewyorkPlaza, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgenewyorkPeninsula, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgenewyorkHighline, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgeafricaCapetown, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgeafricaSilo, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgeafricaBelmond, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgehawaiiFourseasons, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgehawaiiAndaz, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgehawaiiRitz, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgespainArts, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgespainMandarin, "ERROR");
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
                    JOptionPane.showMessageDialog(btnImgespainPalace, "ERROR");
                }
                  });
                framePanelSpain.add(btnImgespainPalace);
                
                }        
            
                //JOption if the search bar delivered is empty 
    else {
                JOptionPane.showMessageDialog(this, "Please Enter Your Destination First", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                   
            }             
            }         
        }
    }
