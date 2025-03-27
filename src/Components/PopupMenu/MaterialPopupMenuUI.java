
package Components.PopupMenu;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPopupMenuUI;

public class MaterialPopupMenuUI extends BasicPopupMenuUI {

  public static ComponentUI createUI(JComponent c) {
    return new MaterialPopupMenuUI();
  }

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);
  }

  @Override
  public void uninstallUI(JComponent c) {
    super.uninstallUI(c);
  }

  @Override
  public void paint(Graphics g, JComponent c) {
    super.paint(g, c);
  }
}
