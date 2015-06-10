/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Marnix
 */

public class Helper extends SpelObject {

    private Image img;
    public ArrayList<Vak> pad = new ArrayList<>();
   
    private int padLengte;
    int dir = 2;
       
    
    public void zoekPad(Vak vak, ArrayList pad) {

        this.pad = pad;       

        SpelObject object = vak.getObject();

        if (!(object instanceof Muur) && !(pad.contains(vak))) { 
            
             pad.add(vak);
                          
             if(object instanceof Exit){
                 
                 if(pad.size() < padLengte ){ 
                     
                     kortstePad = (ArrayList<Vak>)pad.clone();
                     padLengte = pad.size();                     
             }             
        }   else{                 
                 
                System.out.println(pad.size());
                zoekPad(vak.getBuur(dir), pad);            
             }  
        }             
    }

    
    @Override
    public Image getImage() {
        this.img = new ImageIcon(Helper.class.getResource("\\Plaatjes\\friend.png")).getImage();

        return img;
    }

    @Override
    public boolean isPassable() {
        
        return true;
    }

    @Override
    public void pakOp(Pacman p) {
        
     zoekPad(vak, pad);
        
    }
}
