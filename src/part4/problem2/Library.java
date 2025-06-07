import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public Book writeBook(String isbn, String title, String author) {
        Book book = new Book(isbn, title, author);
        books.add(book);
        return book;
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook(Book book) {
        books.remove(book);
    }
    public void addMember(Member member) {
        users.add(member);
    }
    public void addManager(Manager manager) {
        users.add(manager);
    }

    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("도서관에 등록된 책이 없습니다.");
            return;
        }
        for (Book book : books) {
            book.printInfo();
        }
    }

    public void printAllUsers() {
        if (users.isEmpty()) {
            System.out.println("도서관에 등록된 사용자가 없습니다.");
            return;
        }
        for (User user : users) {
            System.out.println("사용자 ID : " + user.userId + ", 이름 : " + user.name);
        }
    }

    public void searchBookByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.author.equalsIgnoreCase(author)) {
                System.out.println(book.title + ", " + (book.isBorrowed() ? "대출 불가" : "대출 가능"));
                found = true;
            }
        }
        if (!found) {
            System.out.println("해당 저자의 책이 없습니다.");
        }
    }

    public void removeBookWithCheck(Book book) {
        if (!books.contains(book)) {
            System.out.println("도서관에 존재하지 않는 책입니다.");
            return;
        }
        if (book.isBorrowed()) {
            System.out.println("대출 중인 책은 삭제할 수 없습니다.");
        } else {
            books.remove(book);
            System.out.println("책을 성공적으로 삭제했습니다.");
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

/*
도서관 기능 : 도서관의 모든 책, 모든 회원 정보를 관리한다.
- 새로운 일반 회원과 새로운 관리자를 등록할 수 있다.
- 모든 책과 회원 정보를 출력할 수 있다.
- 저자의 이름을 기반으로 책을 검색하고 대출 상태를 출력할 수 있다.
- 예외 상황이 발생하는 경우 안내 메시지를 출력한다.

아래 예외 상황을 처리하고, 사용자에게 안내 메시지를 출력한다.
- 등록되지 않은 책을 반납하는 경우
- 검색 결과 해당하는 책이 없는 경우
- 대출 중인 책을 삭제하는 경우
*/