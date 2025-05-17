import java.util.ArrayList;

public class RoadToBiodome01 {
    public static void main(String[] args) {

        // 입력이 없을 경우
        if (args.length == 0) {
            System.out.println("입력된 값이 없습니다. 숫자를 입력해주세요.");
            return;
        }

        ArrayList<Integer> numbers = new ArrayList<>();

        // 입력값 검사 및 리스트에 저장
        for (String arg : args) {
            int value;
            try {
                value = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                System.out.println("입력된 값이 숫자가 아닙니다.");
                return;
            }

            // 범위 검사
            if (value < 0 || value > 1000) {
                System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
                return;
            }

            numbers.add(value);
        }

        // 등장 횟수 세기
        int[] count = new int[1001]; // 0 ~ 1000, HashMap, HeatSet 사용금지

        for (int num : numbers) {
            count[num]++;
        }

        // 한 번만 등장한 숫자 찾기
        for (int num : numbers) {
            if (count[num] == 1) {
                System.out.println(num);
            }
        }
    }
}
