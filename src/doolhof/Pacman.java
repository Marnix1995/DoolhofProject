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

public class Pacman extends SpelObject {
              
    
    private Image img;    
    private Image imgRed;   
    private int ammunitie;         
        
   
        
    
    @Override
    public Image getImage() {

        this.img = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\player.png")).getImage();
        return img;        
    }
  
  
    public Image getRedImage() {

        this.imgRed = new ImageIcon(Vak.class.getResource("\\Plaatjes\\playerRood.png")).getImage();
        return imgRed;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

   
    public void move(int dir) {
      
        Vak target = vak.getBuur(dir);
        SpelObject item = target.getObject();
        
        if(item == null && !(item instanceof Muur)){            
            vak.verplaats(target);
            item.pakOp(this);
                   
        }        
    }


    @Override
    public void pakOp(Pacman p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void move(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
