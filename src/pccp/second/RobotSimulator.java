package pccp.second;

public class RobotSimulator {

    public static int[] solution(String command) {
        int x = 0, y = 0;
        int dir = 0; // 0:북, 1:동, 2:남, 3:서

        // 방향별 x, y 변화량
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (char c : command.toCharArray()) {
            if (c == 'R') {
                dir = (dir + 1) % 4;
            } else if (c == 'L') {
                dir = (dir + 3) % 4; // 왼쪽 회전
            } else if (c == 'G') {
                x += dx[dir];
                y += dy[dir];
            } else if (c == 'B') {
                x -= dx[dir];
                y -= dy[dir];
            }
        }

        return new int[]{x, y};
    }

    // 테스트
    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(solution("GRGLGRG"))); // [2, 2]
        System.out.println(java.util.Arrays.toString(solution("GRGRGRB"))); // [2, 0]
    }
}