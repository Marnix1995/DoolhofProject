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

public class Exit extends SpelObject {

    private Image img;
      
    
   @Override
    public Image getImage() {
      this.img = new ImageIcon(Exit.class.getResource("\\Plaatjes\\finish.png")).getImage(); 
      return img;
      
    }    
    
    public void exitChecker(){
              
     int levelNummer = Doolhof.checkHuidigLevel();  
     levelNummer++; 
            
     vak.level.doolhof.levelPanel(levelNummer);           
     vak.level.updateLevel();     
    }    
    
    
    @Override
    public void pakOp(Pacman p) {
                       
        exitChecker();        
              
    }
}
