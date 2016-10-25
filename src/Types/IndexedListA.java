package Types;

import Exceptions.EmptyListException;
import Exceptions.InstantiatedIndexException;
import Exceptions.RepeatedItemsException;
import Interfaces.IndexedListAI;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lytte on 10/8/2016.
 */
public class IndexedListA<E> implements IndexedListAI<E> {
    final int DEFAULT_SIZE = 100;
    int minEmptyIndex = 0;
    int size = DEFAULT_SIZE;
    int itemSize = 0;
    int current = -1;
    int next = 0;
    E[][] array = (E[][])(new Object[DEFAULT_SIZE][1]);

    @Override
    public void add(E e) throws RepeatedItemsException {
        try {
            if (contains(e)) {
                throw new RepeatedItemsException("Cannot have the same item twice in a List!");
            }
        }catch (EmptyListException ezbrah) {

        }
        itemSize+=1;
        while(array[minEmptyIndex][0]!=null) {
            minEmptyIndex+=1;
            if(minEmptyIndex>=size) {
                increaseSize();
            }
        }
        array[minEmptyIndex][0] = e;
        minEmptyIndex +=1;
        current =(minEmptyIndex-1);
        if(minEmptyIndex == size) {
            increaseSize();
        }
    }

    @Override
    public void addIndexed(int i, E e) throws RepeatedItemsException, InstantiatedIndexException{
        try {
            if (contains(e)) {
                throw new RepeatedItemsException("Cannot have the same item twice in a List!");
            }
        }catch (EmptyListException ezbrah) {

        }
        i-=1;
        while(i >= size) {
            increaseSize();
        }
        //System.out.println(array[i][0]);
        if(array[i][0]==null) {
            array[i][0] = e;
            current = i;
            next = i+1;

        }else {
            throw new InstantiatedIndexException();
        }
    }

    @Override
    public void set(int i, E e) throws RepeatedItemsException {
        //while i > size, increaseSize
        try {
            if (contains(e)) {
                throw new RepeatedItemsException("Cannot have the same item twice in a List!");
            }
        }catch (EmptyListException ezbrah) {

        }
        while(i >= size) {
            increaseSize();
        }
        i-=1;
        array[i][0] = e;

        current = i;
        next = ++i;
    }

    public E remove(int i) throws EmptyListException{
        i-=1;
        E temp = array[i][0];
        array[i][0] = null;
        current = i-1;
        next = ++i;
        return temp;
    }

    @Override
    public E remove(E e) throws EmptyListException{
        //place current to item behind removed index
        int item = 0;
        int cycle = 0;
        while(cycle<array.length) {
            E temp = array[cycle][0];
            if(temp==null & cycle<array.length) {
                cycle+=1;
                continue;
            }
            if(temp.equals(e)) {
                item = cycle;
                //finds index of the item, then passes it
                if(cycle==array.length) {
                    return null;
                }
                for(int i = item; (i+1) < array.length; i++) {
                    array[i][0] = array[i+1][0];
                }
                array[size-1][0] = null;
                current = item-1;
                next = item;
                itemSize -=1;
                return e;
            }
            cycle+=1;
        }
        return null;
    }

    @Override
    public E IndexOf(int i) {
        while(i>size) {
            increaseSize();
        }
        if(i == 0) {

        } else {
            i -= 1;
        }
        E e = array[i][0];
        current = i;
        next = ++i;
        //change current to indexOf, even if indexOf isn't filled
        //if IndexOf doesn't Exist in the array's size, make it bigger
        return e;
    }

    @Override
    public void increaseSize() {
        size += 100;
        E tempArray[][] = (E[][])(new Object[size][1]);
        for(int j = 0; j < array.length; j++) {
            tempArray[j][0] = array[j][0];
        }
        minEmptyIndex = array.length;
        array = tempArray;
    }

    @Override
    public boolean contains(E e) throws EmptyListException {
        boolean contain = false;
        for(int j = 0; j < array.length; j++) {
            if(array[j][0]==e) {
                current =j;
                next = j++;
                contain = true;
                break;
            }
        }
        return contain;
    }

    @Override
    public boolean isEmpty() {
        return (array[0][0]==null);
    }

    @Override
    public int size() {
        return itemSize;
    }

    @Override
    public E get(E e) throws EmptyListException{
        if(isEmpty()) {
            if(isEmpty()) {
                throw new EmptyListException("Cannot get in emptyList");
            }
        }
        if(contains(e)) {
            return e;
        }
        return null;
    }

    @Override
    public void reset() {
        array = (E[][])(new Object[DEFAULT_SIZE][1]);
        minEmptyIndex = 0;
        current = -1;
        next = 0;
    }

    @Override
    public E getNext() throws EmptyListException{
        if(isEmpty()) {
            throw new EmptyListException("Cannot get next in emptyList");
        }
        if(hasNext()) {
            int oldnext = next;
            current=oldnext;
            next+=1;
            return array[oldnext][0];
        }
        return null;
    }

    @Override
    public boolean hasNext() throws EmptyListException{
        if(isEmpty()) {
            throw new EmptyListException("no next in emptyList");
        }
        while(next >= size) {
            increaseSize();
        }
        return (array[next][0]!=null);
    }
    public String toString() {
        int i = 0;
        String list = "";
        if(array[0][0] != null) {
            list = "" + array[i][0];
        }


        i++;
        //while(i < array.length & array[i][0]!=null) {
        while(i < array.length) {

            if(array[i][0]!=null & array[0][0]!=null)
                list += ", " +array[i][0];
            else if(array[i][0]!=null & array[0][0]==null)
                list += array[i][0] + ", ";
//            else if(array[i][0]!=null & array.length-2==i)
//                list+= array[i][0];

            i+=1;
        }
        return list;
    }
}
