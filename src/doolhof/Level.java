/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
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
    private Vak[][] vakjes  = new Vak[n][n];
    
    private int size = 32;
    private int code;
    private Doolhof doolhof;
    private int[][] levelScan; 
    private Timers timer;
       
    
    public Level(Doolhof doolhof, int[][]level, int levelCode, Timers timer){
                
              
       this.code = levelCode;
       this.doolhof = doolhof;
       this.levelScan = level;
       this.timer = timer; 
       timer.start();     
                       
    }            
    
    @Override
	public void paintComponent(Graphics g)
	{
		this.draw(g);              
	}
    
    public void draw(Graphics g) {

    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               
                // tekent muur
                
                if (this.levelScan[i][j] == 1) {

                    this.vakjes[i][j] = new Vak(new Muur()) {
                      
                        public boolean isPassable() {
                            return false;
                        }
                    };
                    this.vakjes[i][j].drawTile(g, j * size, i * size);
                    
                    
                } //  tekent grass
                
                else if (this.levelScan[i][j] == 0) {

                    this.vakjes[i][j] = new Vak(new Exit()) {

                       
                        public boolean isPassable() {
                            return true;
                        }
                    };
                    
                    this.vakjes[i][j].drawTile(g, j * size, i * size);
                    
                }  // tekent exit
                
                else if (this.levelScan[i][j] == 2) {

                    this.vakjes[i][j] = new Vak(new Pacman()) {

                     
                        public boolean isPassable() {
                            return true;
                        }
                    };                   
                    this.vakjes[i][j].drawTile(g, j * size, i * size);
                    
                }                                 
            }
        }
 
        // teken pacman
     doolhof.p.draw(g);
          
      
        //for (SpelObject m : doolhof.objecten) {
            //if (!m.equals(null)) {
             //   m.draw(g);
            }
        }
        

