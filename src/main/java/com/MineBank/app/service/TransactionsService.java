/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.service;

import java.util.UUID;

/**
 *
 * @author giann
 */
public class TransactionsService {
    public static String generateTransactionID(String transactionType) {
        String prefix = transactionType.equals("DEPOSIT") ? "DPS" : "WDR";
        return prefix + "-" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}
