package stack;

import java.util.Scanner;
import java.util.Stack;

public class StackNumber {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String number = sc.next();

        // Step 1: 숫자를 스택에 넣기 (역순으로 만들기 위해)
        for (int i = 0; i < n; i++) {
            stack.push(number.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Step 2: 스택에서 꺼내며 3자리마다 콤마 추가
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop()); // 앞쪽에 추가
            count++;
            if (count % 3 == 0 && !stack.isEmpty()) {
                sb.insert(0, ','); // 세 자리마다 콤마 (맨 앞엔 안 붙이기 위해 !stack.isEmpty() 체크)
            }
        }

        System.out.println(sb.toString());
    }
}