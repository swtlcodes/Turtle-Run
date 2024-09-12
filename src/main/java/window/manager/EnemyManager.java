package main.java.window.manager;

import main.java.entities.enemies.Enemy;
import main.java.entities.enemies.minions.Kayu;
import main.java.window.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class EnemyManager {

    GameWindow gameWindow;

    ArrayList<Enemy> enemyList = new ArrayList<>();
    public EnemyManager(GameWindow gameWindow) throws IOException {
        this.gameWindow = gameWindow;

    }


    public void enemyRepaint(Graphics graphics, JComponent jComponent) throws IOException {
        Random randomNumber = new Random();
        if (randomNumber.nextInt(500) == 1) {
            enemyList.add(new Kayu(gameWindow, randomNumber.nextInt(gameWindow.width), randomNumber.nextInt(200),1,1000 ));
            System.out.println("There are: " + enemyList.size() + " enemies.");

        }

        for (Enemy enemy : enemyList) {
            if(enemy.dead){
                enemyList.remove(enemy);
            }
            else{
                enemy.enemyRepaint(graphics, jComponent);
            }
        }
    }
}
