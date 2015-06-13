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

    public Pacman p;
    private Level l;
    
    public Toets(Pacman p, Level l) {
      
        this.p = p;
        this.l = l;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int waardeKey = e.getKeyCode();
        if (waardeKey == KeyEvent.VK_UP) {

            p.move(1);
          
        }
        if (waardeKey == KeyEvent.VK_DOWN) {
           
            p.move(2);

        }
        if (waardeKey == KeyEvent.VK_LEFT) {
 
            p.move(3);

        }
        if (waardeKey == KeyEvent.VK_RIGHT) {

            p.move(4);
        }
         if (waardeKey == KeyEvent.VK_SPACE) {
            
            p.schiet(0);             
        }    
        
        if (waardeKey == KeyEvent.VK_ESCAPE) {

            l.toets(1);
        }
        if (waardeKey == KeyEvent.VK_P) {

            l.toets(2);
        }
        if (waardeKey == KeyEvent.VK_R) {

            l.toets(3);
        }
       
    }
}
