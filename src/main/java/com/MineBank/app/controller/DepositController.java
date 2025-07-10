/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.controller;

import com.MineBank.app.model.*;
import com.MineBank.app.repository.UserRepository;
import com.MineBank.app.view.DepositView;
import com.MineBank.app.view.DisplaysUtils;
import java.util.IllegalFormatException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author giann
 */
public class DepositController {
    User user;
    DepositView view;
    UserRepository repo;

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
            String amountStr = view.getInputAmountStr();
            
            if (amountStr.isEmpty()) {
                DisplaysUtils.showError("Please enter a value!");
            }
            
            try {
                double amount = Double.parseDouble(amountStr);
                
                if(amount <= 0) {
                    DisplaysUtils.showError("Please enter a positive value!");
                    throw new IllegalArgumentException("Amount must be positive");
                }
                
                double newBalance = user.getBalance() + amount;
                user.setBalance(newBalance);
                 
            } catch (NumberFormatException exception) {
                DisplaysUtils.showError("Please enter a valid amount");
                throw new IllegalArgumentException("Invalid input", exception);
            }
        });
        
        view.setCancelBtnAction(e -> {
             view.dispose();
        });
    }
}
