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
    
           
    public SpelObject(){          
        
    }    
    
    public abstract int getX();   
    public abstract int getY();
   
    public abstract void draw(Graphics g);
    public abstract void drawNieuw(Graphics g, int x, int y);
    
    public abstract void setPositie(int x, int y);
    
    public abstract Image getImage();
    
    
}
