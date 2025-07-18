/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.controller;

import com.MineBank.app.Enums.TransactionType;
import com.MineBank.app.model.Transaction;
import com.MineBank.app.model.Transfer;
import com.MineBank.app.model.User;
import com.MineBank.app.repository.TransactionsRepository;
import com.MineBank.app.repository.UserRepository;
import com.MineBank.app.service.TransactionsService;
import com.MineBank.app.view.ConfirmTransferView;
import com.MineBank.app.view.DisplaysUtils;
import com.MineBank.app.view.ReceiptModal;
import com.MineBank.app.view.TransactionAmtView;
import com.MineBank.app.view.TransferView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 *
 * @author giann
 */
public class TransferController {
    User user;
    TransferView recipientView;
    UserRepository userRepo;
    
    private double protectedTransferFee = 20;
    
    private ArrayList<User> usersList;
    private User recipient;
    private double transferAmt;
    
    private TransactionAmtView amountView;
    private ConfirmTransferView ctView;
    
    public TransferController(User user, TransferView recipientView, UserRepository userRepo) {
        this.user = user;
        this.recipientView = recipientView;
        this.userRepo = userRepo;
    }
    
    public void init() {
        usersList = userRepo.loadUsers();
        recipientView.checkInput(this);
        
        recipientView.setTransferBtnAction(e -> transfer());
        
        recipientView.setCancelBtnAction(e -> {
            recipientView.dispose();
        });
        recipientView.setVisible(true);
    }
    
    private void transfer() {
        recipient = validateAccount(recipientView.getInputFieldVal());
        
        if(recipient == null) {
            recipientView.showInvalidUser();
            return;
        }
        
        recipientView.setVisible(false);
        openAmountInput();
    }
    
    private void openAmountInput() {
        amountView = new TransactionAmtView(TransactionType.TRANSFER);
        amountView.renderUserInfo(user);
        amountView.setLocationRelativeTo(recipientView);
        
        amountView.setTransactionBtnAction(e -> {
            Double amt = Double.parseDouble(amountView.getInputAmountStr());
            
            if (!validateAmount(amt)) {
                return;
            }
            
            this.transferAmt = amt;
            recipientView.setVisible(false);
            amountView.setVisible(false);
            
            ctView = new ConfirmTransferView(recipient, transferAmt);
            ctView.setLocationRelativeTo(amountView);
            confirmTransfer();
            
        });
        
        amountView.setCancelBtnAction(e -> {
            amountView.dispose();
        });
        
        amountView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                recipientView.setVisible(true);
            }
        });
        
        amountView.setVisible(true);
    }
    
    private void confirmTransfer() {
        ctView.setConfirmBtnAction(e -> processTransfer());
        ctView.setCancelBtnAction(e -> {
            ctView.dispose();
        });
        
        ctView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                amountView.setVisible(true);
            }
        });
        
        ctView.setVisible(true);
    }
    
    private void processTransfer() {
        if (ctView.isProtectedTranfer()) {
            transferAmt += protectedTransferFee;
        }
        double userNewBalance = user.getBalance() - transferAmt;
        
        user.setBalance(userNewBalance);
        userRepo.updateUser(user);

        double recipientNewBalance = recipient.getBalance() + transferAmt;
        recipient.setBalance(recipientNewBalance);
        userRepo.updateUser(recipient);

        TransactionsRepository trRepo = new TransactionsRepository();
        Transaction senderTrn = null;
        Transaction recipientTrn = null;

        try {
            // sender
            senderTrn = new Transfer(
                user.getAccNum(),   // accNum
                TransactionsService.generateTransactionID(TransactionType.TRANSFER),
                transferAmt,
                LocalDateTime.now(),
                recipient.getAccNum(),
                true
            );

            // receiver
            recipientTrn = new Transfer(
                recipient.getAccNum(),   // accNum
                TransactionsService.generateTransactionID(TransactionType.TRANSFER),
                transferAmt,
                LocalDateTime.now(),
                user.getAccNum(),
                false
            );

            trRepo.saveTransaction(senderTrn);
            trRepo.saveTransaction(recipientTrn);

        } catch (IOException ie) {
            System.out.println("Error in saving transfer transaction");
        }

        createReceipt(senderTrn);
    }
    
    private void createReceipt(Transaction transaction) {
        ReceiptModal receipt = new ReceiptModal(ctView, true);
        if (ctView.isProtectedTranfer()) {
            receipt.addFee(protectedTransferFee);
        }
        ctView.setVisible(false);
        
        receipt.setHomeBtnAction(e -> {
            receipt.dispose();
            disposeAll();
        });
        
        receipt.showReceipt(transaction);
        
        
        receipt.setDefaultCloseOperation(receipt.DO_NOTHING_ON_CLOSE);
        receipt.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                receipt.dispose();
                disposeAll();
            }
        });
    }
    
    private void disposeAll() {
        ctView.dispose();
        amountView.dispose();
        recipientView.dispose();
    }
    
    public User validateAccount(String accNum) {
        for(User targetUser : usersList) {
            if(accNum.equals(targetUser.getAccNum()) && !accNum.equals(this.user.getAccNum())) {
                return targetUser;
            }
        }
        return null;
    }
    
    
    private boolean validateAmount(Double amount) {  
        if (amount <= 0) {
            DisplaysUtils.showError("Amount cannot be 0 or less!");
            return false;
        } else if (amount > user.getBalance()) {
            DisplaysUtils.showError("Insufficient Balance!");
            return false;
        } else {
            return true;
        }
    }
    
    public User getUser() {
        return this.user;
    }
}
