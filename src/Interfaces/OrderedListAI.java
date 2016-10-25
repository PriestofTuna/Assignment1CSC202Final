package Interfaces;

import Exceptions.EmptyListException;
import Exceptions.RepeatedItemsException;

/**
 * Created by lytte on 10/9/2016.
 */
public interface OrderedListAI<E> {
    public void add(E e)throws RepeatedItemsException;
    public E remove(E e) throws EmptyListException;
    public boolean contains(E e) throws EmptyListException;
    public boolean isEmpty();
    public int size();
    public E get(E e) throws EmptyListException;
    public String toString();
    public void reset();
    public E getNext() throws EmptyListException;
    public boolean hasNext() throws EmptyListException;
}
