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
public class Bazooka extends SpelObject {

    private Image img;
    private int x;
    private int y;
    
    
     public int getY(){
        
       return y;         
    }
    
    public int getX(){ 
        
        return x;        
    }   
    
                  
    @Override
    public void move(int x, int y) {
        
      this.x = x;
      this.y = y;
    }
   
}
