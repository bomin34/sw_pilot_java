public class RoadToBiodome06 {
    public static void main(String[] args) {
        // 입력 값이 2개 미만
        if (args.length < 2) {
            System.out.println("물 높이 배열 2개를 입력해주세요.");
            return;
        }

        // 배열 쉼표로 나누기
        String[] lakeStr = args[0].split(",");
        String[] riverStr = args[1].split(",");
        int n = lakeStr.length, m = riverStr.length;

        // 호수 배열 크기 n, 강 배열 크기 m을 각각 정수형 배열로 변환할 준비
        int[] lake = new int[n];
        int[] river = new int[m];

        // 입력값을 배열에 저장하고 호수 배열 하나씩 오류 검사
        try {
            for (int i = 0; i < n; i++) {
                // 문자열 정수로 변환
                lake[i] = Integer.parseInt(lakeStr[i]);
                if (lake[i] < 0) {
                    System.out.println("물 높이는 0 이상이어야 합니다.");
                    return;
                }
            }
            for (int i = 0; i < m; i++) {
                river[i] = Integer.parseInt(riverStr[i]);
                if (river[i] < 0) {
                    System.out.println("물 높이는 0 이상이어야 합니다.");
                    return;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 값이 포함되어 있습니다.");
            return;
        }

        // 계산
        double sum = 0;
        for (int x : lake) sum += x;
        for (int x : river) sum += x;
        double mean = sum / (n + m);

        // 중앙값 계산 (두 배열 정렬되어 있으니 병합 없이 중앙값)
        double median = findMedian(lake, river);

        // 출력
        System.out.printf("Mean : %.1f, Median : %.1f\n", mean, median);
    }

    // 중앙값 계산 메서드
    private static double findMedian(int[] A, int[] B) {
        // 항상 A가 더 짧게되도록 정렬 → 이진탐색효율(??)
        if (A.length > B.length) return findMedian(B, A);

        int m = A.length, n = B.length;
        int total = m + n;
        int half = (total + 1) / 2;
        int left = 0, right = m;

        // 탐색 범위 설정 후 반복
        // i는 A 배열의 중간 위치, j는 B 배열에서 중앙을 채우기 위해 필요한 개수, 전체 half를 맞추도록 A와 B를 나눔
        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;
            
            // 경계값을 설정하여 범위를 벗어나면 최소 or 최대값
            // A 배열의 왼쪽, 오른쪽 끝 값을 정함, 배열 범위를 벗어나면 최소/최대값으로 설정, 이렇게 하면 경계값 비교 시 오류를 피할 수 있음
            int Aleft = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int Aright = (i == m) ? Integer.MAX_VALUE : A[i];
            int Bleft = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int Bright = (j == n) ? Integer.MAX_VALUE : B[j];

            // 데이터 개수가 홀수면 중앙값은 왼쪽 최대값, 짝수면 중앙의 두 값의 평균
            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 1)
                    return Math.max(Aleft, Bleft);
                else
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                right = i - 1; // A의 왼쪽 최대값이 너무 크면 i를 줄여서 왼쪽으로
            } else {
                left = i + 1; // B의 왼쪽 최대값이 너무 크면 i를 늘려서 오른쪽으로
            }
        }
        return 0;
    }
}

