/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components.Cell;


import Components.ThinBorder.ThinBorder;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;

public class Cell extends JButton {

    public Cell() {
//        setContentAreafilled(false);

//        setBorder(null);
        setBorder(new ThinBorder(Color.BLACK));
    }

}
