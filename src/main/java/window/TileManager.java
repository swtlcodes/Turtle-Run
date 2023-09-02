package main.java.window;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class TileManager {

    // List containing all the tiles.
    ArrayList<Tile> tilesList = new ArrayList<>();
    public int i2;
    // Window variable.
    GameWindow gameWindow;

    long startTime = System.currentTimeMillis();
    long tileTime = System.currentTimeMillis();

    // Paths for images.
    URL grassTileURL1 = TileManager.class.getResource("/assets/images/window/tiles/grass/grass_tile_1.png");

    URL grassTileURL2 = TileManager.class.getResource("/assets/images/window/tiles/grass/grass_tile_2.png");

    URL grassTileURL3 = TileManager.class.getResource("/assets/images/window/tiles/grass/grass_tile_3.png");

    URL grassTileURL4 = TileManager.class.getResource("/assets/images/window/tiles/grass/grass_tile_4.png");

    URL grassPatchTileURL = TileManager.class.getResource("/assets/images/window/tiles/grasspatch_tile.png");
    URL spikeTileURL = TileManager.class.getResource("/assets/images/window/tiles/spike_tile.png");
    URL mudTileURL = TileManager.class.getResource("/assets/images/window/tiles/mud_tile.png");
    URL sandTileURL = TileManager.class.getResource("/assets/images/window/tiles/sand_tile.png");
    URL waterTileURL = TileManager.class.getResource("/assets/images/window/tiles/water_tile.png");

    // Image variables.
    Image grassTile1Image;
    Image grassTile2Image;
    Image grassTile3Image;
    Image grassTile4Image;

    Image grassPathTileImage;
    Image spikeTileImage;
    Image mudTileImage;
    Image sandTileImage;
    Image waterTileImage;


    public final class Tile {

        // Coordinates of the tile.
        public int x;
        public int y;

        // The tile image and its number.
        public int tileNumber;
        public Image tileType;


        // Sets all the values.
        public Tile(int x, int y, int tileNumber, Image tileType) {
            this.x = x;
            this.y = y;
            this.tileNumber = tileNumber;
            this.tileType = tileType;

        }

    }

    public TileManager(GameWindow gameWindow) throws IOException {

        this.gameWindow = gameWindow;

        // Reads all the images.
        grassTile1Image = ImageIO.read(grassTileURL1);
        grassTile2Image = ImageIO.read(grassTileURL2);
        grassTile3Image = ImageIO.read(grassTileURL3);
        grassTile4Image = ImageIO.read(grassTileURL4);
        grassPathTileImage = ImageIO.read(grassPatchTileURL);
        spikeTileImage = ImageIO.read(spikeTileURL);
        mudTileImage = ImageIO.read(mudTileURL);
        sandTileImage = ImageIO.read(sandTileURL);

        // Makes all the tiles and stores them in the list.
        int x = 0;
        int y = 0;
        int i2 = 0;
        for (int i = 0; i < gameWindow.width / 64 + 1; i++) {
            for (int i1 = 0; i1 < gameWindow.height / 64 + 1; i1++) {
              Image tileImage = switch ((int) (Math.random() * 5 - 1 + 1)) {
                  case 0 -> grassTile1Image;
                  case 1 -> grassTile2Image;
                  case 2 -> grassTile3Image;
                  case 3 -> grassTile4Image;
                  case 4 -> grassPathTileImage;
                  default -> null;
              };
                tilesList.add(new Tile(x, y, i2, tileImage));
                i2++;
                y += 64;
            }
            y = 0;
            x += 64;
        }
    }

    public void tileRepaint(Graphics g, JComponent jComponent) throws Throwable {
        System.out.println(tileTime);

            // Paints all the tiles.
            for (int i = 0; i < tilesList.size(); i++) {
                if (tilesList.get(i).y == 0) {
                    i2++;
                    Image tileImage = null;
                    switch ((int) (Math.random() * 5 - 1 + 1)) {
                        case 0:
                            tileImage = grassTile1Image;
                            break;
                        case 1:
                            tileImage = grassTile2Image;
                            break;
                        case 2:
                            tileImage = grassTile3Image;
                            break;
                        case 3:
                            tileImage = grassTile4Image;
                            break;
                        case 4:
                            tileImage = grassPathTileImage;
                    }

                    tilesList.add(new Tile(tilesList.get(i).x, -64, i, tileImage));
                }
                if (tilesList.get(i).y >= gameWindow.height) {
                    tilesList.remove(i);
                }

                g.drawImage(tilesList.get(i).tileType, tilesList.get(i).x, tilesList.get(i).y, jComponent);
                tilesList.get(i).y += 16;

            }

        tileTime =  System.currentTimeMillis() - startTime;

    }
}