/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Marnix
 */
public class Vak extends JComponent {

    private Image leegVakje = new ImageIcon(Vak.class.getResource("\\Plaatjes\\grass.png")).getImage();
    private int size = 32;              //Afmeting van een vakje 
    private int n = Level.getN();
    private Level level = new Level();
    private int[][] lev = level.getLevel1();
       
    
    SpelObject p = new Pacman();
    SpelObject m = new Muur();
    SpelObject e = new Exit();
    SpelObject b = new Bazooka();
    SpelObject h = new Helper();
    SpelObject v = new Vijand();
   
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                m.setPositie(i, j);
                e.setPositie(i, j);
                p.setPositie(i, j);

                g.drawImage(leegVakje, j * size, i * size, size, size, null);

                if (lev[i][j] == 1) {
                    g.drawImage(m.getImage(), j * size, i * size, size, size, null);
                    //System.out.println("muur: "+ m.getX() +"," + m.getY()); 
                }

                if (lev[i][j] == 2) {

                    g.drawImage(e.getImage(), j * size, i * size, size, size, null);
                }

                if (lev[i][j] == 3) {

                    g.drawImage(p.getImage(), j * size, i * size, size, size, null);
                    System.out.println("Pacman: " + p.getX() + "," + p.getY());
                                     
                                                            
                }
            }
        }
    }  
   
}

