package Components.OptionPane;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import mdlaf.utils.MaterialImageFactory;

/** @author https://github.com/vincenzopalazzo */
public class MaterialOptionPaneUI extends BasicOptionPaneUI {

  @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
  public static ComponentUI createUI(JComponent c) {
    return new MaterialOptionPaneUI();
  }

  @Override
  protected Icon getIconForType(int messageType) {
    if (!UIManager.getBoolean("OptionPane.enableIcon")) {
      // Insert icon white because without icon icon the JOptionPane is paint wrong
      return MaterialImageFactory.getInstance().getImage(MaterialImageFactory.BLANK);
    }
    return super.getIconForType(messageType);
  }
}
