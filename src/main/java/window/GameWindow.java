package main.java.window;
import main.java.entities.player.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GameWindow extends JComponent{
    public static JFrame window;
    public static Player player;

    public static int height;
    public static int width;

    public static TileManager tileManager;
    URL weapon_selector_URL = GameWindow.class.getResource("/assets/images/window/weapon_selector.png");
    Image weapon_selector;

    {
        try {
            player = new Player();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //TODO URL iconImageURL = this.class.
    //TODO Image iconImage;

    public GameWindow(JFrame window) throws IOException {

        this.window = window;
        //TODO window.setIconImage();
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
            height = window.getHeight();
            width = window.getWidth();
            tileManager.tileRepaint(g,this);
            player.playerRepaint(window,g,this);
            URL thing = GameWindow.class.getResource("/assets/images/window/Gun Sprite0.png");
            URL thing1 = GameWindow.class.getResource("/assets/images/window/Sword0.png");
            Image thingy = ImageIO.read(thing);
            Image thingy1 = ImageIO.read(thing1);
            g.drawImage(thingy,0,0,this);
            g.drawImage(thingy1,32,0,this);
            for (int i = 0; i < Player.ammunition.size() ; i++) {
                if(Player.ammunition.get(i).fired){
                    Player.ammunition.get(i).y -=1;
                    g.drawImage(Player.ammunition.get(i).projectile,Player.ammunition.get(i).x,Player.ammunition.get(i).y,this);
                }
            }
//            g.drawImage(weapon_selector,window.getWidth()-128,window.getHeight()/2-64,this);

        } catch (IOException e) {

        }catch (NullPointerException e) {
        }
    }
}