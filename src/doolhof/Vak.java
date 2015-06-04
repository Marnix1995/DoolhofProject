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

public class Vak extends JComponent {

    private int size = 32;  //Afmeting van een vakje 
    private int x;
    private int y;
    private boolean isSpelObject = false;
    private Image img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\grass.png")).getImage();
    private SpelObject object;
      
    
    public Vak() {
        
    }

    public Vak(SpelObject object) {

        this.object = object;
        this.isSpelObject = true;

    }

    public int getVakSize() {

        return size;
    }
    
    
    public void tekenVakjes(Graphics g, int x, int y) {
          
        if(object instanceof Pacman){
            
         g.drawImage(object.getImage(), x, y,null); 
            System.out.println("Ik ben Pacman");
        }  
            
        if(object instanceof Muur){
        
          g.drawImage(object.getImage(), x, y, null);        
    }
    }
    

    public void getX(int x) {

        this.x = x;
    }

    public void getY(int y) {

        this.y = y;
    }
}
