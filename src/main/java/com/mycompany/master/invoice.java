/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.master;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author ASUS X441U
 */
public class invoice extends JFrame implements ActionListener{
    private ImageIcon imgLogo,imgnewLogo;
    private URL imageLogo;
    private JButton btnClose;
    private JLabel lblLogo, lblDash, lblBookingID, lblDateTime, lblDash1, lblContactNum, lblDash2, 
            lblFlightInfo, lblPrice,lblDestination, lblFlightID, lblClass, lblDash3, lblHotelInfo,
            lblHotelD, lblHotelPrice, lblLocation, lblRoom, lblDash4, lblTotal, lblDash5, lblThankyou, lblDash6;
    
    invoice () {
        
        setSize(550, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Invoice");
        setLocationRelativeTo(null);
        setUndecorated(true);
        getContentPane().setBackground(new Color(253, 252, 233));       
        
        //Image Icon for logo
        try {
            imageLogo = new URL("https://i.pinimg.com/736x/3d/49/72/3d4972edebca280a6a786632df8d37a2.jpg");
        } catch (MalformedURLException ex) {
            Logger.getLogger(invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        imgLogo = new ImageIcon(imageLogo);
        Image imgScaleLogo = imgLogo.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH);
        imgnewLogo = new ImageIcon(imgScaleLogo);
         
        //Invoice Label 
        lblLogo = new JLabel(imgnewLogo);
        lblLogo.setBounds(215, 25, 100, 70);
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
       
        lblDateTime = new JLabel("Date & Time: ");
        lblDateTime.setBounds(50, 155, 500, 80);
        lblDateTime.setForeground(new Color (105,105,105));
        lblDateTime.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblDateTime);
        
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
        
        lblFlightID = new JLabel("FlightID: ");
        lblFlightID.setBounds(50, 225, 500, 80);
        lblFlightID.setForeground(new Color (105,105,105));
        lblFlightID.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblFlightID);
        
        lblDestination = new JLabel("Destination: ");
        lblDestination.setBounds(50, 245, 500, 80);
        lblDestination.setForeground(new Color (105,105,105));
        lblDestination.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblDestination);
        
        lblClass = new JLabel("Flight Class: ");
        lblClass.setBounds(50, 265, 500, 80);
        lblClass.setForeground(new Color (105,105,105));
        lblClass.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblClass);
        
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
        
        lblHotelD = new JLabel("HotelID: ");
        lblHotelD.setBounds(50,365, 500, 80);
        lblHotelD.setForeground(new Color (105,105,105));
        lblHotelD.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblHotelD);
        
        lblLocation = new JLabel("Location: ");
        lblLocation.setBounds(50,385, 500, 80);
        lblLocation.setForeground(new Color (105,105,105));
        lblLocation.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblLocation);
        
        lblRoom = new JLabel("Room Preference: ");
        lblRoom.setBounds(50, 405, 500, 80);
        lblRoom.setForeground(new Color (105,105,105));
        lblRoom.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(lblRoom);
        
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
        add(btnClose);
        
        btnClose.addActionListener(this);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int close = JOptionPane.showConfirmDialog(this, "Are you sure you want to close?", "Invoice Receipt", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         
        if(close == JOptionPane.YES_NO_OPTION){
            this.dispose();
        } 
    }
}