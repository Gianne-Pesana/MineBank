/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.MineBank.app.view;

import com.MineBank.app.Enums.TransactionType;
import com.MineBank.app.model.Transaction;
import com.MineBank.app.model.Transfer;
import com.MineBank.app.utils.Utils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author giann
 */
public class TransactionHistoryView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TransactionHistoryView.class.getName());

    /**
     * Creates new form TransactionHistoryView
     */
    public TransactionHistoryView() {
        initComponents();
        formatHeader();
        formatRows();
        formatScrollBar();
        setIconImage(new ImageIcon(DisplaysUtils.programIcon).getImage());
        jScrollPane2.getViewport().setBackground(new Color(250, 245, 230));

    }

    private void formatHeader() {
        JTableHeader header = jTable1.getTableHeader();
        header.setBackground(new Color(199, 160, 111)); // accent color
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Minecraft", Font.BOLD, 14));
        header.setOpaque(true);

        // Custom renderer to add padding
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                label.setHorizontalAlignment(CENTER); // Optional: center header text
                label.setBackground(new Color(199, 160, 111));
                label.setForeground(Color.BLACK);
                label.setFont(new Font("Minecraft", Font.BOLD, 14));

                label.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(245, 245, 245)), // right edge border
                        BorderFactory.createEmptyBorder(6, 12, 6, 12) // padding inside the cell
                ));

                return label;
            }
        });
    }

    private void formatRows() {
        // Make rows taller
        jTable1.setFont(new Font("Minecraft", Font.PLAIN, 14));
        jTable1.setRowHeight(28);
        jTable1.setGridColor(new Color(220, 210, 190)); // soft grid
        jTable1.setShowGrid(true);
        jTable1.setSelectionBackground(new Color(204, 213, 174)); // soft green
        jTable1.setSelectionForeground(Color.BLACK);
        jTable1.setBackground(new Color(250, 245, 230)); // table bg

        // Add space between cells (both horizontally and vertically)
        jTable1.setIntercellSpacing(new Dimension(2, 2));

        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                cell.setFont(new Font("Minecraft", Font.PLAIN, 14));
                cell.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12)); // padding

                if (!isSelected) {
                    // Alternating row colors
                    if (row % 2 == 0) {
                        cell.setBackground(new Color(250, 245, 230)); // even
                    } else {
                        cell.setBackground(new Color(245, 240, 220)); // odd
                    }
                    cell.setForeground(Color.BLACK);
                } else {
                    // Selection
                    cell.setBackground(new Color(204, 213, 174));
                    cell.setForeground(Color.BLACK);
                }

                return cell;
            }
        });
    }

    private void formatScrollBar() {
        JScrollBar verticalScrollBar = jScrollPane2.getVerticalScrollBar();
        verticalScrollBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                // Thumb (the draggable part)
                this.thumbColor = new Color(204, 213, 174); // soft green
                this.thumbDarkShadowColor = new Color(190, 200, 160); // subtle shading
                this.thumbHighlightColor = new Color(220, 230, 190);  // gentle highlight
                this.thumbLightShadowColor = new Color(230, 240, 200); // soft edge

                // Track (the background of the scrollbar)
                this.trackColor = new Color(245, 240, 225); // parchment
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton(); // hide the ↑
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton(); // hide the ↓
            }

            private JButton createZeroButton() {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(0, 0));
                btn.setMinimumSize(new Dimension(0, 0));
                btn.setMaximumSize(new Dimension(0, 0));
                btn.setVisible(false);
                return btn;
            }
        });
    }

    public void populateRows(ArrayList<Transaction> list) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for (Transaction t : list) {
            model.addRow(new Object[] {
                    t.getID(),
                    formatType(t),
                    formatAmount(t.getAmount(), t),
                    formatDateTime(t.getDateTime())
            });
        }
    }
    
    private String formatType(Transaction transaction) {
        String type = transaction.getTypeStr();
        
        if (transaction instanceof Transfer) {
            Transfer transfer = (Transfer) transaction;
            String postFix = 
                    transfer.isSender ? 
                    "to: " + transfer.recipientNum : 
                    "from: " + transfer.accNum;
            
            return type + " " + postFix;
        }
        
        return type;
    }
    
    private String formatAmount(double amount, Transaction t) {
        return getOperator(t) + " EMD " + DisplaysUtils.formatNumber(amount);
    }
    
    private char getOperator(Transaction transaction) {
        if (transaction instanceof Transfer) {
            Transfer transfer = (Transfer) transaction;
            return transfer.isSender ? '-' : '+';
        }

        return switch (transaction.type) {
            case DEPOSIT -> '+';
            case WITHDRAW -> '-';
            default -> '?';
        };
    }

    private String formatDateTime(LocalDateTime ldt) {
        DateTimeFormatter formatter = Utils.MMMM_dd_yy;
        return ldt.format(formatter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transaction History");
        setBackground(new java.awt.Color(235, 228, 211));

        jPanel1.setBackground(new java.awt.Color(235, 228, 211));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 200, 180)));

        jScrollPane2.setBackground(new java.awt.Color(250, 245, 230));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 160, 120)));
        jScrollPane2.setForeground(new java.awt.Color(250, 245, 230));
        jScrollPane2.setFont(new java.awt.Font("Minecraft", 0, 12)); // NOI18N

        jTable1.setBackground(new java.awt.Color(255, 250, 239));
        jTable1.setFont(new java.awt.Font("Minecraft", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "Type", "Amount", "Date & Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusTraversalPolicyProvider(true);
        jTable1.setGridColor(new java.awt.Color(150, 150, 150));
        jTable1.setShowGrid(true);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("minecrafter", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(19, 19, 19));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/coin-53px.png"))); // NOI18N
        jLabel1.setText("Transactions");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(10, 1, 1, 1)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TransactionHistoryView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
