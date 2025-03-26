package Components.TextField;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialTextFieldUI extends MaterialComponentField {

  protected static final String ProprietyPrefix = "TextField";

  public MaterialTextFieldUI() {
    this(true);
  }

  public MaterialTextFieldUI(boolean drawLine) {
    super();
    this.drawLine = drawLine;
  }

  @Override
  protected String getPropertyPrefix() {
    return ProprietyPrefix;
  }

  public static ComponentUI createUI(JComponent c) {
    return new MaterialTextFieldUI();
  }

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);
    installMyDefaults(c);
  }

  @Override
  protected void installDefaults() {
    super.installDefaults();
  }

  @Override
  public void uninstallUI(JComponent c) {
    super.uninstallUI(c);
    c.setCursor(Cursor.getDefaultCursor());
  }

  @Override
  protected void uninstallDefaults() {
    super.uninstallDefaults();
    getComponent().setBorder(null);
  }

  @Override
  protected void installListeners() {
    super.installListeners();
    getComponent().addFocusListener(focusListenerColorLine);
    getComponent().addPropertyChangeListener(propertyChangeListener);
    propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
  }

  @Override
  protected void uninstallListeners() {
    getComponent().removeFocusListener(focusListenerColorLine);
    getComponent().removePropertyChangeListener(propertyChangeListener);
    propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    super.uninstallListeners();
  }

  @Override
  public void paintSafely(Graphics g) {
    super.paintSafely(g);
    paintLine(g);
    changeColorOnFocus(g);
  }
}
