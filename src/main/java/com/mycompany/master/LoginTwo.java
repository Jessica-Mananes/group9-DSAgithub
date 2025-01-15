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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Darrel
 */
public class LoginTwo extends JFrame implements ActionListener {

    // Declare UI components for the Login form
    private JTextField txtUserID;
    private JLabel lblUserID, lblPassword, lblLogo, lblSignin, lblLines, lblLines2;
    private JPasswordField password;
    private JButton btnLogin, btnSignup;
    private ImageIcon imgLogo;
    private Connection con;
    private PreparedStatement pst;

    public LoginTwo() {
        Connect();
         // Set up the JFrame properties
        setTitle("Login");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(37,113,128));
        
         // Load and display the logo
        imgLogo = new ImageIcon("C:\\Users\\Darrel\\Documents\\NetBeansProjects\\group9-DSAgithub\\src\\main\\java\\com\\mycompany\\master\\Capture1.JPG");
        lblLogo = new JLabel();
        lblLogo.setBounds(425, 40, 163, 134);
        lblLogo.setIcon(imgLogo);
        add(lblLogo);  
        
        // Add "Sign in" label for the login screen
        lblSignin = new JLabel("Sign in");
        lblSignin.setBounds(425,30,300,300);
        lblSignin.setFont(new Font("Garet",Font.BOLD,37));
        lblSignin.setForeground(new Color(234, 216, 177));
        add(lblSignin);
        
        // Add decorative lines to the UI
        lblLines = new JLabel("____________");
        lblLines.setBounds(157,15,300,300);
        lblLines.setFont(new Font("Garet",Font.BOLD,37));
        lblLines.setForeground(new Color(234, 216, 177));
        add(lblLines);
        
        lblLines2 = new JLabel("____________");
        lblLines2.setBounds(562,15,300,300);
        lblLines2.setFont(new Font("Garet",Font.BOLD,37));
        lblLines2.setForeground(new Color(234, 216, 177));
        add(lblLines2);
       
        // Add UserID label and input field
        lblUserID = new JLabel("UserID");
        lblUserID.setFont(new Font("Garet",Font.BOLD,26));
        lblUserID.setBounds(245, 115, 300, 300);
        lblUserID.setForeground(new Color(0, 0,0));
        add(lblUserID);
       
        txtUserID = new JTextField();
        txtUserID.setBounds(345, 248, 425, 35);
        txtUserID.setBackground(new Color(253, 252, 233));
        add(txtUserID);
       
        // Add Password label and password input field
        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Garet",Font.BOLD,26));
        lblPassword.setBounds(205, 185, 300, 300);
        lblPassword.setForeground(new Color(0, 0,0));
        add(lblPassword);

        password = new JPasswordField();
        password.setBounds(345, 318, 425, 35);
        password.setBackground(new Color(253, 252, 233));
        add(password);

        // Add the Signup button
        btnSignup = new JButton("SIGNUP");
        btnSignup.setBounds(265, 425, 217, 45);
        btnSignup.setFont(new Font("Garet",Font.BOLD,17));
        btnSignup.setBackground(new Color(57, 122, 144));
        btnSignup.setForeground(new Color(234, 216, 177));
        add(btnSignup);
       
        // Add the Login button
        btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(510, 425, 217, 45);
        btnLogin.setFont(new Font("Garet",Font.BOLD,17));
        btnLogin.setBackground(new Color(57, 122, 144));
        btnLogin.setForeground(new Color(234, 216, 177));
        add(btnLogin);
        
        // Make the frame visible
        setVisible(true);

        // Register action listeners for the buttons
        btnLogin.addActionListener(this);
        btnSignup.addActionListener(this);
        
    }
public void Connect(){
    String url = "jdbc:mysql://localhost:3306/groupninedsaproject";
    String username = "root";
    String password = "admin123";
    
    
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(LoginTwo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String userID = txtUserID.getText().trim();
            String userPassword = new String(password.getPassword());

            if (userID.isEmpty() || userPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else {
                 try {
                    String query = "SELECT * FROM signup WHERE UserID = ? AND Password = ?";
                    pst = con.prepareStatement(query);
                    pst.setString(1, userID);
                    pst.setString(2, userPassword);

                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        String firstName = rs.getString("FirstName");
                        String lastName = rs.getString("LastName");
                        String phoneNumber = rs.getString("PhoneNumber");

                        JOptionPane.showMessageDialog(this, "Login successful!");
                        new BookingFormTwo();
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(this, "Invalid UserID or Password!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(LoginTwo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (e.getSource() == btnSignup) {
            dispose();
            //new UserLoginTwo();
        }
    }
    }
