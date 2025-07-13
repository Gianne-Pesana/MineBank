/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.controller;

import com.MineBank.app.Enums.TransactionType;
import com.MineBank.app.model.Transaction;
import com.MineBank.app.model.User;
import com.MineBank.app.repository.TransactionsRepository;
import com.MineBank.app.repository.UserRepository;
import com.MineBank.app.service.TransactionsService;
import com.MineBank.app.view.DisplaysUtils;
import com.MineBank.app.view.ReceiptModal;
import com.MineBank.app.view.WithdrawView;
import java.awt.DisplayMode;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.swing.JDialog;

/**
 *
 * @author giann
 */
public class WithdrawController {
    User user;
    WithdrawView view;
    UserRepository repo;
    
    private String amountStr;
    private double amount;
    private double oldBalance;
    private double newBalance;
    private Transaction transaction;

    public WithdrawController(User user, WithdrawView view, UserRepository repo) {
        this.user = user;
        this.view = view;
        this.repo = repo;
    }
    
    public void init() {
        oldBalance = user.getBalance();
        view.renderUserInfo(user);
        view.setVisible(true);
        withdraw();
    }
    
    private void withdraw() {
        view.setWithdrawBtnAction(e -> {
            if(!isValid()) return;
            
            updateBalance();
            saveTransaction();
        });
        
        view.setCancelBtnAction(e -> {
             view.dispose();
        });
    }
    
    private void updateBalance() {
        newBalance = oldBalance - amount;
        user.setBalance(newBalance);
        repo.updateUser(user);
    }
    
    private void saveTransaction() {
        try {
            TransactionsRepository tr = new TransactionsRepository();
        
            transaction = new Transaction(
                    user.getAccNum(),
                    TransactionsService.generateTransactionID(TransactionType.WITHDRAW),
                    TransactionType.WITHDRAW,
                    amount,
                    LocalDateTime.now()
            );

            tr.saveTransaction(transaction);
            createReceipt();
        } catch(IOException ioe) {
            System.out.println("Error in writing withdraw transaction");
        }
    }
    
    private boolean isValid() {
        amountStr = view.getInputAmountStr();
        try {
            amount = Double.parseDouble(amountStr);
            
            if (amount <= 0) {
                DisplaysUtils.showError("Please enter a positive value!");
                throw new IllegalArgumentException("Amount must be positive!");
            }
            
            if (amount > oldBalance || oldBalance == 0) {
                DisplaysUtils.showError("Insufficient Balance!");
                throw new IllegalArgumentException("Insufficient balance, cannot perform action");
            }
            
        } catch(NumberFormatException ne) {
            System.out.println(ne.getMessage());
            return false;
        }
        
        return true;
    }
    
    private void createReceipt() {
        ReceiptModal receipt = new ReceiptModal(view, true);
        receipt.setLocationRelativeTo(view);
        view.setVisible(false);
        
        receipt.setHomeBtnAction(e -> {
            receipt.dispose();
            view.dispose();
        });
        
        receipt.showReceipt(transaction);
        
        receipt.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        receipt.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                receipt.dispose();
                view.dispose();
            }
        });
        
    }
}
