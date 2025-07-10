package dynamicprogramming;

public class Jump {

    public static long solution(int n) {
        int MOD = 1234567;
        long[] dp = new long[n + 1];

        dp[0] = 1; // 0칸에서 시작하는 경우의 수
        dp[1] = 1; // 1칸 가는 경우는 1가지

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(4)); // 5
        System.out.println(solution(3)); // 3
        System.out.println(solution(1)); // 1
        System.out.println(solution(10)); // 89
    }
}