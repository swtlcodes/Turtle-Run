package main.java.entities.enemies.minions;

import main.java.entities.enemies.Enemy;
import main.java.window.GameWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Kayu extends Enemy {
    Animation frontWalkAnimation;
    URL kayu_front_walk_1_URL = Kayu.class.getResource("/assets/images/enemies/minions/Kayu/Walk/front/kayu_front_walk_1.png");
    URL kayu_front_walk_2_URL = Kayu.class.getResource("/assets/images/enemies/minions/Kayu/Walk/front/kayu_front_walk_2.png");
    URL kayu_front_walk_3_URL = Kayu.class.getResource("/assets/images/enemies/minions/Kayu/Walk/front/kayu_front_walk_3.png");
    URL kayu_front_walk_4_URL = Kayu.class.getResource("/assets/images/enemies/minions/Kayu/Walk/front/kayu_front_walk_4.png");

    Image kayu_front_walk_1;
    Image kayu_front_walk_2;
    Image kayu_front_walk_3;
    Image kayu_front_walk_4;

    Melee attack;


    public Kayu(GameWindow gameWindow, int x, int y, int speed, int health) throws IOException {
        super(gameWindow, x, y, speed, health);
        this.health = health;
        kayu_front_walk_1 = ImageIO.read(kayu_front_walk_1_URL);
        kayu_front_walk_2 = ImageIO.read(kayu_front_walk_2_URL);
        kayu_front_walk_3 = ImageIO.read(kayu_front_walk_3_URL);
        kayu_front_walk_4 = ImageIO.read(kayu_front_walk_4_URL);

        ArrayList<Image> timmy = new ArrayList<>();
        timmy.add(kayu_front_walk_1);
        timmy.add(kayu_front_walk_2);
        timmy.add(kayu_front_walk_3);
        timmy.add(kayu_front_walk_4);
        frontWalkAnimation = new Animation(timmy, 200);

        attack = new Melee(10,5000);
    }


    @Override
    public void enemyRepaint(Graphics g, JComponent jComponent) {
        chasePlayerX();
        chasePlayerY();
        if(x == gameWindow.player.x && y == gameWindow.player.y){
           attack.Attack();
           if(gameWindow.player.stab){
               health -= 10;

           }
        }

        if(health <= 0){
            dead = true;
        }

        enemyImage = frontWalkAnimation.doAnimation();
        g.drawImage(enemyImage, x, y, jComponent);
    }
}
