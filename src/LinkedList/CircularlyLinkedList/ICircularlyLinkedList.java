package LinkedList.CircularlyLinkedList;

import LinkedList.SinglyLinkedList.ISinglyLinkedList;

public interface ICircularlyLinkedList<E> extends ISinglyLinkedList<E> {
    public void rotate(); // push the first element to the end of the list
}
