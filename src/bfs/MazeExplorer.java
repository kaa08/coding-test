package bfs;
import java.util.*;

public class MazeExplorer {

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    static int H, W;
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        map = new int[H][W];
        distance = new int[H][W];
        visited = new boolean[H][W];

        Point start = null;

        for (int i = 0; i < H; i++) {
            String row = sc.next();
            for (int j = 0; j < W; j++) {
                map[i][j] = row.charAt(j) - '0';
                if (map[i][j] == 2) {
                    start = new Point(i, j);
                }
            }
        }

        bfs(start);

        // 출력
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) System.out.print("0 ");
                else if (!visited[i][j]) System.out.print("0 ");
                else System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;
        distance[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[now.x][now.y] + 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
}