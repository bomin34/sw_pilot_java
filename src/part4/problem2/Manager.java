class Manager extends User {
    public Manager(String userId, String name) {
        super(userId, name);
    }

    public void addBook(Book book, Library library) {
        library.addBook(book);
    }
    public void removeBook(Book book, Library library) {
        library.removeBook(book);
    }
}