package main.java.window;
import main.java.entities.player;
import main.java.main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class gameWindow extends JComponent{
    JFrame window;
    public static player player = new player();

    //TODO URL iconImageURL = this.class.
    //TODO Image iconImage;

    public gameWindow(JFrame window) {

        this.window = window;

        //TODO window.setIconImage();
        window = new JFrame("Turtle Run");
        window.add(this);
        window.setSize(new Dimension(937,4));
        //window.setUndecorated(true);
        //window.setExtendedState(JFrame.MAXIMIZED_BOTH);
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