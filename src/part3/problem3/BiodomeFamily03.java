// BiodomeFamily03 : 메인 클래스
public class BiodomeFamily03 {
    public static void main(String[] args) {
        // LifeNest 객체 생성 (동식물 저장하는 곳)
        LifeNest nest = new LifeNest();

        // 동물 생성
        Animal penguin = new Animal("펭귄", "남극", "육식", "물고기");
        Animal koala = new Animal("코알라", "호주", "초식", "유칼립투스");
        // 식물 생성
        Plant cactus = new Plant("선인장", "사막", "11월", "열매 있음");
        Plant peppermint = new Plant("페퍼민트", "정원", "7월", "열매 없음");

        // 동식물 추가
        nest.addOrganism(penguin);
        nest.addOrganism(koala);
        nest.addOrganism(cactus);
        nest.addOrganism(peppermint);

        // 전체 출력
        nest.displayAll();

        // 일부 삭제
        nest.removeOrganism(koala);
        nest.removeOrganism(cactus);

        // 전체 출력
        nest.displayAll();
    }
}
