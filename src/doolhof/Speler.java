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
public class Speler extends Item
{
    public Veld huidigeVeld;
    SpelerKey keys;
    public  int x;
    public  int y;
    Grid grid;
    
    ImageIcon imageGet;
     Image image;
    
    public Speler()
    {
        keys = new SpelerKey();
        imageGet = new  ImageIcon(getClass().getClassLoader().getResource("Images/player.png"));
        image = imageGet.getImage();
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            
            super.paintComponent(g);
             g.drawImage(image, 0, 0, 20, 20, null, this);
                

        }
     
     @Override
     public void Draw(Graphics g)
     {
         paintComponent(g);
     }
     
     public void moveUp()
     {
         int checkY = huidigeVeld.y -1;
         boolean a = grid.gridVeld[checkY][huidigeVeld.x].item instanceof Muur;
         if(!a)
         {
            grid.gridVeld[huidigeVeld.y][huidigeVeld.x].item= null;
            grid.gridVeld[checkY][huidigeVeld.x ].item = this;
            
            this.huidigeVeld.y = huidigeVeld.y -1;
            
            y = y -20;
            setBounds(x, y , 20, 20);
            repaint(); 
         }
     }
     
     public void moveDown()
     {
         int checkY = huidigeVeld.y +1;
         boolean a = grid.gridVeld[checkY][huidigeVeld.x].item instanceof Muur;
         if(!a)
         {
            grid.gridVeld[huidigeVeld.y][huidigeVeld.x].item= null;
            grid.gridVeld[checkY][huidigeVeld.x ].item = this;

            this.huidigeVeld.y = huidigeVeld.y +1;
            
          y = y +20;
          setBounds(x, y , 20, 20);
          repaint();
         }
          
     }
     public void moveLeft()
     {
          int checkX = huidigeVeld.x -1;
         boolean a = grid.gridVeld[huidigeVeld.y][checkX].item instanceof Muur;
         if(!a)
         {
            grid.gridVeld[huidigeVeld.y][huidigeVeld.x].item= null;
            grid.gridVeld[huidigeVeld.y][checkX ].item = this;
             
            this.huidigeVeld.x = huidigeVeld.x -1;
            x = x -20;
            setBounds(x,y , 20, 20);
            repaint();   
         }
     }
     public void moveRight()
     {
          int checkX = huidigeVeld.x +1;
         boolean a = grid.gridVeld[huidigeVeld.y][checkX].item instanceof Muur;
         if(!a)
         {
            grid.gridVeld[huidigeVeld.y][huidigeVeld.x].item= null;
            grid.gridVeld[huidigeVeld.y][checkX ].item = this;
            
             this.huidigeVeld.x = huidigeVeld.x +1;
         x = x +20;
        setBounds(x,y , 20, 20);
        repaint();   
         }
         
     }
}
