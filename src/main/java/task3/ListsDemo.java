package task3;

public class ListsDemo {
    public static void main(String[] args) {
        MyLinkedList<Integer> newList = new MyLinkedList<>();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        System.out.println(newList);
        System.out.println("removed: " + newList.remove(1));
        System.out.println("Size: " + newList.length());
        System.out.println(newList);
        System.out.println("removed: " + newList.remove(1));
        System.out.println("Size: " + newList.length());
        System.out.println(newList);
        System.out.println("removed: " + newList.remove(0));
        System.out.println("Size: " + newList.length());

    }
}
