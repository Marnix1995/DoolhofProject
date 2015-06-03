/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Marnix
 */
public class Vak extends JComponent  {

    private int size = 32;  //Afmeting van een vakje 
    private int x;
    private int y;
       
    private Image img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\grass.png")).getImage();      
    
    private SpelObject p = new Pacman();
    private SpelObject v = new Vijand();
    SpelObject m = new Muur();
     
     
    public Vak(){
        
    } 
     
     
    public Vak(SpelObject object) {
        
                  
    }  
   
    public int getVakSize() {

        return size;
    }
     
    
    public void tekenVakje(Graphics g, int x, int y){
      
        g.drawImage(img, x , y, null);
       
    }
       

    public void getX(int x) {

        this.x = x;
    }

    public void getY(int y) {

        this.y = y;
    }       
    
} 
