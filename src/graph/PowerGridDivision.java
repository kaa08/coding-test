package graph;

import java.util.*;

public class PowerGridDivision {

    public static int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            // 그래프 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) graph.add(new ArrayList<>());

            // i번째 전선을 끊고 나머지로 그래프 구성
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            // 아무 노드(1번)부터 시작해서 BFS로 연결된 노드 수 카운트
            int count = bfs(1, n, graph);
            int diff = Math.abs((n - count) - count);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    private static int bfs(int start, int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] wires1 = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int[][] wires2 = {{1, 2}, {2, 3}, {3, 4}};
        int[][] wires3 = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};

        System.out.println(solution(9, wires1)); // 3
        System.out.println(solution(4, wires2)); // 0
        System.out.println(solution(7, wires3)); // 1
    }
}