/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import doolhof.Beweeg.Direction;
import static doolhof.Beweeg.Direction.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Danny
 */
public class Speler extends Item implements Beweeg
{
    public Veld huidigeVeld;
    SpelerKey keys;
    public  int x;
    public  int y;
    
    ImageIcon imageGet;
    Image image;
    int boxSize = 30;
     int rotation;
     Direction direction;
    
    public Speler()
    {
        keys = new SpelerKey();
        imageGet = new  ImageIcon(getClass().getClassLoader().getResource("Images/player.png"));
        image = imageGet.getImage();
        direction = Down;
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            
            super.paintComponent(g);
             //g.drawImage(image, 0, 0, boxSize, boxSize, null, this);
             int translateX =0;
             int translateY =0;
             
             if(direction == Up)
             {
                 rotation = 180;
                translateX =30;
                translateY =30;
             }
               if(direction == Left)
             {
                 rotation = 90;
                translateX =30;
                translateY =0;
             }
              if(direction == Right)
             {
                 rotation = 270;
                translateX =0;
                translateY =30;
             }
              if(direction == Down)
             {
                 rotation = 0;
                translateX =0;
                translateY =0;
             }
             
            Graphics2D g2d=(Graphics2D)g; // Create a Java2D version of g.
            g2d.translate(translateX, translateY); // Translate the center of our coordinates.
            g2d.rotate(Math.toRadians(rotation));  // Rotate the image by 1 radian.
            g2d.drawImage(image, 0, 0, boxSize, boxSize, null,this);
           
        }
     
     @Override
     public void Draw(Graphics g)
     {
         paintComponent(g);
     }
     
     public void moveUp()
     {

         boolean a = huidigeVeld.Noord.item instanceof Muur;
         if(!a)
         {
             

             huidigeVeld =huidigeVeld.Noord;
            this.huidigeVeld.y = huidigeVeld.y -1;
            
            y = y -boxSize;
            setBounds(x, y , boxSize, boxSize);
            
            
         }
         direction = Up;
            repaint(); 
     }
     
     public void moveDown()
     {

          boolean a = huidigeVeld.Zuid.item instanceof Muur;
         if(!a)
         {

              
          huidigeVeld =huidigeVeld.Zuid;

            this.huidigeVeld.y = huidigeVeld.y +1;
            
          y = y + boxSize;
          setBounds(x, y , boxSize, boxSize);

         }
          direction = Down;
          repaint();
          
     }
     public void moveLeft()
     {

          boolean a = huidigeVeld.West.item instanceof Muur;
         if(!a)
         {

             huidigeVeld =huidigeVeld.West;
             
            this.huidigeVeld.x = huidigeVeld.x -1;
            x = x - boxSize;
            setBounds(x,y , boxSize, boxSize);
              
         }
         direction = Left;
            repaint(); 
     }
     public void moveRight()
     {

         boolean a = huidigeVeld.Oost.item instanceof Muur;
         if(!a)
         {

             huidigeVeld =huidigeVeld.Oost;
             this.huidigeVeld.x = huidigeVeld.x +1;
         x = x + boxSize;
        setBounds(x,y , boxSize, boxSize);
          
         }
        direction = Right;
        repaint(); 
     }
     
     public void destroy(Direction d)
     {
         if(d == Left) 
         {
            
             if(huidigeVeld.West.item instanceof Muur)
             {
                 Muur m = (Muur)huidigeVeld.Oost.item;
                 if(m.getBreekbaar() == true)
                 {
                 huidigeVeld.West.item.setBounds(0, 0, 20, 20);
                 huidigeVeld.West.item.repaint();
                 huidigeVeld.West.item = null;
                 }
             }
             
         }
         if(d == Right) 
         {
               if(huidigeVeld.Oost.item instanceof Muur)
             {
                 Muur m = (Muur)huidigeVeld.Oost.item;
                 if(m.getBreekbaar() == true)
                 {
                 huidigeVeld.Oost.item.setBounds(0, 0, 20, 20);
                 huidigeVeld.Oost.item.repaint();
                 huidigeVeld.Oost.item = null;
                 }
             }
             
         }
     }
     
     
}
