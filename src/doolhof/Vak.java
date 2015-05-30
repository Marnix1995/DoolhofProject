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

    private Image speler = new ImageIcon(Vak.class.getResource("\\Plaatjes\\player.png")).getImage();
    private Image exit = new ImageIcon(Vak.class.getResource("\\Plaatjes\\finish.png")).getImage();
    private Image muur = new ImageIcon(Vak.class.getResource("\\Plaatjes\\crate.png")).getImage();
    private Image grass = new ImageIcon(Vak.class.getResource("\\Plaatjes\\grass.png")).getImage();
    
    private int size = 32;                //Afmeting van een vakje     
    private boolean isItem = true;
    private int n = Level.getN();
    private Level level = new Level();
    private int[][] lev = level.getLevel1();

    @Override
    public void paintComponent(Graphics g) {


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
              
                 g.drawImage(grass, j * size, i * size, size, size, this);
               

                if (lev[i][j] == 1) {
                    g.drawImage(muur, j * size, i * size, size, size, this);
                }

                if (lev[i][j] == 2) {
                    g.drawImage(speler, j * size, i * size, size, size, this);

                }
                if (lev[i][j] == 3) {
                    g.drawImage(exit, j * size, i * size, size, size, this);

                }               

            } 
           
            
        }

    }
}
