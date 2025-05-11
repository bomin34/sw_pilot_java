public class HelloBiodome04 {

    // 상수 지정
    static final double PI = 3.14;

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("값 3개를 모두 입력해야 합니다. 다시 시도하세요.");
            return;
        }

        // 온도, 습도, 산소 농도 값을 저장할 변수
        double temp = 0;
        double hum = 0;
        double oxy = 0;

        // 형 변환
        try {
            temp = Double.parseDouble(args[0]);
            hum = Double.parseDouble(args[1]);
            oxy = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {

            // 숫자가 아닌 입력이 들어온 경우
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");
            return;
        }

        // 범위 확인
        boolean temp1 = (temp >= 10 && temp < 27.5);
        boolean hum1 = (hum >= 40 && hum < 60);
        boolean oxy1 = (oxy >= 19.5 && oxy < 23.5);

        if (temp1 && hum1 && oxy1) {
            System.out.println("생명의 나무는 안정적인 상태입니다.");
        } else {
            if (!temp1) {
                System.out.println("온도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
            } else if (!hum1) {
                System.out.println("습도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
            } else if (!oxy1) {
                System.out.println("산소 농도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
            }
        }
    }
}