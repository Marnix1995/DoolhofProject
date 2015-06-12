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
public class Bazooka extends SpelObject {
     
    private Image img;
    public int munitie = 58;
            
        
    public void munitieVullen() {
           
      vak.level.timer.setMunitie(munitie);  //munitieLabel teller.        
    }
      
    
    @Override
    public Image getImage() {
        this.img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\rocket_launcher.png")).getImage();
        return img;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void pakOp(Pacman p) {

        munitieVullen();
    }
}
