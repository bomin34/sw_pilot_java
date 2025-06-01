import java.util.ArrayList;

// LifeNest 클래스 : 동식물을 List로 저장하고 추가, 삭제, 출력을 담당하는 클래스
public class LifeNest {
    private ArrayList<Organism> organismList; // 동식물 리스트

    // 생성자 : 리스트를 초기화
    public LifeNest() {
        organismList = new ArrayList<>();
    }

    // 동식물을 리스트에 추가하고 메시지 출력
    public void addOrganism(Organism o) {
        organismList.add(o);
        System.out.println("[LifeNest] " + o.getName() + "이(가) 추가되었습니다.");
    }

    // 동식물을 리스트에서 삭제하고 메시지 출력
    public void removeOrganism(Organism o) {
        if (organismList.remove(o)) {
            System.out.println("[LifeNest] " + o.getName() + "이(가) 삭제되었습니다.");
        } else {
            System.out.println("[LifeNest] " + o.getName() + "은(는) 목록에 없습니다.");
        }
    }

    // 모든 동식물 출력
    public void displayAll() {
        System.out.println("\n전체 동식물 목록 출력:");
        for (Organism o : organismList) {
            o.displayInfo(); // 각각의 displayInfo 호출
        }
    }
}
