package Lr13.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Готовая матрица
        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        System.out.println("Матрица 3x3:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        try {
            System.out.print("\nВведите номер столбца (0-2): ");
            int col = scanner.nextInt();

            System.out.println("Столбец " + col + ":");
            for (int i = 0; i < matrix.length; i++) {
                System.out.println("  " + matrix[i][col]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Ввод строки вместо числа!");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Столбца с таким номером не существует!");

        } finally {
            scanner.close();
        }
    }
}