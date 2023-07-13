package main.java;

// Imports code that helps make windows and read images.
import main.java.window.gameWindow;
import main.java.window.homeWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class main{

    // Variables
    public static JFrame window = new JFrame();
    public static homeWindow homeWindow;
    public static gameWindow gameWindow;
    public static JComponent mainWindow;
    public static int thing;
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

//    public void thing(){
//        System.out.println("hi");
//        Timer timer = new Timer(1000000000,this);
//        timer.setInitialDelay(0);
//        timer.start();
//        System.out.println("how r u?");
//    }
    // This is what runs when you click the play button or run the file.
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("how r u");
            // Creates the home window.
            //setHomeWindow(new homeWindow(window));
            setGameWindow(new gameWindow(window));
           while(true){
                mainWindow.repaint();
            }

//        main main=  new main();
//        main.thing();

    }


}
