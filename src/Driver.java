

public class Driver {
    public static int highestGeneration = 0;
    public static void main(String[] args) {
        Node ayenUddin = new Node("AyenUddin");
        Node mofazzal = new Node(ayenUddin,"Mofazzal");
        Node zakir = new Node(ayenUddin,"Zakir");
        Node jesmin = new Node(mofazzal,"Jesmin");
        Node lubna = new Node(mofazzal,"Lubna");
        Node murad = new Node(mofazzal,"Murad");
        Node sajib = new Node(zakir,"Tanvir");
        Node fuad = new Node(zakir,"Fuad");
        Node fahim = new Node(jesmin,"Fahim");
        Node niaz = new Node(jesmin,"Niaz");
        Node sarah = new Node(murad,"Sarah");

        Tree tree = new Tree(ayenUddin);
        tree.print();
        System.out.println();
        System.out.println();

        Tree2 tree2 = new Tree2(ayenUddin,12);
        tree2.print();
    }
}
