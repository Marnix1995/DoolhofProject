/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;

/**
 *
 * @author Marnix
 */

public abstract class SpelObject {
        
    public Vak vak;
    private int munitie;   
         
    public abstract void pakOp(Pacman p); 
         
    
    public void setVak(Vak v){        
     vak = v;       
    }
    
    public int getMunitie(){
     
        
        
    return munitie;      
    }
    
    
    public abstract boolean isPassable();
                 
    
    public abstract Image getImage();    
    
}
