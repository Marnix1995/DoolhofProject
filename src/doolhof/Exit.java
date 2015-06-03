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
public class Exit extends SpelObject {

    private Image img;
    private int x;
    private int y;
    
        public Exit(Doolhof game, int row, int col) {
        super(game, row, col);
    }
    
    public Exit()
	{
	super(1);
	}
      
    
    @Override
    public void setPositie(int x, int y) {
      this.x = x;
      this.y = y;
    }   
    
    
    @Override
     public int getY(){
       
       return y;        
    }
    
    @Override
    public int getX(){          
        return x;        
    }    
         

    @Override
    public Image getImage() {
      this.img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\finish.png")).getImage(); 
      return img;
      
    } 
   

    @Override
    public void move(int x, int y) {
       
    }

    @Override
    public void drawItem(Graphics g, int x, int y) {
       
    }

    @Override
    public void draw(Graphics g) {
      
    }

    
    @Override
    public boolean isPassable() {
      return true;
    }
}
