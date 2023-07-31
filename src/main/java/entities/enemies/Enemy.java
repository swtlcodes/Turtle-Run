package main.java.entities.enemies;

import main.java.window.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Enemy {
    public int x;
    public int y;
    public int speed;
    public int health;

    public GameWindow gameWindow;
    ArrayList<Animation> animationList = new ArrayList<>();

    public Enemy(GameWindow gameWindow, int x, int y, int speed,int health) {
        this.x = x;
        this.y = y;
        this.gameWindow = gameWindow;
        this.speed = speed;
    }

    public void chasePlayer() {
        if (gameWindow.player.x > x) {
            System.out.println(1);
            x += speed;
        }
        if (gameWindow.player.x < x) {
            x -= speed;
        }
        if (gameWindow.player.x > x && gameWindow.player.x < x + 64) {
            x -= 0;
        }
        if (gameWindow.player.y > y) {
            y += speed;
        }
        if (gameWindow.player.y < y) {
            y-=speed;
        }
        if (gameWindow.player.y > y && gameWindow.player.y < y + 64) {
            x -= 0;
        }
    }
    public void addAnimation(Animation animation){
        animationList.add(animation);
    }

    public void enemyRepaint(Graphics g, JComponent jComponent){}

    public class Animation{
        public ArrayList<Image> animationSprites = new ArrayList<>();
        public double animationTime;

        public Animation(ArrayList<Image> animationSprites, double animationTime){
            this.animationTime = animationTime;
            this.animationSprites = animationSprites;
        }
    }
}
