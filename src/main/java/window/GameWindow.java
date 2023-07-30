package main.java.window;

// Imported classes.
import main.java.entities.player.Player;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GameWindow extends JComponent{

    // Stores the window, TileManager, and player as a variable.
    public static JFrame window;
    public static Player player;
    public static TileManager tileManager;


    // Stores the dimensions of the window.
    public static int height;
    public static int width;

    // Unused Code
    URL weapon_selector_URL = GameWindow.class.getResource("/assets/images/window/weapon_selector.png");
    Image weapon_selector;

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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            // Sets the variables.
            height = window.getHeight();
            width = window.getWidth();

            // Repaints the player and tiles.
            tileManager.tileRepaint(g,this);
            player.playerRepaint(window,g,this);

            // Temporary Code
            URL thing = GameWindow.class.getResource("/assets/images/window/Gun Sprite0.png");
            URL thing1 = GameWindow.class.getResource("/assets/images/window/Sword0.png");
            Image thingy = ImageIO.read(thing);
            Image thingy1 = ImageIO.read(thing1);
            g.drawImage(thingy,0,0,this);
            g.drawImage(thingy1,32,0,this);

            // Draws the bullet (unused)
            for (int i = 0; i < Player.ammunition.size() ; i++) {
                if(Player.ammunition.get(i).fired){
                    Player.ammunition.get(i).y -=1;
                    g.drawImage(Player.ammunition.get(i).projectile,Player.ammunition.get(i).x,Player.ammunition.get(i).y,this);
                }
            }

        }

        // Error management.
        catch (IOException e) {}
        catch (NullPointerException e) {} catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}