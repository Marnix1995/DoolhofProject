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

    private SpelObject spelobject;
    private Image grass = new ImageIcon(Vak.class.getResource("\\Plaatjes\\grass.png")).getImage();
    private int size = 32;                //Afmeting van een vakje     
    private boolean isItem = true;
    private int n = Level.getN(); 

    
    @Override
    public void paintComponent(Graphics g) {


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                g.drawRect(j * size, i * size, size, size);

            }
        }
    }
}
