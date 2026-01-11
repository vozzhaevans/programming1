package Lr6.Example4;

public class Main {
    public static void main(String[] args) {
        System.out.println(getFactorial(6));
    }

    public static long getFactorial (int n) {
        if (n == 0 || n == 1) {
            return 1; // по определению: 0!! = 1, 1!! = 1
        }

        long result = 1;
        for (int i = n; i >= 2; i -= 2) {
            result *= i;
        }

        return result;
    }
}
