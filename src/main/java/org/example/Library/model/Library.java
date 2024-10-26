package org.example.Library.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


//Library is the singleton class
public class Library {


    private static Library instance;

    //reading room lists id's persons that there are in the reading room
    private final Set<Long> readingRoom = new HashSet<>();

    //catalog of books. where id is key, if there is the book in the library then value is true
    //encapsulate the state of book(in library or not)
    private final Map<Book, Boolean> catalog;

    //catalog of readers info cards. Key is person id, value is ReaderInfo object
    private final Map<Long, ReaderInfo> readerInfosMap = new HashMap<>();

    //initialize the catalog in the constructor
    private Library() {
        //list of all books in library
        List<Book> bookList = List.of(
                new Book(1, "Book1", "Author1"),
                new Book(2, "Book2", "Author2"),
                new Book(3, "Book3", "Author3")
        );
        catalog = bookList.stream()
                .collect(Collectors.toMap(Function.identity(), book -> true));

    }

    //get instance of library
    public static Library getInstance() {
        if (instance == null) instance = new Library();
        return instance;
    }

    //return reader info card by person ID. Create new ReaderInfo if person is new reader.
    private ReaderInfo getReaderInfo(long personId) {
        return readerInfosMap.computeIfAbsent(personId, ReaderInfo::new);

    }


    //Inner classes
    // prevent creation of objects librarian and administrator without creating an instance of the library
    //Now I know that this is not the best way.

    //encapsulate interaction between  readers and library.
    public class Librarian {

        private final String NOT_AVAILABLE = "Book is not available";

        //uses to return of book to the library
        //change state of the book in the catalog. clean the reader info card
        public void getBook(Book book, long personId) {
            changeBookState(book, true);         //book is available for other readers
            readerInfosMap.get(personId).onHandBook = null;   //delete
            readingRoom.remove(personId);    //if person get book in reading room

        }


        //methods to lending books by book's ID or title.

        public Optional<Book> lendBookInReadingRoom(long personId, long bookId) {
            readingRoom.add(personId);
            var optionalBook = findBookById(bookId);
            optionalBook.ifPresent(book -> handleOrder(personId, book));
            return optionalBook;
        }


        public Optional<Book> lendBookBySubscription(long personId, long bookId) {
            var optionalBook = findBookById(bookId);
            optionalBook.ifPresent(book -> handleOrder(personId, book));
            return optionalBook;
        }


        public Optional<Book> lendBookInReadingRoom(long personId, String title) {
            readingRoom.add(personId);
            var optionalBook = findBookByTitle(title);
            optionalBook.ifPresent(book -> handleOrder(personId, book));
            return optionalBook;
        }


        public Optional<Book> lendBookBySubscription(long personId, String title) {
            var optionalBook = findBookByTitle(title);
            optionalBook.ifPresent(book -> handleOrder(personId, book));

            return optionalBook;
        }

        //if book is available and exist then return Optional<Book> else return empty optional
        private Optional<Book> findBookByTitle(String title) {
            var optionalBook = catalog.keySet().stream().filter(book -> book.title().equalsIgnoreCase(title)).findFirst();
            if (optionalBook.isPresent() && bookIsAvailable(optionalBook.get())) return optionalBook;
            return Optional.empty();
        }

        //if book is available and exist then return Optional<Book> else return empty optional
        private Optional<Book> findBookById(long bookId) {
            var optionalBook = catalog.keySet().stream().filter(book -> bookId == book.id()).findFirst();
            if (optionalBook.isPresent() && bookIsAvailable(optionalBook.get())) {
                return optionalBook;
            }
            return Optional.empty();
        }

        //checks if book is not available.
        private Boolean bookIsAvailable(Book book) {
            if (catalog.get(book)) return true;
            System.out.println(NOT_AVAILABLE);
            return false;
        }


        private void handleOrder(long personId, Book book) {
            var readerInfo = getReaderInfo(personId);
            readerInfo.onHandBook = book;
            changeBookState(book, false);//set in the reader info the book on the hand
            //set in the catalog of books that the book is not available;
        }

        //set true in catalog if book is available in library of false if it is not
        private void changeBookState(Book book, boolean state) {
            catalog.put(book, state);
        }

    }


    //encapsulate permissions for persons and banning readers
    public class Administrator {

        private final String DEBTOR = "You owe the library a book";
        private final String BANNED = "You are banned!";

        //return true if it is allowed to give person a book
        public boolean isPersonBanned(long personId) {
            var readerInfo = getReaderInfo(personId);
            //check if Person is banned in the library
            if (readerInfo.banned) {
                System.out.println(BANNED);
                return true;
            }
            //check if person owe the book and ban him in the library

            return false;
        }

        //check if person owe the book and ban him in the library
        public boolean isPersonDebtor(long personId) {
            var readerInfo = getReaderInfo(personId);
            if (readerInfo.onHandBook != null) {
                System.out.println(DEBTOR);
                return true;
            }
            return false;
        }

        public void banReader(long personId) {
            var readerInfo = getReaderInfo(personId);
            readerInfo.banned = true;
        }
    }


    private static class ReaderInfo {

        private final long personId;
        private Book onHandBook;
        private boolean banned;

        public ReaderInfo(long personId) {
            this.personId = personId;
            banned = false;

        }


    }

}
