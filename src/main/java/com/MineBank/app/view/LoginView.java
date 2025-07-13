
package com.MineBank.app.view;

import com.MineBank.app.controller.LoginController;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.net.*;

/**
 *
 * @author giann
 */

public class LoginView extends javax.swing.JFrame {
    private LoginController controller;
    
    
    public LoginView() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(DisplaysUtils.programIcon).getImage());
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        loginPassword = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        logoIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(227, 234, 236));
        jPanel1.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Minecraft Ten", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome, Miner!");
        jLabel1.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Minecraft", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(69, 69, 69));
        jLabel3.setText("Username");
        jLabel3.setFocusable(false);

        loginUsername.setBackground(new java.awt.Color(242, 242, 242));
        loginUsername.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        loginUsername.setForeground(new java.awt.Color(51, 51, 51));
        loginUsername.setToolTipText("");
        loginUsername.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 143, 179)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        loginUsername.setCaretColor(new java.awt.Color(153, 153, 153));
        loginUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        loginUsername.setMargin(new java.awt.Insets(2, 30, 2, 30));
        loginUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUsernameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Minecraft", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(69, 69, 69));
        jLabel4.setText("Password");

        loginPassword.setBackground(new java.awt.Color(243, 243, 243));
        loginPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        loginPassword.setForeground(new java.awt.Color(51, 51, 51));
        loginPassword.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(74, 143, 179)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        loginPassword.setMargin(new java.awt.Insets(2, 10, 2, 10));
        loginPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPasswordActionPerformed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(0, 132, 33));
        loginButton.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.setFocusable(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(loginPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(loginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(234, 223, 212));

        logoIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/minebank-transparent.png"))); // NOI18N
        logoIcon.setToolTipText("");
        logoIcon.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(logoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(logoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

//        controller.handleLogin(getUsername(), getPassword());
//        String usernameInput = loginUsername.getText();
//        String passwordInput = new String(loginPassword.getPassword());
//        
//        User user = new User("giannep", "test123", "Gianne", "Pesana", 560.23);
//        
//        if(usernameInput.equalsIgnoreCase(user.getUsername()) && passwordInput.equals(user.getPassword())) {
//            JOptionPane.showMessageDialog(this, "Login Confirmed!");
//            dispose();
//        }
//        else {
//            JOptionPane.showMessageDialog(this, "Invalid Credentials!", "Invalid", JOptionPane.ERROR_MESSAGE);
//            loginUsername.setText("");
//            loginPassword.setText("");
//            loginUsername.requestFocus(); // bring focus back to username field
//        }
      
    }//GEN-LAST:event_loginButtonActionPerformed

    private void loginPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPasswordActionPerformed
        loginButton.doClick();
    }//GEN-LAST:event_loginPasswordActionPerformed

    private void loginUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUsernameActionPerformed
        loginPassword.requestFocusInWindow();
    }//GEN-LAST:event_loginUsernameActionPerformed

    public void setLoginBtnAction(ActionListener listener) {
        loginButton.addActionListener(listener);
    }
    
    public void setController(LoginController controller) {
        this.controller = controller;
    }
    
    public void clearFields() {
        loginUsername.setText("");
        loginPassword.setText("");
        loginUsername.requestFocusInWindow();
    }
    
    public void showInvalidCredentials(String message) {
        JDialog modal = new JDialog();
        modal.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(
                modal, 
                message, 
                "Login Failed", 
                JOptionPane.ERROR_MESSAGE
        );
        
        
        clearFields();
    }
    
    // getters
    public String getUsername() {
        return loginUsername.getText();
    }
    
    public String getPassword() {
        return new String(loginPassword.getPassword());
    }
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField loginPassword;
    private javax.swing.JTextField loginUsername;
    private javax.swing.JLabel logoIcon;
    // End of variables declaration//GEN-END:variables

}

