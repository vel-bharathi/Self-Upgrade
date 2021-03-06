package LinkedList.CircularlyLinkedList;

import LinkedList.SinglyLinkedList.SinglyLinkedList;

public class CircularlyLinkedList<E> implements ICircularlyLinkedList<E>{

    private Node tail = null;
    private int size = 0;

    private class Node{
        private E element;
        private Node next;
        public Node(E element, Node node){
            this.element = element;
            this.next = node;
        }
        private E getElement() { return this.element; }
        public Node getNext() { return next;        }
        public void setNext(Node next) { this.next = next;        }
    }

    @Override
    public void rotate() {
        if(!isEmpty()){
            tail = tail.getNext();
        }
    }

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
        if(isEmpty())
            return null;
        return tail.getNext().getElement();
    }

    @Override
    public E last() {
        if(isEmpty())
            return null;
        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        Node newNode = new Node(e, null);
        if(isEmpty()){
            tail = newNode;
            tail.setNext(tail);
        }else{
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    @Override
    public E removeFirst() {
        if(isEmpty())
            return null;
        E pop = tail.getNext().getElement();
        if(tail.getNext() == tail){
            tail = null;
        }else{
            tail.setNext(tail.getNext().getNext());
        }
        size--;
        return pop;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if(this.tail != null){
            CircularlyLinkedList.Node iter = this.tail.getNext();
            while (true){
                result.append(iter.getElement().toString());
                result.append("\n"); //optional
                if(this.tail == iter){
                    break;
                }
                iter = iter.getNext();
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        CircularlyLinkedList<String> circularlyLinkedList = new CircularlyLinkedList<>();
        circularlyLinkedList.addFirst("a");
        circularlyLinkedList.addFirst("b");
        circularlyLinkedList.addFirst("c");
        System.out.println(circularlyLinkedList.toString());
        circularlyLinkedList.rotate();
        System.out.println(circularlyLinkedList.toString());
    }

}
