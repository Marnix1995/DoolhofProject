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
      
    private int keycode; 
    private int left = 37;
    private int up = 38;
    private int right = 39;
    private int down = 40;
        
    private Image img;    
    private Image imgRed;   
    private int size = 32;       
      
        
    public void setKey(int k){
        
      this.keycode = k; 
      checkKey();
      
    }
       
        
    public void checkKey(){
        
        if(keycode == up){                        
            System.out.println("UP");            
        }        
        if(keycode == down){            
            System.out.println("DOWN");
        } 
        if (keycode == left){   
            System.out.println("LEFT");
        } 
    }
        
    
    @Override
    public Image getImage() {

        this.img = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\player.png")).getImage();
        return img;        
    }

    
    @Override
    public void drawItem(Graphics g, int x, int y) {
        g.drawImage(img, x * size, y * size, size, size, null);
                
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
