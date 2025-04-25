package Components.Button;

import javax.swing.JButton;

public class MenuButton extends JButton{

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the subMenuAble
     */
    public boolean isSubMenuAble() {
        return subMenuAble;
    }

    /**
     * @param subMenuAble the subMenuAble to set
     */
    public void setSubMenuAble(boolean subMenuAble) {
        this.subMenuAble = subMenuAble;
    }

    /**
     * @return the subMenuIndex
     */
    public int getSubMenuIndex() {
        return subMenuIndex;
    }

    /**
     * @param subMenuIndex the subMenuIndex to set
     */
    public void setSubMenuIndex(int subMenuIndex) {
        this.subMenuIndex = subMenuIndex;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }
    
    private int index;
    private boolean subMenuAble;
    private int subMenuIndex;
    private int length; 
    
    public MenuButton(String name, int index, boolean subMenuAble){
        super(name);
        this.index=index;
        this.subMenuAble=subMenuAble;
    }
    
    private void initSubMenu(int subMenuIndex, int length){
        this.subMenuIndex = subMenuIndex;
        this.length = length;
    }
    
    
}