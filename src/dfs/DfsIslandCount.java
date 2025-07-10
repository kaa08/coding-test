package dfs;

public class DfsIslandCount {

    static int[][] map;
    static boolean[][] visited;
    static int h, w;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int solution(int h, int w, int[][] inputMap) {
        DfsIslandCount.h = h;
        DfsIslandCount.w = w;
        map = inputMap;

        visited = new boolean[h][w];
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] map1 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1}
        };
        System.out.println("섬 개수 (예1): " + solution(10, 5, map1)); // 4

        int[][] map2 = {
                {1, 1, 0, 1, 0, 0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 1, 0, 0, 1, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println("섬 개수 (예2): " + solution(8, 10, map2)); // 6
    }
}
