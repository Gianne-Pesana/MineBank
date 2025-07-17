/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.MineBank.app;

import com.MineBank.app.view.*;
import com.MineBank.app.repository.*;
import com.MineBank.app.controller.*;
import com.MineBank.app.model.User;
import java.util.*;
/**
 *
 * @author giann
 */
public class Main {
    // MAIN
    public static void main(String[] args) {  
//        new TransactionHistoryView().setVisible(true);

//        test();
        start();
    }
    
    public static void start() {
        String path = "data\\user\\userData.txt";
        LoginController loginController = new LoginController(
                new LoginView(), 
                new UserRepository(path));
        loginController.init();
    }
    
    public static void test() {
        TransferView trv = new TransferView();
        trv.displayFoundStatus(TransferView.loading);
        trv.setVisible(true);
    }
}
