package main.java.entities.enemies;

import main.java.window.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Enemy {
    public int x;
    public int y;
    public int speed;
    public String direction;
    public int health;

    public GameWindow gameWindow;
    public Image enemyImage;

    public boolean dead = false;

    //gameWindow.player.x >= x && gameWindow.player.x <= x + 64 && gameWindow.player.y >= y && gameWindow.player.y <=y + 64;


    public Enemy(GameWindow gameWindow, int x, int y, int speed, int health) {
        this.x = x;
        this.y = y;
        this.gameWindow = gameWindow;
        this.speed = speed;
    }

    public void chasePlayerX() {
        if (gameWindow.player.x > x) {
            x += speed;
            direction = "right";
        }
        if (gameWindow.player.x < x) {
            x -= speed;
            direction = "left";
        }
    }
    public void chasePlayerY(){
        if (gameWindow.player.y > y) {
            y += speed;
            direction = "down";
        }
        if (gameWindow.player.y < y) {
            y -= speed;
            direction = "up";
        }
    }

    public void enemyRepaint(Graphics g, JComponent jComponent) {
    /*
    Suggested code for a minion:

        chasePlayer();
        enemyImage = x.doAnimation();
        g.drawImage(enemyImage, x, y, jComponent);

     */
    }

    public class Animation {
        public ArrayList<Image> animationSprites = new ArrayList<>();
        public double animationTime;

        long timer;

        public Animation(ArrayList<Image> animationSprites, double animationTime) {
            this.animationTime = animationTime;
            this.animationSprites = animationSprites;
        }

        public Image doAnimation() {
            if (timer == 0) {
                timer = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - timer > animationTime * (animationSprites.size())) {
                timer = 0;
            }
            for (int i = 0; i < animationSprites.size(); i++) {
                if (System.currentTimeMillis() - timer >= animationTime * (i) && System.currentTimeMillis() - timer < animationTime * (i + 1)) {
                    return animationSprites.get(i);
                }
            }
        return enemyImage;
        }
    }

        public class Melee{
            int damage;
            long cooldown;

            long cooldownTimer;

            public Melee(int damage, long cooldown){
                this.damage = damage;
                this.cooldown = cooldown;

            }
            public void Attack(){
                if(System.currentTimeMillis()-cooldownTimer >= cooldown){
                    gameWindow.player.health -= damage;
                    cooldownTimer = System.currentTimeMillis();
                }
            }
            public void Attack(Animation animation){
                if(System.currentTimeMillis()-cooldownTimer >= cooldown){
                    gameWindow.player.health -= damage;
                    cooldownTimer = System.currentTimeMillis();
                    animation.doAnimation();
                }
            }
        }
        public class Ranged{

        }

}


