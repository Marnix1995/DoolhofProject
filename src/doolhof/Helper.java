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
public class Helper extends SpelObject {

    Image img;
       
    
    public void showRouteToExit(){
                
    }
    
    
    @Override
    public int getY() {

        return y;
    }

    @Override
    public int getX() {

        return x;
    }

    @Override
    public Image getImage() {
        new ImageIcon(Vak.class.getResource("\\Plaatjes\\friend.png")).getImage();

        return img;
    }

    @Override
    public void setPositie(int x, int y) {
     
        
    }

    @Override
    public void move(int x, int y) {
    }

    @Override
    public void drawItem(Graphics g, int x, int y) {
      
        
    }

    @Override
    public void draw(Graphics g) {
    
        
    }

    @Override
    public boolean isPassable() {
       return true;
        
    }
}