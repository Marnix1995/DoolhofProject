package doolhof;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Marnix /Alois
 */

    public class Doolhof extends JFrame  {
      
    private static int breedte = 890;
    private static int hoogte = 980;   
    private static JFrame frame;
    private static JPanel startPanel;
    private static JPanel knoppenPanel;    
    private static JPanel level;
    private static Timers timerPanel;    
    private static Pacman p = new Pacman();
    private static Font font = new Font("Century gothic", Font.BOLD, 50);
    private static Font fontBtn = new Font("Century gothic", Font.BOLD, 15);
    private Image img = new ImageIcon(Doolhof.class.getResource("\\Plaatjes\\player.png")).getImage();
    private static Color color = (Color.BLACK);
    private static ArrayList<JButton> knoppen = new ArrayList<>();  
       
   
    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                doolhofFrame();
                startPanel();
            }
        });
    }

    public static void levelPanel() {

        timerPanel = new Timers();
        level = new Level(getLevel1(), timerPanel, p);

        level.setVisible(true);
        frame.add(level);
        frame.add(timerPanel, BorderLayout.SOUTH);

    }

    public static void startPanel() {


        FlowLayout layout = new FlowLayout();

        startPanel = new JPanel();        
        startPanel.setLayout(layout);
        startPanel.setVisible(true); 
          
        JPanel graphicsPanel = new JPanel();
        graphicsPanel.setLayout(layout);
        graphicsPanel.setVisible(true);
        
        JLabel label = new JLabel("<html><br><br>Pacman</html>", SwingConstants.CENTER);
        label.setFont(font);
        label.setForeground(color);
        graphicsPanel.add(label); 
                                    
        JButton buttonStart = new JButton("Start");  
        JButton buttonExit = new JButton("Exit");            
        JButton buttonRead = new JButton("Read me");        
        JButton buttonCheat = new JButton("Cheats");         
       
        knoppen.add(buttonStart);
        knoppen.add(buttonExit);
        knoppen.add(buttonRead);
        knoppen.add(buttonCheat);
        
        for(JButton b : knoppen ){  
            
            b.setFont(fontBtn);
            b.setBackground(Color.LIGHT_GRAY);
            startPanel.add(b);           
        }
        
        
        frame.add(startPanel, BorderLayout.NORTH);
        frame.add(graphicsPanel, BorderLayout.CENTER);
        
        
        buttonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent start) {

                levelPanel();
                startPanel.setVisible(false);                 
                frame.setTitle("Level 1");
            }
        });

        buttonExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
    }
       
        
    public static void doolhofFrame() {

        frame = new Doolhof();
        frame.setTitle("Doolhof");
        frame.setResizable(false);
        frame.setSize(breedte, hoogte);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static String[][] getLevel1() {

        String w = "w";
        String c = "c";
        String e = "e";
        String p = "p";


        String[][] level1 = new String[][]{
            {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w},
            {w, p, w, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, w},
            {w, c, w, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, w},
            {w, c, w, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, w},
            {w, c, w, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, w},
            {w, c, w, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, w},
            {w, c, w, c, w, w, w, w, w, w, w, w, w, w, w, w, w, w, c, c, c, w},
            {w, c, w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, w, c, c, c, w},
            {w, c, w, w, w, w, w, w, w, w, w, w, w, w, w, w, c, w, c, c, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, w, c, c, w, c, w, c, c, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, w, c, c, w, c, w, c, c, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, w, c, c, w, c, w, c, c, c, w},
            {w, c, c, c, c, c, c, c, c, w, c, c, w, c, c, w, c, w, c, c, c, w},
            {w, c, w, c, c, c, c, c, c, w, c, c, w, c, c, w, c, w, c, c, c, w},
            {w, c, w, c, c, c, c, c, c, w, c, c, c, c, c, w, c, w, c, c, c, w},
            {w, c, w, c, c, c, c, c, c, w, c, c, c, c, c, w, c, w, c, c, c, w},
            {w, c, w, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, w, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, w, c, c, c, w, w, w, w, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, w, c, c, c, c, c, c, w, c, c, c, c, e, c, c, c, c, c, c, w},
            {w, c, w, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w},};

        return level1;
    }
    
     public static String[][] getLevel2() {

        String w = "w";
        String c = "c";
        String e = "e";
        String p = "p";
        String v = "v";

        String[][] level2 = new String[][]{
            {v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v},
            {v, p, w, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, v},
            {v, c, w, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, v},
            {v, c, w, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, v},
            {v, c, w, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, v},
            {v, c, w, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, v},
            {v, c, w, c, w, w, w, w, w, w, w, w, w, w, w, w, w, w, c, c, c, v},
            {v, c, w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, w, c, c, c, v},
            {v, c, w, w, w, w, w, w, w, w, w, w, w, w, w, w, c, w, c, c, c, v},
            {v, c, c, c, c, c, c, c, c, c, c, c, w, c, c, w, c, w, c, c, c, v},
            {v, c, c, c, c, c, c, c, c, c, c, c, w, c, c, w, c, w, c, c, c, v},
            {v, c, c, c, c, c, c, c, c, c, c, c, w, c, c, w, c, w, c, c, c, v},
            {v, c, c, c, c, c, c, c, c, w, c, c, w, c, c, w, c, w, c, c, c, v},
            {v, c, w, c, c, c, c, c, c, w, c, c, w, c, c, w, c, w, c, c, c, v},
            {v, c, w, c, c, c, c, c, c, w, c, c, c, c, c, w, c, w, c, c, c, v},
            {v, c, w, c, c, c, c, c, c, w, c, c, c, c, c, w, c, w, c, c, c, v},
            {v, c, w, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, c, v},
            {v, c, w, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, c, v},
            {v, c, w, c, c, c, w, w, w, w, c, c, c, c, c, c, c, c, c, c, c, v},
            {v, c, w, c, c, c, c, c, c, w, c, c, c, c, e, c, c, c, c, c, c, v},
            {v, c, w, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, c, v},
            {v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v, v},};

        return level2;
    }   
}
