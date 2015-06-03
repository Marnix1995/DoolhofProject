/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Marnix
 */
public class Toets extends KeyAdapter {

    private Pacman p;    
        
    public Toets(Pacman p) {
              
       this.p = p;
    }
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_UP) {
                 
           
        }        
        if (keycode == KeyEvent.VK_DOWN) {
                            

        }
        if (keycode == KeyEvent.VK_LEFT) {
          
                       
        }
        if (keycode == KeyEvent.VK_RIGHT) {
          
            
        }
    }
}


