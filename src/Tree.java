public class Tree {
    public Node root;
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

    public void traverse(Node start){
        start.isVisited = true;

        System.out.println("("+start.name+")");//insert name here

        for (Node child : start.children) {
            if(!child.isVisited) traverse(child);//need to print the horizontal line here
        }

        System.out.println(printLineage(start));//increase width here
    }
}
//o->g->c->a->b->f->d->e->n->j->h->i->m->k->l->
