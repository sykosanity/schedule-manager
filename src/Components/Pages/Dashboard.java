/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.Pages;

import java.awt.Dimension;

/**
 *
 * @author USER
 */
public class Dashboard extends javax.swing.JPanel {

    /**
     * Creates new form DashboardSection
     */
    public Dashboard() {
        initComponents();
        setLayout(new java.awt.BorderLayout());
        this.setPreferredSize(new Dimension(1050, 0));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("THIS IS THE DASHBOARD SECTION");
        add(jLabel2);
        jLabel2.setBounds(335, 0, 383, 40);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
