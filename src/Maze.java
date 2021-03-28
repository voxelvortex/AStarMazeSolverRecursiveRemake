

public class Maze {
    public WNode[][] maze;

    public Maze(WNode[][] maze){
        this.maze = new WNode[maze.length][maze[0].length]; // We need to make a deep copy so I can implement backtracking later

        for(int r = 0; r < maze.length; r++){
            for(int c = 0; c < maze.length; c++){
                this.maze[r][c] = maze[r][c];
            }
        }
    }

    public Maze(int row, int col){
        this.maze = new WNode[row][col];
    }

    public void setNode(int row, int col, WNode loc){
        maze[row][col] = loc;
    }
    public WNode getNode(int row, int col){
        return maze[row][col];
    }
}
