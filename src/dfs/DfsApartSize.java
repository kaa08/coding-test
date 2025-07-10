package dfs;

public class DfsApartSize {
    static int h, w;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int solution(int h, int w, char[][] inputMap) {
        DfsApartSize.h = h;
        DfsApartSize.w = w;
        map = inputMap;
        visited = new boolean[h][w];

        int maxSize = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && map[i][j] == '*') {
                    int size = dfs(i, j);
                    maxSize = Math.max(size, maxSize);
                }
            }
        }
        return maxSize;
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (!visited[nx][ny] && map[nx][ny] == '*') {
                    size += dfs(nx, ny);
                }
            }
        }
        return size;
    }
    // 테스트
    public static void main(String[] args) {
        char[][] map1 = {
                {'.','.','*','.','.','.','.','.','*','*'},
                {'.','*','*','.','.','*','*','*','*','*'},
                {'.','*','.','.','.','*','.','.','.','.'},
                {'.','.','*','*','*','*','.','*','*','*'},
                {'.','.','*','*','*','*','.','*','*','*'}
        };
        System.out.println("Test 1 (Expected 16): " + solution(5, 10, map1));

        // Test Case 2
        char[][] map2 = {
                {'.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.'},
                {'.','.','*','.','.','.','.'},
                {'.','*','*','*','.','.','*'},
                {'.','*','.','.','.','.','*'},
                {'.','.','.','.','.','.','.'}
        };
        System.out.println("Test 2 (Expected 5): " + solution(7, 7, map2));

        // Test Case 3: All connected
        char[][] map3 = {
                {'*','*','*'},
                {'*','*','*'},
                {'*','*','*'}
        };
        System.out.println("Test 3 (Expected 9): " + solution(3, 3, map3));

        // Test Case 4: All isolated
        char[][] map4 = {
                {'*','.','*'},
                {'.','*','.'},
                {'*','.','*'}
        };
        System.out.println("Test 4 (Expected 1): " + solution(3, 3, map4));

        // Test Case 5: All water
        char[][] map5 = {
                {'.','.','.'},
                {'.','.','.'},
                {'.','.','.'}
        };
        System.out.println("Test 5 (Expected 0): " + solution(3, 3, map5));
    }
}
