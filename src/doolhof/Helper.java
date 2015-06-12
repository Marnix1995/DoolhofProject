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
 *///Mutator is een methode om private atrributen van een methode in een andere klas te bereiken.
//Accesor is  een methode om private atrributen van een andere klas te bereiken.

public class Helper extends SpelObject {

    private Image img;
    private ArrayList<Vak> kortstePad = new ArrayList<>();
    private int padLengte = Integer.MAX_VALUE;

    
    public void zoekPad(Vak vak, ArrayList<Vak> pad) {

        if (!(vak.getObject() instanceof Muur) && !(pad.contains(vak))) {

            pad.add(vak);

            if (vak.getObject() instanceof Exit) {

                if (pad.size() < padLengte) {

                    kortstePad = (ArrayList<Vak>)pad.clone();
                    this.padLengte = pad.size();
                    
                }
            } else {
                
                zoekPad(vak.getBuur(1), pad);
                zoekPad(vak.getBuur(2), pad);
                zoekPad(vak.getBuur(3), pad);
                zoekPad(vak.getBuur(4), pad);
                
            }            
        }
        //pad.remove(vak);
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

        zoekPad(vak, new ArrayList<Vak>());

        for (Vak v : kortstePad) {
            v.setKortste(true);

        }
    }
}
