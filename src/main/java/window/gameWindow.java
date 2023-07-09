package main.java.window;
import main.java.entities.player;
import main.java.main;

import javax.swing.*;
import java.awt.*;

public class gameWindow extends main {
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

        new player(window);

    }
}
