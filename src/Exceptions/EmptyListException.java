package Exceptions;

/**
 * Created by lytte on 9/30/2016.
 */
public class EmptyListException extends Exception{
    public EmptyListException() {
        super();
    }
    public EmptyListException(String msg) {
        super(msg);
    }
}
