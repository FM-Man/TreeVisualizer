public class Tree {
    public Node root;
    public Tree(Node root){
        this.root = root;
    }

    public void traverse(Node start){
        start.isVisited = true;
        System.out.print(start.name+"->");
        for (Node child : start.children) {
            if(!child.isVisited) traverse(child);
        }

    }
}
//o->g->c->a->b->f->d->e->n->j->h->i->m->k->l->
