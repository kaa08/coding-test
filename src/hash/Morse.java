package hash;

public class Morse {

    public static String solution(String letter) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.",
                "--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",
                ".--","-..-","-.--","--.."};
        String[] morseString;
        morseString = letter.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String word : morseString) {
            for (int i = 0; i < morse.length; i++) {
                if (word.equals(morse[i])) sb.append(Character.toString(i + 'a'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(".... . .-.. .-.. ---"));  // "hello"
        System.out.println(solution(".--. -.-- - .... --- -."));  // "python"
        System.out.println(solution(".- -... -.-."));  // "abc"
        System.out.println(solution("... --- ..."));  // "sos"
        System.out.println(solution(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."));  // "hello world"
    }
}

