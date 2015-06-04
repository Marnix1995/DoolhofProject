/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Marnix
 */

public abstract class SpelObject {
       
    Doolhof game;    // Dit private
     
    private int value;
    Vak vak;    
    private int x, y;        
         
    public abstract void pakOp(Pacman p); 
    
    public abstract void move(int x, int y);
    
      
    public void setVak(Vak v){
        
        vak = v;
    }
    
    public abstract boolean isPassable();
         
    
    public int getValue(){
        
        return value;        
    }
    
    public abstract Image getImage();    
    
}
