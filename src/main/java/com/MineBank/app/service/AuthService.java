/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.service;

import com.MineBank.app.exceptions.AuthenticationException;
import com.MineBank.app.model.User;
import com.MineBank.app.repository.UserRepository;
import java.util.*;


/**
 *
 * @author giann
 */
public class AuthService {
    // user related logic that supports the controller
    
    
    public User authUser(String username, String password, UserRepository repo) throws AuthenticationException {
        User user = repo.findUsername(username);
        // check user exists and incorrect password
        if(user == null) 
            throw new AuthenticationException("User not found!");
        
        if(!password.equals(user.getPassword()))
            throw new AuthenticationException("Incorrect password!");
        
        // check if validated
        if(user.getStatus().isPending()) {
            throw new AuthenticationException("Account is waiting for approval. Contact Admin.");
        } else if(user.getStatus().isDisabled()) {
            throw new AuthenticationException("Account is disabled.");
        } else {
            return user;
        }
        
    }
}
