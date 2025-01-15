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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                       txtDestination,txtDeparture,txtTravelClass,txtArrival,txtPrice,txtHotelID,txtHotelName,txtLocation,txtRating,txtHotelPrice,
                       txtTotalCost;
    private JButton btnSubmit,btnRetrieve,btnTotalCost,btnReset;
    private JLabel lblTitle,lblBookingID,lblFirstName,lblLastName,lblUserID,lblPhoneNumber,lblFlightID,lblDestination,lblDeparture,lblArrival,
                   lblTravelClass,lblPrice,lblHotelID,lblHotelName,lblLocation,lblRating,lblRoomPreference,lblHotelPrice,lblCheckInDate,lblCheckOutDate,
                   lblCheckInTime,lblCheckOutTime,lblTitlePersonalDetails,lblTitleFlightInformation,lblTitleHotelInformation,lblFlightTotalCost;
    private JPanel pnlPersonalDetails,pnlFlightInfo,pnlHotelInfo;
    private JComboBox cmbRoomPreference;
    private String[] roomPreference = {"Standard Room","Deluxe Room","Executive Room"};
    private Connection con;
    private PreparedStatement pst;

 BookingFormTwo(){
        
        Connect();
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

        txtFirstName = new JTextField();
        txtFirstName.setBounds(120, 30, 250, 30);
        txtFirstName.setEditable(false);
        txtFirstName.setBackground(new Color(253,252,233));
        pnlPersonalDetails.add(txtFirstName);

        lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(20, 70, 100, 30);
        lblLastName.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(120, 70, 250, 30);
        txtLastName.setEditable(false);
        txtLastName.setBackground(new Color(253,252,233));
        pnlPersonalDetails.add(txtLastName);

        lblUserID = new JLabel("userID:");
        lblUserID.setBounds(20, 110, 250, 30);
        lblUserID.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblUserID);

        txtUserID = new JTextField();
        txtUserID.setBounds(120, 110, 250, 30);
        txtUserID.setBackground(new Color(253,252,233));
        pnlPersonalDetails.add(txtUserID);

        lblPhoneNumber = new JLabel("Phone Number:");
        lblPhoneNumber.setBounds(20, 150, 100, 30);
        lblPhoneNumber.setFont(new Font("Garet",Font.BOLD,12));
        pnlPersonalDetails.add(lblPhoneNumber);

        txtPhoneNumber = new JTextField();
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
        cmbRoomPreference.setEnabled(false);
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
        
        txtTotalCost = new JTextField();
        txtTotalCost.setBounds(120, 442, 90, 28);
        txtTotalCost.setEditable(false);
        txtTotalCost.setBackground(new Color(253,252,233));
        pnlHotelInfo.add(txtTotalCost);
        
        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBounds(325, 440, 100, 30);
        btnSubmit.setBackground(new Color(37, 113, 128));
        btnSubmit.setForeground(new Color(253, 252, 233));
        pnlHotelInfo.add(btnSubmit);
        btnSubmit.setVisible(false);
        
        btnRetrieve = new JButton("RETRIEVE");
        btnRetrieve.setBounds(325, 440, 100, 30);
        btnRetrieve.setBackground(new Color(37, 113, 128));
        btnRetrieve.setForeground(new Color(253, 252, 233));
        pnlHotelInfo.add(btnRetrieve);
        btnRetrieve.setVisible(true);
        
        btnTotalCost = new JButton("CALCULATE");
        btnTotalCost.setBounds(325, 440, 100, 30);
        btnTotalCost.setBackground(new Color(37, 113, 128));
        btnTotalCost.setForeground(new Color(253, 252, 233));
        pnlHotelInfo.add(btnTotalCost);
        btnTotalCost.setVisible(false);
        
        btnReset = new JButton("RESET");
        btnReset.setBounds(220, 440, 100, 30);
        btnReset.setBackground(new Color(37, 113, 128));
        btnReset.setForeground(new Color(253, 252, 233));
        pnlHotelInfo.add(btnReset);
        btnReset.setVisible(false);
        
        btnReset.addActionListener(this);
        btnSubmit.addActionListener(this);
        btnRetrieve.addActionListener(this);
        btnTotalCost.addActionListener(this);
        cmbRoomPreference.addActionListener(new ActionListener() {
            
                        public void actionPerformed(ActionEvent e) {
                        double hotelPrice = 8000.00;
            String selectedItem = (String) cmbRoomPreference.getSelectedItem();
                if(selectedItem == "Deluxe Room"){
                        double hotelPriceDeluxe = 10000.00;
                        txtHotelPrice.setText("₱ " + hotelPriceDeluxe);
                }else if(selectedItem.equals("Executive Room")){
                        double hotelPricePlusRoomPreference = hotelPrice + 7000.00;
                        txtHotelPrice.setText("₱ " + String.valueOf(hotelPricePlusRoomPreference));
                }else if (selectedItem .equals("Standard Room")){
                        txtHotelPrice.setText("₱ " + String.valueOf(hotelPrice));
                }else{
                        JOptionPane.showMessageDialog(null,"ERROR", "Error",JOptionPane.ERROR_MESSAGE);
                    }
                }       
                    });
        
        

        setVisible(true);
    }
                
 public void Connect(){
    String url = "jdbc:mysql://localhost:3306/groupninedsaproject";
    String username = "root";
    String password = "admin123";
    
     try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(BookingFormTwo.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    
    
 @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRetrieve) {
        String userID = txtUserID.getText().trim();
        
        if (userID.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Input your UserID", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else {
                 try {
                    String query = "SELECT * FROM signup WHERE UserID = ?";
                                   
                    pst = con.prepareStatement(query);
                    pst.setString(1, userID);
                    
                    
                  
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        String firstName = rs.getString("FirstName");
                        String lastName = rs.getString("LastName");
                        String phoneNumber = rs.getString("PhoneNumber");
                        
                        txtFirstName.setText(firstName);
                        txtLastName.setText(lastName);
                        txtPhoneNumber.setText(phoneNumber);
                        
                        btnRetrieve.setVisible(false);
                        txtUserID.setEditable(false);
                        btnTotalCost.setVisible(true);
                        cmbRoomPreference.setEnabled(true);
                        
                        JOptionPane.showMessageDialog(this, "Choose your Desired Room Preference");
  
                    }else {
                        JOptionPane.showMessageDialog(this, "Invalid UserID", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
        
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
                    txtPrice.setText("₱ "+flightDetails.getString("price"));
                }else {
                    JOptionPane.showMessageDialog(this, "No details found for the selected Flight ID.", "No Data", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No Flight IDs found in the database.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occurred while retrieving data.", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(BookingFormTwo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // Retrieve Database from SQL
            String query = "SELECT hotelid FROM hotelinfo ORDER BY TimeCreated DESC LIMIT 1"; // Adjust the query as needed
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                
                String hotelid = rs.getString("hotelid");
                txtHotelID.setText(hotelid); 

                
                query = "SELECT * FROM hotelinfo WHERE hotelid = ?";
                pst = con.prepareStatement(query);
                pst.setString(1, hotelid);

                ResultSet hotelDetails = pst.executeQuery();

                if (hotelDetails.next()) {
                    
                   
                    
                    
                    txtHotelName.setText(hotelDetails.getString("name"));
                    txtLocation.setText(hotelDetails.getString("location"));
                    txtRating.setText(hotelDetails.getString("rate"));
                    
                    
                    
                }else {
                    JOptionPane.showMessageDialog(this, "No details found for the selected Hotel ID.", "No Data", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No Hotel IDs found in the database.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occurred while retrieving data.", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(BookingFormTwo.class.getName()).log(Level.SEVERE, null, ex);
        }  
}
        }if (e.getSource() == btnSubmit) {
            String totalcost = txtTotalCost.getText().trim();
            String checkInDate = txtCheckInDate.getText().trim();
            String checkOutDate = txtCheckOutDate.getText().trim();
            String checkInTime = txtCheckInTime.getText().trim();
            String checkOutTime = txtCheckOutTime.getText().trim();
            if (!totalcost.isEmpty() && !checkInDate.isEmpty() && !checkOutDate.isEmpty() && !checkInTime.isEmpty() && !checkOutTime.isEmpty()){
                
            String firstName = txtFirstName.getText().trim();
            String lastName = txtLastName.getText().trim();
            String userid = txtUserID.getText().trim();
            String phoneNumber = new String(txtPhoneNumber.getText().trim());
            String flightid = txtFlightID.getText().trim();
            String destination = new String(txtDestination.getText().trim());
            String departure = txtDeparture.getText().trim();
            String arrival = txtArrival.getText().trim();
            String travelClass = txtTravelClass.getText().trim();
            String flightPrice = txtPrice.getText().trim();
            String hotelId = txtHotelID.getText().trim();
            String hotelName = txtHotelName.getText().trim();
            String hotelLocation = txtLocation.getText().trim();
            String hotelRating = txtRating.getText().trim();
            String roomPreference = (String) cmbRoomPreference.getSelectedItem();
            String hotelPrice = txtHotelPrice.getText().trim();
            String checkInDates = txtCheckInDate.getText().trim();
            String checkOutDates = txtCheckOutDate.getText().trim();
            String checkInTimes = txtCheckInTime.getText().trim();
            String checkOutTimes = txtCheckOutTime.getText().trim();
            String totalCost = txtTotalCost.getText().trim();
            
            
                try{
                    
                    String values = "INSERT INTO bookinfo (FirstName, LastName, UserID, PhoneNumber, FlightID, Destination, Departure, Arrival, TravelClass,"
                                    +"FlightPrice, HotelID, HotelName, HotelLocation, HotelRating, RoomPreference, HotelPrice, CheckInDates, CheckOutDates, "
                                    +"CheckInTime, CheckOutTime, TotalCost) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    pst = con.prepareStatement(values,Statement.RETURN_GENERATED_KEYS);
                    pst.setString(1, firstName);
                    pst.setString(2, lastName);
                    pst.setString(3, userid);
                    pst.setString(4, phoneNumber);
                    pst.setString(5, flightid);
                    pst.setString(6, destination);
                    pst.setString(7, departure);
                    pst.setString(8, arrival);
                    pst.setString(9, travelClass);
                    pst.setString(10, flightPrice);
                    pst.setString(11, hotelId);
                    pst.setString(12, hotelName);
                    pst.setString(13, hotelLocation);
                    pst.setString(14, hotelRating);
                    pst.setString(15, roomPreference);
                    pst.setString(16, hotelPrice);
                    pst.setString(17, checkInDates);
                    pst.setString(18, checkOutDates);
                    pst.setString(19, checkInTimes);
                    pst.setString(20, checkOutTimes);
                    pst.setString(21, totalCost);
                  
                    
                    
                    int rowCount = pst.executeUpdate();                     
                    if (rowCount > 0) {               
                        ResultSet rs = pst.getGeneratedKeys();
                        if (rs.next()) {
                        
                    JOptionPane.showMessageDialog(this, "Successful!");
                    new invoice();
                    dispose();
                        
                        }    
                    }
            
                }catch (SQLException ex) {
                    Logger.getLogger(BookingFormTwo.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Database connection error!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                }else{
               JOptionPane.showMessageDialog(this, "Please Fill all Fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
             
            
             
        }
        if (e.getSource() == btnTotalCost) {
           
            String getHotelPrice = txtHotelPrice.getText().trim();
                if(!getHotelPrice.isEmpty()){
                     String flightPriceText = txtPrice.getText();
                     String hotelPriceText = txtHotelPrice.getText();

        
        flightPriceText = flightPriceText.replace("?", "").replace("₱", "").trim();
        hotelPriceText = hotelPriceText.replace("?", "").replace("₱", "").trim();

        
        double flightPrice = Double.parseDouble(flightPriceText);
        double hotelPrice = Double.parseDouble(hotelPriceText);

        
        double totalCost = flightPrice + hotelPrice;

        
        txtTotalCost.setText(String.format("₱ " + "%.2f", totalCost));
        btnTotalCost.setVisible(false);
        btnSubmit.setVisible(true);
        cmbRoomPreference.setEnabled(false);
        btnReset.setVisible(true);
                }else{
                  JOptionPane.showMessageDialog(this, "Please choose your Desired ROOM PREFERENCE", "Error", JOptionPane.ERROR_MESSAGE);
                }
   
    }if (e.getSource()== btnReset){
       txtTotalCost.setText("");
       txtHotelPrice.setText("");
       cmbRoomPreference.setEnabled(true);
       
       JOptionPane.showMessageDialog(this, "Reset Successful!");
       btnTotalCost.setVisible(true);
       btnSubmit.setVisible(false);
       btnReset.setVisible(false);
       
     }
       
    }
}


