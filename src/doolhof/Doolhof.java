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
   
    private  Timer repaint = new Timer(25, this);
    private static JFrame frame;
    private static JPanel level;
    private static Timers timer;   
    private int[][] level1;
    private int[][] level2;
    private int[][] level3;
    private int tijd = 59; 
    int keycode;
    
    String[][] levelString;
    private Pacman p;
    
    public Doolhof() {
                
            repaint.start();
           
            String w = "w";
            String c = "c";
            String e = "e";
            
            levelString = new String[][]{
                
                                {w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w},
				{w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,c,c,c,w,c,c,c,c,c,w},
				{w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,c,c,c,w,c,c,c,c,c,w},
                                {w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,c,c,c,w,c,c,c,c,c,w},
                                {w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,c,c,c,w,c,c,c,c,c,w},
				{w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,c,c,c,w,c,c,c,c,c,w},
                                {w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,c,c,c,w,c,c,c,c,c,w},
                                {w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,c,c,c,w,c,c,c,c,c,w},
				{w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,c,c,c,w,c,c,c,c,c,w},
                                {w,c,c,c,w,c,c,c,c,c,c,c,c,c,c,c,c,c,w,c,c,c,c,c,w},
                                {w,c,c,c,w,c,c,c,c,c,c,c,c,c,c,c,c,c,w,c,c,c,c,c,w},
				{w,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,w,c,c,c,c,c,w},
                                {w,c,c,c,c,c,c,c,c,c,c,c,c,c,c,w,c,c,w,c,c,c,c,c,w},
                                {w,c,c,c,c,c,c,c,w,c,c,c,c,c,c,w,c,c,w,c,c,c,c,c,w},
				{w,c,c,c,c,c,c,c,w,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,w},
                                {w,c,c,c,c,c,c,c,w,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,w},
                                {w,c,c,c,c,c,c,c,w,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,w},
				{w,c,c,c,c,c,c,c,w,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,w},
                                {w,c,c,c,c,c,c,c,w,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,w},
                                {w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,w},
				{w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,w},
                                {w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,c,c,c,e,c,c,c,c,c,w},
                                {w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,w},
				{w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,w},
                                {w,c,c,c,w,c,c,c,w,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,w},
                                {w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w},
		};          
                             
            
           timer = new Timers(tijd);
           level = new Level(levelString, 1, timer);
        
           level.addKeyListener(new Toets());
           level.setFocusable(true);              
    }
         
        public static void main(String[] args) {
     
                      
        frame = new Doolhof();        
        frame.setResizable(false);
        frame.setSize(890, 910);
        frame.add(level);
        frame.add(timer, BorderLayout.SOUTH);               
                
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       
     }      
      
             

    @Override
    public void actionPerformed(ActionEvent e) {      
        repaint();          
    }    
}

