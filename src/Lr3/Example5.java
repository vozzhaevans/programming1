package Lr3;

import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел в сумме: ");
        int len = scanner.nextInt();

        int sum = 0;
        int numbers = 0;

        for (int i = 1; numbers < len; i++) {
            if (i % 5 == 2 || i % 3 == 1) {
                System.out.print(i + " ");
                sum += i;
                numbers++;
            }
        }

        System.out.println("\nСумма чисел: " + sum);
    }
}
