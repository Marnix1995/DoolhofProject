/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


/**
 *
 * @author Marnix
 */

public class Pacman extends SpelObject {
      
    int keycode; 
    int left = 37;
    int up = 38;
    int right = 39;
    int down = 40;
        
    private Image img;    
    private Image imgRed;   
    private int vakSize = 32;       
      
        
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
        g.drawImage(img, x * vakSize, y * vakSize, vakSize, vakSize, null);
        
        System.out.println();
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
