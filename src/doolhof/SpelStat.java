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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class SpelStat extends JPanel {

    private JLabel label;
    private JLabel KLabel;
    private JButton startB;
    private JButton restartB;
    public Level level;
    private Cheater cheater;
    private Timer timer;
    private Speler speler;
    private Bazooka bazooka = new Bazooka();

    public SpelStat() {
        setSize(400, 50);
        setLayout(null);
        ResetListnenr a = new ResetListnenr();
        startB = new JButton("Start");
        startB.addActionListener(a);
        restartB = new JButton("Restart");
        ResetListener restet = new ResetListener();
        restartB.addActionListener(restet);
        add(restartB);
        restartB.setBounds(110, 10, 100, 30);
        add(startB);
        startB.setBounds(10, 10, 100, 30);
        label = new JLabel("0");
        add(label);
        label.setBounds(250, 10, 100, 30);
        KLabel = new JLabel("Bazooka : " + Integer.toString(bazooka.kogels));
        add(KLabel);
        KLabel.setBounds(350, 10, 100, 30);
    }

    public class ResetListnenr implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            startB.setEnabled(false);
            level.starten();
        }
    }

    public class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            startB.setEnabled(true);
            level.herstarten();
            requestFocus();
            label.setText( "0");
        }
    }
    
    public void stappenTeller(int stappen)
    {
        String labeltext = label.getText();
        int steps = Integer.parseInt(labeltext);
        steps = steps + stappen;
        String stapjes = Integer.toString(steps);
        label.setText( stapjes);
        repaint();
    }

    public void aantalKogels(int kogels) {
        KLabel.setText("Bazooka : " + Integer.toString(kogels));
    }
}
