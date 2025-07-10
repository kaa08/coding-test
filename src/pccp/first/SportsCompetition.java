package pccp.first;

public class SportsCompetition {

    static int maxSum = 0;
    static boolean[] visited;

    public static int solution(int[][] ability) {
        int n = ability.length;      // 학생 수
        int m = ability[0].length;   // 종목 수
        visited = new boolean[n];
        maxSum = 0;

        dfs(0, 0, ability, m);

        return maxSum;
    }

    private static void dfs(int depth, int sum, int[][] ability, int m) {
        if (depth == m) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < ability.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, sum + ability[i][depth], ability, m);
                visited[i] = false; // 백트래킹
            }
        }
    }

    // 테스트
    public static void main(String[] args) {
        int[][] ability1 = {
                {40, 10, 10},
                {20, 5, 0},
                {30, 30, 30},
                {70, 0, 70},
                {100, 100, 100}
        };
        System.out.println(solution(ability1)); // 출력: 210

        int[][] ability2 = {
                {20, 30},
                {30, 20},
                {20, 30}
        };
        System.out.println(solution(ability2)); // 출력: 60
    }
}