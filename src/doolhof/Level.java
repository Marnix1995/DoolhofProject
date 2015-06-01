/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Marnix/Alois
 */
//0 of > 6 = leeg vakje
//1 = muur
//2 = exit
//3 = pacman
//4 = vijand
//5 = helper
//6 = Bazooka

public class Level extends JPanel {

    private int n = 25;    //aantal * n vakjes  
    private Vak vk = new Vak();      
    private Image leegVakje = new ImageIcon(Vak.class.getResource("\\Plaatjes\\grass.png")).getImage();
    private int size = vk.vakSize();
    int x;
    int y;
    
    SpelObject p = new Pacman();
    SpelObject m = new Muur();
    SpelObject e = new Exit();
    SpelObject b = new Bazooka();
    SpelObject h = new Helper();
    SpelObject v = new Vijand();
          
   
   
    @Override
    public void paintComponent(Graphics g) {


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
         
                                
                 g.drawImage(leegVakje, j * size, i * size, size, size, null);

                if (vk.getLevel()[i][j] == 1) {
                    g.drawImage(m.getImage(), j * size, i * size, size, size, null); 
                     m.setPositie(i, j);
                }

                if (vk.getLevel()[i][j] == 2) {

                    g.drawImage(e.getImage(), j * size, i * size, size, size, null);
                    e.setPositie(i, j);
                }

                if (vk.getLevel()[i][j] == 3) {
                
                    g.drawImage(p.getImage(), j * size, i * size, size, size, null);
                    p.setPositie(i, j);
                    p.getY();
                    
                                                   
                }
            }
        }
    }     
   
}
