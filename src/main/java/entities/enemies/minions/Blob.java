package main.java.entities.enemies.minions;

import main.java.entities.enemies.Enemy;
import main.java.window.GameWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class Blob extends Enemy {
    URL testUrl = Blob.class.getResource("/assets/images/enemies/minions/Blob.png");
    Image blobImage;

    public Blob(GameWindow gameWindow, int x, int y, int speed, int health) throws IOException {
        super(gameWindow, x, y, speed, health);
        blobImage = ImageIO.read(testUrl);
    }


   @Override
    public void enemyRepaint(Graphics g, JComponent jComponent) {
        super.enemyRepaint(g, jComponent);

        chasePlayer();
        g.drawImage(blobImage,x,y,jComponent);

    }
}
