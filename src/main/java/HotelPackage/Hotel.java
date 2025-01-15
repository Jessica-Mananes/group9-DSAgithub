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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.*;

public class Hotel extends JFrame implements ActionListener {

    private JLabel lblNote, lblSearch, lblHotelIDOne, lblHotelIDTwo, lblHotelIDThree, lblHotelIDFour, lblHotelIDFive, lblHotelIDSix, lblHotelIDSeven, lblHotelIDEight, lblHotelIDNine,lblHotelIDTen,
            lblHotelIDEleven,lblHotelIDTwelve,lblHotelIDThirteen,lblHotelIDFourteen,lblHotelIDFifteen,lblHotelIDExtSixteen,lblHotelIDSeventeen,lblHotelIDEighteen,lblHotelIDNineteen,lblHotelIDTwenty,
            lblHotelIDTwentyone,lblHotelIDTwentytwo,lblHotelIDTwentythree,lblHotelIDTwentyfour,lblHotelIDTwentyfive,lblHotelIDTwentysix,lblHotelIDTwentyseven,lblHotelIDTwentyeight,lblHotelIDTwentynine,
            lblHotelIDThirty,lblHotelIDExtOne, lblHotelIDExtTwo, lblHotelIDExtThree, lblHotelIDExtFour, lblHotelIDExtFive, lblHotelIDExtSix, lblHotelIDExtSeven, lblHotelIDExtEight, lblHotelIDExtNine,
            lblHotelIDExtTen,lblHotelIDExtEleven,lblHotelIDExtTwelve,lblHotelIDExtThirteen,lblHotelIDExtFourteen,lblHotelIDExtFifteen,lblHotelIDExtSeventeen,lblHotelIDExtEighteen,lblHotelIDExtNineteen,
            lblHotelIDExtTwenty,lblHotelIDExtTwentyone,lblHotelIDExtTwentytwo,lblHotelIDExtTwentythree,lblHotelIDExtTwentyfour,lblHotelIDExtTwentyfive,lblHotelIDExtTwentysix,lblHotelIDExtTwentyseven,
            lblHotelIDExtTwentyeight,lblHotelIDExtTwentynine,lblHotelLocationOne, lblHotelLocationTwo, lblHotelLocationThree, lblHotelLocationFour, lblHotelLocationFive, lblHotelLocationSix, lblHotelLocationSeven, 
            lblHotelLocationEight, lblHotelLocationNine,lblHotelLocationTen, lblHotelLocationEleven,lblHotelLocationTwelve,lblHotelLocationThirteen,lblHotelLocationFourteen,lblHotelLocationFifteen,lblHotelLocationSixteen,
            lblHotelLocationSeventeen,lblHotelLocationEighteen,lblHotelLocationNineteen,lblHotelLocationTwenty,lblHotelLocationTwentyone,lblHotelLocationTwentytwo,lblHotelLocationTwentythree,lblHotelLocationTwentyfour,
            lblHotelLocationTwentyfive,lblHotelLocationTwentysix,lblHotelLocationTwentyseven,lblHotelLocationTwentyeight,lblHotelLocationTwentynine,lblHotelLocationThirty,lblHotelLocExtOne, lblHotelLocExtTwo, 
            lblHotelLocExtThree, lblHotelLocExtFour, lblHotelLocExtFive, lblHotelLocExtSix, lblHotelLocExtSeven, lblHotelLocExtEight, lblHotelLocExtNine,lblHotelLocExtTen,lblHotelLocExtEleven,lblHotelLocExtTwelve,
            lblHotelLocExtThirteen,lblHotelLocExtFourteen,lblHotelLocExtFifteen,lblHotelLocExtSixteen,lblHotelIDSixteen,lblHotelLocExtSeventeen,lblHotelLocExtEighteen,lblHotelLocExtNineteen,lblHotelLocExtTwenty,
            lblHotelLocExtTwentyone,lblHotelLocExtTwentytwo,lblHotelLocExtTwentythree,lblHotelLocExtTwentyfour,lblHotelLocExtTwentyfive,lblHotelLocExtTwentysix,lblHotelLocExtTwentyseven,lblHotelLocExtTwentyeight,
            lblHotelLocExtTwentynine,lblHotelLocExtThirty,lblHotelNameOne, lblHotelNameTwo, lblHotelNameThree, lblHotelNameFour, lblHotelNameFive,lblHotelNameSix, lblHotelNameSeven,lblHotelNameEight, lblHotelNameNine,
            lblHotelNameTen, lblHotelNameEleven,lblHotelNameTwelve,lblHotelNameThirteen,lblHotelNameFourteen,lblHotelNameFifteen,lblHotelNameSixteen,lblHotelNameSeventeen,lblHotelNameEighteen,lblHotelNameNineteen,
            lblHotelNameTwenty,lblHotelNameTwentyone,lblHotelNameTwentytwo,lblHotelNameTwentythree,lblHotelNameTwentyfour,lblHotelNameTwentyfive,lblHotelNameTwentysix,lblHotelNameTwentyseven,lblHotelNameTwentyeight,
            lblHotelNameTwentynine,lblHotelNameThirty,lblHotelRateOne, lblHotelRateTwo, lblHotelRateThree, lblHotelRateFour, lblHotelRateFive, lblHotelRateSix, lblHotelRateSeven, lblHotelRateEight, lblHotelRateNine,lblHotelRateTen,
            lblHotelRateEleven,lblHotelRateTwelve,lblHotelRateThirteen,lblHotelRateFourteen,lblHotelRateFifteen,lblHotelRateSixteen,lblHotelRateSeventeen,lblHotelRateEighteen,lblHotelRateNineteen,lblHotelRateTwenty,lblHotelRateTwentyone,
            lblHotelRateTwentytwo,lblHotelRateTwentythree,lblHotelRateTwentyfour,lblHotelRateTwentyfive,lblHotelRateTwentysix,lblHotelRateTwentyseven,lblHotelRateTwentyeight,lblHotelRateTwentynine,lblHotelIDExtThirty,lblHotelRateThirty,
            lblHotelRateExtOne, lblHotelRateExtTwo, lblHotelRateExtThree, lblHotelRateExtFour, lblHotelRateExtFive, lblHotelRateExtSix, lblHotelRateExtSeven, lblHotelRateExtEight, lblHotelRateExtNine,lblHotelRateExtTen,lblHotelRateExtEleven, 
            lblHotelRateExtTwelve,lblHotelRateExtThirteen,lblHotelRateExtFourteen, lblHotelRateExtFifteen,lblHotelRateExtSixteen,lblHotelRateExtSeventeen,lblHotelRateExtEighteen,lblHotelRateExtNineteen,lblHotelRateExtTwenty,lblHotelRateExtTwentyone,
            lblHotelRateExtTwentytwo,lblHotelRateExtTwentythree,lblHotelRateExtTwentyfour,lblHotelRateExtTwentyfive,lblHotelRateExtTwentysix,lblHotelRateExtTwentyseven,lblHotelRateExtTwentyeight,lblHotelRateExtTwentynine,lblHotelRateExtThirty; 
    private JTextField jtfSearch;
    private JButton btnSearch,btnRefresh, btnImgeparisParkhyatt, btnImgparisshangri, btnImgparisQT, btnImgenewyorkPlaza, btnImgenewyorkPeninsula, btnImgenewyorkHighline,
            btnImgeafricaCapetown, btnImgeafricaSilo,btnImgeafricaBelmond,btnImgehawaiiFourseasons, btnImgehawaiiAndaz,btnImgehawaiiRitz,
            btnImgespainArts,btnImgespainMandarin, btnImgespainPalace, btnImgthailandMandarin, btnImgthailandSiam, btnImgthailandPeninsula, btnImgfranceRitz, btnImgfranceLemeurice, 
            btnImgfranceShangrila, btnImgjapanCarlton, btnImgjapanHoshinoya, btnImgjapanAman, btnImgitalyRussie, btnImgitalyEden, btnImgitalyRegis, btnImgsouthkoreaFS, 
            btnImgsouthkoreaShilla, btnImgsouthkoreaSigniel, btnPrint;
    private Font font = new Font("Garet", Font.BOLD, 25),
            fontNote = new Font("Garet", Font.PLAIN, 10),
            hotelFont = new Font("Garet", Font.BOLD, 15),
            fontHotelName = new Font("Arial", Font.BOLD, 20);

    private JPanel framePanelsydney,framePanelnewyork,framePanelAfrica,framePanelHawaii, framePanelSpain, framePanelthailand, framePanelfrance, framePaneljapan, framePanelitaly,
            framePanelsouthkorea;
    private ImageIcon imgIconparisParkhyatt, imgnewiconParkhyatt, imgIconparisShangri, imgiconparisShangri, imgIconparisQT, imgiconparisQT, imgIconnewyorkPlaza, imgnewiconnewyorkPlaza, 
            imgIconnewyorkPeninsula, imgnewiconnewyorkPeninsula, imgIconnewyorkHighline, imgnewiconnewyorkHighline, imgIconafricaCapetown, imgnewiconafricaCapetown, imgIconafricaSilo, 
            imgnewiconafricaSilo, imgIconafricaBelmond, imgnewiconafricaBelmond, imgIconhawaiiFourseasons, imgnewiconhawaiiFourseasons, imgIconhawaiiAndaz, imgnewiconhawaiiAndaz, 
            imgIconhawaiiRitz, imgnewiconhawaiiRitz, imgIconspainArts, imgnewiconspainArts, imgIconspainMandarin, imgnewiconspainMandarin, imgIconspainPalace, imgnewiconspainPalace, 
            imgIconthailandMandarin, imgnewiconMandarin, imgIconthailandSiam, imgnewiconSiam, imgIconthailandPeninsula, imgnewiconPeninsula,imgIconthailandRitz, imgnewiconRitz,
            imgIconfranceLemeurice, imgnewiconLemeurice, imgIconfranceShangrila, imgnewiconShangrila, imgIconjapanCarlton, imgnewiconCarlton,imgIconjapanHoshinoya, imgnewiconHoshinoya,
            imgIconjapanAman, imgnewiconAman, imgIconitalyRussie, imgnewiconRussie,imgIconitalyEden, imgnewiconEden, imgIconitalyRegis,imgnewiconRegis,imgIconsouthkoreaFS, imgnewiconFS, 
            imgIconsouthkoreaShilla, imgnewiconShilla, imgIconsouthkoreaSigniel, imgnewiconSigniel;
    private JLayeredPane layer;

    Hotel() {
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(37, 113, 128));
        setResizable(false);
        setLocationRelativeTo(null);

        //allows the componets to don't overlap in on every panel
        layer = new JLayeredPane();
        layer.setBounds(0, 0, 1000, 600);
        add(layer);  

        //search bar 
        jtfSearch = new JTextField();
        jtfSearch.setForeground(new Color(0,0,0));
        jtfSearch.setBackground(new Color(180,204,224));
        jtfSearch.setBounds(230, 40, 415, 50);
        add(jtfSearch);

        lblSearch = new JLabel("Search:");
        lblSearch.setFont(font);
        lblSearch.setForeground(new Color(0,0,0));
        lblSearch.setBounds(115, 40, 350, 50);
        add(lblSearch);
        
        //note for search button
        lblNote = new JLabel("Note: Please search for specific country you want to stay.");
        lblNote.setFont(fontNote);
        lblNote.setForeground(Color.WHITE);
        lblNote.setBounds(230, 90, 350, 15);
        add(lblNote);

        //search button 
        btnSearch = new JButton("⌕");
        btnSearch.setFont(font);
        btnSearch.setForeground(new Color(0,0,0));
        btnSearch.setBackground(new Color(180,204,224));
        btnSearch.setBounds(690, 40, 60, 50);
        add(btnSearch);
        
        //refresh btn
        btnRefresh = new JButton("⟳");
        btnRefresh.setFont(font);
        btnRefresh.setForeground(new Color(0,0,0));
        btnRefresh.setBackground(new Color(180,204,224));
        btnRefresh.setBounds(770, 40, 60, 50);
        add(btnRefresh);
        
        btnSearch.addActionListener(this);
        btnRefresh.addActionListener(this);

        
        setVisible(true);
    }
    
        PreparedStatement pst;
        Connection con;
        ResultSet rs;

    @Override
    public void actionPerformed(ActionEvent e) {   
        
        Connect();
        if (e.getSource() == btnRefresh) {
                layer.removeAll();
                layer.repaint();
                jtfSearch.setText(" ");
        }
        
            //show the specific panel per location
        String place = jtfSearch.getText().trim();
        if (e.getSource() == btnSearch) {
            if (place.equalsIgnoreCase("sydney")) {
                layer.removeAll(); 
                
                //Panel for the location Sydney
                framePanelsydney = new JPanel();
                framePanelsydney.setBounds(40, 120, 900,450 );
                framePanelsydney.setBackground(new Color(37, 113, 128));
                framePanelsydney.setLayout(null);
                layer.add(framePanelsydney, Integer.valueOf(0)); 
                
                // Labels for information of the hotel
                // Park Hyatt
                
                lblHotelNameOne = new JLabel("Park Hyatt Hotel, Sydney");
                lblHotelNameOne.setFont(fontHotelName);
                lblHotelNameOne.setForeground(Color.BLACK);
                lblHotelNameOne.setBounds(20, 300, 320, 70);
                framePanelsydney.add(lblHotelNameOne);
                
                lblHotelLocationOne = new JLabel("LOCATION:");
                lblHotelLocationOne.setFont(hotelFont);
                lblHotelLocationOne.setForeground(Color.WHITE);
                lblHotelLocationOne.setBounds(20, 320, 310, 70);
                framePanelsydney.add(lblHotelLocationOne);
                
                lblHotelLocExtOne = new JLabel("7 Hickson Road,Sydney Australia");
                lblHotelLocExtOne.setFont(hotelFont);
                lblHotelLocExtOne.setForeground(Color.WHITE);
                lblHotelLocExtOne.setBounds(20, 340, 320, 70);
                framePanelsydney.add(lblHotelLocExtOne);
                
                lblHotelIDOne = new JLabel("HOTELID: ");
                lblHotelIDOne.setFont(hotelFont);
                lblHotelIDOne.setForeground(Color.WHITE);
                lblHotelIDOne.setBounds(20, 360, 320, 70);
                framePanelsydney.add(lblHotelIDOne);   
               
                lblHotelIDExtOne = new JLabel(" SPH001");
                lblHotelIDExtOne.setFont(hotelFont);
                lblHotelIDExtOne.setForeground(Color.WHITE);
                lblHotelIDExtOne.setBounds(90, 360, 320, 70);
                framePanelsydney.add(lblHotelIDExtOne);
                
                lblHotelRateOne = new JLabel("RATING:");
                lblHotelRateOne.setFont(hotelFont);
                lblHotelRateOne.setForeground(Color.WHITE);
                lblHotelRateOne.setBounds(20, 380, 320, 70);
                framePanelsydney.add(lblHotelRateOne);
                
                lblHotelRateExtOne = new JLabel("5/5");
                lblHotelRateExtOne.setFont(hotelFont);
                lblHotelRateExtOne.setForeground(Color.WHITE);
                lblHotelRateExtOne.setBounds(90, 380, 320, 70);
                framePanelsydney.add(lblHotelRateExtOne);
                               
                //Image button for park hyatt
            
                imgIconparisParkhyatt = new ImageIcon("parkhyattSydney.jpg");
                Image imgscaleParkhyatt = imgIconparisParkhyatt.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconParkhyatt = new ImageIcon(imgscaleParkhyatt);
                btnImgeparisParkhyatt = new JButton(imgnewiconParkhyatt);
                btnImgeparisParkhyatt.setBounds(20, 10, 250, 300);
                 
                btnImgeparisParkhyatt.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                                        
                    
        //JOtionPane (user's preference)
        int btnImgeparisParkhyatt = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgeparisParkhyatt == JOptionPane.YES_OPTION) {
            dispose();
            
            
                                //new BookingFormTwo();

     
                        //getText                             
                        String name=lblHotelNameOne.getText();
                        String location=lblHotelLocExtOne.getText();
                        String hotelid=lblHotelIDExtOne.getText();
                        String rate=lblHotelRateExtOne.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                       
                        }catch (Exception a){
                        a.printStackTrace();
                    } 
                        
                   }    
                }
                  });                
                framePanelsydney.add(btnImgeparisParkhyatt);
                
                
                // Labels for information of the hotel
                    // Shangri
              
                lblHotelNameTwo = new JLabel("Shangri-La Hotel, Sydney");
                lblHotelNameTwo.setFont(fontHotelName);
                lblHotelNameTwo.setForeground(Color.BLACK);
                lblHotelNameTwo.setBounds(325, 300, 320, 70);
                framePanelsydney.add(lblHotelNameTwo);
                
                lblHotelLocationTwo = new JLabel("LOCATION: ");
                lblHotelLocationTwo.setFont(hotelFont);
                lblHotelLocationTwo.setForeground(Color.WHITE);
                lblHotelLocationTwo.setBounds(325, 320, 310, 70);
                framePanelsydney.add(lblHotelLocationTwo);
                
                lblHotelLocExtTwo = new JLabel("176 Cumberland St, Australia");
                lblHotelLocExtTwo.setFont(hotelFont);
                lblHotelLocExtTwo.setForeground(Color.WHITE);
                lblHotelLocExtTwo.setBounds(325, 340, 320, 70);
                framePanelsydney.add(lblHotelLocExtTwo);
                
                lblHotelIDTwo = new JLabel("HOTELID:");
                lblHotelIDTwo.setFont(hotelFont);
                lblHotelIDTwo.setForeground(Color.WHITE);
                lblHotelIDTwo.setBounds(325, 360, 320, 70);
                framePanelsydney.add(lblHotelIDTwo); 
                
                lblHotelIDExtTwo = new JLabel(" SSH002");
                lblHotelIDExtTwo.setFont(hotelFont);
                lblHotelIDExtTwo.setForeground(Color.WHITE);
                lblHotelIDExtTwo.setBounds(395, 360, 320, 70);
                framePanelsydney.add(lblHotelIDExtTwo);
                
                lblHotelRateTwo = new JLabel("RATING:");
                lblHotelRateTwo.setFont(hotelFont);
                lblHotelRateTwo.setForeground(Color.WHITE);
                lblHotelRateTwo.setBounds(325, 380, 320, 70);
                framePanelsydney.add(lblHotelRateTwo);
                 
                lblHotelRateExtTwo = new JLabel("5/5");
                lblHotelRateExtTwo.setFont(hotelFont);
                lblHotelRateExtTwo.setForeground(Color.WHITE);
                lblHotelRateExtTwo.setBounds(395, 380, 320, 70);
                framePanelsydney.add(lblHotelRateExtTwo);
                
                
                //Image for every button on the panel
 
                imgIconparisShangri = new ImageIcon("shangrilaSydney.jpg");
                Image imgscaleparisShangri = imgIconparisShangri.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgiconparisShangri = new ImageIcon(imgscaleparisShangri);
                btnImgparisshangri = new JButton(imgiconparisShangri);
                btnImgparisshangri.setBounds(325, 10, 250, 300);
                
               
                btnImgparisshangri.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                                       
       
        //JOtionPane (user's preference)
        int btnImgparisshangri = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgparisshangri == JOptionPane.YES_OPTION) {
            dispose();
                    
                          //new BookingFormTwo();

             
                    //getText                             
                        String name=lblHotelNameTwo.getText();
                        String location=lblHotelLocExtTwo.getText();
                        String hotelid=lblHotelIDExtTwo.getText();
                        String rate=lblHotelRateExtTwo.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }                              
                  }
                }
                  });
                framePanelsydney.add(btnImgparisshangri);
                
                
                    // Labels for information of the hotel
                        // QT
                
                lblHotelNameThree = new JLabel("QT Hotel, Sydney");
                lblHotelNameThree.setFont(fontHotelName);
                lblHotelNameThree.setForeground(Color.BLACK);
                lblHotelNameThree.setBounds(630, 300, 320, 70);
                framePanelsydney.add(lblHotelNameThree);
                
                lblHotelLocationThree = new JLabel("LOCATION:");
                lblHotelLocationThree.setFont(hotelFont);
                lblHotelLocationThree.setForeground(Color.WHITE);
                lblHotelLocationThree.setBounds(630, 320, 310, 70);
                framePanelsydney.add(lblHotelLocationThree);
                
                lblHotelLocExtThree = new JLabel("49 Market St, Australia");
                lblHotelLocExtThree.setFont(hotelFont);
                lblHotelLocExtThree.setForeground(Color.WHITE);
                lblHotelLocExtThree.setBounds(630, 340, 320, 70);
                framePanelsydney.add(lblHotelLocExtThree);
                
                lblHotelIDThree = new JLabel("HOTELID:");
                lblHotelIDThree.setFont(hotelFont);
                lblHotelIDThree.setForeground(Color.WHITE);
                lblHotelIDThree.setBounds(630, 360, 320, 70);
                framePanelsydney.add(lblHotelIDThree);
               
                lblHotelIDExtThree = new JLabel(" SQH003");
                lblHotelIDExtThree.setFont(hotelFont);
                lblHotelIDExtThree.setForeground(Color.WHITE);
                lblHotelIDExtThree.setBounds(700, 360, 320, 70);
                framePanelsydney.add(lblHotelIDExtThree);
                
                lblHotelRateThree = new JLabel("RATING: ");
                lblHotelRateThree.setFont(hotelFont);
                lblHotelRateThree.setForeground(Color.WHITE);
                lblHotelRateThree.setBounds(630, 380, 320, 70);
                framePanelsydney.add(lblHotelRateThree);
                
                lblHotelRateExtThree = new JLabel("4.5/5");
                lblHotelRateExtThree.setFont(hotelFont);
                lblHotelRateExtThree.setForeground(Color.WHITE);
                lblHotelRateExtThree.setBounds(700, 380, 320, 70);
                framePanelsydney.add(lblHotelRateExtThree);
                
           
                //Image for every button on the panel

                imgIconparisQT = new ImageIcon("qtSydney.jpg");
                Image imgscaleparisQT = imgIconparisQT.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgiconparisQT = new ImageIcon(imgscaleparisQT);
                btnImgparisQT = new JButton(imgiconparisQT);
                btnImgparisQT.setBounds(630, 10, 250, 300);
                
                btnImgparisQT.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  
       
        //JOtionPane (user's preference)
        int btnImgparisQT = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgparisQT == JOptionPane.YES_OPTION) {
            dispose();
                    
                          //new BookingFormTwo();
                    
                    
                        //getText                             
                        String name=lblHotelNameThree.getText();
                        String location=lblHotelLocExtThree.getText();
                        String hotelid=lblHotelIDExtThree.getText();
                        String rate=lblHotelRateExtThree.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }               
                  }
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
                
                lblHotelNameFour = new JLabel("The Plaza Hotel, NY");
                lblHotelNameFour.setFont(fontHotelName);
                lblHotelNameFour.setForeground(Color.BLACK);
                lblHotelNameFour.setBounds(20, 300, 320, 70);
                framePanelnewyork.add(lblHotelNameFour);
                
                lblHotelLocationFour = new JLabel("LOCATION:");
                lblHotelLocationFour.setFont(hotelFont);
                lblHotelLocationFour.setForeground(Color.WHITE);
                lblHotelLocationFour.setBounds(20, 320, 310, 70);
                framePanelnewyork.add(lblHotelLocationFour);
                
                lblHotelLocExtFour = new JLabel("5th Avenue, C.P., NY, USA");
                lblHotelLocExtFour.setFont(hotelFont);
                lblHotelLocExtFour.setForeground(Color.WHITE);
                lblHotelLocExtFour.setBounds(20, 340, 320, 70);
                framePanelnewyork.add(lblHotelLocExtFour);
                
                lblHotelIDFour = new JLabel("HOTELID:");
                lblHotelIDFour.setFont(hotelFont);
                lblHotelIDFour.setForeground(Color.WHITE);
                lblHotelIDFour.setBounds(20, 360, 320, 70);
                framePanelnewyork.add(lblHotelIDFour);
                
                lblHotelIDExtFour = new JLabel(" NYH004");
                lblHotelIDExtFour.setFont(hotelFont);
                lblHotelIDExtFour.setForeground(Color.WHITE);
                lblHotelIDExtFour.setBounds(90, 360, 320, 70);
                framePanelnewyork.add(lblHotelIDExtFour);
               
                lblHotelRateFour = new JLabel("RATING:");
                lblHotelRateFour.setFont(hotelFont);
                lblHotelRateFour.setForeground(Color.WHITE);
                lblHotelRateFour.setBounds(20, 380, 320, 70);
                framePanelnewyork.add(lblHotelRateFour);
                
                lblHotelRateExtFour = new JLabel("5/5");
                lblHotelRateExtFour.setFont(hotelFont);
                lblHotelRateExtFour.setForeground(Color.WHITE);
                lblHotelRateExtFour.setBounds(90, 380, 320, 70);
                framePanelnewyork.add(lblHotelRateExtFour);
                
                
                //Image for every button on the panel
                
                imgIconnewyorkPlaza = new ImageIcon("plazaNY.jpg");
                Image imgscalenewyorkPlaza = imgIconnewyorkPlaza.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconnewyorkPlaza = new ImageIcon(imgscalenewyorkPlaza);
                btnImgenewyorkPlaza = new JButton(imgnewiconnewyorkPlaza);
                btnImgenewyorkPlaza.setBounds(20, 10, 250, 300);
                btnImgenewyorkPlaza.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
        
        //JOtionPane (user's preference)
        int btnImgenewyorkPlaza = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgenewyorkPlaza == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();
                                
                    
                    //getText                             
                        String name=lblHotelNameFour.getText();
                        String location=lblHotelLocExtFour.getText();
                        String hotelid=lblHotelIDExtFour.getText();
                        String rate=lblHotelRateExtFour.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }               
                }
                }
                  }); 
                framePanelnewyork.add(btnImgenewyorkPlaza);
                
                
                
                    // Labels for information of the hotel
                        // The Peninsula Hotel, New York
                
                lblHotelNameFive = new JLabel("The Peninsula Hotel, NY");
                lblHotelNameFive.setFont(fontHotelName);
                lblHotelNameFive.setForeground(Color.BLACK);
                lblHotelNameFive.setBounds(325, 300, 320, 70);
                framePanelnewyork.add(lblHotelNameFive);
                
                lblHotelLocationFive = new JLabel("LOCATION:");
                lblHotelLocationFive.setFont(hotelFont);
                lblHotelLocationFive.setForeground(Color.WHITE);
                lblHotelLocationFive.setBounds(325, 320, 310, 70);
                framePanelnewyork.add(lblHotelLocationFive);
                
                lblHotelLocExtFive = new JLabel("700 5th Avenue, NY, USA");
                lblHotelLocExtFive.setFont(hotelFont);
                lblHotelLocExtFive.setForeground(Color.WHITE);
                lblHotelLocExtFive.setBounds(325, 340, 320, 70);
                framePanelnewyork.add(lblHotelLocExtFive);
                
                lblHotelIDFive = new JLabel("HOTELID:");
                lblHotelIDFive.setFont(hotelFont);
                lblHotelIDFive.setForeground(Color.WHITE);
                lblHotelIDFive.setBounds(325, 360, 320, 70);
                framePanelnewyork.add(lblHotelIDFive);
                
                lblHotelIDExtFive = new JLabel(" NYH005");
                lblHotelIDExtFive.setFont(hotelFont);
                lblHotelIDExtFive.setForeground(Color.WHITE);
                lblHotelIDExtFive.setBounds(395, 360, 320, 70);
                framePanelnewyork.add(lblHotelIDExtFive);
               
                lblHotelRateFive = new JLabel("RATING:");
                lblHotelRateFive.setFont(hotelFont);
                lblHotelRateFive.setForeground(Color.WHITE);
                lblHotelRateFive.setBounds(325, 380, 320, 70);
                framePanelnewyork.add(lblHotelRateFive);
                
                lblHotelRateExtFive = new JLabel("5/5");
                lblHotelRateExtFive.setFont(hotelFont);
                lblHotelRateExtFive.setForeground(Color.WHITE);
                lblHotelRateExtFive.setBounds(395, 380, 320, 70);
                framePanelnewyork.add(lblHotelRateExtFive);
                
      
                //Image for every button on the panel
 
                imgIconnewyorkPeninsula = new ImageIcon("peninsulaNY.jpg");
                Image imgscalenewyorkPeninsula = imgIconnewyorkPeninsula.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconnewyorkPeninsula = new ImageIcon(imgscalenewyorkPeninsula);
                btnImgenewyorkPeninsula = new JButton(imgnewiconnewyorkPeninsula);
                btnImgenewyorkPeninsula.setBounds(325, 10, 250, 300);
                btnImgenewyorkPeninsula.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
        //JOtionPane (user's preference)
        int btnImgenewyorkPeninsula = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgenewyorkPeninsula == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();               
                                
                                
                    //getText                             
                        String name=lblHotelNameFive.getText();
                        String location=lblHotelLocExtFive.getText();
                        String hotelid=lblHotelIDExtFive.getText();
                        String rate=lblHotelRateExtFive.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }               
                 }
                }
                  }); 
                framePanelnewyork.add(btnImgenewyorkPeninsula);
                
                
                  // Labels for information of the hotel
                    // The High Line Hotel, New York
                
                lblHotelNameSix = new JLabel("The Standard High Line, NY");
                lblHotelNameSix.setFont(fontHotelName);
                lblHotelNameSix.setForeground(Color.BLACK);
                lblHotelNameSix.setBounds(630, 300, 320, 70);
                framePanelnewyork.add(lblHotelNameSix);
                
                lblHotelLocationSix = new JLabel("LOCATION:");
                lblHotelLocationSix.setFont(hotelFont);
                lblHotelLocationSix.setForeground(Color.WHITE);
                lblHotelLocationSix.setBounds(630, 320, 310, 70);
                framePanelnewyork.add(lblHotelLocationSix);
                
                lblHotelLocExtSix = new JLabel("848 Washington St, NY, USA");
                lblHotelLocExtSix.setFont(hotelFont);
                lblHotelLocExtSix.setForeground(Color.WHITE);
                lblHotelLocExtSix.setBounds(630, 340, 320, 70);
                framePanelnewyork.add(lblHotelLocExtSix);
                
                lblHotelIDSix = new JLabel("HOTELID:");
                lblHotelIDSix.setFont(hotelFont);
                lblHotelIDSix.setForeground(Color.WHITE);
                lblHotelIDSix.setBounds(630, 360, 320, 70);
                framePanelnewyork.add(lblHotelIDSix);
                
                lblHotelIDExtSix = new JLabel(" NYH006");
                lblHotelIDExtSix.setFont(hotelFont);
                lblHotelIDExtSix.setForeground(Color.WHITE);
                lblHotelIDExtSix.setBounds(700, 360, 320, 70);
                framePanelnewyork.add(lblHotelIDExtSix);
               
                lblHotelRateSix = new JLabel("RATING:");
                lblHotelRateSix.setFont(hotelFont);
                lblHotelRateSix.setForeground(Color.WHITE);
                lblHotelRateSix.setBounds(630, 380, 320, 70);
                framePanelnewyork.add(lblHotelRateSix);
                
                lblHotelRateExtSix = new JLabel("5/5");
                lblHotelRateExtSix.setFont(hotelFont);
                lblHotelRateExtSix.setForeground(Color.WHITE);
                lblHotelRateExtSix.setBounds(700, 380, 320, 70);
                framePanelnewyork.add(lblHotelRateExtSix);
     
                //Image for every button on the panel
                
                imgIconnewyorkHighline = new ImageIcon("highlineNY.jpg");
                Image imgscalenewyorkHighline = imgIconnewyorkHighline.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconnewyorkHighline = new ImageIcon(imgscalenewyorkHighline);
                btnImgenewyorkHighline = new JButton(imgnewiconnewyorkHighline);
                btnImgenewyorkHighline.setBounds(630, 10, 250, 300);
                btnImgenewyorkHighline.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  
                    //new BookingFormTwo();
                    
                    //getText                             
                        String name=lblHotelNameSix.getText();
                        String location=lblHotelLocExtSix.getText();
                        String hotelid=lblHotelIDExtSix.getText();
                        String rate=lblHotelRateExtSix.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }               
                   }
                  }); 
                framePanelnewyork.add(btnImgenewyorkHighline);
            }
    
                //show the specific panel per location
                    //South Africa
        
    else if 
                (place.equalsIgnoreCase("south africa")) {
                layer.removeAll();                

                //Panel for the location  South Africa
                framePanelAfrica = new JPanel();
                framePanelAfrica.setBounds(40, 120, 900, 450);
                framePanelAfrica.setBackground(new Color(37, 113, 128));
                framePanelAfrica.setLayout(null);
                layer.add(framePanelAfrica, Integer.valueOf(0));  
                
                
                // Labels for information of the hotel
                    // One&Only Cape Town Hotel
                
                lblHotelNameSeven = new JLabel("One&Only Cape Town Hotel");
                lblHotelNameSeven.setFont(fontHotelName);
                lblHotelNameSeven.setForeground(Color.BLACK);
                lblHotelNameSeven.setBounds(20, 300, 320, 70);
                framePanelAfrica.add(lblHotelNameSeven);
                
                lblHotelLocationSeven = new JLabel("LOCATION:");
                lblHotelLocationSeven.setFont(hotelFont);
                lblHotelLocationSeven.setForeground(Color.WHITE);
                lblHotelLocationSeven.setBounds(20, 320, 310, 70);
                framePanelAfrica.add(lblHotelLocationSeven);
                
                lblHotelLocExtSeven = new JLabel("Dock Rd, Cape Town, 8001, SA");
                lblHotelLocExtSeven.setFont(hotelFont);
                lblHotelLocExtSeven.setForeground(Color.WHITE);
                lblHotelLocExtSeven.setBounds(20, 340, 320, 70);
                framePanelAfrica.add(lblHotelLocExtSeven);
                
                lblHotelIDSeven = new JLabel("HOTELID:");
                lblHotelIDSeven.setFont(hotelFont);
                lblHotelIDSeven.setForeground(Color.WHITE);
                lblHotelIDSeven.setBounds(20, 360, 320, 70);
                framePanelAfrica.add(lblHotelIDSeven);
                
                lblHotelIDExtSeven = new JLabel(" ACH007");
                lblHotelIDExtSeven.setFont(hotelFont);
                lblHotelIDExtSeven.setForeground(Color.WHITE);
                lblHotelIDExtSeven.setBounds(90, 360, 320, 70);
                framePanelAfrica.add(lblHotelIDExtSeven);
               
                lblHotelRateSeven = new JLabel("RATING:");
                lblHotelRateSeven.setFont(hotelFont);
                lblHotelRateSeven.setForeground(Color.WHITE);
                lblHotelRateSeven.setBounds(20, 380, 320, 70);
                framePanelAfrica.add(lblHotelRateSeven);
                
                lblHotelRateExtSeven = new JLabel("5/5");
                lblHotelRateExtSeven.setFont(hotelFont);
                lblHotelRateExtSeven.setForeground(Color.WHITE);
                lblHotelRateExtSeven.setBounds(90, 380, 320, 70);
                framePanelAfrica.add(lblHotelRateExtSeven);

      
                //Image for every button on the panel

                imgIconafricaCapetown = new ImageIcon("capetownSA.jpg");
                Image imgscaleafricaCapetown = imgIconafricaCapetown.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconafricaCapetown = new ImageIcon(imgscaleafricaCapetown);
                btnImgeafricaCapetown = new JButton(imgnewiconafricaCapetown);
                btnImgeafricaCapetown.setBounds(20, 10, 250, 300);
                btnImgeafricaCapetown.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                 
        
        //JOtionPane (user's preference)
        int btnImgeafricaCapetown = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgeafricaCapetown == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();         
                                
                                
                    //getText                             
                        String name=lblHotelNameSeven.getText();
                        String location=lblHotelLocExtSeven.getText();
                        String hotelid=lblHotelIDExtSeven.getText();
                        String rate=lblHotelRateExtSeven.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }       
        }
                }
                  }); 
                framePanelAfrica.add(btnImgeafricaCapetown);
               
                
                 // Labels for information of the hotel
                    // Silo Hotel
                
                lblHotelNameEight = new JLabel("Silo Hotel");
                lblHotelNameEight.setFont(fontHotelName);
                lblHotelNameEight.setForeground(Color.BLACK);
                lblHotelNameEight.setBounds(325, 300, 320, 70);
                framePanelAfrica.add(lblHotelNameEight);
                
                lblHotelLocationEight = new JLabel("LOCATION:");
                lblHotelLocationEight.setFont(hotelFont);
                lblHotelLocationEight.setForeground(Color.WHITE);
                lblHotelLocationEight.setBounds(325, 320, 310, 70);
                framePanelAfrica.add(lblHotelLocationEight);
                
                lblHotelLocExtEight = new JLabel("Silo Square, Cape Town, 8001, SA");
                lblHotelLocExtEight.setFont(hotelFont);
                lblHotelLocExtEight.setForeground(Color.WHITE);
                lblHotelLocExtEight.setBounds(325, 340, 320, 70);
                framePanelAfrica.add(lblHotelLocExtEight);
                
                lblHotelIDEight = new JLabel("HOTELID:");
                lblHotelIDEight.setFont(hotelFont);
                lblHotelIDEight.setForeground(Color.WHITE);
                lblHotelIDEight.setBounds(325, 360, 320, 70);
                framePanelAfrica.add(lblHotelIDEight);
                
                lblHotelIDExtEight = new JLabel(" ASH008");
                lblHotelIDExtEight.setFont(hotelFont);
                lblHotelIDExtEight.setForeground(Color.WHITE);
                lblHotelIDExtEight.setBounds(395, 360, 320, 70);
                framePanelAfrica.add(lblHotelIDExtEight);
               
                lblHotelRateEight = new JLabel("RATING:");
                lblHotelRateEight.setFont(hotelFont);
                lblHotelRateEight.setForeground(Color.WHITE);
                lblHotelRateEight.setBounds(325, 380, 320, 70);
                framePanelAfrica.add(lblHotelRateEight);
                
                lblHotelRateExtEight = new JLabel("5/5");
                lblHotelRateExtEight.setFont(hotelFont);
                lblHotelRateExtEight.setForeground(Color.WHITE);
                lblHotelRateExtEight.setBounds(395, 380, 320, 70);
                framePanelAfrica.add(lblHotelRateExtEight);
                
     
                //Image for every button on the panel

                imgIconafricaSilo = new ImageIcon("siloSA.jpg");
                Image imgscaleafricaSilo = imgIconafricaSilo.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconafricaSilo = new ImageIcon(imgscaleafricaSilo);
                btnImgeafricaSilo = new JButton(imgnewiconafricaSilo);
                btnImgeafricaSilo.setBounds(325, 10, 250, 300);
                btnImgeafricaSilo.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
        //JOtionPane (user's preference)
        int btnImgeafricaSilo = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgeafricaSilo == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();      
                                
                                
                    //getText                             
                        String name=lblHotelNameEight.getText();
                        String location=lblHotelLocExtEight.getText();
                        String hotelid=lblHotelIDExtEight.getText();
                        String rate=lblHotelRateExtEight.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }               
                }
                }
                  }); 
                framePanelAfrica.add(btnImgeafricaSilo);
                
                
                // Labels for information of the hotel
                // Belmond Hotel
                
                lblHotelNameNine = new JLabel("Belmond M.N. Hotel");
                lblHotelNameNine.setFont(fontHotelName);
                lblHotelNameNine.setForeground(Color.BLACK);
                lblHotelNameNine.setBounds(630, 300, 320, 70);
                framePanelAfrica.add(lblHotelNameNine);
                
                lblHotelLocationNine = new JLabel("LOCATION:");
                lblHotelLocationNine.setFont(hotelFont);
                lblHotelLocationNine.setForeground(Color.WHITE);
                lblHotelLocationNine.setBounds(630, 320, 310, 70);
                framePanelAfrica.add(lblHotelLocationNine);
                
                lblHotelLocExtNine = new JLabel("76 Orange St, Cape Town, 8001, SA");
                lblHotelLocExtNine.setFont(hotelFont);
                lblHotelLocExtNine.setForeground(Color.WHITE);
                lblHotelLocExtNine.setBounds(630, 340, 320, 70);
                framePanelAfrica.add(lblHotelLocExtNine);
                
                lblHotelIDNine = new JLabel("HOTELID:");
                lblHotelIDNine.setFont(hotelFont);
                lblHotelIDNine.setForeground(Color.WHITE);
                lblHotelIDNine.setBounds(630, 360, 320, 70);
                framePanelAfrica.add(lblHotelIDNine);
                
                lblHotelIDExtNine = new JLabel(" ABH009");
                lblHotelIDExtNine.setFont(hotelFont);
                lblHotelIDExtNine.setForeground(Color.WHITE);
                lblHotelIDExtNine.setBounds(700, 360, 320, 70);
                framePanelAfrica.add(lblHotelIDExtNine);
               
                lblHotelRateNine = new JLabel("RATING:");
                lblHotelRateNine.setFont(hotelFont);
                lblHotelRateNine.setForeground(Color.WHITE);
                lblHotelRateNine.setBounds(630, 380, 320, 70);
                framePanelAfrica.add(lblHotelRateNine);
                
                lblHotelRateExtNine = new JLabel("4.5/5");
                lblHotelRateExtNine.setFont(hotelFont);
                lblHotelRateExtNine.setForeground(Color.WHITE);
                lblHotelRateExtNine.setBounds(700, 380, 320, 70);
                framePanelAfrica.add(lblHotelRateExtNine);
                
             
                //Image for every button on the panel

                imgIconafricaBelmond = new ImageIcon("belmondSA.jpg");
                Image imgscaleafricaBelmond = imgIconafricaBelmond.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconafricaBelmond = new ImageIcon(imgscaleafricaBelmond);
                btnImgeafricaBelmond = new JButton(imgnewiconafricaBelmond);
                btnImgeafricaBelmond.setBounds(630, 10, 250, 300);
                btnImgeafricaBelmond.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
        //JOtionPane (user's preference)
        int btnImgeafricaBelmond = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgeafricaBelmond == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();     
                                
                    
                        //getText                             
                        String name=lblHotelNameNine.getText();
                        String location=lblHotelLocExtNine.getText();
                        String hotelid=lblHotelIDExtNine.getText();
                        String rate=lblHotelRateExtNine.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }               
                }
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
                
                lblHotelNameTen = new JLabel("Four Seasons Resort");
                lblHotelNameTen.setFont(fontHotelName);
                lblHotelNameTen.setForeground(Color.BLACK);
                lblHotelNameTen.setBounds(20, 300, 320, 70);
                framePanelHawaii.add(lblHotelNameTen);
                
                lblHotelLocationTen = new JLabel("LOCATION:");
                lblHotelLocationTen.setFont(hotelFont);
                lblHotelLocationTen.setForeground(Color.WHITE);
                lblHotelLocationTen.setBounds(20, 320, 310, 70);
                framePanelHawaii.add(lblHotelLocationTen);
                
                lblHotelLocExtTen = new JLabel("3900 Wailea Alanui Dr, HI, US");
                lblHotelLocExtTen.setFont(hotelFont);
                lblHotelLocExtTen.setForeground(Color.WHITE);
                lblHotelLocExtTen.setBounds(20, 340, 320, 70);
                framePanelHawaii.add(lblHotelLocExtTen);
                
                lblHotelIDTen = new JLabel("HOTELID:");
                lblHotelIDTen.setFont(hotelFont);
                lblHotelIDTen.setForeground(Color.WHITE);
                lblHotelIDTen.setBounds(20, 360, 320, 70);
                framePanelHawaii.add(lblHotelIDTen);
                
                lblHotelIDExtTen = new JLabel(" HFH0010");
                lblHotelIDExtTen.setFont(hotelFont);
                lblHotelIDExtTen.setForeground(Color.WHITE);
                lblHotelIDExtTen.setBounds(90, 360, 320, 70);
                framePanelHawaii.add(lblHotelIDExtTen);
               
                lblHotelRateTen = new JLabel("RATING:");
                lblHotelRateTen.setFont(hotelFont);
                lblHotelRateTen.setForeground(Color.WHITE);
                lblHotelRateTen.setBounds(20, 380, 320, 70);
                framePanelHawaii.add(lblHotelRateTen);
                
                lblHotelRateExtTen = new JLabel("5/5");
                lblHotelRateExtTen.setFont(hotelFont);
                lblHotelRateExtTen.setForeground(Color.WHITE);
                lblHotelRateExtTen.setBounds(90, 380, 320, 70);
                framePanelHawaii.add(lblHotelRateExtTen);
                
            
                //Image for every button on the panel

                imgIconhawaiiFourseasons = new ImageIcon("fourseasonsHawaii.jpg");
                Image imgscalehawaiiFourseasons = imgIconhawaiiFourseasons.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconhawaiiFourseasons = new ImageIcon(imgscalehawaiiFourseasons);
                btnImgehawaiiFourseasons = new JButton(imgnewiconhawaiiFourseasons);
                btnImgehawaiiFourseasons.setBounds(20, 10, 250, 300);
                btnImgehawaiiFourseasons.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

        //JOtionPane (user's preference)
        int btnImgehawaiiFourseasons = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgehawaiiFourseasons == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();       
                                
                                
                    //getText                             
                        String name=lblHotelNameTen.getText();
                        String location=lblHotelLocExtTen.getText();
                        String hotelid=lblHotelIDExtTen.getText();
                        String rate=lblHotelRateExtTen.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }               
                }
                }
                  }); 
                framePanelHawaii.add(btnImgehawaiiFourseasons);
                
                
                // Labels for information of the hotel
                // Andaz Maui At Wailea Resort
                
                lblHotelNameEleven = new JLabel("Andaz Maui At Wailea Resort");
                lblHotelNameEleven.setFont(fontHotelName);
                lblHotelNameEleven.setForeground(Color.BLACK);
                lblHotelNameEleven.setBounds(325, 300, 320, 70);
                framePanelHawaii.add(lblHotelNameEleven);
                
                lblHotelLocationEleven = new JLabel("LOCATION:");
                lblHotelLocationEleven.setFont(hotelFont);
                lblHotelLocationEleven.setForeground(Color.WHITE);
                lblHotelLocationEleven.setBounds(325, 320, 310, 70);
                framePanelHawaii.add(lblHotelLocationEleven);
                
                lblHotelLocExtEleven = new JLabel("3550 Wailea Alanui Dr, HI, US");
                lblHotelLocExtEleven.setFont(hotelFont);
                lblHotelLocExtEleven.setForeground(Color.WHITE);
                lblHotelLocExtEleven.setBounds(325, 340, 320, 70);
                framePanelHawaii.add(lblHotelLocExtEleven);
                
                lblHotelIDEleven = new JLabel("HOTELID:");
                lblHotelIDEleven.setFont(hotelFont);
                lblHotelIDEleven.setForeground(Color.WHITE);
                lblHotelIDEleven.setBounds(325, 360, 320, 70);
                framePanelHawaii.add(lblHotelIDEleven);
                
                lblHotelIDExtEleven = new JLabel(" HAH011");
                lblHotelIDExtEleven.setFont(hotelFont);
                lblHotelIDExtEleven.setForeground(Color.WHITE);
                lblHotelIDExtEleven.setBounds(395, 360, 320, 70);
                framePanelHawaii.add(lblHotelIDExtEleven);
               
                lblHotelRateEleven = new JLabel("RATING:");
                lblHotelRateEleven.setFont(hotelFont);
                lblHotelRateEleven.setForeground(Color.WHITE);
                lblHotelRateEleven.setBounds(325, 380, 320, 70);
                framePanelHawaii.add(lblHotelRateEleven);
                
                lblHotelRateExtEleven = new JLabel("4.5/5");
                lblHotelRateExtEleven.setFont(hotelFont);
                lblHotelRateExtEleven.setForeground(Color.WHITE);
                lblHotelRateExtEleven.setBounds(395, 380, 320, 70);
                framePanelHawaii.add(lblHotelRateExtEleven);
                
               
                //Image for every button on the panel

                imgIconhawaiiAndaz = new ImageIcon("andazHawaii.jpg");
                Image imgscalehawaiiAndaz = imgIconhawaiiAndaz.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconhawaiiAndaz = new ImageIcon(imgscalehawaiiAndaz);
                btnImgehawaiiAndaz = new JButton(imgnewiconhawaiiAndaz);
                btnImgehawaiiAndaz.setBounds(325, 10, 250, 300);
                btnImgehawaiiAndaz.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
        //JOtionPane (user's preference)
        int btnImgehawaiiAndaz = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgehawaiiAndaz == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();   
                                
                    
                        //getText                             
                        String name=lblHotelNameEleven.getText();
                        String location=lblHotelLocExtEleven.getText();
                        String hotelid=lblHotelIDExtEleven.getText();
                        String rate=lblHotelRateExtEleven.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }               
                }
                }
                  }); 
                framePanelHawaii.add(btnImgehawaiiAndaz);
                
                
                // Labels for information of the hotel
                // The Ritz-Carlton, Kapalua
                
                lblHotelNameTwelve = new JLabel("The Ritz-Carlton, Kapalua");
                lblHotelNameTwelve.setFont(fontHotelName);
                lblHotelNameTwelve.setForeground(Color.BLACK);
                lblHotelNameTwelve.setBounds(630, 300, 320, 70);
                framePanelHawaii.add(lblHotelNameTwelve);
                
                lblHotelLocationTwelve = new JLabel("LOCATION:");
                lblHotelLocationTwelve.setFont(hotelFont);
                lblHotelLocationTwelve.setForeground(Color.WHITE);
                lblHotelLocationTwelve.setBounds(630, 320, 310, 70);
                framePanelHawaii.add(lblHotelLocationTwelve);
                
                lblHotelLocExtTwelve = new JLabel("1 Ritz Carlton Dr, Lahaina,HI , US");
                lblHotelLocExtTwelve.setFont(hotelFont);
                lblHotelLocExtTwelve.setForeground(Color.WHITE);
                lblHotelLocExtTwelve.setBounds(630, 340, 320, 70);
                framePanelHawaii.add(lblHotelLocExtTwelve);
                
                lblHotelIDTwelve = new JLabel("HOTELID:");
                lblHotelIDTwelve.setFont(hotelFont);
                lblHotelIDTwelve.setForeground(Color.WHITE);
                lblHotelIDTwelve.setBounds(630, 360, 320, 70);
                framePanelHawaii.add(lblHotelIDTwelve);
                
                lblHotelIDExtTwelve = new JLabel(" HRH012");
                lblHotelIDExtTwelve.setFont(hotelFont);
                lblHotelIDExtTwelve.setForeground(Color.WHITE);
                lblHotelIDExtTwelve.setBounds(700, 360, 320, 70);
                framePanelHawaii.add(lblHotelIDExtTwelve);
               
                lblHotelRateTwelve = new JLabel("RATING:");
                lblHotelRateTwelve.setFont(hotelFont);
                lblHotelRateTwelve.setForeground(Color.WHITE);
                lblHotelRateTwelve.setBounds(630, 380, 320, 70);
                framePanelHawaii.add(lblHotelRateTwelve);
                
                lblHotelRateExtTwelve = new JLabel("4.5/5");
                lblHotelRateExtTwelve.setFont(hotelFont);
                lblHotelRateExtTwelve.setForeground(Color.WHITE);
                lblHotelRateExtTwelve.setBounds(700, 380, 320, 70);
                framePanelHawaii.add(lblHotelRateExtTwelve);
               
                
                //Image for every button on the panel
  
                imgIconhawaiiRitz = new ImageIcon("ritzHawaii.jpg");
                Image imgscalehawaiiRitz = imgIconhawaiiRitz.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconhawaiiRitz = new ImageIcon(imgscalehawaiiRitz);
                btnImgehawaiiRitz = new JButton(imgnewiconhawaiiRitz);
                btnImgehawaiiRitz.setBounds(630, 10, 250, 300);
                btnImgehawaiiRitz.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    

        //JOtionPane (user's preference)
        int btnImgehawaiiRitz = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgehawaiiRitz == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();         
                                
                              
                        //getText                             
                        String name=lblHotelNameTwelve.getText();
                        String location=lblHotelLocExtTwelve.getText();
                        String hotelid=lblHotelIDExtTwelve.getText();
                        String rate=lblHotelRateExtTwelve.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }               
        }                 
                }
                  }); 
                framePanelHawaii.add(btnImgehawaiiRitz);
                
                }
    
                
                   //show the specific panel per location
                    //Spain

    else if
                (place.equalsIgnoreCase("Spain")) {
                layer.removeAll();
                
                //Panel for the location Spain
                framePanelSpain = new JPanel();
                framePanelSpain.setBounds(40, 120, 900, 450);
                framePanelSpain.setBackground(new Color(37, 113, 128));
                framePanelSpain.setLayout(null);
                layer.add(framePanelSpain, Integer.valueOf(0));  
                
                // Labels for information of the hotel
                    // Hotel Arts Barcelona
                
                lblHotelNameThirteen = new JLabel("Hotel Arts Barcelona");
                lblHotelNameThirteen.setFont(fontHotelName);
                lblHotelNameThirteen.setForeground(Color.BLACK);
                lblHotelNameThirteen.setBounds(20, 300, 320, 70);
                framePanelSpain.add(lblHotelNameThirteen);
                
                lblHotelLocationThirteen = new JLabel("LOCATION:");
                lblHotelLocationThirteen.setFont(hotelFont);
                lblHotelLocationThirteen.setForeground(Color.WHITE);
                lblHotelLocationThirteen.setBounds(20, 320, 310, 70);
                framePanelSpain.add(lblHotelLocationThirteen);
                
                lblHotelLocExtThirteen = new JLabel("Carrer de la Marina, Barcelona, Spain");
                lblHotelLocExtThirteen.setFont(hotelFont);
                lblHotelLocExtThirteen.setForeground(Color.WHITE);
                lblHotelLocExtThirteen.setBounds(20, 340, 320, 70);
                framePanelSpain.add(lblHotelLocExtThirteen);
                
                lblHotelIDThirteen = new JLabel("HOTELID:");
                lblHotelIDThirteen.setFont(hotelFont);
                lblHotelIDThirteen.setForeground(Color.WHITE);
                lblHotelIDThirteen.setBounds(20, 360, 320, 70);
                framePanelSpain.add(lblHotelIDThirteen);
                
                lblHotelIDExtThirteen = new JLabel(" SAH013");
                lblHotelIDExtThirteen.setFont(hotelFont);
                lblHotelIDExtThirteen.setForeground(Color.WHITE);
                lblHotelIDExtThirteen.setBounds(90, 360, 320, 70);
                framePanelSpain.add(lblHotelIDExtThirteen);
               
                lblHotelRateThirteen = new JLabel("RATING:");
                lblHotelRateThirteen.setFont(hotelFont);
                lblHotelRateThirteen.setForeground(Color.WHITE);
                lblHotelRateThirteen.setBounds(20, 380, 320, 70);
                framePanelSpain.add(lblHotelRateThirteen);
                
                lblHotelRateExtThirteen = new JLabel("5/5");
                lblHotelRateExtThirteen.setFont(hotelFont);
                lblHotelRateExtThirteen.setForeground(Color.WHITE);
                lblHotelRateExtThirteen.setBounds(90, 380, 320, 70);
                framePanelSpain.add(lblHotelRateExtThirteen);        
                
                //Image for every button on the panel
 
                imgIconspainArts = new ImageIcon("artsSpain.jpg");
                Image imgscalespainArts = imgIconspainArts.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconspainArts = new ImageIcon(imgscalespainArts);
                btnImgespainArts = new JButton(imgnewiconspainArts);
                btnImgespainArts.setBounds(20, 10, 250, 300);
                btnImgespainArts.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
                    
        //JOtionPane (user's preference)
        int btnImgespainArts = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgespainArts == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();     
                                
                        
                         //getText                             
                        String name=lblHotelNameThirteen.getText();
                        String location=lblHotelLocExtThirteen.getText();
                        String hotelid=lblHotelIDExtThirteen.getText();
                        String rate=lblHotelRateExtThirteen.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    } 
                  }
                }
                  });
                framePanelSpain.add(btnImgespainArts);
                
                
                // Labels for information of the hotel
                // Mandarin Oriental, Barcelona
                
                lblHotelNameFourteen = new JLabel("Mandarin Oriental, Barcelona");
                lblHotelNameFourteen.setFont(fontHotelName);
                lblHotelNameFourteen.setForeground(Color.BLACK);
                lblHotelNameFourteen.setBounds(325, 300, 320, 70);
                framePanelSpain.add(lblHotelNameFourteen);
                
                lblHotelLocationFourteen = new JLabel("LOCATION:");
                lblHotelLocationFourteen.setFont(hotelFont);
                lblHotelLocationFourteen.setForeground(Color.WHITE);
                lblHotelLocationFourteen.setBounds(325, 320, 310, 70);
                framePanelSpain.add(lblHotelLocationFourteen);
                
                lblHotelLocExtFourteen = new JLabel("L'Eixample,Barcelona, Spain");
                lblHotelLocExtFourteen.setFont(hotelFont);
                lblHotelLocExtFourteen.setForeground(Color.WHITE);
                lblHotelLocExtFourteen.setBounds(325, 340, 320, 70);
                framePanelSpain.add(lblHotelLocExtFourteen);
                
                lblHotelIDFourteen = new JLabel("HOTELID:");
                lblHotelIDFourteen.setFont(hotelFont);
                lblHotelIDFourteen.setForeground(Color.WHITE);
                lblHotelIDFourteen.setBounds(325, 360, 320, 70);
                framePanelSpain.add(lblHotelIDFourteen);
                
                lblHotelIDExtFourteen = new JLabel(" SMH014");
                lblHotelIDExtFourteen.setFont(hotelFont);
                lblHotelIDExtFourteen.setForeground(Color.WHITE);
                lblHotelIDExtFourteen.setBounds(395, 360, 320, 70);
                framePanelSpain.add(lblHotelIDExtFourteen);
                
                lblHotelRateFourteen = new JLabel("RATING:");
                lblHotelRateFourteen.setFont(hotelFont);
                lblHotelRateFourteen.setForeground(Color.WHITE);
                lblHotelRateFourteen.setBounds(325, 380, 320, 70);
                framePanelSpain.add(lblHotelRateFourteen);
                
                lblHotelRateExtFourteen = new JLabel("5/5");
                lblHotelRateExtFourteen.setFont(hotelFont);
                lblHotelRateExtFourteen.setForeground(Color.WHITE);
                lblHotelRateExtFourteen.setBounds(395, 380, 320, 70);
                framePanelSpain.add(lblHotelRateExtFourteen);
                
                
                //Image for every button on the panel

                imgIconspainMandarin = new ImageIcon("mandarinSpain.jpg");
                Image imgscalespainMandarin = imgIconspainMandarin.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconspainMandarin = new ImageIcon(imgscalespainMandarin);
                btnImgespainMandarin = new JButton(imgnewiconspainMandarin);
                btnImgespainMandarin.setBounds(325, 10, 250, 300);
                btnImgespainMandarin.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                        

        //JOtionPane (user's preference)
        int btnImgespainMandarin = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgespainMandarin == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();        
                                
                            
                        //getText                             
                        String name=lblHotelNameFourteen.getText();
                        String location=lblHotelLocExtFourteen.getText();
                        String hotelid=lblHotelIDExtFourteen.getText();
                        String rate=lblHotelRateExtFourteen.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }             
                    }
                }
                  });
                framePanelSpain.add(btnImgespainMandarin);
                
                
                // Labels for information of the hotel
                // El Palace Hotel, Barcelona
                
                lblHotelNameFifteen = new JLabel("El Palace Hotel");
                lblHotelNameFifteen.setFont(fontHotelName);
                lblHotelNameFifteen.setForeground(Color.BLACK);
                lblHotelNameFifteen.setBounds(630, 300, 320, 70);
                framePanelSpain.add(lblHotelNameFifteen);
                
                lblHotelLocationFifteen = new JLabel("LOCATION:");
                lblHotelLocationFifteen.setFont(hotelFont);
                lblHotelLocationFifteen.setForeground(Color.WHITE);
                lblHotelLocationFifteen.setBounds(630, 320, 310, 70);
                framePanelSpain.add(lblHotelLocationFifteen);
                
                lblHotelLocExtFifteen = new JLabel(" 668, L'Eixample, Barcelona, Spain");
                lblHotelLocExtFifteen.setFont(hotelFont);
                lblHotelLocExtFifteen.setForeground(Color.WHITE);
                lblHotelLocExtFifteen.setBounds(630, 340, 320, 70);
                framePanelSpain.add(lblHotelLocExtFifteen);
                
                lblHotelIDFifteen = new JLabel("HOTELID:");
                lblHotelIDFifteen.setFont(hotelFont);
                lblHotelIDFifteen.setForeground(Color.WHITE);
                lblHotelIDFifteen.setBounds(630, 360, 320, 70);
                framePanelSpain.add(lblHotelIDFifteen);
                
                lblHotelIDExtFifteen = new JLabel(" SPH015");
                lblHotelIDExtFifteen.setFont(hotelFont);
                lblHotelIDExtFifteen.setForeground(Color.WHITE);
                lblHotelIDExtFifteen.setBounds(700, 360, 320, 70);
                framePanelSpain.add(lblHotelIDExtFifteen);
                
                lblHotelRateFifteen = new JLabel("RATING:");
                lblHotelRateFifteen.setFont(hotelFont);
                lblHotelRateFifteen.setForeground(Color.WHITE);
                lblHotelRateFifteen.setBounds(630, 380, 320, 70);
                framePanelSpain.add(lblHotelRateFifteen);
                
                lblHotelRateExtFifteen = new JLabel("5/5");
                lblHotelRateExtFifteen.setFont(hotelFont);
                lblHotelRateExtFifteen.setForeground(Color.WHITE);
                lblHotelRateExtFifteen.setBounds(700, 380, 320, 70);
                framePanelSpain.add(lblHotelRateExtFifteen);
                
            
                //Image for every button on the panel

                imgIconspainPalace = new ImageIcon("elpalaceSpain.jpg");
                Image imgscalespainPalace = imgIconspainPalace.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconspainPalace = new ImageIcon(imgscalespainPalace);
                btnImgespainPalace = new JButton(imgnewiconspainPalace);
                btnImgespainPalace.setBounds(630, 10, 250, 300);
                btnImgespainPalace.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                 
                    
        //JOtionPane (user's preference)
        int btnImgespainPalace = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgespainPalace == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();       
                                
                            
                        //getText                             
                        String name=lblHotelNameFifteen.getText();
                        String location=lblHotelLocExtFifteen.getText();
                        String hotelid=lblHotelIDExtFifteen.getText();
                        String rate=lblHotelRateExtFifteen.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }             
                }
                }
                  });
                framePanelSpain.add(btnImgespainPalace);
                
                }    

                
                //show the specific panel per location

    
            else if
                (place.equalsIgnoreCase("thailand")) {
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
                
                lblHotelNameSixteen = new JLabel("Mandarin Oriental, Bangkok");
                lblHotelNameSixteen.setFont(fontHotelName);
                lblHotelNameSixteen.setForeground(Color.BLACK);
                lblHotelNameSixteen.setBounds(20, 300, 320, 70);
                framePanelthailand.add(lblHotelNameSixteen);
                
                lblHotelLocationSixteen = new JLabel("LOCATION:");
                lblHotelLocationSixteen.setFont(hotelFont);
                lblHotelLocationSixteen.setForeground(Color.WHITE);
                lblHotelLocationSixteen.setBounds(20, 320, 310, 70);
                framePanelthailand.add(lblHotelLocationSixteen);
                
                lblHotelLocExtSixteen = new JLabel("48 Oriental Avenue, Bangkok, Thailand");
                lblHotelLocExtSixteen.setFont(hotelFont);
                lblHotelLocExtSixteen.setForeground(Color.WHITE);
                lblHotelLocExtSixteen.setBounds(20, 340, 320, 70);
                framePanelthailand.add(lblHotelLocExtSixteen);
                
                lblHotelIDSixteen = new JLabel("HOTELID:");
                lblHotelIDSixteen.setFont(hotelFont);
                lblHotelIDSixteen.setForeground(Color.WHITE);
                lblHotelIDSixteen.setBounds(20, 360, 320, 70);
                framePanelthailand.add(lblHotelIDSixteen);
                
                lblHotelIDExtSixteen = new JLabel(" BKK016");
                lblHotelIDExtSixteen.setFont(hotelFont);
                lblHotelIDExtSixteen.setForeground(Color.WHITE);
                lblHotelIDExtSixteen.setBounds(90, 360, 320, 70);
                framePanelthailand.add(lblHotelIDExtSixteen);

                lblHotelRateSixteen = new JLabel("RATING: ");
                lblHotelRateSixteen.setFont(hotelFont);
                lblHotelRateSixteen.setForeground(Color.WHITE);
                lblHotelRateSixteen.setBounds(20, 380, 320, 70);
                framePanelthailand.add(lblHotelRateSixteen);
                
                lblHotelRateExtSixteen = new JLabel("5/5");
                lblHotelRateExtSixteen.setFont(hotelFont);
                lblHotelRateExtSixteen.setForeground(Color.WHITE);
                lblHotelRateExtSixteen.setBounds(90, 380, 320, 70);
                framePanelthailand.add(lblHotelRateExtSixteen);
                
                
                //Image button for Mandarin
   
                imgIconthailandMandarin = new ImageIcon("mandarinThailand.jpg");
                Image imgscaleMandarin = imgIconthailandMandarin.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconMandarin = new ImageIcon(imgscaleMandarin);
                btnImgthailandMandarin = new JButton(imgnewiconMandarin);
                btnImgthailandMandarin.setBounds(20, 10, 250, 300);
                btnImgthailandMandarin.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    

        //JOtionPane (user's preference)
        int btnImgthailandMandarin = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgthailandMandarin == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();  
                                
                            
                        //getText                             
                        String name=lblHotelNameSixteen.getText();
                        String location=lblHotelLocExtSixteen.getText();
                        String hotelid=lblHotelIDExtSixteen.getText();
                        String rate=lblHotelRateExtSixteen.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }             
                }
                }
                  });                
                framePanelthailand.add(btnImgthailandMandarin);

                
                //Labels for the information of the hotel
                    //Siam
                    
                lblHotelNameSeventeen = new JLabel("The Siam");
                lblHotelNameSeventeen.setFont(fontHotelName);
                lblHotelNameSeventeen.setForeground(Color.BLACK);
                lblHotelNameSeventeen.setBounds(325, 300, 320, 70);
                framePanelthailand.add(lblHotelNameSeventeen);
                
                lblHotelLocationSeventeen = new JLabel("LOCATION:");
                lblHotelLocationSeventeen.setFont(hotelFont);
                lblHotelLocationSeventeen.setForeground(Color.WHITE);
                lblHotelLocationSeventeen.setBounds(325, 320, 310, 70);
                framePanelthailand.add(lblHotelLocationSeventeen);
                
                lblHotelLocExtSeventeen = new JLabel("3/2 Thanon Khao, Bangkok,Thailand");
                lblHotelLocExtSeventeen.setFont(hotelFont);
                lblHotelLocExtSeventeen.setForeground(Color.WHITE);
                lblHotelLocExtSeventeen.setBounds(325, 340, 320, 70);
                framePanelthailand.add(lblHotelLocExtSeventeen);
                
                lblHotelIDSeventeen = new JLabel("HOTELID:");
                lblHotelIDSeventeen.setFont(hotelFont);
                lblHotelIDSeventeen.setForeground(Color.WHITE);
                lblHotelIDSeventeen.setBounds(325, 360, 320, 70);
                framePanelthailand.add(lblHotelIDSeventeen);
                
                lblHotelIDExtSeventeen = new JLabel(" BKK017");
                lblHotelIDExtSeventeen.setFont(hotelFont);
                lblHotelIDExtSeventeen.setForeground(Color.WHITE);
                lblHotelIDExtSeventeen.setBounds(395, 360, 320, 70);
                framePanelthailand.add(lblHotelIDExtSeventeen);
               
                lblHotelRateSeventeen = new JLabel("RATING: ");
                lblHotelRateSeventeen.setFont(hotelFont);
                lblHotelRateSeventeen.setForeground(Color.WHITE);
                lblHotelRateSeventeen.setBounds(325, 380, 320, 70);
                framePanelthailand.add(lblHotelRateSeventeen);
                
                lblHotelRateExtSeventeen = new JLabel("4.5/5");
                lblHotelRateExtSeventeen.setFont(hotelFont);
                lblHotelRateExtSeventeen.setForeground(Color.WHITE);
                lblHotelRateExtSeventeen.setBounds(395, 380, 320, 70);
                framePanelthailand.add(lblHotelRateExtSeventeen);
               

                
                //Image button for Siam
   
                imgIconthailandSiam = new ImageIcon("siamThailand.jpg");
                Image imgscaleSiam = imgIconthailandSiam.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconSiam = new ImageIcon(imgscaleSiam);
                btnImgthailandSiam = new JButton(imgnewiconSiam);
                btnImgthailandSiam.setBounds(325, 10, 250, 300);
                btnImgthailandSiam.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  
                    
        //JOtionPane (user's preference)
        int btnImgthailandSiam = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgthailandSiam == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();   
                                
                            
                        //getText                             
                        String name=lblHotelNameSeventeen.getText();
                        String location=lblHotelLocExtSeventeen.getText();
                        String hotelid=lblHotelIDExtSeventeen.getText();
                        String rate=lblHotelRateExtSeventeen.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }             
                }
                }
                  });                
                framePanelthailand.add(btnImgthailandSiam);
                
                
                //Labels for the information of the hotel
                   //Peninsula
                
                lblHotelNameEighteen = new JLabel("The Peninsula");
                lblHotelNameEighteen.setFont(fontHotelName);
                lblHotelNameEighteen.setForeground(Color.BLACK);
                lblHotelNameEighteen.setBounds(630, 300, 320, 70);
                framePanelthailand.add(lblHotelNameEighteen);
                
                lblHotelLocationEighteen = new JLabel("LOCATION:");
                lblHotelLocationEighteen.setFont(hotelFont);
                lblHotelLocationEighteen.setForeground(Color.WHITE);
                lblHotelLocationEighteen.setBounds(630, 320, 310, 70);
                framePanelthailand.add(lblHotelLocationEighteen);
                
                lblHotelLocExtEighteen = new JLabel("CharoennakornRoad, Bangkok, Thailand ");
                lblHotelLocExtEighteen.setFont(hotelFont);
                lblHotelLocExtEighteen.setForeground(Color.WHITE);
                lblHotelLocExtEighteen.setBounds(630, 340, 320, 70);
                framePanelthailand.add(lblHotelLocExtEighteen);
                
                lblHotelIDEighteen = new JLabel("HOTELID:");
                lblHotelIDEighteen.setFont(hotelFont);
                lblHotelIDEighteen.setForeground(Color.WHITE);
                lblHotelIDEighteen.setBounds(630, 360, 320, 70);
                framePanelthailand.add(lblHotelIDEighteen);
                
                lblHotelIDExtEighteen = new JLabel(" BKK018");
                lblHotelIDExtEighteen.setFont(hotelFont);
                lblHotelIDExtEighteen.setForeground(Color.WHITE);
                lblHotelIDExtEighteen.setBounds(700, 360, 320, 70);
                framePanelthailand.add(lblHotelIDExtEighteen);
                
                lblHotelRateEighteen = new JLabel("RATING: ");
                lblHotelRateEighteen.setFont(hotelFont);
                lblHotelRateEighteen.setForeground(Color.WHITE);
                lblHotelRateEighteen.setBounds(630, 380, 320, 70);
                framePanelthailand.add(lblHotelRateEighteen);
    
                lblHotelRateExtEighteen = new JLabel("4.5/5");
                lblHotelRateExtEighteen.setFont(hotelFont);
                lblHotelRateExtEighteen.setForeground(Color.WHITE);
                lblHotelRateExtEighteen.setBounds(700, 380, 320, 70);
                framePanelthailand.add(lblHotelRateExtEighteen);
    
                //Image button for Peninsula

                imgIconthailandPeninsula = new ImageIcon("peninsulaThailand.jpg");
                Image imgscalepeninsula = imgIconthailandPeninsula.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconPeninsula = new ImageIcon(imgscalepeninsula);
                btnImgthailandPeninsula = new JButton(imgnewiconPeninsula);
                btnImgthailandPeninsula.setBounds(630, 10, 250, 300);
                btnImgthailandPeninsula.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
                    
        //JOtionPane (user's preference)
        int btnImgthailandPeninsula = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgthailandPeninsula == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();     
                                
                            
                        //getText                             
                        String name=lblHotelNameEighteen.getText();
                        String location=lblHotelLocExtEighteen.getText();
                        String hotelid=lblHotelIDExtEighteen.getText();
                        String rate=lblHotelRateExtEighteen.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }           
        }
                }
                  });     
                framePanelthailand.add(btnImgthailandPeninsula);
                
                
                //Show the specific panel for location
              
     
       } else if 
                (place.equalsIgnoreCase("paris")) {
                layer.removeAll();                
                
                //Panel for the location for France
                framePanelfrance = new JPanel();
                framePanelfrance.setBounds(40, 120, 900, 450);
                framePanelfrance.setBackground(new Color(37, 113, 128));
                framePanelfrance.setLayout(null);
                layer.add(framePanelfrance, Integer.valueOf(0));
                
                
                //Labels for the information of the hotel
                 //Ritz
                
                lblHotelNameNineteen = new JLabel("The Ritz");
                lblHotelNameNineteen.setFont(fontHotelName);
                lblHotelNameNineteen.setForeground(Color.BLACK);
                lblHotelNameNineteen.setBounds(20, 300, 320, 70);
                framePanelfrance.add(lblHotelNameNineteen);
                
                lblHotelLocationNineteen = new JLabel("LOCATION:");
                lblHotelLocationNineteen.setFont(hotelFont);
                lblHotelLocationNineteen.setForeground(Color.WHITE);
                lblHotelLocationNineteen.setBounds(20, 320, 310, 70);
                framePanelfrance.add(lblHotelLocationNineteen);
                
                lblHotelLocExtNineteen = new JLabel("15 Place Vendôme, Paris, France");
                lblHotelLocExtNineteen.setFont(hotelFont);
                lblHotelLocExtNineteen.setForeground(Color.WHITE);
                lblHotelLocExtNineteen.setBounds(20, 340, 320, 70);
                framePanelfrance.add(lblHotelLocExtNineteen);
                
                lblHotelIDNineteen = new JLabel("HOTELID:");
                lblHotelIDNineteen.setFont(hotelFont);
                lblHotelIDNineteen.setForeground(Color.WHITE);
                lblHotelIDNineteen.setBounds(20, 360, 320, 70);
                framePanelfrance.add(lblHotelIDNineteen);
                
                lblHotelIDExtNineteen = new JLabel(" PAR019");
                lblHotelIDExtNineteen.setFont(hotelFont);
                lblHotelIDExtNineteen.setForeground(Color.WHITE);
                lblHotelIDExtNineteen.setBounds(90, 360, 320, 70);
                framePanelfrance.add(lblHotelIDExtNineteen);
               
                lblHotelRateNineteen = new JLabel("RATING: ");
                lblHotelRateNineteen.setFont(hotelFont);
                lblHotelRateNineteen.setForeground(Color.WHITE);
                lblHotelRateNineteen.setBounds(20, 380, 320, 70);
                framePanelfrance.add(lblHotelRateNineteen);
                
                lblHotelRateExtNineteen = new JLabel("5/5");
                lblHotelRateExtNineteen.setFont(hotelFont);
                lblHotelRateExtNineteen.setForeground(Color.WHITE);
                lblHotelRateExtNineteen.setBounds(90, 380, 320, 70);
                framePanelfrance.add(lblHotelRateExtNineteen);
                
                 
                //Image button for Ritz

                imgIconthailandRitz = new ImageIcon("theritzParis.jpg");
                Image imgscaleRitz = imgIconthailandRitz.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconRitz = new ImageIcon(imgscaleRitz);
                btnImgfranceRitz = new JButton(imgnewiconRitz);
                btnImgfranceRitz.setBounds(20, 10, 250, 300);
                 
                btnImgfranceRitz.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
        //JOtionPane (user's preference)
        int btnImgfranceRitz = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgfranceRitz == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();      
                                
                    
                        //getText                             
                        String name=lblHotelNameNineteen.getText();
                        String location=lblHotelLocExtNineteen.getText();
                        String hotelid=lblHotelIDExtNineteen.getText();
                        String rate=lblHotelRateExtNineteen.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }             
                    }
                }
                  });                
                framePanelfrance.add(btnImgfranceRitz);
                
                
                //Labels for the information of the hotel
                    //Le Meurice
                
                lblHotelNameTwenty = new JLabel("Le Meurice");
                lblHotelNameTwenty.setFont(fontHotelName);
                lblHotelNameTwenty.setForeground(Color.BLACK);
                lblHotelNameTwenty.setBounds(325, 300, 320, 70);
                framePanelfrance.add(lblHotelNameTwenty);
                
                lblHotelLocationTwenty = new JLabel("LOCATION:");
                lblHotelLocationTwenty.setFont(hotelFont);
                lblHotelLocationTwenty.setForeground(Color.WHITE);
                lblHotelLocationTwenty.setBounds(325, 320, 310, 70);
                framePanelfrance.add(lblHotelLocationTwenty);
                
                lblHotelLocExtTwenty = new JLabel("228 Rue de Rivoli, Paris, France");
                lblHotelLocExtTwenty.setFont(hotelFont);
                lblHotelLocExtTwenty.setForeground(Color.WHITE);
                lblHotelLocExtTwenty.setBounds(325, 340, 320, 70);
                framePanelfrance.add(lblHotelLocExtTwenty);
                
                lblHotelIDTwenty = new JLabel("HOTELID:");
                lblHotelIDTwenty.setFont(hotelFont);
                lblHotelIDTwenty.setForeground(Color.WHITE);
                lblHotelIDTwenty.setBounds(325, 360, 320, 70);
                framePanelfrance.add(lblHotelIDTwenty);
               
                lblHotelIDExtTwenty = new JLabel(" PAR020");
                lblHotelIDExtTwenty.setFont(hotelFont);
                lblHotelIDExtTwenty.setForeground(Color.WHITE);
                lblHotelIDExtTwenty.setBounds(395, 360, 320, 70);
                framePanelfrance.add(lblHotelIDExtTwenty);
                
                lblHotelRateTwenty = new JLabel("RATING: ");
                lblHotelRateTwenty.setFont(hotelFont);
                lblHotelRateTwenty.setForeground(Color.WHITE);
                lblHotelRateTwenty.setBounds(325, 380, 320, 70);
                framePanelfrance.add(lblHotelRateTwenty);
                
                lblHotelRateExtTwenty = new JLabel("5/5");
                lblHotelRateExtTwenty.setFont(hotelFont);
                lblHotelRateExtTwenty.setForeground(Color.WHITE);
                lblHotelRateExtTwenty.setBounds(395, 380, 320, 70);
                framePanelfrance.add(lblHotelRateExtTwenty);
                

                
                //Image button for Le Meurice
  
                imgIconfranceLemeurice = new ImageIcon("meuriceParis.jpg");
                Image imgscalelemeurice = imgIconfranceLemeurice.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconLemeurice = new ImageIcon(imgscalelemeurice);
                btnImgfranceLemeurice = new JButton(imgnewiconLemeurice);
                btnImgfranceLemeurice.setBounds(325, 10, 250, 300);
                 
                btnImgfranceLemeurice.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  
        //JOtionPane (user's preference)
        int btnImgfranceLemeurice = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgfranceLemeurice == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();    
                                
                    
                        //getText                             
                        String name=lblHotelNameTwenty.getText();
                        String location=lblHotelLocExtTwenty.getText();
                        String hotelid=lblHotelIDExtTwenty.getText();
                        String rate=lblHotelRateExtTwenty.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }             
                  }
                }
                  });                
                framePanelfrance.add(btnImgfranceLemeurice);
                
                
                //Labels for the information of the hotel
                     //Shangri-La
                
                lblHotelNameTwentyone = new JLabel("Shangri-La");
                lblHotelNameTwentyone.setFont(fontHotelName);
                lblHotelNameTwentyone.setForeground(Color.BLACK);
                lblHotelNameTwentyone.setBounds(630, 300, 320, 70);
                framePanelfrance.add(lblHotelNameTwentyone);
                
                lblHotelLocationTwentyone = new JLabel("LOCATION:");
                lblHotelLocationTwentyone.setFont(hotelFont);
                lblHotelLocationTwentyone.setForeground(Color.WHITE);
                lblHotelLocationTwentyone.setBounds(630, 320, 310, 70);
                framePanelfrance.add(lblHotelLocationTwentyone);
                
                lblHotelLocExtTwentyone = new JLabel("10 Avenue d'Iéna, Paris, France ");
                lblHotelLocExtTwentyone.setFont(hotelFont);
                lblHotelLocExtTwentyone.setForeground(Color.WHITE);
                lblHotelLocExtTwentyone.setBounds(630, 340, 320, 70);
                framePanelfrance.add(lblHotelLocExtTwentyone);
                
                lblHotelIDTwentyone = new JLabel("HOTELID:");
                lblHotelIDTwentyone.setFont(hotelFont);
                lblHotelIDTwentyone.setForeground(Color.WHITE);
                lblHotelIDTwentyone.setBounds(630, 360, 320, 70);
                framePanelfrance.add(lblHotelIDTwentyone);
                
                lblHotelIDExtTwentyone = new JLabel(" PAR021");
                lblHotelIDExtTwentyone.setFont(hotelFont);
                lblHotelIDExtTwentyone.setForeground(Color.WHITE);
                lblHotelIDExtTwentyone.setBounds(700, 360, 320, 70);
                framePanelfrance.add(lblHotelIDExtTwentyone);
                
                lblHotelRateTwentyone = new JLabel("RATING: ");
                lblHotelRateTwentyone.setFont(hotelFont);
                lblHotelRateTwentyone.setForeground(Color.WHITE);
                lblHotelRateTwentyone.setBounds(630, 380, 320, 70);
                framePanelfrance.add(lblHotelRateTwentyone);
                
                lblHotelRateExtTwentyone = new JLabel("5/5");
                lblHotelRateExtTwentyone.setFont(hotelFont);
                lblHotelRateExtTwentyone.setForeground(Color.WHITE);
                lblHotelRateExtTwentyone.setBounds(700, 380, 320, 70);
                framePanelfrance.add(lblHotelRateExtTwentyone);
    
            
                //Image button for Shangrila

                imgIconfranceShangrila = new ImageIcon("shangriParis.jpg");
                Image imgscaleShangrila = imgIconfranceShangrila.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconShangrila = new ImageIcon(imgscaleShangrila);
                btnImgfranceShangrila = new JButton(imgnewiconShangrila);
                btnImgfranceShangrila.setBounds(630, 10, 250, 300);
                
                btnImgfranceShangrila.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  
        //JOtionPane (user's preference)
        int btnImgfranceShangrila = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgfranceShangrila == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();  
                                
                    
                        //getText                             
                        String name=lblHotelNameTwentyone.getText();
                        String location=lblHotelLocExtTwentyone.getText();
                        String hotelid=lblHotelIDExtTwentyone.getText();
                        String rate=lblHotelRateExtTwentyone.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }            
                }
                }
                  });     
                framePanelfrance.add(btnImgfranceShangrila);
                
                

                //Show the specific panel for location
                    //Japan
               
        } else if 
                (place.equalsIgnoreCase("japan")) {
                layer.removeAll();                
                
                //Panel for the location for Japan
                framePaneljapan = new JPanel();
                framePaneljapan.setBounds(40, 120, 900, 450);
                framePaneljapan.setBackground(new Color(37, 113, 128));
                framePaneljapan.setLayout(null);
                layer.add(framePaneljapan, Integer.valueOf(0));
                
                
                //Labels for the information of the hotel
                   //Ritz-Carlton
                   
                lblHotelNameTwentytwo = new JLabel("The Ritz-Carlton");
                lblHotelNameTwentytwo.setFont(fontHotelName);
                lblHotelNameTwentytwo.setForeground(Color.BLACK);
                lblHotelNameTwentytwo.setBounds(20, 300, 320, 70);
                framePaneljapan.add(lblHotelNameTwentytwo);
                
                lblHotelLocationTwentytwo = new JLabel("LOCATION:");
                lblHotelLocationTwentytwo.setFont(hotelFont);
                lblHotelLocationTwentytwo.setForeground(Color.WHITE);
                lblHotelLocationTwentytwo.setBounds(20, 320, 310, 70);
                framePaneljapan.add(lblHotelLocationTwentytwo);
                
                lblHotelLocExtTwentytwo = new JLabel("Kamogawa, Kyoto, Japan");
                lblHotelLocExtTwentytwo.setFont(hotelFont);
                lblHotelLocExtTwentytwo.setForeground(Color.WHITE);
                lblHotelLocExtTwentytwo.setBounds(20, 340, 320, 70);
                framePaneljapan.add(lblHotelLocExtTwentytwo);
                
                lblHotelIDTwentytwo = new JLabel("HOTELID:");
                lblHotelIDTwentytwo.setFont(hotelFont);
                lblHotelIDTwentytwo.setForeground(Color.WHITE);
                lblHotelIDTwentytwo.setBounds(20, 360, 320, 70);
                framePaneljapan.add(lblHotelIDTwentytwo);
                
                lblHotelIDExtTwentytwo = new JLabel(" KYT022");
                lblHotelIDExtTwentytwo.setFont(hotelFont);
                lblHotelIDExtTwentytwo.setForeground(Color.WHITE);
                lblHotelIDExtTwentytwo.setBounds(90, 360, 320, 70);
                framePaneljapan.add(lblHotelIDExtTwentytwo);
               
                lblHotelRateTwentytwo = new JLabel("RATING:");
                lblHotelRateTwentytwo.setFont(hotelFont);
                lblHotelRateTwentytwo.setForeground(Color.WHITE);
                lblHotelRateTwentytwo.setBounds(20, 380, 320, 70);
                framePaneljapan.add(lblHotelRateTwentytwo);
                
                lblHotelRateExtTwentytwo = new JLabel("5/5");
                lblHotelRateExtTwentytwo.setFont(hotelFont);
                lblHotelRateExtTwentytwo.setForeground(Color.WHITE);
                lblHotelRateExtTwentytwo.setBounds(90, 380, 320, 70);
                framePaneljapan.add(lblHotelRateExtTwentytwo);

                
                //Image button for Carlton
  
                imgIconjapanCarlton = new ImageIcon("ritzcarltonJapan.jpg");
                Image imgscaleCarlton = imgIconjapanCarlton.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconCarlton = new ImageIcon(imgscaleCarlton);
                btnImgjapanCarlton = new JButton(imgnewiconCarlton);
                btnImgjapanCarlton.setBounds(20, 10, 250, 300);
                btnImgjapanCarlton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
        //JOtionPane (user's preference)
        int btnImgjapanCarlton = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgjapanCarlton == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();        
                                
                    
                        //getText                             
                        String name=lblHotelNameTwentytwo.getText();
                        String location=lblHotelLocExtTwentytwo.getText();
                        String hotelid=lblHotelIDExtTwentytwo.getText();
                        String rate=lblHotelRateExtTwentytwo.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }       
        }
                }
                  }); 
                framePaneljapan.add(btnImgjapanCarlton);
                
                
                
                      //Labels for the information of the hotel
                          //Hoshinoya
                   
                lblHotelNameTwentythree = new JLabel("Hoshinoya");
                lblHotelNameTwentythree.setFont(fontHotelName);
                lblHotelNameTwentythree.setForeground(Color.BLACK);
                lblHotelNameTwentythree.setBounds(325, 300, 320, 70);
                framePaneljapan.add(lblHotelNameTwentythree);
                
                lblHotelLocationTwentythree = new JLabel("LOCATION:");
                lblHotelLocationTwentythree.setFont(hotelFont);
                lblHotelLocationTwentythree.setForeground(Color.WHITE);
                lblHotelLocationTwentythree.setBounds(325, 320, 310, 70);
                framePaneljapan.add(lblHotelLocationTwentythree);
                
                lblHotelLocExtTwentythree = new JLabel("Arashiyama, Kyoto, Japan");
                lblHotelLocExtTwentythree.setFont(hotelFont);
                lblHotelLocExtTwentythree.setForeground(Color.WHITE);
                lblHotelLocExtTwentythree.setBounds(325, 340, 320, 70);
                framePaneljapan.add(lblHotelLocExtTwentythree);
                
                lblHotelIDTwentythree = new JLabel("HOTELID:");
                lblHotelIDTwentythree.setFont(hotelFont);
                lblHotelIDTwentythree.setForeground(Color.WHITE);
                lblHotelIDTwentythree.setBounds(325, 360, 320, 70);
                framePaneljapan.add(lblHotelIDTwentythree);
                
                lblHotelIDExtTwentythree = new JLabel(" KYT023");
                lblHotelIDExtTwentythree.setFont(hotelFont);
                lblHotelIDExtTwentythree.setForeground(Color.WHITE);
                lblHotelIDExtTwentythree.setBounds(395, 360, 320, 70);
                framePaneljapan.add(lblHotelIDExtTwentythree);
               
                lblHotelRateTwentythree = new JLabel("RATING:");
                lblHotelRateTwentythree.setFont(hotelFont);
                lblHotelRateTwentythree.setForeground(Color.WHITE);
                lblHotelRateTwentythree.setBounds(325, 380, 320, 70);
                framePaneljapan.add(lblHotelRateTwentythree);
                
                lblHotelRateExtTwentythree = new JLabel("5/5");
                lblHotelRateExtTwentythree.setFont(hotelFont);
                lblHotelRateExtTwentythree.setForeground(Color.WHITE);
                lblHotelRateExtTwentythree.setBounds(395, 380, 320, 70);
                framePaneljapan.add(lblHotelRateExtTwentythree);
        
                
                
                //Image button for Hoshinoya
               
                imgIconjapanHoshinoya = new ImageIcon("hoshinoyaJapan.jpg");
                Image imgscaleHoshinoya = imgIconjapanHoshinoya.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconHoshinoya = new ImageIcon(imgscaleHoshinoya);
                btnImgjapanHoshinoya = new JButton(imgnewiconHoshinoya);
                btnImgjapanHoshinoya.setBounds(325, 10, 250, 300);
                btnImgjapanHoshinoya.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  
        //JOtionPane (user's preference)
        int btnImgjapanHoshinoya = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgjapanHoshinoya == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();     
                                
                    
                        //getText                             
                        String name=lblHotelNameTwentythree.getText();
                        String location=lblHotelLocExtTwentythree.getText();
                        String hotelid=lblHotelIDExtTwentythree.getText();
                        String rate=lblHotelRateExtTwentythree.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }       
        }
                }
                  }); 
                framePaneljapan.add(btnImgjapanHoshinoya);
                
                
                
                //Labels for the information of the hotel
                    //Aman
                    
                lblHotelNameTwentyfour = new JLabel("Aman");
                lblHotelNameTwentyfour.setFont(fontHotelName);
                lblHotelNameTwentyfour.setForeground(Color.BLACK);
                lblHotelNameTwentyfour.setBounds(630, 300, 320, 70);
                framePaneljapan.add(lblHotelNameTwentyfour);
                
                lblHotelLocationTwentyfour = new JLabel("LOCATION:");
                lblHotelLocationTwentyfour.setFont(hotelFont);
                lblHotelLocationTwentyfour.setForeground(Color.WHITE);
                lblHotelLocationTwentyfour.setBounds(630, 320, 310, 70);
                framePaneljapan.add(lblHotelLocationTwentyfour);
                
                lblHotelLocExtTwentyfour = new JLabel("Okitayama, Kyoto, Japan");
                lblHotelLocExtTwentyfour.setFont(hotelFont);
                lblHotelLocExtTwentyfour.setForeground(Color.WHITE);
                lblHotelLocExtTwentyfour.setBounds(630, 340, 320, 70);
                framePaneljapan.add(lblHotelLocExtTwentyfour);
                
                lblHotelIDTwentyfour = new JLabel("HOTELID:");
                lblHotelIDTwentyfour.setFont(hotelFont);
                lblHotelIDTwentyfour.setForeground(Color.WHITE);
                lblHotelIDTwentyfour.setBounds(630, 360, 320, 70);
                framePaneljapan.add(lblHotelIDTwentyfour);
                
                lblHotelIDExtTwentyfour = new JLabel(" KYT024");
                lblHotelIDExtTwentyfour.setFont(hotelFont);
                lblHotelIDExtTwentyfour.setForeground(Color.WHITE);
                lblHotelIDExtTwentyfour.setBounds(700, 360, 320, 70);
                framePaneljapan.add(lblHotelIDExtTwentyfour);
               
                lblHotelRateTwentyfour = new JLabel("RATING:");
                lblHotelRateTwentyfour.setFont(hotelFont);
                lblHotelRateTwentyfour.setForeground(Color.WHITE);
                lblHotelRateTwentyfour.setBounds(630, 380, 320, 70);
                framePaneljapan.add(lblHotelRateTwentyfour);
                
                lblHotelRateExtTwentyfour = new JLabel("5/5");
                lblHotelRateExtTwentyfour.setFont(hotelFont);
                lblHotelRateExtTwentyfour.setForeground(Color.WHITE);
                lblHotelRateExtTwentyfour.setBounds(700, 380, 320, 70);
                framePaneljapan.add(lblHotelRateExtTwentyfour);
               
                
                
                //Image button for Aman
 
                imgIconjapanAman = new ImageIcon("amanJapan.jpg");
                Image imgscaleAman = imgIconjapanAman.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconAman = new ImageIcon(imgscaleAman);
                btnImgjapanAman = new JButton(imgnewiconAman);
                btnImgjapanAman.setBounds(630, 10, 250, 300);
                btnImgjapanAman.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  
        //JOtionPane (user's preference)
        int btnImgjapanHoshinoya = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgjapanHoshinoya == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();   
                                
                    
                        //getText                             
                        String name=lblHotelNameTwentyfour.getText();
                        String location=lblHotelLocExtTwentyfour.getText();
                        String hotelid=lblHotelIDExtTwentyfour.getText();
                        String rate=lblHotelRateExtTwentyfour.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }       
        }
                }
                  }); 
                framePaneljapan.add(btnImgjapanAman);
                
                
                
               

                //Show the specific panel for location
                    //Italy
               
        } else if 
                (place.equalsIgnoreCase("italy")) {
                layer.removeAll();                
                
                //Panel for the location for Italy
                framePanelitaly = new JPanel();
                framePanelitaly.setBounds(40, 120, 900, 450);
                framePanelitaly.setBackground(new Color(37, 113, 128));
                framePanelitaly.setLayout(null);
                layer.add(framePanelitaly, Integer.valueOf(0));
                
                
                //Labels for the information of the hotel
                      //Russie
                      
                lblHotelNameTwentyfive = new JLabel("Hotel de Russie");
                lblHotelNameTwentyfive.setFont(fontHotelName);
                lblHotelNameTwentyfive.setForeground(Color.BLACK);
                lblHotelNameTwentyfive.setBounds(20, 300, 320, 70);
                framePanelitaly.add(lblHotelNameTwentyfive);
                
                lblHotelLocationTwentyfive = new JLabel("LOCATION:");
                lblHotelLocationTwentyfive.setFont(hotelFont);
                lblHotelLocationTwentyfive.setForeground(Color.WHITE);
                lblHotelLocationTwentyfive.setBounds(20, 320, 310, 70);
                framePanelitaly.add(lblHotelLocationTwentyfive);
                
                lblHotelLocExtTwentyfive = new JLabel("Via del Babuino, Rome, Italy");
                lblHotelLocExtTwentyfive.setFont(hotelFont);
                lblHotelLocExtTwentyfive.setForeground(Color.WHITE);
                lblHotelLocExtTwentyfive.setBounds(20, 340, 320, 70);
                framePanelitaly.add(lblHotelLocExtTwentyfive);
                
                lblHotelIDTwentyfive = new JLabel("HOTELID:");
                lblHotelIDTwentyfive.setFont(hotelFont);
                lblHotelIDTwentyfive.setForeground(Color.WHITE);
                lblHotelIDTwentyfive.setBounds(20, 360, 320, 70);
                framePanelitaly.add(lblHotelIDTwentyfive);
                
                lblHotelIDExtTwentyfive = new JLabel(" ROM025");
                lblHotelIDExtTwentyfive.setFont(hotelFont);
                lblHotelIDExtTwentyfive.setForeground(Color.WHITE);
                lblHotelIDExtTwentyfive.setBounds(90, 360, 320, 70);
                framePanelitaly.add(lblHotelIDExtTwentyfive);
               
                lblHotelRateTwentyfive = new JLabel("RATING:");
                lblHotelRateTwentyfive.setFont(hotelFont);
                lblHotelRateTwentyfive.setForeground(Color.WHITE);
                lblHotelRateTwentyfive.setBounds(20, 380, 320, 70);
                framePanelitaly.add(lblHotelRateTwentyfive);
                
                lblHotelRateExtTwentyfive = new JLabel("5/5");
                lblHotelRateExtTwentyfive.setFont(hotelFont);
                lblHotelRateExtTwentyfive.setForeground(Color.WHITE);
                lblHotelRateExtTwentyfive.setBounds(90, 380, 320, 70);
                framePanelitaly.add(lblHotelRateExtTwentyfive);
               
                
                //Image button for Russie
   
                imgIconitalyRussie = new ImageIcon("russieItaly.jpg");
                Image imgscaleRussie = imgIconitalyRussie.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconRussie = new ImageIcon(imgscaleRussie);
                btnImgitalyRussie = new JButton(imgnewiconRussie);
                btnImgitalyRussie.setBounds(20, 10, 250, 300);
                btnImgitalyRussie.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  
        //JOtionPane (user's preference)
        int btnImgitalyRussie = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgitalyRussie == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();     
                                
                    
                        //getText                             
                        String name=lblHotelNameTwentyfive.getText();
                        String location=lblHotelLocExtTwentyfive.getText();
                        String hotelid=lblHotelIDExtTwentyfive.getText();
                        String rate=lblHotelRateExtTwentyfive.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }       
        }
                }
                  }); 
                framePanelitaly.add(btnImgitalyRussie);
                
                
                
                //Labels for the information of the hotel
                     //Eden
                     
                lblHotelNameTwentysix = new JLabel("Hotel Eden");
                lblHotelNameTwentysix.setFont(fontHotelName);
                lblHotelNameTwentysix.setForeground(Color.BLACK);
                lblHotelNameTwentysix.setBounds(325, 300, 320, 70);
                framePanelitaly.add(lblHotelNameTwentysix);
                
                lblHotelLocationTwentysix = new JLabel("LOCATION:");
                lblHotelLocationTwentysix.setFont(hotelFont);
                lblHotelLocationTwentysix.setForeground(Color.WHITE);
                lblHotelLocationTwentysix.setBounds(325, 320, 310, 70);
                framePanelitaly.add(lblHotelLocationTwentysix);
                
                lblHotelLocExtTwentysix = new JLabel("Via Ludovisi, Rome, Italy");
                lblHotelLocExtTwentysix.setFont(hotelFont);
                lblHotelLocExtTwentysix.setForeground(Color.WHITE);
                lblHotelLocExtTwentysix.setBounds(325, 340, 320, 70);
                framePanelitaly.add(lblHotelLocExtTwentysix);
                
                lblHotelIDTwentysix = new JLabel("HOTELID:");
                lblHotelIDTwentysix.setFont(hotelFont);
                lblHotelIDTwentysix.setForeground(Color.WHITE);
                lblHotelIDTwentysix.setBounds(325, 360, 320, 70);
                framePanelitaly.add(lblHotelIDTwentysix);
                
                lblHotelIDExtTwentysix = new JLabel(" ROM026");
                lblHotelIDExtTwentysix.setFont(hotelFont);
                lblHotelIDExtTwentysix.setForeground(Color.WHITE);
                lblHotelIDExtTwentysix.setBounds(395, 360, 320, 70);
                framePanelitaly.add(lblHotelIDExtTwentysix);
               
                lblHotelRateTwentysix = new JLabel("RATING:");
                lblHotelRateTwentysix.setFont(hotelFont);
                lblHotelRateTwentysix.setForeground(Color.WHITE);
                lblHotelRateTwentysix.setBounds(325, 380, 320, 70);
                framePanelitaly.add(lblHotelRateTwentysix);
                
                lblHotelRateExtTwentysix = new JLabel("5/5");
                lblHotelRateExtTwentysix.setFont(hotelFont);
                lblHotelRateExtTwentysix.setForeground(Color.WHITE);
                lblHotelRateExtTwentysix.setBounds(395, 380, 320, 70);
                framePanelitaly.add(lblHotelRateExtTwentysix);
                
            
                //Image button for Eden
   
                imgIconitalyEden = new ImageIcon("edenItaly.jpg");
                Image imgscaleEden = imgIconitalyEden.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconEden = new ImageIcon(imgscaleEden);
                btnImgitalyEden = new JButton(imgnewiconEden);
                btnImgitalyEden.setBounds(325, 10, 250, 300);
                btnImgitalyEden.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
        //JOtionPane (user's preference)
        int btnImgitalyEden = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgitalyEden == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();       
                                
                        
                        //getText                             
                        String name=lblHotelNameTwentysix.getText();
                        String location=lblHotelLocExtTwentysix.getText();
                        String hotelid=lblHotelIDExtTwentysix.getText();
                        String rate=lblHotelRateExtTwentysix.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }       
        }
                }
                  }); 
                framePanelitaly.add(btnImgitalyEden);
                
                
                //Labels for the information of the hotel
                  //Regis
                  
                lblHotelNameTwentyseven = new JLabel("The St. Regis");
                lblHotelNameTwentyseven.setFont(fontHotelName);
                lblHotelNameTwentyseven.setForeground(Color.BLACK);
                lblHotelNameTwentyseven.setBounds(630, 300, 320, 70);
                framePanelitaly.add(lblHotelNameTwentyseven);
                
                lblHotelLocationTwentyseven = new JLabel("LOCATION:");
                lblHotelLocationTwentyseven.setFont(hotelFont);
                lblHotelLocationTwentyseven.setForeground(Color.WHITE);
                lblHotelLocationTwentyseven.setBounds(630, 320, 310, 70);
                framePanelitaly.add(lblHotelLocationTwentyseven);
                
                lblHotelLocExtTwentyseven = new JLabel("Orlando, Rome, Italy");
                lblHotelLocExtTwentyseven.setFont(hotelFont);
                lblHotelLocExtTwentyseven.setForeground(Color.WHITE);
                lblHotelLocExtTwentyseven.setBounds(630, 340, 320, 70);
                framePanelitaly.add(lblHotelLocExtTwentyseven);
                
                lblHotelIDTwentyseven = new JLabel("HOTELID:");
                lblHotelIDTwentyseven.setFont(hotelFont);
                lblHotelIDTwentyseven.setForeground(Color.WHITE);
                lblHotelIDTwentyseven.setBounds(630, 360, 320, 70);
                framePanelitaly.add(lblHotelIDTwentyseven);
                
                lblHotelIDExtTwentyseven = new JLabel(" ROM027");
                lblHotelIDExtTwentyseven.setFont(hotelFont);
                lblHotelIDExtTwentyseven.setForeground(Color.WHITE);
                lblHotelIDExtTwentyseven.setBounds(700, 360, 320, 70);
                framePanelitaly.add(lblHotelIDExtTwentyseven);
               
                lblHotelRateTwentyseven = new JLabel("RATING:");
                lblHotelRateTwentyseven.setFont(hotelFont);
                lblHotelRateTwentyseven.setForeground(Color.WHITE);
                lblHotelRateTwentyseven.setBounds(630, 380, 320, 70);
                framePanelitaly.add(lblHotelRateTwentyseven);
                
                lblHotelRateExtTwentyseven = new JLabel("5/5");
                lblHotelRateExtTwentyseven.setFont(hotelFont);
                lblHotelRateExtTwentyseven.setForeground(Color.WHITE);
                lblHotelRateExtTwentyseven.setBounds(700, 380, 320, 70);
                framePanelitaly.add(lblHotelRateExtTwentyseven);
                
                
                //Image button for Regis
    
                imgIconitalyRegis = new ImageIcon("regisItaly.jpg");
                Image imgscaleRegis = imgIconitalyRegis.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconRegis = new ImageIcon(imgscaleRegis);
                btnImgitalyRegis = new JButton(imgnewiconRegis);
                btnImgitalyRegis.setBounds(630, 10, 250, 300);
                btnImgitalyRegis.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
        //JOtionPane (user's preference)
        int btnImgitalyRegis = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgitalyRegis == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();                              
                        
                        
                        //getText                             
                        String name=lblHotelNameTwentyseven.getText();
                        String location=lblHotelLocExtTwentyseven.getText();
                        String hotelid=lblHotelIDExtTwentyseven.getText();
                        String rate=lblHotelRateExtTwentyseven.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }       
        }
                }
                  }); 
                framePanelitaly.add(btnImgitalyRegis);

                
               
                //Show the specific panel for location
                    //South Korea
                
        } else if 
                (place.equalsIgnoreCase("south korea")) {
                layer.removeAll();                
                
                //Panel for the location for South Korea
                framePanelsouthkorea = new JPanel();
                framePanelsouthkorea.setBounds(40, 120, 900, 450);
                framePanelsouthkorea.setBackground(new Color(37, 113, 128));
                framePanelsouthkorea.setLayout(null);
                layer.add(framePanelsouthkorea, Integer.valueOf(0));
                
 
                //Labels for the information of the hotel
                    //Four Season
                    
                lblHotelNameTwentyeight = new JLabel("Four Seasons Hotel");
                lblHotelNameTwentyeight.setFont(fontHotelName);
                lblHotelNameTwentyeight.setForeground(Color.BLACK);
                lblHotelNameTwentyeight.setBounds(20, 300, 320, 70);
                framePanelsouthkorea.add(lblHotelNameTwentyeight);
                
                lblHotelLocationTwentyeight = new JLabel("LOCATION:");
                lblHotelLocationTwentyeight.setFont(hotelFont);
                lblHotelLocationTwentyeight.setForeground(Color.WHITE);
                lblHotelLocationTwentyeight.setBounds(20, 320, 310, 70);
                framePanelsouthkorea.add(lblHotelLocationTwentyeight);
                
                lblHotelLocExtTwentyeight = new JLabel("Saemunan-ro, Seoul, South Korea");
                lblHotelLocExtTwentyeight.setFont(hotelFont);
                lblHotelLocExtTwentyeight.setForeground(Color.WHITE);
                lblHotelLocExtTwentyeight.setBounds(20, 340, 320, 70);
                framePanelsouthkorea.add(lblHotelLocExtTwentyeight);
                
                lblHotelIDTwentyeight = new JLabel("HOTELID:");
                lblHotelIDTwentyeight.setFont(hotelFont);
                lblHotelIDTwentyeight.setForeground(Color.WHITE);
                lblHotelIDTwentyeight.setBounds(20, 360, 320, 70);
                framePanelsouthkorea.add(lblHotelIDTwentyeight);
                
                lblHotelIDExtTwentyeight = new JLabel(" SEO028");
                lblHotelIDExtTwentyeight.setFont(hotelFont);
                lblHotelIDExtTwentyeight.setForeground(Color.WHITE);
                lblHotelIDExtTwentyeight.setBounds(90, 360, 320, 70);
                framePanelsouthkorea.add(lblHotelIDExtTwentyeight);
               
                lblHotelRateTwentyeight = new JLabel("RATING:");
                lblHotelRateTwentyeight.setFont(hotelFont);
                lblHotelRateTwentyeight.setForeground(Color.WHITE);
                lblHotelRateTwentyeight.setBounds(20, 380, 320, 70);
                framePanelsouthkorea.add(lblHotelRateTwentyeight);
                
                lblHotelRateExtTwentyeight = new JLabel("5/5");
                lblHotelRateExtTwentyeight.setFont(hotelFont);
                lblHotelRateExtTwentyeight.setForeground(Color.WHITE);
                lblHotelRateExtTwentyeight.setBounds(90, 380, 320, 70);
                framePanelsouthkorea.add(lblHotelRateExtTwentyeight);

                
                    
                //Image button for FS
  
                imgIconsouthkoreaFS = new ImageIcon("seasonsSK.jpg");
                Image imgscaleFS = imgIconsouthkoreaFS.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconFS = new ImageIcon(imgscaleFS);
                btnImgsouthkoreaFS = new JButton(imgnewiconFS);
                btnImgsouthkoreaFS.setBounds(20, 10, 250, 300);
                btnImgsouthkoreaFS.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
        //JOtionPane (user's preference)
        int btnImgsouthkoreaFS = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgsouthkoreaFS == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();    
                                
                        
                        //getText                             
                        String name=lblHotelNameTwentyeight.getText();
                        String location=lblHotelLocExtTwentyeight.getText();
                        String hotelid=lblHotelIDExtTwentyeight.getText();
                        String rate=lblHotelRateExtTwentyeight.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }       
        }
                }
                  }); 
                framePanelsouthkorea.add(btnImgsouthkoreaFS);
                
                
               
                //Labels for the information of the hotel
                    //Shilla
                    
                lblHotelNameTwentynine = new JLabel("The Shilla");
                lblHotelNameTwentynine.setFont(fontHotelName);
                lblHotelNameTwentynine.setForeground(Color.BLACK);
                lblHotelNameTwentynine.setBounds(325, 300, 320, 70);
                framePanelsouthkorea.add(lblHotelNameTwentynine);
                
                lblHotelLocationTwentynine = new JLabel("LOCATION:");
                lblHotelLocationTwentynine.setFont(hotelFont);
                lblHotelLocationTwentynine.setForeground(Color.WHITE);
                lblHotelLocationTwentynine.setBounds(325, 320, 310, 70);
                framePanelsouthkorea.add(lblHotelLocationTwentynine);
                
                lblHotelLocExtTwentynine = new JLabel("249 Dongho-ro, Seoul, South Korea");
                lblHotelLocExtTwentynine.setFont(hotelFont);
                lblHotelLocExtTwentynine.setForeground(Color.WHITE);
                lblHotelLocExtTwentynine.setBounds(325, 340, 320, 70);
                framePanelsouthkorea.add(lblHotelLocExtTwentynine);
                
                lblHotelIDTwentynine = new JLabel("HOTELID:");
                lblHotelIDTwentynine.setFont(hotelFont);
                lblHotelIDTwentynine.setForeground(Color.WHITE);
                lblHotelIDTwentynine.setBounds(325, 360, 320, 70);
                framePanelsouthkorea.add(lblHotelIDTwentynine);
                
                lblHotelIDExtTwentynine = new JLabel(" SEO029");
                lblHotelIDExtTwentynine.setFont(hotelFont);
                lblHotelIDExtTwentynine.setForeground(Color.WHITE);
                lblHotelIDExtTwentynine.setBounds(395, 360, 320, 70);
                framePanelsouthkorea.add(lblHotelIDExtTwentynine);
               
                lblHotelRateTwentynine = new JLabel("RATING:");
                lblHotelRateTwentynine.setFont(hotelFont);
                lblHotelRateTwentynine.setForeground(Color.WHITE);
                lblHotelRateTwentynine.setBounds(325, 380, 320, 70);
                framePanelsouthkorea.add(lblHotelRateTwentynine);
                
                lblHotelRateExtTwentynine = new JLabel("5/5");
                lblHotelRateExtTwentynine.setFont(hotelFont);
                lblHotelRateExtTwentynine.setForeground(Color.WHITE);
                lblHotelRateExtTwentynine.setBounds(395, 380, 320, 70);
                framePanelsouthkorea.add(lblHotelRateExtTwentynine);
                
                
                //Image button for Shilla
 
                imgIconsouthkoreaShilla = new ImageIcon("shillaSK.jpg");
                Image imgscaleShilla = imgIconsouthkoreaShilla.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconShilla = new ImageIcon(imgscaleShilla);
                btnImgsouthkoreaShilla = new JButton(imgnewiconShilla);
                btnImgsouthkoreaShilla.setBounds(325, 10, 250, 300);
                btnImgsouthkoreaShilla.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
                    
        //JOtionPane (user's preference)
        int btnImgsouthkoreaShilla = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgsouthkoreaShilla == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();       
                                
                                
                        
                        //getText                             
                        String name=lblHotelNameTwentynine.getText();
                        String location=lblHotelLocExtTwentynine.getText();
                        String hotelid=lblHotelIDExtTwentynine.getText();
                        String rate=lblHotelRateExtTwentynine.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }    
        }
                }
                  }); 
                framePanelsouthkorea.add(btnImgsouthkoreaShilla);
                
                
                
                //Labels for the information of the hotel
                    //Signiel
                    
                lblHotelNameThirty = new JLabel("Signiel");
                lblHotelNameThirty.setFont(fontHotelName);
                lblHotelNameThirty.setForeground(Color.BLACK);
                lblHotelNameThirty.setBounds(630, 300, 320, 70);
                framePanelsouthkorea.add(lblHotelNameThirty);
                
                lblHotelLocationThirty = new JLabel("LOCATION:");
                lblHotelLocationThirty.setFont(hotelFont);
                lblHotelLocationThirty.setForeground(Color.WHITE);
                lblHotelLocationThirty.setBounds(630, 320, 310, 70);
                framePanelsouthkorea.add(lblHotelLocationThirty);
                
                lblHotelLocExtThirty = new JLabel("300 Olympic-ro, Seoul, South Korea");
                lblHotelLocExtThirty.setFont(hotelFont);
                lblHotelLocExtThirty.setForeground(Color.WHITE);
                lblHotelLocExtThirty.setBounds(630, 340, 320, 70);
                framePanelsouthkorea.add(lblHotelLocExtThirty);
                
                lblHotelIDThirty = new JLabel("HOTELID:");
                lblHotelIDThirty.setFont(hotelFont);
                lblHotelIDThirty.setForeground(Color.WHITE);
                lblHotelIDThirty.setBounds(630, 360, 320, 70);
                framePanelsouthkorea.add(lblHotelIDThirty);
                
                lblHotelIDExtThirty = new JLabel(" SEO030");
                lblHotelIDExtThirty.setFont(hotelFont);
                lblHotelIDExtThirty.setForeground(Color.WHITE);
                lblHotelIDExtThirty.setBounds(700, 360, 320, 70);
                framePanelsouthkorea.add(lblHotelIDExtThirty);
               
                lblHotelRateThirty = new JLabel("RATING:");
                lblHotelRateThirty.setFont(hotelFont);
                lblHotelRateThirty.setForeground(Color.WHITE);
                lblHotelRateThirty.setBounds(630, 380, 320, 70);
                framePanelsouthkorea.add(lblHotelRateThirty);
                
                lblHotelRateExtThirty = new JLabel("4.5/5");
                lblHotelRateExtThirty.setFont(hotelFont);
                lblHotelRateExtThirty.setForeground(Color.WHITE);
                lblHotelRateExtThirty.setBounds(700, 380, 320, 70);
                framePanelsouthkorea.add(lblHotelRateExtThirty);
                
                
                //Image button for Signiel
 
                imgIconsouthkoreaSigniel = new ImageIcon("signielSK.jpg");
                Image imgscaleSigniel = imgIconsouthkoreaSigniel.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imgnewiconSigniel = new ImageIcon(imgscaleSigniel);
                btnImgsouthkoreaSigniel = new JButton(imgnewiconSigniel);
                btnImgsouthkoreaSigniel.setBounds(630, 10, 250, 300);
                btnImgsouthkoreaSigniel.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   
                   
        //JOtionPane (user's preference)
        int btnImgsouthkoreaSigniel = JOptionPane.showConfirmDialog(Hotel.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (btnImgsouthkoreaSigniel == JOptionPane.YES_OPTION) {
            dispose();
                    
                          
                                //new BookingFormTwo();                     
                   
                                
                        //getText                             
                        String name=lblHotelNameThirty.getText();
                        String location=lblHotelLocExtThirty.getText();
                        String hotelid=lblHotelIDExtThirty.getText();
                        String rate=lblHotelRateExtThirty.getText();
                                               
                        try{
                           pst = con.prepareStatement("insert into hotelinfo (name,location,hotelid,rate) values (?,?,?,?)");
                           pst.setString(1,name);
                           pst.setString(2,location);
                           pst.setString(3,hotelid);
                           pst.setString(4,rate);
                        
                           pst.executeUpdate();
                           
                        }catch (Exception a){
                        a.printStackTrace();
                    }       
        }
                }
                  }); 
                framePanelsouthkorea.add(btnImgsouthkoreaSigniel);  
                }
                
                
        else if(place.isEmpty()){
            
                JOptionPane.showMessageDialog(this, "Please Enter Your Destination First", "ERROR", JOptionPane.ERROR_MESSAGE);      
            
        }
            
                //JOption if the search bar delivered is empty 
         else {
                JOptionPane.showMessageDialog(this, "Place is still not available", "ERROR", JOptionPane.ERROR_MESSAGE);
                                
            }        
            }  
        
        }
  
    //connecting to sql
    
    public void Connect(){
  
        String url = "jdbc:mysql://localhost:3306/groupninedsaproject";
            String username = "root";
            String password = "admin123";
                       
        try {
          con=(Connection) DriverManager.getConnection(url, username, password);
       
        } catch (SQLException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }

