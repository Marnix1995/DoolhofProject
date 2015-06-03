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
public class Pacman extends SpelObject {

    private Image img;
    private int x;
    private int y;    
    private Image imgRed;
   // private SpelObject object;
    private int vakSize = 32;
    //int rij = object.getRow();
    //int kolom = object.getKolom();

    public Pacman(Doolhof game, int row, int col) {
        super(game, row, col);
    }

    public Pacman() {
        super(1);
    }

    @Override
    public void setPositie(int x, int y) {

        this.x = x;
        this.y = y;
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
    public void move(int x, int y) {
          game.p.rij = rij + x;
          game.p.kolom = kolom + y;
      
    }

    @Override
    public Image getImage() {

        this.img = new ImageIcon(Pacman.class.getResource("\\Plaatjes\\player.png")).getImage();
        return img;
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, x * vakSize, y * vakSize, vakSize, vakSize, null);
    }

    @Override
    public void drawItem(Graphics g, int x, int y) {

        g.drawImage(img, x + vakSize, y + vakSize, vakSize, vakSize, null);
    }

    public Image getRedImage() {

        this.imgRed = new ImageIcon(Vak.class.getResource("\\Plaatjes\\playerRood.png")).getImage();
        return imgRed;
    }

    @Override
    public boolean isPassable() {
        return true;
    }
}
