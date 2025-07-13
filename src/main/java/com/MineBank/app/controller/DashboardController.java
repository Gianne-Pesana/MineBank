/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.controller;

import com.MineBank.app.exceptions.AuthenticationException;
import com.MineBank.app.model.*;
import com.MineBank.app.repository.*;
import com.MineBank.app.view.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author giann
☺ */
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
        view.setSettingsBtnAction(e -> showSettingsFrame());
    }
    
    private void showTransactionHistoryFrame() {
        view.setAllButtonsEnabled(false);
        
        TransactionsRepository trRepo = new TransactionsRepository();
        TransactionHistoryView trView = new TransactionHistoryView();
        trView.setLocationRelativeTo(view);
        
        TransactHistoryCtrl trController = new TransactHistoryCtrl(user, trView, trRepo);
        
        trView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                view.setVisible(true);
                view.setAllButtonsEnabled(true);
            }
        });
        
        view.setVisible(false);
        trController.init();
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
        // prevents spamming
        view.setAllButtonsEnabled(false);
        
        WithdrawView withdrawView = new WithdrawView();
        withdrawView.setLocationRelativeTo(view);
        
        WithdrawController withdrawController = new WithdrawController(user, withdrawView, repo);
        
        withdrawView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                view.setVisible(true);
                view.setAllButtonsEnabled(true);
                updateUserInfo(withdrawController.user);
            }
        });
        
        view.setVisible(false);
        withdrawController.init();
    }
    
    private void showSettingsFrame() {
        System.out.println("Settings Btn pressed.");
    }
    
    private void updateUserInfo(User updatedUser) {
        this.user = updatedUser;
        view.renderHeader(user);
    }
}
