// 동식물 관리 클래스 : 동식물 삭제, 추가, 출력
import java.util.ArrayList;

public class LifeNest {
    //객체 저장 리스트
    private ArrayList<Organism> organismList;

    // 생성자 : LifeNest 객체를 만들 때 리스트 초기화?
    public LifeNest() {
        organismList = new ArrayList<>();
    }

    // 추가 메서드
    public void addOrganism(Organism organism) {
        // 리스트에 organism 추가
        organismList.add(organism);
        System.out.println("[LifeNest] " + organism.getName() + "이(가) 추가되었습니다.");
    }

    // 삭제 메서드
    public void removeOrganism(Organism organism) {
        if (organismList.remove(organism)) {
            System.out.println("[LifeNest] " + organism.getName() + "이(가) 삭제되었습니다.");
        } else {
            System.out.println("[LifeNest] " + organism.getName() + "을(를) 찾을 수 없습니다.");
        }
    }

    // 전체 동식물 출력
    public void displayAllOrganisms() {
        System.out.println("전체 동식물 목록 출력 : ");
        // 리스트 순회 → 각 oraganism의 정보 출력
        for (Organism o : organismList) {
            o.displayInfo();
        }
    }
}
