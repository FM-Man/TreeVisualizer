import java.util.ArrayList;

public class Tree {
    public Node root;
    public ArrayList<String> tree = new ArrayList<>();
    int width = 1;
    int level = 0;

    public Tree(Node root){
        this.root = root;
        tree.add("");
        tree.add("");
        tree.add("");
        tree.add("");
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

    public void traverse(Node start){
        start.isVisited = true;

        //System.out.println("("+start.name+")");//insert name here
        tree.set(start.getLevel(), tree.get(start.getLevel())+start.name);

        for (Node child : start.children) {
            if(!child.isVisited) traverse(child);//need to print the horizontal line here
        }

        //System.out.println(printLineage(start));//increase width here
        if(tree.get(start.getLevel()).length() > width)
            width++;
        else if(tree.get(start.getLevel()).length() < width){
            int gap = width-tree.get(start.getLevel()).length();
            String add ="";
            for(int i = 0; i<gap; i++)
                add+=" ";
            tree.set(start.getLevel(), tree.get(start.getLevel())+add);
        }
    }
}

