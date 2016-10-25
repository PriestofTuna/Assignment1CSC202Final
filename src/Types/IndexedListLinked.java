package Types;

import Exceptions.EmptyListException;
import Exceptions.InstantiatedIndexException;
import Exceptions.RepeatedItemsException;
import Exceptions.UninstantiatedIndexException;
import Interfaces.IndexedListAI;
import Interfaces.IndexedListLinkedI;
import sun.invoke.empty.Empty;

/**
 * Created by lytte on 10/11/2016.
 */
public class IndexedListLinked<E extends Comparable> implements IndexedListLinkedI<E> {
    LinkedList<E> linkedList = new LinkedList<E>();
    int size = 0;
    @Override
    public void add(E e) throws RepeatedItemsException{
        try {
            if (contains(e)) {
                throw new RepeatedItemsException("Cannot have the same item twice in a List!");
            }
        }catch (EmptyListException ezbrah) {

        }
        size++;
        linkedList.unorderedAddQue(e);
    }

    @Override
    public void addIndexed(int i, E e) throws RepeatedItemsException, InstantiatedIndexException {
        try {
            if (contains(e)) {
                throw new RepeatedItemsException("Cannot have the same item twice in a List!");
            }
        }catch (EmptyListException ezbrah) {

        }
        linkedList.indexedAdd(i, e);
    }

    @Override
    public void set(int i, E e) throws UninstantiatedIndexException, RepeatedItemsException{
        try {
            if (contains(e)) {
                throw new RepeatedItemsException("Cannot have the same item twice in a List!");
            }
        }catch (EmptyListException ezbrah) {

        }
        int keep = 0;

        Node<E> gitGud = linkedList.getListPointer();
        Node<E> previousGitGud = null;
        Node<E> nextGitGud = null;
        if(gitGud!=null) {
            while (keep < i & gitGud!=null) {
                previousGitGud = gitGud;
                gitGud = gitGud.getPointer();
                keep += 1;
            }
            if(gitGud==null) {
                throw new UninstantiatedIndexException("Cannot set uninitiated index");
            }else {
                nextGitGud = gitGud.getPointer();
                gitGud.setName(e);
                linkedList.setPrevious(previousGitGud);
                linkedList.setCurrent(gitGud);
                linkedList.setNext(nextGitGud);
            }
        }
    }

    @Override
    public E remove(E e) throws EmptyListException {
        if(isEmpty()) {
            throw new EmptyListException("Cannot remove from empty List");
        }
        size--;
        return linkedList.IndexedRemove(e);
    }

    public E remove(int i) {
        return linkedList.indexedRemove(i);
    }

    @Override
    public E IndexOf(int i)  {
        //should throw uninstantiated index Exception, or return null
        Node<E> Index = linkedList.getListPointer();
        int cycle = 1;
        while(cycle< i & Index!=null) {
            Index = Index.getPointer();
            cycle+=1;
        }
        if(Index!=null) {
            linkedList.setCurrent(Index);
            linkedList.setNext(Index.getPointer());
            return Index.getName();
        }
        return null;
    }

    @Override
    public boolean contains(E e) throws EmptyListException{
        if(isEmpty()) {
            throw new EmptyListException("Empty list doesn't contain any values");
        }
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
    public E get(E e) throws EmptyListException{
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
    public boolean hasNext() throws EmptyListException {
        return linkedList.hasNext();
    }
    public String toString() {
        if(isEmpty()) {
            return null;
        }
        return linkedList.toString();
    }
}
