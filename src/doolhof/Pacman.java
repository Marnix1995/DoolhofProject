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

    private Image imgRechts = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerRechts.png")).getImage();
    private Image imgLinks = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerLinks.png")).getImage();
    private Image imgBoven = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerBoven.png")).getImage();
    private Image imgOnder = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerOnder.png")).getImage();
    private int dir;
    private int ammunitie;

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

    public void move(int dir) {

        this.dir = dir;

        try {
            Vak target = vak.getBuur(dir);
            SpelObject item = target.getObject();

            if (!(item instanceof Muur)) {

                // if(target != null){
                vak.verplaats(target);
                vak = target;
            }

        } catch (NullPointerException n) {
            System.out.println("NullPointer");
        }
    }

    // if (item instanceof Exit){         
    // }
    //  }
    @Override
    public void pakOp(Pacman p) {
    }
}
