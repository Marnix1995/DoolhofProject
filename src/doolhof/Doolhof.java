/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Marnix /Alois
 */
public class Doolhof extends JFrame implements ActionListener {

    private JPanel tijdPanel;
    private int breedte = 820;
    private int hoogte = 910;
    private int tijd = 99;
    private int ms = 20;
    private Timer timer;
    private JFrame frame = new JFrame("Doolhof");
    private JPanel levelPanel = new Level();
           
    public Doolhof() {

       timer = new Timer(ms, this);
       timer.start(); 
               
        tijdPanel = new Timers(tijd);            
               
        frame.add(tijdPanel, BorderLayout.SOUTH);
        levelPanel.setLayout(new BorderLayout());   
        frame.add(levelPanel);
        frame.setResizable(false);
        frame.setSize(breedte, hoogte);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    frame.repaint();     
                
    }
}

