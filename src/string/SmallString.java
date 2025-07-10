package string;

public class SmallString {
    public static int solution(String t, String p) {
        int pLen = p.length();
        long pNum = Long.parseLong(p); // 길이가 최대 18이므로 long 사용
        int count = 0;

        for (int i = 0; i < t.length() - pLen; i++) {
            String sub = t.substring(i, i + pLen);
            long numSub = Long.parseLong(sub);

            if (numSub <= pNum) {
                count++;
            }
        }

        return count;
    }



    // 테스트
    public static void main(String[] args) {
        System.out.println(solution("3141592", "271"));        // 2
        System.out.println(solution("500220839878", "7"));     // 8
        System.out.println(solution("10203", "15"));           // 3
    }
}