package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyLinkedListTest {

    MyLinkedList<Integer> list;

    @BeforeEach
    void setUpList() {
        list = new MyLinkedList<>();
    }

    @Test
    @DisplayName("Test length() method")
    void length() {
        assertEquals(0, list.length());
        list.add(1);
        assertEquals(1, list.length());
        list.add(1);
        assertEquals(2, list.length());
        list.removeLast();
        assertEquals(1, list.length());
        list.removeLast();
        assertEquals(0, list.length());

    }

    @Test
    void addAll(){
        list.addAll(List.of(1, 2, 3));
        assertEquals(3, list.length());
        assertEquals("[1 2 3]", list.toString());
    }

    @Test
    void remove() {
        list.add(1);
        list.remove(0);
        assertEquals(0, list.length());
        list.add(1);
        list.add(1);
        list.add(1);
        list.remove(1);
        assertEquals(2, list.length());
    }


    @Test
    void removeLast() {
        list.add(1);
        list.add(2);
        list.add(3);
        var removed = list.removeLast();
        assertEquals(3, removed);
        assertEquals("[1 2]", list.toString());
    }

    @Test
    void removeFirst() {
        list.add(1);
        list.add(2);
        list.add(3);
        var removed = list.removeFirst();
        assertEquals(1, removed);
        assertEquals("[2 3]", list.toString());
    }

    @Test
    void get() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    @DisplayName("test add()")
    void add() {
        list.add(1);
        assertEquals("[1]", list.toString());
        list.add(1);
        assertEquals("[1 1]", list.toString());
    }

    @Test
    @DisplayName("Print list elements")
    void testToString() {
        list.add(1);
        list.add(2);
        assertEquals("[1 2]", list.toString());
    }
}