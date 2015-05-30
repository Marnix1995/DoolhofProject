/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Marnix /Alois
 */

public class Doolhof extends JFrame implements ActionListener {
   
    private JPanel panel;
    private int breedte = 820;
    private int hoogte = 910;
    private int tijd = 210;
    private Timer timer;  
    
    
     public Doolhof(){
         
         timer = new Timer(25, this);
         timer.start();                 
     }
    
    public void Doolhof() {

        JFrame frame = new JFrame("Doolhof");
      
        frame.addKeyListener(new Toets());  //Toetsen aanroepen, werkt nu.
        frame.setFocusable(true);                
       
        JComponent component = new Vak();           
        frame.add(component);
              
        panel = new Level();
        panel.setLayout(new BorderLayout());
        panel.add(new Timers(tijd));
        frame.add(panel, BorderLayout.SOUTH);

        frame.setResizable(false);
        frame.setSize(breedte, hoogte);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();         //Repaint werkt niet met de toetsen..
    }    
    
}
