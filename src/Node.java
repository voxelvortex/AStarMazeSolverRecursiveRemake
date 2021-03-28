public class Node {
    protected Node parent;
    protected Location value;

    public Node(Location value){
        this.parent = null;
        this.value = value;
    }

    public Node(Location value, Node parent){
        this.parent = parent;
        this.value = value;
    }

    public Node getParent(){
        return parent;
    }

    public void setParent(Node parent){
        this.parent = parent;
    }

    public Location getValue(){
        return value;
    }

    public void setValue(Location value){
        this.value = value;
    }

}
