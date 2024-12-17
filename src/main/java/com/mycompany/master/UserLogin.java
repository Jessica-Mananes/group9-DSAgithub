/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.master;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
//Declare GUI components 
public class UserLogin extends JFrame implements ActionListener {
    private JTextField txtFirstName, txtLastName, txtUserID,txtPhoneNumber;
    private JPasswordField txtPassword, txtConfirmPassword;
    private JButton btnCreateAccount;
    private JLabel lblFirstName,lblLastName,lblUserID,lblPassword,lblConfirmPassword,lblLogo,lblPhoneNumber;
    private ImageIcon imgLogo;

    //Constructor for the GUI Components
    UserLogin() {
        
        setTitle("Create Account");
        setSize(1000, 650);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(253,252,233));
        
        
        //Adds a logo to the frame
        imgLogo = new ImageIcon("C:\\Users\\Darrel\\Documents\\NetBeansProjects\\group9-DSAgithub\\src\\main\\java\\com\\mycompany\\master\\Capture.JPG");
        lblLogo = new JLabel();
        lblLogo.setBounds(400, 1, 163, 134);
        lblLogo.setIcon(imgLogo);
        add(lblLogo);      
       
        //Adds the First name Label and TextField
        lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(225, 125, 200, 30);
        lblFirstName.setFont(new Font("Garet",Font.BOLD,17));
        add(lblFirstName);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(225, 165, 250, 30);
        txtFirstName.setBackground(new Color(180, 204, 224));
        add(txtFirstName);
        
        //Adds the UserID Label and TextField
        lblUserID = new JLabel("UserID:");
        lblUserID.setBounds(225, 225, 200, 30);
        lblUserID.setFont(new Font("Garet",Font.BOLD,17));
        add(lblUserID);

        txtUserID = new JTextField();
        txtUserID.setBounds(225, 265, 250, 30);
        txtUserID.setBackground(new Color(180, 204, 224));
        add(txtUserID);
        
        //Adds the Password Label and PasswordField
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(225, 325, 200, 30);
        lblPassword.setFont(new Font("Garet",Font.BOLD,17));
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(225, 365, 250, 30);
        txtPassword.setBackground(new Color(180, 204, 224));
        add(txtPassword);
        
        // Add the LastName Label and TextField
        lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(515, 125, 200, 30);
        lblLastName.setFont(new Font("Garet",Font.BOLD,17));
        add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(515, 165, 250, 30);
        txtLastName.setBackground(new Color(180, 204, 224));
        add(txtLastName);
        
        // Adds the PhoneNumber Label and TextField
        lblPhoneNumber = new JLabel("Phone Number:");
        lblPhoneNumber.setBounds(515, 225, 200, 30);
        lblPhoneNumber.setFont(new Font("Garet",Font.BOLD,17));
        add(lblPhoneNumber);
        
        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setBounds(515, 265, 250, 30);
        txtPhoneNumber.setBackground(new Color(180, 204, 224));
        add(txtPhoneNumber);

        // Adds the Confirm Password Label and PasswordField
        lblConfirmPassword = new JLabel("Confirm Password:");
        lblConfirmPassword.setBounds(515, 325, 200, 30);
        lblConfirmPassword.setFont(new Font("Garet",Font.BOLD,17));
        add(lblConfirmPassword);

        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setBounds(515, 365, 250, 30);
        txtConfirmPassword.setBackground(new Color(180, 204, 224));
        add(txtConfirmPassword);
        
         // Adds the Create Account Button
        btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.setBounds(225, 440, 230, 45);
        btnCreateAccount.setFont(new Font("Garet",Font.BOLD,17));
        btnCreateAccount.setBackground(new Color(37, 113, 128));
        btnCreateAccount.setForeground(new Color(253, 252, 233));
        add(btnCreateAccount);
        
        btnCreateAccount.addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCreateAccount) {
            String firstName = txtFirstName.getText().trim();
            String lastName = txtLastName.getText().trim();
            String email = txtUserID.getText().trim();
            String password = new String(txtPassword.getPassword());
            String phoneNumber = new String(txtPhoneNumber.getText().trim());
            String confirmPassword = new String(txtConfirmPassword.getPassword());

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || phoneNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                
               
                dispose();
                new Login();
                 
            }
        }
    }


}
