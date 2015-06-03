/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Marnix
 */
public class Pacman extends SpelObject {

    private Image img;
    
    private Image imgRed;
  
    private int vakSize = 32;
    
         

    @Override
    public Image getImage() {

        this.img = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\player.png")).getImage();
        return img;
        
    }

    @Override
    public void drawItem(Graphics g, int x, int y) {
        g.drawImage(img, x * vakSize, y * vakSize, vakSize, vakSize, null);
    }

  

    public Image getRedImage() {

        this.imgRed = new ImageIcon(Vak.class.getResource("\\Plaatjes\\playerRood.png")).getImage();
        return imgRed;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void move(int x, int y) {
      
    }
}
