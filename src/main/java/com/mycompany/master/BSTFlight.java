/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.master;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Marielle
 */
public class BSTFlight {
    private ArrayList<FlightInfo> flightList;
    
    // Node class to hold flight data
    static class FlightNode {
        FlightInfo flightinfo;
        FlightNode left;
        FlightNode right;
        
        FlightNode(FlightInfo flightinfo){
            this.flightinfo = flightinfo;
            this.left = null;
            this.right = null;
     
        }                        
    }
    
    // Root of the BST
    private FlightNode root;

    BSTFlight() {
        root = null;
    }
    
    //insert flight into bst
    public void insert(FlightInfo flightinfo){
        root = insertRecursive(root, flightinfo);
    }
    
    //Insert Recursive method
    private FlightNode insertRecursive(FlightNode root, FlightInfo flightinfo){
        if(root == null){
            return new FlightNode(flightinfo);          
        }
        
        if(flightinfo.departure().isBefore(root.flightinfo.departure())){
            root.left = insertRecursive(root.left, flightinfo);
        } else if(flightinfo.departure().isAfter(root.flightinfo.departure())){
            root.right = insertRecursive(root.right, flightinfo);
        } else {
            if(flightinfo.flightID().compareTo(root.flightinfo.flightID()) < 0 ){
               root.left = insertRecursive(root.left, flightinfo);
            } else if(flightinfo.flightID().compareTo(root.flightinfo.flightID()) > 0){
                root.right = insertRecursive(root.right, flightinfo);
            }
        }
        return root;
        
    }
    
    // manage flights by departure time (using inorder traversal)
    public ArrayList<FlightInfo> inorder(){
        flightList = new ArrayList<>();
        inorderRecursive(root, flightList);
        return flightList;
        
    }
    
    // Inorder Recursive method
    private void inorderRecursive(FlightNode root, ArrayList<FlightInfo> flightList){
        if(root != null){
           inorderRecursive(root.left, flightList);
           flightList.add(root.flightinfo);
           inorderRecursive(root.right, flightList);
        }
        
    }
    
    // Search for a flight by departure time
    public FlightNode search(LocalTime departureTime) {
    return searchRec(root, departureTime);
    }

    private FlightNode searchRec(FlightNode root, LocalTime departure) {
        if (root == null) {
        return null;
        }

        if (root.flightinfo.departure.equals(departure)) {
        return root;
        }

        if (departure.isBefore(root.flightinfo.departure)) {
        return searchRec(root.left, departure);
    }

        return searchRec(root.right, departure);
    }

}
         


