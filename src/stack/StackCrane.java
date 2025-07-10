package stack;

import java.util.Stack;

public class StackCrane {

    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int move : moves) {
            int col = move - 1;

            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != 0) {
                    int picked = board[row][col];
                    board[row][col] = 0;

                    if (!stack.isEmpty() && stack.peek() == picked) {
                        stack.pop();
                        count += 2;
                    } else {
                        stack.push(picked);
                    }
                    break; // 인형 하나 집었으면 그 column은 더 볼 필요 없음
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println("Result: " + solution(board, moves)); // Expected: 4
    }
}