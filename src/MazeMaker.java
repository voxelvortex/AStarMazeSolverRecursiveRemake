import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MazeMaker {
    private BufferedImage image;
    private Location start;
    private Location end;

    public MazeMaker(String filename){
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException ioe) {
            System.out.println(ioe);
            System.exit(1);
        }
    }

    public Maze makeMaze(){
        int[][] key = {{255,255,255},{0,0,0},{255,0,0},{0,0,255}};
        WNode[][] maze = new WNode[image.getWidth()][image.getHeight()];
        
        for(int row = 0; row < maze.length; row++) {
            for(int col = 0; col < maze[row].length; col++) {
                Color color = new Color(image.getRGB(row,col));
                int[] current = {color.getRed(), color.getGreen(), color.getBlue()};

                for(int i = 0; i < key.length; i++) {
                    boolean same = true;
                    for(int f = 0; f <3; f++)
                        if(key[i][f] != current[f]) {
                            same = false;
                            break;
                        }
                    if(same) {
                        Location currentLoc = new Location(row, col, i==1);
                        WNode currentNode = new WNode(currentLoc);
                        maze[row][col] = currentNode;

                        if(i == 2)
                            start = currentLoc;
                        if(i == 3)
                            end = currentLoc;
                    }
                }
            }
        }
        return new Maze(maze);
    }

    public Location getStart(){return start;}
    public Location getEnd(){return end;}

    public void drawOnImg(ArrayList<WNode> solution) {
        for(WNode node: solution) {

            int y = node.getValue().getCol();
            int x = node.getValue().getRow();;
            int color = (255 << 24) | (255 << 8); //24A 16R 8G 0B

            image.setRGB(x, y, color);
        }
    }

    public void writeImageToHDD(String path) {
        try {
            ImageIO.write(image, "png", new File(path));
        }catch(IOException ioe) {
            System.out.println(ioe);
        }
    }

}
