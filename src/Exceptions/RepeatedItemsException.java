package Exceptions;

/**
 * Created by lytte on 10/10/2016.
 */
public class RepeatedItemsException extends Exception {
    public RepeatedItemsException() {
        super();
    }
    public RepeatedItemsException(String msg) {
        super(msg);
    }
}
