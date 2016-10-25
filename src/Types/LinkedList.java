package Types;

import Exceptions.EmptyListException;
import Exceptions.InstantiatedIndexException;
import Interfaces.CompareTo;
import Interfaces.ILList;
import Interfaces.LinkedListResources;
import com.sun.corba.se.impl.io.TypeMismatchException;

/**
 * Created by lytte on 9/26/2016.
 */
public class LinkedList<E extends Comparable> implements ILList<E>, LinkedListResources<E> {
    private Node<E> listPointer;
    private Node<E> current;
    private Node<E> previous;
    private Node<E> next;
    private Node<E> last = listPointer;
    int count = 0;

    public LinkedList() {
        listPointer = null;
    }

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<E>(e);
        if (isEmpty()) {
            listPointer = newNode;
            this.current = newNode;
            this.previous = null;
            this.next = null;
        } else {
            current = listPointer;
            previous = listPointer;
            Node<E> previousReset = previous;
            boolean needNew = true;
            //sets current to a value, and previous
            while (current != null) {
                if (e.compareTo(current.getName()) < 0) {

                    if(listPointer.equals(current)) {
                        //beginning insert
                        listPointer = newNode;
                    } else {
                        previous.setPointer(newNode);
                        //in between insert
                    }
                    newNode.setPointer(current);
                    needNew=false;
                    break;
                }
                previous=current;
                if(needNew) {
                    current = current.getPointer();
                }
            }
            if(current==null) {
                //inserts at the end
                previous.setPointer(newNode);
            } else{
                next= newNode.getPointer();
            }
        }
        if(listPointer.getPointer()==current) {
            previous = listPointer;
            if(current!=null)
                next = current.getPointer();
        }
        current = newNode;
        next = newNode.getPointer();
        if(previous==current) {
            previous=null;
        }
        count++;
    }

    public void unorderedAddQue(E e) {
        //works with Indexed as well
        count++;
        if(listPointer==null) {
            listPointer = new Node<E>(e);
            last=listPointer;
        } else {
            Node<E> de_stroyed = new Node<E>(e);
            last.setPointer(de_stroyed);
            previous=last;
            last = de_stroyed;
        }

        current = last;
        next = null;
    }
    public E IndexedRemove(E e) throws EmptyListException {
        Node<E> temp = listPointer;
        Node<E> previousTemp = listPointer;
        do {
            //System.out.println(temp.getName());
            if(temp.getName()==e) {
                previousTemp.setPointer(temp.getPointer());
                //System.out.println(temp.getName() + " Hits?");
                previous = previousTemp;
                current = temp.getPointer();
                if(current!=null) {
                    next = current.getPointer();
                }
                count--;
                return temp.getName();
            }
            previousTemp = temp;
            temp = temp.getPointer();
        }while((temp!=null));
        if(temp!=null) {
            count--;
            return temp.getName();
        } else {
            return null;
        }
    }

    public E indexedRemove(int i) {
        int tempInt = i;
        Node<E> tempE = listPointer;
        Node<E> preTemp = null;
        E tempElement = null;
        if (tempInt > 1) {
            while (tempInt > 0) {
                preTemp = tempE;
                tempE = tempE.getPointer();
                last = tempE.getPointer();
                tempInt -= 1;
            }
            if(tempE.getName()!=null) {
                tempElement = tempE.getName();
                preTemp.setPointer(tempE.getPointer());
                previous=null;
                current = preTemp;
                next = preTemp.getPointer();
            }
        } else if(tempInt==0){
            if(listPointer!=null)
                listPointer = listPointer.getPointer();
        }
        return tempElement;
    }

    @Override
    public void indexedAdd(int i, E e) throws InstantiatedIndexException {
        int tempInt = i;
        Node<E> tempE = listPointer;
        Node<E> preTemp = null;
        boolean breaker = false;
        boolean breaker2 = false;
        //listpointer = 1 in Index
        if (tempInt == 1 & listPointer == null) {
            listPointer = new Node<>(e);
        } else if (tempInt == 1 & listPointer != null) {
            throw new InstantiatedIndexException("Cannot add to an Instantiated index :(");
            //            if(listPointer.getName()==null) {
//                listPointer.setName(e);
//            }
        }
        if (tempInt > 1) {
            while (tempInt > 0) {
                preTemp = tempE;
                if (tempE.getPointer() == null) {
                    Node<E> newNode = new Node<>();
                    tempE.setPointer(newNode);
                    breaker = true;
                    //insert ahead
                } else if(tempInt == 2){
                    Node<E> newNode = new Node<>();
                    Node<E> next = null;

                    preTemp = tempE;
                    tempE = tempE.getPointer();
                    last = tempE.getPointer();
                    next = tempE.getPointer();
                    newNode.setPointer(tempE);
                    preTemp.setPointer(newNode);
                    //tempE = tempE.getPointer();
                    breaker2 = true;
                }
                if(breaker2) {
                    break;
                }
                tempE = tempE.getPointer();
                last = tempE.getPointer();
                tempInt -= 1;
                if(breaker) {
                    break;
                }
            }
            if(breaker2) {
                //tempE = tempE.getPointer();
            }
            if(tempE.getName()==null) {
                previous=preTemp;
                current = tempE;
                next = tempE.getPointer();
                tempE.setName(e);
            } else if(preTemp.getPointer().getName()==null){
                previous =preTemp;
                current = preTemp.getPointer();
                next = tempE;
                preTemp.getPointer().setName(e);
            } else {
                throw new InstantiatedIndexException("Cannot add to an Instantiated index :(");
            }
        }
    }

    public E removeQue() throws EmptyListException{
        E eZ = listPointer.getName();
        if(listPointer.getPointer()!=null) {
            listPointer = listPointer.getPointer();
        } else {
            listPointer=null;
        }
        return eZ;
    }
    //make an add for Que,
    public void unorderedAdd(E e) {
        Node<E> newNode = new Node<E>(e);
        if(!isEmpty()) {
            newNode.setPointer(listPointer);
        }
        listPointer = newNode;
        current = newNode;
        next = newNode.getPointer();
        count++;
        //works for Stack
    }
    public E unorderedRemove() throws EmptyListException {
        if(isEmpty()) {
            throw new EmptyListException("Cannot remove from empty list");
        }
        E temp = listPointer.getName();
        listPointer = listPointer.getPointer();
        count--;
        current = listPointer;
        return temp;
        //works for Stack
    }
    public E unorderedTop() throws EmptyListException {
        E temp = listPointer.getName();
        return temp;
    }

    @Override
    public E remove(E element) throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Cannot remove from empty List");
        }
        if(contains(element)) {
            count--;
        }
        Node<E> current;
        Node<E> last;
        last = listPointer;
        current = listPointer.getPointer();
        do {
            //next look for pointer, maybe in contains?
            if(last.getName()== element) {
                listPointer = listPointer.getPointer();
                this.current = listPointer;
                this.previous = null;
                if(listPointer!=null) {
                    this.next = listPointer.getPointer();
                } else {
                    this.next = null;
                }
                return element;
            }
            if (current.getName() == element) {
                last.setPointer(current.getPointer());
                this.current = last;
                next = this.current.getPointer();
                return element;
            }
            last = current;
            current = current.getPointer();
        } while (current != null);
        throw new EmptyListException("Item does not exist within List");
    }

    @Override
    public boolean contains(E element) throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Cannot find item in empty List");
        }
        Node<E> previousC = listPointer;
        Node<E> cycle = listPointer;
        //needs to be first node
        do {
            if (cycle.getName() == element) {
                previous = previousC;
                current = cycle;
                next = cycle.getPointer();
                return true;
            }
            previousC = cycle;
            cycle = cycle.getPointer();
        } while (cycle != null);
        return false;
    }

    public boolean isEmpty() {
        return (listPointer == null);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public E get(E element) throws EmptyListException {
        //contains with return
        //perhaps this is meant to change the pointers?
        if (isEmpty()) {
            throw new EmptyListException("Cannot get from empty List");
        }
        if(contains(element)) {
            return element;
        }
        return null;
    }


    @Override
    public String toString() {
        System.out.println("Hits" + "\n" + "Plz");
        Node<E> current = listPointer;
        String list = "";
        if(current==null) {
            return "";
            //catches null pointers
        }
        list+=current.getName();
        do {

            current = current.getPointer();
            //this moves current Node down the List
            if(current==null) {
                break;
            }else if(current.getName()==null) {
                continue;
            }
            list += ", " +current.getName();
            //Adds the element AKA Name to the String
        } while (current.getPointer() != null);
        return list;
    }

    @Override
    public void reset() {
        count = 0;
        listPointer = null;
    }

    @Override
    public E getNext() throws EmptyListException{
        E nextName;
        if(hasNext()) {
            nextName = next.getName();
            return nextName;
        }
        return null;
    }

    @Override
    public boolean hasNext() throws EmptyListException {
        return (next!=null);
    }
    public E getCurrent() throws EmptyListException {
        return current.getName();
    }
    public E cycleNext() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Cannot cycle through empty list");
        }
        if (next == null) {
            return null;
        }
        previous = current;
        current = next;
        next = next.getPointer();
        return current.getName();
    }
    public E cycleBack() throws EmptyListException {
        if(isEmpty()) {
            throw new EmptyListException("Cannot cycle through empty list");
        }
        if(previous==null) {
            //System.out.println("Hits at prev==null");
            return null;
        }
        Node<E> last;
        last=listPointer;
        current = previous;
        next = previous.getPointer();
        if(last==current) {
            previous=null;
            return current.getName();

            }
        while(last!=previous.getPointer()) {
            if(last.getPointer()==previous) {
                previous = last;
                //System.out.println("Next name " +next.getName());
                return current.getName();
            }
            last = last.getPointer();
        }
        //System.out.println("Next name " +next.getName());
        previous = null;
        return current.getName();
    }
    public E cycleStart() throws EmptyListException{
        if(isEmpty()) {
            throw new EmptyListException("Cannot cycle to start of empty list");
        }
        previous=null;
        current=listPointer;
        next=current.getPointer();
        return listPointer.getName();
    }
    public Node<E> getListPointer() {
        return listPointer;
    }
    public void setCurrent(Node<E> next) throws TypeMismatchException {
        this.current = next;
    }
    public void setNext(Node<E> next) throws TypeMismatchException{
        this.next = next;
    }
    public void setPrevious(Node<E> previous) throws TypeMismatchException{
        this.previous = previous;
    }
}
