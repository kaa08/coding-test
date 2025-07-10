package array;

import java.util.*;

public class EveryNthElement {

    public static List<Integer> solution(int[] numList, int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numList.length; i += n) {
            result.add(numList[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numList1 = {4, 2, 6, 1, 7, 6};
        int[] numList2 = {4, 2, 6, 1, 7, 6};

        System.out.println(solution(numList1, 2)); // [4, 6, 7]
        System.out.println(solution(numList2, 4)); // [4, 7]
    }
}