package org.example.Library.logic;

import org.example.Library.model.Book;
import org.example.Library.model.Library;
import org.example.Library.model.Library.Librarian;
import org.example.Library.model.Person;
import org.example.Library.model.Library.Administrator;

import java.util.Optional;

public class LibraryUtil {

    private static final Library library = Library.getInstance();
    private static final Librarian librarian = library.new Librarian();
    private static final Administrator administrator = library.new Administrator();


    //
    public static void getBookOnSubscription(Person person, long id) {
        long personId = person.getId();
        if (personIsOffender(personId)) return;
        var optionBook = librarian.lendBookBySubscription(personId, id);
        optionBook.ifPresent(person::addBook);
    }

    public static void getBookInReadingRoom(Person person, long id) {
        long personId = person.getId();
        if (personIsOffender(personId)) return;
        var optionBook = librarian.lendBookInReadingRoom(personId, id);
        optionBook.ifPresent(person::addBook);
    }

    public static void getBookInReadingRoom(Person person, String title) {
        long personId = person.getId();
        if (personIsOffender(personId)) return;
        var optionBook = librarian.lendBookInReadingRoom(personId, title);
        optionBook.ifPresent(person::addBook);
    }

    public static void getBookOnSubscription(Person person, String title) {
        long personId = person.getId();
        if (personIsOffender(personId)) return;
        var optionBook = librarian.lendBookBySubscription(personId, title);
        optionBook.ifPresent(person::addBook);
    }

    private static boolean personIsOffender(long personId) {
        if (administrator.isPersonBanned(personId)) return true;
        if (administrator.isPersonDebtor(personId)) {
            administrator.banReader(personId);
            return true;
        }
        return false;
    }


    //
    public static void returnBook(Person person) {
        String NO_BOOK = "Where is the book?";

        Optional<Book> optionalBook = person.takeOutBook();
        if (optionalBook.isEmpty()) {
            System.out.println(NO_BOOK);
            return;
        }
        librarian.getBook(optionalBook.get(), person.getId());
    }
}
