/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private int tijd = 99;
    private int ms = 100;
    private Timer timer;
    private JFrame frame = new JFrame("Doolhof");
    private JComponent component = new Level();
    
    
    public Doolhof() {


        timer = new Timer(ms, this);
        timer.start();

        panel = new Level();
        panel.setLayout(new BorderLayout());
        panel.add(new Timers(tijd));
        panel.addKeyListener(new Toets());         
        panel.setFocusable(true);    

        frame.add(panel, BorderLayout.SOUTH);
        frame.add(component);
        frame.setResizable(false);
        frame.setSize(breedte, hoogte);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

