package Types;

import Exceptions.EmptyListException;
import Interfaces.QueArray;

/**
 * Created by lytte on 9/21/2016.
 */
public class QueueList<E> implements QueArray<E>{
    final int DEFAULT_SIZE = 100;
    E[] array = (E[])(new Object[DEFAULT_SIZE]);

    int size = DEFAULT_SIZE;
    //size is adjustable DEFAULT_SIZE
    int maxIndex = DEFAULT_SIZE - 1;
    //index == maximum location in array that is empty
    int front = DEFAULT_SIZE-1;
    @Override
    public void enQueue(E e) {
        if(isEmpty()) {
            array[size-1] = e;
            maxIndex=size-2;
            //if empty, index of size -1 is equal to e, and next empty index is size minus 2
        } else {
            array[maxIndex] = e;
            maxIndex-=1;
            if (maxIndex < 0) {
                increaseSize();
            }
            //array at max Empty index is equal to e, maxIndex minus 1
            //if maxIndex < 0, call the increase size method
        }
    }

    @Override
    public E deQueue() throws EmptyListException {
        if(isEmpty()) {
            throw new EmptyListException("Cannot Deque from empty list!");
        }
        E temp = array[front];
        E first = array[maxIndex+1];
        array[maxIndex + 1] = null;
        int tempMaxIndex = maxIndex;
        if(maxIndex==(size-2)) {
            maxIndex+=1;
            return first;
            //if only size-1 is filled, then empty that and return it
        }
        if(maxIndex<size-2) {
            E cycle;
            E item = first;
            while(1+tempMaxIndex < size) {
                cycle = item;
                //Cycle is equal to item, and then the previous index is equal to Cycle
                int la = 1;
                item = array[tempMaxIndex+la];
                //Item is equal to the current index
                array[(tempMaxIndex + la)] =cycle;
                //the current index is now equal to the previous index
                tempMaxIndex++;
            }
            array[maxIndex+2] = first;
            //the index after first is now equal to first
        }

        maxIndex+=1;
        //the largest empty index is now 1 larger
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return (array[size-1]==null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void increaseSize() {
        size +=100;
        maxIndex = size-1;
        E temp[] = (E[])(new Object[size]);
        int iA = array.length-1;
        for(int i = temp.length-1; iA >= 0; i--) {

            temp[i] = array[iA];
            //copies to new array
            iA-=1;
            maxIndex = i -1;
            //sets current empty index
        }
        front = temp.length-1;
        //sets new Front value IE 200, 300, 400,
        array = temp;
        //sets array equal to new Array
    }
    @Override
    public String toString() {
        String QueList = "";
        if(!isEmpty()) {
            //if not empty, cycle through the array backwards. and then return the String
            QueList += array[size-1];
                for (int i = size - 2; i > maxIndex; i--) {

                    QueList += ", " + array[i];
                }

        }
        return QueList;
    }
}
