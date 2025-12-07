package Lr3;

import java.util.Scanner;

public class Example3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ВВедите кол-во чисел в массиве: ");
        int n = scanner.nextInt();

        if (n >= 1) {
            System.out.print("1");
        }
        if (n >= 2) {
            System.out.print(" 1");
        }

        if (n > 2) {
            int a = 1;
            int b = 1;
            int count = 2;

            while (count < n) {
                int next = a + b;
                System.out.print(" " + next);

                a = b;
                b = next;
                count++;
            }
        }

        scanner.close();
    }
}