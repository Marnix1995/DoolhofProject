/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Marnix/Alois
 */
public class Level extends JPanel {

    private int n = 22;    //aantal * n vakjes  
    private Vak[][] vakjes = new Vak[n][n];
    private Vak vak;
    private int code;
    private Doolhof doolhof;
    private String[][] levelScan;
    private Timers timer;
        
    
    public Level(String[][] level, Timers timer,  Pacman p) {

        this.levelScan = level;
        this.timer = timer;
        timer.start();
        
        addKeyListener(new Toets(p));
        setFocusable(true);
        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                vakjes[i][j] = new Vak(this, j, i);

                
                switch (levelScan[i][j]) {

                    case "w":
                        vakjes[i][j].zetObject(new Muur());
                        break;

                    case "e":
                        vakjes[i][j].zetObject(new Exit());                        
                        break;

                    case "p":                                                 
                        vakjes[i][j].zetObject(p);                                 
                       p.setVak(vakjes[i][j]);
                        break;
                }
            }
        }
    }

   public Vak[][] getVakjes(){
            
       return vakjes;
   }

    @Override
    public void paintComponent(Graphics g) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                vakjes[i][j].tekenVakjes(g);
            }
        }
      repaint();
    }
}
