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

    int x;
    int y;
    private Pacman p = new Pacman();
      
       
    @Override
    public void keyPressed(KeyEvent event) {

        switch (event.getKeyCode()) {

            case KeyEvent.VK_LEFT:
               
                p.move(0, -1);               
                                          
                break;

            case KeyEvent.VK_RIGHT:

                p.move(0, 1);
                 
                break;

            case KeyEvent.VK_UP:
                
                p.move(-1, 0);

                break;

            case KeyEvent.VK_DOWN:

                p.move(1, 0);

                break;
        }        
    }
}
