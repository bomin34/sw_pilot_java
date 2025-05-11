public class HelloBiodome03 {

    // 상수 지정
    static final double PI = 3.14;
    static final double BE = 0.415;

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("값 3개를 모두 입력해야 합니다. 다시 시도하세요.");
            return;
        }

        // 온도, 습도, 산소 농도 값을 저장할 변수
        double temp = 0;
        double hum = 0;
        double oxy = 0;
        double r_hum = 0;
        double mid = 0;
        double total;

        // 형 변환
        try {
            temp = Double.parseDouble(args[0]);
            hum = Double.parseDouble(args[1]);
            oxy = Double.parseDouble(args[2]);

            r_hum = calcSqrt(hum);
            mid = calcAbs(r_hum, temp);
            total = calcH(mid, oxy);

            // 출력
            System.out.println("생명지수 H = " + total);
        } catch (NumberFormatException e) {
            // 숫자가 아닌 입력이 들어온 경우
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");
        }

    }
    public static double calcSqrt(double hum) {
        double guess = hum;
        for (int i = 0; i < 200; i++) {
            guess = (guess + hum / guess) / 2;
        }
        return guess;
    }

    public static double calcAbs(double a, double b) {
        if (a - b < 0) {
            return (a - b) * (-1);
        } else {
            return (a - b);
        }
    }

    public static double calcH(double mid, double oxy) {
        return BE * mid + (oxy/(PI*PI));
    }
}