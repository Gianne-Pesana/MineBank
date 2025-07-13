/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.model;

import com.MineBank.app.Enums.TransactionType;
import java.time.LocalDateTime;

/**
 *
 * @author giann
 */

// POJO
public class Transaction {
    
    public String accNum;
    public String ID;
    public TransactionType type;
    public double amount;
    public LocalDateTime dateTime;

    public Transaction(String accNum, String ID, TransactionType type, double amount, LocalDateTime dateTime) {
        this.accNum = accNum;
        this.ID = ID;
        this.type = type;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTypeStr() {
        return this.type.name();
    }
    
    public TransactionType getType() {
        return this.type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
