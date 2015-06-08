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
    private int strafTijd = 5;    
  
    
    @Override
    public Image getImage() {
      this.img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\Enemy.png")).getImage(); 
       return img;
    }
       
    @Override
    public void haalTijdAf(Vak v){
            
        v.checkVijandTimer(strafTijd);
        
    }        
           
   public void Beweeg(int x, int y){
       
            
       
   }    
    
    
    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void pakOp(Pacman p) {
        
                     
                
    }
}
