public class WNode<G> extends Node<G> implements Comparable<WNode<G>>{
    private int weight;

    public WNode(G value, int weight){
        super(value);
        this.weight = weight;
    }
    public WNode(G value, Node parent, int weight){
        super(value, parent);
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }

    public int compareTo(WNode<G> other){
        return weight - other.getWeight();
    }
}
