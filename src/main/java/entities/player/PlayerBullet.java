package main.java.entities.player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class PlayerBullet {
    public static int x;
    public static int y;
    public static boolean fired = false;

    Player player;
    URL projectileURL = PlayerBullet.class.getResource("/assets/images/player/player_projectile.png");
    public static Image projectile;

    public PlayerBullet(Player player) throws IOException {
        this.player = player;
        x = player.x;
        y = player.y;
        projectile = ImageIO.read(projectileURL);
    }

}