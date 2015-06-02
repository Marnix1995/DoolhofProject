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
               
    public abstract void setPositie(int x, int y);
    public abstract int getX();   
    public abstract int getY();
      
    public abstract void move(int x, int y);
    
    
    public abstract Image getImage();
    
    
}
