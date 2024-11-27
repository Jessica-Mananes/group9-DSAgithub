/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.master;

/**
 *
 * @author Marielle
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import javax.swing.*;
import javax.swing.table.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Flight extends JPanel implements ActionListener{
    private JLabel lblflights, lblDate;
    private JButton btnBook, btnSearch, btnRefresh;
    private JTextField txtField;
    private JTable tableFlights;
    private DefaultTableModel defaultTableMdl;
    private TableColumnModel tableColumnMdl;
    private TableColumn tableColumn;
    private JScrollPane scrollpane;
    private TableRowSorter<DefaultTableModel> search;
    private JComboBox<String> flightClass;
    private URL imgSearch, imgRefresh;
    private ImageIcon imgIconSearch, imgnewSearch, imgIconRefresh, imgnewRefresh;
    private String[] column = {"Flight ID", "Destination", "Departure", "Arrival", "Class", "Price"};
    private String[] TravelClass = {"Economy", "Business", "First Class"};
    private double InitialPrice[] = {52000, 16000, 50320, 48000, 60000, 11850, 55200, 13500, 36350, 26580};
    private int traveltime[] = {18, 7, 18, 16, 20, 3, 19, 4, 12, 8};
    private String flightInfo[][] = {
        {"FLPF001", "Paris, France", "8:00 AM", "", "Choose.."},
        {"FLKJ002", "Kyoto, Japan", "10:30 AM", "", "Choose.."},
        {"FLRI003", "Rome, Italy", "5:00 PM", "", "Choose.."},
        {"FLNY004", "New York City, USA", "6:00 AM", "", "Choose.."},
        {"FLSA005", "Cape Town, South Africa", "10:30 AM", "", "Choose.."},
        {"FLBT006", "Bangkok, Thailand", "7:45 PM", "", "Choose.."},
        {"FLBS007", "Barcelona, Spain", "7:20 AM", "", "Choose.."},
        {"FLSK008", "Seoul, South Korea", "6:00 PM", "", "Choose.."},
        {"FLHU009", "Hawaii, USA", "10:00 PM","", "Choose.."},
        {"FLSA010", "Sydney, Australia", "8:30 PM", "", "Choose.."}
        
    };

    Flight () {
        
       setSize(1000, 600);
       setBackground(new Color(37, 113, 128));
       setLayout(null);
        
        
        flightClass = new JComboBox<>(TravelClass);
        
        //table
        defaultTableMdl = new DefaultTableModel(flightInfo, column){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4;
            }
        };  
            
        tableFlights = new JTable(defaultTableMdl);
        tableFlights.setBackground(new Color(37, 113, 128));
        tableFlights.setForeground(new Color(253, 252, 233));
        tableFlights.setFont(new Font("Garet", Font.BOLD, 13));     
        tableFlights.setRowHeight(60);
        
        tableFlights.getTableHeader().setBackground(new Color(180, 204, 224));
        tableFlights.getTableHeader().setForeground(new Color(0, 0, 0));
        tableFlights.getTableHeader().setFont(new Font("Garet", Font.BOLD, 20));
        add(tableFlights);
        
        search = new TableRowSorter<>(defaultTableMdl);
        tableFlights.setRowSorter(search);
        
        tableColumnMdl = tableFlights.getColumnModel();
        tableColumnMdl.getColumn(1).setPreferredWidth(150);
        tableColumnMdl.getColumn(3).setPreferredWidth(150);
                
        tableColumn = tableFlights.getColumnModel().getColumn(4);
        tableColumn.setCellEditor(new DefaultCellEditor(flightClass));      
        
        scrollpane = new JScrollPane(tableFlights);
        scrollpane.setBounds(30, 125, 925, 400);
        add(scrollpane);        
        
        lblDate = new JLabel(LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
        lblDate.setBounds(30, 10, 350, 50);
        lblDate.setFont(new Font("Garet", Font.BOLD, 20));
        add(lblDate);
        
        lblflights = new JLabel("AVAILABLE FLIGHTS");
        lblflights.setBounds(30, 50, 350, 50);
        lblflights.setFont(new Font("Garet", Font.BOLD, 25));
        add(lblflights);
       
        txtField = new JTextField();
        txtField.setBounds(290, 50, 380, 50);
        txtField.setFont(new Font("Garet", Font.BOLD, 18));
        txtField.setBackground(new Color(180, 204, 224));
        txtField.setForeground(new Color(0, 0, 0));
        add(txtField);
        add(txtField);
        
        //Image Icon for Search button
        try {
            imgSearch = new URL("https://i.pinimg.com/736x/9f/60/aa/9f60aa4fc99a35d7b994407954231148.jpg");          
        } catch (MalformedURLException ex) {
            Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        imgIconSearch = new ImageIcon(imgSearch);
        Image imgscaleSearch = imgIconSearch.getImage().getScaledInstance(60, 50, Image.SCALE_SMOOTH);
        imgnewSearch = new ImageIcon(imgscaleSearch);      
        
        btnSearch = new JButton(imgnewSearch);
        btnSearch.setBounds(685, 50, 60, 50);
        panelFlight.add(btnSearch);
        
        //Image Icon for Refresh button
        try {
            imgRefresh = new URL("https://i.pinimg.com/736x/d9/84/c8/d984c8f531bcbd61fe95fbb59bb07773.jpg");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        imgIconRefresh = new ImageIcon(imgRefresh);
        Image imgscaleRefresh = imgIconRefresh.getImage().getScaledInstance(60, 50, Image.SCALE_SMOOTH);
        imgnewRefresh = new ImageIcon(imgscaleRefresh);
        
        btnRefresh = new JButton(imgnewRefresh);
        btnRefresh.setBounds(755, 50, 60, 50);
        panelFlight.add(btnRefresh);

        //book now button
        btnBook = new JButton("BOOK NOW");
        btnBook.setBounds(825, 50, 130, 50);
        btnBook.setFont(new Font("Garet", Font.BOLD, 17));
        btnBook.setForeground(new Color(0, 0, 0));
        btnBook.setBackground(new Color(180, 204, 224));
        panelFlight.add(btnBook);
        
        //Local Date&Time
        for(int r = 0; r < flightInfo.length; r++){
            String departure = flightInfo[r][2];
            
            try {
                LocalDate currentD = LocalDate.now();
                LocalTime dtime = LocalTime.parse(departure, DateTimeFormatter.ofPattern("h:mm a"));
                LocalDateTime departureDT = LocalDateTime.of(currentD, dtime);
                
                int travelHrs = traveltime[r];
                LocalDateTime arr = departureDT.plusHours(travelHrs);
                
                String arrival = arr.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a"));
                
                defaultTableMdl.setValueAt(arrival, r, 3);
                        
            } catch (Exception e){
                System.out.println("Error parsing" + e.getMessage());
            }
            }

        flightClass.addActionListener(this);
        btnSearch.addActionListener(this);
        btnRefresh.addActionListener(this);
        btnBook.addActionListener(this);
        setVisible(true);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //allow user to choose travel class
       if(e.getSource() == flightClass){
           int r = tableFlights.getSelectedRow();
           if(r != -1){
               int row = tableFlights.convertRowIndexToModel(r);
               
               String classes = (String) flightClass.getSelectedItem();
               
               double initialPrc = InitialPrice[row];
               double p = classPrices(classes, initialPrc);
               
               String price = "₱" + String.format("%.2f", p);              
               defaultTableMdl.setValueAt(price, row, 5);              
           }
        //allow user to search flights   
       }else if(e.getSource() == btnSearch){
           String txt = txtField.getText().trim();
           
           if(txt.isEmpty()){                 
               JOptionPane.showMessageDialog(this, "Please enter a flight", "Error", JOptionPane.ERROR_MESSAGE);
           } else {
               search.setRowFilter(RowFilter.regexFilter("(?i)" + txt));
           }
           
           if(tableFlights.getRowCount() == 0){
               JOptionPane.showMessageDialog(this, "Flight not available.", "Error", JOptionPane.ERROR_MESSAGE);
               search.setRowFilter(null);
               txtField.setText("");
           }
        //refresh the components       
       }else if(e.getSource() == btnRefresh){
           txtField.setText("");
           search.setRowFilter(null); 
                    
           String travelClass = "Choose..";
           String priceColumn = "";
           
           for (int i = 0; i < tableFlights.getRowCount(); i++){
               tableFlights.setValueAt(travelClass, i, 4);
               tableFlights.setValueAt(priceColumn, i, 5);
           }
           tableFlights.repaint();
        //error message 
       }else if (e.getSource() == btnBook){
           int row = tableFlights.getSelectedRow();
           if(row == -1){
              JOptionPane.showMessageDialog(this, "Please select a row to book", "Error", JOptionPane.ERROR_MESSAGE); 
           }
             
           String selected = (String) tableFlights.getValueAt(row, 4);
           if(selected.equals("Choose..")){
              JOptionPane.showMessageDialog(this, "Please select a travel class to book", "Error", JOptionPane.ERROR_MESSAGE);
           }else {
               new BookingForm(firstName,lastName,userID,phoneNumber);
               
           }
           
           
       }
        
    }
    private double classPrices (String TravelClass, double InitialPrice){
        double price = 0.0;
        switch(TravelClass){
            case "Economy":
            price = InitialPrice*1;
            break;
            case "Business":
            price = InitialPrice*2;
            break;
            case "First Class":
            price = InitialPrice*5;
        }
        return price;
        
    }        
}

