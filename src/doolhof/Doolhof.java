/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Marnix
 */
public class Doolhof extends JFrame {

    private static JPanel panel;
    private static int breedte = 820;
    private static int hoogte = 910;
    private static int tijd = 59;
    
    public static void Doolhof() {
       
        JFrame frame = new JFrame("Doolhof");
       
        JComponent component = new Vak();
        frame.add(component);
               
        panel = new Level();
        panel.setLayout(new BorderLayout());
        panel.add(new Timers(tijd));               
        frame.add(panel, BorderLayout.SOUTH);

        frame.setResizable(false);
        frame.setSize(breedte, hoogte);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        Doolhof();


    }
}
