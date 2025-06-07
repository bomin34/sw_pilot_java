class Member extends User {
    public Member(String userId, String name) {
        super(userId, name);
    }

    public void addBook(Book book, Library library) {
        System.out.println("멤버는 책을 등록할 수 없습니다.");
    }
    public void removeBook(Book book, Library library) {
        System.out.println("멤버는 책을 삭제할 수 없습니다.");
    }
}
