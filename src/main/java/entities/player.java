package main.java.entities;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

public class player extends JComponent implements KeyListener {
    JFrame window;
    JComponent jComponent;

    public static int x;
    public static int y;
    public static int velocity = 10;

    long startTime;
    long elapsedTime;

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

    public player(JFrame window, JComponent jComponent) throws IOException {
        this.window = window;
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
    }
    public void playerRepaint(Graphics graphics) throws IOException {






    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(startTime == 0){
            startTime = System.currentTimeMillis();
            playerImage = player_normal_walk_1;
        }
        if(System.currentTimeMillis() == startTime + 125){
            playerImage = player_normal_walk_1;
        }

        g.drawImage(playerImage,x,y,jComponent);
        repaint();


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
        window.repaint();

}

    @Override
    public void keyReleased(KeyEvent e) {
        velocity = 10;
        window.repaint();
    }
}