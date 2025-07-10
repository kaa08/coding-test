package string;

public class Qrcode {
    public static String solution(int q, int r, String code) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            if (i % q == r) {
                result.append(code.charAt(i));
            }
        }

        return result.toString();
    }

    // 테스트용 main 메서드
    public static void main(String[] args) {
        System.out.println(solution(3, 1, "qjnwezgrpirldywt"));  // 출력: jerry
        System.out.println(solution(1, 0, "programmers"));        // 출력: programmers
    }
}