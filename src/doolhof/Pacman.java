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
    private int munitie = 5;
    private int x;
    private int y;
    
    Kogel kogel;
    ArrayList<Kogel> store_kogelOp = new ArrayList<>(); //array list met kogels
    
    public ArrayList<Kogel> getBULLETS() //get kogels array
    { return store_kogelOp; }
    
    public void setBULLETS(Kogel value) //zet kogels
    { store_kogelOp.add(value); }
    
    public void schiet()
    {
        kogel = new Kogel(this.getX() ,this.getY()); // nieuwe kogel
        store_kogelOp.add(kogel);    //opslaan in araylist
    }
    
    public int getX() { 
        
        System.out.println(x + "positie");       
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

        try {
            Vak target = vak.getBuur(dir);
            SpelObject item = target.getObject();
           
            if (!(item instanceof Muur)) {

                // if(target != null){
                vak.verplaats(target);
                vak = target;
            }

            if (item instanceof Vijand) {
               pakOp(this); 
               item.haalTijdAf(vak);
                                           
            }
           
        } catch (NullPointerException n) {
            System.out.println("NullPointer");
        }         
    }

    @Override
    public void pakOp(Pacman p) {
        
                 
    }
}
