/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.master;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

/**
 *
 * @author Marielle
 */
public class FlightInfo {
    String flightID;
    String destination;
    String travelClass;
    LocalTime departure;
    LocalDateTime arrival;
    double price;
        
    FlightInfo(String destination, LocalTime departure, String travelClass){
        this.destination = destination;
        this.travelClass = travelClass;
        this.departure = departure;
        this.flightID = getFlightId(destination);
        this.arrival = arrival();
        this.price = InitialPrice();
    

            
        }
        
        public LocalTime departure() {
        return departure;
    }
        
        public String flightID() {
        return flightID;
    }
        
    
    //flight ID generator
    private String getFlightId(String destination) {
        String[] words = destination.split(", ");
        String FLIGHTId = "FL";
        
        for (int f = 0; f < Math.min(3, words.length); f++) {
        FLIGHTId += words[f].substring(0, 1).toUpperCase();
    }
        
        FLIGHTId += String.format("%03d", new Random().nextInt(1000));  
        return FLIGHTId;
        
    } 
    
    //arrival time
    private LocalDateTime arrival(){
        int traveltime = 0;
        
        switch(destination){
            case "Paris, France" -> traveltime = 18;
            case "Kyoto, Japan" -> traveltime = 7;
            case "Rome, Italy" -> traveltime = 18;
            case "New York City, USA" -> traveltime = 16;
            case "Cape Town, South Africa" -> traveltime = 20;
            case "Bangkok, Thailand" -> traveltime = 3;
            case "Barcelona, Spain" -> traveltime = 19;
            case "Seoul, South Korea" -> traveltime = 4;
            case "Hawaii, USA" -> traveltime = 12;
            case "Sydney, Australia" -> traveltime = 8;
          
        }
        
        return LocalDateTime.of(LocalDateTime.now().toLocalDate(), departure).plusHours(traveltime);
    }
    
    //initial price
    private double InitialPrice(){
        double initialprice = 0.0;
        
        switch(destination){
            case "Paris, France" -> initialprice = 52000;
            case "Kyoto, Japan" -> initialprice = 16000;
            case "Rome, Italy" -> initialprice = 50320;
            case "New York City, USA" -> initialprice = 48000;
            case "Cape Town, South Africa" -> initialprice = 60000;
            case "Bangkok, Thailand" -> initialprice = 11850;
            case "Barcelona, Spain" -> initialprice = 55200;
            case "Seoul, South Korea" -> initialprice = 13500;
            case "Hawaii, USA" -> initialprice = 36350;
            case "Sydney, Australia" -> initialprice = 26580;
            
            
        }
        return classPrices(travelClass, initialprice);
        
    }
    
    //travel class prices
    public double classPrices(String TravelClass, double initialprice) {
    double pr = initialprice;

    switch (TravelClass) {
        case "Economy" -> pr = initialprice * 1.0; 
        case "Business" -> pr = initialprice * 2.0; 
        case "First Class" -> pr = initialprice * 4.0;
    }
    return pr;
        
    }

    }

