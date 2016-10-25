package Exceptions;

/**
 * Created by lytte on 10/11/2016.
 */
public class UninstantiatedIndexException extends Exception {
    public UninstantiatedIndexException() {
        super();
    }
    public UninstantiatedIndexException(String msg) {
        super(msg);
    }
}