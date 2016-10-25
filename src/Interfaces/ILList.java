package Interfaces;

import Exceptions.EmptyListException;

/**
 * Created by lytte on 9/29/2016.
 */
public interface ILList <E extends Comparable> extends IListIterator<E> {
    void add(E e);
    E remove(E element) throws EmptyListException;
    boolean contains(E element) throws EmptyListException;
    boolean isEmpty() throws EmptyListException;
    int size();
    E get(E element) throws EmptyListException;
//    public void reset();
//    public E getNext() throws EmptyListException;
//    public boolean hasNext() throws EmptyListException;
}
