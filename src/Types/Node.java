package Types;

/**
 * Created by lytte on 9/26/2016.
 */
public class Node<T> {
    private Node<T> pointer;
    private T name;

    public Node(){
        pointer = null;
        name = null;
    }
    public Node(T name){
        pointer = null;
        this.name = name;
    }
    public Node(T name, Node<T> pointer){
        this.pointer = pointer;
        this.name = name;
    }

    public Node<T> getPointer() {
        return pointer;
    }

    public void setPointer(Node<T> pointer) {
        this.pointer = pointer;
    }

    public T getName() { return name; }
    public void setName(T name) {this.name = name;}
}
