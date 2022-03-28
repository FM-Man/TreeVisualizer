import java.util.ArrayList;

public class TreeVertical {
    public Node root;
    private final ArrayList<String> tree = new ArrayList<>();
    int width = 1;
    int level = 0;

    public TreeVertical(Node root){
        this.root = root;
    }

    private void fillGapLater(int index, Node node){
        int gap = width-tree.get(index).length();
        StringBuilder add = new StringBuilder();
        StringBuilder add2 = new StringBuilder();
        for(int i = 0; i<gap; i++){
            add.append(" ");

            if(node.parent!=null) if(!node.equals(node.parent.children.get(node.parent.children.size()-1)))
                add2.append("—");
            else add2.append(" ");
        }
        tree.set(index, tree.get(index)+add);
        tree.set(index-1, tree.get(index-1)+add2);
    }

    private void fillGap(int index, Node node){
        int gap = width - tree.get(index).length();
        StringBuilder add = new StringBuilder();
        StringBuilder add2 = new StringBuilder();
        for(int i = 0; i<gap; i++){
            add.append(" ");
            if(node.parent!=null) if(!node.equals(node.parent.children.get(0)))
                add2.append("—");
            else add2.append(" ");
        }
        int wordLength = node.name.length()+4;
        for(int i = 0; i<(wordLength-1)/2+1;i++){
            if(node.parent != null) if(!node.equals(node.parent.children.get(0))){
                add2.append("—");
            }
            else add2.append(" ");
        }
        if (node.parent!=null){
            if(node.parent.children.get(0).equals(node) && node.parent.children.size()!=1)
                add2.append('├');
            else if(node.parent.children.size() == 1)
                add2.append('│');
            else if(node.parent.children.get(node.parent.children.size()-1).equals(node))
                add2.append('┐');
            else
                add2.append('┬');
        }
        for(int i = (wordLength-1)/2+2; i<wordLength;i++){
            if(node.parent != null) if(!node.equals(node.parent.children.get(node.parent.children.size()-1))){
                add2.append("—");
            }
            else add2.append(" ");
        }


        add.append(" [").append(node.name).append("] ");
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

    public void print() {

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

        tree.remove(0);
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

