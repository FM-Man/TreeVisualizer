import java.io.IOException;
import java.util.ArrayList;

public class Tree2 {
    public Node root;
    private ArrayList<String> tree = new ArrayList<>();
    int currentString = 0;
    int totalString = 0;
    int genGap = 10;

    public Tree2(Node root){
        this.root = root;
    }
    public Tree2(Node root, int genGap){
        this.root = root;
        this.genGap = genGap;
    }

    public void print() {
        tree.add("");
        root.stringNo = currentString;

        tree.set(currentString,tree.get(currentString)+root.name);
        //dfs
        for (Node node:root.children) {
            traverse(node);
        }

        for (String s:tree) {
            System.out.println(s);
        }
    }

    public void traverse(Node node){
        if(node.parent.children.get(0).equals(node)){
            currentString = node.parent.stringNo;
        }
        else {
            currentString = ++totalString;
            tree.add("");
        }
        node.stringNo = currentString;

        //adding the horizontal gap
        for(int i = tree.get(currentString).length()-1; i < node.parent.generation*genGap; i++){
            tree.set(currentString, tree.get(currentString)+" ");
        }
        //adding the horizontal line
        for (int i = tree.get(currentString).length()-1; i<node.generation*genGap; i++){
            tree.set(currentString, tree.get(currentString)+"—");
        }
        //adding the vertical line
            //to start from the previous child
        int stn = node.previousSibling()==null? node.parent.stringNo : node.previousSibling().stringNo;
            //filling the middle gaps
        for(int i = stn+1; i<currentString;i++){
            char[] arr = tree.get(i).toCharArray();
            arr[node.parent.generation*genGap + 1] = '│';
            tree.set(i, String.valueOf(arr));
        }
            //if its a middle child
        if(!node.parent.children.get(0).equals(node) && !node.parent.children.get(node.parent.children.size()-1).equals(node)){
            char[] arr = tree.get(node.stringNo).toCharArray();
            arr[node.parent.generation*genGap + 1] = '├';
            tree.set(node.stringNo, String.valueOf(arr));
        }
            //if its the last but not only child
        else if(!node.parent.children.get(0).equals(node)){
            char[] arr = tree.get(node.stringNo).toCharArray();
            arr[node.parent.generation*genGap + 1] = '└';
            tree.set(node.stringNo, String.valueOf(arr));
        }

        tree.set(currentString,tree.get(currentString)+node.name);

        for (Node n:node.children) {
            traverse(n);
        }
    }
}

