package main.java;

import main.java.window.gameWindow;
import main.java.window.homeWindow;

import javax.swing.*;
import java.io.IOException;

public class main {

    public static JFrame window = new JFrame();
    public static homeWindow homeWindow;
    public static gameWindow gameWindow;



    public static void setHomeWindow(homeWindow homeWindowPar){
        homeWindow = homeWindowPar;
    }
    public static void setGameWindow(gameWindow gameWindowPar){
        gameWindow = gameWindowPar;

    }
    public static void main(String[] args) throws IOException {
//            setHomeWindow(new homeWindow(window));
            setGameWindow(new gameWindow(window));
            while(true){
                gameWindow.repaint();
            }
    }
}
