/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class SpelStat extends JPanel {
    
    JButton startB;
    JButton restartB;
    Level level;
    
    public SpelStat()
    {
        setSize(400, 50);
        setLayout(null);
        ResetListnenr  a = new ResetListnenr();
        startB = new JButton("Start");
        startB.addActionListener(a);
         restartB = new JButton("Restart");
        ResetListener restet = new ResetListener();
        restartB.addActionListener(restet);
        add(restartB);
        restartB.setBounds(110, 10, 100, 30);
        add(startB);
        startB.setBounds(10, 10, 100, 30);
    }
    
    public class ResetListnenr implements ActionListener
 {
        @Override
        public void actionPerformed(ActionEvent e) 
        {

            level.grid.requestFocus();
        }
 }
    
     public class ResetListener implements ActionListener
 {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
//            level.grid.gridVeld[level.grid.speler.huidigeVeld.y][level.grid.speler.huidigeVeld.x].speler= null;
//            level.grid.speler.x=20;
//            level.grid.speler.y=20;
//            level.grid.gridVeld[1][1].speler = level.grid.speler;
//            level.grid.speler.huidigeVeld.x=1;
//            level.grid.speler.huidigeVeld.y=1;
//     
//             level.grid.speler.setBounds(level.grid.speler.x,level.grid.speler.y, 20, 20);
////                      gridVeld[i][j].y = i;
////                        gridVeld[i][j].x = j;
////                     speler.huidigeVeld = gridVeld[i][j];
//              level.grid.requestFocus();
             level.grid.readGrid();
        }
 }
    
}
