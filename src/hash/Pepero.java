package hash;

import java.util.*;

public class Pepero {

    public static String[] solution(String[] pepero) {
/*        Set<String> set = new HashSet<>();
        for(String s : pepero) {
            set.add(s);
        }
        List<String> list = new ArrayList<>(set.stream().toList());
        Collections.sort(list);
        return list.toArray(new String[0]);*/

        Set<String> set = new HashSet<>();
        Collections.addAll(set, pepero); // 더 간단하게 추가

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        return list.toArray(new String[0]);
    }

    public static String[] solution2(String[] pepero) {
        Set<String> set = new TreeSet<>(Arrays.asList(pepero)); // TreeSet은 정렬 상태 유지
        return set.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // 테스트케이스 1
        String[] input1 = {"초코", "누드초코", "크런키", "아몬드", "초코", "누드초코", "아몬드", "화이트쿠키", "초코", "초코"};
        System.out.println("출력1: " + Arrays.toString(solution(input1))); // ['누드초코', '아몬드', '초코', '크런키', '화이트쿠키']

        // 테스트케이스 2
        String[] input2 = {"아몬드", "화이트쿠키", "크림치즈", "아몬드", "화이트쿠키", "크림치즈", "아몬드", "화이트쿠키", "크림치즈", "크런키"};
        System.out.println("출력1: " + Arrays.toString(solution(input2))); // ['누드초코', '아몬드', '초코', '크런키', '화이트쿠키']

        // 테스트케이스 3
        String[] input3 = {"초코", "초코", "크런키", "크런키", "아몬드", "누드초코", "아몬드", "누드초코", "화이트쿠키", "크림치즈"};
        System.out.println("출력1: " + Arrays.toString(solution(input3))); // ['누드초코', '아몬드', '초코', '크런키', '화이트쿠키']
    }
}
