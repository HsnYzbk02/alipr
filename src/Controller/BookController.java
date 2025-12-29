package Controller;

import Model.Book;
import Model.IssuedBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookController {
    private FileAccess fileAccess;
    private List<IssuedBook> issuedBooks;

    public BookController(FileAccess fileAccess) {
        this.fileAccess = fileAccess;
        this.issuedBooks = fileAccess.loadIssuedBooks();
    }

    public boolean addBook(Book book) {
        List<Book> books = fileAccess.loadBooks();

        for (Book b : books) {
            if (b.getBookNumber().equals(book.getBookNumber())) {
                return false;
            }
        }

        books.add(book);
        fileAccess.saveBooks(books);
        return true;
    }

    public boolean deleteBook(String bookNumber) {
        List<Book> books = fileAccess.loadBooks();
        boolean removed = books.removeIf(b -> b.getBookNumber().equals(bookNumber));
        if (removed) {
            fileAccess.saveBooks(books);
        }
        return removed;
    }

    public List<Book> getAllBooks() {
        return fileAccess.loadBooks();
    }

    public Book getBookByNumber(String bookNumber) {
        List<Book> books = fileAccess.loadBooks();
        for (Book book : books) {
            if (book.getBookNumber().equals(bookNumber)) {
                return book;
            }
        }
        return null;
    }

 public boolean issueBook(String bookNumber,
                         String librarianName,
                         String librarianId,
                         LocalDate issueDate) {

    List<Book> books = fileAccess.loadBooks();
    Book book = null;

    for (Book b : books) {
        if (b.getBookNumber().equals(bookNumber)) {
            book = b;
            break;
        }
    }

    if (book == null) return false;
    if (book.getQuantity() <= book.getIssued()) return false;

    book.setIssued(book.getIssued() + 1);
    fileAccess.saveBooks(books);

    LocalDate returnDate = issueDate.plusDays(14);

    IssuedBook issuedBook = new IssuedBook(
            bookNumber,
            book.getBookName(),
            librarianId,
            librarianName,
            issueDate,
            returnDate
    );

    issuedBooks.add(issuedBook);
    fileAccess.saveIssuedBooks(issuedBooks);

    return true;
}

public boolean returnBook(String bookNumber, String librarianId, LocalDate returnDate) {
    IssuedBook issuedBook = null;

    for (IssuedBook ib : issuedBooks) {
        if (ib.getBookNumber().equals(bookNumber) &&
            ib.getLibrarianId().equals(librarianId)) {
            issuedBook = ib;
            break;
        }
    }

    if (issuedBook == null) return false;

    List<Book> books = fileAccess.loadBooks();
    for (Book book : books) {
        if (book.getBookNumber().equals(bookNumber)) {
            book.setIssued(book.getIssued() - 1);
            break;
        }
    }

    fileAccess.saveBooks(books);

    issuedBooks.remove(issuedBook);
    fileAccess.saveIssuedBooks(issuedBooks);

    return true;
}


    public List<IssuedBook> getAllIssuedBooks() {
        return new ArrayList<>(issuedBooks);
    }

    public List<IssuedBook> getActiveIssuedBooks() {
        return new ArrayList<>(issuedBooks);
    }

    public List<Book> searchBooksByName(String bookName) {
        List<Book> books = fileAccess.loadBooks();
        List<Book> results = new ArrayList<>();

        for (Book book : books) {
            if (book.getBookName().toLowerCase().contains(bookName.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchBooksByAuthor(String author) {
        List<Book> books = fileAccess.loadBooks();
        List<Book> results = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public boolean updateBook(String bookNumber, Book updatedBook) {
        List<Book> books = fileAccess.loadBooks();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookNumber().equals(bookNumber)) {
                books.set(i, updatedBook);
                fileAccess.saveBooks(books);
                return true;
            }
        }
        return false;
    }
}
