package stack;

import java.util.*;

public class StackCommand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // 명령 개수
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();

            if (command.startsWith("i ")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                stack.push(value);
            } else if (command.equals("o")) {
                if (stack.isEmpty()) {
                    System.out.println("empty");
                } else {
                    System.out.println(stack.pop());
                }
            } else if (command.equals("c")) {
                System.out.println(stack.size());
            }
        }
    }
}