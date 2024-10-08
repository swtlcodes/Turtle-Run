package main.java.window;

// Imported classes.
import main.java.entities.enemies.minions.Kayu;
import main.java.entities.player.Player;
import main.java.window.components.SettingsButton;
import main.java.window.manager.EnemyManager;
import main.java.window.manager.TileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GameWindow extends JComponent{

    // Stores the window, TileManager, and player as a variable.
    public JFrame window;
    public Player player;
    public TileManager tileManager;
    public EnemyManager enemyManager;
    public Kayu blob;

    // Stores the dimensions of the window.
    public int height;
    public int width;

    public long animationTime;

    public int fps;

    public  long frameTime;

    public int frameTimeMilli = 17;

    // Unused Code
    URL weapon_selector_URL = GameWindow.class.getResource("/assets/images/window/weapon_selector.png");
    Image weapon_selector;

    SettingsButton settingsButton;

    // Creates a new player.
    {
        try {
            player = new Player();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GameWindow(JFrame window) throws IOException {

        // Edits things about the window.
        this.window = window;
        window.setTitle("Turtle Run");
        window.add(this);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(player);
        weapon_selector = ImageIO.read(weapon_selector_URL);
        window.setUndecorated(true);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        height = window.getHeight();
        width = window.getWidth();
        tileManager = new TileManager(this);

        enemyManager = new EnemyManager(this);
        settingsButton = new SettingsButton(window,this);
        window.addMouseListener(settingsButton);

    }

    public void FPSChecker(){
        while(System.currentTimeMillis() - this.frameTime < frameTimeMilli){

        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            frameTime = System.currentTimeMillis();
            if(animationTime == 0){
                animationTime = System.currentTimeMillis();
            }
            // Sets the variables.
            height = window.getHeight();
            width = window.getWidth();

            // Repaints the player and tiles.
            tileManager.tileRepaint(g,this);
            player.playerRepaint(window,g,this);
            settingsButton.SettingsButtonRepaint(g);
            enemyManager.enemyRepaint(g,this);
            // Temporary Code
            URL thing = GameWindow.class.getResource("/assets/images/window/Gun Sprite0.png");
            URL thing1 = GameWindow.class.getResource("/assets/images/window/Sword0.png");
            Image thingy = ImageIO.read(thing);
            Image thingy1 = ImageIO.read(thing1);
            g.drawImage(thingy,0,0,this);
            g.drawImage(thingy1,32,0,this);

            if(player.health <= 0){
                System.exit(0);
            }

            // Draws the bullet (unused)
            for (int i = 0; i < player.ammunition.size() ; i++) {
                if(player.ammunition.get(i).fired){
                    player.ammunition.get(i).y -=1;
                    g.drawImage(player.ammunition.get(i).projectile,player.ammunition.get(i).x,player.ammunition.get(i).y,this);
                }
            }

            FPSChecker();
            if(System.currentTimeMillis() - animationTime >= 1000){
                System.out.println(fps + " fps");
                fps = 0;
                animationTime = 0;
            }
            else{
                fps += 1;
            }

        }

        // Error management.
        catch (IOException e) {}
        catch (NullPointerException e) {} catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}