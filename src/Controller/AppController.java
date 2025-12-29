package Controller;

import Model.Admin;
import Model.Librarian;

public class AppController {
    private FileAccess fileAccess;
    private BookController bookController;
    private LibrarianController librarianController;

    public AppController() {
        this.fileAccess = new FileAccess();
        this.bookController = new BookController(fileAccess);
        this.librarianController = new LibrarianController(fileAccess);
        fileAccess.loadData();
    }

    public boolean authenticateAdmin(String username, String password) {
        Admin admin = fileAccess.loadAdmin();
        if (admin != null) {
            return admin.getUsername().equals(username) &&
                   admin.getPassword().equals(password);
        }
        return false;
    }

    public Librarian authenticateLibrarian(String username, String password) {
        for (Librarian librarian : fileAccess.loadLibrarians()) {
            if (librarian.getUsername().equals(username) &&
                librarian.getPassword().equals(password)) {
                return librarian;
            }
        }
        return null;
    }

    public FileAccess getFileAccess() {
        return fileAccess;
    }

    public BookController getBookController() {
        return bookController;
    }

    public LibrarianController getLibrarianController() {
        return librarianController;
    }
}
