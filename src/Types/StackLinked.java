package Types;

import Exceptions.EmptyListException;
import Interfaces.IUStack;

/**
 * Created by lytte on 10/10/2016.
 */
public class StackLinked<E extends Comparable> implements IUStack<E> {
    LinkedList<E> ez = new LinkedList<E>();
    int size = 0;

    @Override
    public void Push(E e) {
        size+=1;
        ez.unorderedAdd(e);
    }
    public int getSIZE() {
        return size;
    }
    @Override
    public E Pop() throws EmptyListException{
        if(isEmpty()) {
            throw new EmptyListException("No items to pop in empty list");
        }
        size-=1;
        return ez.unorderedRemove();
    }

    @Override
    public E top() throws EmptyListException{
        if(isEmpty()) {
            throw new EmptyListException("No top in empty list");
        }
        return ez.unorderedTop();
    }

    @Override
    public boolean isEmpty() {
        return (ez.getListPointer()==null);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }

        Node<E> temp = ez.getListPointer();
        String listTemp = "" + temp.getName();
        temp=temp.getPointer();
        while(temp!=null) {

            listTemp += ", " + temp.getName();
            temp=temp.getPointer();
        }
        return listTemp;
    }
}
