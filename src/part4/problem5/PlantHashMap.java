class PlantHashMap<K, V> {
    // HashMap 동작 방식 : 배열 처럼 생긴 저장소 생성
    private Entry<K, V>[] table;

    // Entry는 (key, value) 쌍, 저장할 때는 키를 hashCode()로 숫자로 바꾸고, 그 숫자를 배열의 인덱스로 사용
    public PlantHashMap() {
        // 크기 16으로 고정된 배열
        table = new Entry[16];  // 고정 크기
    }

    // 내부 클래스: 키와 값을 저장하는 구조
    // HashMap 클래스 안에서만 사용하는 것이므로 static으로 선언
    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // 해시코드로 인덱스 구하기
    // key를 HashCode로 정수로 변환하고 배열 크기로 나누어 인덱스 계산 -> 항상 0~15 사이의 값
    // "장미"의 hashCode()가 12345라고 하면 → 12345 % 16 = 5 → index 5
    public int getIndex(K key) {
        return Math.abs(key.hashCode()) % 16;
    }

    // put : 추가 (덮어쓰고 체이닝 하지 않음)
    // key에 해당하는 인덱스를 계산하고 해당 위치에 새 Entry 저장
    // 이미 값이 있어도 그냥 덮어쓰기
    public void put(K key, V value) {
        int index = getIndex(key);
        table[index] = new Entry<>(key, value);
        System.out.println("'" + key + "' 추가 : '" + value + "'");
    }

    // get : 검색
    // key를 index로 변환해서 배열에서 꺼내보고 key가 일치하면 value를 보여줌
    public void get(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        if (entry != null && entry.key.equals(key)) {
            System.out.println("'" + key + "' 검색 : '" + entry.value + "'");
        } else {
            System.out.println("'" + key + "'를 찾을 수 없습니다.");
        }
    }

    // remove : 삭제
    // key로 인덱스를 계산한 뒤, 맞는 데이터가 있으면 null로 지움
    public void remove(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        if (entry != null && entry.key.equals(key)) {
            table[index] = null;
            System.out.println("'" + key + "' 삭제 : '" + key + "'와 그 특징이 삭제되었습니다.");
        } else {
            System.out.println("'" + key + "'는 존재하지 않아 삭제할 수 없습니다.");
        }
    }
}
