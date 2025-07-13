/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.MineBank.app;

import com.MineBank.app.view.*;
import com.MineBank.app.repository.*;
import com.MineBank.app.controller.*;
import java.util.*;
/**
 *
 * @author giann
 */
public class Main {
    // MAIN
    public static void main(String[] args) {  
//        new TransactionHistoryView().setVisible(true);
        String path = "data\\user\\userData.txt";
        LoginController loginController = new LoginController(
                new LoginView(), 
                new UserRepository(path));
        loginController.init();
    }
}
