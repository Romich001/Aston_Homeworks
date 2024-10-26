package org.example.Library;

import org.example.Library.logic.LibraryUtil;
import org.example.Library.model.Person;

import java.util.Arrays;

public class LibraryDemo {
    public static void main(String[] args) {
        Person person = new Person("Jone");
        System.out.println(Arrays.toString(person.getBooks()));
        LibraryUtil.getBookOnSubscription(person, 1);
        System.out.println(Arrays.toString(person.getBooks()));
        LibraryUtil.returnBook(person);
        System.out.println(Arrays.toString(person.getBooks()));

        LibraryUtil.getBookOnSubscription(person, "Book1");
        System.out.println(Arrays.toString(person.getBooks()));
        LibraryUtil.returnBook(person);

        LibraryUtil.getBookInReadingRoom(person, "Book2");
        System.out.println(Arrays.toString(person.getBooks()));
        LibraryUtil.returnBook(person);

        LibraryUtil.getBookInReadingRoom(person, "Book1");
        System.out.println(Arrays.toString(person.getBooks()));
        LibraryUtil.returnBook(person);

        LibraryUtil.getBookOnSubscription(person, "Book2");
        System.out.println(Arrays.toString(person.getBooks()));
        LibraryUtil.getBookOnSubscription(person, "Book2");

        LibraryUtil.returnBook(person);
        LibraryUtil.returnBook(person);

        LibraryUtil.getBookOnSubscription(person, "Book2");
        System.out.println(Arrays.toString(person.getBooks()));
        LibraryUtil.getBookOnSubscription(person, "Book2");
    }
}