/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.controller;

import com.MineBank.app.model.*;
import com.MineBank.app.repository.TransactionsRepository;
import com.MineBank.app.repository.UserRepository;
import com.MineBank.app.service.TransactionsService;
import com.MineBank.app.view.DepositView;
import com.MineBank.app.view.DisplaysUtils;
import java.time.LocalDateTime;
import java.util.IllegalFormatException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author giann
 */
public class DepositController {
    public User user;
    public DepositView view;
    
    private String amountStr;
    private double amount;
    private double newBalance;

    public DepositController(User user, DepositView view) {
        this.user = user;
        this.view = view;
    }
    
    public void init() {
        view.renderUserInfo(user);
        view.setVisible(true);
        deposit();
    }
    
    private void deposit() {
        view.setDepositBtnAction(e -> {
            updateBalance();
            createTransaction();
        });
        
        view.setCancelBtnAction(e -> {
             view.dispose();
        });
    }
    
    private void updateBalance() {
        amountStr = view.getInputAmountStr();
        if (amountStr.isEmpty()) {
            DisplaysUtils.showError("Please enter a value!");
        }

        try {
            amount = Double.parseDouble(amountStr);

            if(amount <= 0) {
                DisplaysUtils.showError("Please enter a positive value!");
                throw new IllegalArgumentException("Amount must be positive");
            }

            newBalance = user.getBalance() + amount;
            user.setBalance(newBalance);

        } catch (NumberFormatException exception) {
            DisplaysUtils.showError("Please enter a valid amount");
            throw new IllegalArgumentException("Invalid input", exception);
        }
    }
    
    private void createTransaction() {
        TransactionsRepository repo = new TransactionsRepository(user, amountStr)
        
        Transaction transaction = new Transaction(
                user.getAccNum(),
                TransactionsService.generateTransactionID("DEPOSIT"),
                "DEPOSIT",
                amount,
                LocalDateTime.now()
        );
        
        
    }
}
