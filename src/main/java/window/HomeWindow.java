package main.java.window;

// Code imported to make a window, draw images, and create URLs.
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import main.java.main;

public class HomeWindow extends JComponent implements KeyListener {

    // Window Variable.
    JFrame window;

    main main;
    // Whenever the class is called, this code will execute.
    public HomeWindow(JFrame window){

        try {
            // Creates a variable which stores the icon image of the game.
//            URL iconImageURL = HomeWindow.class.getResource("/assets/images/player/player_normal_idle.png");
//            System.out.println(iconImageURL);
//            Image iconImage = ImageIO.read(iconImageURL);

            // Creates the window and all of its properties (ex. title, icon image, etc.)
            this.window = window;
//            window.setIconImage(iconImage);
            this.window = new JFrame();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
            window.addKeyListener(this);

        // This is needed so that the computer can read the image.
        } catch(Exception e){}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            new GameWindow(window);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
