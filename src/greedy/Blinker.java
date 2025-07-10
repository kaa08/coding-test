package greedy;

public class Blinker {

    public static int solution(int n, int k, int b, int[] arr) {
        int[] status = new int[n];
        for (int i : arr) {
            status[i - 1] = 1; // 고장난 신호등은 1로 표시
        }

        int broken_count = 0;

        // 초기 윈도우 내 고장난 개수 카운트
        for (int i = 0; i < k; i++) {
            if (status[i] == 1) {
                broken_count++;
            }
        }

        int answer = broken_count;

        // 슬라이딩 윈도우: 왼쪽부터 한 칸씩 이동
        for (int start = 1; start <= n - k; start++) {
            // 이전 시작 지점이 고장났었다면 감소
            if (status[start - 1] == 1) broken_count--;

            // 새로 포함된 끝 지점이 고장났다면 증가
            if (status[start + k - 1] == 1) broken_count++;

            answer = Math.min(answer, broken_count);
        }

        return answer;
    }

    public static void main(String[] args) {
        int n1 = 10, b1 = 5, k1 = 5;
        int[] arr1 = {2, 10, 1, 5, 9};
        System.out.println(solution(n1, k1, b1, arr1)); // ➜ 1

        int n2 = 100, b2 = 6, k2 = 6;
        int[] arr2 = {35, 86, 92, 49, 21, 62};
        System.out.println(solution(n2, k2, b2, arr2)); // ➜ 6
    }
}