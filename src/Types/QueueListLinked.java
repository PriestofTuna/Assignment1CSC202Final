package Types;

import Exceptions.EmptyListException;
import Interfaces.QueArray;
import Interfaces.QueLinked;

/**
 * Created by lytte on 10/11/2016.
 */
public class QueueListLinked<E extends Comparable> implements QueLinked<E>{
    LinkedList<E> ez = new LinkedList<E>();
    int size = 0;
    @Override
    public void enQueue(E e) {
        size++;
        ez.unorderedAddQue(e);
    }

    @Override
    public E deQueue() throws EmptyListException{
        size--;
        return ez.removeQue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return ez.isEmpty();
    }
    public String toString() {
        return ez.toString();
    }
    public String toStringReverse() {
        int j = 1;
        String start = ez.toString();
        String end = "1. ";
        String array[] = start.split(",");
        end+= array[array.length-1];
        for(int i = array.length-2; i >=0; i--) {
            j++;
            end += " " +j+". " +array[i];
        }
        return end;
    }
}
