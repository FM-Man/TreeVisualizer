import java.io.IOException;
import java.util.ArrayList;

public class Tree {
    public Node root;
    private ArrayList<String> tree = new ArrayList<>();
    int width = 1;
    int level = 0;

    public Tree(Node root){
        this.root = root;
    }

    private String printLineage(Node start){
        String s ="";
        s+=start.name;
        Node i = start;
        while(i.parent != null){
            s+="->"+i.parent.name;
            i = i.parent;
        }
        return s;
    }

    private void fillGapLater(int index, Node node){
        int gap = width-tree.get(index).length();
        String add ="";
        String add2 = "";
        for(int i = 0; i<gap; i++){
            add+=" ";

            if(node.parent!=null) if(!node.equals(node.parent.children.get(node.parent.children.size()-1)))
                add2+="—";
            else add2+=" ";
        }
        tree.set(index, tree.get(index)+add);
        tree.set(index-1, tree.get(index-1)+add2);
    }

    private void fillGap(int index, Node node){
        int gap = width - tree.get(index).length();
        String add ="";
        String add2 = "";
        for(int i = 0; i<gap; i++){
            add+=" ";
            if(node.parent!=null) if(!node.equals(node.parent.children.get(0)))
                add2+="—";
            else add2+=" ";
        }
        int wordlength = node.name.length()+4;
        for(int i = 0; i<(wordlength-1)/2+1;i++){

            if(node.parent != null) if(!node.equals(node.parent.children.get(0))){
                add2+="—";
            }
            else add2+=" ";
        }
        add2+="|";
        for(int i = (wordlength-1)/2+2; i<wordlength;i++){
            if(node.parent != null) if(!node.equals(node.parent.children.get(node.parent.children.size()-1))){
                add2+="—";
            }
            else add2+=" ";
        }


        add+=" ["+node.name+"] ";
        tree.set(index, tree.get(index)+add);
        tree.set(index-1, tree.get(index-1)+add2);
    }

    private void totalLevel(Node start){
        if(start.getLevel() >= level)
            level++;

        for (Node child : start.children) {
            totalLevel(child);
        }
    }


    public void print() throws IOException {

        totalLevel(root);
        for (int i=0; i<level;i++) {
            tree.add("");
            tree.add("");
        }

        fillGap(1,root);

        for (Node child : root.children) {
            traverse(child);
        }

        if(tree.get(1).length() > width){
            width=tree.get(1).length();
        }
        else if(tree.get(1).length() < width){
            fillGapLater(1, root);
        }


        tree.set(0,"");
        for (String s:tree) {
            System.out.println(s);
        }
    }

    public void traverse(Node start){
        fillGap(2*start.getLevel()+1,start);

        for (Node child : start.children) {
            traverse(child);
        }

        if(tree.get( 2*start.getLevel()+1 ).length() > width)
            width = tree.get( 2*start.getLevel()+1 ).length();
        else if(tree.get( 2*start.getLevel()+1 ).length() < width){
            fillGapLater( 2*start.getLevel()+1 , start );
        }
    }
}

