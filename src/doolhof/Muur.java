/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;


/**
 *
 * @author Marnix
 */


public class Muur extends SpelObject {
  
    
private boolean vernietigbaar;    
private int x;
private int y;
private boolean passible = false;
    

 public int getY(){
        
       return y;         
    }   
 
    public int getX(){  
        
       return x;        
    }   
    
      
    
    @Override
    public void move(int x, int y) {
      
        this.x = x;
        this.y = y;
        
    }

}

