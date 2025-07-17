/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.controller;

import com.MineBank.app.model.User;
import com.MineBank.app.repository.UserRepository;
import com.MineBank.app.view.ConfirmTransferView;
import com.MineBank.app.view.DisplaysUtils;
import com.MineBank.app.view.TransferView;
import java.util.ArrayList;
import jdk.javadoc.doclet.Reporter;

/**
 *
 * @author giann
 */
public class TransferController {
    User user;
    TransferView view;
    UserRepository userRepo;
    
    private ArrayList<User> usersList;
    private User receipient;
    
    public TransferController(User user, TransferView view, UserRepository userRepo) {
        this.user = user;
        this.view = view;
        this.userRepo = userRepo;
    }
    
    public void init() {
        usersList = userRepo.loadUsers();
        view.checkInput(this);
        view.setTransferBtnAction(e -> transfer());
        view.setCancelBtnAction(e -> {
            view.dispose();
        });
        view.setVisible(true);
    }
    
    private void transfer() {
        receipient = validateAccount(view.getInputFieldVal());
        
        if(receipient == null) {
            view.showUserNotFound();
            return;
        }
        
        confirmTransfer();
    }
    
    private void confirmTransfer() {
        ConfirmTransferView ctView = new ConfirmTransferView();
        
    }
    
    public User validateAccount(String accNum) {
        for(User user : usersList) {
            if(accNum.equals(user.getAccNum())) {
                System.out.println("User found");
                return user;
            }
        }
        
        System.out.println("User not found!");
        return null;
    }
    
}
