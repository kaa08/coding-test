package bfs;

import java.util.*;

public class TravelPath {

    static List<String[]> allPaths = new ArrayList<>();
    static boolean[] visited;

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        // 목적지 기준으로 정렬 (알파벳 빠른 순으로 방문하기 위해)
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        List<String> route = new ArrayList<>();
        route.add("ICN");
        dfs("ICN", tickets, route, 0);

        // 사전순 정렬
        allPaths.sort((a, b) -> {
            for (int i = 0; i < a.length; i++) {
                int cmp = a[i].compareTo(b[i]);
                if (cmp != 0) return cmp;
            }
            return 0;
        });

        return allPaths.get(0);
    }

    static void dfs(String current, String[][] tickets, List<String> route, int count) {
        if (count == tickets.length) {
            allPaths.add(route.toArray(new String[0]));
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                route.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, route, count + 1);
                visited[i] = false;
                route.remove(route.size() - 1); // 백트래킹
            }
        }
    }

    // 테스트 코드
    public static void main(String[] args) {
        String[][] tickets1 = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };
        System.out.println(Arrays.toString(solution(tickets1)));
        // 예상 결과: [ICN, JFK, HND, IAD]

        String[][] tickets2 = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };
        System.out.println(Arrays.toString(solution(tickets2)));
        // 예상 결과: [ICN, ATL, ICN, SFO, ATL, SFO]
    }
}