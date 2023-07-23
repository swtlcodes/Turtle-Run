package main.java.window;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import java.net.URL;
import java.util.HashMap;

public class TileManager extends JComponent {
    HashMap<Integer,Integer[]> tiles = new HashMap<>();
    JFrame window;

    URL grassTileURL = TileManager.class.getResource("/assets/images/window/tiles/grass_tile.png");
    URL grassPatchTileURL = TileManager.class.getResource("/assets/images/window/tiles/grasspatch_tile.png");
    URL spikeTileURL = TileManager.class.getResource("/assets/images/window/tiles/spike_tile.png");
    URL mudTileURL = TileManager.class.getResource("/assets/images/window/tiles/spike_tile.png");
    URL sandTileURL = TileManager.class.getResource("/assets/images/window/tiles/sand_tile.png");
    URL waterTileURL = TileManager.class.getResource("/assets/images/window/tiles/water_tile.png");

    Image grassTileImage;
    Image grassPathTileImage;
    Image spikeTileImage;
    Image mudTileImage;
    Image sandTileImage;
    Image waterTileImage;


    public class grassTile extends TileManager{
        public static int tileNumber;
        public grassTile(int tileNumber,JFrame window) throws IOException {

        }
    }
    public class grassPatchTile extends TileManager{
        public static int tileNumber;

        public grassPatchTile(int tileNumber,JFrame window) throws IOException {

        }
    }
    public class spikeTile extends TileManager {
        public static int tileNumber;

        public spikeTile(int tileNumber,JFrame window) throws IOException {

        }
    }
    public class mudTile extends TileManager{
        public static int tileNumber;

        public mudTile(int tileNumber,JFrame window) throws IOException {

        }
    }
    public class sandTile extends TileManager{
        public static int tileNumber;

        public sandTile(int tileNumber,JFrame window) throws IOException {

        }
    }
    public class waterTile extends TileManager{
        public static int tileNumber;

        public waterTile(int tileNumber,JFrame window) throws IOException {

        }
    }
    public TileManager(/*JFrame window*/) throws IOException {
        this.window = window;

        grassTileImage = ImageIO.read(grassTileURL);
        grassPathTileImage = ImageIO.read(grassPatchTileURL);
        spikeTileImage = ImageIO.read(spikeTileURL);
        mudTileImage = ImageIO.read(mudTileURL);
        sandTileImage = ImageIO.read(sandTileURL);
        waterTileImage = ImageIO.read(waterTileURL);

        tiles.put(1,new Integer[]{64,32});

    }
    public void tileRepaint(Graphics g, JComponent jComponent){
        int x = 0;
        int y = 0;
        for(int i = 0; i < 20; i++ ){
            for(int i1 = 0; i1<20; i1++){
                g.drawImage(grassTileImage,x,y,jComponent);
                x += 64;
            }
            y +=64;
            x = 0;

        }
    }

}
