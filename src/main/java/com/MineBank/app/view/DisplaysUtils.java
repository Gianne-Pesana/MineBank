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
}
