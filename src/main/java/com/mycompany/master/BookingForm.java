package com.mycompany.master;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Darrel
 */
public class BookingForm extends JFrame implements ActionListener {
    // Declare buttons and labels
    private JTextField txtFirstName, txtLastName, txtUserID, txtPhoneNumber,txtCheckInDate, txtCheckOutDate, txtCheckInTime,txtCheckOutTime,txtFlightID,
                       txtDestination,txtDeparture,txtTravelClass,txtArrival,txtPrice,txtHotelID,txtHotelName,txtLocation,txtRating,txtRoomPreference,txtHotelPrice;
    private JButton btnNext, btnRetrieve;
    private JLabel lblTitle,lblBookingID,lblFirstName,lblLastName,lblUserID,lblPhoneNumber,lblFlightID,lblDestination,lblDeparture,lblArrival,lblTravelClass,
                   lblPrice,lblHotelID,lblHotelName,lblLocation,lblRating,lblRoomPreference,lblHotelPrice,lblCheckInDate,lblCheckOutDate,lblCheckInTime,
                   lblCheckOutTime,lblTitlePersonalDetails,lblTitleFlightInformation,lblTitleHotelInformation,lblFlightTotalCost;
    private JPanel pnlPersonalDetails,pnlFlightInfo,pnlHotelInfo;
    private Connection con;
    private PreparedStatement pst;
    
    

 BookingForm(String firstName,String lastName,String userID, String phoneNumber){
        Connect();
        // Set up the JFrame properties
        setTitle("Booking Form");
        setSize(1000, 650);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(253,252,233));

        // Add the main title label
        lblTitle = new JLabel("Booking Form");
        lblTitle.setBounds(50, 20, 200, 30);
        lblTitle.setFont(new Font("Garet",Font.BOLD,20));
        add(lblTitle);

        // Add the Booking ID label
        lblBookingID = new JLabel("Booking ID");
        lblBookingID.setBounds(850, 20, 100, 30);
        lblBookingID.setFont(new Font("Garet",Font.BOLD,17));
        add(lblBookingID);

        // Initialize and set up the Personal Details panel
        pnlPersonalDetails = new JPanel();
        pnlPersonalDetails.setLayout(null);
        pnlPersonalDetails.setBounds(50, 60, 400, 200);
        pnlPersonalDetails.setBorder(BorderFactory.createTitledBorder(""));
        pnlPersonalDetails.setFont(new Font("Garet",Font.BOLD,10));
        pnlPersonalDetails.setBackground(new Color(180, 204, 224));
        add(pnlPersonalDetails);
        
        // Add the "Personal Details" title inside the panel
        lblTitlePersonalDetails = new JLabel("Personal Details");
        lblTitlePersonalDetails.setBounds(150, 0, 100, 30);
        lblTitlePersonalDetails.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblTitlePersonalDetails);
        
        // Add the First Name label and text field
        lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(20, 30, 100, 30);
        lblFirstName.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblFirstName);

        txtFirstName = new JTextField(firstName);
        txtFirstName.setBounds(120, 30, 250, 30);
        txtFirstName.setEditable(false);
        txtFirstName.setBackground(new Color(253,252,233));
        pnlPersonalDetails.add(txtFirstName);

        // Add the Last Name label and text field
        lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(20, 70, 100, 30);
        lblLastName.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblLastName);

        txtLastName = new JTextField(lastName);
        txtLastName.setBounds(120, 70, 250, 30);
        txtLastName.setEditable(false);
        txtLastName.setBackground(new Color(253,252,233));
        pnlPersonalDetails.add(txtLastName);

        // Add the User ID label and text field
        lblUserID = new JLabel("userID:");
        lblUserID.setBounds(20, 110, 250, 30);
        lblUserID.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblUserID);

        txtUserID = new JTextField(userID);
        txtUserID.setBounds(120, 110, 250, 30);
        txtUserID.setEditable(false);
        txtUserID.setBackground(new Color(253,252,233));
        pnlPersonalDetails.add(txtUserID);

        // Add the Phone Number label and text field
        lblPhoneNumber = new JLabel("Phone Number:");
        lblPhoneNumber.setBounds(20, 150, 100, 30);
        lblPhoneNumber.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblPhoneNumber);

        txtPhoneNumber = new JTextField(phoneNumber);
        txtPhoneNumber.setBounds(120, 150, 250, 30);
        txtPhoneNumber.setEditable(false);
        txtPhoneNumber.setBackground(new Color(253,252,233));
        pnlPersonalDetails.add(txtPhoneNumber);
        
        // Initialize and set up the Flight Information panel
        pnlFlightInfo = new JPanel();
        pnlFlightInfo.setLayout(null);
        pnlFlightInfo.setBounds(50, 270, 400, 275);
        pnlFlightInfo.setBorder(BorderFactory.createTitledBorder(""));
        pnlFlightInfo.setBackground(new Color(180, 204, 224));
        pnlFlightInfo.setFont(new Font("Garet",Font.BOLD,10));
        add(pnlFlightInfo);

        // Add the "Flight Information" title inside the panel
        lblTitleFlightInformation = new JLabel("Flight Information");
        lblTitleFlightInformation.setBounds(150, 0, 100, 30);
        lblTitleFlightInformation.setFont(new Font("Garet",Font.BOLD,12));
        pnlFlightInfo.add(lblTitleFlightInformation);
        
        lblTitleFlightInformation = new JLabel("Flight Information");
        lblTitleFlightInformation.setBounds(150, 0, 100, 30);
        lblTitleFlightInformation.setFont(new Font("Garet",Font.BOLD,12));
        pnlFlightInfo.add(lblTitleFlightInformation);
        
        // Add the Flight ID label and text field
        lblFlightID = new JLabel("Flight ID:");
        lblFlightID.setBounds(20, 30, 100, 30);
        lblFlightID.setFont(new Font("Garet",Font.BOLD,12));
        pnlFlightInfo.add(lblFlightID);

        txtFlightID = new JTextField();
        txtFlightID.setBounds(120, 30, 250, 30);
        txtFlightID.setEditable(false);
        txtFlightID.setBackground(new Color(253,252,233));
        pnlFlightInfo.add(txtFlightID);

        // Add the Destination label and text field
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

        lblPrice = new JLabel("Price(₱):");
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

        txtRoomPreference = new JTextField();
        txtRoomPreference.setBounds(145, 190, 275, 30);
        txtRoomPreference.setEditable(false);
        txtRoomPreference.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtRoomPreference);

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
        txtCheckInDate.setEditable(false);
        txtCheckInDate.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtCheckInDate);

        lblCheckInTime = new JLabel("Check-in Time:");
        lblCheckInTime.setBounds(260, 280, 100, 30);
        lblCheckInTime.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblCheckInTime);

        txtCheckInTime = new JTextField();
        txtCheckInTime.setBounds(260, 315, 150, 30);
        txtCheckInTime.setEditable(false);
        txtCheckInTime.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtCheckInTime);
        
        lblCheckOutDate = new JLabel("Check-out dates:");
        lblCheckOutDate.setBounds(40, 350, 150, 30);
        lblCheckOutDate.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblCheckOutDate);

        txtCheckOutDate = new JTextField();
        txtCheckOutDate.setBounds(40, 385, 150, 30);
        txtCheckOutDate.setEditable(false);
        txtCheckOutDate.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtCheckOutDate);

        lblCheckOutTime = new JLabel("Check-out Time:");
        lblCheckOutTime.setBounds(260, 350, 150, 30);
        lblCheckOutTime.setFont(new Font("Garet",Font.BOLD,12));
        pnlHotelInfo.add(lblCheckOutTime);

        txtCheckOutTime = new JTextField();
        txtCheckOutTime.setBounds(260, 385, 150, 30);
        txtCheckOutTime.setEditable(false);
        txtCheckOutTime.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtCheckOutTime);
        
        lblFlightTotalCost = new JLabel("Total Cost:");
        lblFlightTotalCost.setBounds(30, 440, 150, 30);
        lblFlightTotalCost.setFont(new Font("Garet",Font.BOLD,17));
        pnlHotelInfo.add(lblFlightTotalCost);
        
       
        btnNext = new JButton("NEXT");
        btnNext.setBounds(325, 440, 100, 30);
        btnNext.setBackground(new Color(37, 113, 128));
        btnNext.setForeground(new Color(253, 252, 233));
        btnNext.setEnabled(false);
        pnlHotelInfo.add(btnNext);
        
        
        btnRetrieve = new JButton("RETRIEVE");
        btnRetrieve.setBounds(210, 440, 100, 30);
        btnRetrieve.setBackground(new Color(37, 113, 128));
        btnRetrieve.setForeground(new Color(253, 252, 233));
        pnlHotelInfo.add(btnRetrieve);
        
        setVisible(true);
        
        btnNext.addActionListener(this);
        btnRetrieve.addActionListener(this);
        
    }
    public void Connect(){
    String url = "jdbc:mysql://localhost:3306/groupninedsaproject";
    String username = "root";
    String password = "admin123";
    
    
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(BookingForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnRetrieve) {
        
        btnRetrieve.setVisible(false);
        btnNext.setEnabled(true);
               
        
        

       try {
            // Retrieve Database from SQL
            String query = "SELECT flightID FROM flightInfo ORDER BY TimeCreated DESC LIMIT 1"; // Adjust the query as needed
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                
                String flightID = rs.getString("flightID");
                txtFlightID.setText(flightID); 

                
                query = "SELECT * FROM flightInfo WHERE flightID = ?";
                pst = con.prepareStatement(query);
                pst.setString(1, flightID);

                ResultSet flightDetails = pst.executeQuery();

                if (flightDetails.next()) {
                    
                    txtDestination.setText(flightDetails.getString("destination"));
                    txtDeparture.setText(flightDetails.getString("departure"));
                    txtArrival.setText(flightDetails.getString("arrival"));
                    txtTravelClass.setText(flightDetails.getString("travelClass"));
                    txtPrice.setText(flightDetails.getString("price"));
                }else {
                    JOptionPane.showMessageDialog(this, "No details found for the selected Flight ID.", "No Data", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No Flight IDs found in the database.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occurred while retrieving data.", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(BookingForm.class.getName()).log(Level.SEVERE, null, ex);
        }try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookingForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    if (e.getSource() == btnNext) {
        int book = JOptionPane.showConfirmDialog(BookingForm.this, "Are you sure you want to continue?", "Confirm Booking", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (book == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Proceed to Hotel Tab");
            dispose();
        } else {
        }
    }
}
}
   
