package main.java.entities;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

public class player implements KeyListener {
    JFrame window;
    Graphics graphics;
    JComponent jComponent;
    public static long animationStartTime;
    public static boolean canShootCooldown = false;
    public static boolean shoot;

    public static int x;
    public static int y;
    public static int velocity = 10;

    public static URL player_normal_idle_URL = player.class.getResource("/assets/images/player/player_normal_idle.png");
    public static URL player_normal_walk_1_URL = player.class.getResource("/assets/images/player/player_normal_walk_1.png");
    public static URL player_normal_walk_2_URL = player.class.getResource("/assets/images/player/player_normal_walk_2.png");
    public static URL player_normal_walk_3_URL = player.class.getResource("/assets/images/player/player_normal_walk_3.png");
    public static URL player_normal_walk_4_URL = player.class.getResource("/assets/images/player/player_normal_walk_4.png");

    public static URL player_shoot_idle_URL = player.class.getResource("/assets/images/player/player_shoot_idle.png");
    public static URL player_shoot_walk_1_URL = player.class.getResource("/assets/images/player/player_shoot_walk_1.png");
    public static URL player_shoot_walk_2_URL = player.class.getResource("/assets/images/player/player_shoot_walk_2.png");
    public static URL player_shoot_walk_3_URL = player.class.getResource("/assets/images/player/player_shoot_walk_3.png");
    public static URL player_shoot_walk_4_URL = player.class.getResource("/assets/images/player/player_shoot_walk_4.png");

    public static Image player_normal_idle;
    public static Image player_normal_walk_1;
    public static Image player_normal_walk_2;
    public static Image player_normal_walk_3;
    public static Image player_normal_walk_4;

    public static Image player_shoot_idle;
    public static Image player_shoot_walk_1;
    public static Image player_shoot_walk_2;
    public static Image player_shoot_walk_3;
    public static Image player_shoot_walk_4;

    public static Image playerImage;


    public void playerRepaint(JFrame window, Graphics graphics, JComponent jComponent) throws IOException {
        this.window = window;
        this.graphics = graphics;
        this.jComponent = jComponent;

        Image player_normal_idle = ImageIO.read(player_normal_idle_URL);
        Image player_normal_walk_1 = ImageIO.read(player_normal_walk_1_URL);
        Image player_normal_walk_2 = ImageIO.read(player_normal_walk_2_URL);
        Image player_normal_walk_3 = ImageIO.read(player_normal_walk_3_URL);
        Image player_normal_walk_4 = ImageIO.read(player_normal_walk_4_URL);

        Image player_shoot_idle = ImageIO.read(player_shoot_idle_URL);
        Image player_shoot_walk_1 = ImageIO.read(player_shoot_walk_1_URL);
        Image player_shoot_walk_2 = ImageIO.read(player_shoot_walk_2_URL);
        Image player_shoot_walk_3 = ImageIO.read(player_shoot_walk_3_URL);
        Image player_shoot_walk_4 = ImageIO.read(player_shoot_walk_4_URL);

        if(animationStartTime == 0){
            animationStartTime = System.currentTimeMillis();
            if(shoot){
                playerImage = player_normal_walk_1;
                shoot = false;
            } else{
                playerImage = player_shoot_walk_1;

            }

        }
        if(System.currentTimeMillis() - animationStartTime >= 125 && System.currentTimeMillis() - animationStartTime < 250){
            if(shoot){
                playerImage = player_normal_walk_2;
                shoot = false;
            } else{
                playerImage = player_shoot_walk_2;

            }
        }
        if(System.currentTimeMillis() - animationStartTime >= 250  && System.currentTimeMillis() - animationStartTime < 375){

            if(shoot){
                playerImage = player_normal_walk_3;
                shoot = false;
            } else{
                playerImage = player_shoot_walk_3;

            }
        }
        if(System.currentTimeMillis() - animationStartTime >= 375  && System.currentTimeMillis() - animationStartTime < 500){
            if(shoot){
                playerImage = player_normal_walk_4;
                shoot = false;
            } else{
                playerImage = player_shoot_walk_4;

            }
            animationStartTime = 0;
        }

        graphics.drawImage(playerImage,x,y,jComponent);
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'a'){
            x = x-velocity;
            velocity+=2;
        }
        if(e.getKeyChar() == 'd'){
            x = x+velocity;
            velocity+=2;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE && !canShootCooldown){
            shoot = true;
        }
        window.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {
        velocity = 10;
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            canShootCooldown = false;
        }
        window.repaint();
    }
}