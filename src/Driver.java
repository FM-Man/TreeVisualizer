import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Node> al = new ArrayList<>();
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        c.addChild(a);
        c.addChild(b);
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        f.addChild(d);
        f.addChild(e);
        Node g = new Node("g");
        g.addChild(c);
        g.addChild(f);

        Node h = new Node("h");
        Node i = new Node("i");
        Node j = new Node("j");
        j.addChild(h);
        j.addChild(i);
        Node k = new Node("k");
        Node l = new Node("l");
        Node m = new Node("m");
        m.addChild(k);
        m.addChild(l);
        Node n = new Node("n");
        n.addChild(j);
        n.addChild(m);

        Node o = new Node("o");
        o.addChild(g);
        o.addChild(n);

        Tree tree = new Tree(o);
        tree.traverse(tree.root);
    }
}
