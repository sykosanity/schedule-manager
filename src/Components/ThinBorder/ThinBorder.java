
package Components.ThinBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ThinBorder implements Border {
    private final Color color;

    public ThinBorder(Color color) {
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(0.1f));
        g2.drawRect(x, y, width - 1, height - 1);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(1, 1, 1, 1);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
