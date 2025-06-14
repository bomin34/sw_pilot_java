import java.util.*;

public class AnimalFrequencyAnalyzer {

    // 동물 이름과 빈도수를 저장하는 맵
    // key : 동물이름, value : 등장 횟수
    Map<String, Integer> animalCountMap = new HashMap<>();

    // 동물 배열을 받아서 맵에 빈도수 저장
    public void analyzeFrequencies(String[] animals) {
        // 반복문을 돌면서 각 동물 이름 확인
        for (String animal : animals) {
            if (animalCountMap.containsKey(animal)) {
                animalCountMap.put(animal, animalCountMap.get(animal) + 1); // 이미 맵에 있으면 등장횟수 +1
            } else {
                animalCountMap.put(animal, 1); // 없으면 처음으로 등록하면서 등장 횟수 1로 설정
            }
        }
    }

    // 가장 많이 등장한 동물 이름 리스트 반환
    public List<String> getMostFrequentAnimals() {
        List<String> mostFrequent = new ArrayList<>();
        int maxCount = 0;

        // entrySet()을 통해 맵 안의 모든 쌍(동물, 등장횟수)을 반복해서 탐색
        // entrySet() : Map에서 모든 Entry(Key-Value 쌍)를 가져와 Set 객체로 반환한다. foreach 루프를 사용하여 각 Entry에 순차적으로 접근할 수 있다.
        // 등장횟수가 가장 높은 동물을 리스트에 담아 반환 (여러 동물이 똑같이 자주 등장할 수도 있어 List로 반환)
        for (Map.Entry<String, Integer> entry : animalCountMap.entrySet()) {
            int count = entry.getValue();
            if (count > maxCount) {
                // 더 큰 빈도 발견 → 초기화
                mostFrequent.clear();
                mostFrequent.add(entry.getKey());
                maxCount = count;
            } else if (count == maxCount) {
                // 같은 빈도 → 추가
                mostFrequent.add(entry.getKey());
            }
        }

        return mostFrequent;
    }

    // 관찰된 모든 동물의 목록 반환 (Set 활용)
    // Set은 중복을 허용하지 않아서 사용
    // HashSet으로 만들어서 반환
    public Set<String> getAllObservedAnimals() {
        return new HashSet<>(animalCountMap.keySet());
    }
}
