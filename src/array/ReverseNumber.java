package array;

import java.util.Arrays;

public class ReverseNumber {
    public static int[] solution(long n) {
        int length = String.valueOf(n).length();

        int[] answer = new int[length];

        int i = 0;
        while (n != 0) {
            answer[i] = (int) (n % 10);

            n /= 10;

            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        // 테스트
        int[] result = solution(12345L);
        System.out.println(Arrays.toString(result));
    }
}