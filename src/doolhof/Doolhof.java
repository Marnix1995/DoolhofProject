package doolhof;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Marnix / Alois
 *///Pacman Maze

public class Doolhof extends JFrame {

    private static int breedte = 760;
    private static int hoogte = 830;
    private static String title = "Pacman-Maze";
    private static JFrame frame = new JFrame();
    private static JPanel startPanel;
    private static JPanel level;
    private static Timers timerPanel;
    private static Font font = new Font("Century gothic", Font.BOLD, 50);
    private static Font fontBtn = new Font("Century gothic", Font.BOLD, 15);
    private static Color color = (Color.BLACK);
    private static JLabel label;
    private static JLabel fotoLabel;
    private static int checkLevel;
    private static ImageIcon img = new ImageIcon(Doolhof.class.getResource("\\Plaatjes\\startFrame.png"));  
    private static JList list = new JList();

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                doolhofFrame();
                startPanel();
                snelsteTijd();
            }
        });
    }

    public static void levelPanel(int levelNummer) {

        Pacman p = new Pacman();
        Doolhof.checkLevel = levelNummer;


        if (levelNummer == 1) {

            timerPanel = new Timers();
            level = new Level(getLevel1(), timerPanel, p, 270);
            frame.setTitle("Level 1");
            frame.add(level);

        } else if (levelNummer == 2) {

            insert(timerPanel.getHighScore(), 1);
            snelsteTijd();
            timerPanel = new Timers();
            level = new Level(getLevel2(), timerPanel, p, 400);
            frame.setTitle("Level 2");
            frame.add(level);

        } else if (levelNummer == 3) {

            insert(timerPanel.getHighScore(), 2);
            snelsteTijd();
            timerPanel = new Timers();
            level = new Level(getLevel3(), timerPanel, p, 600);
            frame.setTitle("Level 3");
            frame.add(level);

        } else if (levelNummer == 0) {

            timerPanel = new Timers();
            level = new Level(getLevel0(), timerPanel, p, 60);
            frame.setTitle("Level 0");
            frame.add(level);

        } else {

            insert(timerPanel.getHighScore(), 3);
            snelsteTijd();
            startPanel();

        }
        frame.add(timerPanel, BorderLayout.SOUTH);
    }

    public static int checkHuidigLevel() {

        int huidig = Doolhof.checkLevel;
        return huidig;
    }

    public static void startPanel() {

        ArrayList<JButton> knoppen = new ArrayList<>();

        FlowLayout layout = new FlowLayout();

        frame.setTitle(title);
        startPanel = new JPanel();
        startPanel.setLayout(layout);
        startPanel.setVisible(true);

        final JPanel graphicsPanel = new JPanel();
        graphicsPanel.setLayout(layout);
        graphicsPanel.setVisible(true);
        final String titel = "<html><br>Pacman Maze<br><br><br></html>";
        label = new JLabel(titel);
        fotoLabel = new JLabel();

        fotoLabel.setIcon(img);

        label.setFont(font);
        label.setForeground(color);

        list.setFont(fontBtn);
        list.setForeground(color);

        graphicsPanel.add(label);
        graphicsPanel.add(fotoLabel, BorderLayout.SOUTH);
        graphicsPanel.add(list);


        JButton buttonStart = new JButton("Start");
        JButton buttonExit = new JButton("Exit");
        JButton buttonRead = new JButton("Read me");
        JButton buttonCheat = new JButton("Cheats");

        final JComboBox box = new JComboBox();
        box.addItem("Demo");
        box.addItem("Level 1");       
        box.setSelectedIndex(1);
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
                    levelPanel(0);
                }

                if (levelNummer == 1) {
                    levelPanel(1);
                }

                startPanel.setVisible(false);
                graphicsPanel.setVisible(false);
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

                label.setText("<html><br><br>Het is de bedoeling om binnen de aangegeven tijd de Exit te bereiken.<br>"
                        + "De speler kan onderweg vijanden tegen komen, die extra tijd van de timer zullen afhalen.<br>"
                        + "De speler kan, als deze aanwezig zijn, een of meerdere bazooka`s oppakken en hiermee<br>"
                        + "binnenmuren wegschieten om zo sneller en makkelijker bij de Exit te komen.<br>"
                        + "Gebruikte toetsen: ↓  →  ↑  ←  ESC,  P, R  en  Space.<br><br>"
                        + "P      =  pauze toets<br>"
                        + "R      =  Restart level<br>"
                        + "Space  =  Schieten<br>"
                        + "Esc    =  Terug naar startscherm.<br><br></html>");

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
                label.setText("<html><br><br>Kies hier het levelnummer en klik op start.<br><br><br><br><br><br><br><br><br><br></html>");
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

    private static void snelsteTijd() {

        try {
            DefaultListModel datamodel = new DefaultListModel();
            Doolhof.list.setModel(datamodel);

            String query = "SELECT MAX(TIME_FORMAT(score1,'%H:%i')) AS score1, MAX(TIME_FORMAT(score2,'%H:%i'))"
                    + " AS score2, MAX(TIME_FORMAT(score3, '%H:%i')) AS score3 from Level;";

            //Vanaf database:

            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet results = statement.executeQuery();

            while (results.next()) {

                String s1 = results.getString("score1");
                String s2 = results.getString("score2");
                String s3 = results.getString("score3");

                Object[] rij = {s1, s2, s3};
              
                datamodel.addElement("High score");
                datamodel.addElement("________________");
                datamodel.addElement("Level 1:");
                datamodel.addElement(s1);
                datamodel.addElement("________________");
                datamodel.addElement("Level 2:");
                datamodel.addElement(s2);
                datamodel.addElement("________________");
                datamodel.addElement("Level 3:");
                datamodel.addElement(s3);
                datamodel.addElement("________________");

            }

            Doolhof.list.setModel(datamodel);
        } catch (SQLException ex) {               
            Logger.getLogger(Doolhof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                            
        }
    }

    public static void insert(String tijd, int levelNummer) {

        try {
            Connection connection = DataBase.getConnection();

            if (levelNummer == 1) {
                String query = "insert into Level (score1) values(?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, tijd);
                statement.executeUpdate();
            }

            if (levelNummer == 2) {
                String query = "insert into Level (score2) values(?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, tijd);
                statement.executeUpdate();
            }

            if (levelNummer == 3) {
                String query = "insert into Level (score3) values(?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, tijd);
                statement.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Doolhof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static String[][] getLevel1() {

        String w = "w";
        String c = "c";
        String e = "e";
        String p = "p";
        String v = "v";
        String b = "b";
        String h = "h";
        String x = "x";

        String[][] level1 = new String[][]{
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},
            {x, c, p, c, c, c, c, c, c, c, c, w, v, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, b, c, w, c, w, w, w, w, w, w, w, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, c, c, c, c, c, c, c, c, w, w, w, c, w, w, w, w, w, w, w, x},
            {x, c, c, w, c, w, w, w, w, w, c, w, c, w, c, c, c, c, c, c, c, c, c, c, x},
            {x, w, c, c, c, c, c, c, c, c, c, w, c, w, c, w, w, w, w, w, w, w, w, w, x},
            {x, c, c, w, w, w, w, w, w, w, w, w, c, w, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, w, w, c, c, c, c, c, c, c, c, c, c, c, w, w, w, w, w, w, w, w, c, x},
            {x, c, c, w, w, w, w, w, w, w, w, w, c, w, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, c, c, c, c, c, c, w, c, w, c, c, c, c, c, c, c, c, w, w, x},
            {x, c, c, w, c, w, w, w, w, w, w, w, v, w, c, w, w, w, w, w, w, w, w, c, x},
            {x, c, w, w, c, c, c, c, c, c, c, w, c, w, c, c, c, c, c, c, c, c, w, c, x},
            {x, c, c, w, c, w, c, w, w, w, c, w, c, w, c, w, w, w, w, w, w, w, w, c, x},
            {x, w, c, w, c, c, c, c, c, c, c, w, c, w, c, c, c, c, c, v, c, c, w, c, x},
            {x, c, c, w, c, c, c, v, c, c, c, c, c, w, c, c, b, c, c, c, c, c, c, c, x},
            {x, c, w, w, w, w, w, w, w, w, w, w, c, w, w, w, w, w, w, w, w, w, w, w, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, v, c, c, c, h, c, w, x},
            {x, c, c, c, c, b, c, c, c, c, c, w, w, w, c, w, w, w, w, w, w, w, w, w, x},
            {x, c, w, w, w, w, w, w, w, w, w, w, c, c, c, c, c, c, c, w, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, v, c, c, c, c, w, w, w, w, w, c, w, e, c, w, c, x},
            {x, w, w, w, w, w, w, w, w, w, w, w, c, c, c, c, w, c, c, w, w, w, w, c, x},
            {x, c, c, v, c, c, c, v, c, c, c, c, c, c, c, c, w, c, c, c, v, c, c, c, x},
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},};
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
        String x = "x";

        String[][] level2 = new String[][]{
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},
            {x, c, c, w, c, c, c, c, w, c, c, c, c, c, c, v, c, c, c, c, c, v, c, c, x},
            {x, c, c, w, c, w, w, w, w, w, w, w, w, c, w, w, c, c, v, c, c, c, c, c, x},
            {x, p, c, w, c, w, c, c, w, c, c, w, v, c, c, w, w, w, w, w, w, w, w, c, x},
            {x, c, c, w, c, w, c, c, w, c, c, w, w, c, c, w, b, c, c, c, c, c, w, c, x},
            {x, c, c, w, c, w, c, c, w, c, c, w, c, c, c, w, c, c, c, c, c, c, w, c, x},
            {x, w, c, w, c, w, c, v, w, c, c, w, v, w, w, w, c, c, c, c, c, v, w, v, x},
            {x, w, c, w, c, w, c, w, c, w, c, w, c, w, c, w, c, w, w, w, w, w, w, c, x},
            {x, w, c, w, c, w, c, w, c, w, c, w, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, c, c, w, c, w, c, w, w, w, c, w, c, w, w, w, w, w, w, w, x},
            {x, c, c, w, c, c, c, w, v, c, c, w, c, w, c, w, c, w, c, v, c, c, c, v, x},
            {x, c, c, w, c, c, c, c, w, c, c, c, c, w, c, w, h, c, c, c, c, c, c, c, x},
            {x, c, c, w, w, w, w, w, w, w, w, w, c, w, c, w, w, w, w, w, w, w, w, c, x},
            {x, c, c, w, c, c, c, c, c, c, c, c, c, w, c, w, c, c, w, c, c, c, c, c, x},
            {x, c, c, w, w, w, w, w, w, c, c, c, c, c, c, w, w, c, c, c, w, c, w, c, x},
            {x, c, c, c, c, c, w, c, c, c, w, w, w, w, w, w, w, w, w, c, w, c, w, c, x},
            {x, c, w, c, w, c, c, c, c, w, w, c, c, w, c, c, c, c, w, v, w, c, w, v, x},
            {x, w, w, w, w, w, w, w, w, v, w, c, c, w, c, w, w, w, w, c, w, c, w, c, x},
            {x, c, c, c, c, c, c, c, c, c, w, e, c, w, w, w, c, c, w, c, w, c, w, c, x},
            {x, c, c, c, c, c, c, c, c, c, w, c, c, w, c, c, c, c, c, c, w, c, w, c, x},
            {x, w, w, w, w, w, w, w, c, c, w, c, w, c, c, w, w, w, w, w, w, w, w, c, x},
            {x, c, c, c, c, c, c, c, c, c, w, c, w, c, c, w, c, c, c, c, w, c, w, c, x},
            {x, c, w, w, w, w, w, w, w, w, w, c, w, w, c, w, c, c, c, c, w, c, w, c, x},
            {x, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, v, c, c, c, w, c, x},
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},};
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
        String x = "x";


        String[][] level3 = new String[][]{
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, w, c, w, w, w, w, w, w, w, v, w, v, w, w, w, w, w, w, w, w, w, c, x},
            {x, c, w, v, c, c, c, c, c, c, w, c, w, c, c, c, c, c, c, c, w, c, w, v, x},
            {x, c, w, c, w, w, w, w, w, c, w, c, w, c, w, w, w, c, w, v, w, c, w, c, x},
            {x, c, w, c, w, c, c, c, w, v, w, v, w, c, c, c, w, c, w, c, w, c, w, c, x},
            {x, c, w, c, w, v, w, v, w, c, w, c, c, c, w, w, w, w, w, c, w, v, w, c, x},
            {x, c, w, c, w, c, w, c, w, c, w, c, w, v, w, c, w, c, w, c, w, c, w, c, x},
            {x, c, w, c, w, c, w, c, w, c, w, c, w, c, w, c, w, c, w, c, w, c, w, c, x},
            {x, v, w, c, w, c, w, c, c, c, w, v, w, c, w, c, w, w, w, v, w, c, w, v, x},
            {x, c, w, v, w, c, w, c, w, v, w, w, w, c, w, c, c, c, c, c, w, c, w, c, x},
            {x, c, w, c, w, v, w, c, w, c, w, c, w, c, w, w, w, w, w, w, w, c, w, c, x},
            {x, c, w, c, w, c, w, c, w, c, c, c, c, v, c, c, c, c, c, v, c, c, w, c, x},
            {x, c, w, c, w, c, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, c, x},
            {x, c, w, c, w, c, c, w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, w, v, c, c, c, w, c, w, w, w, w, w, w, w, w, w, w, w, w, w, w, c, x},
            {x, c, w, w, w, w, w, w, c, w, v, c, c, c, v, c, c, c, v, c, c, c, w, v, x},
            {x, c, c, c, c, w, c, c, c, w, w, w, w, w, w, w, w, w, w, w, w, c, w, c, x},
            {x, c, w, w, w, w, c, w, v, w, c, c, c, c, c, c, c, c, c, c, w, c, w, c, x},
            {x, c, w, c, c, c, c, w, c, w, c, w, w, w, w, w, w, w, w, c, w, c, w, c, x},
            {x, c, w, c, w, w, v, w, c, w, c, w, c, c, c, c, c, c, w, w, w, c, w, c, x},
            {x, c, w, c, c, w, c, w, c, c, c, w, c, c, v, c, c, c, c, c, c, c, w, c, x},
            {x, p, w, c, c, w, c, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, c, x},
            {x, c, w, e, c, c, c, c, c, w, v, c, c, v, c, c, c, v, c, c, v, c, c, c, x},
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},};
        return level3;
    }

    public static String[][] getLevel0() {

        String w = "w";
        String c = "c";
        String e = "e";
        String p = "p";
        String v = "v";
        String b = "b";
        String h = "h";
        String x = "x";

        String[][] level0 = new String[][]{
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},
            {x, c, c, w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, w, c, c, c, c, c, c, c, c, c, w, w, w, w, w, w, w, w, c, x},
            {x, c, c, w, c, w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, w, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, w, c, v, c, c, c, c, c, c, c, w, c, c, c, c, c, v, c, c, x},
            {x, c, c, c, c, w, c, c, c, w, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, w, c, c, c, w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, w, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, w, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, c, c, c, c, c, c, p, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, w, w, w, w, w, w, w, c, c, c, c, w, w, w, w, c, w, w, w, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, w, w, w, w, c, c, w, w, w, w, w, w, w, w, w, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, w, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, w, e, c, c, c, c, c, c, w, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, w, w, w, w, c, c, c, c, c, c, c, c, c, c, x},
            {x, w, w, w, w, w, w, w, c, c, c, c, c, w, w, w, w, w, w, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},};
        return level0;
    }
}
