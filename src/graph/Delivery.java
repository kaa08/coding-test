package graph;

import java.util.*;

public class Delivery {

    public static int solution(int N, int[][] road, int K) {
        // 인접 리스트 생성 (마을 번호는 1부터 시작)
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int[] r : road) {
            int a = r[0], b = r[1], time = r[2];
            graph.get(a).add(new int[]{b, time});
            graph.get(b).add(new int[]{a, time}); // 양방향 도로
        }

        // 다익스트라 알고리즘 준비
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0}); // 시작점 (노드, 거리)

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int now = curr[0];
            int cost = curr[1];

            if (cost > dist[now]) continue;

            for (int[] next : graph.get(now)) {
                int neighbor = next[0];
                int nextCost = cost + next[1];

                if (nextCost < dist[neighbor]) {
                    dist[neighbor] = nextCost;
                    pq.offer(new int[]{neighbor, nextCost});
                }
            }
        }

        // K 이하의 마을 개수 세기
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] road1 = {
                {1, 2, 1}, {2, 3, 3}, {5, 2, 2},
                {1, 4, 2}, {5, 3, 1}, {5, 4, 2}
        };
        int[][] road2 = {
                {1, 2, 1}, {1, 3, 2}, {2, 3, 2},
                {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}
        };

        System.out.println(solution(5, road1, 3)); // 4
        System.out.println(solution(6, road2, 4)); // 4
    }
}