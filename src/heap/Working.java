package heap;

import java.util.*;

public class Working {
    public int solution(int[] works, int n) {
        // 우선순위 큐를 사용하여 가장 큰 작업량을 우선적으로 처리하기 위해 내림차순으로 설정
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 주어진 작업량을 우선순위 큐에 삽입
        for (int work : works) {
            pq.add(work);
        }

        // n 시간이 남았을 때
        while (n > 0 && !pq.isEmpty()) {
            // 가장 큰 작업량을 꺼냄
            int maxWork = pq.poll();

            // 작업량이 0보다 크면 1을 빼고 다시 큐에 넣음
            if (maxWork > 0) {
                pq.add(maxWork - 1);
                n--;
            }
        }

        // 남아 있는 작업량에 대해 야근 피로도 계산
        int fatigue = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            fatigue += work * work;
        }

        return fatigue;
    }

    public static void main(String[] args) {
        Working sol = new Working();

        // 예시 입력 1
        int[] works1 = {4, 3, 3};
        int n1 = 4;
        System.out.println(sol.solution(works1, n1)); // 예상 출력: 12

        // 예시 입력 2
        int[] works2 = {2, 1, 2};
        int n2 = 1;
        System.out.println(sol.solution(works2, n2)); // 예상 출력: 6

        // 예시 입력 3
        int[] works3 = {1, 1};
        int n3 = 3;
        System.out.println(sol.solution(works3, n3)); // 예상 출력: 0
    }
}