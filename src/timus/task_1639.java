package timus;

import java.util.Scanner;

public class task_1639 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();


        if (m % 2 == 1 && n % 2 == 1) {
            System.out.println("[second]=:]");
        } else {

            System.out.println("[:=[first]");
        }

        scanner.close();
    }
}

