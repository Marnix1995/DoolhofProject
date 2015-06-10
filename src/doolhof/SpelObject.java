/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Marnix
 */

public abstract class SpelObject {
        
    public Vak vak;  
    public ArrayList<Vak> kortstePad;
      
          
   
    public abstract void pakOp(Pacman p); 
         
    
    public void setVak(Vak v){        
     vak = v;       
    }     
          
            
    public abstract boolean isPassable();
                 
    
    public abstract Image getImage();    
    
}
