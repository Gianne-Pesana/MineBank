/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.MineBank.app;

/**
 *
 * @author giann
 */
public enum UserAccStatus {
    PENDING,
    DISABLED,
    ACTIVE;

   public boolean isPending() {
       return this == PENDING;
   }
   
   public boolean isDisabled() {
       return this == DISABLED;
   }
   
   public boolean isActive() {
       return this == ACTIVE;
   }
    
}
