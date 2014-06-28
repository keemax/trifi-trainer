package com.zappos.trifi.trainer;

import com.zappos.trifi.trainer.panel.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by maxkeene on 6/27/14.
 */
public class Trainer {
    private static final int IMG_WIDTH = 992;
    private static final int IMG_HEIGHT = 692;
    private static final String TRAINING_EP = "http://tri-fi.zappos.biz/train/v/";
    private static final String VERSION_TEST = "cartesian-test";

    private static JFrame frame;

    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Tri-Fi Trainer");
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
            String zoneInput = JOptionPane.showInputDialog(frame, "what zone are you in?");
            int zone = Integer.parseInt(zoneInput);
            Point clickPoint = e.getPoint();
            double y = IMG_HEIGHT - clickPoint.getY();
            double x = clickPoint.getX();
            System.out.println("x: " + x + ", y: " + y);

            try {
                Process process = new ProcessBuilder("/usr/bin/trifi",
                        "-x", String.valueOf(x),
                        "-y", String.valueOf(y),
                        "-z", String.valueOf(zone),
                        "-ep", (TRAINING_EP + VERSION_TEST)).start();
                InputStream is = process.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line;

                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
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
