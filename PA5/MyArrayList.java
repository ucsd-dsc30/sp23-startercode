/*
 * NAME: TODO First Last
 * PID: TODO Axxxxxxxx
 */

import java.util.AbstractList;


/**
 * ArrayList Implementation
 *
 * @author TODO
 * @since TODO
 */
public class MyArrayList<T> extends AbstractList<T> {

    private int nelems;
    private T  [ ] arrList;
  
    /**
     * TODO
     */
    public MyArrayList() {
      
        arrList = (T[]) new Object[0];
  
    }

    public MyArrayList(int capacity) {
       
        arrList = (T[]) new Object[capacity];    
    }

    /**
     * Retrieves the amount of elements that are currently in the ArrayList.
     *
     * @return Number of elements currently in the ArrayList
     */
    @Override
    public int size() {
        // TODO: complete implementation
    }

    /**
     * Adds an element to a certain index in the list, shifting existing elements
     * to create space. Does not accept null values.
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
        // TODO: complete implementation
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * @param index The index of the desired element.
     * @return Returns the data contained at the specified index.
     * @throws IndexOutOfBoundsException if index received is out of bounds for
     *                                   the current list.
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        // TODO: complete implementation
    }
                   

    /**
     * Determine if this list contains the given data
     * @param data data to find
     * @return true if list contains given data, false otherwise
     */
    public boolean contains(Object data) {
        // TODO: complete implementation
    }


    /**
     * String representation of this list in the form of:
     * "[2 -> 45 -> 15 -> 9 -> 1]"
     * @return string representation
     */
    @Override
    public String toString() {
        // TODO: complete implementation

    }


}



    