package pccp.second;

import java.util.PriorityQueue;

public class SpyTraining {

    public static long solution(int[] ability, int number) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // 초기 능력치 삽입
        for (int a : ability) {
            pq.offer((long) a);
        }

        // number번 교육
        for (int i = 0; i < number; i++) {
            long first = pq.poll();
            long second = pq.poll();
            long sum = first + second;

            pq.offer(sum);
            pq.offer(sum);
        }

        // 최종 합 구하기
        long total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        return total;
    }

    // 테스트 코드
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 3, 7, 2}, 2)); // 37
        System.out.println(solution(new int[]{1, 2, 3, 4}, 3));  // 26
    }
}