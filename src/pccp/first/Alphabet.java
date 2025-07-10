package pccp.first;

import java.util.HashSet;
import java.util.*;

public class Alphabet {
    public static String solution(String input_string) {
        String answer = "";
        Set<Character> lonelySet = new HashSet<>();
        Set<Character> visited = new HashSet<>();
        char prev = 0;

        for (int i = 0; i < input_string.length(); i++) {
            char curr = input_string.charAt(i);

            if (curr != prev) {
                if(visited.contains(curr)) {
                    lonelySet.add(curr);
                }
                visited.add(curr);
            }
            prev = curr;
        }
        if (lonelySet.isEmpty()) return "N";

        List<Character> list = new ArrayList<>(lonelySet);
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (char c : list) sb.append(c);
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("edeaaabbccd")); // 출력: de
        System.out.println(solution("eeddee"));      // 출력: e
        System.out.println(solution("string"));      // 출력: N
        System.out.println(solution("zbzbz"));       // 출력: bz
    }

}
