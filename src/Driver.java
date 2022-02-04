import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node(a,"b");
        Node c = new Node(a,"c");
        Node d = new Node(b,"d");
        Node e = new Node(b,"e");
        Node f = new Node(c,"f");
        Node g = new Node(c,"g");
        Node h = new Node(d,"h");
        Node i = new Node(d,"i");
        Node j = new Node(e,"j");
        Node k = new Node(e,"k");
        Node l = new Node(f,"l");
        Node m = new Node(f,"m");
        Node n = new Node(g,"n");
        Node o = new Node(g,"o");
        Node p = new Node(l,"p");
        Node q = new Node(l,"q");


        Tree tree = new Tree(a);
        tree.print();
    }
}
