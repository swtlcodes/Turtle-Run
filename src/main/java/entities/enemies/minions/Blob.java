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
    URL testUrl = Blob.class.getResource("/assets/images/enemies/minions/Enemy Sprite10.png");
    URL testUrl1 = Blob.class.getResource("/assets/images/enemies/minions/Enemy Sprite11.png");
    URL testUrl2 = Blob.class.getResource("/assets/images/enemies/minions/Enemy Sprite12.png");
    URL testUrl3 = Blob.class.getResource("/assets/images/enemies/minions/Enemy Sprite13.png");
    URL testUrl4 = Blob.class.getResource("/assets/images/enemies/minions/Enemy Sprite14.png");
    URL testUrl5 = Blob.class.getResource("/assets/images/enemies/minions/Enemy Sprite15.png");
    Image blobImage;
    Image blobImage1;
    Image blobImage2;
    Image blobImage3;
    Image blobImage4;
    Image blobImage5;



    public Blob(GameWindow gameWindow, int x, int y, int speed, int health) throws IOException {
        super(gameWindow, x, y, speed, health);
        blobImage = ImageIO.read(testUrl);
        blobImage1 = ImageIO.read(testUrl1);
        blobImage2 = ImageIO.read(testUrl2);
        blobImage3 = ImageIO.read(testUrl3);
        blobImage4 = ImageIO.read(testUrl4);
        blobImage5 = ImageIO.read(testUrl5);
        ArrayList<Image> timmy = new ArrayList<>();
        timmy.add(blobImage);
        timmy.add(blobImage1);
        timmy.add(blobImage2);
        timmy.add(blobImage3);
        timmy.add(blobImage4);
        timmy.add(blobImage5);
        thing = new Animation(timmy, 1000);
    }


    @Override
    public void enemyRepaint(Graphics g, JComponent jComponent) {
        chasePlayerX();
        chasePlayerY();
        enemyImage = thing.doAnimation();
        g.drawImage(enemyImage, x, y, jComponent);

        System.out.println(direction);
    }
}
