/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;



/**
 *
 * @author Marnix
 */

public class Pacman extends SpelObject {

   
    private int x;
    private int y;

    public int getY() {

        return y;
    }

    public int getX() {

        return x;        
    }

    @Override
    public void move(int x, int y) {

        this.x += x;
        this.y += y;
    }
    
    
          
    //Als buurvakje is grass; loop door;    
    //Als buurvakje is muur stop;
    
   
}
