import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solver {
    private Maze maze;
    private Location start;
    private Location end;

    public Solver(Maze maze, Location start, Location end){
        this.maze = maze;
        this.start = start;
        this.end = end;
    }

    public ArrayList<WNode> solve(){
        ArrayList<WNode> starterPath = new ArrayList<>();
        ArrayList<MazeConfig> configs = new ArrayList<>();
        HashSet<WNode> checked = new HashSet<>();
        
        starterPath.add( maze.getNode(start.getRow(), start.getCol()) );
        configs.add( new MazeConfig(starterPath) );

        while(!configs.isEmpty()){
            MazeConfig current = configs.remove(0);
            for(MazeConfig potentialSolution: current.getSuccessors(maze, checked)){

                if(potentialSolution.isGoal(end)){
                    return potentialSolution.getPath();
                }

                if(potentialSolution.isValid()){
                    checked.add(potentialSolution.getLastWNode());
                    configs.add(potentialSolution);
                }
            }

            Collections.sort(configs);
        }

        return null;
    }

}
