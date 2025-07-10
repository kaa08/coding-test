package dfs;

public class DfsApart {
    static int h, w;
    static char[][] map;
    static int[][] result;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int[][] solution(int h, int w, char[][] inputMap, int l, int c) {
        DfsApart.h = h;
        DfsApart.w = w;
        map = inputMap;
        result = new int[h][w];
        visited = new boolean[h][w];

        if (map[l - 1][c - 1] == '*') {
            dfs(l - 1, c - 1);
        }
        return result;
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        result[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (!visited[nx][ny] && map[nx][ny] == '*') {
                    dfs(nx, ny);
                }
            }
        }
    }

    private static void printMap(int[][] res) {
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val);
            }
            System.out.println();
        }
    }

    // 테스트
    public static void main(String[] args) {
        char[][] map1 = {
                "..*.....**".toCharArray(),
                ".**..*****".toCharArray(),
                ".*...*....".toCharArray(),
                "..****.***".toCharArray(),
                "..****.***".toCharArray()
        };
        int[][] res1 = solution(5, 10, map1, 3, 6); // (3,6)은 1-based
        printMap(res1);

        System.out.println("-----------");

        char[][] map2 = {
                ".......".toCharArray(),
                ".......".toCharArray(),
                ".......".toCharArray(),
                "..*....".toCharArray(),
                ".***..*".toCharArray(),
                ".*....*".toCharArray(),
                ".......".toCharArray()
        };
        int[][] res2 = solution(7, 7, map2, 5, 7); // (5,7)은 1-based
        printMap(res2);
    }
}
