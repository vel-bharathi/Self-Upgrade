package data_structures.node;

public class NodeMain {
    public static void main(String[] args) {
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);

        a.setNext(b);
        b.setNext(c);

//        Traverse through the elements
        Node loop = a;
        while (loop != null) { // the loop executes until the next node is null.
            System.out.println(loop.getData());
            loop = loop.getNext();// we get the next node and reference it to loop
        }
        System.out.println("End of looping");
    }
    /*
    OUTPUT:
    1
    2
    3
    End of looping

     */
}
