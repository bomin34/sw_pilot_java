import java.util.*;

public class RuleOfBiodome06 {
    public static void main(String[] args) {
        if (args.length < 20) {
            System.out.println("최소 20마리 이상의 동물 이름을 입력해주세요.");
            return;
        }

        // 객체 생성
        AnimalFrequencyAnalyzer analyzer = new AnimalFrequencyAnalyzer();
        // 동물 빈도 분석
        analyzer.analyzeFrequencies(args);

        // 가장 자주 관찰된 동물 구하기
        List<String> frequentAnimals = analyzer.getMostFrequentAnimals();
        // 전체 동물 목록(Set)을 가져옴
        Set<String> allAnimals = analyzer.getAllObservedAnimals();

        // 쉼표로 구분해서 결과 출력
        System.out.print("가장 많이 발견된 동물 : ");
        System.out.println(String.join(", ", frequentAnimals));

        System.out.print("관찰된 모든 동물 : ");
        List<String> sortedAnimals = new ArrayList<>(allAnimals);
        // 보기 좋게 정렬하는 거
        Collections.sort(sortedAnimals);
        System.out.println(String.join(", ", sortedAnimals));
    }
}
