/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Marnix/Alois
 */
public class Level extends JPanel implements ActionListener {

    private int n = 25;    //aantal * n vakjes
    private Timer repaintTimer = new Timer(25, this);
    private Vak[][] vakjes = new Vak[n][n];
    private Doolhof doolhof;
    private String[][] levelScan;
    private int tijd = 60;
    private Timers timer;  
    private int druktOpPauze = 0;
    private Pacman p;
    
    
    public Level(String[][] level, Timers timer, Pacman p) {

        this.timer = timer;
        this.levelScan = level;
        this.p = p;
        timer.start(tijd);
        repaintTimer.start();

        addKeyListener(new Toets(p, this));
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

                    case "v":
                        vakjes[i][j].zetObject(new Vijand());
                        break;
                }
            }
        }
    }     
    
       
    public void toets(int toets) {

        druktOpPauze++;
        this.repaint();
        switch (toets) {

            case 1:
                this.setVisible(false);
                timer.setVisible(false);
                Doolhof.startPanel();

            case 2:
                repaintTimer.stop();
                timer.pauze();
                
                if (druktOpPauze % 2 == 0) {
                    repaintTimer.start();
                    timer.hervat();
                }
        }
    }

    public Vak[][] getVakjes() {

        return vakjes;
    }

    @Override
    public void paintComponent(Graphics g) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                vakjes[i][j].tekenVakjes(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
         this.repaint();
            
         if (timer.getStopGetal() == timer.getStartGetal()) {
           repaintTimer.stop();
        
    }
}
}
