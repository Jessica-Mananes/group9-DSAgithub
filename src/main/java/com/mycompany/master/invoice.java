package com.mycompany.master;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author ASUS X441U
 */
public class invoice extends JFrame implements ActionListener{
//    private ImageIcon imgLogo,imgnewLogo;
    private JButton btnClose, btnPrint;
    private JLabel lblLogo, lblDash, lblBookingID, lblDateTime, lblDash1, lblContactNum, lblDash2, 
            lblFlightInfo, lblPrice,lblDestination, lblFlightID, lblClass, lblDash3, lblHotelInfo,
            lblHotelD, lblHotelPrice, lblLocation, lblRoom, lblDash4, lblTotal, lblDash5, lblThankyou, lblDash6, 
            
            lblBookingIdInvoice, lblTimeCreatedInvoice, lblFlightPriceInvoice, lblFlightIDInvoice, lblDestinationInvoice, lblFlightClassInvoice,
            lblHotelPriceInvoice, lblHotelIDInvoice, lblLocationInvoice, 
            lblRoomPreferenceInvoice, lblTotalAmountInvoice;

    private Connection con;
    private PreparedStatement pst;
    
   
    invoice () {
        Connect();
        setSize(550, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Invoice");
        setLocationRelativeTo(null);
        setUndecorated(true);
        getContentPane().setBackground(new Color(253, 252, 233));       
        
        ImageIcon imageIcon = new ImageIcon("invoicelogo.png");
        Image imageScale = imageIcon.getImage().getScaledInstance(90, 70, Image.SCALE_SMOOTH);
        ImageIcon imageNew = new ImageIcon(imageScale);
       
         
        //Invoice Label 
        lblLogo = new JLabel(imageNew);
        lblLogo.setBounds(215, 25, 90, 70);
        lblLogo.setBackground(new Color(253, 252, 233));       
        
        
        add(lblLogo);
        
        lblDash = new JLabel("------------------------------------");
        lblDash.setBounds(50, 65, 500, 80);
        lblDash.setForeground(new Color (128,128,128));
        lblDash.setFont(new Font("Monospaced", Font.PLAIN, 20));
        add(lblDash);
        
        lblDateTime = new JLabel("CITE: Computer Information Technology and Engineering");
        lblDateTime.setBounds(51, 80, 500, 80);
        lblDateTime.setForeground(new Color (105,105,105));
        lblDateTime.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblDateTime); 
     
        
        lblContactNum = new JLabel("+639919130826");
        lblContactNum.setBounds(210, 100, 500, 80);
        lblContactNum.setForeground(new Color (105,105,105));
        lblContactNum.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblContactNum);
        
        lblDash1 = new JLabel("------------------------------------");
        lblDash1.setBounds(50, 115, 500, 80);
        lblDash1.setForeground(new Color (128,128,128));
        lblDash1.setFont(new Font("Monospaced", Font.PLAIN, 20));
        add(lblDash1);
        
        lblBookingID = new JLabel("Booking ID: ");
        lblBookingID.setBounds(50, 135, 500, 80);
        lblBookingID.setForeground(new Color (105,105,105));
        lblBookingID.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblBookingID);
        
        lblBookingIdInvoice = new JLabel("");
        lblBookingIdInvoice.setBounds(150, 135, 500, 80);
        add(lblBookingIdInvoice);
        
       
        lblDateTime = new JLabel("Date & Time: ");
        lblDateTime.setBounds(50, 155, 500, 80);
        lblDateTime.setForeground(new Color (105,105,105));
        lblDateTime.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblDateTime);
        
        lblTimeCreatedInvoice = new JLabel("");
        lblTimeCreatedInvoice.setBounds(150, 155, 500, 80);
        add(lblTimeCreatedInvoice);
        
        
        lblDash2 = new JLabel("------------------------------------");
        lblDash2.setBounds(50, 175, 500, 80);
        lblDash2.setForeground(new Color (128,128,128));
        lblDash2.setFont(new Font("Monospaced", Font.PLAIN, 20));
        add(lblDash2);
        
        lblFlightInfo = new JLabel("FLIGHT INFORMATION");
        lblFlightInfo.setBounds(50, 195, 500, 80);
        lblFlightInfo.setForeground(new Color (105,105,105));
        lblFlightInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
        add(lblFlightInfo);
        
        
        lblPrice = new JLabel("PRICE");
        lblPrice.setBounds(390, 195, 500, 80);
        lblPrice.setForeground(new Color (105,105,105));
        lblPrice.setFont(new Font("Monospaced", Font.PLAIN, 15));
        add(lblPrice);
        
        lblFlightPriceInvoice = new JLabel("");
        lblFlightPriceInvoice.setBounds(390, 300, 500, 80);
        add(lblFlightPriceInvoice);
        
        
        lblFlightID = new JLabel("FlightID: ");
        lblFlightID.setBounds(50, 225, 500, 80);
        lblFlightID.setForeground(new Color (105,105,105));
        lblFlightID.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblFlightID);
        
        lblFlightIDInvoice = new JLabel("");
        lblFlightIDInvoice.setBounds(125, 225, 500, 80);
        add(lblFlightIDInvoice);
        
       
        
        lblDestination = new JLabel("Destination: ");
        lblDestination.setBounds(50, 245, 500, 80);
        lblDestination.setForeground(new Color (105,105,105));
        lblDestination.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblDestination);
        
        lblDestinationInvoice = new JLabel("");
        lblDestinationInvoice.setBounds(150, 245, 500, 80);
        add(lblDestinationInvoice);
        
        lblClass = new JLabel("Flight Class: ");
        lblClass.setBounds(50, 265, 500, 80);
        lblClass.setForeground(new Color (105,105,105));
        lblClass.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblClass);
        
        lblFlightClassInvoice = new JLabel("");
        lblFlightClassInvoice.setBounds(155, 265, 500, 80);
        add(lblFlightClassInvoice);
        
        lblDash3 = new JLabel("------------------------------------");
        lblDash3.setBounds(50, 315, 500, 80);
        lblDash3.setForeground(new Color (128,128,128));
        lblDash3.setFont(new Font("Monospaced", Font.PLAIN, 20));
        add(lblDash3);
        
        lblHotelInfo = new JLabel("HOTEL INFORMATION");
        lblHotelInfo.setBounds(50,335, 500, 80);
        lblHotelInfo.setForeground(new Color (105,105,105));
        lblHotelInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
        add(lblHotelInfo);
        
        lblHotelPrice = new JLabel("PRICE");
        lblHotelPrice.setBounds(390, 335, 500, 80);
        lblHotelPrice.setForeground(new Color (105,105,105));
        lblHotelPrice.setFont(new Font("Monospaced", Font.PLAIN, 15));
        add(lblHotelPrice);
        
        lblHotelPriceInvoice = new JLabel("");
        lblHotelPriceInvoice.setBounds(390, 440, 500, 80);
        add(lblHotelPriceInvoice);
        
        lblHotelD = new JLabel("HotelID: ");
        lblHotelD.setBounds(50,365, 500, 80);
        lblHotelD.setForeground(new Color (105,105,105));
        lblHotelD.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblHotelD);
        
        lblHotelIDInvoice = new JLabel("");
        lblHotelIDInvoice.setBounds(120, 365, 500, 80);
        add(lblHotelIDInvoice);
        
        lblLocation = new JLabel("Location: ");
        lblLocation.setBounds(50,385, 500, 80);
        lblLocation.setForeground(new Color (105,105,105));
        lblLocation.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblLocation);
        
        lblLocationInvoice = new JLabel("");
        lblLocationInvoice.setBounds(125, 385, 500, 80);
        add(lblLocationInvoice);
        
        lblRoom = new JLabel("Room Preference: ");
        lblRoom.setBounds(50, 405, 500, 80);
        lblRoom.setForeground(new Color (105,105,105));
        lblRoom.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblRoom);
        
        lblRoomPreferenceInvoice = new JLabel("");
        lblRoomPreferenceInvoice.setBounds(180, 405, 500, 80);
        add(lblRoomPreferenceInvoice);
        
        lblDash4 = new JLabel("------------------------------------");
        lblDash4.setBounds(50, 455, 500, 80);
        lblDash4.setForeground(new Color (128,128,128));
        lblDash4.setFont(new Font("Monospaced", Font.PLAIN, 20));
        add(lblDash4);
        
        lblTotal = new JLabel("Total Amount: " );
        lblTotal.setBounds(50, 475, 500, 80);
        lblTotal.setForeground(new Color (105,105,105));
        lblTotal.setFont(new Font("Monospaced", Font.PLAIN, 15));
        add(lblTotal);
        
        lblTotalAmountInvoice = new JLabel("");
        lblTotalAmountInvoice.setBounds(390, 475, 500, 80);
        add(lblTotalAmountInvoice);
        
        lblDash5 = new JLabel("------------------------------------");
        lblDash5.setBounds(50, 495, 500, 80);
        lblDash5.setForeground(new Color (128,128,128));
        lblDash5.setFont(new Font("Monospaced", Font.PLAIN, 20));
        add(lblDash5);
        
        lblThankyou = new JLabel("THANK YOU FOR FLYING WITH US!");
        lblThankyou.setBounds(70, 525, 500, 80);
        lblThankyou.setForeground(new Color (105,105,105));    
        lblThankyou.setFont(new Font("Monospaced", Font.PLAIN, 23));
        add(lblThankyou);
        
        lblDash6 = new JLabel("------------------------------------");
        lblDash6.setBounds(50, 555, 500, 80);
        lblDash6.setForeground(new Color (128,128,128));
        lblDash6.setFont(new Font("Monospaced", Font.PLAIN, 20));
        add(lblDash6);
        
        //Close button
        btnClose = new JButton("CLOSE");
        btnClose.setBounds(400, 630, 80, 25);
        btnClose.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnClose.setForeground(new Color(253, 252, 233));
        btnClose.setBackground(new Color(37, 113, 128));
        btnClose.setVisible (false);
        add(btnClose);
        
        
        btnPrint = new JButton("PRINT");
        btnPrint.setBounds(400, 630, 80, 25);
        btnPrint.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnPrint.setForeground(new Color(253, 252, 233));
        btnPrint.setBackground(new Color(37, 113, 128));
        add(btnPrint);
        
        btnClose.addActionListener(this);
        btnPrint.addActionListener(this);
        setVisible(true);
        
    }
 public void Connect(){
    String url = "jdbc:mysql://localhost:3306/groupninedsaproject";
    String username = "root";
    String password = "admin123";
    
    
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      
        if (e.getSource() == btnPrint){
            btnPrint.setVisible(false);
            btnClose.setVisible(true);
            String bookingid = lblBookingIdInvoice.getText();
            if(bookingid.isEmpty()){
            
            
        
        try { String query = "SELECT BookingID, TimeCreated, FlightPrice, FlightID, Destination, TravelClass, HotelPrice, HotelID, HotelLocation, RoomPreference, TotalCost"
                + "  FROM bookinfo ORDER BY TimeCreated DESC LIMIT 1"; // Adjust the query as needed
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
                    if (rs.next()) {
                        String BookingID = rs.getString("BookingID");
                        String timecreated = rs.getString("TimeCreated");
                        String flightprice = rs.getString("flightprice");
                        String flightid = rs.getString("FlightID");
                        String destination = rs.getString("Destination");
                        String travelclass = rs.getString("TravelClass");
                        String hotelprice = rs.getString("HotelPrice");
                        String hotelid = rs.getString("HotelID");
                        String hotellocation = rs.getString("HotelLocation");
                        String roompreference = rs.getString("RoomPreference");
                        String totalcost = rs.getString("TotalCost");
                        
                        lblBookingIdInvoice.setText(BookingID);
                        lblTimeCreatedInvoice.setText(timecreated);
                        lblFlightPriceInvoice.setText(flightprice);
                        lblFlightIDInvoice.setText(flightid);
                        lblDestinationInvoice.setText(destination);
                        lblFlightClassInvoice.setText(travelclass);
                        lblHotelPriceInvoice.setText(hotelprice);
                        lblHotelIDInvoice.setText(hotelid);
                        lblLocationInvoice.setText(hotellocation);
                        lblRoomPreferenceInvoice.setText(roompreference);
                        lblTotalAmountInvoice.setText(totalcost);
       
                        
                    }
                    } 
                 catch (SQLException ex) {
                    ex.printStackTrace();
}
            
        }}
            if(e.getSource() == btnClose){
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "THANK YOU!", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION){
                        new ItineraryTravel();
                        dispose();
 
                
            }
        }
    }
}
       
     
           
         