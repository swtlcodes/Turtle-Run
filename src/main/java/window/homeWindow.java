package main.java.window;

// Code imported to make a window, draw images, and create URLs.
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class homeWindow extends JComponent{

    // Window Variable.
    JFrame window;

    // Whenever the class is called, this code will execute.
    public homeWindow(JFrame window){
        try {
            // Creates a variable which stores the icon image of the game.
            URL iconImageURL = homeWindow.class.getResource("/assets/images/player/player_normal_idle.png");
            System.out.println(iconImageURL);
            Image iconImage = ImageIO.read(iconImageURL);

            // Creates the window and all of its properties (ex. title, icon image, etc.)
            this.window = window;
            window = new JFrame("Turtle Run");
            window.setIconImage(iconImage);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
            window.setSize(new Dimension(100, 100));
            window.add(this);

        // This is needed so that the computer can read the image.
        } catch(Exception e){}
    }
}
