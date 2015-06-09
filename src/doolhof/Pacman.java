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
public class Pacman extends SpelObject {

    private Image imgRechts = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerRechts.png")).getImage();
    private Image imgLinks = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerLinks.png")).getImage();
    private Image imgBoven = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerBoven.png")).getImage();
    private Image imgOnder = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerOnder.png")).getImage();
    private int dir;
    private int munitie = 1;
    boolean heeftMunitie = false;
    private int x;
    private int y;
    public Kogel kogel;
    private ArrayList<Kogel> store_kogelOp = new ArrayList<>();

        
    public ArrayList<Kogel> getBULLETS() //get kogels array
    {
        return store_kogelOp;
    }


    public void schiet() {
        if (heeftMunitie = true && (munitie > 0)) {
            kogel = new Kogel(this.getX(), this.getY()); // nieuwe kogel
            munitie--;
            store_kogelOp.add(kogel);    //opslaan in araylist
        } else {
            heeftMunitie = false;
        }
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

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
               
                //item.setVak(vak);
                item.pakOp(this);
                
                heeftMunitie = false;                
                vak.level.timer.setMunitie(munitie);
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
