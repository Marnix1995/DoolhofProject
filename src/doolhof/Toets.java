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

    private Pacman p = new Pacman();
    
    
    public Toets(){
        
        
    }
             
           @Override
            public void keyPressed(KeyEvent e) {
 
                int keycode = e.getKeyCode();
                if (keycode == KeyEvent.VK_UP) {
                    {
                      p.move(0, -1);
                      System.out.println("Omhoog " + p.getY()); 
                    }
                }
                
                if (keycode == KeyEvent.VK_DOWN) {
                    {
                        p.move(0, 1);
                        System.out.println("beneden ");
                    }
                }
                if (keycode == KeyEvent.VK_RIGHT) {
                    {
                        p.move(-1, 0);
                        System.out.println("Rechts");
                    }
                }
                if (keycode == KeyEvent.VK_LEFT) {
                    {
                        p.move(1, 0);
                        System.out.println("Links");
                        
                    }
                }
            } 
           
}
           
           
          
    
