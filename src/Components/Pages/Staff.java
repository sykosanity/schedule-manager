/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.Pages;

import Components.ButtonInteractions.ButtonsEditor;
import Components.ButtonInteractions.ButtonsRenderer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Database.Database;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author USER
 */
public class Staff extends javax.swing.JPanel {

    private Component dialog;

    /**
     * Creates new form Admin
     */
    public Staff() {
        initComponents();
        this.setPreferredSize(new Dimension(1050, 720));
        jTable1.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof Boolean) {
                    JCheckBox checkbox = new JCheckBox();
                    checkbox.setSelected((Boolean) value);
                    checkbox.setHorizontalAlignment(JLabel.CENTER);
                    return checkbox;
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });
        setupUIEnhancements();
        populateTableWithAccounts();
    }

    private void customizeButtons() {

//        URL imageUrl = getClass().getResource("/Assets/Icons/edit.png");
//        if (imageUrl == null) {
//            System.out.println("Image not found!");
//        } else {
//            ImageIcon icon = new ImageIcon(imageUrl);
//        }
        // Load and resize icons
        ImageIcon deleteIcon = resizeIcon(new ImageIcon(getClass().getResource("/Assets/Icons/delete.png")), 25, 25);
        ImageIcon editIcon = resizeIcon(new ImageIcon(getClass().getResource("/Assets/Icons/edit16.png")), 155, 150);

        // Update icons and remove text if desired
        DeleteButton.setIcon(deleteIcon);
        DeleteButton.setText(""); // Remove text to show icon only

        UpdateButton.setIcon(editIcon);
        UpdateButton.setText(""); // Remove text to show icon only

        // Make buttons square and properly sized
        Dimension buttonSize = new Dimension(40, 40);
        DeleteButton.setPreferredSize(buttonSize);
        UpdateButton.setPreferredSize(buttonSize);

        // Optional - create button with rounded corners
        DeleteButton.setUI(new BasicButtonUI() {
            @Override
            public void update(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                AbstractButton button = (AbstractButton) c;
                ButtonModel model = button.getModel();

                int width = button.getWidth();
                int height = button.getHeight();

                if (model.isPressed()) {
                    g2.setColor(button.getBackground().darker());
                } else if (model.isRollover()) {
                    g2.setColor(button.getBackground().brighter());
                } else {
                    g2.setColor(button.getBackground());
                }

                g2.fillRoundRect(0, 0, width, height, 10, 10);
                g2.dispose();

                super.update(g, c);
            }
        });

        // Do the same for UpdateButton if desired
        UpdateButton.setUI(new BasicButtonUI() {
            // Same code as above
        });
    }

    private void setupUIEnhancements() {
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(false);
        jTable1.setIntercellSpacing(new Dimension(0, 0));

        // Create custom header renderer
        JTableHeader header = jTable1.getTableHeader();
        header.setBackground(new Color(4, 76, 172));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("SansSerif", Font.BOLD, 12));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));

        // Add custom column for action buttons
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // Change first column header from empty string to "Actions"
        model.setColumnIdentifiers(new Object[]{"Select", "Name", "Rank", "User_name"});

        jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        // Add alternating row colors
        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Skip the first column which has our custom renderer
                if (column != 0) {
                    if (!isSelected) {
                        c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 250));
                    } else {
                        c.setBackground(new Color(173, 216, 230));
                    }
                }

                return c;
            }
        });

        // Style buttons
        styleButton(AddButton, new Color(46, 204, 113));
        styleButton(UpdateButton, new Color(52, 152, 219));
        styleButton(DeleteButton, new Color(231, 76, 60));

        // Style search bar
        SearchBar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        SearchBar.setFont(new Font("SansSerif", Font.PLAIN, 14));
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 12));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new raven.crazypanel.CrazyPanel();
        ScrollPane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TabPanel = new raven.crazypanel.CrazyPanel();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        SearchBar = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setLayout(null);

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 76, 172)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Name", "Rank", "User_name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollPane.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        MainPanel.add(ScrollPane);
        ScrollPane.setBounds(20, 140, 980, 406);

        TabPanel.setBackground(new java.awt.Color(255, 255, 255));
        TabPanel.setPreferredSize(new java.awt.Dimension(1019, 34));
        TabPanel.setLayout(null);

        UpdateButton.setText("Update");
        UpdateButton.setMaximumSize(new java.awt.Dimension(100, 100));
        UpdateButton.setMinimumSize(new java.awt.Dimension(49, 28));
        UpdateButton.setName(""); // NOI18N
        UpdateButton.setPreferredSize(new java.awt.Dimension(49, 49));
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        TabPanel.add(UpdateButton);
        UpdateButton.setBounds(780, 10, 90, 30);

        DeleteButton.setText("Delete");
        DeleteButton.setMaximumSize(new java.awt.Dimension(100, 100));
        DeleteButton.setMinimumSize(new java.awt.Dimension(49, 49));
        DeleteButton.setName(""); // NOI18N
        DeleteButton.setPreferredSize(new java.awt.Dimension(49, 49));
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        TabPanel.add(DeleteButton);
        DeleteButton.setBounds(880, 10, 90, 30);

        SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBarActionPerformed(evt);
            }
        });
        TabPanel.add(SearchBar);
        SearchBar.setBounds(0, 10, 170, 28);

        AddButton.setText("Add");
        AddButton.setMaximumSize(new java.awt.Dimension(49, 49));
        AddButton.setMinimumSize(new java.awt.Dimension(49, 49));
        AddButton.setPreferredSize(new java.awt.Dimension(49, 49));
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        TabPanel.add(AddButton);
        AddButton.setBounds(680, 10, 90, 30);

        MainPanel.add(TabPanel);
        TabPanel.setBounds(20, 90, 980, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarActionPerformed
        // TODO add your handling code here:
        searchUsers();
    }//GEN-LAST:event_SearchBarActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();
        List<Integer> rowsToDelete = new ArrayList<>();
        StringBuilder selectedUsers = new StringBuilder();

        // find all checked rows
        for (int i = 0; i < rowCount; i++) {
            Boolean isChecked = (Boolean) model.getValueAt(i, 0);
            if (isChecked != null && isChecked) {
                rowsToDelete.add(i);
                selectedUsers.append("- ").append(model.getValueAt(i, 1)).append("\n");
            }
        }

        if (rowsToDelete.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "No user selected for deletion.");
            return;
        }

        //warning dialog
        int response = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete the following users?\n\n" + selectedUsers,
                "Confirm Deletion",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE
        );

        //delete users after confirmed
        if (response == javax.swing.JOptionPane.YES_OPTION) {
            for (int i = rowsToDelete.size() - 1; i >= 0; i--) {
                int rowIndex = rowsToDelete.get(i);
                String userName = (String) model.getValueAt(rowIndex, 3);  // getusername from the row

                //deletes the selected user from the database method
                removeUserFromDatabase(userName);
            }
            System.out.println("Deleted users:\n" + selectedUsers);
        } else {
            System.out.println("Deletion cancelled.");
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
        addNewUser();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // First, check for checkbox selections
        boolean hasCheckedRow = false;
        int checkedRowCount = 0;
        int lastCheckedRowIndex = -1;

        for (int i = 0; i < model.getRowCount(); i++) {
            Boolean isChecked = (Boolean) model.getValueAt(i, 0);
            if (isChecked != null && isChecked) {
                hasCheckedRow = true;
                checkedRowCount++;
                lastCheckedRowIndex = i;
            }
        }

        // Now check selected rows and make a decision based on both selection methods
        int[] selectedRows = jTable1.getSelectedRows();

        // If a row is checked via checkbox
        if (hasCheckedRow) {
            if (checkedRowCount > 1) {
                JOptionPane.showMessageDialog(this, "Please select only one user to update.");
                return;
            }

            // If exactly one row is checked, use that row
            String fullName = (String) model.getValueAt(lastCheckedRowIndex, 1);
            String rank = (String) model.getValueAt(lastCheckedRowIndex, 2);
            String userName = (String) model.getValueAt(lastCheckedRowIndex, 3);

            updateUserDialog(fullName, userName, rank);
            return;
        }

        // If no checkboxes are checked, use table row selection
        if (selectedRows.length != 1) {
            JOptionPane.showMessageDialog(this, "Please select exactly one row to update.");
            return;
        }

        // Get data from the selected row
        int selectedRow = selectedRows[0];
        String fullName = (String) model.getValueAt(selectedRow, 1);
        String rank = (String) model.getValueAt(selectedRow, 2);
        String userName = (String) model.getValueAt(selectedRow, 3);

        // Call method to open the update dialog and pre-fill data
        updateUserDialog(fullName, userName, rank);
    }

    private void updateUserInDatabase(String fullName, String originalUserName, String newUserName, String rank) {
        try (Connection connection = getConnection()) {
            // First check if the new username already exists (if it was changed)
            if (!originalUserName.equals(newUserName) && userExists(newUserName)) {
                JOptionPane.showMessageDialog(this, "Username '" + newUserName + "' already exists!");
                return;
            }

            String updateQuery = "UPDATE accounts SET full_name = ?, user_name = ?, rank = ? WHERE user_name = ?";
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setString(1, fullName);
            statement.setString(2, newUserName);
            statement.setString(3, rank);
            statement.setString(4, originalUserName);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "User updated successfully.");
                // Update the table after successful database update
                populateTableWithAccounts();
            } else {
                JOptionPane.showMessageDialog(this, "No user found with that username.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating user: " + e.getMessage());
        }
    }

    private void updateUserDialog(String fullName, String userName, String rank) {
        // Create a new dialog for updating user information
        JDialog updateDialog = new JDialog();
        updateDialog.setTitle("Update User");
        updateDialog.setSize(400, 280);
        updateDialog.setModal(true);
        updateDialog.setLayout(new BorderLayout());

        // Create main panel with padding
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create labels and text fields with pre-filled data
        JLabel fullNameLabel = new JLabel("Full Name:");
        JTextField fullNameField = new JTextField(fullName);
        fullNameField.setPreferredSize(new Dimension(200, 30));

        JLabel userNameLabel = new JLabel("Username:");
        JTextField userNameField = new JTextField(userName);
        userNameField.setPreferredSize(new Dimension(200, 30));

        JLabel rankLabel = new JLabel("Rank:");
        JTextField rankField = new JTextField(rank);
        rankField.setPreferredSize(new Dimension(200, 30));

        // Store the original username for reference
        final String originalUserName = userName;

        // Add components to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(fullNameLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(fullNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(userNameLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(userNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(rankLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(rankField, gbc);

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);

        // Create styled buttons
        JButton submitButton = new JButton("Update");
        submitButton.setBackground(new Color(52, 152, 219));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(189, 195, 199));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        // Add panels to dialog
        updateDialog.add(mainPanel, BorderLayout.CENTER);
        updateDialog.add(buttonPanel, BorderLayout.SOUTH);

        // Center the dialog on the screen
        updateDialog.setLocationRelativeTo(this);

        // Handle the submit button click event
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String newFullName = fullNameField.getText().trim();
                String newUserName = userNameField.getText().trim();
                String newRank = rankField.getText().trim();

                // Check if any field is empty
                if (newFullName.isEmpty() || newUserName.isEmpty() || newRank.isEmpty()) {
                    JOptionPane.showMessageDialog(updateDialog, "All fields are required!");
                    return;
                }

                if (Pattern.compile("\\d+").matcher(newFullName).find()) {
                    JOptionPane.showMessageDialog(updateDialog, "Full name should not contain numbers!");
                    return;
                }

                // Update the user in the database
                updateUserInDatabase(newFullName, originalUserName, newUserName, newRank);

                // Close the dialog
                updateDialog.dispose();
            }
        });

        // Handle the cancel button click event
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateDialog.dispose();
            }
        });

        // Show the dialog
        updateDialog.setVisible(true);
    }

    private void searchUsers() {
        String searchTerm = SearchBar.getText().toLowerCase().trim();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

        SearchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchUsers();
            }
        });

        try (Connection connection = getConnection()) {
            String query = "SELECT full_name, rank, user_name FROM accounts WHERE full_name LIKE ? OR rank LIKE ? OR user_name LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            String wildcard = "%" + searchTerm + "%";
            stmt.setString(1, wildcard);
            stmt.setString(2, wildcard);
            stmt.setString(3, wildcard);

            var resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String fullName = resultSet.getString("full_name");
                String rank = resultSet.getString("rank");
                String userName = resultSet.getString("user_name");

                // Add data to the table
                model.addRow(new Object[]{false, fullName, rank, userName});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error searching accounts: " + e.getMessage());
        }
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void addUserToDatabase(String fullName, String userName, String userPassword, String rank, String permissions) {
        try (Connection connection = getConnection()) {
            if (permissions == null || permissions.isEmpty()) {
                permissions = "user";
            }

            if (userExists(userName)) {
                JOptionPane.showMessageDialog(dialog, "Username already exists!");
                return;
            }

            String insertQuery = "INSERT INTO accounts (user_name, user_password, full_name, rank) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, userName);
            statement.setString(2, userPassword);
            statement.setString(3, fullName);
            statement.setString(4, rank);
            statement.executeUpdate();

            System.out.println("User " + userName + " added to database.");
            JOptionPane.showMessageDialog(this, "User added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding user to database: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error adding user: " + e.getMessage());
        }
    }

    private void addNewUser() {
        // Create a modal dialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Add New User");
        dialog.setSize(400, 320);
        dialog.setModal(true);
        dialog.setLayout(new BorderLayout());

        // Main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Labels and text fields with consistent styling
        JLabel titleLabel = new JLabel("Create New User Account");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setForeground(new Color(4, 76, 172));

        JLabel fullNameLabel = new JLabel("Full Name:");
        JTextField fullNameField = new JTextField();
        fullNameField.setPreferredSize(new Dimension(200, 30));

        JLabel userNameLabel = new JLabel("Username:");
        JTextField userNameField = new JTextField();
        userNameField.setPreferredSize(new Dimension(200, 30));

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30));

        JLabel rankLabel = new JLabel("Rank:");
        JTextField rankField = new JTextField();
        rankField.setPreferredSize(new Dimension(200, 30));

        // Add components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(new JSeparator(), gbc);

        gbc.gridy = 2;
        mainPanel.add(fullNameLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(fullNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(userNameLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(userNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(rankLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(rankField, gbc);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(46, 204, 113));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(189, 195, 199));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        // Add panels to dialog
        dialog.add(mainPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(this);

        // Submit button action
        submitButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            String fullName = fullNameField.getText().trim();
            String userName = userNameField.getText().trim();
            String userPassword = new String(passwordField.getPassword());
            String rank = rankField.getText().trim();

            // Validation
            if (fullName.isEmpty() || userName.isEmpty() || userPassword.isEmpty() || rank.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "All fields are required!");
                return;
            }

            if (Pattern.compile("\\d+").matcher(fullName).find()) {
                JOptionPane.showMessageDialog(dialog, "Full name should not contain numbers!");
                return;
            }

            // Adding to database
            addUserToDatabase(fullName, userName, userPassword, rank, "Basic");

            dialog.dispose();

            // Update table with the new user
            Database.initDatabase();
            populateTableWithAccounts();
        });

        // Cancel button
        cancelButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            dialog.dispose();
        });

        // Show dialog
        dialog.setVisible(true);
    }

    private boolean userExists(String userName) {
        try (Connection connection = getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM accounts WHERE user_name = ?");
            stmt.setString(1, userName);
            return stmt.executeQuery().next();
        } catch (SQLException e) {
            System.out.println("Error checking user: " + e.getMessage());
            return false;
        }
    }

    private void populateTableWithAccounts() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data in the table

        try (Connection connection = getConnection()) {
            String query = "SELECT full_name, rank, user_name FROM accounts";
            PreparedStatement stmt = connection.prepareStatement(query);
            var resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String fullName = resultSet.getString("full_name");
                String rank = resultSet.getString("rank");
                String userName = resultSet.getString("user_name");

                // Add data to the table
                model.addRow(new Object[]{false, fullName, rank, userName});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching accounts: " + e.getMessage());
        }
    }

    private void removeUserFromDatabase(String userName) {
        try (Connection connection = getConnection()) {
            String deleteQuery = "DELETE FROM accounts WHERE user_name = ?";
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.setString(1, userName);
            statement.executeUpdate();

            // Refresh data after deletion
            Database.initDatabase();
            populateTableWithAccounts(); // Update table with new data

            System.out.println("User " + userName + " deleted from database.");
        } catch (SQLException e) {
            System.out.println("Error deleting user from database: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error deleting user: " + e.getMessage());
        }
    }

    private double getAmount(int from, int to) {
        Random ran = new Random();
        return (ran.nextInt(to - from) + from) * ran.nextDouble();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_manager_db", "root", "");
    }

    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private raven.crazypanel.CrazyPanel MainPanel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTextField SearchBar;
    private raven.crazypanel.CrazyPanel TabPanel;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
