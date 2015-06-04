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

public class Toets extends KeyAdapter implements KeyBoard {

    
             
    @Override
    public void keyPressed(KeyEvent e) {
        
        int waardeKey = e.getKeyCode();
        if (waardeKey == KeyEvent.VK_UP) {
                      
                
        }
        if (waardeKey == KeyEvent.VK_DOWN) {

           
        }
        if (waardeKey == KeyEvent.VK_LEFT) {

           
        }
        if (waardeKey == KeyEvent.VK_RIGHT) {

           
        }
    }
}
