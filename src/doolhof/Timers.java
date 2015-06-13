package doolhof;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Marnix(c) 2015-06-01
 */
public final class Timers extends JPanel {

    private int teller;
    private int telling;
    private int stopGetal = 0;
    private int ms = 1000; //seconden
    private Font font = new Font("Century gothic", Font.BOLD, 30);
    private Color color = (Color.BLUE);
    private JLabel tijdLabel;
    private Timer timer;
    private Timer timerExtra;
    private JLabel munitieLabel;
    private ArrayList<JLabel> labels = new ArrayList<>();
    private int munitie;    
    private double loopTeller = 0;
    private int strafTijd;

    
    public Timers() {

        this.munitieLabel = new JLabel(" ");
        this.tijdLabel = new JLabel(" ");

        labels.add(tijdLabel);
        labels.add(munitieLabel);

        for (JLabel l : labels) {

            l.setAlignmentX(CENTER_ALIGNMENT);
            l.setFont(font);
            l.setForeground(color);
            this.add(l);
        }

        setMunitie(munitie);

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                telling++;

                String text = getTijdAfhalen(getFormaat());
                tijdLabel.setText("     Tijd: " + text);

                if (teller < stopGetal) {
                    tijdLabel.setText("    Game Over!");
                    timer.removeActionListener(this);
                }
            }
        };
        timer = new Timer(ms, listener);
    }
    
    public void setMunitie(int i) {

        this.munitie = i;      
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                               
                munitieLabel.setText("   Munitie:  " + munitie);
            }
        };
        timer = new Timer(25, listener);
        timer.start();
    }

    
    public int getMunitie() {

        return munitie;
    }

    public int getTelling() {

        return telling;
    }

    public int getStartGetal() {

        return teller;
    }

    public int getStopGetal() {

        return stopGetal;
    }

    public String getTijdAfhalen(String formaat) {

        formaat = getFormaat();
        teller--;

        return formaat;
    }

    public void start(int tijd) {

        this.teller = tijd;
        timer.start();
    }

    public void hervat() {
        timer.start();
    }

    public void pauze() {
        timer.stop();
        tijdLabel.setText("    Pauze");
    }

    public void stop() {
        timer.stop();
    }

    public String getFormaat() {

        int count = teller * ms;
        int minutes = count / (60 * ms);
        int seconds = (count / ms) % 60;

        String str = String.format("%d:%02d", minutes, seconds);
        return str;
    }

    public void getExtraTijdAfhalen(int t) {

        this.strafTijd = t;
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                loopTeller += 2.1;
                teller--;

                tijdLabel.setText("     Tijd: " + getTijdAfhalen(getFormaat()));


                if (loopTeller > strafTijd) {
                    loopTeller = 0;
                    timerExtra.removeActionListener(this);

                }
                if (teller < stopGetal) {
                    timerExtra.stop();
                    tijdLabel.setText("    Game Over!");
                    timer.removeActionListener(this);
                }

            }
        };
        timerExtra = new Timer(25, listener);
        timerExtra.start();

    }
}
