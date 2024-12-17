/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.master;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Darrel
 */
public class BookingFormTwo extends JFrame implements ActionListener{
    private JTextField txtFirstName, txtLastName, txtUserID, txtPhoneNumber,txtCheckInDate, txtCheckOutDate, txtCheckInTime,txtCheckOutTime,txtFlightID,
                       txtDestination,txtDeparture,txtTravelClass,txtArrival,txtPrice,txtHotelID,txtHotelName,txtLocation,txtRating,txtHotelPrice;
    private JButton btnSubmit;
    private JLabel lblTitle,lblBookingID,lblFirstName,lblLastName,lblUserID,lblPhoneNumber,lblFlightID,lblDestination,lblDeparture,lblArrival,lblTravelClass,
                   lblPrice,lblHotelID,lblHotelName,lblLocation,lblRating,lblRoomPreference,lblHotelPrice,lblCheckInDate,lblCheckOutDate,lblCheckInTime,
                   lblCheckOutTime,lblTitlePersonalDetails,lblTitleFlightInformation,lblTitleHotelInformation,lblFlightTotalCost;
    private JPanel pnlPersonalDetails,pnlFlightInfo,pnlHotelInfo;
    private JComboBox cmbRoomPreference;
    private String[] roomPreference = {"Standard Room","Deluxe Room","Executive Room"};

 BookingFormTwo(String firstName,String lastName,String userID, String phoneNumber){
        
     
        setTitle("Booking Form");
        setSize(1000, 650);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(253,252,233));

 
        lblTitle = new JLabel("Booking Form");
        lblTitle.setBounds(50, 20, 200, 30);
        lblTitle.setFont(new Font("Garet",Font.BOLD,20));
        add(lblTitle);

        lblBookingID = new JLabel("Booking ID");
        lblBookingID.setBounds(850, 20, 100, 30);
        lblBookingID.setFont(new Font("Garet",Font.BOLD,17));
        add(lblBookingID);

        pnlPersonalDetails = new JPanel();
        pnlPersonalDetails.setLayout(null);
        pnlPersonalDetails.setBounds(50, 60, 400, 200);
        pnlPersonalDetails.setBorder(BorderFactory.createTitledBorder(""));
        pnlPersonalDetails.setFont(new Font("Garet",Font.BOLD,10));
        pnlPersonalDetails.setBackground(new Color(180, 204, 224));
        add(pnlPersonalDetails);
        
        lblTitlePersonalDetails = new JLabel("Personal Details");
        lblTitlePersonalDetails.setBounds(150, 0, 100, 30);
        lblTitlePersonalDetails.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblTitlePersonalDetails);
        
        
        lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(20, 30, 100, 30);
        lblFirstName.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblFirstName);

        txtFirstName = new JTextField(firstName);
        txtFirstName.setBounds(120, 30, 250, 30);
        txtFirstName.setEditable(false);
        txtFirstName.setBackground(new Color(253,252,233));
        pnlPersonalDetails.add(txtFirstName);

        lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(20, 70, 100, 30);
        lblLastName.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblLastName);

        txtLastName = new JTextField(lastName);
        txtLastName.setBounds(120, 70, 250, 30);
        txtLastName.setEditable(false);
        txtLastName.setBackground(new Color(253,252,233));
        pnlPersonalDetails.add(txtLastName);

        lblUserID = new JLabel("userID:");
        lblUserID.setBounds(20, 110, 250, 30);
        lblUserID.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblUserID);

        txtUserID = new JTextField(userID);
        txtUserID.setBounds(120, 110, 250, 30);
        txtUserID.setEditable(false);
        txtUserID.setBackground(new Color(253,252,233));
        pnlPersonalDetails.add(txtUserID);

        lblPhoneNumber = new JLabel("Phone Number:");
        lblPhoneNumber.setBounds(20, 150, 100, 30);
        lblPhoneNumber.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblPhoneNumber);

        txtPhoneNumber = new JTextField(phoneNumber);
        txtPhoneNumber.setBounds(120, 150, 250, 30);
        txtPhoneNumber.setEditable(false);
        txtPhoneNumber.setBackground(new Color(253,252,233));
        pnlPersonalDetails.add(txtPhoneNumber);
        
        pnlFlightInfo = new JPanel();
        pnlFlightInfo.setLayout(null);
        pnlFlightInfo.setBounds(50, 270, 400, 275);
        pnlFlightInfo.setBorder(BorderFactory.createTitledBorder(""));
        pnlFlightInfo.setBackground(new Color(180, 204, 224));
        pnlFlightInfo.setFont(new Font("Garet",Font.BOLD,10));
        add(pnlFlightInfo);

        lblTitleFlightInformation = new JLabel("Flight Information");
        lblTitleFlightInformation.setBounds(150, 0, 100, 30);
        lblTitleFlightInformation.setFont(new Font("Garet",Font.BOLD,12));
        pnlFlightInfo.add(lblTitleFlightInformation);
        
        
        lblFlightID = new JLabel("Flight ID:");
        lblFlightID.setBounds(20, 30, 100, 30);
        lblFlightID.setFont(new Font("Garet",Font.BOLD,12));
        pnlFlightInfo.add(lblFlightID);

        txtFlightID = new JTextField();
        txtFlightID.setBounds(120, 30, 250, 30);
        txtFlightID.setEditable(false);
        txtFlightID.setBackground(new Color(253,252,233));
        pnlFlightInfo.add(txtFlightID);

        lblDestination = new JLabel("Destination:");
        lblDestination.setBounds(20, 70, 100, 30);
        lblDestination.setFont(new Font("Garet",Font.BOLD,12));
        pnlFlightInfo.add(lblDestination);

        txtDestination = new JTextField();
        txtDestination.setBounds(120, 70, 250, 30);
        txtDestination.setEditable(false);
        txtDestination.setBackground(new Color(253,252,233));
        pnlFlightInfo.add(txtDestination);

        lblDeparture = new JLabel("Departure:");
        lblDeparture.setBounds(20, 110, 100, 30);
        lblDeparture.setFont(new Font("Garet",Font.BOLD,12));
        pnlFlightInfo.add(lblDeparture);

        txtDeparture = new JTextField();
        txtDeparture.setBounds(120, 110, 250, 30);
        txtDeparture.setEditable(false);
        txtDeparture.setBackground(new Color(253,252,233));
        pnlFlightInfo.add(txtDeparture);

        lblArrival = new JLabel("Arrival:");
        lblArrival.setBounds(20, 150, 100, 30);
        lblArrival.setFont(new Font("Garet",Font.BOLD,12));
        pnlFlightInfo.add(lblArrival);

        txtArrival = new JTextField();
        txtArrival.setBounds(120, 150, 250, 30);
        txtArrival.setEditable(false);
        txtArrival.setBackground(new Color(253,252,233));
        pnlFlightInfo.add(txtArrival);

        lblTravelClass = new JLabel("Travel Class:");
        lblTravelClass.setBounds(20, 190, 100, 30);
        lblTravelClass.setFont(new Font("Garet",Font.BOLD,12));
        pnlFlightInfo.add(lblTravelClass);

        txtTravelClass = new JTextField();
        txtTravelClass.setBounds(120, 190, 250, 30);
        txtTravelClass.setEditable(false);
        txtTravelClass.setBackground(new Color(253,252,233));
        pnlFlightInfo.add(txtTravelClass);

        lblPrice = new JLabel("Price:");
        lblPrice.setBounds(20, 230, 100, 30);
        lblPrice.setFont(new Font("Garet",Font.BOLD,12));
        pnlFlightInfo.add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(120, 230, 250, 30);
        txtPrice.setEditable(false);
        txtPrice.setBackground(new Color(253,252,233));
        pnlFlightInfo.add(txtPrice);

        pnlHotelInfo = new JPanel();
        pnlHotelInfo.setLayout(null);
        pnlHotelInfo.setBounds(500, 60, 450, 485);
        pnlHotelInfo.setBorder(BorderFactory.createTitledBorder(""));
        pnlHotelInfo.setBackground(new Color(180, 204, 224));
        pnlHotelInfo.setFont(new Font("Garet",Font.BOLD,10));
        add(pnlHotelInfo);
        
        lblTitleHotelInformation = new JLabel("Hotel Information");
        lblTitleHotelInformation.setBounds(175, 0, 100, 30);
        lblTitleHotelInformation.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblTitleHotelInformation);

        
        lblHotelID = new JLabel("Hotel ID:");
        lblHotelID.setBounds(20, 30, 100, 30);
        lblHotelID.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblHotelID);

        txtHotelID = new JTextField();
        txtHotelID.setBounds(145, 30, 275, 30);
        txtHotelID.setEditable(false);
        txtHotelID.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtHotelID);

        lblHotelName = new JLabel("Name:");
        lblHotelName.setBounds(20, 70, 100, 30);
        lblHotelName.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblHotelName);

        txtHotelName = new JTextField();
        txtHotelName.setBounds(145, 70, 275, 30);
        txtHotelName.setEditable(false);
        txtHotelName.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtHotelName);

        lblLocation = new JLabel("Location:");
        lblLocation.setBounds(20, 110, 100, 30);
        lblLocation.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblLocation);

        txtLocation = new JTextField();
        txtLocation.setBounds(145, 110, 275, 30);
        txtLocation.setEditable(false);
        txtLocation.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtLocation);

        lblRating = new JLabel("Rating:");
        lblRating.setBounds(20, 150, 100, 30);
        lblRating.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblRating);

        txtRating = new JTextField();
        txtRating.setBounds(145, 150, 275, 30);
        txtRating.setEditable(false);
        txtRating.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtRating);

        lblRoomPreference = new JLabel("Room Preference:");
        lblRoomPreference.setBounds(20, 190, 150, 30);
        lblRoomPreference.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblRoomPreference);

        cmbRoomPreference = new JComboBox<>(roomPreference);
        cmbRoomPreference.setBounds(145, 190, 275, 30);
        cmbRoomPreference.setEditable(true);
        cmbRoomPreference.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(cmbRoomPreference);

        lblHotelPrice = new JLabel("Price:");
        lblHotelPrice.setBounds(20, 230, 100, 30);
        lblHotelPrice.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblHotelPrice);

        txtHotelPrice = new JTextField();
        txtHotelPrice.setBounds(145, 230, 275, 30);
        txtHotelPrice.setEditable(false);
        txtHotelPrice.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtHotelPrice);

        lblCheckInDate = new JLabel("Check-in dates:");
        lblCheckInDate.setBounds(40, 280, 100, 30);
        lblCheckInDate.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblCheckInDate);

        txtCheckInDate = new JTextField();
        txtCheckInDate.setBounds(40, 315, 150, 30);
        txtCheckInDate.setEditable(true);
        txtCheckInDate.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtCheckInDate);

        lblCheckInTime = new JLabel("Check-in Time:");
        lblCheckInTime.setBounds(260, 280, 100, 30);
        lblCheckInTime.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblCheckInTime);

        txtCheckInTime = new JTextField();
        txtCheckInTime.setBounds(260, 315, 150, 30);
        txtCheckInTime.setEditable(true);
        txtCheckInTime.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtCheckInTime);
        
        lblCheckOutDate = new JLabel("Check-out dates:");
        lblCheckOutDate.setBounds(40, 350, 150, 30);
        lblCheckOutDate.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblCheckOutDate);

        txtCheckOutDate = new JTextField();
        txtCheckOutDate.setBounds(40, 385, 150, 30);
        txtCheckOutDate.setEditable(true);
        txtCheckOutDate.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtCheckOutDate);

        lblCheckOutTime = new JLabel("Check-out Time:");
        lblCheckOutTime.setBounds(260, 350, 150, 30);
        lblCheckOutTime.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblCheckOutTime);

        txtCheckOutTime = new JTextField();
        txtCheckOutTime.setBounds(260, 385, 150, 30);
        txtCheckOutTime.setEditable(true);
        txtCheckOutTime.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtCheckOutTime);
        
        lblFlightTotalCost = new JLabel("Total Cost:");
        lblFlightTotalCost.setBounds(30, 440, 150, 30);
        lblFlightTotalCost.setFont(new Font("Garet",Font.BOLD,17));
        pnlHotelInfo.add(lblFlightTotalCost);
        
       
        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBounds(325, 440, 100, 30);
        btnSubmit.setBackground(new Color(37, 113, 128));
        btnSubmit.setForeground(new Color(253, 252, 233));
        pnlHotelInfo.add(btnSubmit);
        
        setVisible(true);
        
        btnSubmit.addActionListener(this);
        
    }
 @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
             JOptionPane.showMessageDialog(this, "successful!");
             new invoice();
             dispose();
        }
}
}
