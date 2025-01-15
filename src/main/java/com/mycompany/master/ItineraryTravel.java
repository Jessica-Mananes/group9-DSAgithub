package com.mycompany.master;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Darrel
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ItineraryTravel extends JFrame implements ActionListener {
    private JButton returnBtn, proceedBtn, rowBtn, deleteBtn;
    private JTable itnryTable;
    private DefaultTableModel itnryModel;
    private JScrollPane itnryPane;
    private JLabel lbl, userID, placeLabel, dateLabel, timeLabel, activityLabel;
    private JTextField dateField, placesField, timeField, activityField, userField;


    ItineraryTravel() {
        setSize(1000, 700);
        getContentPane().setBackground(new Color(37, 113, 128));
        setTitle("Itinerary of Travel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        userID = new JLabel("UserID: ");
        userID.setBounds(20, 30, 220, 25);
        userID.setFont(new Font("Garet", Font.BOLD, 30));
        userID.setForeground(new Color(0, 0, 0));
        add(userID);
        
        userField = new JTextField();
        userField.setBounds(150, 30, 100, 30);
        userField.setBackground(new Color(37, 113, 128));
        add(userField);
        
        
        
        lbl = new JLabel("Individual Itinerary of Travel");
        lbl.setBounds(20, 80, 600, 50);
        lbl.setFont(new Font("Garet", Font.BOLD, 33));
        lbl.setForeground(new Color(0, 0, 0));
        add(lbl);
        
        returnBtn = new JButton("RETURN");
        returnBtn.setBounds(590, 49, 130, 40);
        returnBtn.setFont(new Font("Garet", Font.BOLD, 20));
        returnBtn.setBackground(new Color(180, 209, 224));
        returnBtn.setForeground(new Color(0, 0, 0));
        add(returnBtn);
        
        proceedBtn = new JButton("CLOSE");
        proceedBtn.setBounds(750, 49, 130, 40);
        proceedBtn.setFont(new Font("Garet", Font.BOLD, 20));
        proceedBtn.setBackground(new Color(180, 209, 224));
        proceedBtn.setForeground(new Color(0, 0, 0));
        add(proceedBtn);

        String[] Itcolumn = {"Date", "Places to be visited", "Time", "Activity"};
        itnryModel = new DefaultTableModel(Itcolumn, 0);
        itnryTable = new JTable(itnryModel);
        itnryTable.getTableHeader().setFont(new Font("Garet", Font.BOLD, 20));
        itnryTable.setBackground(new Color(180, 209, 224));
        itnryTable.setForeground(new Color(0, 0, 0));
        itnryTable.setFont(new Font("Garet", Font.BOLD, 20));
        itnryTable.setRowHeight(30);
        
        itnryPane = new JScrollPane(itnryTable);
        itnryPane.setBounds(20, 250, 950, 400);
        add(itnryPane);

        dateLabel = new JLabel("Date:");
        dateLabel.setBounds(50, 150, 250, 30);
        dateLabel.setForeground(new Color(253, 252, 233));
        dateLabel.setFont(new Font("Garet", Font.BOLD, 27));
        add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(150, 150, 150, 30);
        add(dateField);

        placeLabel = new JLabel("Place:");
        placeLabel.setBounds(320, 150, 250, 30);
        placeLabel.setForeground(new Color(253, 252, 233));
        placeLabel.setFont(new Font("Garet", Font.BOLD, 27));
        add(placeLabel);

        placesField = new JTextField();
        placesField.setBounds(420, 150, 150, 30);
        add(placesField);

        timeLabel = new JLabel("Time:");
        timeLabel.setBounds(590, 150, 250, 30);
        timeLabel.setForeground(new Color(253, 252, 233));
        timeLabel.setFont(new Font("Garet", Font.BOLD, 27));
        add(timeLabel);

        timeField = new JTextField();
        timeField.setBounds(670, 150, 150, 30);
        add(timeField);

        activityLabel = new JLabel("Activity:");
        activityLabel.setBounds(50, 200, 250, 30);
        activityLabel.setForeground(new Color(253, 252, 233));
        activityLabel.setFont(new Font("Garet", Font.BOLD, 25));
        add(activityLabel);

        activityField = new JTextField();
        activityField.setBounds(150, 200, 670, 30);
        add(activityField);

        rowBtn = new JButton("ADD ROW");
        rowBtn.setBounds(850, 150, 120, 30);
        rowBtn.setFont(new Font("Garet", Font.BOLD, 13));
        rowBtn.setBackground(new Color(180, 209, 224));
        rowBtn.setForeground(new Color(0, 0, 0));
        add(rowBtn);
        
        deleteBtn = new JButton("DELETE ROW");
        deleteBtn.setBounds(850, 200, 120, 30);
        deleteBtn.setFont(new Font("Garet", Font.BOLD, 13));
        deleteBtn.setBackground(new Color(180, 209, 224));
        deleteBtn.setForeground(new Color(0, 0, 0));
        add(deleteBtn);
        
        rowBtn.addActionListener(this);
        returnBtn.addActionListener(this);
        proceedBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        
        
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rowBtn){
                String date = dateField.getText();
                String place = placesField.getText();
                String time = timeField.getText();
                String activity = activityField.getText();

                if (date.isEmpty() || place.isEmpty() || time.isEmpty() || activity.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    itnryModel.addRow(new String[]{date, place, time, activity});

                    dateField.setText("");
                    placesField.setText("");
                    timeField.setText("");
                    activityField.setText("");
                }
              }else if(e.getSource() == deleteBtn){
                        int selectedRow = itnryTable.getSelectedRow();
                        if(selectedRow == -1){
                            JOptionPane.showMessageDialog(null, "Please select first a row to delete", "Error", JOptionPane.ERROR_MESSAGE );
             }else{
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected row?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION){
                        itnryModel.removeRow(selectedRow);
                    } 
                    else{
                        
                        
                    }
                    }
            } else if (e.getSource() == returnBtn){
                JOptionPane.showMessageDialog(this, "Returning to previous screen");
                dispose();
            }
              else if(e.getSource() == proceedBtn){
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to CLOSE?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if(confirm == 0){
                System.exit(0);
            }else{
                    
                }
                    
                }
}
}