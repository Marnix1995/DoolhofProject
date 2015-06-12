/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Marnix
 */

public class Pacman extends SpelObject {

    private Image imgRechts = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerRechts.png")).getImage();
    private Image imgLinks = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerLinks.png")).getImage();
    private Image imgBoven = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerBoven.png")).getImage();
    private Image imgOnder = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerOnder.png")).getImage();
    private int dir;
    private boolean heeftMunitie = false;
    private int munitie = 0;
    

    @Override
    public Image getImage() {

        switch (dir) {
            case 1:
                return imgBoven;
            case 2:
                return imgOnder;
            case 3:
                return imgLinks;
            case 4:
                return imgRechts;                
            default:
                return imgRechts;
        }
    }

    @Override
    public boolean isPassable() {
        return true;
    }

     
    public void schiet(int dir) {
        
      // Vak vak =  
        while (heeftMunitie && (munitie > 0)) {
            
          //  Vak target = adf.getBuur(this.dir);
           // SpelObject item = target.getObject();
           // vak.verplaatsLeeg(target);
         //   adf = target;

          //  if (item instanceof Muur) {
                                
             //   target.zetVakSpelObjectLeeg(target);
                munitie--;
                break;
            } 
        }
   // }  
                 
    
    public void move(int dir) {

        this.dir = dir;
       
        Vak target = vak.getBuur(dir);
        SpelObject item = target.getObject();
  
        if (!(item instanceof Muur)) {

            vak.verplaats(target);
            vak = target;
                
            if (item instanceof Vijand) {
               
                item.setVak(vak);
                item.pakOp(this);
            }
            if (item instanceof Exit) {
                item.setVak(vak);
                item.pakOp(this);

            }
            if (item instanceof Bazooka) {
               
                item.setVak(vak);
                item.pakOp(this);
                this.heeftMunitie = true;  
                munitie++;
              
            }
            if (item instanceof Helper) {
                
                item.setVak(vak);
                item.pakOp(this);
            }            
        }
    }

    @Override
    public void pakOp(Pacman p) {
       
       
    }
}
