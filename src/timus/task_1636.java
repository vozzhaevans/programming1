package timus;

import java.util.Scanner;

public class task_1636 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T1 = sc.nextInt();
        int T2 = sc.nextInt();

        int totalPenalties = 0;
        for (int i = 0; i < 10; i++) {
            totalPenalties += sc.nextInt();
        }
        sc.close();

        int T2without = T2 - totalPenalties * 20;

        if (T2without < T1) {
            System.out.println("Dirty debug :(");
        } else {
            System.out.println("No chance.");
        }
    }
}
