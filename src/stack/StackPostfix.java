package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StackPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int m = sc.nextInt();
        sc.nextLine();
        String[] tokens = sc.nextLine().split(" ");
        System.out.println(Arrays.toString(tokens));

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOp(a, b, token));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        System.out.println(stack.pop());
    }

    public static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    public static int applyOp(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("잘못된 연산자: " + op);
        };
    }
}
