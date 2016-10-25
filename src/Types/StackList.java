package Types;

import Exceptions.EmptyListException;
import Interfaces.IUStack;

/**
 * Created by lytte on 9/21/2016.
 */
public class StackList<E> implements IUStack<E> {
    E element[];
    private int SIZE = 100;
    private int stackSize = 0;
    public StackList() {
        element =  (E[])(new Object[SIZE]);
    }
    @Override
    public void Push(E e) {
        element[stackSize] = e;
        stackSize++;
        if(stackSize >= SIZE) {
            SIZEAdjustUp();
        }
    }
    @Override
    public E Pop() throws EmptyListException{
        if(isEmpty()) {
            throw new EmptyListException("No top in empty list");
        }
        if(stackSize > 0) {
            stackSize--;
            E e = element[stackSize];
            element[stackSize] = null;
            return e;
        }
        stackSize--;
        E e = element[stackSize];
        element[stackSize] = null;
        return e;
    }

    @Override
    public E top()throws EmptyListException {
        if(isEmpty()) {
            throw new EmptyListException("No top in empty list");
        }
        return element[stackSize - 1];
    }

    @Override
    public boolean isEmpty() {
        return (element[0] == null);
    }
    public void SIZEAdjustUp() {
        SIZE = stackSize + 50;
        E tempElement[] = element;
        for(int i = 0; i < element.length; i++) {
            tempElement[i] = element[i];
        }
        E z[] = (E[])(new Object[SIZE]);
        element = z;
        for(int i = 0; i < tempElement.length; i++) {
            element[i] = tempElement[i];
        }
    }
    public void SIZEAdjustUser(int SIZE) throws IndexOutOfBoundsException {
        this.SIZE = SIZE;
        E tempElement[] = element;
        element = (E[])(new Object[SIZE]);
        for(int i = 0; i < element.length; i++) {
            element[i] = tempElement[i];
        }
        //unrequired Method thus no test, it works doe :P
    }
    public int getSIZE() {
        return SIZE;
    }
    public int getUsedSize() {
        return stackSize;
    }
    public String toString() {
        String thing = "";
        if(!isEmpty()) {
            thing = "" +element[--stackSize];
            for(int i = (stackSize-1); i > -1; i--) {
                thing += ", " + element[i];
            }
        }
        return thing;
    }
}
