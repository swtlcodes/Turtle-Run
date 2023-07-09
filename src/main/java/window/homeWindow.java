package main.java.window;

import javax.swing.*;
import java.awt.*;
import main.java.main;
import java.net.URL;

public class homeWindow extends main{
    JFrame window;

    //TODO URL iconImageURL = this.class.
    //TODO Image iconImage;

    public homeWindow(JFrame window) {

        this.window = window;

        //TODO window.setIconImage();
        window = new JFrame("Turtle Run");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(new Dimension(100,100));

    }


}
