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

            level.starten();
        }
 }
    
     public class ResetListener implements ActionListener
 {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            level.herstarten();
            
        }
 }
    
}
