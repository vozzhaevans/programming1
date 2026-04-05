package timus;

import java.util.Scanner;

public class task_1243 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine().trim();
        scanner.close();

        int remainder = 0;
        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - '0';
            remainder = (remainder * 10 + digit) % 7;
        }

        System.out.println(remainder);
    }
}
