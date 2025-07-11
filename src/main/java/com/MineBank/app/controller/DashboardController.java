/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.controller;

import com.MineBank.app.*;
import com.MineBank.app.exceptions.AuthenticationException;
import com.MineBank.app.model.*;
import com.MineBank.app.repository.*;
import com.MineBank.app.utils.Utils;
import com.MineBank.app.view.*;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author giann
 */
public class DashboardController {
    private User user;
    private DashboardView view;
    private UserRepository repo;

    public DashboardController(User user, DashboardView view, UserRepository repo) {
        this.user = user;
        this.view = view;
        this.repo = repo;
    }

    public void handleDashboard() throws AuthenticationException {
        if(user == null) 
            throw new AuthenticationException("User not found!");
        
        
        

        this.view.renderHeader(user);
        this.view.setVisible(true);
        
        handleButtons();
    }
    
    private void handleButtons() {
        view.setTransactionHistoryBtnAction(e -> showTransactionHistoryFrame());
        view.setMoneyTransferBtnAction(e -> showMoneyTransferFrame());
        view.setDepositBtnAction(e -> showDepositFrame());
        view.setWithdrawBtnAction(e -> showWithdrawFrame());
    }
    
    private void showTransactionHistoryFrame() {
        System.out.println("Transaction History Btn Clicked");
    }
    
    private void showMoneyTransferFrame() {
        System.out.println("Money Transfer Btn Clicked");
    }
    
    private void showDepositFrame() {
        // prevents spamming
        view.setAllButtonsEnabled(false);
        
        DepositView depositView = new DepositView();
        depositView.setLocationRelativeTo(view);
        
        DepositController depositController = new DepositController(user, depositView, repo);
        
        // checks if the deposit view is closed
        depositView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                view.setVisible(true);
                view.setAllButtonsEnabled(true);
                updateUserInfo(depositController.user);
            }
        });
        
        view.setVisible(false);
        depositController.init();
    }
    
    
    private void showWithdrawFrame() {
        System.out.println("Withdraw btn clicked");
    }
    
    private void updateUserInfo(User updatedUser) {
        this.user = updatedUser;
        view.renderHeader(user);
    }
}
