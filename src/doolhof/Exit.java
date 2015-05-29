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
public class Exit extends SpelObject {

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
    public Image getImage(){
        
    new ImageIcon(Exit.class.getResource("\\Plaatjes\\finish.png")).getImage(); 
    return img;
    }
    
    @Override
    public void setObject(int x, int y) {
       
    }

    @Override
    public char getChar() {
       return 'e';
    }
}
