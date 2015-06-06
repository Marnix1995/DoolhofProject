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
      
    private static int breedte = 760;
    private static int hoogte = 820;   
    private static JFrame frame;
    private static JPanel startPanel;
    private static JPanel knoppenPanel;    
    private static JPanel level;
    private static JPanel munitiePanel;
    private static Timers timerPanel;    
    private static Pacman p = new Pacman();
    private static Font font = new Font("Century gothic", Font.BOLD, 50);
    private static Font fontBtn = new Font("Century gothic", Font.BOLD, 15);
    private static Color color = (Color.BLACK);
     
    private static JLabel label; 
       
       
     public Doolhof(){
           
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
         
              
        timerPanel = new Timers();      
         
        level = new Level(getLevel1(), timerPanel, p);          
        level.setVisible(true);
        frame.add(level);
        frame.add(timerPanel, BorderLayout.SOUTH);       
        
    }

    public static void startPanel() {

       ArrayList<JButton> knoppen = new ArrayList<>(); 
       
        FlowLayout layout = new FlowLayout();

        startPanel = new JPanel();        
        startPanel.setLayout(layout);
        startPanel.setVisible(true); 
          
        JPanel graphicsPanel = new JPanel();
        graphicsPanel.setLayout(layout);
        graphicsPanel.setVisible(true);
        
        label = new JLabel("<html><br><br>Pacman</html>");
        label.setFont(font);
        label.setForeground(color);
        graphicsPanel.add(label);         
        
                                 
        JButton buttonStart = new JButton("Start");  
        JButton buttonExit = new JButton("Exit");            
        JButton buttonRead = new JButton("Read me");        
        JButton buttonCheat = new JButton("Cheats");               
             
        final JComboBox box = new JComboBox();
        box.addItem("Level 1");
        box.addItem("Level 2");
        box.addItem("Level 3");        
        box.setFont(fontBtn);
        box.setVisible(false);
        
        knoppen.add(buttonStart);
        knoppen.add(buttonExit);
        knoppen.add(buttonRead);
        knoppen.add(buttonCheat);     
         
        
        for(JButton b : knoppen ){  
            
            b.setFont(fontBtn);
            b.setBackground(Color.LIGHT_GRAY);
            startPanel.add(b);            
        }
        
        startPanel.add(box);        
        frame.add(startPanel, BorderLayout.NORTH);
        frame.add(graphicsPanel, BorderLayout.CENTER);
                
        buttonStart.addActionListener(new ActionListener() {
  
            @Override
            public void actionPerformed(ActionEvent e) {
                
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
    
       buttonRead.addActionListener(new ActionListener() {

            int clicks = 0;          
            @Override
            public void actionPerformed(ActionEvent e) {
                
            clicks ++;
             
            label.setText("<html><br><br><br><br>Het is de bedoeling om binnen de aangegeven tijd de Exit te bereiken.<br>"
                    + "De speler kan onderweg vijanden tegen komen, die extra tijd van de timer zullen afhalen.<br>"
                    + "De speler kan, als deze aanwezig zijn, een of meerdere bazooka`s oppakken en hiermee<br>"
                    + "binnenmuren wegschieten om zo sneller en makkelijker bij de Exit te komen.<br>"
                    + "Gebruikte toetsen: ↓  →  ↑  ←  ESC,  P en  S.<br><br>"
                    + "© 2015</html>");
              
            label.setFont(fontBtn);            
            if(clicks % 2 == 0){          
           
              label.setText("<html><br><br>Pacman</html>");            
              label.setFont(font);              
            }            
            }
        });      
       
         buttonCheat.addActionListener(new ActionListener() {

            int clicks = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
             clicks ++;
             label.setText("<html><br><br><br><br>Kies hier het levelnummer.</html>");
             label.setFont(fontBtn);  
             
             box.setVisible(true);
             
             
             if(clicks % 2 == 0){
                 
             box.setVisible(false);
           
             
             label.setText("<html><br><br>Pacman</html>");            
             label.setFont(font);    
             
             }             
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
        String v = "v";

        String[][] level1 = new String[][]{
            {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w},
            {w, p, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, c, w, c, w, w, w, w, w, w, w, c, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, c, w, c, c, c, c, c, c, c, c, c, w, w, w, w, w, w, w, w, w, w, w, w},
            {w, c, c, w, c, w, w, w, w, w, c, w, c, w, c, c, c, c, c, c, c, c, c, c, w},
            {w, w, c, w, c, c, c, c, c, c, c, w, c, w, c, w, w, w, w, w, w, w, w, w, w},
            {w, c, c, w, w, w, w, w, w, w, w, w, v, w, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, w, w, c, c, c, c, c, c, c, c, c, w, w, w, w, w, w, w, w, w, w, c, w},
            {w, c, c, w, w, w, w, w, w, w, w, w, c, w, c, c, c, c, c, c, c, c, c, c, w},
            {w, w, c, w, c, c, c, c, c, c, c, w, c, w, c, c, c, c, c, c, c, c, w, w, w},
            {w, c, c, w, c, w, w, w, w, w, w, w, v, w, c, w, w, w, w, w, w, w, w, c, w},
            {w, c, w, w, c, c, c, c, c, c, c, w, c, w, c, c, c, c, c, c, c, c, w, c, w},
            {w, c, c, w, c, w, c, w, w, w, c, w, c, w, c, w, w, w, w, w, w, w, w, c, w}, 
            {w, w, c, w, c, c, c, c, c, c, c, w, v, w, c, c, c, c, c, c, c, c, w, c, w},
            {w, c, c, w, c, c, c, v, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, w, w, w, w, w, w, w, w, w, w, c, w, c, c, w, w, w, w, w, w, w, w, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, c, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, w, w},
            {w, c, c, c, c, c, c, c, c, c, c, w, w, w, w, w, w, w, w, w, w, w, w, w, w},
            {w, c, w, w, w, w, w, w, w, w, w, w, c, c, c, c, c, c, c, w, c, c, c, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, w, w, w, w, w, c, w, e, c, w, c, w},
            {w, w, w, w, w, w, w, w, w, w, w, w, c, c, c, c, w, c, c, w, w, w, w, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, w},           
            {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w},
                        
        };                 
                
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
