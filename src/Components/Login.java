package Components;

import Database.Database;
import java.awt.Color;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import javax.swing.text.DefaultHighlighter;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.*;

public class Login extends javax.swing.JFrame {

    public Login() {
        System.out.println("Initiated Login");
        initComponents();
        SetDefault();
        applyCustomComponents();

        UsernameTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (UsernameTxtField.getText().equals("Enter Username/Id")) {
                    UsernameTxtField.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (UsernameTxtField.getText().isEmpty()) {
                    UsernameTxtField.setText("Enter Username/Id");
                }
            }
        });

        PasswordTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (new String(PasswordTxtField.getPassword()).equals("Enter Password")) {
                    PasswordTxtField.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (new String(PasswordTxtField.getPassword()).isEmpty()) {
                    PasswordTxtField.setText("Enter Password");
                }
            }
        });
    }

    public void SetDefault() {
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginContainer = new javax.swing.JPanel();
        LoginLogo = new javax.swing.JLabel();
        UsernameTxtField = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
        PasswordTxtField = new javax.swing.JPasswordField();
        BGImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        LoginContainer.setBackground(new java.awt.Color(255, 255, 255, 220));
        LoginContainer.setForeground(new java.awt.Color(30, 30, 30));
        LoginContainer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        LoginContainer.setEnabled(false);
        LoginContainer.setLayout(null);

        LoginLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/logo_w_txt.png"))); // NOI18N
        LoginContainer.add(LoginLogo);
        LoginLogo.setBounds(30, 10, 210, 90);

        UsernameTxtField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UsernameTxtField.setText("Enter Username/Id");
        UsernameTxtField.setSelectionColor(new java.awt.Color(4, 75, 172));
        UsernameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameTxtFieldActionPerformed(evt);
            }
        });
        LoginContainer.add(UsernameTxtField);
        UsernameTxtField.setBounds(30, 120, 210, 40);

        LoginButton.setBackground(new java.awt.Color(4, 75, 172));
        LoginButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Login");
        LoginButton.setToolTipText("");
        LoginButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LoginButton.setBorderPainted(false);
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        LoginContainer.add(LoginButton);
        LoginButton.setBounds(30, 260, 210, 40);

        PasswordTxtField.setText("Password");
        PasswordTxtField.setSelectionColor(new java.awt.Color(4, 75, 172));
        PasswordTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordTxtFieldActionPerformed(evt);
            }
        });
        LoginContainer.add(PasswordTxtField);
        PasswordTxtField.setBounds(30, 190, 210, 40);

        getContentPane().add(LoginContainer);
        LoginContainer.setBounds(500, 100, 270, 490);

        BGImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/bgimage.png"))); // NOI18N
        getContentPane().add(BGImage);
        BGImage.setBounds(0, 0, 1280, 720);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        String username = UsernameTxtField.getText().trim();
        String password = PasswordTxtField.getText().trim();

        // innput validation
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter both username and password",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // validate login
        Database.initDatabase(); // Fetch database records first
        boolean loginSuccessful = validateLogin(username, password);

        if (loginSuccessful) {
            // find users
            HashMap<String, String> userDetails = getUserDetails(username);

            if (userDetails != null) {
                // close login 
                this.dispose();
                SwingUtilities.invokeLater(() -> {

                });
            }
        } else {
            // login failed
            JOptionPane.showMessageDialog(this,
                    "Invalid username or password",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private boolean validateLogin(String username, String password) {

        List<HashMap<String, String>> accounts = Database.getDatabase();

        for (HashMap<String, String> account : accounts) {

            if (account.containsKey("user_name") && account.containsKey("user_password")) {

                System.out.println("ENTERED NAME: " + username);
                System.out.println("ENTERED PASSWORD: " + password);

                System.out.println(account.get("user_name"));
                System.out.println(account.get("user_password"));

                if (account.get("user_name").equals(username) && account.get("user_password").equals(password)) {
                    return true; // Login success
                }
            }
        }
        return false; // Login failure
    }

    // user details
    private HashMap<String, String> getUserDetails(String username) {
        List<HashMap<String, String>> accounts = Database.getDatabase();

        for (HashMap<String, String> account : accounts) {
            if (account.get("user_name").equals(username)) {
                return account;
            }
        }
        return null;

    }

    private void UsernameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameTxtFieldActionPerformed

    private void PasswordTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordTxtFieldActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    public void applyCustomComponents() {
        // Example: Customizing the JButton after NetBeans-generated code
        LoginButton.setUI(new mdlaf.components.button.MaterialButtonUI());
        LoginButton.setBackground(new java.awt.Color(33, 150, 243)); // Blue
        LoginButton.setForeground(java.awt.Color.WHITE);
        LoginButton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        LoginButton.setBorderPainted(false);
        LoginButton.setFocusPainted(false);
        LoginButton.setOpaque(true);

        UsernameTxtField.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // Custom font
        UsernameTxtField.setForeground(new java.awt.Color(0, 0, 0)); 
        UsernameTxtField.setBackground(new java.awt.Color(230, 230, 230)); // Light gray background
        UsernameTxtField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 75, 172)));
        UsernameTxtField.setCaretColor(new java.awt.Color(0, 0, 0)); 
        UsernameTxtField.setHorizontalAlignment(javax.swing.JTextField.CENTER); // Center text
        UsernameTxtField.setOpaque(true);

        PasswordTxtField.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)); // Custom font
        PasswordTxtField.setForeground(new java.awt.Color(0, 0, 0)); // Blue text color
        PasswordTxtField.setBackground(new java.awt.Color(230, 230, 230)); // Light gray background
        PasswordTxtField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(4, 75, 172)));
        PasswordTxtField.setCaretColor(new java.awt.Color(0, 0, 0)); // Blue cursor
        PasswordTxtField.setHorizontalAlignment(javax.swing.JTextField.CENTER); // Center text
        PasswordTxtField.setOpaque(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGImage;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel LoginContainer;
    private javax.swing.JLabel LoginLogo;
    private javax.swing.JPasswordField PasswordTxtField;
    private javax.swing.JTextField UsernameTxtField;
    // End of variables declaration//GEN-END:variables
}
