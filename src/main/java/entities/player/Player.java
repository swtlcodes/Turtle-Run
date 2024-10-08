package main.java.entities.player;


// Imported classes
import main.java.window.GameWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.util.ArrayList;


public class Player implements KeyListener {


    // Variables for the window and painting.
    JFrame window;
    Graphics graphics;
    GameWindow jComponent;


    // Timers
    public  long animationStartTime;
    public  long moveCooldown;


    // Weapon related variables.
    public  boolean canShoot = true;
    public  boolean gun = true;
    public  boolean shoot = false;
    public  boolean stab = false;
    public  boolean sword = false;
    public  ArrayList<PlayerBullet> ammunition = new ArrayList<>();


    // Variables needed for movement.
    public  int x;
    public  int y;
    public  int velocity = 10;
    public int health = 100;


    // Paths for sprites.
    public  URL player_gun_idle_1_URL = Player.class.getResource("/assets/images/player/gun/player_gun_idle_1.png");
    public  URL player_gun_idle_2_URL = Player.class.getResource("/assets/images/player/gun/player_gun_idle_2.png");
    public  URL player_gun_walk_1_URL = Player.class.getResource("/assets/images/player/gun/player_gun_walk_1.png");
    public  URL player_gun_walk_2_URL = Player.class.getResource("/assets/images/player/gun/player_gun_walk_2.png");
    public  URL player_gun_walk_3_URL = Player.class.getResource("/assets/images/player/gun/player_gun_walk_3.png");
    public  URL player_gun_walk_4_URL = Player.class.getResource("/assets/images/player/gun/player_gun_walk_4.png");


    public  URL player_shoot_idle_1_URL = Player.class.getResource("/assets/images/player/shoot/player_shoot_idle_1.png");
    public  URL player_shoot_idle_2_URL = Player.class.getResource("/assets/images/player/shoot/player_shoot_idle_2.png");
    public  URL player_shoot_walk_1_URL = Player.class.getResource("/assets/images/player/shoot/player_shoot_walk_1.png");
    public  URL player_shoot_walk_2_URL = Player.class.getResource("/assets/images/player/shoot/player_shoot_walk_2.png");
    public  URL player_shoot_walk_3_URL = Player.class.getResource("/assets/images/player/shoot/player_shoot_walk_3.png");
    public  URL player_shoot_walk_4_URL = Player.class.getResource("/assets/images/player/shoot/player_shoot_walk_4.png");


    public  URL player_stab_idle_1_URL = Player.class.getResource("/assets/images/player/stab/player_stab_idle_1.png");
    public  URL player_stab_idle_2_URL = Player.class.getResource("/assets/images/player/stab/player_stab_idle_2.png");
    public  URL player_stab_walk_1_URL = Player.class.getResource("/assets/images/player/stab/player_stab_walk_1.png");
    public  URL player_stab_walk_2_URL = Player.class.getResource("/assets/images/player/stab/player_stab_walk_2.png");
    public  URL player_stab_walk_3_URL = Player.class.getResource("/assets/images/player/stab/player_stab_walk_3.png");
    public  URL player_stab_walk_4_URL = Player.class.getResource("/assets/images/player/stab/player_stab_walk_4.png");


    public  URL player_sword_idle_1_URL = Player.class.getResource("/assets/images/player/sword/player_sword_idle_1.png");
    public  URL player_sword_idle_2_URL = Player.class.getResource("/assets/images/player/sword/player_sword_idle_2.png");
    public  URL player_sword_walk_1_URL = Player.class.getResource("/assets/images/player/sword/player_sword_walk_1.png");
    public  URL player_sword_walk_2_URL = Player.class.getResource("/assets/images/player/sword/player_sword_walk_2.png");
    public  URL player_sword_walk_3_URL = Player.class.getResource("/assets/images/player/sword/player_sword_walk_3.png");
    public  URL player_sword_walk_4_URL = Player.class.getResource("/assets/images/player/sword/player_sword_walk_4.png");


    // Sprite Images.
    public  Image player_gun_idle_1;
    public  Image player_gun_idle_2;
    public  Image player_gun_walk_1;
    public  Image player_gun_walk_2;
    public  Image player_gun_walk_3;
    public  Image player_gun_walk_4;


    public  Image player_shoot_idle_1;
    public  Image player_shoot_idle_2;
    public  Image player_shoot_walk_1;
    public  Image player_shoot_walk_2;
    public  Image player_shoot_walk_3;
    public  Image player_shoot_walk_4;


    public  Image player_stab_idle_1;
    public  Image player_stab_idle_2;
    public  Image player_stab_walk_1;
    public  Image player_stab_walk_2;
    public  Image player_stab_walk_3;
    public  Image player_stab_walk_4;


    public  Image player_sword_idle_1;
    public  Image player_sword_idle_2;
    public  Image player_sword_walk_1;
    public  Image player_sword_walk_2;
    public  Image player_sword_walk_3;
    public  Image player_sword_walk_4;
    public  Image playerImage;


    public Player() throws IOException {


// Makes Ammunition.
        for(int i = 0; i<20; i++){
            ammunition.add(new PlayerBullet(this));
        }


// Reads files and stores them in the image variables.
        player_gun_idle_1 = ImageIO.read(player_gun_idle_1_URL);
        player_gun_idle_1 = ImageIO.read(player_gun_idle_2_URL);
        player_gun_walk_1 = ImageIO.read(player_gun_walk_1_URL);
        player_gun_walk_2 = ImageIO.read(player_gun_walk_2_URL);
        player_gun_walk_3 = ImageIO.read(player_gun_walk_3_URL);
        player_gun_walk_4 = ImageIO.read(player_gun_walk_4_URL);


        player_shoot_idle_1 = ImageIO.read(player_shoot_idle_1_URL);
        player_shoot_idle_1 = ImageIO.read(player_shoot_idle_2_URL);
        player_shoot_walk_1 = ImageIO.read(player_shoot_walk_1_URL);
        player_shoot_walk_2 = ImageIO.read(player_shoot_walk_2_URL);
        player_shoot_walk_3 = ImageIO.read(player_shoot_walk_3_URL);
        player_shoot_walk_4 = ImageIO.read(player_shoot_walk_4_URL);


        player_stab_idle_1 = ImageIO.read(player_stab_idle_1_URL);
        player_stab_idle_1 = ImageIO.read(player_stab_idle_2_URL);
        player_stab_walk_1 = ImageIO.read(player_stab_walk_1_URL);
        player_stab_walk_2 = ImageIO.read(player_stab_walk_2_URL);
        player_stab_walk_3 = ImageIO.read(player_stab_walk_3_URL);
        player_stab_walk_4 = ImageIO.read(player_stab_walk_4_URL);


        player_sword_idle_1 = ImageIO.read(player_sword_idle_1_URL);
        player_sword_idle_1 = ImageIO.read(player_sword_idle_2_URL);
        player_sword_walk_1 = ImageIO.read(player_sword_walk_1_URL);
        player_sword_walk_2 = ImageIO.read(player_sword_walk_2_URL);
        player_sword_walk_3 = ImageIO.read(player_sword_walk_3_URL);
        player_sword_walk_4 = ImageIO.read(player_sword_walk_4_URL);
    }
    public void playerRepaint(JFrame window, Graphics graphics, GameWindow jComponent) throws IOException {
// Variable stuff.
        this.window = window;
        this.graphics = graphics;
        this.jComponent = jComponent;


// The Animation
        if(animationStartTime == 0 ){
            animationStartTime = System.currentTimeMillis();
            if(gun){
                playerImage = player_gun_walk_1;
            }
            if(shoot){
                playerImage = player_shoot_walk_1;
            }
            if(stab){
                playerImage = player_stab_walk_1;
            }
            if(sword){
                playerImage = player_sword_walk_1;
            }


        }
        if(System.currentTimeMillis() - animationStartTime >= 125 && System.currentTimeMillis() - animationStartTime < 250){
            if(gun){
                playerImage = player_gun_walk_2;
            }
            if(shoot){
                playerImage = player_shoot_walk_2;
            }
            if(stab){
                playerImage = player_stab_walk_2;
            }
            if(sword){
                playerImage = player_sword_walk_2;
            }
        }
        if(System.currentTimeMillis() - animationStartTime >= 250 && System.currentTimeMillis() - animationStartTime < 375){
            if(gun){
                playerImage = player_gun_walk_3;
            }
            if(shoot){
                playerImage = player_shoot_walk_3;
            }
            if(stab){
                playerImage = player_stab_walk_3;
            }
            if(sword){
                playerImage = player_sword_walk_3;
            }
        }
        if(System.currentTimeMillis() - animationStartTime >= 375 && System.currentTimeMillis() - animationStartTime < 500){
            if(gun){
                playerImage = player_gun_walk_4;
            }
            if(shoot){
                playerImage = player_shoot_walk_4;
            }
            if(sword){
                playerImage = player_sword_walk_4;
            }
            if(stab){
                playerImage = player_stab_walk_4;
            }
            animationStartTime = 0;
        }
        if(System.currentTimeMillis() - animationStartTime > 500){
            animationStartTime = 0;
        }


// Makes sure the player cannot exit the window and that its y is always the same.
        y = window.getHeight()-128;
        if(x > window.getWidth() - 80){
            x = window.getWidth() - 80;
        }


// Draws the player.
        graphics.drawImage(playerImage,x,y,jComponent);
    }


    // Shoots a bullet.
    public  void fireBullet(){
        for(int i = 0; i < ammunition.size(); i++){
            if(!ammunition.get(i).fired){
                ammunition.get(i).fired = true;
                break;
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {}


    @Override
    public void keyPressed(KeyEvent e) {


// Stops the game when the escape or e key is pressed.
        if(e.getKeyChar() == 'e' || e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }


// Moves the player left.
        if(e.getKeyChar() == 'a' ){
            x = x-velocity;
            velocity+=2;
            if(x<0){
                x = 0;
                velocity = 16;
            }
        }


// Moves the player right.
        if(e.getKeyChar() == 'd'){
            x = x+velocity;
            velocity+=2;
            velocity+=2;
            if(x>window.getWidth()-80){
                x = window.getWidth()-80;
                velocity = 16;
            }
        }

// Makes the player change its weapon to a gun.
        if(e.getKeyChar() == 'w'){
            gun = true;
            sword = false;
        }


// Makes the player change its weapon to a sword.
        if(e.getKeyChar() == 's'){
            sword = true;
            gun = false;
        }


// Shoots a bullet.
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(moveCooldown == 0 || canShoot){
                if(gun){
                    gun = false;
                    shoot = true;
                    fireBullet();
                }
                if(sword){
                    sword = false;
                    stab = true;
                }
                moveCooldown = System.currentTimeMillis();
                canShoot = false;
            }
            if(System.currentTimeMillis()-moveCooldown >= 125){
                if(shoot){
                    gun = true;
                    shoot = false;
                }
                if(stab){
                    sword = true;
                    stab = false;
                }
            }
            if(System.currentTimeMillis() - moveCooldown >= 500){
                if(gun){
                    gun = false;
                    shoot = true;
                    fireBullet();
                }
                if(sword){
                    sword = false;
                    stab = true;
                }
                moveCooldown = 0;
            }


        }
        window.repaint();
    }




    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyChar() == 'o'){
            if(jComponent.frameTimeMilli >= 0){
                jComponent.frameTimeMilli -=1;

            }
        }

        if(e.getKeyChar() == 'p'){
            jComponent.frameTimeMilli +=1;
        }


// Makes sure that the velocity is not too high.
        velocity = 10;


// Makes sure that you cannot constantly shoot your gun.
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            canShoot = true;
            if(shoot){
                shoot = false;
                gun = true;
            }
            if(stab){
                stab = false;
                sword = true;
            }
        }
        window.repaint();
    }
}

