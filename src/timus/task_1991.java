package timus;

import java.util.Scanner;

public class task_1991 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long totalBoomBooms = 0;
        long totalDestroyed = 0;

        for (int i = 0; i < n; i++) {
            int ai = scanner.nextInt();
            totalBoomBooms += ai;

            int destroyedInBlock = Math.min(ai, k);
            totalDestroyed += destroyedInBlock;
        }

        scanner.close();

        long totalDroids = (long) n * k;

        long survivedDroids = totalDroids - totalDestroyed;

        long unusedBoomBooms = totalBoomBooms - totalDestroyed;

        System.out.println(unusedBoomBooms + " " + survivedDroids);
    }
}
