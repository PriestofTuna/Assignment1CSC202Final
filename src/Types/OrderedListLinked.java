package Types;

import Exceptions.EmptyListException;
import Exceptions.RepeatedItemsException;
import Interfaces.OrderedListAI;

/**
 * Created by lytte on 10/10/2016.
 */
public class OrderedListLinked<E extends Comparable> implements OrderedListAI<E> {
        LinkedList<E> linkedList = new LinkedList<E>();
    @Override
    public void add(E e) throws RepeatedItemsException {
        if(!linkedList.isEmpty()) {
            try {
                if (linkedList.contains(e)) {
                    throw new RepeatedItemsException("cannot insert an item identical to another!");
                }
            }catch(EmptyListException ez) {

            }
        }
        linkedList.add(e);
    }

    @Override
    public E remove(E e) throws EmptyListException{
        return linkedList.remove(e);
    }

    @Override
    public boolean contains(E e) throws EmptyListException{
        return linkedList.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.size();

    }

    @Override
    public E get(E e) throws EmptyListException {
        return linkedList.get(e);
    }

    @Override
    public void reset() {
        linkedList.reset();
    }

    @Override
    public E getNext() throws EmptyListException{
        return linkedList.getNext();
    }

    @Override
    public boolean hasNext() throws EmptyListException{
        return linkedList.hasNext();
    }
    public E cycleNext() throws EmptyListException{
        return linkedList.cycleNext();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
