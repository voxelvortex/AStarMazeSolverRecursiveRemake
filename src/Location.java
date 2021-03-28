public class Location {
    private int row;
    private int col;
    private boolean isWall;
    
    public Location(int row, int col){this(row,col,false);}
    public Location(int row, int col, boolean isWall){
        this.row = row;
        this.col = col;
        this.isWall = isWall;
    }

    public boolean isWall(){return isWall;}
    public int getRow(){return row;}
    public int getCol(){return col;}

    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int col){
        this.col = col;
    }

    public boolean equals(Location other){
        return row == other.getRow() && col == other.getCol();
    }
}
