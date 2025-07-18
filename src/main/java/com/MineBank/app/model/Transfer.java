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
public class Transfer extends Transaction {
    public String recipientNum;
    public boolean isSender;

    public Transfer(String accNum, String ID, double amount, LocalDateTime dateTime, String recipientNum, boolean isSender) {
        super(accNum, ID, TransactionType.TRANSFER, amount, dateTime);
        this.recipientNum = recipientNum;
        this.isSender = isSender;
    }

    
}
