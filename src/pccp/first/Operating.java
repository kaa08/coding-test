package pccp.first;

import java.util.*;


public class Operating {

    public static int[] solution(int[][] program) {
        int[] answer = new int[11];
        int n = program.length;

        // 호출 시간 기준 정렬
        Arrays.sort(program, Comparator.comparingInt(p -> p[1]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[3], b[3])
        );

        int idx = 0;
        int currentTime = 0;

        while (idx < n || !pq.isEmpty()) {
            // 현재 시간 이전에 호출된 프로그램을 큐에 넣음
            while (idx < n && program[idx][1] <= currentTime) {
                int[] p = program[idx];
                pq.offer(new int[]{p[0], p[1], p[2], idx}); // score, callTime, duration, id
                idx++;
            }

            if (pq.isEmpty()) {
                currentTime = program[idx][1];
                continue;
            }

            int[] now = pq.poll();
            int waitTime = currentTime - now[1];
            answer[now[0]] += waitTime;

            currentTime += now[2]; // duration만큼 실행
        }

        answer[0] = currentTime;
        return answer;
    }

    public static void main(String[] args) {
        int[][] input1 = {
                {2, 0, 10},
                {1, 5, 5},
                {3, 5, 3},
                {3, 12, 2}
        };
        System.out.println(Arrays.toString(solution(input1)));
        // [20, 5, 0, 16, 0, 0, 0, 0, 0, 0, 0]

        int[][] input2 = {
                {3, 6, 4},
                {4, 2, 5},
                {1, 0, 5},
                {5, 0, 5}
        };
        System.out.println(Arrays.toString(solution(input2)));
        // [19, 0, 0, 4, 3, 14, 0, 0, 0, 0, 0]
    }
}