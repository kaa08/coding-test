package array;

import java.util.*;

public class Hamburger {
    public static int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int j : ingredient) {
            stack.push(j);
            int size = stack.size();
            if (size >= 4 &&
                    stack.get(size - 4) == 1 &&
                    stack.get(size - 3) == 2 &&
                    stack.get(size - 2) == 3 &&
                    stack.get(size - 1) == 1) {
                for (int i = 0; i < 4; i++) {
                    stack.pop();
                }
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] test1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int[] test2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};

        System.out.println(solution(test1));  // 예상 출력: 2
        System.out.println(solution(test2));  // 예상 출력: 0
    }
}
