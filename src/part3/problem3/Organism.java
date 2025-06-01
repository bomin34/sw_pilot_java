// Organism 클래스 : 동식물 공통 특징(이름, 종, 서식지)을 정의한 클래스
public class Organism {
    // 이름, 종, 서식지 정보를 저장하는 변수들
    private String name;
    private String species;
    private String habitat;

    // 생성자 : 객체 생성 시 초기화
    public Organism(String name, String species, String habitat) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
    }

    // 정보를 외부에서 볼 수 있게 하는 메서드 → getter
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public String getHabitat() { return habitat; }

    // 정보를 출력하는 메서드 (나중에 Animal, Plant에서 이 메서드를 덮어씌움)
    public void displayInfo() {
        System.out.println(name + ", " + species + ", " + habitat);
    }
}
