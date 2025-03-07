// You can extend comparable interface,
// this enables you to check if two elements are or not equals.

public class Node<T> {
    private T value;
    private Node next;

    public Node(T valor) {
        this.value = valor;
        this.next = null;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
