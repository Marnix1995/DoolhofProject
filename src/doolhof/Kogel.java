/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Alois
 */

public class Kogel extends SpelObject {

    private int x, y;
    private int dx = 15;
    private Image img;
    private int dir;

    Kogel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    
   
    public void SHOOT_MOVE() //move Kogels
    {
        this.x += dx;        
    }

    public void move(int dir) { // move Kogels via vakkjes werkt nog niet om dat vak.getX(); 0 geeft met een NullPointer
        

    }   
    
    
    
    @Override
    public Image getImage() {
        this.img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\Kogel.png")).getImage();
        return img;
    }

    public void draw(Graphics g) {
        g.drawImage(getImage(), x, y, null);
    }

    @Override
    public void pakOp(Pacman p) {
        
        
    }

    @Override
    public boolean isPassable() {
        return true;
    }
}
