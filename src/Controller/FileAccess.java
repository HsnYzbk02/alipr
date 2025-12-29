package Controller;

import Model.Admin;
import Model.Book;
import Model.IssuedBook;
import Model.Librarian;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileAccess {
    private String dataPath;

    public FileAccess() {
        this.dataPath = "data/";
        createDataDirectory();
    }

    private void createDataDirectory() {
        File dir = new File(dataPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    // Initialize all data files
    public void loadData() {
        File adminFile = new File(dataPath + "admin.txt");
        if (!adminFile.exists()) {
            try {
                adminFile.createNewFile();
                saveAdmin(new Admin("admin", "admin123", "Administrator"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        createFileIfNotExists(dataPath + "librarians.txt");
        createFileIfNotExists(dataPath + "books.txt");
        createFileIfNotExists(dataPath + "issuedBooks.txt");
    }

    private void createFileIfNotExists(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveAdmin(Admin admin) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(dataPath + "admin.txt"))) {
            pw.println(admin.getUsername() + "," + admin.getPassword() + "," + admin.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Admin loadAdmin() {
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath + "admin.txt"))) {
            String line = br.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                return new Admin(parts[0], parts[1], parts[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveLibrarians(List<Librarian> librarians) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(dataPath + "librarians.txt"))) {
            for (Librarian lib : librarians) {
                pw.println(lib.getLibrarianId() + "," + lib.getUsername() + "," +
                        lib.getPassword() + "," + lib.getName() + "," +
                        lib.getEmail() + "," + lib.getPhone());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Librarian> loadLibrarians() {
        List<Librarian> librarians = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath + "librarians.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                librarians.add(new Librarian(parts[0], parts[1], parts[2],
                        parts[3], parts[4], parts[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return librarians;
    }

    public void saveBooks(List<Book> books) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(dataPath + "books.txt"))) {
            for (Book book : books) {
                pw.println(book.getBookNumber() + "," + book.getBookName() + "," +
                        book.getAuthor() + "," + book.getPublisher() + "," +
                        book.getQuantity() + "," + book.getIssued());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath + "books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                books.add(new Book(parts[0], parts[1], parts[2], parts[3],
                        Integer.parseInt(parts[4]), Integer.parseInt(parts[5])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

  public void saveIssuedBooks(List<IssuedBook> issuedBooks) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(dataPath + "issuedBooks.txt"))) {
        for (IssuedBook ib : issuedBooks) {
            pw.println(
                ib.getBookNumber() + "," +
                ib.getBookName() + "," +
                ib.getLibrarianId() + "," +
                ib.getLibrarianName() + "," +
                ib.getIssueDate() + "," +
                ib.getReturnDate()
            );
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public List<IssuedBook> loadIssuedBooks() {
    List<IssuedBook> issuedBooks = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(dataPath + "issuedBooks.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            issuedBooks.add(new IssuedBook(
                    parts[0], parts[1],
                    parts[2], parts[3],
                    LocalDate.parse(parts[4]),
                    LocalDate.parse(parts[5])
            ));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return issuedBooks;
}

}
