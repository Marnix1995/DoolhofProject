/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Marnix
 */

public class Pacman extends SpelObject {

    private Image img;
    private Image imgRed;
    private int ammunitie;

    @Override
    public Image getImage() {

        this.img = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\player.png")).getImage();
        return img;
    }

    public Image getRedImage() {

        this.imgRed = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerRood.png")).getImage();
        return imgRed;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    public void move(int dir) {

        try {
            Vak target = vak.getBuur(dir);
            SpelObject item = target.getObject();

            //if ((item instanceof Muur)) {

            // if(target != null){
            vak.verplaats(target);
            vak = target;
            // }          
        } catch (NullPointerException n) {
            System.out.println("");
        }
    }
    
    // if (item instanceof Exit){         

    // }
    //  }
    @Override
    public void pakOp(Pacman p) {
    }
}
