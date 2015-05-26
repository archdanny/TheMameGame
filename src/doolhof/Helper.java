/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Danny
 */
public class Helper extends Item{
    
    int boxSize = 30;
    ImageIcon imageGet;
     Image image;
    
    public Helper()
    {
      imageGet = new  ImageIcon(getClass().getClassLoader().getResource("Images/diamond.png"));
      image = imageGet.getImage();
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            
            super.paintComponent(g);
               //g.setColor(Color.red);
                //g.fillRect(0, 0 , 100, 100); 
                g.drawImage(image, 0, 0, boxSize, boxSize, null, this);

        }
}
    

