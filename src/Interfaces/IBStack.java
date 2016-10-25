package Interfaces;

/**
 * Created by lytte on 9/24/2016.
 */
public interface IBStack<E> {
    public void Push(E e);
    public E Pop();
    public E top();
    public boolean isEmpty();
    public int size();
    public String toString();
}
