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


public class Muur extends SpelObject {
  
private Image img;    
private boolean vernietigbaar;    
     

public Muur(boolean vernietigbaar){
    
    this.vernietigbaar = vernietigbaar;
    
}

    @Override
    public Image getImage() {
       this.img = new ImageIcon(Muur.class.getResource("\\Plaatjes\\crate.png")).getImage(); 
       return img;
    }
      

    
    @Override
    public void pakOp(Pacman p) {
        
    }
}

