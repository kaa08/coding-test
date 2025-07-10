package prefixsum;

import java.util.Arrays;

public class ArraySum {
    public static int[] solution(int n, int[] arr, int m, int[][] k) {
        int[] answer = new int[m];
        int[] sum = new int[n + 1];
        for (int i = 1; i < n + 1 ; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        for (int i = 0; i < m; i++) {
            answer[i] = sum[k[i][1]] - sum[k[i][0] - 1];
        }
        System.out.println(Arrays.toString(sum));
        return answer;
    }
    public static void main(String[] args) {
        int n1 = 7;
        int[] arr1 = {1, 125, 126, 10, 49, 83, 52};
        int m1 = 3;
        int[][] k1 = {{1, 7}, {2, 4}, {3, 6}};
        System.out.println("result = " + Arrays.toString(solution(n1, arr1, m1, k1))); // [446, 261, 268]

        // 두 번째 테스트 케이스
        int n2 = 5;
        int[] arr2 = {112, 12, 16, 120, 449};
        int m2 = 5;
        int[][] k2 = {{1, 5}, {1, 5}, {1, 5}, {1, 5}, {1, 5}};
        System.out.println("result = " + Arrays.toString(solution(n2, arr2, m2, k2)));
    }
}
