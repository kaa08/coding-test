package greedy;

import java.util.Arrays;

public class Candy {
    public static int solution(int n, int k, int[] arr) {
        int[] sum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        System.out.println(Arrays.toString(sum));
        int max = 0;
        for (int i = 1;i <= n - k + 1; i++) {
            if (max < sum[i + k - 1] - sum[i - 1]) {
                max = sum[i + k - 1] - sum[i - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n1 = 6;
        int k1 = 3;
        int[] arr1 = {10, 2, 8, 3, 3, 1};
        System.out.println("Result 1: " + solution(n1, k1, arr1)); // 기대값: 20

        // 테스트 케이스 2
        int n2 = 13;
        int k2 = 2;
        int[] arr2 = {3, 5, 5, 9, 5, 3, 1, 2, 2, 8, 1, 9, 4};
        System.out.println("Result 2: " + solution(n2, k2, arr2)); // 기대값: 14

        // 테스트 케이스 3 (모서리 케이스: 모두 같은 값)
        int n3 = 10;
        int k3 = 5;
        int[] arr3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Result 3: " + solution(n3, k3, arr3)); // 기대값: 5

        // 테스트 케이스 4 (모서리 케이스: 최대값이 맨 끝에)
        int n4 = 8;
        int k4 = 3;
        int[] arr4 = {1, 1, 1, 1, 1, 9, 9, 9};
        System.out.println("Result 4: " + solution(n4, k4, arr4)); // 기대값: 27
    }
}
