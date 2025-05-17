public class HelloBiodome01 {
    public static void main(String[] args) {

        // 사용자 이름
        String name;

        // 한 글자 이상 입력했는 지 확인
        if (args.length == 0 || args[0].trim().length() == 0) {
            System.out.println("이름을 1글자 이상 입력해야 합니다. 프로그램을 종료합니다.");
            return;
        }

        // 띄어쓰기 포함해서 저장
        // args : 띄어쓰기 기준으로 분리되므로 전체 이름 조합
        name = String.join(" ", args);

        // 환영 인사 출력
        System.out.println("스프링와트에 오신 걸 환영합니다. " + name + "님!");
    }
}
