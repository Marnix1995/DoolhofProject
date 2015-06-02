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
    private Image imgRed;  
           
    
    @Override
    public void setPositie(int x, int y){
            
     this.x = x;
     this.y = y;     
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
    public void move(int x, int y) {

        this.x += x;
        this.y += y;
    }         
    
                    
    //Als buurvakje is grass; loop door;    
    //Als buurvakje is muur stop;

    @Override
    public Image getImage() {
      
        this.img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\player.png")).getImage();  
        return img;
       
    }
    
    public Image getRedImage() {
      
        this.imgRed = new ImageIcon(Vak.class.getResource("\\Plaatjes\\playerRood.png")).getImage();  
        return imgRed;
      
}
}
