package task3;

import java.util.List;

public class ListsDemo {
    public static void main(String[] args) {
        sortTest();
        addAllDemo();
        removeAllDemo();
        iterateDemo();
        System.out.println(MyCollectionSorter.sort(List.of(3, 2, 1)));


//        more tests in test.java.task3.tests

    }

    private static void iterateDemo() {
        var list = new MyLinkedList<>(List.of(1, 2, 3));

        list.forEach(System.out::println);
    }

    private static void sortTest() {
        var myList = new MyLinkedList<Integer>();
        myList.addAll(List.of(4, 3));
        myList.sort();
        System.out.println(myList);

    }

    private static void removeAllDemo() {
        var list = new MyLinkedList<Integer>(List.of(1, 2, 3));
        System.out.println("List before removing: " + list);
        list.remove(1);
        System.out.println("List after removing: " + list);

    }


    private static void addAllDemo() {
        var list = new MyLinkedList<Integer>();
        list.addAll(List.of(1, 2, 4));
        System.out.println(list);

    }
}
