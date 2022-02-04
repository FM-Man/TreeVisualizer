import java.util.ArrayList;

public class Node {
    public String name;
    public ArrayList<Node> children;
    public Node parent;
    public int traversedIndex = 0;
    public boolean isVisited = false;

    public Node(String name){
        this.name = name;
        children = new ArrayList<>();
        parent = null;
    }

    public Node(Node parent, String name){
        this.parent = parent;
        this.parent.addChild(this);
        this.name = name;
        children = new ArrayList<>();
    }

    public Node(String name, ArrayList<Node> children){
        this.name = name;
        this.children = children;
        parent = null;
        for (Node n: children) {
            n.parent = this;
        }
    }

    public Node(Node parent, String name, ArrayList<Node> children){
        this.parent = parent;
        this.parent.addChild(this);
        this.name = name;
        this.children = children;
        for (Node n: children) {
            n.parent = this;
        }
    }
    public void addChild(Node node){
        children.add(node);
        node.parent = this;
    }
    public Node nextChild(){
        if(traversedIndex>=children.size()) return null;
        else{
            traversedIndex++;
            return children.get(traversedIndex-1);
        }
    }
}
