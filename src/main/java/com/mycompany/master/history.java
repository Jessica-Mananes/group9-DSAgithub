/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.master;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS X441U
 */
public class history extends JFrame implements ActionListener {
    
    //Components Declaration
    private JLabel userid, bookHistory;
    private JButton logout;
    private JTable historyTb;
    private DefaultTableModel historyModel;
    private JScrollPane historyTable;

    
    history() {
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 253, 208));
        setLocationRelativeTo(null);

        //User Label
        userid = new JLabel("USER ID: ");
        userid.setFont(new Font("Garet", Font.BOLD, 22));
        userid.setForeground(new Color(0, 0, 0));
        userid.setBounds(60, 40, 350, 50);
        add(userid);

        //Booking History Label
        bookHistory = new JLabel("BOOKING HISTORY");
        bookHistory.setFont(new Font("Garet", Font.BOLD, 25));
        bookHistory.setForeground(new Color(0, 0, 0));
        bookHistory.setBounds(60, 100, 350, 50);
        add(bookHistory);

        //Logout button
        logout = new JButton("LOGOUT");
        logout.setFont(new Font("Garet", Font.BOLD, 15));
        logout.setBounds(800, 40, 120, 30);
        add(logout);

        //Table Model used for Booking History
        String[] columns = {"Booking ID", "Flight ID", "Hotel ID", "Date & Time", "Total"};
        historyModel = new DefaultTableModel(columns, 0);

        //History Table
        historyTb = new JTable(historyModel);
        historyTb.setBackground(new Color(37, 113, 128));
        historyTb.setForeground(new Color(253, 252, 233));
        historyTb.setFont(new Font("Garet", Font.BOLD, 13));
        historyTb.setRowHeight(30);

        historyTable = new JScrollPane(historyTb);
        historyTable.setBounds(60, 160, 860, 295);
        add(historyTable);
        
        //Logout Button Function
        logout.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Action Listener for Logout Button
        int logout1 = JOptionPane.showConfirmDialog(history.this,"Are you sure you want to logout?","Confirm Logout",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (logout1 == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
}