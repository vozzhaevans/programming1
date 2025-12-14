package Lr4;

import java.util.Random;

public class Example5 {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 3;
        int m = 5;
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = random.nextInt(9);
                System.out.print(" " + a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nТранспонированная матрица :");

        int[][] b = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = a[j][i];
                System.out.print(" " + b[i][j] + " ");
            }
            System.out.println();
        }
    }
}