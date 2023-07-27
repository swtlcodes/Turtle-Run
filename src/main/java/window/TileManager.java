package main.java.window;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class TileManager  {

    ArrayList<Tile> tilesList = new ArrayList<>();
    GameWindow gameWindow;

    URL grassTileURL1 = TileManager.class.getResource("/assets/images/window/tiles/grass/grass_tile_1.png");

    URL grassTileURL2 = TileManager.class.getResource("/assets/images/window/tiles/grass/grass_tile_2.png");

    URL grassTileURL3 = TileManager.class.getResource("/assets/images/window/tiles/grass/grass_tile_3.png");

    URL grassTileURL4 = TileManager.class.getResource("/assets/images/window/tiles/grass/grass_tile_4.png");

    URL grassPatchTileURL = TileManager.class.getResource("/assets/images/window/tiles/grasspatch_tile.png");
    URL spikeTileURL = TileManager.class.getResource("/assets/images/window/tiles/spike_tile.png");
    URL mudTileURL = TileManager.class.getResource("/assets/images/window/tiles/mud_tile.png");
    URL sandTileURL = TileManager.class.getResource("/assets/images/window/tiles/sand_tile.png");
    URL waterTileURL = TileManager.class.getResource("/assets/images/window/tiles/water_tile.png");

    Image grassTile1Image;
    Image grassTile2Image;

    Image grassTile3Image;

    Image grassTile4Image;

    Image grassPathTileImage;
    Image spikeTileImage;
    Image mudTileImage;
    Image sandTileImage;
    Image waterTileImage;

    Image[] tileImages = {grassTile1Image,grassPathTileImage,spikeTileImage,mudTileImage,sandTileImage,waterTileImage};
    public final class Tile{
        public int x;
        public int y;
        public int tileNumber;
        public Image tileType;

        public Tile(int x, int y,int tileNumber, Image tileType){
            this.x = x;
            this.y = y;
            this.tileNumber = tileNumber;
            this.tileType = tileType;
        }

    }
    public TileManager(GameWindow gameWindow) throws IOException {
        this.gameWindow= gameWindow;

        grassTile1Image = ImageIO.read(grassTileURL1);
        grassTile2Image = ImageIO.read(grassTileURL2);
        grassTile3Image = ImageIO.read(grassTileURL3);
        grassTile4Image = ImageIO.read(grassTileURL4);
        grassPathTileImage = ImageIO.read(grassPatchTileURL);
        spikeTileImage = ImageIO.read(spikeTileURL);
        mudTileImage = ImageIO.read(mudTileURL);
        sandTileImage = ImageIO.read(sandTileURL);
        waterTileImage = ImageIO.read(waterTileURL);
        System.out.println("hoi");

        int x = 0;
        int y = 0;
        int i2 = 0;
        for(int i = 0; i < 64; i++){
            for(int i1 = 0; i1 < gameWindow.height/64+1; i1++){
                Image tileImage;
                System.out.println((int) (Math.random() * tileImages.length - 1 + 1));

                tilesList.add(new Tile(x,y,i2,grassTile1Image));
                i2++;
                y +=64;
            }
            y = 0;
            x += 64;
        }

        for(int i3 = 0; i3 < tilesList.size(); i3++){
            System.out.println(i3);
        }

    }
    public void tileRepaint(Graphics g, JComponent jComponent){
        for(int i = 0; i < tilesList.size(); i ++){
            g.drawImage(tilesList.get(i).tileType,tilesList.get(i).x,tilesList.get(i).y,jComponent);
            tilesList.get(i).y += 10;
            if(tilesList.get(i).y > gameWindow.height){
                tilesList.get(i).y = -64;
            }
        }

//        for(int i = 0; i < 20; i++ ){
//            for(int i1 = 0; i1<20; i1++){
////                switch ((int) (Math.random() * 4 - 1 + 1) + 1){
////                    case 1:
////
////                    case 2:
////                        g.drawImage(grassTile1Image,x,y,jComponent);
////                    case 3:
////                        g.drawImage(grassTile2Image,x,y,jComponent);
////                    case 4:
////                        g.drawImage(grassTile3Image,x,y,jComponent);
////
////                }
//
////                if((int) (Math.random() * 4 - 1 + 1) + 1 == 1){
////                    System.out.println(1);
////                    g.drawImage(grassTile1Image,x,y,jComponent);
////                }
////                if((int) (Math.random() * 4 - 1 + 1) + 1 == 2){
////                    System.out.println(2);
////                    g.drawImage(grassTile2Image,x,y,jComponent);
////                }
////                if((int) (Math.random() * 4 - 1 + 1) + 1 == 3){
////                    System.out.println(1);
////                    g.drawImage(grassTile3Image,x,y,jComponent);
////                }
////                if((int) (Math.random() * 4 - 1 + 1) + 1 == 4){
////                    System.out.println(2);
////                    g.drawImage(grassTile4Image,x,y,jComponent);
////                }
//                                    g.drawImage(grassTile1Image,x,y,jComponent);
//
//                x += 64;
//            }
//            y +=64;
//            x = 0;

        }
    }


