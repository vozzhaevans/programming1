import java.util.Scanner;

public class task_1293 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        if (N < 1 || N > 100 || A < 1 || A > 100 || B < 1 || B > 100) {
            System.out.println("Ошибка: числа должны быть в диапазоне от 1 до 100");
            return;
        }

        int area = 2 * A * B;

        int totalArea = N * area;

        System.out.println(totalArea);

        scanner.close();
    }
}