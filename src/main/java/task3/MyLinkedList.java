package task3;

public class MyLinkedList<T>{

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
            size++;                //increase count of Nodes
            return;
        }
        current.setPrevious(tail);     //set previous to new element
        tail.setNext(current);          //set next field to tail element, now the myLinkedList obj includes new element
        tail = current;                 //set new element as last
        size++;                         // increase count of Nodes
    }


    public void print() {

        if (head != null) {
            var current = head;
            while (true) {
                System.out.println(current.value);
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
        }
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
