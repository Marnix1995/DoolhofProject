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
    private int munitie = 5;
    private int som;
            
        
    public void munitieVullen() { 
      
      som = vak.level.timer.getMunitie() + munitie;                
      vak.level.timer.setMunitie(som);   
    }
      
    
    @Override
    public Image getImage() {
        this.img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\rocket_launcher.png")).getImage();
        return img;
    }   

    @Override
    public void pakOp(Pacman p) {
        munitieVullen();
    }
}
