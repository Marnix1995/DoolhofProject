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
    private int stopGetal = 0;
    private int ms = 1000; //seconden
    private Font font = new Font("Century gothic", Font.BOLD, 30);
    private Color color = (Color.BLUE);
    private JLabel tijdLabel;
    private String leeg = "     Tijd: --:--";
    private Timer timer;
    private Timer timerExtra;
    private Timer munitieTeller;
    private JLabel munitieLabel;
    private ArrayList<JLabel> labels = new ArrayList<>();
    private int munitie;
    private double loopTeller = 0;
    private int counter = 0;
    private int strafTijd;

    public Timers() {

        munitieLabel = new JLabel(" ");
        tijdLabel = new JLabel(" ");

        labels.add(tijdLabel);
        labels.add(munitieLabel);

        for (JLabel l : labels) {

            l.setAlignmentX(CENTER_ALIGNMENT);
            l.setFont(font);
            l.setForeground(color);
            this.add(l);
        }

        setMunitie(munitie);
        tijdLabel.setText(leeg);

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                               
                tijdLabel.setText("     Tijd: " +getFormaat());

                if (teller < stopGetal) {
                                     
                    timer.stop(); 
                    tijdLabel.setText("    Game Over!");
                    munitieLabel.setText(" ");
                    munitieTeller.stop(); 
                    teller = stopGetal;
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
        
                counter++;
                munitieLabel.setText("   Munitie:  " + counter);
    
                if(counter >= munitie) {                    
                    munitieTeller.setRepeats(false);                                  
                    munitieLabel.setText("   Munitie:  " + munitie);
                    counter = munitie;                                                                   
                }                  
            }           
        };
        munitieTeller = new Timer(25, listener);
        munitieTeller.start();       
    }
      
     public void haalMunitieAf(int i) {
    
          this.munitie = i;          
          counter = munitie;     
          munitieLabel.setText("   Munitie:  " + munitie);     
     }   

     
    public String getHighScore() {

        String formaat = getFormaat();
        return formaat;
    }

    
    public int getMunitie() {

        return munitie;
    }

    public int getStartGetal() {

        return teller;
    }

    public int getStopGetal() {

        return stopGetal;
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
        tijdLabel.setText(leeg);      
    }

    public void stop() {
        timer.stop();
    }

    public String getFormaat() {
        
        int count = teller * ms;
        int minutes = count / (60 * ms);
        int seconds = (count / ms) % 60;
        teller--;

        String str = String.format("%d:%02d", minutes, seconds);
        return str;
    }

    
    public void getExtraTijdAfhalen(int t) {

        this.strafTijd = t;
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                loopTeller += 1.1;
               
                tijdLabel.setText("     Tijd: " + getFormaat());

                if (loopTeller > strafTijd) {
                    loopTeller = 0;
                    timerExtra.setRepeats(false);

                }
                if (teller < stopGetal) {  
                     
                    timerExtra.stop();
                    tijdLabel.setText("    Game Over!");
                    munitieTeller.stop();
                    munitieLabel.setText(" ");  
                    teller = stopGetal;
                }                 
            }
        };
        timerExtra = new Timer(25, listener);
        timerExtra.start();
    }
}
