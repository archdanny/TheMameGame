/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Danny
 */
public class Muur extends Item
{
     public Veld huidigeVeld;
     ImageIcon imageGet;
     Image image;
    
    public Muur()
    {
      imageGet = new  ImageIcon(getClass().getClassLoader().getResource("Images/block.png"));
      image = imageGet.getImage();
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            
            super.paintComponent(g);
               //g.setColor(Color.red);
                //g.fillRect(0, 0 , 100, 100); 
                g.drawImage(image, 0, 0, 20, 20, Color.LIGHT_GRAY, this);

        }
}
