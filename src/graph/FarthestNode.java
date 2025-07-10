package graph;

import java.util.*;

public class FarthestNode {

    public static int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        // 양방향 그래프 구성
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1); // 방문 여부 + 거리 저장 (-1: 방문 안 함)

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph.get(curr)) {
                if (distance[next] == -1) { // 아직 방문 안한 노드
                    distance[next] = distance[curr] + 1;
                    queue.add(next);
                }
            }
        }

        // 가장 멀리 있는 노드들의 개수 구하기
        int maxDist = Arrays.stream(distance).max().getAsInt();
        int count = 0;
        for (int d : distance) {
            if (d == maxDist) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        };
        System.out.println(solution(n, vertex)); // 출력: 3
    }
}