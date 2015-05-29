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
    
           
    public SpelObject(){          
        
    }    
        
    public abstract void setObject(int x, int y);
    public abstract Image getImage();
    public abstract char getChar();
    
}
