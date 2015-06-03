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
//0 of > 5 = leeg vakje
//1 = muur
//2 = exit
//3 = vijand
//4 = helper
//5 = Bazooka

public class Level extends JPanel {

    private int n = 25;    //aantal * n vakjes  
    private Vak[][] vakjes = new Vak[n][n];    
    private Vak vak; 
    private int size = 32;
    private int code;
    private Doolhof doolhof;
    private String[][] levelScan;
    private Timers timer;
    
    private SpelObject p = new Pacman();
    private SpelObject m = new Muur();
    private SpelObject v = new Vijand();

    public Level(String[][] level, int levelCode, Timers timer) {


        this.code = levelCode;
        this.levelScan = level;
        this.timer = timer;
        this.vak = new Vak();
        
        timer.start();

        //scannen van level in doolhof  
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                                
                 vakjes[j][i] = new Vak(p);                               
            }
        }
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                vak.tekenVakje(g, j * size,  i * size);                 
            }
        }
    }

    
    public String[][] getVakjes() {

        return levelScan;
    }

    public int GetN() {
        return n;
    }
}
