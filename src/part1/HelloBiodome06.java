public class HelloBiodome06 {
    public static void main(String[] args) {

        // 두 개의 유전자 정보가 입력되지 않은 경우
        if (args.length != 2) {
            System.out.println("두 개의 유전자 정보를 입력해주세요.");
            return;
        }

        String gene1 = args[0];
        String gene2 = args[1];

        // 길이 범위 (5개 이상 ~ 최대 20개)
        if (gene1.length() < 5 || gene1.length() > 20 || gene2.length() < 5 || gene2.length() > 20) {
            System.out.println("유전자 코드는 최소 5글자 이상, 최대 20글자까지 가능합니다.");
            return;
        }

        // 길이 불일치
        if (gene1.length() != gene2.length()) {
            System.out.println("일치하지 않습니다.");
            return;
        }

        // 문자별 비교
        int i = 0;
        boolean isSame = true;

        while (i < gene1.length()) {
            // 두 문자열의 각 위치 i 에서의 문자를 비교, 다르면 break
            if (gene1.charAt(i) != gene2.charAt(i)) {
                isSame = false;
                break;
            }
            i++;
        }

        // 결과 출력
        if (isSame) {
            System.out.println("동일한 유전자 코드입니다.");
        } else {
            System.out.println("일치하지 않습니다.");
        }
    }
}