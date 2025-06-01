// Animal 클래스 : Organism을 상속받고 동물의 특징 추가하는 클래스
public class Animal extends Organism {
    private String digestion; // 소화방식
    private String food;      // 먹이

    // 생성자 : 이름, 서식지, 소화방식, 먹이를 받아 초기화
    public Animal(String name, String habitat, String digestion, String food) {
        super(name, "동물", habitat); // 부모클래스 Organism의 생성자 호출
        this.digestion = digestion;
        this.food = food;
    }

    // getter
    public String getDigestion() { return digestion; }
    public String getFood() { return food; }

    // 부모의 displayInfo를 Override
    @Override
    public void displayInfo() {
        System.out.println(getName() + ", " + getSpecies() + ", " + getHabitat() + ", " + digestion + ", " + food);
    }
}
