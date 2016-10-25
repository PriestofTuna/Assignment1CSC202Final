package Interfaces;

import Exceptions.EmptyListException;

/**
 * Created by lytte on 9/24/2016.
 */
public interface IUStack<E> {
    public void Push(E e);
    public E Pop() throws EmptyListException;
    public E top() throws EmptyListException;
    public boolean isEmpty();
    public String toString();
}
