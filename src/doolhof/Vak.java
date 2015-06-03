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
    private Doolhof doolhof;
    private Image img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\grass.png")).getImage();
    
    private char karakter;
        
            
    public Vak(int x , int y, char karakter) {
        
        this.x = 0;
        this.y = 0;
    }

    public int getVakSize() {

        return size;
    }
     
    
    public void drawTile(Graphics g) {
        
       g.drawRect(x, y, size, size);
       
       
    }

    public void getRow(int row) {

        this.x = row;
    }

    public void getCol(int col) {

        this.y = col;
    }
}
