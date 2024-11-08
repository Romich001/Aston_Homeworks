package task3;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    private boolean isSort = false;

    public MyLinkedList() {
    }

    public MyLinkedList(Collection<? extends T> collection) {
        this.addAll(collection);
    }

    public int length() {
        return size;
    }

    //remove data by index and return value
    public T remove(int index) {
        validateIndex(index);//throw Exception if index out of bounds
        var node = getNodeByIndex(index);       //get the desired element
        return removeNode(node);
    }


    //    bubble sort with comparator
    public void sort(Comparator<? super T> comparator) {
        if (size == 0 || size == 1 || isSort) return;  //checks if list is empty or have one element
        for (int j = 1; j < size; j++) {
            var current = head;
            var next = head.next;
            for (int i = 0; i < size - j; i++) {
                if (comparator.compare(current.value, next.value) > 0) {
                    var temp = current.value;
                    current.value = next.value;
                    next.value = temp;
                }
                current = next;
                next = current.next;
            }
        }
        isSort = true;    //set isSort value to true

    }

    //    sort in natural oder
    public void sort() {
        sort(Comparator.naturalOrder());
    }

    //remove node
    private T removeNode(Node<T> node) {
        var prevNode = node.previous;           //change previous element's link to previous link from the node
        var nextNode = node.next;           //change next element's link to prev
        if (prevNode == null && nextNode != null) {    //case when node is a head and not a single element.
            nextNode.previous = null;
            head = nextNode;
        } else if (nextNode == null && prevNode != null) {   //case when node is tail and not a single element
            prevNode.next = null;
            tail = prevNode;
        } else if (nextNode == null) {  //case when node is only element
            tail = null;
            head = null;
        } else {                        //case when node is in a middle of list
            //rewrite links in next node and previous elements to each other
            nextNode.previous = prevNode;
            prevNode.next = nextNode;
        }
        size--;          //decrement size of list;
        return node.value;
    }

    //    remove last element in the list and return its value
    public T removeLast() {
        var node = getNodeByIndex(size - 1);
        return removeNode(node);
    }

    //    remove first element in the list and return its value
    public T removeFirst() {
        var node = getNodeByIndex(0);
        return removeNode(node);
    }

    //get element by index
    public T get(int index) {
        validateIndex(index);       //throw Exception if index out of bounds
        return getNodeByIndex(index).value;

    }

    //throw Exception if index is out of bounds
    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
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


    //    add all elements to MyLinkedList object.
    public void addAll(Collection<? extends T> collection) {
        collection.forEach(this::add);
    }

    //    add element to the list in last position.
    public void add(T item) {
        isSort = false;       //list is not sorted after adding new element
        var current = new Node<>(item);
        if (head == null) {      //initialize first item of MyLinkedList
            head = current;
            tail = current;
            size++;                //increase count of Nodes
            return;
        }
        current.previous = tail;     //set previous to new element
        tail.next = current;          //set next field to tail element, now the myLinkedList obj includes new element
        tail = current;                 //set new element as last
        size++;                         // increase count of Nodes
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (head != null) {
            var current = head;
            while (true) {
                str.append(current);
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

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private class MyIterator implements Iterator<T> {

        private Node<T> node = head;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T value = node.value;
            node = node.next;
            return value;
        }

    }
}
