package Components;



public class Login extends javax.swing.JFrame {
 
    public Login() {
        System.out.println("Initiated Login");
        initComponents();
        SetDefault();
    }

    public void SetDefault() {
        setSize(1280, 720); // Set to your preferred dimensions
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginContainer = new javax.swing.JPanel();
        LoginLogo = new javax.swing.JLabel();
        UsernameTxtField = new javax.swing.JTextField();
        PasswordTxtField = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
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
        LoginContainer.add(UsernameTxtField);
        UsernameTxtField.setBounds(30, 120, 210, 40);

        PasswordTxtField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PasswordTxtField.setText("Enter Password");
        LoginContainer.add(PasswordTxtField);
        PasswordTxtField.setBounds(30, 190, 210, 40);

        LoginButton.setBackground(new java.awt.Color(4, 75, 172));
        LoginButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Login");
        LoginButton.setToolTipText("");
        LoginButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LoginButton.setBorderPainted(false);
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        LoginContainer.add(LoginButton);
        LoginButton.setBounds(30, 260, 210, 40);

        getContentPane().add(LoginContainer);
        LoginContainer.setBounds(500, 100, 270, 490);

        BGImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/bgimage.png"))); // NOI18N
        getContentPane().add(BGImage);
        BGImage.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGImage;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel LoginContainer;
    private javax.swing.JLabel LoginLogo;
    private javax.swing.JTextField PasswordTxtField;
    private javax.swing.JTextField UsernameTxtField;
    // End of variables declaration//GEN-END:variables
}
