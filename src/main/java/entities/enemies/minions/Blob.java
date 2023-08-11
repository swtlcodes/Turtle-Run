package main.java.entities.enemies.minions;

import main.java.entities.enemies.Enemy;
import main.java.window.GameWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Blob extends Enemy {
    Animation thing;
    URL testUrl = Blob.class.getResource("/assets/images/enemies/minions/Blob.png");
    Image blobImage;

    public Blob(GameWindow gameWindow, int x, int y, int speed, int health) throws IOException {
        super(gameWindow, x, y, speed, health);
        blobImage = ImageIO.read(testUrl);
        ArrayList<Image> timmy = new ArrayList<>();
        timmy.add(gameWindow.player.player_gun_walk_1);
        timmy.add(gameWindow.player.player_shoot_walk_2);
        timmy.add(gameWindow.player.player_stab_walk_3);
        timmy.add(gameWindow.player.player_sword_walk_4);
        thing = new Animation(timmy, 100);
    }


    @Override
    public void enemyRepaint(Graphics g, JComponent jComponent) {
        chasePlayer();
        enemyImage = thing.doAnimation();
        g.drawImage(enemyImage, x, y, jComponent);

    }
}
