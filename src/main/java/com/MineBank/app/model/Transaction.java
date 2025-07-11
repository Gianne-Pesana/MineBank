/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.model;

import java.time.LocalDateTime;

/**
 *
 * @author giann
 */
public class Transaction {
    public String accNum;
    public String ID;
    public String type;
    public double amount;
    public LocalDateTime dateTime;

    public Transaction(String accNum, String ID, String type, double amount, LocalDateTime dateTime) {
        this.accNum = accNum;
        this.ID = ID;
        this.type = type;
        this.amount = amount;
        this.dateTime = dateTime;
    }
    
    
    
}
