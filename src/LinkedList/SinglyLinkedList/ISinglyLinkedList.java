package LinkedList.SinglyLinkedList;

public interface ISinglyLinkedList<E> {
    // returns the current size of the linked list
    public int size();

    // return true if the list is empty
    public boolean isEmpty();

    // returns the first element of the linked list (null for empty list)
    public E first();

    // returns the last element of the linked list (null for empty list)
    public E last();

    // add element to the head of the list
    public void addFirst(E e);

    // add element to the tail of the list
    public void addLast(E e);

    // remove the first element from the list and return it
    public E removeFirst();
}
