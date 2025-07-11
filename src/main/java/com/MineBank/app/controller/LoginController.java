/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.controller;
import com.MineBank.app.view.DashboardView;
import com.MineBank.app.view.LoginView;
import com.MineBank.app.service.AuthService;
import com.MineBank.app.service.UserService;
import com.MineBank.app.repository.UserRepository;
import com.MineBank.app.exceptions.AuthenticationException;
import com.MineBank.app.model.User;

/**
 *
 * @author giann
 */
public class LoginController {
    private LoginView view;
    private UserRepository repo;

    public LoginController(LoginView view, UserRepository repo) {
        this.view = view;
        this.repo = repo;
    }
    
    public void init() {
        view.setVisible(true);
        view.setLoginBtnAction(e -> handleLogin());
    }
    
    private void handleLogin() {
        String username = view.getUsername();
        String password = view.getPassword();
        
        AuthService authService = new AuthService();
        try {
            User user = authService.authUser(username, password, this.repo);
            DashboardView dashView = new DashboardView();
            DashboardController dashController = new DashboardController(user, dashView, repo);
            dashView.setLocationRelativeTo(view);
            view.dispose();
            dashController.handleDashboard();
            
        } catch (AuthenticationException e) {
            view.showInvalidCredentials(e.getMessage());
        } 
    }
    
    
}
