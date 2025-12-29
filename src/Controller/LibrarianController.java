package Controller;

import Model.Librarian;

import java.util.ArrayList;
import java.util.List;

public class LibrarianController {
    private FileAccess fileAccess;

    public LibrarianController(FileAccess fileAccess) {
        this.fileAccess = fileAccess;
    }

    public boolean addLibrarian(Librarian librarian) {
        List<Librarian> librarians = fileAccess.loadLibrarians();

        for (Librarian lib : librarians) {
            if (lib.getLibrarianId().equals(librarian.getLibrarianId()) ||
                lib.getUsername().equals(librarian.getUsername())) {
                return false;
            }
        }

        librarians.add(librarian);
        fileAccess.saveLibrarians(librarians);
        return true;
    }

    public boolean deleteLibrarian(String librarianId) {
        List<Librarian> librarians = fileAccess.loadLibrarians();
        boolean removed = librarians.removeIf(lib -> lib.getLibrarianId().equals(librarianId));

        if (removed) {
            fileAccess.saveLibrarians(librarians);
        }
        return removed;
    }

    public List<Librarian> getAllLibrarians() {
        return fileAccess.loadLibrarians();
    }

    public Librarian getLibrarianById(String librarianId) {
        List<Librarian> librarians = fileAccess.loadLibrarians();
        for (Librarian lib : librarians) {
            if (lib.getLibrarianId().equals(librarianId)) {
                return lib;
            }
        }
        return null;
    }

    public Librarian getLibrarianByUsername(String username) {
        List<Librarian> librarians = fileAccess.loadLibrarians();
        for (Librarian lib : librarians) {
            if (lib.getUsername().equals(username)) {
                return lib;
            }
        }
        return null;
    }

    public boolean updateLibrarian(String librarianId, Librarian updatedLibrarian) {
        List<Librarian> librarians = fileAccess.loadLibrarians();

        for (int i = 0; i < librarians.size(); i++) {
            if (librarians.get(i).getLibrarianId().equals(librarianId)) {
                librarians.set(i, updatedLibrarian);
                fileAccess.saveLibrarians(librarians);
                return true;
            }
        }
        return false;
    }

    public List<Librarian> searchLibrariansByName(String name) {
        List<Librarian> librarians = fileAccess.loadLibrarians();
        List<Librarian> results = new ArrayList<>();

        for (Librarian lib : librarians) {
            if (lib.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(lib);
            }
        }
        return results;
    }

    public boolean validateCredentials(String username, String password) {
        List<Librarian> librarians = fileAccess.loadLibrarians();
        for (Librarian lib : librarians) {
            if (lib.getUsername().equals(username) &&
                lib.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean changePassword(String librarianId, String oldPassword, String newPassword) {
        List<Librarian> librarians = fileAccess.loadLibrarians();

        for (int i = 0; i < librarians.size(); i++) {
            Librarian lib = librarians.get(i);
            if (lib.getLibrarianId().equals(librarianId) &&
                lib.getPassword().equals(oldPassword)) {
                lib.setPassword(newPassword);
                librarians.set(i, lib);
                fileAccess.saveLibrarians(librarians);
                return true;
            }
        }
        return false;
    }

    public int getLibrarianCount() {
        return fileAccess.loadLibrarians().size();
    }
}
