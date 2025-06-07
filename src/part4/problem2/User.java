import java.util.ArrayList;
import java.util.List;

abstract class User {
    public String userId;
    public String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    protected List<Book> borrowedBooks = new ArrayList<>();

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // 필드 → 메서드를 통한 간접 접근으로 변경
    public void borrowBook(Book book) {
        if(!book.isBorrowed()) {
            book.setBorrowed(true);
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        if(book.isBorrowed()) {
            book.setBorrowed(false);
            borrowedBooks.remove(book);
        }
    }

    abstract void addBook(Book book, Library library);
    abstract void removeBook(Book book, Library library);

}