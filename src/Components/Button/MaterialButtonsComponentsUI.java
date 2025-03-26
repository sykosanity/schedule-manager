/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components.Button;

import javax.swing.*;

public class MaterialButtonsComponentsUI extends MaterialButtonUI {

  @Override
  public void installUI(JComponent c) {
    mouseHoverEnabled = false;
    super.installUI(c);
    borderEnabled = false;
    buttonBorderToAll = false;
  }
}
