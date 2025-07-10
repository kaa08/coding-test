package string;

public class AlterString {
    public static String solution(String my_String, String overWriteString, int s) {
        String answer = my_String.substring(0, s)
                + overWriteString
                + my_String.substring(s + overWriteString.length());
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("He11oWor1d", "lloWorl", 2));
        System.out.println(solution("Program29b8UYP", "merS123", 7));
    }
}
