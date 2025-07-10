package queue;

import java.util.*;

public class EnQueueDeQueue {
    public static int[] solution(String[] commands) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (String command : commands) {
            String[] com = command.split(" ");
            if (com[0].equals("ENQ")) {
                queue.offer(Integer.parseInt(com[1]));
            } else { // DEQ
                Integer poll = queue.poll();
                list.add(poll == null ? -1 : poll);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[][] testCases = {
                {"ENQ 3", "ENQ 7", "DEQ", "DEQ", "DEQ"}, // [3, 7, -1]
                {"DEQ", "DEQ", "ENQ 5", "DEQ"},          // [-1, -1, 5]
                {"ENQ 1", "ENQ 2", "ENQ 3"},             // []
                {"DEQ", "DEQ", "DEQ"},                   // [-1, -1, -1]
                {"ENQ 10", "DEQ", "ENQ 20", "ENQ 30", "DEQ", "DEQ", "DEQ"}, // [10, 20, 30, -1]
                {"ENQ 1000", "ENQ 99999", "DEQ", "DEQ"}  // [1000, 99999]
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] result = solution(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ": " + Arrays.toString(result));
        }
    }
}