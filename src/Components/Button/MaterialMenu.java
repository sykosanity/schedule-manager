package Components.Button;

import javax.swing.JComponent;
import net.miginfocom.swing.MigLayout;

public class MaterialMenu extends JComponent {

    private MigLayout layout;
    private String[][] menuItems = new String[][]{
        {"Dashboard", "Table"},
        {"Email", "1", "2", "3"}
    };

    public MaterialMenu() {
        init();
    }

    private void init() {
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
        setLayout(layout);

        for (int i = 0; i < menuItems.length; i++) {
            addMenu(menuItems[i][0], i);
        }
    }

    private void addMenu(String menuName, int index) {
        int length = menuItems[index].length;
        MenuButton item = new MenuButton(menuName, index, length > 1);      
        add(item);
        revalidate();
        repaint();
    }

}
