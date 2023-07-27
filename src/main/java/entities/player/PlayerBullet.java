package main.java.entities.player;

// Imported Classes.
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class PlayerBullet {

    // Bullet's coordinates.
    public static int x;
    public static int y;

    // Variables that stores if the bullet is fired.
    public static boolean fired = false;

    // Player Variable
    Player player;

    // Image path and image variable.
    URL projectileURL = PlayerBullet.class.getResource("/assets/images/player/player_projectile.png");
    public static Image projectile;

    public PlayerBullet(Player player) throws IOException {

        // Makes its x and y position the players.
        this.player = player;
        x = player.x;
        y = player.y;

        // Sets the image variable to the path.
        projectile = ImageIO.read(projectileURL);
    }
}