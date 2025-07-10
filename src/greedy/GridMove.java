package greedy;

public class GridMove {
    static int maxSum;
    static int[][] board;
    static int n;

    public static int solution(int n, int[][] arr) {
        GridMove.n = n;
        board = arr;
        maxSum = Integer.MIN_VALUE;

        dfs(0, 0, 0);
        return maxSum;
    }

    public static void dfs(int x, int y, int sum) {
        if(x == n - 1 && y == n -1) {
            maxSum = Math.max(maxSum, sum + board[x][y]);
            return;
        }

        sum += board[x][y];

        if(x + 1 < n) dfs(x + 1, y, sum);
        if(y + 1 < n) dfs(x, y + 1, sum);
    }
    public static void main(String[] args) {
        int[][] test1 = {
                {1, 8, 2, 5, 5},
                {6, 3, 3, 6, 5},
                {1, 10, 5, 5, 5},
                {5, 4, 5, 2, 7},
                {6, 9, 6, 8, 5}
        };
        System.out.println("result1: " + solution(5, test1)); // ➜ 54

        int[][] test2 = {
                {10, 2, 10, 3},
                {7, 6, 7, 3},
                {3, 10, 10, 5},
                {10, 9, 10, 5}
        };
        System.out.println("result2: " + solution(4, test2)); // ➜ 58

        int[][] test3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("result3: " + solution(3, test3)); // ➜ 29
    }
}
