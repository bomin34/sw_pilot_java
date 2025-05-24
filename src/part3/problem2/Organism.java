// 동식물 클래스 : 이름, 종, 서식지 정보 포함
public class Organism {
    private String name;
    private String species;
    private String habitat;

    // 정보 출력 메서드
    public String displayInfo() {
        return name + ", " + species + ", " + habitat;
    }

    // 서식지 변경 메서드
    // setter : setHabitat(), 외부에서 habitat 값 바꾸기
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    // 이름을 외부에서 가져오는 메서드
    // getter : getName(), 외부에서 name 값 가져오기
    public String getName() {
        return name;
    }

    // 생성자 선언 : 객체를 생성할 때 이름, 종, 서식지를 입력받아 초기화
    // 클래스 내부 변수에 저장
    public Organism(String name, String species, String habitat) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
    }

}