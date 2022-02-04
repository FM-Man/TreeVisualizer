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

    private void fillGap(int index){
        int gap = width-tree.get(index).length();
        String add ="";
        for(int i = 0; i<gap; i++)
            add+=" ";
        tree.set(index, tree.get(index)+add);
    }

    private void fillGap(int index, Node node){
        int gap = width - tree.get(index).length();
        String add ="";
        for(int i = 0; i<gap; i++)
            add+=" ";
        add+=node.name;
        tree.set(index, tree.get(index)+add);
    }

    private void totalLevel(Node start){
        if(start.getLevel() >= level)
            level++;

        for (Node child : start.children) {
            totalLevel(child);
        }
    }


    public void print(){

        totalLevel(root);
        for (int i=0; i<level;i++) {
            tree.add("");
        }

        fillGap(0,root);

        for (Node child : root.children) {
            traverse(child);
        }

        if(tree.get(0).length() > width)
            width++;
        else if(tree.get(0).length() < width){
            fillGap(0);
        }

        for (String s:tree) {
            System.out.println(s);
        }
    }

    public void traverse(Node start){
        fillGap(start.getLevel(),start);

        for (Node child : start.children) {
            traverse(child);
        }

        if(tree.get(start.getLevel()).length() > width)
            width++;
        else if(tree.get(start.getLevel()).length() < width){
            fillGap(start.getLevel());
        }
    }
}

