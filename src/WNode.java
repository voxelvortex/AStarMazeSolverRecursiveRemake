public class WNode implements Comparable<WNode>{
    private int weight;
    private Location value;
    
    public WNode(Location value){
        this.value = value;
    }
    public WNode(Location value, int weight){
        this.value = value;
        this.weight = weight;
    }
    
    public Location getValue(){
        return value;
    }

    public void setValue(Location value){
        this.value = value;
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
