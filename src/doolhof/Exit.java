/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Marnix
 */
public class Exit extends SpelObject {

    private Image img;
    
    
   @Override
    public Image getImage() {
      this.img = new ImageIcon(Exit.class.getResource("\\Plaatjes\\finish.png")).getImage(); 
      return img;
      
    } 
   
    
    @Override
    public boolean isPassable() {
      return true;
    }

    @Override
    public void pakOp(Pacman p) {
      
    }
}
