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
 * @author Marnix/Alois
 */
public class Vijand extends SpelObject {

    private Image img;
    private int x;
    private int y;
   

    @Override
    public int getY() {

        return y;
    }

    @Override
    public int getX() {
       
        return x;
    }
    
    @Override
    public void move(int x, int y) {

        this.x += x;
        this.y += y;
    }

    @Override
    public Image getImage() {
      this.img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\Enemy.png")).getImage(); 
       return img;
    }
   

    @Override
    public void setPositie(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
