/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Marnix
 */
public class Helper extends SpelObject {

    private int x;
    private int y;
    private Image img;
    
    public int getY() {

        return y;
    }

    public int getX() {

        return x;
    }

    
    @Override
    public void setObject(int x, int y) {

        this.x = x;
        this.y = y;

    }    
   
    @Override
    public Image getImage(){
      
     this.img = new ImageIcon(Helper.class.getResource("\\Plaatjes\\friend.png")).getImage();    
      return img;  
    }

    @Override
    public char getChar() {
        return 'h';
    }
}
