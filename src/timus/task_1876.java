package timus;

import java.util.Scanner;

public class task_1876 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        int seconds = 2 * b + 40;
        System.out.println(seconds);
    }
}