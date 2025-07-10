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
        
        
        Image scaledImage = new ImageIcon(user.getProfileImage()).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon profileImage = new ImageIcon(scaledImage);

        this.view.renderHeader(user.getFullName(), user.getAccNum(), profileImage);
        this.view.setVisible(true);
        
        handleButtons();
    }
    
    private void handleButtons() {
        view.setViewBalanceBtnAction(e -> showViewBalanceFrame());
        view.setViewTransactionBtnAction(e -> showViewTransactionsFrame());
        view.setDepositBtnAction(e -> showDepositFrame());
        view.setWithdrawBtnAction(e -> showWithdrawFrame());
    }
    
    private void showViewBalanceFrame() {
        System.out.println("View balance btn clicked");
    }
    
    private void showViewTransactionsFrame() {
        System.out.println("View Transactions btn clicked");
    }
    
    private void showDepositFrame() {
        // prevents spamming
        view.setAllButtonsEnabled(false);
        
        DepositView depositView = new DepositView();
        DepositController depositController = new DepositController(user, depositView, repo);
        
        // checks if the deposit view is closed
        depositView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                view.setVisible(true);
                view.setAllButtonsEnabled(true);
            }
        });
        
        view.setVisible(false);
        depositController.init();
    }
    
    
    private void showWithdrawFrame() {
        System.out.println("Withdraw btn clicked");
    }
}
