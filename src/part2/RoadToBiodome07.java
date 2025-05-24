public class RoadToBiodome07 {
    public static void main(String[] args) {

        // 배열이 0
        if (args.length == 0) {
            System.out.println("입력된 데이터가 없습니다. 동물 이름을 입력해주세요.");
            return;
        }

        // 숫자가 포함되어 있는지 검사
        for (String s : args) {
            // 변수에 하나씩 대입하면서 요소 확인
            if (s.matches(".*\\d.*")) {
                System.out.println("입력 데이터에 숫자가 포함되어 있습니다: " + s);
                return;
            }
        }

        // 고유 동물 이름과 빈도 계산, 입력 데이터 크기과 같게 초기 데이터 크기 설정함
        String[] animals = new String[args.length];
        // 동물의 등장 빈도 저장
        int[] counts = new int[args.length];
        //현재까지의 고유 동물
        int uniqueCount = 0;

        for (int i = 0; i < args.length; i++) {
            boolean found = false;
            // animals 배열에 있는 지 확인
            for (int j = 0; j < uniqueCount; j++) {
                if (animals[j].equals(args[i])) {
                    counts[j]++;
                    found = true;
                    break;
                }
            }
            // 배열에 없으면 이름 추가
            if (!found) {
                animals[uniqueCount] = args[i];
                counts[uniqueCount] = 1;
                uniqueCount++;
            }
        }

        // 선택 정렬 사용 : 빈도 내림차순(4, 3, 2), 이름 오름차순(가나다)
        for (int i = 0; i < uniqueCount - 1; i++) {
            // 최대 빈도 동물
            int maxIdx = i;
            for (int j = i + 1; j < uniqueCount; j++) {
                // 현재 동물이 최대값보다 빈도가 크거나, 빈도는 같고 이름이 가나다순이면 maxIdx 갱신
                if (counts[j] > counts[maxIdx] ||
                        (counts[j] == counts[maxIdx] && animals[j].compareTo(animals[maxIdx]) < 0)) {
                    maxIdx = j;
                }
            }
            // swap
            int tempCount = counts[i];
            counts[i] = counts[maxIdx];
            counts[maxIdx] = tempCount;

            String tempAnimal = animals[i];
            animals[i] = animals[maxIdx];
            animals[maxIdx] = tempAnimal;
        }

        // 출력
        System.out.print("결과 : ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(animals[i]);
            // 마지막 동물이 아니라묜 쉼표 출력
            if (i < uniqueCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

/*
선택 정렬
counts[j] : j번째 동물의 관찰 빈도
counts[maxIdx] : 현재까지 최대 빈도를 가진 동물의 관찰 빈도
animals[j].compareTo(animals[macIdx]) : 문자열을 사전 순서(가나다)로 비교해주는 메서드, j번째 이름이 maxIdx번째 이름보다 앞족(가나다)이면 음수 변환
즉 이름을 비교하는 거임

counts[j] > counts[maxIdx]
j번째 동물이 관찰 빈도가 더 크면, 새로운 최대값으로 갱신
(counts[j] == counts[maxIdx] && animals[j].compareTo(animals[maxIdx]) < 0)
j번째 동물의 관찰 빈도와 현재 최대값이 같고, j번째 이름이 가나다순으로 앞쪽이면, 이름 순서로 갱신
||
둘 중 하나라도 조건을 만족하면 maxIdx를 j로 갱신

빈도 높은 동물부터 정렬, 빈도가 같으면 이름 가나다순으로 정렬을 구현한 조건
*/