package main.java.window;
import main.java.entities.player.player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class gameWindow extends JComponent{
    public static JFrame window;
    public static player player;

    URL weapon_selector_URL = gameWindow.class.getResource("/assets/images/window/weapon_selector.png");
    Image weapon_selector;

    static {
        try {
            player = new player();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Dimension windowDimension = new Dimension(1440,900);
    //TODO URL iconImageURL = this.class.
    //TODO Image iconImage;

    public gameWindow(JFrame window) throws IOException {

        this.window = window;

        //TODO window.setIconImage();
        window.setSize(windowDimension);
        window.add(this);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(window.getSize());
        window.addKeyListener(player);
        weapon_selector = ImageIO.read(weapon_selector_URL);
        window.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            player.playerRepaint(window,g,this);
//            for (int i = 0; i < player.ammunition.size() ; i++) {
//                if(player.ammunition.get(i).fired){
//                    player.ammunition.get(i).y -=1;
//                    System.out.println(player.ammunition.get(i).y);
//                    g.drawImage(player.ammunition.get(i).projectile,player.ammunition.get(i).x,player.ammunition.get(i).y,this);
//                }
//            }
            g.drawImage(weapon_selector,window.getWidth()-128,window.getHeight()/2-64,this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}