package Interfaces;

import Exceptions.EmptyListException;
import Exceptions.InstantiatedIndexException;
import Exceptions.RepeatedItemsException;

/**
 * Created by lytte on 9/29/2016.
 */
public interface IListIterator<E extends Comparable> {
    public void reset();
    public E getNext() throws EmptyListException;
    public boolean hasNext() throws EmptyListException;
    public E IndexedRemove(E e)throws EmptyListException;
    public void indexedAdd(int i, E e) throws InstantiatedIndexException;
    public void unorderedAddQue(E e);
    //this is a reused method for both Que and Indexed
    public E cycleNext() throws EmptyListException;
    public E cycleBack() throws EmptyListException;
    public E cycleStart() throws EmptyListException;
}
