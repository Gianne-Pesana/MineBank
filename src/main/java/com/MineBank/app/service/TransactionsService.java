/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.service;

import com.MineBank.app.Enums.TransactionType;
import com.MineBank.app.model.Transaction;
import java.util.UUID;

/**
 *
 * @author giann
 */
public class TransactionsService {
    // update to handle multiple types of transactions
    
    public static String generateTransactionID(TransactionType type) {
        String prefix = switch (type) {
            case TransactionType.DEPOSIT -> "DPS";
            case TransactionType.WITHDRAW -> "WDR";
            case TransactionType.TRANSFER -> "TFR";
            default -> "TSN";
        };
        
        return prefix + "-" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}
