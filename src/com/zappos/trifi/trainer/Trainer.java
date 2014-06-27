package com.zappos.trifi.trainer;

import com.zappos.trifi.trainer.panel.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by maxkeene on 6/27/14.
 */
public class Trainer {
    private static final int IMG_WIDTH = 992;
    private static final int IMG_HEIGHT = 692;


    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Tri-Fi Trainer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel floorPlanPanel = new ImagePanel();
        frame.add(floorPlanPanel);
        floorPlanPanel.setPreferredSize(new Dimension(IMG_WIDTH, IMG_HEIGHT));
        floorPlanPanel.addMouseListener(mouseListener);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            Point clickPoint = e.getPoint();
            System.out.println("mouse clicked: " + clickPoint);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

}
