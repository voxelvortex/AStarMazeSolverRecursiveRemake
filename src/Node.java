public class Node<G> {
    private Node parent;
    private G value;

    public Node(G value){
        this.parent = null;
        this.value = value;
    }

    public Node(G value, Node parent){
        this.parent = parent;
        this.value = value;
    }

    public Node<G> getParent(){
        return parent;
    }

    public void setParent(Node<G> parent){
        this.parent = parent;
    }

    public G getValue(){
        return value;
    }

    public void setValue(G value){
        this.value = value;
    }

}
