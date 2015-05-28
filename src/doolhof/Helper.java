/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import static doolhof.Beweeg.Direction.Down;
import static doolhof.Beweeg.Direction.Left;
import static doolhof.Beweeg.Direction.Right;
import static doolhof.Beweeg.Direction.Up;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

/**
 *
 * @author Danny
 */
public class Helper extends Item{
    
    private int boxSize = 30;
    private ImageIcon imageGet;
    private Image image;
    private TimerTask task;
    private  Timer timer;
    private int translateX;
    private int translateY;
    private int rotation;
      
    public Helper()
    {
      imageGet = new  ImageIcon(getClass().getClassLoader().getResource("Images/diamond.png"));
      image = imageGet.getImage();
        task = new Task();
        timer = new Timer();
        rotation=90;
        timer.schedule(task, 0, 200);
       
    }
    
     @Override
     public void paintComponent(Graphics g) 
        {
            if(rotation == 180)
             {
                 
                translateX =30;
                translateY =30;
             }
               if(rotation == 90)
             {
              
                translateX =30;
                translateY =0;
             }
              if(rotation == 270)
             {
             
                translateX =0;
                translateY =30;
             }
              if(rotation == 0)
             {
               
                translateX =0;
                translateY =0;
             }
            
            super.paintComponent(g);
               //g.setColor(Color.red);
                //g.fillRect(0, 0 , 100, 100); 
                g.drawImage(image, 0, 0, boxSize, boxSize, null, this);
                 Graphics2D g2d=(Graphics2D)g; // Create a Java2D version of g.
            g2d.translate(translateX, translateY); // Translate the center of our coordinates.
            g2d.rotate(Math.toRadians(rotation));  // Rotate the image by 1 radian.
            g2d.drawImage(image, 0, 0, boxSize, boxSize, null,this);

        }
     
     public void Rotation()
     {
         if(rotation > 270)
         {
             rotation = 90;
             
         }
         else
         {
           rotation = rotation + 90;   
         }
         repaint();
     }
        
     
     
     public class Task extends TimerTask {


        @Override
        public void run() 
        {
           Rotation();

        }
    
     }
}
    

