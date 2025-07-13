/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.MineBank.app.Enums;

/**
 *
 * @author giann
 */
public enum TransactionType {
        DEPOSIT,
        WITHDRAW,
        TRANSFER;
        
        public boolean isDeposit() {
            return this == DEPOSIT;
        }
        
        public boolean isWithdraw() {
            return this == WITHDRAW;
        }
        
        public boolean isTransfer() {
            return this == TRANSFER;
        }
    }
