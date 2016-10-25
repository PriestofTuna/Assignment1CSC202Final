package Interfaces;

import Exceptions.EmptyListException;

/**
 * A Collection of items for additional resources for linked list
 * Including removeQue for Queue implementations, addQue is located in IListIterator.
 * Also includes methods for stackListLinked
 */
public interface LinkedListResources<E> {
    public E removeQue() throws EmptyListException;
    //addQue is located in IListIterator
    public void unorderedAdd(E e);
    public E unorderedRemove() throws EmptyListException;
    public E unorderedTop() throws EmptyListException;
}
