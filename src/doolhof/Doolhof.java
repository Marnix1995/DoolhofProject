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
    private JComponent component = new Vak();   
    

    public Doolhof() {


        timer = new Timer(ms, this);
        timer.start();

        panel = new Level();
        panel.setLayout(new BorderLayout());
        panel.add(new Timers(tijd));
        panel.addKeyListener(new Toetsen());  //Toetsen aanroepen, werkt nu.
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
   
    //Klasse Toets
    public class Toetsen extends KeyAdapter {
        
       Pacman p = new Pacman();
       
        @Override
        public void keyPressed(KeyEvent event) {

            switch (event.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    
                    p.move(0, -1);                  
                    System.out.println("p: " + p.getX()); 
                                                                             
                    break;

                case KeyEvent.VK_RIGHT:
                    
                    p.move(0, 1);
                    
                    break;
                    
                case KeyEvent.VK_UP:
                     p.move(-1, 0);
                    
                    break;
                    
                case KeyEvent.VK_DOWN:
                    
                    p.move(1, 0);
                    
                    break;
            }
repaint();
        }
    }
}
