/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Marnix
 */
public class Vak extends JComponent {

    private Image speler = new ImageIcon(Vak.class.getResource("\\Plaatjes\\player.png")).getImage();
    private Image exit = new ImageIcon(Vak.class.getResource("\\Plaatjes\\finish.png")).getImage();
    private Image muur = new ImageIcon(Vak.class.getResource("\\Plaatjes\\crate.png")).getImage();
    private Image gras = new ImageIcon(Vak.class.getResource("\\Plaatjes\\grass.png")).getImage();
    private Timer timer;
    private int size = 32;              //Afmeting van een vakje 
    private int n = Level.getN();
    private Level level = new Level();
    private int[][] lev = level.getLevel1();
    private Pacman p = new Pacman();

    
    
    
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {


                if (lev[i][j] == 0) {
                    g.drawImage(gras, j * size, i * size, size, size, null);
                }

                if (lev[i][j] == 1) {
                    g.drawImage(muur, j * size, i * size, size, size, null);
                }

                if (lev[i][j] == 2) {

                    g.drawImage(exit, j * size, i * size, size, size, null);
                }
            }
        } 
        p.move(0,1);
        g.drawImage(speler, p.getX() * size, p.getY() * size, size, size, null);
        System.out.println("positie y: " + p.getY());
       
    }
}
