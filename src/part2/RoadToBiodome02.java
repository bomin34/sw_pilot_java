import java.util.ArrayList;

public class RoadToBiodome02 {
    // Stack 클래스 직접 구현
    static class CharStack {
        private ArrayList<Character> stack = new ArrayList<>();

        public void push(char c) {
            stack.add(c);
        }

        public char pop() {
            return stack.remove(stack.size() - 1);
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        // 입력 없을 경우 처리
        if (args.length == 0) {
            System.out.println("입력된 메시지가 올바르지 않습니다. 다시 한번 확인해주세요.");
            return;
        }

        // 모든 args 이어붙이기 (공백 포함)
        String input = "";
        for (String arg : args) {
            input += arg + " ";
        }

        // 끝 공백 제거
        input = input.trim();

        // 공백만 입력된 경우
        if (input.trim().isEmpty()) {
            System.out.println("입력된 메시지가 올바르지 않습니다. 다시 한번 확인해주세요.");
            return;
        }

        // 스택에 문자 하나씩 push
        CharStack stack = new CharStack();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // pop 하며 역순 출력
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

        System.out.println(); // 줄바꿈
    }
}

