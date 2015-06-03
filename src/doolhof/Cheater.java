/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

//import doolhof.SpelStat;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Mehmet
 */
public class Cheater extends Item {

    private Veld huidigeVeld;
    private ImageIcon imageGet;
    private Image image;
    private int boxSize = 30;
    private SpelStat stat;
    

    public void cheat() {
        Container panelContainer = this.getParent();
        Grid grid = (Grid) panelContainer;
        stat = grid.level.getSpelstat();
        int cheat = 20;
//        stat = new SpelStat();
        stat.stappenTeller(cheat);
        stat.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.red);
        g.fillRect(0, 0, 100, 100);
        g.drawImage(image, 0, 0, boxSize, boxSize, null, this);

    }
}