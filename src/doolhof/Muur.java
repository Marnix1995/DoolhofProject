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


public class Muur extends SpelObject {
  
private Image img;    
private boolean vernietigbaar;    


       

    @Override
    public Image getImage() {
       this.img = new ImageIcon(Muur.class.getResource("\\Plaatjes\\crate.png")).getImage(); 
       return img;
    }
  

    @Override
    public void move(int x, int y) {
       
    }

    

    @Override
    public boolean isPassable() {
       return false;
    }

    @Override
    public void pakOp(Pacman p) {
        
    }
}

