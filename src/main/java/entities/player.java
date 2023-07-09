package main.java.entities;

import main.java.window.gameWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class player{
    JFrame window;
    Graphics graphics;
    JComponent jComponent;

    public URL player_normal_idle;
    public player(JFrame window, Graphics graphics, JComponent jComponent) throws IOException {
        this.window = window;
        this.graphics = graphics;
        this.jComponent = jComponent;

        URL player_normal_idle = player.class.getResource("/assets/images/player/player_normal_idle.png");
        Image image = ImageIO.read(player_normal_idle);


        System.out.println(player_normal_idle);
        graphics.drawImage(image,0,0,jComponent);
    }


}
