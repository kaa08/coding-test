package stack;

import java.util.Stack;

public class StackCheck {

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else { // ')'
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution("(()())")); // true
        System.out.println(solution(")(()"));   // false
        System.out.println(solution("(()"));    // false
        System.out.println(solution("()()"));   // true
    }
}