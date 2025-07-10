/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.model;

/**
 *
 * @author giann
 */
public class Transactions {
    public String ID;
    public String type;
    public double amount;
    public String dateTime;

    public Transactions(String ID, String type, double amount, String dateTime) {
        this.ID = ID;
        this.type = type;
        this.amount = amount;
        this.dateTime = dateTime;
    }
    
    
}
