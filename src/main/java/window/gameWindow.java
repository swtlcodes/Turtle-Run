package main.java.window;
import main.java.entities.player;
import main.java.main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class gameWindow extends JComponent{
    public static JFrame window;
    int thing;
    public static player player;

    //TODO URL iconImageURL = this.class.
    //TODO Image iconImage;

    public gameWindow(JFrame window) throws IOException {

        this.window = window;

        //TODO window.setIconImage();
        window = new JFrame("Turtle Run");
        window.add(this);
        window.setUndecorated(true);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);

        player = new player(window,this);
        window.addKeyListener(player);
        window.add(player);
        player.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        try {
//            player.playerRepaint(g);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(thing);
//        thing++;
    }
}
