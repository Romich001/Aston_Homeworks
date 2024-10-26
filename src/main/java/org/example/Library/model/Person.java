package org.example.Library.model;

import java.util.Objects;
import java.util.Optional;

public class Person {
    private static long count = 0L;

    private final long id;
    private final String name;
    private final Book[] books;

    public Person(String name) {
        this.name = name;
        this.books = new Book[1];   //Person may have only one book from library, but array will allow to upgrade this number;
        id = ++count;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Book[] getBooks() {
        return books;
    }


    //take out the book
    public Optional<Book> takeOutBook() {
        Optional<Book> optionalBook = Optional.ofNullable(books[0]);
        books[0] = null;
        return optionalBook;
    }

    public void addBook(Book book) {
        books[0] = book;
    }

    @Override
    public String toString() {
        return String.format("Hi, my name is %s. I'm reading %s", name, books[0].title());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
