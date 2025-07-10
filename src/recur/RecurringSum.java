package recur;

public class RecurringSum {

    public static int num(int n) {
        if (n == 1) return 1;
        return n + num(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(num(10));
    }
}
