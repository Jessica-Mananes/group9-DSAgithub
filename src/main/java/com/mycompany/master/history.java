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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS X441U
 */
public class history extends JPanel implements ActionListener{
    
    // Components Declaration
    private JLabel userid, bookHistory;
    private JButton logout, itinerary, viewhistory;
    private JTable historyTb;
    private DefaultTableModel historyModel;
    private JScrollPane historyTable;
    private Hashtable<String, String[]> bookingHistory;
  
    
    
    // Constructor
    history() {
    
 

        setSize(1000, 600);
        setLayout(null);    
        setBackground(new Color(255, 253, 208));
        Connect();
    
        // Initialize HashMap (our simple hash table)
        bookingHistory = new Hashtable<>();
        
        // Pre-populate the hash table with some sample data
        bookingHistory.put("", new String[] {"", "", "", "", ""});
        bookingHistory.put("", new String[] {"", "", "", "", ""});
        bookingHistory.put("", new String[] {"", "", "", "", ""});
        
        // User Label
        userid = new JLabel("PATH TO PARADISE");
        userid.setFont(new Font("Garet", Font.BOLD, 40));
        userid.setForeground(new Color(0, 0, 0));
        userid.setBounds(60, 25, 550, 80);
        add(userid);

        // Booking History Label
        bookHistory = new JLabel("BOOKING HISTORY");
        bookHistory.setFont(new Font("Garet", Font.PLAIN, 25));
        bookHistory.setForeground(new Color(0, 0, 0));
        bookHistory.setBounds(60, 100, 350, 50);
        add(bookHistory);

        // Logout button
        logout = new JButton("LOGOUT");
        logout.setFont(new Font("Garet", Font.BOLD, 15));
        logout.setBounds(800, 40, 120, 30);
        add(logout);
        
        // Itinerary button
        itinerary = new JButton("ITINERARIES");
        itinerary.setFont(new Font("Garet", Font.BOLD, 15));
        itinerary.setBounds(630, 40, 150, 30);
        add(itinerary);
        
        // View History button
        viewhistory = new JButton("VIEW HISTORY");
        viewhistory.setFont(new Font("Garet", Font.BOLD, 15));
        viewhistory.setBounds(630, 80, 150, 30);
        add(viewhistory);


        // Table Model used for Booking History
        String[] columns = { "Booking ID","Arrival", "Destination","Hotel Name","Total Price"};
        historyModel = new DefaultTableModel(columns, 0);

        // History Table
        historyTb = new JTable(historyModel);
        historyTb.setBackground(new Color(37, 113, 128));
        historyTb.setForeground(new Color(253, 252, 233));
        historyTb.setFont(new Font("Garet", Font.BOLD, 13));
        historyTb.setRowHeight(30);

        historyTable = new JScrollPane(historyTb);
        historyTable.setBounds(60, 160, 860, 350);
        add(historyTable);
        
        // Logout Button Function
        logout.addActionListener(this);
        viewhistory.addActionListener(this);
        itinerary.addActionListener(this);

        setVisible(true);
    }
    
    public void Connect(){
  
        String url = "jdbc:mysql://localhost:3306/groupninedsaproject";
            String username = "root";
            String password = "admin123";
           
        try {
          con=(Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(history.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
        PreparedStatement pst;
        Connection con;
        ResultSet rs;    
    
    public void LoadRecords(){
        try {
            pst = con.prepareStatement("SELECT BookingID, Arrival, Destination, HotelName, TotalCost FROM bookinfo");
            rs = pst.executeQuery();
            
            DefaultTableModel df = (DefaultTableModel) historyTb.getModel();
            df.setRowCount(0);
            
            while (rs.next()) {
             String fbookingid= rs.getString("BookingID");
             String farrival= rs.getString("Arrival");
             String fdestination= rs.getString("Destination");
             String fhotelname= rs.getString("HotelName");
             String ftotalcost= rs.getString("TotalCost");
             df.addRow(new Object[]{fbookingid,farrival,fdestination,fhotelname,ftotalcost});
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Action Listener for Logout Button
        if (e.getSource() == logout) {
            // Action Listener for Logout Button
            int logout1 = JOptionPane.showConfirmDialog(
                history.this,"Are you sure you want to logout?", "Confirm Logout",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(logout1 == 0){
             setVisible(false);
             removeAll();
             
             add(new LoginThree());
             setVisible(true);
             revalidate();
                    
                    
                }

            } else if (e.getSource() == itinerary) {
                int response = JOptionPane.showConfirmDialog(this,"Are you sure you want to CLOSE?", "Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(response == 0){
                    new ItineraryTravel(); 
                }else{
                    
                }
               
 
            
            } else if (e.getSource() == viewhistory) {      
            LoadRecords();
            
            }
        }
    }