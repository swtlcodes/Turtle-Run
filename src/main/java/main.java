package main.java;

// Imports code that helps make windows and read images.
import main.java.window.gameWindow;
import main.java.window.homeWindow;
import javax.swing.*;
import java.io.IOException;

public class main {

    // Variables
    public static JFrame window = new JFrame();
    public static homeWindow homeWindow;
    public static gameWindow gameWindow;
    public static JComponent mainWindow;

    // Creates a new homeWindow and erases anything previously on the screen.
    public static void setHomeWindow(homeWindow homeWindowPar){
        homeWindow = homeWindowPar;
        mainWindow = homeWindow;
    }
    // Creates a new gameWindow and erases anything previously on the screen.
    public static void setGameWindow(gameWindow gameWindowPar){
        gameWindow = gameWindowPar;
        mainWindow = gameWindow;

    }
    // This is what runs when you click the play button or run the file.
    public static void main(String[] args) throws IOException {

            // Creates the home window.
            //setHomeWindow(new homeWindow(window));
            setGameWindow(new gameWindow(window));
            while(true){
                mainWindow.repaint();
            }

    }
}
