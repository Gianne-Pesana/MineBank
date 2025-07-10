/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.utils;

import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author giann
 */
public class Utils {
     public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    
    
    public static String toProperCase(String input) {
        input = input.trim();
        if(!input.contains(" ")) {
            return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
        }

        return input.substring(0, 1).toUpperCase()
                + input.substring(1, input.indexOf(" ")).toLowerCase()
                + " "
                + toProperCase(input.substring(input.indexOf(" ") + 1));
    }
    
    public static void showError(String message) {
        JOptionPane.showMessageDialog(
                null, 
                "Error: " + message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
