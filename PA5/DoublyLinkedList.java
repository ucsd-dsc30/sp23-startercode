/*
 * NAME: TODO First Last
 * PID: TODO Axxxxxxxx
 */

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Doubly-Linked List Implementation
 *
 * @author TODO
 * @since TODO
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {
        T data;

        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            this(element, null, null);
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            data = element;
            setNext(nextNode);
            setPrev(prevNode);
        }

        /**
         * Remove this node from the list. Update previous and next nodes
         */
        public void remove() {
            this.getNext().setPrev(this.getPrev());
            this.getPrev().setNext(this.getNext());
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            this.prev = p;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            this.next = n;
        }

        /**
         * Set the element
         *
         * @param e new element
         */
        public void setElement(T e) {
            this.data = e;
        }

        /**
         * Accessor to get the next Node in the list
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Accessor to get the prev Node in the list
         */
        public Node getPrev() {
            return this.prev;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            return this.data;
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        nelems = 0;
        head = new Node(null);
        tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * @return Number of elements currently on the list
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * @param index The index of the desired element.
     * @return The element stored in the Node with the desired index.
     * @throws IndexOutOfBoundsException if index received is out of bounds for
     *                                   the current list.
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= nelems || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node nthNode = this.getNth(index);
        T data = nthNode.getElement();
        return data;
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * @param index Where in the list to add the element.
     * @param data  Data to be added.
     * @throws IndexOutOfBoundsException if index received is out of bounds for
     *                                   the current list.
     * @throws NullPointerException      if data received is null.
     */
    @Override
    public void add(int index, T data)
            throws IndexOutOfBoundsException, NullPointerException {
        if (data == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > nelems) {
            throw new IndexOutOfBoundsException();
        }
        Node nthNode = this.getNth(index);
        Node prevNode = nthNode.getPrev();
        Node addNode = new Node(data);
        prevNode.setNext(addNode);
        addNode.setPrev(prevNode);
        addNode.setNext(nthNode);
        nthNode.setPrev(addNode);
        nelems++;
    }


    /**
     * Add an element to the end of the list
     *
     * @param data data to be added
     * @throws NullPointerException if data received is null
     */
    public boolean add(T data) throws NullPointerException {
        if (data == null) {
            throw new NullPointerException();
        }

        Node addNode = new Node(data);
        Node prevNode = tail.getPrev();
        prevNode.setNext(addNode);
        addNode.setPrev(prevNode);
        addNode.setNext(tail);
        tail.setPrev(addNode);
        nelems++;

        return true;
    }

    /**
     * Sets the value of an element at a certain index in the list.
     *
     * @param index Where in the list the data should be added.
     * @param data  Data to add.
     * @return Element that was previously at this index.
     * @throws IndexOutOfBoundsException if index received is out of bounds for
     *                                   the current list.
     * @throws NullPointerException      if data received is null.
     */
    public T set(int index, T data)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index >= nelems) {
            throw new IndexOutOfBoundsException();
        }
        if (data == null) {
            throw new NullPointerException();
        }
        Node nthNode = this.getNth(index);
        T previousData = nthNode.getElement();
        nthNode.setElement(data);

        return previousData;
    }

    /**
     * remove the element from position index in the list
     * @param index:index where in the list the data should be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if index<0 || index >= size
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= nelems) {
            throw new IndexOutOfBoundsException();
        }
        Node nthNode = this.getNth(index);
        T data = nthNode.getElement();
        nthNode.remove();
        nelems--;
        return data;
    }

    /**
     * Clear the linked list
     */
    public void clear() {
        head.setNext(tail);
        tail.setPrev(head);
        nelems = 0;
    }

    /**
     * Determine if the list empty
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return head.getNext() == tail && tail.getPrev() == head && nelems == 0;
    }

    // Helper method to get the Node at the Nth index
    private Node getNth(int index) {
        Node currentNode = this.head;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    /**
     * Determine if this list contains the given data
     * @param data data to find
     * @return true if list contains given data, false otherwise
     */
    public boolean contains(Object data) {
        Node temp = this.head;
        while (temp != this.tail) {
            if (data.equals(temp.getElement())) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     * @return string representation
     */
    @Override
    public String toString() {
        String out = "[(head) -> ";
        Node temp = this.head.next;
        while (temp != this.tail) {
            out += (temp.data.toString() + " -> ");
            temp = temp.next;
        }
        out += "(tail)]";
        return out;
    }

    /* Extra Credit */

    public void removeMultipleOf(int base) {
        if (base < 1) throw new IllegalArgumentException();
        int cnt = 0;
        Node cur = head.next;
        while (cur != this.tail) {
            if (cnt % base == 0) {
                cur.remove();
                nelems--;
            }
            cur = cur.next;
            cnt++;
        }
    }

    public void swapSegment(DoublyLinkedList other, int splitIndex) {
        Node p1 = this.head, p2 = other.head;
        // swap the front of segment
        Node temp = this.head.next;
        this.head.next = other.head.next;
        other.head.next = temp;
        // swap the end of segment
        for (int i = 0; i <= splitIndex; i++) {
            p1 = p1.next;
            p2 = p2.next;
        }
        temp = p1.next;
        p1.next = p2.next;
        p2.next = temp;
        // swap list size
        int tempSize = this.nelems;
        this.nelems = other.nelems;
        other.nelems = tempSize;
    }
}


/*
    /
     * Inserts another linked list of the same type into this one
     * @param index the location where the first element of the new array will be located
     * @param otherList list to splice in
     * @throws IndexOutOfBoundsException
     /
    public void splice(int index, DoublyLinkedList<T> otherList) throws IndexOutOfBoundsException {
        if (index < 0 || index > nelems) {
            throw new IndexOutOfBoundsException();
        }
        int otherSize = otherList.size();
        nelems += otherSize;
        if (otherSize < 1) {
            return;
        }
        Node nthNode = getNth(index-1);
        Node nextNode = nthNode.next;
        Node otherFirstNode = otherList.head.next;
        Node otherLastNode = otherList.tail.prev;
        nthNode.setNext(otherFirstNode);
        nextNode.setPrev(otherLastNode);
        otherFirstNode.setPrev(nthNode);
        otherLastNode.setNext(nextNode);
    }
    /
     * Determine the starting indices that match the subSequence
     * @param subsequence sequence to search for
     * @return starting indices for all match locations
     * (these can overlap, see writeup for more details)
     /
    public int[] match(DoublyLinkedList<T> subsequence) {
        ArrayList<Integer> indices = new ArrayList<>();
        // Iterator without iterators
        int index = 0;
        for (Node n = head.next; n != tail; n = n.next) {
            boolean isMatch = true;
            Node subCurr = subsequence.head.next;
            for (Node s = n; s != tail && subCurr != subsequence.tail; s = s.next) {
                // Subsequence doesn't match
                if (!subCurr.getElement().equals(s.getElement())) {
                    isMatch = false;
                    break;
                }
                subCurr = subCurr.next;
            }
            // Early termination
            if (subsequence.size() > size() - index) {
                break;
            }
            if (isMatch) {
                indices.add(index);
            }
            index++;
        }
        // Array Conversion
        int[] startingIndices = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            startingIndices[i] = indices.get(i);
        }
        return startingIndices;
    }
*/