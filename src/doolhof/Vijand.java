/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;


/**
 *
 * @author Marnix/Alois
 */
public class Vijand extends SpelObject {

    private int x;
    private int y;
   

    public int getY() {

        return y;
    }

    public int getX() {

        return x;
    }
  

    @Override
    public void setObject(int x, int y) {

        this.x = x;
        this.y = y;
    }
   
}
