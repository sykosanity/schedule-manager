package Components.ButtonInteractions;

import Components.Pages.Courses;
import javax.swing.table.TableCellEditor;
import javax.swing.AbstractCellEditor;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.util.EventObject;

/**
 *
 * @author Admin
 */
// Custom editor for the buttons column
public class ButtonsEditor extends AbstractCellEditor implements TableCellEditor {

    private JPanel panel;
    private JCheckBox checkBox;
    private JButton editButton;
    private JButton deleteButton;
    private JTable table;
    private boolean isEditing;
    private Courses courses; // Reference to Courses instance

    public ButtonsEditor(JTable table, Courses courses) {
        this.table = table;
        this.courses = courses; // Assign the Courses instance
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 0));

        editButton = new JButton();
        deleteButton = new JButton();
        checkBox = new JCheckBox();

        // Style buttons
        ImageIcon editIcon = ButtonsRenderer.resizeIcon(new ImageIcon(getClass().getResource("/Assets/Icons/edit16.png")), 100, 100);
        ImageIcon deleteIcon = ButtonsRenderer.resizeIcon(new ImageIcon(getClass().getResource("/Assets/Icons/delete16x16.png")), 16, 16);

        editButton.setIcon(editIcon);
        editButton.setPreferredSize(new Dimension(24, 24));
        editButton.setContentAreaFilled(false);
        editButton.setBorderPainted(false);

        deleteButton.setIcon(deleteIcon);
        deleteButton.setPreferredSize(new Dimension(24, 24));
        deleteButton.setContentAreaFilled(false);
        deleteButton.setBorderPainted(false);

        // Edit button action
        editButton.addActionListener(e -> {
            int row = table.convertRowIndexToModel(table.getEditingRow());
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            String courseCode = (String) model.getValueAt(row, 1);
            String courseTitle = (String) model.getValueAt(row, 2);
            String courseType = (String) model.getValueAt(row, 3);
            String units = (String) model.getValueAt(row, 4);

            // Call the update method on the Courses instance
            courses.updateCourseDialog(courseCode, courseTitle, courseType, units);
            fireEditingStopped();
        });

        // Delete button action
        deleteButton.addActionListener(e -> {
            int row = table.convertRowIndexToModel(table.getEditingRow());
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            String courseCode = (String) model.getValueAt(row, 1);
            String courseTitle = (String) model.getValueAt(row, 2); // Define courseTitle here

            // Confirm deletion dialog
            int response = JOptionPane.showConfirmDialog(
                    table,
                    "Are you sure you want to delete the course: " + courseTitle + "?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {
                // Call the remove method on the Courses instance
                courses.removeCourseFromDatabase(courseCode);
            }

            fireEditingStopped();
        });

        // Checkbox action
        checkBox.addActionListener(e -> fireEditingStopped());

        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(checkBox);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        checkBox.setSelected(value != null && (Boolean) value);
        panel.setBackground(new Color(173, 216, 230)); // Selection color
        isEditing = true;
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return checkBox.isSelected();
    }

    @Override
    public boolean stopCellEditing() {
        isEditing = false;
        return super.stopCellEditing();
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        return true;
    }
}