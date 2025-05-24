public class BiodomeFamily01 {
    public static void main(String[] args) {

        // 동식물 저장할 데 생성
        LifeNest lifeNest = new LifeNest();

        // 동식물 생성
        Organism penguin = new Organism("펭귄", "동물", "남극");
        Organism koala = new Organism("코알라", "동물", "호주");
        Organism cactus = new Organism("선인장", "식물", "사막");
        Organism peppermint = new Organism("페퍼민트", "식물", "정원");

        // 저장소에 추가
        lifeNest.addOrganism(penguin);
        lifeNest.addOrganism(koala);
        lifeNest.addOrganism(cactus);
        lifeNest.addOrganism(peppermint);

        // 동식물 전체 출력
        lifeNest.displayAllOrganisms();

        // 펭귄 서식지 변경
        // 아까 setter로 한 거 여기서 변경!!
        penguin.setHabitat("해변");

        // 코알라, 선인장 삭제
        lifeNest.removeOrganism(koala);
        lifeNest.removeOrganism(cactus);

        // 전체 출력
        lifeNest.displayAllOrganisms();
    }
}
