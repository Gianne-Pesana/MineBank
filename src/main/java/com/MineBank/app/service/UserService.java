/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.service;

import com.MineBank.app.utils.SessionManager;

/**
 *
 * @author giann
 */
public class UserService {
    public String generateSessionID() {
        return new SessionManager().generateSessionID();
    }
}
