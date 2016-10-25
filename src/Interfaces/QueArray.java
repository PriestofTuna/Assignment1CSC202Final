package Interfaces;

import Exceptions.EmptyListException;

/**
 * Created by lytte on 10/7/2016.
 */
public interface QueArray<E> {
    public void enQueue(E e);
    public E deQueue() throws EmptyListException;
    public boolean isEmpty();
    public int size();
    public String toString();
    public void increaseSize();
}
