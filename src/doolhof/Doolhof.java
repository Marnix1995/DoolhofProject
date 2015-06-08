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
public class Doolhof extends JFrame {

    private static int breedte = 760;
    private static int hoogte = 820;
    private static JFrame frame = new JFrame("Doolhof");
    private static JPanel startPanel;
    private static JPanel knoppenPanel;
    private static JPanel level;
    private static Timers timerPanel;
    private static Font font = new Font("Century gothic", Font.BOLD, 50);
    private static Font fontBtn = new Font("Century gothic", Font.BOLD, 15);
    private static Color color = (Color.BLACK);
    private static JLabel label;

    public Doolhof() {
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

    public static void levelPanel(int levelNummer) {

        Pacman p = new Pacman();
        timerPanel = new Timers();

        if (levelNummer == 1) {
            level = new Level(getLevel1(), timerPanel, p, 120);
        }

        if (levelNummer == 2) {
            level = new Level(getLevel2(), timerPanel, p, 350);

        }
        if (levelNummer == 3) {
            level = new Level(getLevel3(), timerPanel, p, 460);

        }

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
        final String titel = "<html><br><br>Pacman Maze</html>";
        label = new JLabel(titel);
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


        for (JButton b : knoppen) {

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

                int levelNummer = box.getSelectedIndex();
               
                if (levelNummer == 0) {

                    levelPanel(1);
                    frame.setTitle("Level 1");
                }

                if (levelNummer == 1) {

                    levelPanel(2);
                    frame.setTitle("Level 2");
                }

                if (levelNummer == 2) {

                    levelPanel(3);
                    frame.setTitle("Level 3");
                }
                 
                startPanel.setVisible(false);
                
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

                clicks++;

                label.setText("<html><br><br><br><br>Het is de bedoeling om binnen de aangegeven tijd de Exit te bereiken.<br>"
                        + "De speler kan onderweg vijanden tegen komen, die extra tijd van de timer zullen afhalen.<br>"
                        + "De speler kan, als deze aanwezig zijn, een of meerdere bazooka`s oppakken en hiermee<br>"
                        + "binnenmuren wegschieten om zo sneller en makkelijker bij de Exit te komen.<br>"
                        + "Gebruikte toetsen: ↓  →  ↑  ←  ESC,  P en  S.</html>");


                label.setFont(fontBtn);
                if (clicks % 2 == 0) {

                    label.setText(titel);
                    label.setFont(font);
                }
            }
        });

        buttonCheat.addActionListener(new ActionListener() {

            int clicks = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                clicks++;
                label.setText("<html><br><br><br><br>Kies hier het levelnummer.</html>");
                label.setFont(fontBtn);

                box.setVisible(true);

                if (clicks % 2 == 0) {

                    box.setVisible(false);
                    label.setText(titel);
                    label.setFont(font);
                }
            }
        });
    }

    public static void doolhofFrame() {

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
        String b = "b";
        String h = "h";

        String[][] level1 = new String[][]{
            {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w},
            {w, p, c, w, c, c, c, c, c, c, c, w, v, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, c, w, c, w, w, w, w, w, w, w, c, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, v, c, w, c, c, c, c, c, c, c, c, c, w, w, w, w, w, w, w, w, w, w, w, w},
            {w, c, c, w, c, w, w, w, w, w, c, w, c, w, c, c, c, c, v, c, c, c, c, c, w},
            {w, w, c, w, c, c, c, c, c, c, c, w, c, w, c, w, w, w, w, w, w, w, w, w, w},
            {w, c, c, w, w, w, w, w, w, w, w, w, v, w, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, w, w, c, c, c, c, c, c, c, c, c, w, w, w, w, w, w, w, w, w, w, c, w},
            {w, c, c, w, w, w, w, w, w, w, w, w, c, w, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, c, w, c, c, c, c, c, c, c, w, h, w, c, c, c, c, c, c, c, c, w, w, w},
            {w, c, c, w, c, w, w, w, w, w, w, w, v, w, c, w, w, w, w, w, w, w, w, c, w},
            {w, c, w, w, c, c, c, c, c, c, c, w, c, w, c, c, c, c, c, c, c, c, w, c, w},
            {w, c, c, w, c, w, c, w, w, w, c, w, c, w, c, w, w, w, w, w, w, w, w, c, w},
            {w, w, c, w, c, c, c, c, c, c, c, w, v, w, c, c, c, c, c, v, c, c, w, c, w},
            {w, c, c, w, c, c, c, v, c, c, c, c, c, w, c, c, b, c, c, c, c, c, c, c, w},
            {w, c, w, w, w, w, w, w, w, w, w, w, c, w, c, c, w, w, w, w, w, w, w, w, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, c, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, v, c, c, c, c, c, w, w},
            {w, c, c, c, c, b, c, c, c, c, c, w, w, w, w, w, w, w, w, w, w, w, w, w, w},
            {w, c, w, w, w, w, w, w, w, w, w, w, c, c, c, c, c, c, c, w, c, c, c, c, w},
            {w, c, c, c, c, c, c, c, v, c, c, c, c, w, w, w, w, w, c, w, e, c, w, c, w},
            {w, w, w, w, w, w, w, w, w, w, w, w, c, c, c, c, w, c, c, w, w, w, w, c, w},
            {w, c, c, v, c, c, c, v, c, c, c, c, c, c, c, c, w, c, c, c, v, c, c, c, w},
            {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w},};

        return level1;
    }

    public static String[][] getLevel2() {

        String w = "w";
        String c = "c";
        String e = "e";
        String p = "p";
        String v = "v";
        String b = "b";
        String h = "h";

        String[][] level2 = new String[][]{
            {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w},
            {w, p, w, c, c, c, c, c, c, c, c, w, c, c, e, c, c, c, c, c, c, c, c, c, w},
            {w, c, c, c, c, w, w, w, w, w, w, w, c, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, w, w, w, v, w, w, w, w, w, w, w, w},
            {w, c, c, v, c, w, w, w, w, w, c, w, c, w, c, c, c, c, c, c, c, c, c, c, w},
            {w, w, c, c, c, c, c, c, c, c, c, w, c, w, c, w, w, w, v, w, w, w, w, w, w},
            {w, c, c, c, w, w, w, w, w, w, w, w, c, w, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, w, w, c, c, w, w, w, c, c, c, c, w, w, w, w, w, w, w, w, w, w, c, w},
            {w, c, c, w, w, w, w, w, w, w, w, w, c, w, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, c, w, c, c, c, c, c, c, c, w, h, c, c, c, c, c, c, c, c, c, w, w, w},
            {w, c, c, w, b, c, w, w, w, w, v, w, c, w, c, w, w, w, w, w, w, w, w, c, w},
            {w, c, w, w, b, c, c, c, c, c, c, w, c, w, c, c, c, c, c, c, c, c, w, c, w},
            {w, c, c, w, b, w, c, w, w, w, c, w, c, w, c, w, v, w, w, w, w, w, w, c, w},
            {w, w, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, w, c, w},
            {w, c, c, w, c, c, v, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, w, w, w, w, w, w, w, w, w, w, c, w, c, c, w, w, w, w, w, w, w, w, w},
            {w, c, v, c, c, v, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, v, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, b, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, v, c, c, c, c, c, c, c, w, w},
            {w, c, c, c, c, b, c, c, c, c, c, w, w, w, w, w, w, c, w, w, w, w, w, w, w},
            {w, c, w, w, w, w, w, w, w, w, w, w, c, c, c, c, c, c, c, w, c, c, c, c, w},
            {w, c, c, v, c, c, v, c, c, c, c, c, c, w, w, w, w, w, c, w, c, c, w, c, w},
            {w, c, w, w, w, w, w, w, w, w, w, w, c, c, c, c, w, c, c, w, w, w, w, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, w},
            {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w},};
        return level2;
    }
    
    
     public static String[][] getLevel3() {

        String w = "w";
        String c = "c";
        String e = "e";
        String p = "p";
        String v = "v";
        String b = "b";
        String h = "h";

        String[][] level3 = new String[][]{
            
            {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w},
            {w, p, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, c, c, c, w, w, w, w, w, w, w, c, c, c, c, c, c, v, c, c, c, c, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, w, w, w, w, w, w, w, w, w, w, w, w},
            {w, w, w, c, c, w, w, w, w, w, c, w, c, w, v, c, c, c, c, c, c, c, c, c, w},
            {w, w, c, w, c, c, c, c, c, c, c, w, c, w, c, w, w, w, w, w, w, w, w, w, w},
            {w, c, c, c, w, w, w, w, w, w, w, w, c, w, c, c, c, e, c, c, c, c, c, c, w},
            {w, c, w, w, c, c, c, c, c, c, c, c, c, w, w, w, w, w, w, w, w, w, w, c, w},
            {w, c, c, w, w, w, w, w, w, w, w, w, c, w, c, c, c, c, c, c, c, c, c, c, w},
            {w, c, c, w, v, c, c, c, c, v, c, w, c, c, c, c, c, c, c, c, c, c, w, w, w},
            {w, c, c, w, c, c, w, w, w, w, w, w, c, w, c, w, w, w, w, w, w, w, w, c, w},
            {w, c, w, w, c, c, c, c, c, c, c, w, c, w, c, c, c, c, c, c, c, c, w, c, w},
            {w, c, c, w, c, w, c, w, w, w, c, w, c, w, c, w, w, w, w, w, w, w, w, c, w},
            {w, w, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, w, c, w},
            {w, v, c, w, c, c, c, c, c, c, c, c, c, w, c, c, b, c, c, c, c, c, c, c, w},
            {w, c, c, c, c, w, c, c, w, w, w, w, c, w, c, c, w, w, w, w, w, w, w, w, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, v, c, c, c, c, c, c, c, c, w},
            {w, w, c, c, w, w, w, w, w, w, c, c, c, c, c, c, c, c, w, w, w, w, c, c, w},
            {w, c, c, c, c, v, c, c, c, c, c, c, c, v, c, c, c, c, c, c, c, c, c, w, w},
            {w, c, c, c, c, b, c, c, c, c, c, w, w, w, w, w, w, c, w, w, w, w, w, w, w},
            {w, c, w, w, w, w, w, w, w, w, w, w, c, c, c, c, h, c, c, w, c, c, c, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, w, w, w, w, w, c, w, c, c, w, c, w},
            {w, c, w, w, w, w, w, w, w, w, w, w, c, c, c, c, w, c, c, w, w, w, w, c, w},
            {w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, w},
            {w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w},
        };
        return level3;
    }  
    
}
