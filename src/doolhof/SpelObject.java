/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Marnix
 */

public abstract class SpelObject {
       
     Doolhof game;    // Dit private
      int rij, kolom; //maak dit private
    private int value;
    private Vak vak;
    private int vakSize = 32;
    
    
     public SpelObject(Doolhof doolhof, int row, int col)
	{
		this.game = doolhof;
		this.rij = row;
		this.kolom = col;
	}
    
    public SpelObject(int value)
	{
		this.value = value;
	}        
    
    public abstract void setPositie(int x, int y);
    public abstract int getX();   
    public abstract int getY();
      
    public abstract void move(int x, int y);
    
    public abstract void drawItem(Graphics g, int x, int y);    
    public abstract void draw(Graphics g);
    
    public abstract boolean isPassable();
    
    public int getVakSize(){
    
      return vakSize; 
    }
    
    public int getRow(){
        return rij;
        
    }
    
    public int getKolom(){
        
        return kolom;
    }
    
    public int getValue(){
        
        return value;        
    }
    
    public abstract Image getImage();    
    
}
