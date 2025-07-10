/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.MineBank.app.view;

import com.MineBank.app.controller.DashboardController;
import com.MineBank.app.model.User;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author giann
 */
public class DashboardView extends javax.swing.JFrame {


    DashboardController controller;
    
    public DashboardView() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("src\\main\\resources\\logo\\title_logo-64px.jpg").getImage());
        
        // confirm exit
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JDialog dialog = new JDialog();
                dialog.setAlwaysOnTop(true);
                int result = 
                        JOptionPane.showConfirmDialog(
                                dialog, 
                                "Are you sure you want to exit?", 
                                "Confirmation", 
                                JOptionPane.OK_CANCEL_OPTION);
                if(result == JOptionPane.OK_OPTION) {
                    dispose();
                    System.exit(0);
                } else {
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        profilePicture = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        accNumLabel = new javax.swing.JLabel();
        settingsBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        viewBalanceBtn = new javax.swing.JButton();
        transactionBtn = new javax.swing.JButton();
        depositBtn = new javax.swing.JButton();
        withdrawBtn = new javax.swing.JButton();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 252, 241));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(228, 191, 156));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));

        profilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/default_profile_90px.jpg"))); // NOI18N
        profilePicture.setPreferredSize(new java.awt.Dimension(100, 100));

        nameLabel.setBackground(new java.awt.Color(0, 0, 0));
        nameLabel.setFont(new java.awt.Font("PixelPurl", 0, 32)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setText("Welcome, <user>!");
        nameLabel.setPreferredSize(new java.awt.Dimension(336, 31));
        nameLabel.setRequestFocusEnabled(false);

        accNumLabel.setBackground(new java.awt.Color(0, 0, 0));
        accNumLabel.setFont(new java.awt.Font("Minecraft", 0, 18)); // NOI18N
        accNumLabel.setForeground(new java.awt.Color(0, 0, 0));
        accNumLabel.setText("Account Number: <null>");
        accNumLabel.setPreferredSize(new java.awt.Dimension(336, 21));

        settingsBtn.setBackground(new java.awt.Color(218, 218, 218));
        settingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings-24px.png"))); // NOI18N
        settingsBtn.setFocusPainted(false);
        settingsBtn.setFocusable(false);
        settingsBtn.setMaximumSize(new java.awt.Dimension(30, 30));
        settingsBtn.setMinimumSize(new java.awt.Dimension(30, 30));
        settingsBtn.setOpaque(true);
        settingsBtn.setPreferredSize(new java.awt.Dimension(30, 30));
        settingsBtn.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                        .addComponent(accNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(settingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(profilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(settingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jSeparator1.setRequestFocusEnabled(false);

        jPanel3.setBackground(new java.awt.Color(254, 250, 224));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setFocusable(false);
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 20, 20));

        viewBalanceBtn.setBackground(new java.awt.Color(204, 213, 174));
        viewBalanceBtn.setFont(new java.awt.Font("Minecraft", 0, 18)); // NOI18N
        viewBalanceBtn.setForeground(new java.awt.Color(0, 0, 0));
        viewBalanceBtn.setText("View Balance");
        viewBalanceBtn.setFocusPainted(false);
        viewBalanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBalanceBtnActionPerformed(evt);
            }
        });
        jPanel3.add(viewBalanceBtn);

        transactionBtn.setBackground(new java.awt.Color(204, 213, 174));
        transactionBtn.setFont(new java.awt.Font("Minecraft", 0, 18)); // NOI18N
        transactionBtn.setForeground(new java.awt.Color(0, 0, 0));
        transactionBtn.setText("View Transaction History");
        transactionBtn.setFocusPainted(false);
        transactionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionBtnActionPerformed(evt);
            }
        });
        jPanel3.add(transactionBtn);

        depositBtn.setBackground(new java.awt.Color(204, 213, 174));
        depositBtn.setFont(new java.awt.Font("Minecraft", 0, 18)); // NOI18N
        depositBtn.setForeground(new java.awt.Color(0, 0, 0));
        depositBtn.setText("Deposit");
        depositBtn.setFocusPainted(false);
        depositBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositBtnActionPerformed(evt);
            }
        });
        jPanel3.add(depositBtn);

        withdrawBtn.setBackground(new java.awt.Color(204, 213, 174));
        withdrawBtn.setFont(new java.awt.Font("Minecraft", 0, 18)); // NOI18N
        withdrawBtn.setForeground(new java.awt.Color(0, 0, 0));
        withdrawBtn.setText("Withdraw");
        withdrawBtn.setFocusPainted(false);
        withdrawBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawBtnActionPerformed(evt);
            }
        });
        jPanel3.add(withdrawBtn);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/minebank-transparent-130px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void withdrawBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawBtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_withdrawBtnActionPerformed

    private void viewBalanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBalanceBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewBalanceBtnActionPerformed

    private void depositBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositBtnActionPerformed

    private void transactionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionBtnActionPerformed

    public void viewBalanceBtnAction(ActionListener listener) {
        viewBalanceBtn.addActionListener(listener);
    }
    
    
    public void setAllButtonsEnabled(Boolean enabled) {
        viewBalanceBtn.setEnabled(enabled);
        transactionBtn.setEnabled(enabled);
        depositBtn.setEnabled(enabled);
        withdrawBtn.setEnabled(enabled);
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardView().setVisible(true);
            }
        });
    }
    
    public void setController(DashboardController controller) {
        this.controller = controller;
    }
    
    public void renderHeader(String name, String accNum, ImageIcon icon) {
        nameLabel.setText("Welcome, " + name + "!");
        accNumLabel.setText("Account Number: " + accNum);
        profilePicture.setIcon(icon);
    }
    
    public void setViewBalanceBtnAction(ActionListener listener) {
        viewBalanceBtn.addActionListener(listener);
    }
    
    public void setViewTransactionBtnAction(ActionListener listener) {
        transactionBtn.addActionListener(listener);
    }
    
    public void setDepositBtnAction(ActionListener listener) {
        depositBtn.addActionListener(listener);
    }
    
    public void setWithdrawBtnAction(ActionListener listener) {
        withdrawBtn.addActionListener(listener);
    }
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accNumLabel;
    private javax.swing.JButton depositBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel profilePicture;
    private javax.swing.JButton settingsBtn;
    private javax.swing.JButton transactionBtn;
    private javax.swing.JButton viewBalanceBtn;
    private javax.swing.JButton withdrawBtn;
    // End of variables declaration//GEN-END:variables

}
