package Model;

import java.time.LocalDate;

public class IssuedBook {
    private String bookNumber;
    private String bookName;

    private String librarianId;
    private String librarianName;

    private LocalDate issueDate;
    private LocalDate returnDate;

    public IssuedBook() {}

    public IssuedBook(String bookNumber, String bookName,
                      String librarianId, String librarianName,
                      LocalDate issueDate, LocalDate returnDate) {

        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.librarianId = librarianId;
        this.librarianName = librarianName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public String getBookNumber() { return bookNumber; }
    public void setBookNumber(String bookNumber) { this.bookNumber = bookNumber; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getLibrarianId() { return librarianId; }
    public void setLibrarianId(String librarianId) { this.librarianId = librarianId; }

    public String getLibrarianName() { return librarianName; }
    public void setLibrarianName(String librarianName) { this.librarianName = librarianName; }

    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    @Override
    public String toString() {
        return "IssuedBook{" +
                "bookNumber='" + bookNumber + '\'' +
                ", bookName='" + bookName + '\'' +
                ", librarianId='" + librarianId + '\'' +
                ", librarianName='" + librarianName + '\'' +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
