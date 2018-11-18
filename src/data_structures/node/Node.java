package data_structures.node;

/*
A Node is the basic data structure(DS) for forming most of the other basic data stuctures.
A Node simply stores the data and the refernce(s) to the next node which helps to traverse through the DS.
It is the basic element for tree, graph, linked list etc.
 */
class Node<T> {
    private Node next;
    private T data;

    Node(T data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public T getData() {
        return data;
    }
}