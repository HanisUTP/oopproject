package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class WelcomePage extends JPanel {

    JButton play , exit ;
    JLabel label,imagelogo;
    JFrame frame;

    static boolean go  = false ;

    WelcomePage(JFrame window) {

        setSize(window.getSize().width,window.getSize().height);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        window.setContentPane(this);

        imagelogo = new JLabel(new ImageIcon("utp logo.png"));
        imagelogo.setBounds(200,20,400,200);
        //imagelogo.setPreferredSize(new Dimension(100, 200));
        add(imagelogo);

        label = new JLabel ("<html><span style='font-weight:bold;color:blue;font-size:15px;'>WELCOME TO THE UTP LABORATORY MANAGEMENT QUIZ</span></html>");
        label.setBounds(100,200,600,50);
        add(label);


        play = new JButton ("Play");
        play.setBackground(new Color(255,255,255)) ;
        play.setBounds(300,275,200,50);
        add(play);

        exit = new JButton ("Exit");
        exit.setBackground(new Color(255,255,255)) ;
        exit.setBounds(300,350,200,50);
        add(exit);

        window.setVisible(true);

    }

    void choose (int time) {

        play.addActionListener((ActionEvent e) -> {
            go = true ;
            setVisible(false);
        });

        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        while (!go) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {}
        }

        go = false ;

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);

        WelcomePage welcomePage = new WelcomePage(frame);

        // test the WelcomePage constructor
        assert welcomePage.getSize().equals(frame.getSize());
        assert welcomePage.getBackground().equals(Color.DARK_GRAY);
        assert welcomePage.imagelogo.getIcon().toString().equals("utp logo.png");
        assert welcomePage.label.getText().equals("<html><span style='font-weight:bold;color:blue;font-size:15px;'>WELCOME TO THE UTP LABORATORY MANAGEMENT QUIZ</span></html>");
        assert welcomePage.play.getText().equals("Play");
        assert welcomePage.play.getBackground().equals(new Color(255, 255, 255));
        assert welcomePage.play.getBounds().equals(new Rectangle(300, 275, 200, 50));
        assert welcomePage.exit.getText().equals("Exit");
        assert welcomePage.exit.getBackground().equals(new Color(255, 255, 255));
        assert welcomePage.exit.getBounds().equals(new Rectangle(300, 350, 200, 50));
        assert frame.isVisible();

        // test the choose method
        Thread thread = new Thread(() -> {
            welcomePage.choose(0);
        });

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            assert welcomePage.play.isEnabled();
            assert welcomePage.exit.isEnabled();
            welcomePage.play.doClick();
            assert !welcomePage.isVisible();
            assert WelcomePage.go;
        });

        // close the frame
        SwingUtilities.invokeLater(frame::dispose);
    }

}