package main.java;

// Imports code that helps make windows and read images.
import main.java.window.GameWindow;
import main.java.window.HomeWindow;
import javax.swing.*;
import java.io.IOException;

public class main{

    // Variables
    public static JFrame window = new JFrame();
    public static HomeWindow homeWindow;
    public static GameWindow gameWindow;
    public static JComponent mainWindow;
    // Creates a new HomeWindow and erases anything previously on the screen.
    public static void setHomeWindow(HomeWindow homeWindowPar){
        homeWindow = homeWindowPar;
        mainWindow = homeWindow;
    }
    // Creates a new GameWindow and erases anything previously on the screen.
    public static void setGameWindow(GameWindow gameWindowPar){
        gameWindow = gameWindowPar;
        mainWindow = gameWindow;

    }

    // This is what runs when you click the play button or run the file.
    public static void main(String[] args) throws IOException, InterruptedException {

            // Creates the home window.
            //setHomeWindow(new HomeWindow(window));
            setGameWindow(new GameWindow(window));

            while(true){
                mainWindow.repaint();
            }



    }


}
