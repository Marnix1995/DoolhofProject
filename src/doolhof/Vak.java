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

//0 of > 5 = leeg vakje
//1 = muur
//2 = exit
//3 = vijand
//4 = helper
//5 = Bazooka

public class Vak extends JComponent {
       
    
    private int size = 32;  //Afmeting van een vakje 
    private int col = 0;
    private int row = 0;
    
    private Doolhof doolhof;
   
    private Image img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\grass.png")).getImage();     
    private SpelObject object;
              
    
    public Vak(SpelObject object){
        
        this.object = object;
        
    }    
    
    public int getVakSize(){ 
       
        return size;         
    }
               
       
    public void drawTile(Graphics g, int x, int y) {

          object.drawItem(g, x, y ); 
          
        }       
            
    
    public void getRow(int row){
        
        this.row = row;
    }
    
    
    public void getCol(int col){
        
        this.col = col;
    } 
    
}
  
    
            
    

