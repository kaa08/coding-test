package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Marathon {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String key : participant) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (String key : completion) {
            map.put(key, map.get(key) - 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }

    public static String solution2(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                return answer;
            }
        }
        answer = participant[participant.length - 1];
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));  // "leo"
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));  // "vinko"
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"})); // "mislav"
        System.out.println();
        System.out.println(solution2(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));  // "leo"
        System.out.println(solution2(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));  // "vinko"
        System.out.println(solution2(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));// "mislav"
    }
}
