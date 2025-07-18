/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MineBank.app.view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author giann
 */
public class DisplaysUtils {

    public static String programIcon = "src\\main\\resources\\logo\\title_logo-64px.jpg";

    public static void showError(String error) {
        JDialog modal = new JDialog();
        modal.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(
                modal,
                "Error: " + error,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static String formatAmount(double amount) {
        return String.format("%.3f", amount);
    }
    
    public static String formatNumberLong(double num) {
        String numStr = String.valueOf(num);
        String[] parts = numStr.split("\\.");
        String formatted = String.format("%,d", Long.parseLong(parts[0]));
        return parts.length > 1 ? formatted + "." + parts[1] : formatted;
    }

    public static void showReceipt() {

    }
}
