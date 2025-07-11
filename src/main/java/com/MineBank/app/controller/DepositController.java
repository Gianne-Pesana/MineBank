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
import com.MineBank.app.view.ReceiptModal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 * @author giann
 */
public class DepositController {
    public User user;
    public DepositView view;
    public UserRepository repo;
    
    private String amountStr;
    private double amount;
    private double newBalance;
    private Transaction transaction;

    public DepositController(User user, DepositView view, UserRepository repo) {
        this.user = user;
        this.view = view;
        this.repo = repo;
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
            repo.updateUser(user);

        } catch (NumberFormatException exception) {
            DisplaysUtils.showError("Please enter a valid amount");
            throw new IllegalArgumentException("Invalid input", exception);
        }
    }
    
    private void createTransaction() {
        try {
            TransactionsRepository repo = new TransactionsRepository("data\\transactions\\transactions.txt");

            transaction = new Transaction(
                    user.getAccNum(),
                    TransactionsService.generateTransactionID("DEPOSIT"),
                    "DEPOSIT",
                    amount,
                    LocalDateTime.now()
            );

            repo.saveTransaction(transaction);
            System.out.println("Transaction successfully created.");
            
            createReceipt();
            

        } catch (FileNotFoundException e) {
            System.err.println("Error: Transaction file not found.");
            e.printStackTrace(); // or show error dialog
        } catch (IOException e) {
            System.err.println("Error writing transaction to file.");
            e.printStackTrace(); // or show error dialog
        }
    }
    
    private void createReceipt() {
        ReceiptModal receipt = new ReceiptModal(view, true);
        view.setVisible(false);
        
        receipt.setHomeBtnAction(e -> {
            receipt.dispose();
            view.dispose();
        });
        
        receipt.showReceipt(transaction);
        
        
        receipt.setDefaultCloseOperation(receipt.DO_NOTHING_ON_CLOSE);
        receipt.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                receipt.dispose();
                view.dispose();
            }
        });
    }

}
