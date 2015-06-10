/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Marnix/Alois
 */
public class Level extends JPanel implements ActionListener {

    private int n = 25;    //aantal * n vakjes
    private Timer repaintTimer = new Timer(25, this);
    public Vak[][] vakjes = new Vak[n][n];
    private String[][] levelScan;
    public Timers timer;
    private int druktOpPauze = 0;
    private Pacman p;
    public Doolhof doolhof;

    public Level(String[][] level, Timers timer, Pacman p, int tijd) {

        this.timer = timer;
        this.levelScan = level;
        this.p = p;
        timer.start(tijd);

        repaintTimer.restart();

        addKeyListener(new Toets(p, this));
        setFocusable(true);

        setObjectPosities();
    }

    public final void setObjectPosities() {


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                vakjes[i][j] = new Vak(this, j, i);

                switch (levelScan[i][j]) {

                    case "w":
                        vakjes[i][j].zetObject(new Muur(true));
                        break;
                    case "x":
                        vakjes[i][j].zetObject(new Muur(false));
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

                    case "h":
                        vakjes[i][j].zetObject(new Helper());
                        break;

                    case "b":
                        vakjes[i][j].zetObject(new Bazooka());
                        break;
                }
            }
        }
    }

    public void updateLevel() {

        this.removeAll();
        this.setVisible(false);
        timer.setVisible(false);
        timer.removeAll();

        repaintTimer.removeActionListener(this);

    }

    public void pauzeer() {
        repaintTimer.stop();
        timer.pauze();
    }

    public void hervat() {

        repaintTimer.start();
        timer.hervat();
    }

    public void toets(int toets) {

        druktOpPauze++;
        this.repaint();
        switch (toets) {

            case 1:
                updateLevel();
                Doolhof.startPanel();
                break;

            case 2:
                pauzeer();
                if (druktOpPauze % 2 == 0 && timer.getStartGetal() > timer.getStopGetal()) {
                    hervat();
                }
                break;
            case 3:

                Doolhof.levelPanel(Doolhof.checkHuidigLevel());
                updateLevel();
                break;
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

        repaintTimer.restart();
        this.repaint();

        // updateKogel(); // Kogel methode om de kogel te laten bewegen

        if (timer.getStartGetal() < timer.getStopGetal()) {

            repaintTimer.removeActionListener(this);

        }
    }
}
