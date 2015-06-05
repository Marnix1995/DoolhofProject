package doolhof;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Marnix /Alois
 */
public class Doolhof extends JFrame implements ActionListener {
   
    private Timer timerRepaint = new Timer(25, this);
    private static int breedte = 890;
    private static int hoogte = 980;   
    private static JFrame frame;
    private static JPanel startPanel;
    private static JPanel knoppenPanel;    
    private static JPanel level;
    private static Timers timer;
    private static int tijd = 60;   
    private static Pacman p = new Pacman();
    private static Font font = new Font("Century gothic", Font.BOLD, 50);
    private Image img = new ImageIcon(Doolhof.class.getResource("\\Plaatjes\\player.png")).getImage();
    private static Color color = (Color.BLACK);
        
    
    public Doolhof() {
         
        
        timerRepaint.start();
        
    }

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

        timer = new Timers(tijd);
        level = new Level(getLevel1(), timer, p);

        level.setVisible(true);
        frame.add(level);
        frame.add(timer, BorderLayout.SOUTH);

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
        
        JButton buttonExit = new JButton("Exit");        
        JButton buttonStart = new JButton("Start");
        JButton buttonRead = new JButton("Read Me");        
        JButton buttonCheat = new JButton("CHEATS");    
        
        startPanel.add(buttonStart);
        startPanel.add(buttonExit);
        startPanel.add(buttonRead);
        startPanel.add(buttonCheat);         
               
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

    @Override
    public void actionPerformed(ActionEvent e) {
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
}
