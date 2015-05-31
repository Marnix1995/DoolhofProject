/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Marnix /Alois
 */
public class Doolhof extends JFrame {
    
    private JPanel panel;
    private int breedte = 820;
    private int hoogte = 910;
    private int tijd = 210;
    private int ms = 1000;
    private Timer timer;    
    private JFrame frame = new JFrame("Doolhof");
    private JComponent component = new Vak(); 
        
        
   public Doolhof() {     
             
     
    
   ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {                
                            
                component.repaint();              
            }
        }; 
   
         frame.addKeyListener(new Toets());  //Toetsen aanroepen, werkt nu.
         frame.setFocusable(true);
         timer = new Timer(ms, listener);      
         timer.start();             
    }
        
    public void Doolhof() {
        
       
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
}
