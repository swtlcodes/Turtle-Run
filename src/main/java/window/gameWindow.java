package main.java.window;
import main.java.entities.player.player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class gameWindow extends JComponent{
    public static JFrame window;
    public static player player = new player();
    public static Dimension windowDimension = new Dimension(1440,900);
    //TODO URL iconImageURL = this.class.
    //TODO Image iconImage;

    public gameWindow(JFrame window) {

        this.window = window;

        //TODO window.setIconImage();
        window.setSize(windowDimension);
        window.add(this);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(window.getSize());
        window.addKeyListener(player);
        window.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            player.playerRepaint(window,g,this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}