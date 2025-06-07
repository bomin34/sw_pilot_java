public class Book {
    // 책 정보
    public String isbn;
    public String title;
    public String author;
    // isBorrowed는 true면 대출 중
    private boolean isBorrowed;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    // 직접 필드로 접근한 부분 변경
    public boolean isBorrowed() {
        return isBorrowed;
    }

    // setBorrowed는 true면 대출 처리 → 대출 중으로 바꾸는 것
    public void setBorrowed(boolean borrowed) {
        this.isBorrowed = borrowed;
    }

    public void printInfo() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Borrowed: " + (isBorrowed ? "대출 불가" : "대출 가능"));
    }
}

