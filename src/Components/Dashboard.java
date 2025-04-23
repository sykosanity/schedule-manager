package Components;

import Components.Pages.Dashboard;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.geom.Ellipse2D;
import java.io.File;
import javax.swing.filechooser.FileSystemView;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dashboard extends javax.swing.JFrame {

    public static String ImageURL = "https://cdn.discordapp.com/attachments/1286683285128216638/1356918173961687040/images.jpeg?ex=67ee5006&is=67ecfe86&hm=be42c32b864d5efaf49875d8e658a6c274501646112dbcef34cb96c074478a4d&";

    public dashboard() {

        initComponents();

        applyText();
        applyCustomComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPane = new javax.swing.JPanel();
        DashboardOption = new javax.swing.JButton();
        ScheduleOption = new javax.swing.JButton();
        StaffButton = new javax.swing.JButton();
        LogOutOption = new javax.swing.JButton();
        SettingsOption = new javax.swing.JButton();
        FeedbackOption = new javax.swing.JButton();
        CoursesButton = new javax.swing.JButton();
        ScheduleEditor = new javax.swing.JButton();
        PermissionText = new javax.swing.JLabel();
        ImageLabel = new javax.swing.JLabel();
        UserNameText = new javax.swing.JLabel();
        DashboardSectionLabel = new javax.swing.JLabel();
        OptionSectionLabel = new javax.swing.JLabel();
        AdminSectionLabel = new javax.swing.JLabel();
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
        PanelPane.add(DashboardOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 250, 40));

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
        PanelPane.add(ScheduleOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, 40));

        StaffButton.setText("Employees");
        StaffButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        StaffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StaffButtonActionPerformed(evt);
            }
        });
        StaffButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                StaffButton.setBackground(new Color(36,100,180)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                StaffButton.setBackground(new Color(4,76,172)); // Reset to default
            }
        });
        PanelPane.add(StaffButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 250, 40));

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
        PanelPane.add(LogOutOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 250, 40));

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
        PanelPane.add(SettingsOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 250, 40));

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
        PanelPane.add(FeedbackOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 250, 40));

        CoursesButton.setText("Courses");
        CoursesButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CoursesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoursesButtonActionPerformed(evt);
            }
        });
        StaffButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                StaffButton.setBackground(new Color(36,100,180)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                StaffButton.setBackground(new Color(4,76,172)); // Reset to default
            }
        });
        PanelPane.add(CoursesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 250, 40));

        ScheduleEditor.setText("Schedule Editor");
        ScheduleEditor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ScheduleEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScheduleEditorActionPerformed(evt);
            }
        });
        StaffButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                StaffButton.setBackground(new Color(36,100,180)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                StaffButton.setBackground(new Color(4,76,172)); // Reset to default
            }
        });
        PanelPane.add(ScheduleEditor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 250, 40));

        PermissionText.setBackground(java.awt.Color.white);
        PermissionText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PermissionText.setForeground(new java.awt.Color(255, 255, 255));
        PanelPane.add(PermissionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 230, 40));
        PanelPane.add(ImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 130));

        UserNameText.setBackground(java.awt.Color.white);
        UserNameText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UserNameText.setForeground(new java.awt.Color(255, 255, 255));
        UserNameText.setText("User");
        PanelPane.add(UserNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 230, 40));

        DashboardSectionLabel.setBackground(new java.awt.Color(255, 255, 255));
        DashboardSectionLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DashboardSectionLabel.setText("  Dashboard");
        PanelPane.add(DashboardSectionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 90, -1));

        OptionSectionLabel.setBackground(new java.awt.Color(255, 255, 255));
        OptionSectionLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        OptionSectionLabel.setText("  Options");
        PanelPane.add(OptionSectionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 90, -1));

        AdminSectionLabel.setBackground(new java.awt.Color(255, 255, 255));
        AdminSectionLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AdminSectionLabel.setText("  Admin");
        PanelPane.add(AdminSectionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 90, -1));

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
                .addContainerGap(426, Short.MAX_VALUE))
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
                .addComponent(UIPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE))
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
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutOptionActionPerformed

    private void SettingsOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SettingsOptionActionPerformed

    private void FeedbackOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeedbackOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FeedbackOptionActionPerformed

    private void StaffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StaffButtonActionPerformed

        UIPane.removeAll();

        Components.Pages.Staff staff = new Components.Pages.Staff();

        staff.setBounds(0, 0, UIPane.getWidth(), UIPane.getHeight());

        UIPane.add(staff);
        UIPane.revalidate();
        UIPane.repaint();

    }//GEN-LAST:event_StaffButtonActionPerformed

    private void CoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoursesButtonActionPerformed

        UIPane.removeAll();

        Components.Pages.Courses courses = new Components.Pages.Courses();

        courses.setBounds(0, 0, UIPane.getWidth(), UIPane.getHeight());

        UIPane.add(courses);
        UIPane.revalidate();
        UIPane.repaint();

    }//GEN-LAST:event_CoursesButtonActionPerformed

    private void ScheduleEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScheduleEditorActionPerformed

        UIPane.removeAll();

        Components.Pages.Schedule schedCreator = new Components.Pages.Schedule();

        schedCreator.setBounds(0, 0, UIPane.getWidth(), UIPane.getHeight());

        UIPane.add(schedCreator);
        UIPane.revalidate();
        UIPane.repaint();

    }//GEN-LAST:event_ScheduleEditorActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    public final void setProfilePicture() {
        setCircularImage(ImageLabel, ImageURL); // Replace with a direct image link

    }

    public final void setCircularImage(JLabel imageLabel, String imageUrl) {
        try {
            System.out.println("Attempting to load image...");

            // Load image from URL
            URL imageURL = new URL(imageUrl);
            BufferedImage originalImage = ImageIO.read(imageURL);

            // Get JLabel dimensions
            int labelWidth = imageLabel.getWidth();
            int labelHeight = imageLabel.getHeight();

            // Ensure JLabel has a valid size before resizing
            if (labelWidth > 0 && labelHeight > 0) {
                // Resize image to fit JLabel
                Image scaledImage = originalImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                BufferedImage resizedImage = new BufferedImage(labelWidth, labelHeight, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = resizedImage.createGraphics();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.drawImage(scaledImage, 0, 0, null);
                g2d.dispose();

                // Create circular image
                BufferedImage circularImage = new BufferedImage(labelWidth, labelHeight, BufferedImage.TYPE_INT_ARGB);
                g2d = circularImage.createGraphics();
                g2d.setClip(new Ellipse2D.Float(0, 0, labelWidth, labelHeight));
                g2d.drawImage(resizedImage, 0, 0, null);
                g2d.dispose();

                // Set the circular image as JLabel icon
                imageLabel.setIcon(new ImageIcon(circularImage));
                System.out.println("Image loaded and applied successfully!");
            } else {
                System.out.println("JLabel has zero size, cannot scale image yet.");
            }
        } catch (Exception e) {
            imageLabel.setText("Image not found");
            System.out.println("Image not found");
            e.printStackTrace();
        }
    }

    public void applyText() {
        String userRank = Login.USER_RANK;

        System.out.println("Permission Level = " + userRank);

        if ("Dean".equals(Login.USER_RANK) || "Academic Coordinator".equals(Login.USER_RANK)) {
            System.out.println("ADMIN");
            PermissionText.setText(userRank);
            PermissionText.setHorizontalAlignment(SwingConstants.CENTER);
            PermissionText.setVerticalAlignment(SwingConstants.CENTER);

            StaffButton.setVisible(true); // Hide the button when the action is triggered
            CoursesButton.setVisible(true);
            ScheduleEditor.setVisible(true);
            AdminSectionLabel.setVisible(true);
        } else {
            PermissionText.setText(userRank);
            PermissionText.setHorizontalAlignment(SwingConstants.CENTER);
            PermissionText.setVerticalAlignment(SwingConstants.CENTER);

            StaffButton.setVisible(false); // Hide the button when the action is triggered
            CoursesButton.setVisible(false);
            ScheduleEditor.setVisible(false);
            AdminSectionLabel.setVisible(false);

            System.out.println("USER");
        }

        UserNameText.setText(Login.USER_FULL_NAME);
        UserNameText.setHorizontalAlignment(SwingConstants.CENTER);
        UserNameText.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void applyCustomComponents() {

        DashboardOption.setUI(new mdlaf.components.button.MaterialButtonUI());
        DashboardOption.setBackground(new java.awt.Color(4, 76, 172)); // Blue
        DashboardOption.setForeground(java.awt.Color.WHITE);
        DashboardOption.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        DashboardOption.setBorderPainted(false);
        DashboardOption.setFocusPainted(false);
        DashboardOption.setOpaque(true);

        ScheduleOption.setUI(new mdlaf.components.button.MaterialButtonUI());
        ScheduleOption.setBackground(new java.awt.Color(4, 76, 172)); // Blue
        ScheduleOption.setForeground(java.awt.Color.WHITE);
        ScheduleOption.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        ScheduleOption.setBorderPainted(false);
        ScheduleOption.setFocusPainted(false);
        ScheduleOption.setOpaque(true);

        StaffButton.setUI(new mdlaf.components.button.MaterialButtonUI());
        StaffButton.setBackground(new java.awt.Color(4, 76, 172)); // Blue
        StaffButton.setForeground(java.awt.Color.WHITE);
        StaffButton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        StaffButton.setBorderPainted(false);
        StaffButton.setFocusPainted(false);
        StaffButton.setOpaque(true);

        CoursesButton.setUI(new mdlaf.components.button.MaterialButtonUI());
        CoursesButton.setBackground(new java.awt.Color(4, 76, 172)); // Blue
        CoursesButton.setForeground(java.awt.Color.WHITE);
        CoursesButton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        CoursesButton.setBorderPainted(false);
        CoursesButton.setFocusPainted(false);
        CoursesButton.setOpaque(true);
        CoursesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                CoursesButton.setBackground(new Color(36, 100, 180)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                CoursesButton.setBackground(new Color(4, 76, 172)); // Reset to default
            }
        });
        
        ScheduleEditor.setUI(new mdlaf.components.button.MaterialButtonUI());
        ScheduleEditor.setBackground(new java.awt.Color(4, 76, 172)); // Blue
        ScheduleEditor.setForeground(java.awt.Color.WHITE);
        ScheduleEditor.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        ScheduleEditor.setBorderPainted(false);
        ScheduleEditor.setFocusPainted(false);
        ScheduleEditor.setOpaque(true);
        ScheduleEditor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ScheduleEditor.setBackground(new Color(36, 100, 180)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ScheduleEditor.setBackground(new Color(4, 76, 172)); // Reset to default
            }
        });

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
    private javax.swing.JLabel AdminSectionLabel;
    private javax.swing.JButton CoursesButton;
    private javax.swing.JButton DashboardOption;
    private javax.swing.JLabel DashboardSectionLabel;
    private javax.swing.JButton FeedbackOption;
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JButton LogOutOption;
    private javax.swing.JLabel OptionSectionLabel;
    private javax.swing.JPanel PanelPane;
    private javax.swing.JLabel PermissionText;
    private javax.swing.JButton ScheduleEditor;
    private javax.swing.JButton ScheduleOption;
    private javax.swing.JButton SettingsOption;
    private javax.swing.JButton StaffButton;
    private javax.swing.JPanel UIPane;
    private javax.swing.JLabel UserNameText;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
