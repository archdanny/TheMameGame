/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Danny
 */
public class Bazooka extends Item{
    
     public Veld huidigeVeld;
     ImageIcon imageGet;
     Image image;
     private boolean breekbaar;
     int boxSize = 30;
    
    public Bazooka()
    {
      imageGet = new  ImageIcon(getClass().getClassLoader().getResource("Images/bazooka.png"));
      image = imageGet.getImage();
      breekbaar =true;
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
