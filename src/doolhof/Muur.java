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
private Image imgSteel;
private boolean vernietigbaar;    
     

public Muur(boolean vernietigbaar){       
   
    this.vernietigbaar = vernietigbaar;
        
    }


public boolean destroyable(){
    
    return vernietigbaar;
    
}

    @Override
    public Image getImage() {
        
       if (vernietigbaar == false){       
           this.imgSteel = new ImageIcon(Muur.class.getResource("\\Plaatjes\\steel_wall.png")).getImage();  
           return imgSteel;
       }
        
       this.img = new ImageIcon(Muur.class.getResource("\\Plaatjes\\crate.png")).getImage();  
       return img;
    }
          
    @Override
    public void pakOp(Pacman p) {
        
    }
}

