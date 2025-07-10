package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SleepWord {

    public static int solution(String words) {
        String[] wordsArr = words.split(" ");
        Set<String> set = new HashSet<>(Arrays.asList(wordsArr));
        return set.size();
    }
    public static void main(String[] args) {
        System.out.println(solution("culture experience symbol symbol education symbol effect education affair liberty liberty affair")); // 7
        System.out.println(solution("ocean price row schedule ocean price row schedule ocean price row schedule")); // 4
        System.out.println(solution("handle guide ostrich guide bar ostrich handle guide bar knee guide bar knee")); // 5
    }
}
