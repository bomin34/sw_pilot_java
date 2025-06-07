public class RuleOfBodome02 {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = library.writeBook("0001", "Book1", "Author1");
        Book book2 = library.writeBook("0002", "Book2", "Author2");

        Member member1 = new Member("U001", "메리");
        Member member2 = new Member("U002", "만옥");
        Manager manager = new Manager("U003", "세이코");

        System.out.println("새로운 관리자 '" + manager.name + "'를 등록합니다.");
        System.out.println("새로운 이용자 '" + member1.name + "'를 등록합니다.");
        System.out.println("새로운 이용자 '" + member2.name + "'를 등록합니다.");

        library.addMember(member1);
        library.addMember(member2);
        library.addManager(manager);

        manager.addBook(new Book("B001", "자바의 구름", "제임스밥"), library);
        System.out.println("\n관리자 '" + manager.name + "'가 책을 추가합니다.: '자바의 구름', '제임스밥'");
        manager.addBook(new Book("B002", "파이썬 마스터", "한송희"), library);
        System.out.println("관리자 '" + manager.name + "'가 책을 추가합니다.: '파이썬 마스터', '한송희'");
        manager.addBook(new Book("B003", "에너지 플로우", "키네틱스"), library);
        System.out.println("관리자 '" + manager.name + "'가 책을 추가합니다.: 에너지 플로우 - 키네틱스");
        manager.addBook(new Book("B004", "화성에서의 기억", "한송희"), library);
        System.out.println("관리자 '" + manager.name + "'가 책을 추가합니다.: 화성에서의 기억 - 한송희");
        manager.addBook(new Book("B005", "야채의 비밀", "송은정"), library);
        System.out.println("관리자 '" + manager.name + "'가 책을 추가합니다.: '야채의 비밀', '송은정'");

        // System.out.println("\n이용자 '메리'가 '자바의 구름'을 대출합니다.");
        Book foundBook = library.findBookByTitle("자바의 구름");
        if (foundBook != null) {
            System.out.println("\n이용자 '" + member1.name + "'가 '" + foundBook.title + "'을(를) 대출합니다.");
            member1.borrowBook(foundBook);
            System.out.println("책을 빌립니다. : " + foundBook.title);
        } else {
            System.out.println("책을 찾을 수 없습니다.");
        }

        // 추가 책 등록
        manager.addBook(new Book("B006", "자료구조의 언덕", "황수"), library);
        System.out.println("\n관리자 '" + manager.name + "'가 책을 추가합니다.: 자료구조의 언덕 - 황수");

        manager.addBook(new Book("B007", "그곳에 가면", "한송희"), library);
        System.out.println("관리자 '" + manager.name + "'가 책을 추가합니다.: 그곳에 가면 - 한송희");

        // 대출 상태 확인
        System.out.println("\n'" + foundBook.title + "'은(는) " + (foundBook.isBorrowed() ? "대출 중입니다." : "대출 가능합니다."));

        // 반납
        member1.returnBook(foundBook);
        System.out.println("\n이용자 '" + member1.name + "'가 '" + foundBook.title + "' 을(를) 반납합니다.");

        // 관리자도 대출
        Book anotherBook = library.findBookByTitle("화성에서의 기억");
        if (anotherBook != null) {
            manager.borrowBook(anotherBook);
            System.out.println("\n관리자 '" + manager.name + "'가 '" + anotherBook.title + "' 을(를) 대출합니다.");
        }

        // 특정 저자 책 목록
        System.out.println("\n저자 '한송희'의 책 목록:");
        library.searchBookByAuthor("한송희");



        /*
        member.borrowBook(book1);
        System.out.println("책을 빌립니다: " + book1.title);
        member.returnBook(book1);
        System.out.println("책을 반납합니다: " + book1.title);
        */
    }
}