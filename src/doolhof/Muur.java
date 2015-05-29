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
private boolean vernietigbaar;    
private int x;
private int y;
    

 public int getY(){
        
       return y;         
    }   
 
    public int getX(){  
        
       return x;        
    }   
    
    
    @Override
    public Image getImage(){
        
      this.img = new ImageIcon(Muur.class.getResource("\\Plaatjes\\crate.png")).getImage();   
      return img;         
    }    
    
    @Override
    public void setObject(int x, int y) {
      
        this.x = x;
        this.y = y;
        
    }

    @Override
    public char getChar() {
        return 'm';
    }
}

