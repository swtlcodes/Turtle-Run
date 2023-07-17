package main.java.entities.projectiles;

import main.java.entities.player.player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class playerProjectile extends main.java.entities.player.player {
    public static int x;
    public static int y;

    Graphics graphics;
    JComponent jComponent;
    player player;
    URL projectileURL = playerProjectile.class.getResource("/assets/images/projectiles/player_projectile.png");

    Image projectile;

    public playerProjectile(Graphics graphics, JComponent jComponent, player player, JFrame window ) throws IOException {
        this.graphics = graphics;
        this.jComponent = jComponent;
        this.player = player;

        x = player.x;
        y = player.y;
        System.out.println(player.x);
        projectile = ImageIO.read(projectileURL);
        graphics.drawImage(projectile,x,y,jComponent);
        System.out.println("here");
        window.repaint();

    }
}