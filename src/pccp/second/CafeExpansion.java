package pccp.second;

import java.util.*;

public class CafeExpansion {
    public static int solution(int[] menu, int[] order, int k) {
        List<int[]> events = new ArrayList<>(); // [시간, +1/-1] 형태

        int time = 0; // 음료 제조 시작 시간

        for (int i = 0; i < order.length; i++) {
            int arrival = i * k;
            if (time < arrival) time = arrival;

            int drinkTime = menu[order[i]];
            int exit = time + drinkTime;

            events.add(new int[]{arrival, 1}); // 입장
            events.add(new int[]{exit, -1});   // 퇴장

            time = exit; // 다음 제조는 이때부터 시작
        }

        // 시간순 정렬, 같은 시간일 경우 퇴장이 먼저 (우선순위)
        events.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int max = 0;
        int now = 0;

        for (int[] e : events) {
            now += e[1];
            max = Math.max(max, now);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 12, 30}, new int[]{1, 2, 0, 1}, 10)); // 3
        System.out.println(solution(new int[]{5, 12, 30}, new int[]{2, 1, 0, 0, 0, 1, 0}, 10)); // 4
        System.out.println(solution(new int[]{5}, new int[]{0, 0, 0, 0, 0}, 5)); // 1
    }
}