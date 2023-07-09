package main.java.window;
import main.java.entities.player;
import main.java.main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class gameWindow extends JComponent{
    JFrame window;

    //TODO URL iconImageURL = this.class.
    //TODO Image iconImage;

    public gameWindow(JFrame window) {

        this.window = window;

        //TODO window.setIconImage();
        window = new JFrame("Turtle Run");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(new Dimension(100, 100));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            new player(window,g,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
