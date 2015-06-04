/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Marnix
 */
public class Vak extends JComponent {

    private int size = 32;  //Afmeting van een vakje 
    private int x;
    private int y;
    private boolean isSpelObject = false;
    private Image img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\grass.png")).getImage();
    private SpelObject speelObject;
    private Level level;
    
  
    public Vak(Level level, int x, int y) {
        
        this.level = level;
        this.x = x;
        this.y = y;
        
    }
    //public void setObject(Spelobject s){
       
    
//}
 
    public int getVakSize() {

        return size;
    }

    public void tekenVakjes(Graphics g) {
                      
       
         g.drawImage(img, x * size, y * size, this);             
          
        if(speelObject != null){
            g.drawImage(speelObject.getImage(), x * size ,y * size, this);
        }
        }
    
    public Vak getBuur(int dir){
            
        level.getBuur(x, y, dir);
        
               
        
            }

    public void zetObject(SpelObject s){
        speelObject = s;  
        
    }
    
    
    public SpelObject getObject(){
        
        
        return speelObject;            
}
        
    public void verplaats(Vak t){
        t.zetObject(speelObject);   
        speelObject = null;    
    }
        
    public void getX(int x) {

        this.x = x;
    }

    public void getY(int y) {

        this.y = y;
    }
}
