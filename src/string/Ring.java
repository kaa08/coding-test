package string;

public class Ring {
    public static int solution(String wordFind, int N, String[] ring) {
        int count = 0;
        for(int i = 0; i < N;i++) {
            String doubled = ring[i] + ring[i];
            if (doubled.contains(wordFind)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(solution("ABCD", 3, new String[]{"ABCDXXXXXX", "YYYYABCDXX", "DCBAZZZZZZ"}));
        System.out.println(solution("XYZ", 1, new String[]{"ZAAAAAAAXY"}));
    }
}
