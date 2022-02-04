import java.io.IOException;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) throws IOException {
        Node a = new Node("alfred");
        Node b = new Node(a,"brian");
        Node c = new Node(a,"charles");
        Node d = new Node(b,"alfred-2");
        Node e = new Node(b,"edward");
        Node f = new Node(b,"ferdinand");
        Node g = new Node(c,"alfred-3");
        Node h = new Node(d,"charles-2");
        Node i = new Node(d,"isaac");
        Node j = new Node(e,"james");
        Node k = new Node(e,"alfred-4");
        Node l = new Node(f,"edward-2");
        Node m = new Node(f,"brian-2");
        Node n = new Node(g,"charles-3");
        Node o = new Node(g,"isaac-2");
        Node p = new Node(l,"phillipe");
        Node q = new Node(l,"alfred-5");
        Node r = new Node(l,"robert");
        Node s = new Node(h,"stuart");
        Node t = new Node(h,"ferdinand-2");
        Node u = new Node(h,"james-2");
        Node v = new Node(i,"edward-3");
        Node w = new Node(j,"isaac-3");
        Node x = new Node(j,"brian-3");


        Tree tree = new Tree(a);
        tree.print();
    }
}
