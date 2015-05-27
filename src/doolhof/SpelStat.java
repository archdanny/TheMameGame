/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doolhof;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author Danny
 */
public class SpelStat extends JPanel {
    
    JLabel label;
    JButton startB;
    JButton restartB;
    Level level;
        TimerTask task;
    Timer timer;
    Speler speler;
    
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
        label = new JLabel("60");
        add(label);
        label.setBounds(250, 10, 100, 30);
    }
    
    public class ResetListnenr implements ActionListener
 {
        @Override
        public void actionPerformed(ActionEvent e) 
        {

            level.starten();
            task = new Task();
            timer = new Timer();
            timer.schedule(task, 1000, 1000);
        }
 }
    
     public class ResetListener implements ActionListener
 {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            level.herstarten();
            timer.cancel();
            label.setText("60");
            requestFocus();
            
        }
 }
     public class Task extends TimerTask {

        public int countdown = 59;

        @Override
        public void run() {
            String tijd = Integer.toString(countdown);
            label.setText(tijd);
            if(countdown==0){
            timer.cancel();
            requestFocus();}
            else{
            countdown -= 1;}
            

        }
    
}}
