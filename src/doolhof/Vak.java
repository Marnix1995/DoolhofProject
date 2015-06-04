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

    
    public Vak(SpelObject objects, int x, int y) {
        
        this.speelObject = objects;
        this.x = x;
        this.y = y;
        
    }
 
    public int getVakSize() {

        return size;
    }

    public void tekenVakjes(Graphics g, int x, int y) {
        
        //System.out.println(speelObject);
        
        if(speelObject == null){
           g.drawImage(img, x, y, this);             
        }    
        else{
            g.drawImage(speelObject.getImage(), x, y, this);
        }
        }
    

    public void getX(int x) {

        this.x = x;
    }

    public void getY(int y) {

        this.y = y;
    }
}
