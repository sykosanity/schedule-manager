/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.Pages;

import java.sql.ResultSet;
import Components.ButtonInteractions.ButtonsRenderer;
import Components.ButtonInteractions.ButtonsEditor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Database.Database;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.net.URL;

/**
 *
 * @author USER
 */
public class Courses extends javax.swing.JPanel {

    private Component dialog;

    public Courses() {

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
        customizeButtons();
        setupSearchBarKeyListener();
        setupUIEnhancements();
        populateTableWithCourses();
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
        model.setColumnIdentifiers(new Object[]{"Select", "Course Code", "Course Title", "Course Type", "Units"});

        // Add action buttons renderer and editor to first column
        jTable1.getColumnModel().getColumn(0).setCellRenderer(new ButtonsRenderer());
        jTable1.getColumnModel().getColumn(0).setCellEditor(new ButtonsEditor(jTable1, this)); // Pass the current instance
        jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(15);
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
                "", "Course Code", "Course Title", "Course Type", "Units"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class

                , java.lang.Object.class

                , java.lang.Object.class

                , java.lang.Object.class

            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                if (columnIndex < types.length) {  // Check if the column index is within bounds
                    return types [columnIndex];
                }
                return Object.class; // Default to Object if the index is out of bounds
            }
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];  // Make only 'Select' column editable
            }
        });
        ScrollPane.setViewportView(jTable1);

        MainPanel.add(ScrollPane);
        ScrollPane.setBounds(20, 140, 980, 406);

        TabPanel.setBackground(new java.awt.Color(255, 255, 255));
        TabPanel.setPreferredSize(new java.awt.Dimension(1019, 34));
        TabPanel.setLayout(null);

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        TabPanel.add(UpdateButton);
        UpdateButton.setBounds(780, 10, 90, 28);

        DeleteButton.setText("Delete");
        DeleteButton.setMaximumSize(new java.awt.Dimension(49, 28));
        DeleteButton.setMinimumSize(new java.awt.Dimension(49, 28));
        DeleteButton.setName(""); // NOI18N
        DeleteButton.setPreferredSize(new java.awt.Dimension(49, 28));
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        TabPanel.add(DeleteButton);
        DeleteButton.setBounds(880, 10, 90, 28);

        SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBarActionPerformed(evt);
            }
        });
        TabPanel.add(SearchBar);
        SearchBar.setBounds(0, 10, 170, 28);

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        TabPanel.add(AddButton);
        AddButton.setBounds(680, 10, 90, 28);

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
        searchCourses();
    }//GEN-LAST:event_SearchBarActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();
        List<Integer> rowsToDelete = new ArrayList<>();
        StringBuilder selectedCourse = new StringBuilder();

        // find all checked rows
        for (int i = 0; i < rowCount; i++) {
            Boolean isChecked = (Boolean) model.getValueAt(i, 0);
            if (isChecked != null && isChecked) {
                rowsToDelete.add(i);
                selectedCourse.append("- ").append(model.getValueAt(i, 1)).append(" (").append(model.getValueAt(i, 2)).append(")\n");
            }
        }

        if (rowsToDelete.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "No course selected for deletion.");
            return;
        }

        // warning dialog
        int response = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete the following course/s?\n\n" + selectedCourse,
                "Confirm Deletion",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE
        );

        // delete users after confirmed
        if (response == javax.swing.JOptionPane.YES_OPTION) {
            for (int i = rowsToDelete.size() - 1; i >= 0; i--) {
                int rowIndex = rowsToDelete.get(i);
                String courseCode = (String) model.getValueAt(rowIndex, 1);

                // deletes the selected course from the database
                removeCourseFromDatabase(courseCode);
            }
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
        addNewCourse();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();
        int selectedCount = 0;
        int selectedRow = -1;

        // Find selected row
        for (int i = 0; i < rowCount; i++) {
            Boolean isChecked = (Boolean) model.getValueAt(i, 0);
            if (isChecked != null && isChecked) {
                selectedCount++;
                selectedRow = i;
            }
        }

        // Check selection
        if (selectedCount == 0) {
            JOptionPane.showMessageDialog(this, "Please select a course to update.");
            return;
        } else if (selectedCount > 1) {
            JOptionPane.showMessageDialog(this, "Please select only one course to update.");
            return;
        }

        // Get course data from selected row
        String courseCode = (String) model.getValueAt(selectedRow, 1);
        String courseTitle = (String) model.getValueAt(selectedRow, 2);
        String courseType = (String) model.getValueAt(selectedRow, 3);
        String courseUnits = (String) model.getValueAt(selectedRow, 4);

        // Open update dialog with the selected course data
        updateCourseDialog(courseCode, courseTitle, courseType, courseUnits);
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddButtonActionPerformed

    private void addCourseToDatabase(String courseCode, String courseTitle, String courseType, String courseUnits) {
        try (Connection connection = getConnection()) {
//            if (permissions == null || permissions.isEmpty()) {
//                permissions = "user";
//            }

            if (courseExists(courseCode)) {
                JOptionPane.showMessageDialog(dialog, "Course already exists!");
                return;
            }

            if (courseTitleExists(courseTitle)) {
                JOptionPane.showMessageDialog(dialog, "Course With this Title already exists!");
                return;
            }

            String insertQuery = "INSERT INTO courses (course_code, course_title, course_type, units) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, courseCode);
            statement.setString(2, courseTitle);
            statement.setString(3, courseType);
            statement.setString(4, courseUnits);
            statement.executeUpdate();

            System.out.println("Course: " + courseTitle + " added to database.");
            JOptionPane.showMessageDialog(this, "Course added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding course to database: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error adding course: " + e.getMessage());
        }
    }

    private void addNewCourse() {
        // Create a modal dialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Add New Course");
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
        JLabel titleLabel = new JLabel("Add New Course");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setForeground(new Color(4, 76, 172));

        JLabel courseCodeLabel = new JLabel("Course Code:");
        JTextField courseCodeField = new JTextField();
        courseCodeField.setPreferredSize(new Dimension(200, 30));

        JLabel courseTitleLabel = new JLabel("Course Title:");
        JTextField courseTitleField = new JTextField();
        courseTitleField.setPreferredSize(new Dimension(200, 30));

        JLabel courseTypeLabel = new JLabel("Course Type:");
        String[] courseTypes = {"Lab", "Lec"};
        JComboBox<String> courseTypeComboBox = new JComboBox<>(courseTypes);
        courseTypeComboBox.setPreferredSize(new Dimension(200, 30));

        JLabel unitsLabel = new JLabel("Units:");
        JTextField unitsField = new JTextField();
        unitsField.setPreferredSize(new Dimension(200, 30));

        // Add components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(new JSeparator(), gbc);

        gbc.gridy = 2;
        mainPanel.add(courseCodeLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(courseCodeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(courseTitleLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(courseTitleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(courseTypeLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(courseTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(unitsLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(unitsField, gbc);

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
            String courseCode = courseCodeField.getText().trim();
            String courseTitle = courseTitleField.getText().trim();
            String courseType = (String) courseTypeComboBox.getSelectedItem();
            String units = unitsField.getText().trim();

            // Validation
            if (courseCode.isEmpty() || courseTitle.isEmpty() || courseType.isEmpty() || units.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "All fields are required!");
                return;
            }
            try {
                float unitValue = Float.parseFloat(units);
                if (unitValue <= 0) {
                    JOptionPane.showMessageDialog(dialog, "Units must be a positive number!");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(dialog, "Units must be a valid number!");
                return;
            }
            // Adding to database
            addCourseToDatabase(courseCode, courseTitle, courseType, units);

            dialog.dispose();

            // Update table with the new user
            Database.initDatabase();
            populateTableWithCourses();
        });

        // Cancel button
        cancelButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            dialog.dispose();
        });

        // Show dialog
        dialog.setVisible(true);
    }

    private void searchCourses() {
        String searchText = SearchBar.getText().trim().toLowerCase();

        if (searchText.isEmpty()) {
            // If search field is empty, show all courses
            populateTableWithCourses();
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

        try (Connection connection = getConnection()) {
            String query = "SELECT course_code, course_title, course_type, units FROM courses "
                    + "WHERE LOWER(course_code) LIKE ? OR LOWER(course_title) LIKE ? OR LOWER(course_type) LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(query);

            String searchPattern = "%" + searchText + "%";
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);
            stmt.setString(3, searchPattern);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String courseCode = resultSet.getString("course_code");
                String courseTitle = resultSet.getString("course_title");
                String courseType = resultSet.getString("course_type");
                String courseUnits = resultSet.getString("units");

                model.addRow(new Object[]{false, courseCode, courseTitle, courseType, courseUnits});
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No courses found matching your search.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error searching courses: " + e.getMessage());
        }
    }

    private boolean courseExists(String courseCode) {
        try (Connection connection = getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM courses WHERE course_code = ?");
            stmt.setString(1, courseCode);
            return stmt.executeQuery().next();
        } catch (SQLException e) {
            System.out.println("Error checking course code: " + e.getMessage());
            return false;
        }
    }

    private boolean courseTitleExists(String courseTitle) {
        try (Connection connection = getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM courses WHERE course_title = ?");
            stmt.setString(1, courseTitle); // Change from 2 to 1
            return stmt.executeQuery().next();
        } catch (SQLException e) {
            System.out.println("Error checking course title: " + e.getMessage());
            return false;
        }
    }

    private boolean courseExistsExcludingCurrent(String courseCode, String originalCourseCode) {
        try (Connection connection = getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM courses WHERE course_code = ? AND course_code != ?");
            stmt.setString(1, courseCode);
            stmt.setString(2, originalCourseCode);
            return stmt.executeQuery().next();
        } catch (SQLException e) {
            System.out.println("Error checking course code: " + e.getMessage());
            return false;
        }
    }

    private boolean courseTitleExistsExcludingCurrent(String courseTitle, String originalCourseCode) {
        try (Connection connection = getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM courses WHERE course_title = ? AND course_code != ?");
            stmt.setString(1, courseTitle);
            stmt.setString(2, originalCourseCode);
            return stmt.executeQuery().next();
        } catch (SQLException e) {
            System.out.println("Error checking course title: " + e.getMessage());
            return false;
        }
    }

    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void populateTableWithCourses() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data in the table

        try (Connection connection = getConnection()) {
            String query = "SELECT course_code, course_title, course_type, units FROM courses";
            PreparedStatement stmt = connection.prepareStatement(query);
            var resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String courseCode = resultSet.getString("course_code");
                String courseTitle = resultSet.getString("course_title");
                String courseType = resultSet.getString("course_type");
                String courseUnits = resultSet.getString("units");

                // Add data to the table (false = checkbox initial state)
                model.addRow(new Object[]{false, courseCode, courseTitle, courseType, courseUnits});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching courses: " + e.getMessage());
        }
    }

    // Ensure this method is defined correctly
    public void removeCourseFromDatabase(String courseCode) {
        String sql = "DELETE FROM courses WHERE course_code = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseCode);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Course deleted successfully.");
                populateTableWithCourses(); // Refresh the table
            } else {
                JOptionPane.showMessageDialog(this, "Course not found.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error deleting course: " + e.getMessage());
        }
    }

    // Extract this to Database class
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_manager_db", "root", "");
    }

    private void updateCourseInDatabase(String originalCourseCode, String newCourseCode, String newCourseTitle, String newCourseType, String newUnits) {
        try (Connection connection = getConnection()) {
            // Check if new course code already exists (excluding current course)
            if (!originalCourseCode.equals(newCourseCode) && courseExistsExcludingCurrent(newCourseCode, originalCourseCode)) {
                JOptionPane.showMessageDialog(this, "Course code already exists!");
                return;
            }

            // Check if new course title already exists (excluding current course)
            if (courseTitleExistsExcludingCurrent(newCourseTitle, originalCourseCode)) {
                JOptionPane.showMessageDialog(this, "Course title already exists!");
                return;
            }

            // Validate units
            try {
                float unitValue = Float.parseFloat(newUnits);
                if (unitValue <= 0) {
                    JOptionPane.showMessageDialog(this, "Units must be a positive number!");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Units must be a valid number!");
                return;
            }

            // Update course in database
            String updateQuery = "UPDATE courses SET course_code = ?, course_title = ?, course_type = ?, units = ? WHERE course_code = ?";
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setString(1, newCourseCode);
            statement.setString(2, newCourseTitle);
            statement.setString(3, newCourseType);
            statement.setString(4, newUnits);
            statement.setString(5, originalCourseCode);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Course updated successfully!");
                // Refresh the table
                populateTableWithCourses();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update course. Please try again.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating course in database: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error updating course: " + e.getMessage());
        }
    }

    public void updateCourseDialog(String courseCode, String courseTitle, String courseType, String units) {
        // Create a new dialog for updating course information
        JDialog updateDialog = new JDialog();
        updateDialog.setTitle("Update Course");
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
        JLabel courseCodeLabel = new JLabel("Course Code:");
        JTextField courseCodeField = new JTextField(courseCode);
        courseCodeField.setPreferredSize(new Dimension(200, 30));

        JLabel courseTitleLabel = new JLabel("Course Title:");
        JTextField courseTitleField = new JTextField(courseTitle);
        courseTitleField.setPreferredSize(new Dimension(200, 30));

        JLabel courseTypeLabel = new JLabel("Course Type:");
        String[] courseTypes = {"Lab", "Lec"};
        JComboBox<String> courseTypeComboBox = new JComboBox<>(courseTypes);
        courseTypeComboBox.setSelectedItem(courseType);
        courseTypeComboBox.setPreferredSize(new Dimension(200, 30));

        JLabel unitsLabel = new JLabel("Units:");
        JTextField unitsField = new JTextField(units);
        unitsField.setPreferredSize(new Dimension(200, 30));

        // Add components to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(courseCodeLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(courseCodeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(courseTitleLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(courseTitleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(courseTypeLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(courseTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(unitsLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(unitsField, gbc);

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);

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
                String newCourseCode = courseCodeField.getText().trim();
                String newCourseTitle = courseTitleField.getText().trim();
                String newCourseType = (String) courseTypeComboBox.getSelectedItem();
                String newUnits = unitsField.getText().trim();

                // Check if any field is empty
                if (newCourseCode.isEmpty() || newCourseTitle.isEmpty() || newCourseType.isEmpty() || newUnits.isEmpty()) {
                    JOptionPane.showMessageDialog(updateDialog, "All fields are required!");
                    return;
                }

                // Update the course in the database
                updateCourseInDatabase(courseCode, newCourseCode, newCourseTitle, newCourseType, newUnits);

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

    private void setupSearchBarKeyListener() {
        SearchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchCourses();
            }
        });
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
