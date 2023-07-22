package main.java.entities.player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class playerBullet {
    public static int x;
    public static int y;
    public static boolean fired = false;

    player player;
    URL projectileURL = playerBullet.class.getResource("/assets/images/projectiles/player_projectile.png");
    public static Image projectile;

    public playerBullet(player player) throws IOException {
        this.player = player;
        x = player.x;
        y = player.y;
        projectile = ImageIO.read(projectileURL);
    }

}