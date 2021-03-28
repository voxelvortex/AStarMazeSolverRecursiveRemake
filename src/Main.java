import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //args = new String[] {"mazes\\maze1.png"};
        if(args.length >= 1 && args[0].equals("help"))
            args = new String[] {};
        if(args.length != 1) {
            if(args.length == 0)
                help();
            else
                System.out.println("Incorrect number of parameters!");
            System.exit(1);
        }
        if(!filetypeIsSupported(args[0])) {
            System.out.println("Invalid file path!");
            System.exit(1);
        }

        System.out.println("Importing maze...");
        //import the maze
        MazeMaker mm = new MazeMaker(args[0]);

        //make maze
        Maze maze = mm.makeMaze();
        Solver solver = new Solver(maze, mm.getStart(), mm.getEnd());

        //solve the maze and get solution into a ArrayList
        System.out.println("Solving maze...");
        //time the solution
        long startTime = System.currentTimeMillis();
        ArrayList<WNode> solution = solver.solve();
        long completionTime = System.currentTimeMillis() - startTime;
        System.out.println("The maze was solved in "+completionTime+" milliseconds!");

        if(solution == null){
            System.out.println("There aren't any possible solutions!");
            System.exit(0);
        }

        //draw the solution on the imported image
        System.out.println("Printing img...");
        mm.drawOnImg(solution);

        //write the image with the solution drawn on it to the hdd
        mm.writeImageToHDD(outputFileName(args[0]));
    }

    private static boolean filetypeIsSupported(String filepath) {
        String[] supportedFiletypes = {".jpeg",".png",".bmp",".wbmp",".gif"}; /*pulled from oracle.com, . included to
                                                                              avoid files like picturejpg, that don't
                                                                              include a filetype
                                                                              */
        for(String ft: supportedFiletypes)
            if(filepath.toLowerCase().endsWith(ft.toLowerCase()))
                return true;

        return false;
    }

    private static String outputFileName(String inputFileName) {
        File file = new File(inputFileName);
        String parent = file.getParent();
        String filename = getFileNameWithoutExt(file);
        String outputFileName;
        if(parent == null || parent.equals("null"))
            outputFileName = filename+"_solved.png";
        else
            outputFileName = parent+"\\"+filename+"_solved.png";
        System.out.println(outputFileName);
        return outputFileName;
    }

    private static String getFileNameWithoutExt(File file) {
        String name = file.getName();
        int pos = name.lastIndexOf(".");
        if (pos > 0) {
            name = name.substring(0, pos);
        }
        return name;
    }

    private static void help() {
        System.out.println("An image file must be provided for the MazeSolver to run.");
    }
}
