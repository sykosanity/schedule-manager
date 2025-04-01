/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Components;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author USER
 */
public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
//        setLayout(null);  // Set JFrame layout to null

        Components.Pages.Dashboard dashboardSection = new Components.Pages.Dashboard();
        dashboardSection.setBounds(0, 0, 1050, 720); // Set position & size
        add(dashboardSection);  // Add the dashboard to the frame
        repaint();  // Refresh the UI     
        applyCustomComponents();                 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPane = new javax.swing.JPanel();
        DashboardOption = new javax.swing.JButton();
        ScheduleOption = new javax.swing.JButton();
        Option3 = new javax.swing.JButton();
        LogOutOption = new javax.swing.JButton();
        SettingsOption = new javax.swing.JButton();
        FeedbackOption = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UIPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.95F);

        PanelPane.setBackground(new java.awt.Color(4, 76, 172));
        PanelPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DashboardOption.setText("Dashboard");
        DashboardOption.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DashboardOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardOptionActionPerformed(evt);
            }
        });
        DashboardOption.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                DashboardOption.setBackground(new Color(36,100,180)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                DashboardOption.setBackground(new Color(4,76,172)); // Reset to default
            }
        });
        PanelPane.add(DashboardOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 250, 40));

        ScheduleOption.setText("Schedule");
        ScheduleOption.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ScheduleOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScheduleOptionActionPerformed(evt);
            }
        });
        ScheduleOption.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ScheduleOption.setBackground(new Color(36,100,180)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ScheduleOption.setBackground(new Color(4,76,172)); // Reset to default
            }
        });
        PanelPane.add(ScheduleOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 250, 40));

        Option3.setText("Option 3");
        Option3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Option3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option3ActionPerformed(evt);
            }
        });
        Option3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Option3.setBackground(new Color(36,100,180)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Option3.setBackground(new Color(4,76,172)); // Reset to default
            }
        });
        PanelPane.add(Option3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 250, 40));

        LogOutOption.setText("Log out");
        LogOutOption.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LogOutOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutOptionActionPerformed(evt);
            }
        });
        LogOutOption.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                LogOutOption.setBackground(new Color(36,100,180)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                LogOutOption.setBackground(new Color(4,76,172)); // Reset to default
            }
        });
        PanelPane.add(LogOutOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 250, 40));

        SettingsOption.setText("Settings");
        SettingsOption.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SettingsOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsOptionActionPerformed(evt);
            }
        });
        SettingsOption.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                SettingsOption.setBackground(new Color(36,100,180)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SettingsOption.setBackground(new Color(4,76,172)); // Reset to default
            }
        });
        PanelPane.add(SettingsOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 250, 40));

        FeedbackOption.setText("Feedback");
        FeedbackOption.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        FeedbackOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeedbackOptionActionPerformed(evt);
            }
        });
        FeedbackOption.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                FeedbackOption.setBackground(new Color(36,100,180)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                FeedbackOption.setBackground(new Color(4,76,172)); // Reset to default
            }
        });
        PanelPane.add(FeedbackOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 250, 40));
        PanelPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 80));
        jLabel2.add(new JLabel(new ImageIcon("C:\\Users\\bancr\\Documents\\GitHub\\schedule-manager\\build\\classes\\Assets\\Images\\logo.png")));
        ImageIcon icon = new ImageIcon("C:\\Users\\bancr\\Documents\\GitHub\\schedule-manager\\build\\classes\\Assets\\Images\\logo.png");
        Image image = icon.getImage().getScaledInstance(90, 80, Image.SCALE_SMOOTH);
        jLabel2.setIcon(new ImageIcon(image));

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hello User");
        PanelPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 100, 40));

        UIPane.setBackground(new java.awt.Color(255, 255, 255));
        UIPane.setPreferredSize(new java.awt.Dimension(1050, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("THIS IS THE DEFAULT TEXT UI");

        javax.swing.GroupLayout UIPaneLayout = new javax.swing.GroupLayout(UIPane);
        UIPane.setLayout(UIPaneLayout);
        UIPaneLayout.setHorizontalGroup(
            UIPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UIPaneLayout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(jLabel1)
                .addContainerGap(416, Short.MAX_VALUE))
        );
        UIPaneLayout.setVerticalGroup(
            UIPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UIPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(689, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UIPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPane, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(UIPane, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DashboardOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardOptionActionPerformed

        UIPane.removeAll();

        Components.Pages.Dashboard dash = new Components.Pages.Dashboard();

        dash.setBounds(0, 0, UIPane.getWidth(), UIPane.getHeight());

        UIPane.add(dash);
        UIPane.revalidate();
        UIPane.repaint();

    }//GEN-LAST:event_DashboardOptionActionPerformed

    private void ScheduleOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScheduleOptionActionPerformed

        UIPane.removeAll();

        Components.Pages.Schedule sched = new Components.Pages.Schedule();

        sched.setBounds(0, 0, UIPane.getWidth(), UIPane.getHeight());

        UIPane.add(sched);
        UIPane.revalidate();
        UIPane.repaint();

    }//GEN-LAST:event_ScheduleOptionActionPerformed

    private void LogOutOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogOutOptionActionPerformed

    private void SettingsOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SettingsOptionActionPerformed

    private void FeedbackOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeedbackOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FeedbackOptionActionPerformed

    private void Option3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Option3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    public void applyCustomComponents() {

        // Example: Customizing the UI after NetBeans-generated code
        DashboardOption.setUI(new mdlaf.components.button.MaterialButtonUI());
        DashboardOption.setBackground(new java.awt.Color(4, 76, 172)); // Blue
        DashboardOption.setForeground(java.awt.Color.WHITE);
        DashboardOption.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        DashboardOption.setBorderPainted(false);
        DashboardOption.setFocusPainted(false);
        DashboardOption.setOpaque(true);        

        // Example: Customizing the UI after NetBeans-generated code
        ScheduleOption.setUI(new mdlaf.components.button.MaterialButtonUI());
        ScheduleOption.setBackground(new java.awt.Color(4, 76, 172)); // Blue
        ScheduleOption.setForeground(java.awt.Color.WHITE);
        ScheduleOption.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        ScheduleOption.setBorderPainted(false);
        ScheduleOption.setFocusPainted(false);
        ScheduleOption.setOpaque(true);

        Option3.setUI(new mdlaf.components.button.MaterialButtonUI());
        Option3.setBackground(new java.awt.Color(4, 76, 172)); // Blue
        Option3.setForeground(java.awt.Color.WHITE);
        Option3.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        Option3.setBorderPainted(false);
        Option3.setFocusPainted(false);
        Option3.setOpaque(true);
        
        SettingsOption.setUI(new mdlaf.components.button.MaterialButtonUI());
        SettingsOption.setBackground(new java.awt.Color(4, 76, 172)); // Blue
        SettingsOption.setForeground(java.awt.Color.WHITE);
        SettingsOption.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        SettingsOption.setBorderPainted(false);
        SettingsOption.setFocusPainted(false);
        SettingsOption.setOpaque(true);
        
        ScheduleOption.setUI(new mdlaf.components.button.MaterialButtonUI());
        ScheduleOption.setBackground(new java.awt.Color(4, 76, 172)); // Blue
        ScheduleOption.setForeground(java.awt.Color.WHITE);
        ScheduleOption.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        ScheduleOption.setBorderPainted(false);
        ScheduleOption.setFocusPainted(false);
        ScheduleOption.setOpaque(true);
        
        FeedbackOption.setUI(new mdlaf.components.button.MaterialButtonUI());
        FeedbackOption.setBackground(new java.awt.Color(4, 76, 172)); // Blue
        FeedbackOption.setForeground(java.awt.Color.WHITE);
        FeedbackOption.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        FeedbackOption.setBorderPainted(false);
        FeedbackOption.setFocusPainted(false);
        FeedbackOption.setOpaque(true);
        
        LogOutOption.setUI(new mdlaf.components.button.MaterialButtonUI());
        LogOutOption.setBackground(new java.awt.Color(4, 76, 172)); // Blue
        LogOutOption.setForeground(java.awt.Color.WHITE);
        LogOutOption.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        LogOutOption.setBorderPainted(false);
        LogOutOption.setFocusPainted(false);
        LogOutOption.setOpaque(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DashboardOption;
    private javax.swing.JButton FeedbackOption;
    private javax.swing.JButton LogOutOption;
    private javax.swing.JButton Option3;
    private javax.swing.JPanel PanelPane;
    private javax.swing.JButton ScheduleOption;
    private javax.swing.JButton SettingsOption;
    private javax.swing.JPanel UIPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
