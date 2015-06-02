
package doolhof;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Marnix/Alois (c) 2015-05-29
 */

public class Timers extends JPanel {

    
    private int startGetal;
    private int stopGetal = 0;
    private int ExtraTijd = 5;    //Dit is hoeveel er van de tijd afgehaald mag worden. Dit is later nodig voor de vijand.
    private Timer timer;
    private int ms = 1000;
    private int ms2 = 50;
    private Font font = new Font("Century gothic", Font.BOLD, 50);
    private Color color = (Color.BLUE);
    private JLabel label;   
       
       
    public Timers(int s) {
      
        this.startGetal = s;
              
        this.label = new JLabel();
        label.setFont(font);
        label.setForeground(color);                       
        add(label);      
           
           ActionListener listener = new ActionListener() {

           
            @Override
            public void actionPerformed(ActionEvent e) {
                       
                               
                String text = getTijdAfhalen(getFormaat());
                label.setText("Time: "+text);
                
                if (startGetal < stopGetal) {                    
                    stop();
                    label.setText("Game Over!");
                }
            }
        };
                
        timer = new Timer(ms, listener);
        start();  
    }
          
    public String getExtraTijdAfhalen(String formaat){
        
        formaat = getFormaat();      
        startGetal -= ExtraTijd;
        
        return formaat;        
    }  
    
    
    public String getTijdAfhalen(String formaat){
        
        formaat = getFormaat();
        startGetal --;
        
        return formaat;
    }
   
    public void start(){
        
     timer.start();        
    }
    
    public void stop(){
        
     timer.stop();        
    }
    
    public String getFormaat(){
            
       int count = startGetal * ms; 
       int minutes = count / (60 * ms);
       int seconds = (count / ms) % 60; 
      
        String str = String.format("%d:%02d", minutes, seconds);
        return str;       
    }   
}


