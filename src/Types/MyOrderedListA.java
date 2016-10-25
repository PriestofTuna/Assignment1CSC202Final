package Types;

import Exceptions.EmptyListException;
import Exceptions.RepeatedItemsException;
import Interfaces.OrderedListAI;

/**
 * Created by lytte on 9/21/2016.
 */
public class MyOrderedListA<E extends Comparable> implements OrderedListAI<E> {
    int size = 100;
    int maxIndex = 0;
    int filledSize = 0;
    int current = 0;
    E array[] = (E[])(new Comparable [size]);
    //change to default size
    @Override
    public void add(E e) throws RepeatedItemsException{
        int cycle=0;
        int oneUpIndex = 0;
        int determine = 10;
        filledSize+=1;
        if(isEmpty()) {
            array[0]=e;
            //System.out.println("Hits at is Empty");
        }else {
            while (array[cycle] != null) {
                determine = e.compareTo(array[cycle]);
                if (determine == 0) {
                    filledSize-=1;
                    throw new RepeatedItemsException("Cannot add identicle item to list");
                }else if (determine < 0) {
                    //determine < 0 | determine > 0
                    //System.out.println("Hits at else if(determine < 0");
                    oneUpIndex = cycle;
                    //System.out.println("Hits at Escape");
                    maxIndex += 1;
                    if (maxIndex+1 >= size) {
                        //System.out.println("Hits at IncreaseSize");
                        IncreaseSize();
                    }
                    if(e.compareTo(array[0]) < 0) {
                        IncreaseSize();
                        for(int i = array.length-1; i > 0; i--) {
                            array[i] = array[i-1];
                        }
                        current=0;
                        array[0] = e;
                        break;
                    } else {
                        int temp = maxIndex;
                        for (int i = array.length - 1; i > oneUpIndex; i--) {
                            array[i] = array[i - 1];

                        }
                        current=oneUpIndex;
                        array[oneUpIndex] = e;
                        break;
                    }
//                    while(temp>oneUpIndex) {
//                        //was temp>=oneUpIndex
//                        array[++temp] = array[temp];
//                        temp--;
//                    }
                    //array[temp] = e;
                    //instead of using the switch below lets assume for now as is, that the events hit here
                }
            cycle++;
            }
            if(array[cycle]==null) {
                array[cycle] = e;
            }
            //System.out.println(toString());
            maxIndex += 1;
            if (maxIndex+1 >= size) {
                //System.out.println("Hits at IncreaseSize");
                IncreaseSize();
            }
            }
        }

    @Override
    public E remove(E e) throws EmptyListException {
        if(!contains(e) | isEmpty()) {
            throw new EmptyListException("To remove, item must exist within list");
        }
        //loop through here, for the thing with the removing
        int removableIndex = 0;
        E temp = null;
        filledSize-=1;
        if(array[0]==e) {
            temp = array[0];
            int cycle = 0;
            for(int i = 1; i < array.length; i++ ) {
                array[cycle] = array[i];
                cycle+=1;
            }
            current=0;
            return temp;
        }
        for(int i = 0; i < array.length; i++){
            //System.out.println(array[i]);
            if(array[i]==e) {
                removableIndex = i;
                break;
            }
        }
        temp = array[removableIndex];
        if(array[removableIndex]==array[filledSize]) {
            array[filledSize] = null;
            current = filledSize-1;
            return temp;
        }
        System.out.println(toString());
        for(int j =removableIndex; j < filledSize; j++ )  {
            array[j] = array[++j];
        }
        current = removableIndex;
        //System.out.println(current);
        return temp;
    }

    @Override
    public boolean contains(E e) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == e) {
                return true;
            }
        }

        return false;

    }

    @Override
    public boolean isEmpty() {
        return (array[0]==null);
    }

    @Override
    public int size() {
        int i = 0;
        while(array[i]!=null) {
            ++i;
        }
        return i;
    }

    @Override
    public E get(E e) {
        if(contains(e)) {
            return e;
        }
        return null;
    }

    @Override
    public void reset() {
        current = 0;
        array = (E[])(new Comparable [size]);
    }

    @Override
    public E getNext() throws EmptyListException{
        if(hasNext()) {
            current += 1;
            System.out.println(current);
            return array[current];
        }
        //will need to create a "Current"
        return null;

    }

    @Override
    public boolean hasNext() {
        return (array[current+1]!=null);
    }
    //Unbounded Linked list
    public void IncreaseSize() {
        size += 100;
        E tempArray[] = (E[])(new Comparable[size]);
        for(int j = 0; j < array.length; j++) {
            tempArray[j] = array[j];
        }
        maxIndex = array.length;
        array = tempArray;
    }
    public String toString() {
        if(array[0]!=null) {
        String listString = "" + array[0];
        for(int i = 1; array[i]!=null; i++) {
            listString+=", " + array[i];
        }
        return listString;
        }
        return "";
    }
}
