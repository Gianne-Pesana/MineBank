/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.repository;

import com.MineBank.app.Enums.TransactionType;
import com.MineBank.app.model.Transaction;
import com.MineBank.app.model.Transfer;
import com.MineBank.app.utils.Utils;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author giann
 */
public class TransactionsRepository {
    private String filePath;
    
    public TransactionsRepository() {
        filePath = "data\\transactions\\transactions.txt";
    }
    
    public TransactionsRepository(String filePath) throws FileNotFoundException {
        filePath = filePath.trim();
        File file = new File(filePath);
        if(!file.isFile()) {
            throw new FileNotFoundException("Error: Transactions file not found at: " + filePath);
        }
        
        this.filePath = filePath;
        
    }
    
    public void saveTransaction(Transaction transaction) throws IOException {
        try (FileWriter outFile = new FileWriter(filePath, true)) {
            outFile.append(
                    transaction.accNum + "|" + 
                    transaction.ID + "|" +
                    transaction.type + "|" +
                    transaction.amount + "|" +
                    transaction.dateTime.format(Utils.yyyy_MM_dd)
            );
            
            if (transaction instanceof Transfer) {
                outFile.append("|" + ((Transfer) transaction).recipientNum);
                outFile.append( "|" + ((Transfer) transaction).isSender);
            }
            
            outFile.append("\n");
            
        } catch(IOException e) {
            throw new IOException("Error: Failed to save transaction in path: " + filePath);
        }
    }
    
    public void saveTransaction(String accNum, String ID, String type, double amount, LocalDateTime dateTime) throws IOException {
        try (FileWriter outFile = new FileWriter(filePath)) {
            outFile.append(
                    accNum + "|" + 
                    ID + "|" +
                    type + "|" + 
                    amount + "|" +
                    dateTime.format(Utils.yyyy_MM_dd)          
            );
            
        } catch(IOException e) {
            throw new IOException("Error: Failed to save transaction in path: " + filePath);
        }
    }
    
    public ArrayList<Transaction> loadAllTransactions() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        
        try (BufferedReader inFile = new BufferedReader(new FileReader(filePath))) {
            int lineNum = 0;
            String line;
            
            while ((line = inFile.readLine()) != null) {
                lineNum++;
                String parts[] = line.split("\\|");
                
                // check length
                if(parts.length != 5 && parts.length != 7) {
                    System.out.println("Error: Invalid data.\n"
                            + "Skipping line " + lineNum);
                    continue;
                }
                
                // TRANSFER type
                if (parts[2].equalsIgnoreCase(TransactionType.TRANSFER.toString())) {
                    transactions.add(new Transfer(
                            parts[0],   // accNum
                            parts[1],   // ID
                            Double.parseDouble(parts[3]), // amount
                            LocalDateTime.parse(parts[4], Utils.yyyy_MM_dd),  // dateTime
                            parts[5],    // recipient account num
                            Boolean.parseBoolean(parts[6])
                    ));
                // DEPOSIT/WITHDRAW
                } else {
                    transactions.add(new Transaction(
                        parts[0],   // accNum
                        parts[1],   // ID
                        TransactionType.valueOf(parts[2]),   // type
                        Double.parseDouble(parts[3]), // amount
                        LocalDateTime.parse(parts[4], Utils.yyyy_MM_dd)  // dateTime
                        )   
                    );
                }
            }
        } catch(IOException e) {
            throw new IOException("Error: Failed to load all transactions in path: " + filePath);
        }
        
        return transactions;
    }
    
    public ArrayList<Transaction> getUserTransactions(String accNum) throws IOException{
        ArrayList<Transaction> userTransactions = new ArrayList<>();
        
        for (Transaction transaction : loadAllTransactions()) {
            if (accNum.equals(transaction.accNum)) {
                userTransactions.add(transaction);
            }
            
            // Handle transfer
            if (transaction instanceof Transfer) {
                Transfer transfer = (Transfer) transaction;
                if (accNum.equals(transfer.recipientNum)) {
                    userTransactions.add(transaction);
                }
            }
        }
        
        return userTransactions;
    }
}
