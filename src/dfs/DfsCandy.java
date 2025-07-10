package dfs;

public class DfsCandy {
    static final int N = 7;

    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int solution(int[][] input) {
        board = input;

        visited = new boolean[N][N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int size = dfs(i, j, board[i][j]);
                    if (size >= 3) count++;
                }
            }
        }
        return count;
    }

    public static int dfs(int x, int y, int color) {
        visited[x][y] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && color == board[nx][ny]) {
                    cnt += dfs(nx, ny, color);
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[][] map1 = {
                {4, 4, 2, 2, 5, 5, 2},
                {5, 5, 5, 5, 4, 4, 4},
                {3, 3, 3, 3, 3, 3, 3},
                {2, 2, 2, 2, 2, 2, 3},
                {5, 5, 2, 2, 1, 1, 3},
                {3, 3, 5, 5, 1, 1, 3},
                {4, 4, 5, 5, 1, 1, 2}
        };
        System.out.println("Test 1 (Expected 6): " + solution(map1));

        int[][] map2 = {
                {5, 5, 5, 5, 1, 1, 5},
                {5, 5, 3, 3, 3, 3, 3},
                {3, 3, 1, 1, 3, 3, 4},
                {3, 3, 2, 2, 2, 2, 4},
                {5, 5, 3, 3, 3, 3, 3},
                {1, 3, 3, 2, 2, 2, 2},
                {1, 1, 1, 1, 2, 2, 1}
        };
        System.out.println("Test 2 (Expected 7): " + solution(map2));
    }

}
