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
 * @author Marnix/Alois (c) 2015-05-29
 */
public final class Timers extends JPanel {

    private int teller;
    private int stopGetal = 0;
    private Timer timer;
    private int ms = 1000;
    private Font font = new Font("Century gothic", Font.BOLD, 30);
    private Color color = (Color.BLUE);
    private JLabel tijdLabel;
    private JLabel munitieLabel;
    private ArrayList<JLabel> labels = new ArrayList<>();
    private int munitie;
    int loopTeller = 0;

    public Timers() {

        starten();

        this.munitieLabel = new JLabel();
        this.tijdLabel = new JLabel();

        labels.add(tijdLabel);
        labels.add(munitieLabel);

        for (JLabel l : labels) {

            l.setFont(font);
            l.setForeground(color);
            this.add(l);
        }
    }

    //Dit is voor de munitielabel (schieten) ik weet alleen nog niet of dit gaat werken!
    //**********************************************************************************
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Thread t = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//
//                munitieLabel.setText("Processing");
//                System.out.println(munitie);
//                munitie++;
//
//                munitieLabel.setText("" + munitie);
//            }
//        });
//        t.start();
//    }
    public void starten() {

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String text = getTijdAfhalen(getFormaat());
                tijdLabel.setText("    Time: " + text);

                if (teller < stopGetal) {
                    stop();
                    tijdLabel.setText("    Game Over!");
                }
            }
        };
        timer = new Timer(ms, listener);
        loopTeller = 0;
        timer.start();
    }

    public int setMunitie(int i) {

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                munitie++;
                munitieLabel.setText(" Munitie: " + munitie);

            }
        };
        timer = new Timer(25, listener);
        timer.start();

        munitie += i;
        return munitie;
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

    public void getExtraTijdAfhalen(final int t) {

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                teller--;
                loopTeller++;

                tijdLabel.setText("    Time: " + getTijdAfhalen(getFormaat()));
                System.out.println(loopTeller);
                if (loopTeller == t) {

                    timer.stop();
                    loopTeller = 0;
                }
                if (teller < stopGetal) {
                    stop();
                    timer.stop();
                    tijdLabel.setText("    Game Over!");
                }
            }
        };
        timer = new Timer(1, listener);
        timer.start();
        
    }
}
