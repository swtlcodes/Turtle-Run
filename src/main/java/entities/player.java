package main.java.entities;

import main.java.window.gameWindow;

import javax.swing.*;
import java.net.URL;

public class player{
    JFrame window;

    public URL player_normal_idle;
    public player(JFrame window) {
        this.window = window;

        URL player_normal_idle = player.class.getResource("/assets/images/player/player_normal_idle.png");
        System.out.println(player_normal_idle);

    }
}
