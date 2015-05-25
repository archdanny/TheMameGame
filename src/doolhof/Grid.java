/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javax.swing.JPanel;
import sun.security.util.Resources;

/**
 *
 * @author Danny
 */
public class Grid extends JPanel
{
    private final int frameHoogte = 600;
    private final int frameBreedte = 600;
    private int boxSize = frameHoogte/20;
    private int rows = 20;
    private int colum = 20;
    public Veld gridVeld [][];
    Speler speler;
    
    public Grid()
    {
        setSize(frameHoogte, frameBreedte);
        setLayout(null);
        speler = new Speler();
        add(speler);          
        speler.keys.speler = speler;
        addKeyListener(speler.keys);
        setFocusable(true);
        requestFocus();
        requestFocusInWindow(true);
        
    }
    
    
        public void makeGrid()
    {
         gridVeld = new Veld[rows][colum];
        
        for (int i = 0; i < 20; i++) 
        {
            for (int j = 0; j < 20; j++) 
            {
                Veld veld = new Veld();
                gridVeld[i][j] = veld;
            }
            
        }
        
    }
        
         public void readGrid()
        {
           String [] mapArray = new String[20];
           File file;
           FileInputStream fis;
           
            try {
               
               file = new File(getClass().getClassLoader().getResource("Levels/levelUno.txt").getFile());
               fis = new FileInputStream(file);
                
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                for (int i = 0; i < 20; i++) 
                {
                      mapArray[i] = br.readLine();
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }
 
            
            int Xposition = 0;
            int Yposition = 0;
        
        for (int i = 0; i < 20; i++) 
        {
            
            for (int j = 0; j < 20; j++) 
            {
                if(mapArray[i].substring(j, j+1).equals("w"))
                {
                    Item m = new Muur();
                    gridVeld[i][j].item = m;
                    gridVeld[i][j].y = i;
                    gridVeld[i][j].x = j;
                    
                    m.setBounds(Xposition, Yposition, boxSize, boxSize);
                    add(m);
                }
                 if(mapArray[i].substring(j, j+1).equals("g"))
                {
                    gridVeld[i][j].item = null;
                   
                
                }
                 if(mapArray[i].substring(j, j+1).equals("s"))
                 {
                     
                     gridVeld[i][j].item = speler;
                     speler.x = Xposition;
                     speler.y = Yposition;
                     speler.setBounds(speler.x, speler.y, boxSize, boxSize);
                      gridVeld[i][j].y = i;
                      gridVeld[i][j].x = j;
                     speler.huidigeVeld = gridVeld[i][j];
                     
                 }

                Xposition = Xposition+boxSize;
            }
            Yposition = Yposition +boxSize;
            Xposition = 0;
       }
       
        speler.grid = this;
    }
         
          
    
    
}
