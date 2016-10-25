package Interfaces;

import Exceptions.EmptyListException;
import Exceptions.InstantiatedIndexException;
import Exceptions.RepeatedItemsException;

/**
 * Created by lytte on 10/8/2016.
 */
public interface IndexedListAI<E> {
    public void add(E e) throws RepeatedItemsException;
    public void addIndexed(int i, E e) throws RepeatedItemsException, InstantiatedIndexException;
    public void set(int i, E e) throws RepeatedItemsException;
    public E remove(E e) throws EmptyListException;
    public E remove(int i) throws EmptyListException;
    public E IndexOf(int i);
    public void increaseSize();
    public boolean contains(E e) throws EmptyListException;
    public boolean isEmpty();
    public int size();
    public E get(E e) throws EmptyListException;
    public String toString();
    public void reset();
    public E getNext() throws EmptyListException;
    public boolean hasNext() throws EmptyListException;
}
