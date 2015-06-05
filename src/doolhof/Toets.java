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

    private int dir;
    private Pacman p;

    public Toets(Pacman p) {

        this.p = p;
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
    }
}