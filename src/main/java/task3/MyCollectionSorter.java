package task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class MyCollectionSorter {

    // <E extends Comparable<? super E>> используя super возможно использовать родителькую реализацию Comparable
    public static <E extends Comparable<? super E>> List<E> sort(Collection<E> collection, Comparator<? super E> comparator) {
        var arr = new ArrayList<>(collection);
        System.out.println(arr);
        for (int j = 0; j < arr.size(); j++) {
            for (int i = 0; i < collection.size() - 1 - j; i++) {
                var current = arr.get(i);
                var next = arr.get(i + 1);
                if (comparator.compare(current, next) > 0) {
                    arr.set(i, next);
                    arr.set(i + 1, current);
                }
            }
        }
        return List.copyOf(arr);
    }

    public static <E extends Comparable<? super E>> List<E> sort(Collection<E> collection) {
        return sort(collection, Comparator.naturalOrder());
    }

}
