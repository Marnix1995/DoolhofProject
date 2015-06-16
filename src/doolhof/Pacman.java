/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Marnix
 */
public class Pacman extends SpelObject {

    private Image imgDichtRechts = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerDichtRechts.png")).getImage();
    private Image imgDichtOmhoog = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerDichtOmhoog.png")).getImage();
    private Image imgDichtLinks = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerDichtLinks.png")).getImage();
    private Image imgDichtOnder = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerDichtOnder.png")).getImage();
    
    private Image imgRechts = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerRechts.png")).getImage();
    private Image imgLinks = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerLinks.png")).getImage();
    private Image imgBoven = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerBoven.png")).getImage();
    private Image imgOnder = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\playerOnder.png")).getImage();
       
    private int dir;   
    private boolean mondIsDicht = false;
      
    private Timer timer;

        
    
    @Override
    public Image getImage() {

        switch (dir) {
            case 1:
                if (mondIsDicht == true) {
                    return imgDichtOmhoog;
                }                
                return imgBoven;                
                
            case 2:
                if (mondIsDicht == true) {
                    return imgDichtOnder;
                }
                return imgOnder;
            case 3:
                if (mondIsDicht == true) {
                    return imgDichtLinks;
                }
                return imgLinks;
            case 4:

                if (mondIsDicht == true) {
                    return imgDichtRechts;
                }
                return imgRechts;                
            default:               
                return imgRechts;
        }
    }    
  
    public void schiet(int dir) {

       int munitie = vak.level.timer.getMunitie();      
       munitie --;
             
        Vak adf;
        adf = vak;
        while (munitie >= 0) {                   
            
            Vak target = adf.getBuur(this.dir);
            SpelObject item = target.getObject();                        
            vak.level.timer.setMunitie(munitie);
                       
                        
            adf = target;

            if (item instanceof Muur) {
                target.zetVakSpelObjectLeeg(target);               
                break;
            }
        }
    }

    public void wakaWakaWaka() {

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            mondIsDicht = false;               
            }
        };
        timer = new Timer(25, listener);
        timer.start();    
        mondIsDicht = true;              
        timer.setRepeats(false);
        
    }

    public void move(int dir) {

        wakaWakaWaka();      
       
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
