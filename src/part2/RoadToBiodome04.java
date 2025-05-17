public class RoadToBiodome04 {

    // 선택 정렬 구현
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // 최소값 인덱스 찾기
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 스왑
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // 평균 계산
    public static double calculateAverage(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return (double) sum / arr.length;
    }

    // 중앙값 계산
    public static double calculateMedian(int[] arr) {
        int n = arr.length;
        if (n % 2 == 1) {
            // 홀수: 가운데 값
            return arr[n / 2];
        } else {
            // 짝수: 가운데 두 값의 평균
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("에너지 소비 값이 입력되지 않았습니다.");
            return;
        }

        int[] numbers = new int[args.length];

        // 입력값 변환
        for (int i = 0; i < args.length; i++) {
            try {
                numbers[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
                return;
            }
        }

        // 정렬
        selectionSort(numbers);

        // 평균, 중앙값 계산
        double average = calculateAverage(numbers);
        double median = calculateMedian(numbers);

        // 출력
        System.out.printf("평균값 : %.2f, 중앙값 : %.2f\n", average, median);
    }
}
