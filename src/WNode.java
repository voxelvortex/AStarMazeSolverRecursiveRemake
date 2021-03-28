public class WNode extends Node implements Comparable<WNode>{
    private int weight;

    public WNode(Location value, int weight){
        super(value);
        this.weight = weight;
    }
    public WNode(Location value, Node parent, int weight){
        super(value, parent);
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public void setWeight(Location start, Location end){
        int deltaEnd = Math.abs( value.getRow() - end.getRow() ) + Math.abs( value.getCol() - end.getCol() );
        int deltaStart = Math.abs( value.getRow() - start.getRow() ) + Math.abs( value.getCol() - start.getCol() );
        this.weight = deltaEnd + deltaStart;
    }

    public int compareTo(WNode other){
        return weight - other.getWeight();
    }
}
