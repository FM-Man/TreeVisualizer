import java.util.ArrayList;

public class Node {
    public String name;
    public ArrayList<Node> children;
    public Node parent;
    public int traversedIndex = 0;
    public int generation=0;
    public int stringNo;

    public Node(String name){
        this.name = name;
        children = new ArrayList<>();
        parent = null;
        if(Driver.highestGeneration <= generation) Driver.highestGeneration = generation;
    }

    public Node(Node parent, String name){
        this.parent = parent;
        this.parent.addChild(this);
        this.name = name;
        children = new ArrayList<>();
        generation = parent.generation+1;
        if(Driver.highestGeneration <= generation) Driver.highestGeneration = generation;
    }

    public Node(String name, ArrayList<Node> children){
        this.name = name;
        this.children = children;
        parent = null;
        for (Node n: children) {
            n.parent = this;
            n.generation = generation+1;
            if(Driver.highestGeneration <= n.generation) Driver.highestGeneration = n.generation;
        }
    }

    public Node(Node parent, String name, ArrayList<Node> children){
        this.parent = parent;
        this.parent.addChild(this);
        this.name = name;
        this.children = children;
        for (Node n: children) {
            n.parent = this;
            n.generation = generation+1;
            if(Driver.highestGeneration <= n.generation) Driver.highestGeneration = n.generation;
        }
    }
    public void addChild(Node node){
        children.add(node);
        node.parent = this;
        node.generation = generation+1;
        if(Driver.highestGeneration <= node.generation) Driver.highestGeneration = node.generation;
    }
    public Node previousSibling(){
        if(parent == null) return null;
        else if(parent.children.get(0).equals(this)) return null;
        int i =0;
        for (i = 0; i<parent.children.size(); i++){
            if(parent.children.get(i).equals(this)) break;
        }
        return parent.children.get(i-1);
    }

    public int getLevel(){
        int level = 0;
        Node x = this;
        while(x.parent != null){
            level++;
            x = x.parent;
        }
        return level;
    }
}
