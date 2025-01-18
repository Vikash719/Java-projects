package service;

import pojo.Book;
import repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Constructor to initialize BookRepository
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter to allow repository changes if needed
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Add Book
    public void addBook(String id, String title, String author, String isbn, int publicationYear, boolean isAvailable) {
        Book book = new Book(id, title, author, isbn, publicationYear, isAvailable);
        bookRepository.saveBook(book);
    }

    // Get Book Details
    public String getBookDetails(String id) {
        Book book = bookRepository.getBookById(id);
        return (book != null) ? book.toString() : "Book not found";
    }

    // Remove Book
    public void removeBook(String id) {
        Book book = bookRepository.getBookById(id);
        if (book != null) {
            bookRepository.deleteBook(id);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
}
