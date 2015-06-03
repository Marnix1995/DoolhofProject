/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Marnix
 */
public class Bazooka extends SpelObject {

    private Image img;
    private int x;
    private int y;

    public Bazooka(Doolhof game, int row, int col) {
        super(game, row, col);

    }

    @Override
    public void setPositie(int x, int y) {
    }

    @Override
    public int getY() {

        return y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public Image getImage() {
        this.img = new ImageIcon(Vak.class.getResource("\\Plaatjes\\rocket_launcher.png")).getImage();
        return img;
    }

    @Override
    public void move(int x, int y) {
    }

    @Override
    public void drawItem(Graphics g, int x, int y) {
    }

    @Override
    public void draw(Graphics g) {
    }

    @Override
    public boolean isPassable() {
        return true;
    }
}
