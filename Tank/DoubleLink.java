package Tank;
public class DoubleLink<T> {
    private Node<T> head;
    private int size;
    public DoubleLink(){
        size = 0;
    }
    public void add(T value){
        if (head == null){
            head = new Node<T>(value);
        }else if(head.next == null){
            head.next = new Node<T>(value);
            head.next.previous = head;
        }else{
            Node<T> current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = new Node<T>(value);
            current.next.previous = current;
        }
        size++;
    }
    public T up(){
        if (head.next == null)
            return null;
        head = head.next;
        return head.value;
    }
    
    public T down(){
        if (head.previous == null)
            return null;
        head = head.previous;
        return head.value;
    }

    public void delete(){
        if (head.next == null && head.previous == null){
            head = null;
            size--;
            return;
        }
        if (head.next == null){
            head = head.previous;
            head.next = null;
        }else if (head.previous == null){
            head = head.next;
            head.previous = null;
        }else{
            head.previous.next = head.next;
            head.next.previous = head.previous;
        }
        size--;
    }
    public T get(){
        if (head != null)
            return head.value;
        return null;
    }

    public void delete(T value){
        Node<T> current = head;
        if (head == null)
            return;
        while(current.previous != null){
            current = current.previous;
            if (current.value == value){
                head = current;
                this.delete();
                return;
            }
        }
        while (current != null) {
            if (current.value == value){
                head = current;
                this.delete();
                return;
            }
            current = current.next;
        }

    }
    public int getsize(){
        return size;
    }
    public T[] toArray() {
        // Create an array of type T with the same size as the list
        T[] array = (T[]) new Object[size];
        // Traverse the list from head to tail
        Node<T> current = head;
        if (head == null)
            return array;
        while(current.previous != null){
            current = current.previous;
        }
        int index = 0;
        while (current != null) {
          // Copy each node's value to the corresponding index in the array
          array[index] = current.value;
          // Move to the next node and increment the index
          current = current.next;
          index++;
        }
        
        // Return the array
        return array;
      }
      
}
