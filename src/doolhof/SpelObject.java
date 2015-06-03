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
    private Vak vak;
    private int vakSize = 32;
    private int x, y;        
         
      
    public abstract void move(int x, int y);
    
    public abstract void drawItem(Graphics g, int x, int y);
    
    
    public abstract boolean isPassable();
    
    public int getVakSize(){
    
      return vakSize; 
    }
    
   
    
    public int getValue(){
        
        return value;        
    }
    
    public abstract Image getImage();    
    
}
