import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MazeConfig implements Comparable<MazeConfig>{
    ArrayList<WNode> path;
    private int weight;

    public MazeConfig(ArrayList<WNode> path){
        if(path.size() == 0)
            throw new IllegalArgumentException("The path cannot be empty");
        this.path = path;

        for(int i = 0; i < path.size(); i++){
            weight += path.get(i).getWeight();
        }
    }

    public Set<MazeConfig> getSuccessors(Maze maze, HashSet<WNode> checked){
        WNode current = path.get( path.size() -1 ); //get last item, should be the most recent thing in the 
        Set<MazeConfig> possibleMoves = new HashSet<>();

        for(int deltaRow = -1; deltaRow <= 1; deltaRow++){
            for(int deltaCol = -1; deltaCol <= 1; deltaCol++){
                if(deltaRow + deltaCol == 0)
                    continue; //skip diagonals and middle

                WNode node = maze.getNode(current.getValue().getRow() + deltaRow, current.getValue().getCol() + deltaCol);
                if(checked.contains(node))
                    continue;

                ArrayList<WNode> newPath = new ArrayList<>();
                newPath.addAll(path);

                
                newPath.add(node);
                
                possibleMoves.add( new MazeConfig(newPath) );
            }
        }
        

        return possibleMoves;
    }

    public boolean isValid(){
        for(WNode node: path){
            if(node.getValue().isWall())
                return false;
        }
        return true;
    }

    public boolean isGoal(Location end){
        return path.get( path.size() - 1 ).getValue().equals(end);
    }

    public int getWeight(){
        return weight;
    }

    public ArrayList<WNode> getPath(){
        return path;
    }

    public int compareTo(MazeConfig other){
        return weight - other.getWeight();
    }
}
