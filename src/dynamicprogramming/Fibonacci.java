package dynamicprogramming;

public class Fibonacci {

    public static int solution(int n) {
        int MOD = 1234567;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("n=3 ➜ " + solution(3)); // 2
        System.out.println("n=5 ➜ " + solution(5)); // 5
        System.out.println("n=100_000 ➜ " + solution(100000)); // 성능 확인용
    }
}
