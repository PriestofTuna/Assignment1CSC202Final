package Interfaces;

import Exceptions.EmptyListException;

/**
 * Created by lytte on 10/11/2016.
 */
public interface QueLinked<E> {

    public void enQueue(E e);
    public E deQueue() throws EmptyListException;
    public int size();
    public boolean isEmpty();
}
