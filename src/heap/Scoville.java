package heap;

import java.util.*;

public class Scoville {
    public int solution(int[] scoville, int K) {
        // 우선순위 큐를 사용하여 최소 힙으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // scoville 배열을 우선순위 큐에 넣기
        for (int s : scoville) {
            pq.add(s);
        }

        int count = 0;

        // 우선순위 큐에 음식이 두 개 이상 있을 때까지
        while (pq.size() > 1) {
            // 가장 맵지 않은 두 음식을 꺼냄
            int first = pq.poll();
            int second = pq.poll();

            // 새로운 음식의 스코빌 지수 계산
            int newScoville = first + (second * 2);

            // 새로운 음식의 스코빌 지수를 큐에 넣음
            pq.add(newScoville);

            count++; // 섞은 횟수 증가

            // 가장 작은 스코빌 지수가 K 이상이면 종료
            if (pq.peek() >= K) {
                return count;
            }
        }

        // 만약 모든 음식의 스코빌 지수가 K 이상이 되지 않으면 -1을 반환
        return -1;
    }

    public static void main(String[] args) {
        Scoville sol = new Scoville();

        // 예시 입력 1
        int[] scoville1 = {1, 2, 3, 9, 10, 12};
        int K1 = 7;
        System.out.println(sol.solution(scoville1, K1)); // 예상 출력: 2

        // 예시 입력 2
        int[] scoville2 = {1, 2, 3, 9, 10, 12};
        int K2 = 15;
        System.out.println(sol.solution(scoville2, K2)); // 예상 출력: -1
    }
}