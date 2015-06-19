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
    private static Timers timerPanel = new Timers();
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

        Doolhof.checkLevel = levelNummer;

        if (levelNummer == 0) {

            timerPanel = new Timers();
            level = new Level(getLevel0(), timerPanel, 60);
            frame.setTitle("Level 0");
            frame.add(level);
            
        } else if (levelNummer == 1) {

            timerPanel = new Timers();
            level = new Level(getLevel1(), timerPanel, 210);
            frame.setTitle("Level 1");
            frame.add(level);

        } else if (levelNummer == 2) {

            timerPanel = new Timers();
            level = new Level(getLevel2(), timerPanel, 400);
            frame.setTitle("Level 2");
            frame.add(level);

        } else if (levelNummer == 3) {

            timerPanel = new Timers();
            level = new Level(getLevel3(), timerPanel, 570);
            frame.setTitle("Level 3");
            frame.add(level);

//        } else if (levelNummer == 4) {
//
//            timerPanel = new Timers();
//            level = new Level(getLevel4(), timerPanel, 45);
//            frame.setTitle("Level 4");
//            frame.add(level);

//        } else if (levelNummer == 5) {

//            timerPanel = new Timers();
//            level = new Level(getLevel5(), timerPanel, 120);
//            frame.setTitle("Level 5");
//            frame.add(level);


        } else {

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
        startPanel.setBackground(Color.white);
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
        graphicsPanel.setBackground(Color.white);
        graphicsPanel.add(fotoLabel, BorderLayout.SOUTH);
        graphicsPanel.add(list);


        JButton buttonStart = new JButton("Start");
        JButton buttonExit = new JButton("Exit");
        JButton buttonRead = new JButton("Read me");
        JButton buttonCheat = new JButton("Instellen");

        final JComboBox box = new JComboBox();
        box.addItem("Demo");
        box.addItem("Level 1");
        box.addItem("Level 2");
        box.addItem("Level 3");
        box.addItem("Verwijder highscore");

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

                int selectedIndex = box.getSelectedIndex();

                if (selectedIndex == 0) {
                    levelPanel(0);
                }

                if (selectedIndex == 1) {
                    levelPanel(1);
                }

                if (selectedIndex == 2) {
                    levelPanel(2);
                }

                if (selectedIndex == 3) {
                    levelPanel(3);
                }

                if (selectedIndex == 4) {
                    deleteHighScore();
                    box.setSelectedIndex(1);
                    return;

                } else {
                    startPanel.setVisible(false);
                }
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
                label.setText("<html><br><br>Kies hier een optie en klik op start.<br><br><br><br><br><br><br><br><br><br></html>");
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
                    + "AS score2, MAX(TIME_FORMAT(score3, '%H:%i')) AS score3 from Level;";

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
                datamodel.addElement("___________");
                datamodel.addElement("Level I:");
                datamodel.addElement(s1);
                datamodel.addElement("___________");
                datamodel.addElement("Level II:");
                datamodel.addElement(s2);
                datamodel.addElement("___________");
                datamodel.addElement("Level III:");
                datamodel.addElement(s3);
                datamodel.addElement("___________");

            }

            Doolhof.list.setModel(datamodel);
        } catch (SQLException ex) {
            Logger.getLogger(Doolhof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
    }

    public static void insert(int level) {

        try {

            String str = ("score" + level);

            Connection connection = DataBase.getConnection();
            String tijd = timerPanel.getHighScore();

            String query = "insert into Level ($column$) values(?)";
            String replaceQuery = query.replace("$column$", str);

            PreparedStatement statement = connection.prepareStatement(replaceQuery);
            statement.setString(1, tijd);
            statement.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(Doolhof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        snelsteTijd();
    }

    public static void deleteHighScore() {

        try {

            Connection connection = DataBase.getConnection();

            String query = "DELETE from Level";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            insert(0);


        } catch (SQLException ex) {
            Logger.getLogger(Doolhof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static String[][] getLevelTest() {

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
            {x, c, c, w, c, c, c, p, h, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, c, c, b, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, w, c, c, c, c, c, c, c, c, c, w, w, w, w, w, w, w, w, c, x},
            {x, c, c, w, c, w, c, c, c, b, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, w, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, w, c, v, c, c, c, c, c, c, c, w, c, c, c, c, c, v, c, c, x},
            {x, c, c, c, c, w, c, c, c, w, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, w, c, c, c, w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, w, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, w, c, w, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, c, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, w, w, w, w, w, w, w, v, c, c, c, w, w, w, w, c, w, w, w, c, x},
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
            {x, c, c, w, c, w, c, c, c, b, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, w, c, c, c, c, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, w, c, v, c, c, c, c, c, c, c, w, c, c, c, c, c, v, c, c, x},
            {x, c, c, c, c, w, c, c, c, w, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, w, c, c, c, w, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, w, c, c, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, w, c, w, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, c, c, c, c, c, e, p, c, c, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, w, w, w, w, w, w, w, v, c, c, c, w, w, w, w, c, w, w, w, c, x},
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
            {x, c, c, w, c, c, c, c, w, v, c, c, v, c, c, v, c, c, c, c, c, v, c, c, x},
            {x, c, c, w, c, w, w, w, w, w, w, w, w, c, w, w, w, w, w, w, w, w, w, c, x},
            {x, p, c, w, c, w, c, c, w, c, c, c, v, c, c, w, c, c, c, c, c, c, w, c, x},
            {x, c, c, w, c, w, c, c, w, c, c, w, w, c, c, w, b, c, c, c, c, c, w, c, x},
            {x, c, c, w, c, w, c, c, w, c, c, w, c, c, c, w, w, w, w, w, w, w, w, c, x},
            {x, w, c, w, c, w, c, v, w, c, c, w, v, w, w, w, h, c, c, c, c, v, w, v, x},
            {x, w, c, w, c, w, c, w, c, w, c, w, c, w, c, w, c, c, c, c, c, c, w, c, x},
            {x, w, c, w, c, w, c, w, c, w, c, w, c, w, c, w, c, c, c, c, c, c, c, c, x},
            {x, c, c, w, c, c, c, w, c, w, c, w, w, w, c, w, c, w, w, w, w, w, w, c, x},
            {x, c, c, w, c, c, c, w, v, c, c, w, c, w, c, w, c, w, c, v, c, c, c, v, x},
            {x, c, c, w, c, c, c, c, w, c, c, c, c, w, c, w, c, w, c, c, c, c, c, c, x},
            {x, c, c, w, w, w, w, w, w, w, w, w, c, w, c, w, c, w, w, w, w, w, w, w, x},
            {x, c, c, w, c, c, c, c, c, c, c, c, c, w, c, w, c, c, w, c, c, c, w, c, x},
            {x, c, c, w, w, w, w, w, w, c, c, c, c, w, c, w, c, c, c, c, w, c, w, c, x},
            {x, c, c, c, c, c, w, c, c, c, w, w, w, w, c, w, w, w, w, c, w, c, w, c, x},
            {x, c, w, c, w, c, c, c, c, c, w, c, c, w, c, c, c, c, c, v, c, c, c, v, x},
            {x, w, w, w, w, w, w, w, w, v, w, c, c, w, c, w, w, w, w, w, w, c, w, c, x},
            {x, c, c, c, c, c, c, c, c, c, w, e, c, w, c, w, c, c, w, c, w, c, w, c, x},
            {x, c, c, c, v, c, c, c, c, c, w, c, c, w, c, w, c, c, c, c, w, c, w, c, x},
            {x, w, w, w, w, w, w, w, c, c, w, c, c, w, c, w, w, w, w, c, w, w, w, c, x},
            {x, c, c, c, c, v, c, c, c, c, w, c, c, w, c, w, c, c, c, c, w, c, w, c, x},
            {x, c, w, w, w, w, w, w, w, w, w, c, w, w, w, w, w, w, w, c, w, c, w, c, x},
            {x, c, c, c, c, c, c, c, c, b, w, c, c, c, c, c, c, c, v, c, c, c, c, c, x},
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
            {x, c, w, w, w, w, c, w, v, w, c, c, c, c, c, c, c, c, c, h, w, c, w, c, x},
            {x, c, w, c, c, w, c, w, c, w, c, w, w, w, w, w, w, w, w, c, w, c, w, c, x},
            {x, c, w, c, w, w, v, w, c, w, c, w, c, c, c, c, c, c, w, w, w, c, w, c, x},
            {x, c, w, c, c, w, c, w, c, c, c, w, c, c, v, c, c, c, c, c, c, c, w, c, x},
            {x, p, w, c, c, w, c, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, w, c, x},
            {x, c, w, e, c, c, c, c, c, w, v, c, c, v, c, c, c, v, c, c, v, c, c, c, x},
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},};
        return level3;
    }

    public static String[][] getLevel4() {

        String w = "w";
        String c = "c";
        String e = "e";
        String p = "p";
        String v = "v";
        String b = "b";
        String h = "h";
        String x = "x";


        String[][] level4 = new String[][]{
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, w, w, w, w, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, w, p, c, c, c, c, c, c, c, c, c, c, e, x},
            {x, c, c, c, c, c, c, c, c, c, c, w, w, w, w, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},};
        return level4;
    }

    public static String[][] getLevel5() {

        String w = "w";
        String c = "c";
        String e = "e";
        String p = "p";
        String v = "v";
        String b = "b";
        String h = "h";
        String x = "x";


        String[][] level5 = new String[][]{
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, p, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, e, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, x},
            {x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x, x},};
        return level5;
    }
}
