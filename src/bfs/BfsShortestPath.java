package bfs;
import java.util.*;

public class BfsShortestPath {
    static int[][] map;         // 지도
    static boolean[][] visited; // 방문 여부
    static int[][] dist;        // 거리 저장
    static int h, w;            // 높이, 너비

    // 상, 하, 좌, 우 방향 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 좌표를 나타내는 내부 클래스
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    public static int solution(int h, int w, int[][] inputMap, int sh, int sw, int eh, int ew) {
        // 전역 변수 설정
        BfsShortestPath.h = h;
        BfsShortestPath.w = w;
        map = inputMap;
        visited = new boolean[h][w];
        dist = new int[h][w];

        // 시작, 도착 좌표는 1-based → 0-based로 변환
        int startX = sh - 1, startY = sw - 1;
        int endX = eh - 1, endY = ew - 1;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY));
        visited[startX][startY] = true;
        dist[startX][startY] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            // 도착점에 도달했으면 거리 반환
            if (cur.x == endX && cur.y == endY) {
                return dist[cur.x][cur.y];
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 범위 체크 & 방문 체크 & 섬 여부 체크
                if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[cur.x][cur.y] + 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }

        // 도착할 수 없는 경우
        return -1;
    }

    // 테스트용 main
    public static void main(String[] args) {
        int[][] map1 = {
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println("Test 1 (Expected 4): " + solution(7, 10, map1, 1, 6, 4, 5));

        int[][] map2 = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0}
        };
        System.out.println("Test 2 (Expected 12): " + solution(10, 8, map2, 10, 7, 3, 2));
    }
}