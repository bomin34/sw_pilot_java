public class HelloBiodome02 {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("에너지 생산량 3개를 모두 입력해야 합니다.");
            return;
        }

        // 에너지 생산량을 저장할 변수
        int solar = 0;
        int wind = 0;
        int ground = 0;

        try {
            // 문자열을 정수(int)로 변환, 여기서 Casting 발생
            solar = Integer.parseInt(args[0]);
            wind = Integer.parseInt(args[1]);
            ground = Integer.parseInt(args[2]);

            // 음수 입력 확인
            if (solar < 0 || wind < 0 || ground < 0) {
                System.out.println("생산량은 음수가 될 수 없습니다. 다시 시도하세요.");
                return;
            }

            // 최대값 확인
            if (solar > 30000 || wind < 0 || ground > 30000) {
                System.out.println("생산량은 30,000을 넘을 수 없습니다. 다시 시도하세요.");
                return;
            }

            // 총합 계산
            int total = solar + wind + ground;

            // 출력
            System.out.println("총 에너지 사용량은 " + total + "입니다.");
        } catch (NumberFormatException e) {
            // 숫자가 아닌 입력이 들어온 경우
            System.out.println("숫자만 입력해야 합니다.");
        }
    }
}
