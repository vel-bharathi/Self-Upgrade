package LinkedList.SinglyLinkedList;

public class SinglyLinkedList<E>  implements  ISinglyLinkedList<E>{

    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("ONE");
        list.addFirst("Two");
        list.addLast("Three");
        list.removeFirst();
        System.out.println(list);
    }

    private Node head = null;
    private  Node tail = null;
    private  int size = 0;

    // nested class node element for encapsulation
    private class Node{
        private E element;
        private Node next;

        public Node(E element, Node next){
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node getNext(){
            return next;
        }

    }

    public SinglyLinkedList() { }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        if(isEmpty()){
            return null;
        }
        return head.getElement();
    }

    @Override
    public E last() {
        if(isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    @Override
    public void addFirst(E o) {
        Node newNode = new Node(o, null);
        if(isEmpty()){
            head = newNode;
            tail = head;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(E o) {
        Node newNode = new Node(o, null);
        if(isEmpty()){
            head = newNode;
            tail = head;
        }else{
            tail.next = newNode;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }

        E pop = head.getElement();
        head = head.getNext();
        size--;
        return pop;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node iter = this.head;
        while (iter != null){
            result.append(iter.getElement().toString());
            result.append("\n"); //optional
            iter = iter.getNext();
        }
        return result.toString();
    }
}
