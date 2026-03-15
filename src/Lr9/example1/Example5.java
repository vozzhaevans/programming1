package Lr9.example1;

public class Example5 {
    private static int step = 0;

    public static int fib(int n) {
        space();
        System.out.print("fib(" + n + ")-> ");
        step++;

        int result;
        if (n == 0) {
            result = 0;
            System.out.println(" (база)");
        } else if (n == 1) {
            result = 1;
            System.out.println(" (база)");
        } else {
            System.out.println();

            space();
            System.out.println("  левая часть: fib(" + (n-2) + ")");
            int left = fib(n - 2);

            space();
            System.out.println("  правая часть: fib(" + (n-1) + ")");
            int right = fib(n - 1);

            result = left + right;
            space();
            System.out.println("  сумма = " + left + " + " + right + " = " + result);
        }

        step--;
        space();
        System.out.println("fib(" + n + ") <- " + result);

        return result;
    }

    public static void space() {
        for (int i = 0; i < step; i++) {
            System.out.print("  ");
        }
    }

    public static void main(String[] args) {
        int result = fib(5);
        System.out.println("Результат: " + result);
    }
}