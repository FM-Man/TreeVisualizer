

public class Driver {
    public static int highestGeneration = 0;
    public static void main(String[] args) {
        Node ayenUddin = new Node("AyenUddin");
        Node mofazzal = new Node(ayenUddin,"Mofazzal");
        Node zakir = new Node(ayenUddin,"Zakir");
        Node jesmin = new Node(mofazzal,"Jesmin");
        new Node(mofazzal, "Lubna");
        Node murad = new Node(mofazzal,"Murad");
        new Node(zakir, "Tanvir");
        new Node(zakir, "Fuad");
        new Node(jesmin, "Fahim");
        new Node(jesmin, "Niaz");
        new Node(murad, "Sarah");

        TreeVertical tree = new TreeVertical(ayenUddin);
        tree.print();

        System.out.println();
        System.out.println();

        TreeHorizontal tree2 = new TreeHorizontal(ayenUddin,12);
        tree2.print();
    }
}
