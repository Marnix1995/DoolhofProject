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
    private int x;
    private int y;
    private int size = 32;
       
    
    @Override
    public int getY() {

        return y;
    }

    @Override
    public int getX() {
 
        return x;        
    }      
         
      
    public void move(int x, int y) {

        this.x += x;
        this.y += y;
    }
     
    @Override
    public void setPositie(int x, int y){
     this.x = x;
     this.y = y;        
    }  
    
    @Override
     public void draw(Graphics g) {
	g.drawImage(img, x*size, y*size, size, size,null);
       
	}
    
    @Override
     public void drawNieuw(Graphics g, int x, int  y){
          g.drawImage(img, x + size, y + size, size, size,null); 
         
     }
     
             
    //Als buurvakje is grass; loop door;    
    //Als buurvakje is muur stop;

    @Override
    public Image getImage() {
      
        this.img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\player.png")).getImage();  
        return img;
    }       
}
