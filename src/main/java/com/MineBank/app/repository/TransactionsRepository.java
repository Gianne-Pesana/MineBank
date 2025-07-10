/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.repository;

import com.MineBank.app.model.Transaction;
import com.MineBank.app.model.User;
import com.MineBank.app.utils.Utils;
import com.MineBank.app.view.DisplaysUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.imageio.IIOException;

/**
 *
 * @author giann
 */
public class TransactionsRepository {
    private User user;
    private String filePath;
    
    public TransactionsRepository(User user, String filePath) throws FileNotFoundException {
        filePath = filePath.trim();
        File file = new File(filePath);
        if(!file.isFile()) {
            throw new FileNotFoundException("Error: Transactions file not found at: " + filePath);
        }
        
        this.user = user;
        this.filePath = filePath;
        
    }
    
    public void saveTransaction(String accNum, String ID, String type, double amount, LocalDateTime dateTime) throws IOException {
        try (FileWriter outFile = new FileWriter(filePath)) {
            outFile.append(
                    accNum + "|" + 
                    ID + "|" +
                    type + "|" + 
                    amount + "|" +
                    dateTime.format(Utils.formatter)          
            );
            
        } catch(IOException e) {
            throw new IOException("Error: Failed to save transactions in path: " + filePath);
        }
    }
    
    public Transaction loadTransactions() {
        
    }
}
