package string;

import java.util.Arrays;
import java.util.Collections;

public class ReverseN {

    public static Long solution(long n) {
        // 1. 숫자를 문자열로 바꾼 뒤, 문자 배열로 변환
        String str = String.valueOf(n);
        Character[] digits = new Character[str.length()];

        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i);
        }

        // 2. 내림차순 정렬
        Arrays.sort(digits, Collections.reverseOrder());

        // 3. 정렬된 문자들을 문자열로 이어붙이기
        StringBuilder sb = new StringBuilder();
        for (char c : digits) {
            sb.append(c);
        }

        // 4. 최종 문자열을 long으로 변환하여 반환
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution(118372)); // ➜ 873211
    }
}