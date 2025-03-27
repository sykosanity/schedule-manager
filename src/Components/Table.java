package Components;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import Database.Database;
import com.formdev.flatlaf.FlatClientProperties;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Table extends javax.swing.JFrame {

    private void dashboardDisplay() {
        DefaultTableModel model = (DefaultTableModel) DashboardTable.getModel();
        model.setRowCount(0); // Clear existing data

        // Fetch latest data from database
        Database.initDatabase();
        List<HashMap<String, String>> accounts = Database.getDatabase();

        for (HashMap<String, String> userData : accounts) {
            Object[] row = {
                userData.get("uid"),
                userData.get("user_name"),
                userData.get("user_password"),
                userData.get("full_name"),
                userData.get("rank"),
                userData.get("permissions")
            };
            model.addRow(row);
        }
    }

    public Table() {
        initComponents();
        dashboardDisplay();
        DashboardTable.setDefaultRenderer(Object.class, new GradientCell());
        DashboardTable.setDefaultRenderer(Object.class, new GradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        DashboardTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background");
        jScrollPane2.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,0,3,0,$Table.background,10,10");
        jScrollPane2.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverTrackColor:null");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DashboardTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DashboardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "uid", "user_name", "user_password", "full_name", "rank", "permissions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(DashboardTable);
        if (DashboardTable.getColumnModel().getColumnCount() > 0) {
            DashboardTable.getColumnModel().getColumn(0).setPreferredWidth(1);
            DashboardTable.getColumnModel().getColumn(1).setPreferredWidth(10);
            DashboardTable.getColumnModel().getColumn(2).setPreferredWidth(10);
            DashboardTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            DashboardTable.getColumnModel().getColumn(4).setPreferredWidth(20);
            DashboardTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 

    public static void main(String args[]) {
        FlatLaf.registerCustomDefaultsSource("Components");
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Table().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DashboardTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
