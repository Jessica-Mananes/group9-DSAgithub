/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.master;

/**
 *
 * @author Marielle
 */
import com.mycompany.master.BSTFlight.FlightNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Flight extends JFrame implements ActionListener{
    private BSTFlight bst;
    private JLabel lblflights, lblDate;
    private JButton btnBook, btnSearch, btnRefresh;
    private JTextField txtField;
    private JPanel panelFlight;
    private JTable tableFlights;
    private DefaultTableModel defaultTableMdl;
    private TableColumnModel tableColumnMdl;
    private TableColumn tableColumn;
    private JScrollPane scrollpane;
    private JComboBox<String> flightClass;
    private URL imgSearch, imgRefresh;
    private ImageIcon imgIconSearch, imgnewSearch, imgIconRefresh, imgnewRefresh;
    private String[] column = {"Flight ID", "Destination", "Departure", "Arrival", "Class", "Price"};
    private String[] TravelClass = {"Economy", "Business", "First Class"};  

    Flight () {
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        panelFlight = new JPanel();
        panelFlight.setSize(1000, 600);
        panelFlight.setBackground(new Color(37, 113, 128));
        panelFlight.setLayout(null);
        add(panelFlight);   
        
        flightClass = new JComboBox<>(TravelClass);
        
        bst = new BSTFlight();
        bst.insert(new FlightInfo("Paris, France", LocalTime.of(8, 0), "Choose.."));
        bst.insert(new FlightInfo("Kyoto, Japan", LocalTime.of(10, 30), "Choose.."));
        bst.insert(new FlightInfo("Rome, Italy", LocalTime.of(17, 0), "Choose.."));
        bst.insert(new FlightInfo("New York City, USA", LocalTime.of(6, 0), "Choose.."));
        bst.insert(new FlightInfo("Cape Town, South Africa", LocalTime.of(10, 30), "Choose.."));
        bst.insert(new FlightInfo("Bangkok, Thailand", LocalTime.of(19, 45), "Choose.."));
        bst.insert(new FlightInfo("Barcelona, Spain", LocalTime.of(7, 20), "Choose.."));
        bst.insert(new FlightInfo("Seoul, South Korea", LocalTime.of(18, 30), "Choose.."));
        bst.insert(new FlightInfo("Hawaii, USA", LocalTime.of(22, 0), "Choose.."));
        bst.insert(new FlightInfo("Sydney, Australia", LocalTime.of(21, 30), "Choose.."));
        
        
        ArrayList<FlightInfo> list = bst.inorder();
        
        String[][] flightdata = new String[list.size()][6];
        
        for (int f = 0; f < list.size(); f++) {
            FlightInfo flight = list.get(f);
            flightdata[f][0] = flight.flightID;
            flightdata[f][1] = flight.destination;
            flightdata[f][2] = flight.departure.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a"));
            flightdata[f][3] = flight.arrival.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a")); 
            flightdata[f][4] = flight.travelClass;
            flightdata[f][5] = "";
        }
        
        //table
        defaultTableMdl = new DefaultTableModel(flightdata, column){
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
        panelFlight.add(tableFlights);
        
        tableColumnMdl = tableFlights.getColumnModel();
        tableColumnMdl.getColumn(1).setPreferredWidth(150);
        tableColumnMdl.getColumn(3).setPreferredWidth(150);
                
        tableColumn = tableFlights.getColumnModel().getColumn(4);
        tableColumn.setCellEditor(new DefaultCellEditor(flightClass));      
        
        scrollpane = new JScrollPane(tableFlights);
        scrollpane.setBounds(30, 125, 925, 400);
        panelFlight.add(scrollpane);        
        
        lblDate = new JLabel(LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
        lblDate.setBounds(30, 10, 350, 50);
        lblDate.setFont(new Font("Garet", Font.BOLD, 20));
        panelFlight.add(lblDate);
        
        lblflights = new JLabel("AVAILABLE FLIGHTS");
        lblflights.setBounds(30, 50, 350, 50);
        lblflights.setFont(new Font("Garet", Font.BOLD, 25));
        panelFlight.add(lblflights);
       
        txtField = new JTextField();
        txtField.setBounds(290, 50, 380, 50);
        txtField.setFont(new Font("Garet", Font.BOLD, 18));
        txtField.setBackground(new Color(180, 204, 224));
        txtField.setForeground(new Color(0, 0, 0));
        add(txtField);
        panelFlight.add(txtField);
        
        //Image Icon for Search button        
        imgIconSearch = new ImageIcon("search.jpg");
        Image imgscaleSearch = imgIconSearch.getImage().getScaledInstance(60, 50, Image.SCALE_SMOOTH);
        imgnewSearch = new ImageIcon(imgscaleSearch);      
        
        btnSearch = new JButton(imgnewSearch);
        btnSearch.setBounds(685, 50, 60, 50);
        panelFlight.add(btnSearch);
        
        //Image Icon for Refresh button
        imgIconRefresh = new ImageIcon("refresh.jpg");
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
        
        flightClass.addActionListener(this);
        btnSearch.addActionListener(this);
        btnRefresh.addActionListener(this);
        btnBook.addActionListener(this);
        setVisible(true);
    } 

   
    PreparedStatement pst;
    Connection con;
    ResultSet rs;
    @Override
    public void actionPerformed(ActionEvent e) {
        
       Connect();
        
        //allow user to choose travel class
       if(e.getSource() == flightClass){
           int r = tableFlights.getSelectedRow();
           if (r != -1) {
            int row = tableFlights.convertRowIndexToModel(r);
            String classes = (String) flightClass.getSelectedItem();
            FlightInfo flight = bst.inorder().get(row);

            if (classes != null && !classes.equals("Choose..")) {
                double updatedPrice = flight.classPrices(classes, flight.price);
                defaultTableMdl.setValueAt("₱" + String.format("%.2f", updatedPrice), row, 5);
            }
        }
        //allow user to search flights   
       }else if (e.getSource() == btnSearch) {
        String txt = txtField.getText().trim();

        try {
        LocalTime departureTime = LocalTime.parse(txt, DateTimeFormatter.ofPattern("h:mm a"));
        
        FlightNode foundFlight = bst.search(departureTime);
        if (foundFlight != null) {
            defaultTableMdl.setRowCount(0);
            FlightInfo flight = foundFlight.flightinfo;
            defaultTableMdl.addRow(new Object[]{
                flight.flightID,
                flight.destination,
                flight.departure.format(DateTimeFormatter.ofPattern("h:mm a")),
                flight.arrival.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a")),
                flight.travelClass,
                ""
            });
        } else {
            JOptionPane.showMessageDialog(this, "No flight found with departure time: " + txt, "Error", JOptionPane.ERROR_MESSAGE);
        }
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Invalid time format. Please use 'h:mm a' (e.g., 8:00 AM).", "Error", JOptionPane.ERROR_MESSAGE);
           }
        //refresh the components
        }else if(e.getSource() == btnRefresh){
           txtField.setText("");
           ArrayList<FlightInfo> list = bst.inorder();

        defaultTableMdl.setRowCount(0);

        for (FlightInfo flight : list) {
        defaultTableMdl.addRow(new Object[]{
            flight.flightID,
            flight.destination,
            flight.departure.format(DateTimeFormatter.ofPattern("h:mm a")),
            flight.arrival.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a")),
            "Choose..",
            ""          
        });
                    
           String travelClass = "Choose..";
           String priceColumn = "";
           
           for (int i = 0; i < tableFlights.getRowCount(); i++){
               tableFlights.setValueAt(travelClass, i, 4);
               tableFlights.setValueAt(priceColumn, i, 5);
           }
           tableFlights.repaint();
       }
       //allow user to book
       }else if (e.getSource() == btnBook){
           int row = tableFlights.getSelectedRow();
           if(row == -1){
              JOptionPane.showMessageDialog(this, "Please select a row to book", "Error", JOptionPane.ERROR_MESSAGE); 
              return;
           }
             
           String selected = (String) tableFlights.getValueAt(row, 4);
           if(selected.equals("Choose..")){
              JOptionPane.showMessageDialog(this, "Please select a travel class to book", "Error", JOptionPane.ERROR_MESSAGE);
           }else {
                int btnBook = JOptionPane.showConfirmDialog(this, "Are you sure you want to book now?", "Confirm Booking", JOptionPane.YES_OPTION);
           
               if(btnBook == JOptionPane.YES_OPTION){
               //new Login();
               
               int select = tableFlights.getSelectedRow();
                
               if(select != -1){
                    Object flightID = tableFlights.getValueAt(select, 0);
                    Object destination = tableFlights.getValueAt(select, 1);
                    Object departure = tableFlights.getValueAt(select, 2);
                    Object arrival = tableFlights.getValueAt(select, 3);
                    Object travelClass = tableFlights.getValueAt(select, 4);
                    Object price = tableFlights.getValueAt(select, 5);
                
                        
                        try{
                           pst = con.prepareStatement("insert into flightinfo (flightID,destination,departure,arrival,travelClass,price) values (?,?,?,?,?,?)");
                           pst.setString(1, flightID.toString());
                           pst.setString(2, destination.toString());
                           pst.setString(3, departure.toString());
                           pst.setString(4, arrival.toString());
                           pst.setString(5,travelClass.toString());
                           pst.setString(6,price.toString());

                           pst.executeUpdate();
           }   catch (SQLException ex) {
                   Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
               }
                }
               
            }
                
           
       }
    }
    
       
    }
    
    public void Connect(){
  
        String url = "jdbc:mysql://localhost:3306/groupninedsaproject";
            String username = "root";
            String password = "admin123";
           
        try {
          con=(Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


