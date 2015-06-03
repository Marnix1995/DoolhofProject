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
public class Bazooka extends SpelObject {

    private Image img;
   
    

    @Override
    public Image getImage() {
        this.img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\rocket_launcher.png")).getImage();
        return img;
    }

    @Override
    public void move(int x, int y) {
    }

    @Override
    public void drawItem(Graphics g, int x, int y) {
    }

 
    @Override
    public boolean isPassable() {
        return true;
    }
}
