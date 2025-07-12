/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.service;

import com.MineBank.app.model.Transaction;
import java.util.UUID;

/**
 *
 * @author giann
 */
public class TransactionsService {
    // update to handle multiple types of transactions
    
    public static String generateTransactionID(int transactionType) {
        String prefix = switch (transactionType) {
            case Transaction.DEPOSIT -> "DPS";
            case Transaction.WITHDRAW -> "WDR";
            default -> "TSN";
        };
        
        return prefix + "-" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}
