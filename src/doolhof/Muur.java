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


public class Muur extends SpelObject {
  
private Image img;    
private boolean vernietigbaar;    
private int x ;
private int y ;
private boolean passible = false;
    

    @Override
 public int getY(){
        
       return y;         
    }   
 
    @Override
    public int getX(){ 
        
       return x;        
    }   
          
      
    
    @Override
    public void setPositie(int x, int y){
       
        this.x = x;
        this.y = y;
        
    }
    

    @Override
    public Image getImage() {
       this.img = new ImageIcon(Muur.class.getResource("\\Plaatjes\\crate.png")).getImage(); 
       return img;
    }

    @Override
    public void draw(Graphics g) {
       
    }

    @Override
    public void drawNieuw(Graphics g, int x, int y) {
       
    }    
    
}

