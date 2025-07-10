package dfs;

public class DfsIsland {
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int h, w;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int[][] solution(int h, int w, int[][] inputMap, int startX, int startY) {
        map = inputMap;
        result = new int[h][w];
        visited = new boolean[h][w];
        DfsIsland.h = h;
        DfsIsland.w = w;

        if (map[startX][startY] == 1) {
            dfs(startX, startY);
        }
        return result;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        result[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (!visited[nx][ny] & map[nx][ny] == 1) {
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
        int[][] res1 = solution(10, 5, map1, 7, 2);
        printGrid(res1);

        System.out.println("----");

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
        int[][] res2 = solution(8, 10, map2, 2, 9);
        printGrid(res2);
    }

    // 결과 출력 함수
    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

