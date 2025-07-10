package pccp.second;

import java.util.*;

public class TreasureMap {

    static class State {
        int x, y, time, used;
        State(int x, int y, int time, int used) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.used = used;
        }
    }

    public static int solution(int n, int m, int[][] hole) {
        boolean[][] trap = new boolean[n + 1][m + 1];
        for (int[] h : hole) {
            trap[h[0]][h[1]] = true;
        }

        int[] dx = {-1, 1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1};

        boolean[][][] visited = new boolean[n + 1][m + 1][2]; // [x][y][used]

        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(1, 1, 0, 0));
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.x == n && cur.y == m) {
                return cur.time;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                if (trap[nx][ny]) continue;
                if (!visited[nx][ny][cur.used]) {
                    visited[nx][ny][cur.used] = true;
                    queue.offer(new State(nx, ny, cur.time + 1, cur.used));
                }

                // 신발 사용 (used == 0 인 경우만)
                if (cur.used == 0) {
                    int jx = cur.x + dx[d] * 2;
                    int jy = cur.y + dy[d] * 2;

                    if (jx < 1 || jx > n || jy < 1 || jy > m) continue;
                    if (trap[jx][jy]) continue;
                    if (!visited[jx][jy][1]) {
                        visited[jx][jy][1] = true;
                        queue.offer(new State(jx, jy, cur.time + 1, 1));
                    }
                }
            }
        }

        return -1;
    }

    // 테스트
    public static void main(String[] args) {
        System.out.println(solution(4, 4, new int[][]{{2, 3}, {3, 3}})); // 5
        System.out.println(solution(5, 4, new int[][]{
                {1, 4}, {2, 1}, {2, 2}, {2, 3}, {2, 4},
                {3, 3}, {4, 1}, {4, 3}, {5, 3}
        })); // -1
    }
}