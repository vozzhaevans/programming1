package timus;

import java.util.Scanner;

public class task_1296 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(0);
            sc.close();
            return;
        }

        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            maxEndingHere = Math.max(p, maxEndingHere + p);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        System.out.println(maxSoFar);
        sc.close();
    }
}
