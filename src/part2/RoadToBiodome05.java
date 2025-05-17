public class RoadToBiodome05 {

    // 퀵 정렬 함수
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivot = arr[(left + right) / 2];  // 가운데 값을 피벗으로 선택
        int index = partition(arr, left, right, pivot);

        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    // 분할 함수 (partition)
    public static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

            if (left <= right) {
                // swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("입력값이 없습니다. 두 개의 배열을 공백으로 구분하여 입력해주세요.");
            return;
        }

        // 두 배열의 입력을 구분하기 위해 "splitIndex"를 찾아 분할
        int splitIndex = -1;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("|")) {
                splitIndex = i;
                break;
            }
        }

        if (splitIndex == -1) {
            System.out.println("입력 형식이 잘못되었습니다. 두 배열 사이에 구분 기호 '|'를 사용해주세요.");
            return;
        }

        // 첫 번째 배열
        int[] arr1 = new int[splitIndex];
        for (int i = 0; i < splitIndex; i++) {
            try {
                int val = Integer.parseInt(args[i]);
                if (val < 0) throw new NumberFormatException();
                arr1[i] = val;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력이 있습니다. 물 높이는 0 이상의 정수여야 합니다.");
                return;
            }
        }

        // 두 번째 배열
        int[] arr2 = new int[args.length - splitIndex - 1];
        for (int i = splitIndex + 1, j = 0; i < args.length; i++, j++) {
            try {
                int val = Integer.parseInt(args[i]);
                if (val < 0) throw new NumberFormatException();
                arr2[j] = val;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력이 있습니다. 물 높이는 0 이상의 정수여야 합니다.");
                return;
            }
        }

        // 두 배열을 합치기
        int[] merged = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) merged[i] = arr1[i];
        for (int i = 0; i < arr2.length; i++) merged[arr1.length + i] = arr2[i];

        // 정렬
        quickSort(merged, 0, merged.length - 1);

        // 출력
        System.out.print("[");
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i]);
            if (i != merged.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}

