/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.controller;

import com.MineBank.app.model.Transaction;
import com.MineBank.app.model.User;
import com.MineBank.app.repository.TransactionsRepository;
import com.MineBank.app.view.TransactionHistoryView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author giann
 */
public class TransactHistoryCtrl {
    User user;
    TransactionHistoryView view;
    TransactionsRepository repo;

    public TransactHistoryCtrl(User user, TransactionHistoryView view, TransactionsRepository repo) {
        this.user = user;
        this.view = view;
        this.repo = repo;
    }

    public void init() {
        try {
            ArrayList<Transaction> transactions = repo.getUserTransactions(user.getAccNum());
            Collections.reverse(transactions);
            view.populateRows(transactions);
        } catch (IOException ioe) {
            System.out.println("Error in listing transactions.");
        }
        
        
        view.setVisible(true);
    }
    
}
