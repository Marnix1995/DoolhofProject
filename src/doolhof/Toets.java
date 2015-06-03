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

    int key;
    Pacman p = new Pacman();

    @Override
    public void keyPressed(KeyEvent e) {

        int waardeKey = e.getKeyCode();

        if (waardeKey == KeyEvent.VK_UP) {

            p.setKey(waardeKey);

        }
        if (waardeKey == KeyEvent.VK_DOWN) {

            p.setKey(waardeKey);
        }
        if (waardeKey == KeyEvent.VK_LEFT) {

            p.setKey(waardeKey);
        }
        if (waardeKey == KeyEvent.VK_RIGHT) {

            p.setKey(waardeKey);
        }
    }
}
