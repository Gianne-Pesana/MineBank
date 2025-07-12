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

// POJO
public class Transaction {
    public static final int DEPOSIT = 0;
    public static final int WITHDRAW = 1;
    
    public String accNum;
    public String ID;
    public int type;
    public double amount;
    public LocalDateTime dateTime;

    public Transaction(String accNum, String ID, int type, double amount, LocalDateTime dateTime) {
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
        return switch(type) {
            case DEPOSIT -> "DEPOSIT";
            case WITHDRAW -> "WITHDRAW";
            default -> "TRANSACTION";
        };
    }

    public void setType(int type) {
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
