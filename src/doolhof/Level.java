/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Marnix/Alois
 */
//0 of > 5 = leeg vakje
//1 = muur
//2 = exit
//3 = vijand
//4 = helper
//5 = Bazooka
public class Level extends JPanel {

    private int n = 25;    //aantal * n vakjes  
    private Vak vk = new Vak();
    private Image leegVakje = new ImageIcon(Vak.class.getResource("\\Plaatjes\\grass.png")).getImage();
    private int size = vk.vakSize();
    
    SpelObject p = new Pacman();
    SpelObject m = new Muur();
    SpelObject e = new Exit();
    SpelObject b = new Bazooka();
    SpelObject h = new Helper();
    SpelObject v = new Vijand();

    public Level() {

        this.addKeyListener(new Toets());
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {


                g.drawImage(leegVakje, j * size, i * size, size, size, null);

                if (vk.getLevel()[i][j] == 1) {
                    g.drawImage(m.getImage(), j * size, i * size, size, size, null);
                }

                if (vk.getLevel()[i][j] == 2) {

                    if (p.getX() == j && p.getY() == i) {

                        System.out.println("Exit op: " + j + "," + i);
                    }
                    g.drawImage(e.getImage(), j * size, i * size, size, size, null);

                }

                if (vk.getLevel()[i][j] == 3) {

                    if (p.getX() == j && p.getY() == i) {

                        System.out.println("Vijand op: " + j + "," + i);
                    }
                    g.drawImage(v.getImage(), j * size, i * size, size, size, null);
                }
            }
        }
        g.drawImage(p.getImage(), p.getX() * size, p.getY() * size, size, size, null);
    }
    
    
    public class Toets extends KeyAdapter implements KeyBoard {

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if (keycode == KeyEvent.VK_UP) {
                p.move(0, -1);
                System.out.println("positie: " + p.getX() + "," + p.getY());

            }
            if (keycode == KeyEvent.VK_DOWN) {

                p.move(0, 1);
                System.out.println("positie: " + p.getX() + "," + p.getY());

            }
            if (keycode == KeyEvent.VK_LEFT) {
                p.move(-1, 0);
                System.out.println("positie: " + p.getX() + "," + p.getY());
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                p.move(1, 0);
                System.out.println("positie: " + p.getX() + "," + p.getY());

            }
        }
    }
}
