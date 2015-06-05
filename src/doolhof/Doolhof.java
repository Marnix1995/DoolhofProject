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
   
    
    int dir;
    String[][] levelString;
   
    
    public Doolhof() {
                
            repaint.start();
           
            String w = "w";
            String c = "c";
            String e = "e";
            String p = "p";
            
            levelString = new String[][]{
                
                                {w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w},
				{w,c,w,c,w,c,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,w},
				{w,c,w,p,w,c,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,w},
                                {w,c,w,c,w,c,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,w},
                                {w,c,w,c,w,c,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,w},
				{w,c,w,c,w,c,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,w},
                                {w,c,w,c,w,w,w,w,w,w,w,w,w,w,w,w,w,w,c,c,c,w},
                                {w,c,w,c,c,c,c,c,c,c,c,c,c,c,c,c,c,w,c,c,c,w},
				{w,c,w,w,w,w,w,w,w,w,w,w,w,w,w,w,c,w,c,c,c,w},
                                {w,c,c,c,c,c,c,c,c,c,c,c,w,c,c,w,c,w,c,c,c,w},
                                {w,c,c,c,c,c,c,c,c,c,c,c,w,c,c,w,c,w,c,c,c,w},
				{w,c,c,c,c,c,c,c,c,c,c,c,w,c,c,w,c,w,c,c,c,w},
                                {w,c,c,c,c,c,c,c,c,w,c,c,w,c,c,w,c,w,c,c,c,w},
                                {w,c,w,c,c,c,c,c,c,w,c,c,w,c,c,w,c,w,c,c,c,w},
				{w,c,w,c,c,c,c,c,c,w,c,c,c,c,c,w,c,w,c,c,c,w},
                                {w,c,w,c,c,c,c,c,c,w,c,c,c,c,c,w,c,w,c,c,c,w},
                                {w,c,w,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,c,c,c,w},
				{w,c,w,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,c,c,c,w},
                                {w,c,w,c,c,c,w,w,w,w,c,c,c,c,c,c,c,c,c,c,c,w},
                                {w,c,w,c,c,c,c,c,c,w,c,c,c,c,e,c,c,c,c,c,c,w},
                                {w,c,w,c,c,c,c,c,c,w,c,c,c,c,c,c,c,c,c,c,c,w},                               
				{w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w},
                                                         
		};          
                            
            
           timer = new Timers(tijd);
           Pacman pc = new Pacman();
           level = new Level(levelString, timer, pc);
        
           level.addKeyListener(new Toets(pc));
           level.setFocusable(true);              
    }
              
    
        public static void main(String[] args) {
                           
        frame = new Doolhof();        
        frame.setResizable(false);
        frame.setSize(890, 980);
        frame.add(level);
        frame.add(timer, BorderLayout.SOUTH);               
                
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       
     }      
                  
    @Override
    public void actionPerformed(ActionEvent e) {      
        this.repaint();          
    }    
}

