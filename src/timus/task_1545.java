package timus;

import java.util.Scanner;

public class task_1545 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        String[] hieroglyphs = new String[n];
        for (int i = 0; i < n; i++) {
            hieroglyphs[i] = scanner.nextLine().trim();
        }

        String letter = scanner.nextLine().trim();

        for (String h : hieroglyphs) {
            if (h.length() >= 1 && h.charAt(0) == letter.charAt(0)) {
                System.out.println(h);
            }
        }

        scanner.close();
    }
}