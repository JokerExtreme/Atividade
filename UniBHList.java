public class UniBHList<T> {
    private Node<T> firstNode;
    private int totalElements;

    public void insertAtBeginning(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(firstNode);
        firstNode = newNode;
        totalElements++;
    }

    public Node<T> removeAtBeginning() {
        if (firstNode == null) {
            throw new IllegalStateException("A lista está vazia.");
        }
        Node<T> aux = firstNode;
        firstNode = firstNode.getNext();
        totalElements--;
        return aux;
    }

    public boolean isEmpty() {
        return totalElements == 0;
    }

    public int size() {
        return totalElements;
    }

    public boolean search(T value) {
        Node<T> current = firstNode;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void removeByValue(T value) {
        if (firstNode == null) {
            throw new IllegalStateException("A lista está vazia.");
        }

        if (firstNode.getValue().equals(value)) {
            firstNode = firstNode.getNext();
            totalElements--;
            return;
        }

        Node<T> current = firstNode;
        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(value)) {
                current.setNext(current.getNext().getNext());
                totalElements--;
                return;
            }
            current = current.getNext();
        }

        throw new IllegalArgumentException("O valor não está presente na lista.");
    }

    public void insertAfter(int index, T value) {
        if (index < 0 || index >= totalElements) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }

        Node<T> current = firstNode;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        Node<T> newNode = new Node<>(value);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        totalElements++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= totalElements) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }

        if (index == 0) {
            firstNode = firstNode.getNext();
            totalElements--;
            return;
        }

        Node<T> current = firstNode;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
        totalElements--;
    }

    public void updateElement(T oldValue, T newValue) {
        Node<T> current = firstNode;
        while (current != null) {
            if (current.getValue().equals(oldValue)) {
                current.setValue(newValue);
                return;
            }
            current = current.getNext();
        }
        throw new IllegalArgumentException("Elemento não encontrado na lista.");
    }

    @Override
    public String toString() {
        if (this.totalElements == 0) {
            return "[ ]";
        }

        Node<T> currentNode = firstNode;
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalElements; i++) {
            builder.append(currentNode.getValue());
            if (i < totalElements - 1) {
                builder.append(", ");
            }
            currentNode = currentNode.getNext();
        }

        builder.append("]");
        return builder.toString();
    }
}
