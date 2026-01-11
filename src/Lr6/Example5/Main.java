package Lr6.Example5;

public class Main {
    public static void main(String[] args) {
        int n1 = 3;
        System.out.println("Сумма квадратов от 1 до " + n1 + ": " + sumOfSquares(n1));

        int n2 = 5;
        System.out.println("Сумма квадратов от 1 до " + n2 + ": " + sumOfSquares(n2));

        int n3 = 10;
        System.out.println("Сумма квадратов от 1 до " + n3 + ": " + sumOfSquares(n3));
    }

    public static long sumOfSquares(int n) {
        return (long) n * (n + 1) * (2 * n + 1) / 6;
    }
}
