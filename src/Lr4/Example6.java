package Lr4;

import java.util.Random;

public class Example6 {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 3;
        int m = 5;
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = random.nextInt(10);
                System.out.printf(" " + a[i][j] + " ");
            }
            System.out.println();
        }

        int removeRow = random.nextInt(n);
        int removeCol = random.nextInt(m);

        System.out.println("\nУдаляем строку: " + removeRow);
        System.out.println("Удаляем столбец: " + removeCol);

        int[][] b = new int[n - 1][m - 1];

        for (int i = 0, newI = 0; i < n; i++) {
            if (i == removeRow) continue;
            for (int j = 0, newJ = 0; j < m; j++) {
                if (j == removeCol) continue;
                b[newI][newJ] = a[i][j];
                newJ++;
            }
            newI++;
        }

        System.out.println("\nНовая матрица ");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.printf(" " + b[i][j] + " ");
            }
            System.out.println();
        }
    }
    }

