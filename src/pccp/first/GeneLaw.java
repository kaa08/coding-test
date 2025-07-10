package pccp.first;
public class GeneLaw {

    public static String[] solution(int[][] queries) {
        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int p = queries[i][1];
            result[i] = findGene(n, p, "Rr");
        }

        return result;
    }

    // 재귀적으로 부모 추적
    private static String findGene(int generation, int position, String parentGene) {
        if (generation == 1) {
            return "Rr"; // 항상 시작은 Rr
        }

        int parentPos = (position - 1) / 4 + 1; // 부모 위치
        int childOrder = (position - 1) % 4 + 1; // 부모의 몇 번째 자식인지

        String parent = findGene(generation - 1, parentPos, parentGene);

        if (parent.equals("RR")) return "RR";
        if (parent.equals("rr")) return "rr";

        // Rr인 경우
        if (childOrder == 1) return "RR";
        if (childOrder == 4) return "rr";
        return "Rr";
    }

    // 테스트
    public static void main(String[] args) {
        int[][] queries1 = {{3, 5}};
        int[][] queries2 = {{3, 8}, {2, 2}};
        int[][] queries3 = {{3, 1}, {2, 3}, {3, 9}};
        int[][] queries4 = {{4, 26}};

        System.out.println(java.util.Arrays.toString(solution(queries1))); // [RR]
        System.out.println(java.util.Arrays.toString(solution(queries2))); // [rr, Rr]
        System.out.println(java.util.Arrays.toString(solution(queries3))); // [RR, Rr, RR]
        System.out.println(java.util.Arrays.toString(solution(queries4))); // [Rr]
    }
}