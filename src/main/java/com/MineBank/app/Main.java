/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.MineBank.app;

import com.MineBank.app.view.LoginView;
import com.MineBank.app.repository.UserRepository;
import com.MineBank.app.controller.LoginController;
import java.util.*;
/**
 *
 * @author giann
 */
public class Main {
    public static void main(String[] args) {
//        new DepositView().setVisible(true);
        
        String path = "data\\user\\userData.txt";
        LoginController loginController = new LoginController(
                new LoginView(), 
                new UserRepository(path));
        loginController.init();

        
//        new LoginPage().setVisible(true);
    }
}
