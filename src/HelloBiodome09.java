public class HelloBiodome09 {
    public static void main(String[] args) {
        // 입력이 여러개면 프로그램 종료
        if (args.length != 1) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }

        int height = 0;

        try {
            height = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }

        if (height < 3 || height > 100) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }

        // 나무 출력
        for (int i = 0; i < height; i++) {
            // 별 개수
            int numStars = 1 + (i * 2);
            // 좌우 공백
            int numSpaces = height - i - 1;

            // 공백 출력
            for (int j = 0; j < numSpaces; j++) {
                System.out.print(" ");
            }

            // 별 출력
            for (int j = 0; j < numStars; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // 기둥 출력 (중앙 정렬)
        for (int i = 0; i < height - 1; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }
}