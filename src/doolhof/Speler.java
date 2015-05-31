/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;



import static doolhof.Direction.Down;
import static doolhof.Direction.Left;
import static doolhof.Direction.Right;
import static doolhof.Direction.Up;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Speler extends Item implements Beweeg
{
    private Image image;
    private Bazooka bazooka;
    public Veld huidigeVeld;
    public SpelerKey keys;
    public  int x;
    public  int y;
    private int boxSize = 30;
    public Direction direction;
    private int rotation;
    

    public Speler()
    {
        keys = new SpelerKey();
        image = new  ImageIcon(getClass().getClassLoader().getResource("Images/player.png")).getImage();
        direction = Down;
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            
            super.paintComponent(g);
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
             
            Graphics2D g2d=(Graphics2D)g; 
            g2d.translate(translateX, translateY); 
            g2d.rotate(Math.toRadians(rotation)); 
            g2d.drawImage(image, 0, 0, boxSize, boxSize, null,this);
           
        }
     
     @Override
     public void Draw(Graphics g)
     {
         paintComponent(g);
     }
     
    @Override
     public void move(Direction d)
     {
         if(d == Up)
         {
         if(huidigeVeld.Noord.item instanceof Muur == false)
            {
            checkBazooka(huidigeVeld.Noord.item);
            checkVriend(huidigeVeld.Noord.item);
            checkHelper(huidigeVeld.Noord);
            huidigeVeld =huidigeVeld.Noord;
            this.huidigeVeld.y = huidigeVeld.y -1;
            y = y -boxSize;
            setBounds(x, y , boxSize, boxSize);
            }
            direction = Up;
            repaint(); 
        }
              if(d == Down)
         {
          
         if(huidigeVeld.Zuid.item instanceof Muur == false)
            {
            checkBazooka(huidigeVeld.Zuid.item);
            checkVriend(huidigeVeld.Zuid.item);
            checkHelper(huidigeVeld.Zuid);
            huidigeVeld =huidigeVeld.Zuid;
            this.huidigeVeld.y = huidigeVeld.y +1;
            y = y + boxSize;
            setBounds(x, y , boxSize, boxSize);
            }
          direction = Down;
          repaint();
        }
                 if(d == Left)
         {
         if(huidigeVeld.West.item instanceof Muur == false)
            {
            checkBazooka(huidigeVeld.West.item);
            checkVriend(huidigeVeld.West.item);
            checkHelper(huidigeVeld.West);
            huidigeVeld =huidigeVeld.West;
            this.huidigeVeld.x = huidigeVeld.x -1;
            x = x - boxSize;
            setBounds(x,y , boxSize, boxSize); 
            }
            direction = Left;
            repaint(); 
        }
                   if(d == Right)
         {
         if(huidigeVeld.Oost.item instanceof Muur == false)
            {
            checkBazooka(huidigeVeld.Oost.item);
            checkVriend(huidigeVeld.Oost.item);
            checkHelper(huidigeVeld.Oost);
            huidigeVeld =huidigeVeld.Oost;
            this.huidigeVeld.x = huidigeVeld.x +1;
            x = x + boxSize;
            setBounds(x,y , boxSize, boxSize);
            }
            direction = Right;
            repaint(); 
        }   
     }
     
     public void checkVriend(Item item)
     {
         if(item instanceof Vriend)
         {
           Container panelContainer = this.getParent();
            JPanel panel = (JPanel)panelContainer;
            panel.setVisible(false);
         }
     }
     
       public void checkHelper(Veld veld)
     {
         if(veld.item instanceof Helper)
         {
            Container panelContainer = this.getParent();
            JPanel panel = (JPanel)panelContainer;
             Helper help = (Helper) veld.item;
             help.GetLocation(veld, panel);
             help.setVisible(false);
         }
     }
     
     public void checkBazooka(Item item)
     {
         if(item instanceof Bazooka)
         {
            bazooka = (Bazooka) item;
            bazooka.huidigeVeld = huidigeVeld;
            image = new  ImageIcon(getClass().getClassLoader().getResource("Images/playerBazooka.png")).getImage();
            repaint();
            item.setVisible(false);
         }
         if(bazooka == null)
         {
             image = new  ImageIcon(getClass().getClassLoader().getResource("Images/player.png")).getImage();

         }
     }
     
     public void resetSpeler()
     {
        bazooka = null;
        image = new  ImageIcon(getClass().getClassLoader().getResource("Images/player.png")).getImage();  
     }
     
     public void destroy()
     {
         Container panelContainer = this.getParent();
         JPanel panel = (JPanel)panelContainer;
         if(bazooka != null)
         {
            bazooka.afschieten(direction, huidigeVeld,x,y,panel);

         }
     }
     
     
}
