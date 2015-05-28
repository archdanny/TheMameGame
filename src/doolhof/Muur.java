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
     private Veld huidigeVeld;
     private ImageIcon imageGet;
     private Image image;
     private boolean breekbaar;
     private int boxSize = 30;
    
    public Muur()
    {
      imageGet = new  ImageIcon(getClass().getClassLoader().getResource("Images/block.png"));
      image = imageGet.getImage();
      breekbaar =true;
    }
    
      public Muur(boolean d)
    {
        if(d ==true)
        {
           breekbaar = false; 
        }
      imageGet = new  ImageIcon(getClass().getClassLoader().getResource("Images/block.png"));
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
     
     public void destroy()
     {
          setVisible(false);  
     }
     
     public boolean getBreekbaar()
     {
         return breekbaar;
     }
             
}
