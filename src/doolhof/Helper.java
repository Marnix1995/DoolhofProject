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

   private Image img;     
    
   
    public void zoekPad(){
           
       SpelObject object = vak.getObject();                
       if(object instanceof Muur){
                
           
    }
       //vak.contains(null); 
                      
    }
      
    @Override
    public Image getImage() {
       this.img = new ImageIcon(Helper.class.getResource("\\Plaatjes\\friend.png")).getImage();

        return img;
    }  
       

    @Override
    public boolean isPassable() {
       return true;
        
    }

    @Override
    public void pakOp(Pacman p) {
      
     zoekPad();
        
    }
}
