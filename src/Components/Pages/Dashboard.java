/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.Pages;

import Components.ButtonInteractions.ButtonsEditor;
import Components.ButtonInteractions.ButtonsRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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
        setupSearchBarKeyListener();
        setupUIEnhancements();
        populateTableWithCourses();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/schedule_manager_db", "root", "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        dashboardTitle = new javax.swing.JLabel();
        noticePanel = new javax.swing.JPanel();
        noticeTitle = new javax.swing.JLabel();
        noticeScrollPane = new javax.swing.JScrollPane();
        noticeContent = new javax.swing.JTextArea();
        MainPanel = new raven.crazypanel.CrazyPanel();
        ScrollPane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TabPanel = new raven.crazypanel.CrazyPanel();
        SearchBar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1265, 720));
        setLayout(null);

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));
        headerPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 20, 15, 20), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220))));
        headerPanel.setLayout(new java.awt.BorderLayout());

        dashboardTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        dashboardTitle.setForeground(new java.awt.Color(60, 60, 60));
        dashboardTitle.setText("THIS IS THE DASHBOARD SECTION");
        headerPanel.add(dashboardTitle, java.awt.BorderLayout.CENTER);

        add(headerPanel);
        headerPanel.setBounds(0, 0, 1050, 210);

        noticePanel.setBackground(new java.awt.Color(240, 240, 240));
        noticePanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220))));
        noticePanel.setToolTipText("");

        noticeTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        noticeTitle.setForeground(new java.awt.Color(60, 60, 60));
        noticeTitle.setText("Notice Board");
        noticeTitle.setAutoscrolls(true);
        noticeTitle.setFocusTraversalPolicyProvider(true);
        noticeTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        noticeContent.setColumns(20);
        noticeContent.setRows(5);
        noticeScrollPane.setViewportView(noticeContent);

        javax.swing.GroupLayout noticePanelLayout = new javax.swing.GroupLayout(noticePanel);
        noticePanel.setLayout(noticePanelLayout);
        noticePanelLayout.setHorizontalGroup(
            noticePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticePanelLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(noticeTitle)
                .addGap(89, 89, 89))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noticePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(noticeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        noticePanelLayout.setVerticalGroup(
            noticePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(noticeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noticeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(noticePanel);
        noticePanel.setBounds(790, 220, 260, 500);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setLayout(null);

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(4, 76, 172)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Code", "Course Title", "Course Type", "Units"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class

                , java.lang.Object.class

                , java.lang.Object.class

                , java.lang.Object.class

            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        ScrollPane.setViewportView(jTable1);

        MainPanel.add(ScrollPane);
        ScrollPane.setBounds(20, 70, 740, 450);

        TabPanel.setBackground(new java.awt.Color(255, 255, 255));
        TabPanel.setPreferredSize(new java.awt.Dimension(1019, 34));
        TabPanel.setLayout(null);
        MainPanel.add(TabPanel);
        TabPanel.setBounds(20, 90, 980, 40);

        SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBarActionPerformed(evt);
            }
        });
        MainPanel.add(SearchBar);
        SearchBar.setBounds(20, 40, 170, 28);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(60, 60, 60));
        jLabel1.setText("Course Data");
        MainPanel.add(jLabel1);
        jLabel1.setBounds(20, 10, 110, 16);

        add(MainPanel);
        MainPanel.setBounds(20, 200, 760, 520);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarActionPerformed
        // TODO add your handling code here:
        searchCourses();
    }//GEN-LAST:event_SearchBarActionPerformed

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

                model.addRow(new Object[]{courseCode, courseTitle, courseType, courseUnits});
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No courses found matching your search.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error searching courses: " + e.getMessage());
        }
    }

    private void setupSearchBarKeyListener() {
        SearchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchCourses();
            }
        });
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

                
                model.addRow(new Object[]{courseCode, courseTitle, courseType, courseUnits});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching courses: " + e.getMessage());
        }
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
        model.setColumnIdentifiers(new Object[]{"Course Code", "Course Title", "Course Type", "Units"});

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);  // Course Code
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);  // Course Title
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);   // Course Type
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(15);   // Units

        // Add alternating row colors
        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 250));
                } else {
                    c.setBackground(new Color(200, 200, 255));
                }

                return c;
            }
        });
        jTable1.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        // Style search bar
        SearchBar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(204, 204, 204)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        SearchBar.setFont(new Font("SansSerif", Font.PLAIN, 14));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.crazypanel.CrazyPanel MainPanel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTextField SearchBar;
    private raven.crazypanel.CrazyPanel TabPanel;
    private javax.swing.JLabel dashboardTitle;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea noticeContent;
    private javax.swing.JPanel noticePanel;
    private javax.swing.JScrollPane noticeScrollPane;
    private javax.swing.JLabel noticeTitle;
    // End of variables declaration//GEN-END:variables
}
