package twopointer;

import java.util.Arrays;

public class TwoPointer {

    public static int solution(int n, int[] arr, int x) {
        int answer = 0;
        int left = 0;
        int right = arr.length - 1;
        Arrays.sort(arr);
        while(left < right) {
            if(arr[left] + arr[right] > x) {
                right--;
            } else if (arr[left] + arr[right] < x) {
                left++;
            } else {
                answer++;
                left++;
                right++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n1 = 9;
        int[] arr1 = {11, 3, 7, 4, 6, 16, 10, 9, 5};
        int x1 = 11;
        System.out.println("Result 1: " + solution(n1, arr1, x1)); // ➜ 2

        int n2 = 8;
        int[] arr2 = {4, 12, 2, 3, 15, 10, 6, 7};
        int x2 = 7;
        System.out.println("Result 2: " + solution(n2, arr2, x2)); // ➜ 1
    }
}
