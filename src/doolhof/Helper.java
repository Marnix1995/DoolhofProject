/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Marnix
 */
//Mutator is een methode om private atrributen van een methode in een andere klas te bereiken. 
//Accesor is  een methode om private atrributen van een andere klas te bereiken. 

public class Helper extends SpelObject {

    private Image img;
    private Stack<Vak> kortstePad = new Stack<>();
    private int padLengte = Integer.MAX_VALUE;
    private Timer timer;
    private int aantalSecondenZichtbaar = 5;

    public void zoekPad(Vak vak, Stack<Vak> pad) {


        if (!(vak.getObject() instanceof Muur) && !(pad.contains(vak))&& pad.size() < padLengte) {

            pad.push(vak);

            if (vak.getObject() instanceof Exit) {

                if (pad.size() < padLengte) {

                    kortstePad = (Stack<Vak>) pad.clone();
                    padLengte = pad.size();
                }
            } else {

                zoekPad(vak.getBuur(1), pad);
                zoekPad(vak.getBuur(2), pad);
                zoekPad(vak.getBuur(3), pad);
                zoekPad(vak.getBuur(4), pad);
            }         
        
         pad.pop();
        }
    }

    @Override
    public Image getImage() {
        this.img = new ImageIcon(Helper.class.getResource("\\Plaatjes\\friend.png")).getImage();

        return img;
    }

    @Override
    public void pakOp(Pacman p) {

        zoekPad(vak, new Stack<Vak>());


        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                for (Vak v : kortstePad) {
                    v.setKortste(false);
                }
            }
        };

        timer = new Timer(aantalSecondenZichtbaar * 1000, listener);
        timer.start();

        for (Vak v : kortstePad) {
            v.setKortste(true);
        }
    }
}
