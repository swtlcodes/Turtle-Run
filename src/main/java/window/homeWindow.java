package main.java.window;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import main.java.entities.player;
import main.java.main;

import java.io.IOException;
import java.net.URL;

public class homeWindow extends main{
    JFrame window;

     URL iconImageURL;
     ImageIcon iconImage;

    public homeWindow(JFrame window) throws IOException {
        try {
            URL iconImageURL = homeWindow.class.getResource("/assets/images/window/gameIcon.ico");
            System.out.println(iconImageURL);
            ImageIcon iconImage = new ImageIcon(iconImageURL);

            this.window = window;
            window = new JFrame("Turtle Run");
            window.setIconImage(iconImage.getImage());
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
            window.setSize(new Dimension(100, 100));
        } catch(Exception e){
            System.out.println(e);
        }
    }


}
