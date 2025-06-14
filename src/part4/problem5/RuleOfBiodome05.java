// 파일명: RuleOfBiodome05.java
public class RuleOfBiodome05 {
    public static void main(String[] args) {
        PlantHashMap<String, String> map = new PlantHashMap<>();

        // 식물 데이터 추가
        map.put("장미", "장미는 관상용으로 많이 재배되는 화초 중 하나이다.");
        map.put("해바라기", "해바라기는 태양을 따라 움직이는 것으로 알려져 있다.");
        map.put("민들레", "민들레는 약용으로도 사용되는 풀이다.");

        // 검색
        map.get("장미");
        map.get("해바라기");

        // 삭제
        map.remove("민들레");

        // 인덱스 출력
        System.out.println("'장미' 인덱스 : " + map.getIndex("장미"));
        System.out.println("'해바라기' 인덱스 : " + map.getIndex("해바라기"));
    }
}
