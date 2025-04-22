package Components.ButtonInteractions;

import javax.swing.table.TableCellRenderer;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Image;

/**
 *
 * @author Admin
 */
// Custom renderer for the buttons column
public class ButtonsRenderer extends JPanel implements TableCellRenderer {

    private JCheckBox checkBox;
    private JButton editButton;
    private JButton deleteButton;

    public ButtonsRenderer() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        setBackground(null); // Transparent background

        editButton = new JButton();
        deleteButton = new JButton();
        checkBox = new JCheckBox();

        // Style buttons
        ImageIcon editIcon = resizeIcon(new ImageIcon(getClass().getResource("/Assets/Icons/edit16.png")), 100, 100);
        ImageIcon deleteIcon = resizeIcon(new ImageIcon(getClass().getResource("/Assets/Icons/delete16x16.png")), 16, 16);

        editButton.setIcon(editIcon);
        editButton.setPreferredSize(new Dimension(24, 24));
        editButton.setContentAreaFilled(false);
        editButton.setBorderPainted(false);

        deleteButton.setIcon(deleteIcon);
        deleteButton.setPreferredSize(new Dimension(24, 24));
        deleteButton.setContentAreaFilled(false);
        deleteButton.setBorderPainted(false);

        checkBox.setBackground(null);

        add(editButton);
        add(deleteButton);
        add(checkBox);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setBackground(new Color(173, 216, 230));
        } else {
            setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 250));
        }

        checkBox.setSelected(value != null && (Boolean) value);
        return this;
    }

    // Static method to resize icons
    public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
