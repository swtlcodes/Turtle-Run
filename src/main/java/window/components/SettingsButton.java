package main.java.window.components;

import main.java.entities.enemies.minions.Kayu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;

public class SettingsButton implements MouseListener {

    int x;
    int y;
    JFrame jFrame;
    JComponent jComponent;
    URL kayu_front_walk_4_URL = Kayu.class.getResource("/assets/images/window/settings_button.png");

    Image thing;
    public SettingsButton(JFrame jFrame, JComponent jComponent) throws IOException {
        x = jFrame.getWidth()-144;
        y = 0;
        this.jFrame = jFrame;
        this.jComponent = jComponent;
        thing = ImageIO.read(kayu_front_walk_4_URL);

    }

    public void SettingsButtonRepaint(Graphics graphics){
        x = jFrame.getWidth()-144;
        y = 0;
        graphics.drawImage(thing,x,y,jComponent);

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX() >= x && e.getX() <= x +128 && e.getY() >= y && e.getY() <= y +128){
            System.out.println();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
