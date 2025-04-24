package Components.Pages;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;

public class Dashboard extends javax.swing.JPanel {

    private JTable employeeTable;
    private JScrollPane scrollPane;
    private JPanel headerPanel;
    private JLabel dashboardTitle;
    private JPanel noticePanel;
    private JLabel noticeTitle;
    private JScrollPane noticeScrollPane;
    private JTextArea noticeContent;

    public Dashboard() {
        initComponents();
        setupCustomComponents();
        populateTableWithEmployees();
    }

    private void setupCustomComponents() {
        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(new Color(240, 240, 240));
        this.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Create header panel with title
        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(255, 255, 255));
        headerPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1),
                new EmptyBorder(15, 20, 15, 20)
        ));

        dashboardTitle = new JLabel("Employee Management Dashboard");
        dashboardTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        dashboardTitle.setForeground(new Color(60, 60, 60));
        headerPanel.add(dashboardTitle, BorderLayout.WEST);

        // Create main panel with split content
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        gbc.weighty = 1.0;

        // Create table panel
        JPanel tablePanel = createTablePanel();
        contentPanel.add(tablePanel, gbc);

        // Create notice board panel
        gbc.gridx = 1;
        gbc.weightx = 0.3;
        gbc.insets = new Insets(0, 0, 0, 0);

        noticePanel = createNoticePanel();
        contentPanel.add(noticePanel, gbc);

        // Add components to main panel
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 10));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1),
                new EmptyBorder(15, 15, 15, 15)
        ));

        JLabel tableTitle = new JLabel("Employee Data");
        tableTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tableTitle.setForeground(new Color(60, 60, 60));
        panel.add(tableTitle, BorderLayout.NORTH);

        // Create the table
        employeeTable = new JTable();
        setupEmployeeTable();

        scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBorder(new LineBorder(new Color(220, 220, 220), 1));
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void setupEmployeeTable() {
        // Define table model
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Employee ID", "Name", "Department", "Position", "Action"}
        ) {
            // Make cells non-editable except for the action column
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // Only action column is editable
            }
        };

        employeeTable.setModel(model);
        employeeTable.setRowHeight(45);
        employeeTable.setShowGrid(true);
        employeeTable.setGridColor(new Color(240, 240, 240));
        employeeTable.setBackground(Color.WHITE);
        employeeTable.setSelectionBackground(new Color(240, 240, 250));
        employeeTable.getTableHeader().setReorderingAllowed(false);
        employeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Set column widths
        employeeTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        employeeTable.getColumnModel().getColumn(1).setPreferredWidth(180);
        employeeTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        employeeTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        employeeTable.getColumnModel().getColumn(4).setPreferredWidth(100);

        // Style header
        JTableHeader header = employeeTable.getTableHeader();
        header.setBackground(new Color(4, 76, 172));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setPreferredSize(new Dimension(0, 35));

        // Set custom renderer for action column
        employeeTable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        employeeTable.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox()));

        // Add alternating row colors
        employeeTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Keep text color consistent
                label.setForeground(new Color(60, 60, 60));

                // Set background color
                if (isSelected) {
                    label.setBackground(new Color(240, 240, 250));
                } else {
                    label.setBackground(row % 2 == 0 ? Color.WHITE : new Color(248, 248, 248));
                }

                // Center align text
                label.setHorizontalAlignment(JLabel.CENTER);

                return label;
            }
        });

    }

    private JPanel createNoticePanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 10));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1),
                new EmptyBorder(15, 15, 15, 15)
        ));

        noticeTitle = new JLabel("Notice Board");
        noticeTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        noticeTitle.setForeground(new Color(60, 60, 60));
        panel.add(noticeTitle, BorderLayout.NORTH);

        noticeContent = new JTextArea();
        noticeContent.setEditable(false);
        noticeContent.setLineWrap(true);
        noticeContent.setWrapStyleWord(true);
        noticeContent.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        noticeContent.setText("• Welcome to the Employee Management Dashboard!\n\n"
                + "• Use the 'Details' button to view courses assigned to each employee.\n\n"
                + "• New teaching assignments will be posted by the end of this week.\n\n"
                + "• For any assistance, please contact the admin team.");

        noticeScrollPane = new JScrollPane(noticeContent);
        noticeScrollPane.setBorder(new LineBorder(new Color(220, 220, 220), 1));
        panel.add(noticeScrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void populateTableWithEmployees() {
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
        model.setRowCount(0); // Clear existing data

        try (Connection connection = getConnection()) {
            String query = "SELECT uid, user_name, full_name, rank FROM accounts";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String UID = resultSet.getString("uid");
                String user_name = resultSet.getString("user_name");
                String full_name = resultSet.getString("full_name");
                String rank = resultSet.getString("rank");

                model.addRow(new Object[]{UID, user_name, full_name, rank, "Details"});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading employees: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_manager_db", "root", "");
    }

    // Custom renderer for the button column
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
            setFocusPainted(false);
            setBorderPainted(false);
            setBackground(new Color(52, 152, 219));
            setForeground(Color.WHITE);
            setFont(new Font("Segoe UI", Font.BOLD, 12));
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("Details");
            return this;
        }
    }

    // Custom editor for the button column
    class ButtonEditor extends DefaultCellEditor {

        private JButton button;
        private String employeeId;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);

            button = new JButton();
            button.setOpaque(true);
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.setBackground(new Color(52, 152, 219));
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Segoe UI", Font.BOLD, 12));

            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            isPushed = true;
            employeeId = (String) table.getValueAt(row, 0);
            button.setText("Details");
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                // Show courses assigned to this employee
                showAssignedCourses(employeeId);
            }
            isPushed = false;
            return "Details";
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }

    private void showAssignedCourses(String uid) {
        // Get employee name for dialog title
        String employeeName = "";
        for (int i = 0; i < employeeTable.getRowCount(); i++) {
            if (employeeTable.getValueAt(i, 0).equals(uid)) {
                employeeName = (String) employeeTable.getValueAt(i, 1);
                break;
            }
        }

        // Create a dialog to show assigned courses
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Courses Assigned to " + employeeName, true);
        dialog.setSize(600, 400);
        dialog.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(4, 76, 172));
        headerPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel("Courses Assigned to: " + employeeName + " (" + uid + ")");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        // Create table for courses
        String[] columnNames = {"Course Code", "Course Title", "Course Type", "Units"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable courseTable = new JTable(model);

        courseTable.setRowHeight(35);
        courseTable.setShowGrid(true);
        courseTable.setGridColor(new Color(240, 240, 240));
        courseTable.setBackground(Color.WHITE);
        courseTable.setSelectionBackground(new Color(240, 240, 250));

        // Style header
        JTableHeader header = courseTable.getTableHeader();
        header.setBackground(new Color(52, 152, 219));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setPreferredSize(new Dimension(0, 35));

        JScrollPane scrollPane = new JScrollPane(courseTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // Fetch assigned courses from database
        fetchAssignedCourses(uid, model);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton closeButton = new JButton("Close");
        closeButton.setBackground(new Color(52, 152, 219));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(e -> dialog.dispose());
        buttonPanel.add(closeButton);

        dialog.add(headerPanel, BorderLayout.NORTH);
        dialog.add(contentPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

    }

    private void fetchAssignedCourses(String uid, DefaultTableModel model) {
        // Clear existing data
        model.setRowCount(0);

        try (Connection connection = getConnection()) {
            // Query to fetch courses assigned to the employee
            String query = "SELECT c.course_code, c.course_title, c.course_type, c.units "
                    + "FROM courses c "
                    + "JOIN employee_courses ec ON c.course_code = ec.course_code "
                    + "WHERE ec.employee_id = ?";

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, uid);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String courseCode = resultSet.getString("course_code");
                String courseTitle = resultSet.getString("course_title");
                String courseType = resultSet.getString("course_type");
                String units = resultSet.getString("units");

                model.addRow(new Object[]{courseCode, courseTitle, courseType, units});
            }

            // If no courses are assigned, add a message row
            if (model.getRowCount() == 0) {
                model.addRow(new Object[]{"", "No courses assigned to this employee", "", ""});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
