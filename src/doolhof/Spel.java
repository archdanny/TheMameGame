/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Spel extends JFrame 
{
    private final int frameHoogte = 600;
    private final int frameBreedte = 670;
    public Level level;
    
    public Spel()
    {
        
        setSize(frameHoogte, frameBreedte);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    }
    
    public void makeComponents()
    {
        level = new Level();
        add(level.getSpelstat());
        level.getSpelstat().setBounds(0, 0, 600, 50);
        add(level.getGrid());
        level.getGrid().setBounds(0, 50, 600, 600);

    }
          
    
}
