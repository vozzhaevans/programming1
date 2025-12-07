package Lr3;

import java.util.Scanner;

public class Example5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел в сумме: ");
        int len = scanner.nextInt();

        int sum = 0;
        int numbers = 1;
        int count = 0;

        while (count < len) {
            if (numbers % 5 == 2 || numbers % 3 == 1) {
                System.out.print(numbers + " ");
                sum += numbers;
                count++;
            }
            numbers++;
        }

        System.out.println("\nСумма чисел: " + sum);
    }
}

