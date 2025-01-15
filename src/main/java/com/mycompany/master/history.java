/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.master;

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
public class historyht extends JFrame implements ActionListener{
    
    // Components Declaration
    private JLabel userid, bookHistory;
    private JButton logout, itinerary, viewhistory;
    private JTable historyTb;
    private DefaultTableModel historyModel;
    private JScrollPane historyTable;
    private Hashtable<String, String[]> bookingHistory;
  
    
    
    // Constructor
    historyht() {
    
 

        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 253, 208));
        setLocationRelativeTo(null);
        Connect();
    
        // Initialize HashMap (our simple hash table)
        bookingHistory = new Hashtable<>();
        
        // Pre-populate the hash table with some sample data
        bookingHistory.put("", new String[] {"", "", "", "", ""});
        bookingHistory.put("", new String[] {"", "", "", "", ""});
        bookingHistory.put("", new String[] {"", "", "", "", ""});
        
        // User Label
        userid = new JLabel("USER ID: ");
        userid.setFont(new Font("Garet", Font.BOLD, 22));
        userid.setForeground(new Color(0, 0, 0));
        userid.setBounds(60, 40, 350, 50);
        add(userid);

        // Booking History Label
        bookHistory = new JLabel("BOOKING HISTORY");
        bookHistory.setFont(new Font("Garet", Font.BOLD, 25));
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
            Logger.getLogger(historyht.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
        PreparedStatement pst;
        Connection con;
        ResultSet rs;    
    
    public void LoadRecords(){
        try {
            pst = con.prepareStatement("SELECT BookingID, TotalCost, FlightID, HotelID, TimeCreated FROM bookinfo");
            rs = pst.executeQuery();
            
            DefaultTableModel df = (DefaultTableModel) historyTb.getModel();
            df.setRowCount(0);
            
            while (rs.next()) {
             String fbookingid= rs.getString("BookingID");
             String ftotalcost= rs.getString("TotalCost");
             String fflightid= rs.getString("FlightID");
             String fhotelid= rs.getString("HotelID");
             String ftimecreated= rs.getString("TimeCreated");
             
             df.addRow(new Object[]{fbookingid,ftotalcost,fflightid,fhotelid,ftimecreated});
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
                historyht.this,
                "Are you sure you want to logout?",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            } else if (e.getSource() == itinerary) {
                int response = JOptionPane.showConfirmDialog(
                this,"Do you want to see the travel itinerary?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                //new ItineraryTravel();
                dispose();
            
            } else if (e.getSource() == viewhistory) {      
            LoadRecords();

            }
        }
    }
