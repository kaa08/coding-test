package greedy;

import java.util.Arrays;

public class CommunityRoom {

    public static int solution(int[][] arr) {
        int answer = 0;
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int endTime = 0;
        for (int[] i : arr) {
            if (i[0] >= endTime) {
                endTime = i[1];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {2, 4}, {2, 2}};
        int[][] arr2 = {{1, 4}, {2, 6}, {4, 7}};

        System.out.println(solution(arr1)); // ➜ 3
        System.out.println(solution(arr2)); // ➜ 2
    }
}
