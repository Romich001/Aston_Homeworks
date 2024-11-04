package task3;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public int length() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return getNodeByIndex(index).value;

    }

    private Node<T> getNodeByIndex(int index) {
        var currentNode = head;
        var currentIndex = 0;
        while (currentIndex != index) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode;
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


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (head != null) {
            var current = head;
            while (true) {
                str.append(current.value.toString());
                str.append(" ");
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
        }
        return "[" + str.toString().trim() + "]";
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
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

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private class MyIterator implements Iterator<T> {

        private int pointer = 0;

        @Override
        public boolean hasNext() {
            return getNodeByIndex(pointer) != null;
        }

        @Override
        public T next() {
            return get(pointer++);
        }

    }
}
