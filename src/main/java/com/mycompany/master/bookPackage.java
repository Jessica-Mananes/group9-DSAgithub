/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.master;

/**
 *
 * @author j&k
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class bookPackage extends JPanel implements ActionListener {
    
    //Components Declaration
    private JPanel bgColor;
    private URL pic1, pic2, pic3, pic4 = null;
    private JLabel packages, feature1, feature2, feature3, feature4, feature5, feature6, lblDate1, lblDate2, lblDate3, lblDate4;
    private JButton btnCountry, btnCountry2, btnCountry3, btnCountry4;
    private LinkedList<String> lblfeatures;

    //constructor for bookPackage class
    bookPackage() {
        setBackground(new Color(37, 113, 128));
       
        
        //
        setSize(1000, 600);
        
      
        //add the first label from bookPackage Tab
        packages = new JLabel("TRAVEL PACKAGES");
        packages.setBounds(300, 15, 400, 30);
        packages.setFont(new Font("Fira Code", Font.BOLD, 40)); 
        packages.setForeground(new Color(234, 216, 177));
        bgColor.add(packages);
        
        
        //Flight information label from bookPackage Tab
        lblDate1 = new JLabel("Flight Date: ");
        lblDate1.setFont(new Font("Garet", Font.BOLD, 13)); 
        lblDate1.setForeground(new Color(234, 216, 177));
        lblDate1.setBounds(85, 390, 180 ,40);
        bgColor.add(lblDate1);
        
        //Flight information label from bookPackage Tab
        lblDate2 = new JLabel("Flight Date: ");
        lblDate2.setFont(new Font("Garet", Font.BOLD, 13)); 
        lblDate2.setForeground(new Color(234, 216, 177));
        lblDate2.setBounds(295, 390, 180 ,40);
        bgColor.add(lblDate2);
        
        //Flight information label from bookPackage Tab
        lblDate3 = new JLabel("Flight Date: ");
        lblDate3.setFont(new Font("Garet", Font.BOLD, 13)); 
        lblDate3.setForeground(new Color(234, 216, 177));
        lblDate3.setBounds(505, 390, 180 ,40);
        bgColor.add(lblDate3);
        
        //Flight information label from bookPackage Tab
        lblDate4 = new JLabel("Flight Date: ");
        lblDate4.setFont(new Font("Garet", Font.BOLD, 13)); 
        lblDate4.setForeground(new Color(234, 216, 177));
        lblDate4.setBounds(715, 390, 180 ,40);
        bgColor.add(lblDate4);
        
        //Book button of Sydney Austrialia Package from the bookPackage
        btnCountry = new JButton("Sydney, Australia (PRICE)");
        btnCountry.setFont(new Font("Garet", Font.BOLD, 12)); 
        btnCountry.setBackground(new Color(253, 252, 233));
        btnCountry.setForeground(new Color(37, 113, 128));
        btnCountry.setBounds(85, 350, 180 ,40);
        bgColor.add(btnCountry);
        
        //Book button of Maui Hawaii USA Package from the bookPackage
        btnCountry2 = new JButton("Maui, Hawaii, USA (PRICE)");
        btnCountry2.setFont(new Font("Garet", Font.BOLD, 12)); 
        btnCountry2.setBackground(new Color(253, 252, 233));
        btnCountry2.setForeground(new Color(37, 113, 128));
        btnCountry2.setBounds(295, 350, 180 ,40);
        bgColor.add(btnCountry2);
        
        //Book button of Bangok Thailand Package from the bookPackage
        btnCountry3 = new JButton("Bangkok, Thailand (PRICE)");
        btnCountry3.setFont(new Font("Garet", Font.BOLD, 12)); 
        btnCountry3.setBackground(new Color(253, 252, 233));
        btnCountry3.setForeground(new Color(37, 113, 128));
        btnCountry3.setBounds(505, 350, 180 ,40);
        bgColor.add(btnCountry3);
        
        //Book button of Parice France Package from the bookPackage
        btnCountry4 = new JButton("Paris, France (PRICE)");
        btnCountry4.setFont(new Font("Garet", Font.BOLD, 12)); 
        btnCountry4.setBackground(new Color(253, 252, 233));
        btnCountry4.setForeground(new Color(37, 113, 128));
        btnCountry4.setBounds(715, 350, 180 ,40);
        bgColor.add(btnCountry4);
        
        //Image use to show the Sydney Austriala Package frm the bookPackage
        try {
            pic1 = new URL("https://i.pinimg.com/564x/fe/6b/7f/fe6b7f63e7fe424813974b93012f0c3d.jpg");
        } catch (MalformedURLException ex) {
            Logger.getLogger(bookPackage.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon imageIcon = new ImageIcon(pic1);
        Image imageScale = imageIcon.getImage().getScaledInstance(180, 300, Image.SCALE_SMOOTH);
        ImageIcon imageNew = new ImageIcon(imageScale);
        JLabel backgroundLabel = new JLabel(imageNew);
        backgroundLabel.setBounds(50, 70, 250, 290);
        bgColor.add(backgroundLabel);
        
        //Image use to show the Maui Hawaii Package frm the bookPackage
       try {
            pic2 = new URL("https://i.pinimg.com/564x/d8/00/7f/d8007f496b6a61841a267fd1ec05ba08.jpg");
        } catch (MalformedURLException ex) {
            Logger.getLogger(bookPackage.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon imageIcon1 = new ImageIcon(pic2);
        Image imageScale1 = imageIcon1.getImage().getScaledInstance(180, 300, Image.SCALE_SMOOTH);
        ImageIcon imageNew1 = new ImageIcon(imageScale1);
        JLabel backgroundLabel1 = new JLabel(imageNew1);
        backgroundLabel1.setBounds(260, 70, 250, 290);
        bgColor.add(backgroundLabel1);

        //Image use to show the Bangkok Thailand  Package frm the bookPackage
        try {
            pic3 = new URL("https://i.pinimg.com/736x/a8/a5/61/a8a5619a67d3502ff7eb1057137a784f.jpg");
        } catch (MalformedURLException ex) {
            Logger.getLogger(bookPackage.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon imageIcon2 = new ImageIcon(pic3);
        Image imageScale2 = imageIcon2.getImage().getScaledInstance(180, 300, Image.SCALE_SMOOTH);
        ImageIcon imageNew2 = new ImageIcon(imageScale2);
        JLabel backgroundLabel2 = new JLabel(imageNew2);
        backgroundLabel2.setBounds(470, 70, 250, 290);
        bgColor.add(backgroundLabel2);
        
        //Image use to show the Paris France Package frm the bookPackage
       try {
            pic4 = new URL("https://i.pinimg.com/564x/a6/5b/87/a65b8711fd3ec6fa6e7fca4e9d8578f5.jpg");
        } catch (MalformedURLException ex) {
            Logger.getLogger(bookPackage.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon imageIcon3 = new ImageIcon(pic4);
        Image imageScale3 = imageIcon3.getImage().getScaledInstance(180, 300, Image.SCALE_SMOOTH);
        ImageIcon imageNew3 = new ImageIcon(imageScale3);
        JLabel backgroundLabel3 = new JLabel(imageNew3);
        backgroundLabel3.setBounds(680, 70, 250, 290);
        bgColor.add(backgroundLabel3);
        
        //Label for Features used for Package
        feature1 = new JLabel("Features");
        feature1.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature1.setForeground(new Color(234, 216, 177));
        feature1.setBounds(85, 370, 180 ,150);
        bgColor.add(feature1);
        
        //Label for Features used for Package
        feature2 = new JLabel("● 10 Nights Hotel");
        feature2.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature2.setForeground(new Color(234, 216, 177));
        feature2.setBounds(85, 390, 180 ,150);
        bgColor.add(feature2);
        
        //Label for Features used for Package
        feature3 = new JLabel("● 24 Hours Travel Support");
        feature3.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature3.setForeground(new Color(234, 216, 177));
        feature3.setBounds(85, 405, 180 ,150);
        bgColor.add(feature3);        
        
        //Label for Features used for Package
        feature4 = new JLabel("»️︎ Manila - Sydney Australia");
        feature4.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature4.setForeground(new Color(234, 216, 177));
        feature4.setBounds(85, 420, 180 ,150);
        bgColor.add(feature4);
       
        //Label for Features used for Package
        feature5 = new JLabel("HOTEL INCLUDED:");
        feature5.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature5.setForeground(new Color(234, 216, 177));
        feature5.setBounds(85, 440, 180 ,150);
        bgColor.add(feature5);

        //Label for Features used for Package
        feature6 = new JLabel("Shangri-La Hotel, Sydney");
        feature6.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature6.setForeground(new Color(234, 216, 177));
        feature6.setBounds(85, 460, 180 ,150);
        bgColor.add(feature6);
        
        //Label for Features used for Package
        feature1 = new JLabel("Features");
        feature1.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature1.setForeground(new Color(234, 216, 177));
        feature1.setBounds(295, 370, 180 ,150);
        bgColor.add(feature1);

        //Label for Features used for Package
        feature2 = new JLabel("● 10 Nights Hotel");
        feature2.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature2.setForeground(new Color(234, 216, 177));
        feature2.setBounds(295, 390, 180 ,150);
        bgColor.add(feature2);
        
        //Label for Features used for Package
        feature3 = new JLabel("● 24 Hours Travel Support");
        feature3.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature3.setForeground(new Color(234, 216, 177));
        feature3.setBounds(295, 405, 180 ,150);
        bgColor.add(feature3);        
        
        //Label for Features used for Package
        feature4 = new JLabel("● Manila - Maui, Hawaii, USA");
        feature4.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature4.setForeground(new Color(234, 216, 177));
        feature4.setBounds(295, 420, 180 ,150);
        bgColor.add(feature4);
        
        //Label for Features used for Package
        feature5 = new JLabel("HOTEL INCLUDED:");
        feature5.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature5.setForeground(new Color(234, 216, 177));
        feature5.setBounds(295, 440, 180 ,150);
        bgColor.add(feature5);
        
        //Label for Features used for Package
        feature6 = new JLabel("Andaz Maui at Wailea Resort");
        feature6.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature6.setForeground(new Color(234, 216, 177));
        feature6.setBounds(295, 460, 180 ,150);
        bgColor.add(feature6);
        
        //Label for Features used for Package
        feature1 = new JLabel("Features");
        feature1.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature1.setForeground(new Color(234, 216, 177));
        feature1.setBounds(505, 370, 180 ,150);
        bgColor.add(feature1);
        
        //Label for Features used for Package
        feature2 = new JLabel("● 10 Nights Hotel");
        feature2.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature2.setForeground(new Color(234, 216, 177));
        feature2.setBounds(505, 390, 180 ,150);
        bgColor.add(feature2);
        
        //Label for Features used for Package
        feature3 = new JLabel("● 24 Hours Travel Support");
        feature3.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature3.setForeground(new Color(234, 216, 177));
        feature3.setBounds(505, 405, 180 ,150);
        bgColor.add(feature3);        
        
        //Label for Features used for Package
        feature4 = new JLabel("● Manila - Bangkok, Thailand");
        feature4.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature4.setForeground(new Color(234, 216, 177));
        feature4.setBounds(505, 420, 180 ,150);
        bgColor.add(feature4);
        
        //Label for Features used for Package
        feature5 = new JLabel("HOTEL INCLUDED:");
        feature5.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature5.setForeground(new Color(234, 216, 177));
        feature5.setBounds(505, 440, 180 ,150);
        bgColor.add(feature5);
        
        //Label for Features used for Package
        feature6 = new JLabel("Mandarin Oriental, Bangkok");
        feature6.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature6.setForeground(new Color(234, 216, 177));
        feature6.setBounds(505, 460, 180 ,150);
        bgColor.add(feature6);
        
        //Label for Features used for Package
        feature1 = new JLabel("Features");
        feature1.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature1.setForeground(new Color(234, 216, 177));
        feature1.setBounds(715, 370, 180 ,150);
        bgColor.add(feature1);
        
        //Label for Features used for Package
        feature2 = new JLabel("● 10 Nights Hotel");
        feature2.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature2.setForeground(new Color(234, 216, 177));
        feature2.setBounds(715, 390, 180 ,150);
        bgColor.add(feature2);
        
        //Label for Features used for Package
        feature3 = new JLabel("● 24 Hours Travel Support");
        feature3.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature3.setForeground(new Color(234, 216, 177));
        feature3.setBounds(715, 405, 180 ,150);
        bgColor.add(feature3);        
        
        //Label for Features used for Package
        feature4 = new JLabel("● Manila - Paris, France");
        feature4.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature4.setForeground(new Color(234, 216, 177));
        feature4.setBounds(715, 420, 180 ,150);
        bgColor.add(feature4);
        
        //Label for Features used for Package
        feature5 = new JLabel("HOTEL INCLUDED:");
        feature5.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature5.setForeground(new Color(234, 216, 177));
        feature5.setBounds(715, 440, 180 ,150);
        bgColor.add(feature5);
        
        //Label for Features used for Package
        feature6 = new JLabel("Le Meurice");
        feature6.setFont(new Font("Garet", Font.BOLD, 13)); 
        feature6.setForeground(new Color(234, 216, 177));
        feature6.setBounds(715, 460, 180 ,150);
        bgColor.add(feature6);
        
        //Adding Action Lisntener for Buttons in the Package
        btnCountry.addActionListener(this);
        btnCountry2.addActionListener(this);
        btnCountry3.addActionListener(this);
        btnCountry4.addActionListener(this);
       
      setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Action Listener function for button in the bookPackage
        int book = JOptionPane.showConfirmDialog(bookPackage.this,"Are you sure you want to book now?","Confirm Booking",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (book == JOptionPane.YES_OPTION) {
            String firstName = "";
            String lastName = "";
            String userID = "";
            String phoneNumber = "";
            new BookingFormTwo(firstName,lastName,userID,phoneNumber);
            
    }
        
    }
}
