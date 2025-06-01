// Plant 클래스 : Organism을 상속받아서 식물의 특징을 추가하는 클래스
public class Plant extends Organism {
    private String Season; // 개화시기
    private String Fruit;       // 열매 유무

    // 생성자 : 이름, 서식지, 개화시기, 열매 유무를 받아 초기화
    public Plant(String name, String habitat, String Season, String Fruit) {
        super(name, "식물", habitat); // 부모클래스 Organism의 생성자 호출
        this.Season = Season;
        this.Fruit = Fruit;
    }

    public String getSeason() { return Season; }
    public String getFruit() { return Fruit; }

    // Plant만의 출력 : 부모의 displayInfo를 Override
    @Override
    public void displayInfo() {
        System.out.println(getName() + ", " + getSpecies() + ", " + getHabitat() + ", " + Season + ", " + Fruit);
    }
}
