/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Marnix/Alois
 */

public final class Vijand extends SpelObject {

    private Image img;
    private int strafTijd = 25;
     

    @Override
    public Image getImage() {
        this.img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\Enemy.png")).getImage();
        return img;
    }
    
  
    public void beweeg(int dir) {
              
        
        Vak target = vak.getBuur(dir);
        SpelObject object = target.getObject();
      
       if (!(object instanceof Muur)) {
         
            vak.verplaats(target);
            vak = target;
        }
    }    

    
    @Override
    public void pakOp(Pacman p) {
               
        vak.level.timer.getExtraTijdAfhalen(strafTijd);

    }
}
