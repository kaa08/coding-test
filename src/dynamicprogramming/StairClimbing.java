package dynamicprogramming;

import java.util.Scanner;

public class StairClimbing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stairs = new int[n + 1]; // 1-based index
        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];

        if (n >= 1) dp[1] = stairs[1];
        if (n >= 2) dp[2] = stairs[1] + stairs[2];
        if (n >= 3) dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(
                    dp[i - 2] + stairs[i],
                    dp[i - 3] + stairs[i - 1] + stairs[i]
            );
        }

        System.out.println(dp[n]);
    }
}