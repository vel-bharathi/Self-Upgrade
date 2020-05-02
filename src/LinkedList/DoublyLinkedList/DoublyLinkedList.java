package LinkedList.DoublyLinkedList;

import LinkedList.SinglyLinkedList.SinglyLinkedList;

public class DoublyLinkedList<E extends Comparable<E>> implements IDoublyLinkedList<E> {

    private class Node{
        private E element;
        private Node prev;
        private Node next;

        public Node(E e, Node next, Node prev){
            this.element = e;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    private int size = 0;
    private Node header = null;
    private Node tailer = null;

    public  DoublyLinkedList(){
        header = new Node(null, null, null);
        tailer = new Node(null, null, null);
        header.setNext(tailer);
        tailer.setPrev(header);
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
        return header.getNext().getElement();
    }

    @Override
    public E last() {
        return tailer.getPrev().getElement();
    }

    @Override
    public void addFirst(E e) {
        size++;
        Node add = new Node(e, header.getNext(), header);
        add.getNext().setPrev(add);
        header.setNext(add);

    }

    @Override
    public void addLast(E e) {
        size++;
        Node last = new Node(e, tailer, tailer.getPrev());
        last.getPrev().setNext(last);
        tailer.setPrev(last);
    }

    @Override
    public E removeFirst() {

        if(isEmpty())
            return null;

        Node first = header.getNext();
        header.setNext(first.getNext());
        first.getNext().setPrev(header);
        return first.getElement();
    }

    @Override
    public E removeLast() {
        if(isEmpty())
            return null;

        Node last = tailer.getPrev();
        tailer.setPrev(last.getPrev());
        last.getPrev().setNext(tailer);
        return last.getElement();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        DoublyLinkedList.Node iter = this.header.getNext();
        while (iter != this.tailer){
            result.append(iter.getElement().toString());
            result.append("\n"); //optional
            iter = iter.getNext();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.addFirst("b");
        list.addFirst("c");
        list.addFirst("a");
        list.addLast("d");

        System.out.println(list.toString());
        list.removeLast();
        System.out.println(list.toString());
        list.removeFirst();
        System.out.println(list.toString());
    }
}
