import java.io.IOException;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Node ayenUddin = new Node("Ayen Uddin Mollah");
        Node mofazzal = new Node(ayenUddin,"Mofazzal Mollah");
        Node zakir = new Node(ayenUddin,"Zakir Mollah");
        Node jesmin = new Node(mofazzal,"Jesmin Naher");
        Node lubna = new Node(mofazzal,"Lubna Mariam");
        Node murad = new Node(mofazzal,"Murad Hossen");
        Node sajib = new Node(zakir,"Tanvir Hossen");
        Node fuad = new Node(zakir,"Fuad Hossen");
        Node fahim = new Node(jesmin,"Fahim Morshed");
        Node niaz = new Node(jesmin,"Niaz Morshed");
        Node sarah = new Node(murad,"Sarah");

        Tree tree = new Tree(ayenUddin);
        tree.print();
    }
}
