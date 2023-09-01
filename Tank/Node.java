package Tank;

public class Node<T> {
    public Node<T> next;
    public Node<T> previous;
    public T value;
    
    public Node(T value){
        this.value = value;
        next = previous = null;

    }
}
