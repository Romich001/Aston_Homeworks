package task3;

public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public int length() {
        return size;
    }

    public void add(T item) {
        var current = new Node<>(item);
        if (head == null) {      //initialize first item of MyLinkedList
            head = current;
            tail = current;
            return;
        }
        current.setPrevious(tail);
        tail.setNext(current);
        tail = current;
        size++;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}
