public class HelloBiodome07 {
    public static String compressDNA(String input) {
        if(input == null || input.trim().isEmpty()) {
            return "염기 서열이 입력되지 않았습니다.";
        }

        // 문자열 공백 제거, 대문자 변환
        input = input.replaceAll("\\s+","").toUpperCase();

        // 문자 구성 확인
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != 'C' && ch != 'J' && ch != 'H' && ch != 'E' && ch != 'Y') {
                return "염기서열은 C, J, H, E, Y 다섯가지로만 입력됩니다. 확인하고 다시 입력해주세요";
            }
        }

        String result = "";

        // 압축
        char prev = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == prev) {
                count++;
            } else {
                result += prev + String.valueOf(count);
                prev = current;
                count = 1;
            }
        }
        // 마지막 문자 처리
        result += prev + String.valueOf(count);

        return result;
    }

    public static void main(String[] args) {
        // 사용자 입력이 있는지 확인
        if (args.length == 0) {
            System.out.println("염기서열이 입력되지 않았습니다.");
            return;
        }

        // 입력된 모든 문자열을 하나로 이어붙임
        String input = "";
        for (int i = 0; i < args.length; i++) {
            input += args[i];
        }

        // 압축 수행 및 출력
        String result = compressDNA(input);
        System.out.println(result);
    }
}
