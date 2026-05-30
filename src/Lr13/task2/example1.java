package Lr13.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class example1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;

        try {
            int size = 0;
            boolean validSize = false;

            while (!validSize) {
                try {
                    System.out.print("Введите размер массива: ");
                    size = scanner.nextInt();
                    if (size <= 0) {
                        System.out.println("Размер должен быть > 0. Попробуйте снова.");
                    } else {
                        validSize = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ОШИБКА: Введите целое число!");
                    scanner.next();
                }
            }

            int[] array = new int[size];
            System.out.println("Введите элементы массива (целые числа):");

            for (int i = 0; i < size; i++) {
                while (true) {
                    try {
                        System.out.print("array[" + i + "] = ");
                        array[i] = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("ОШИБКА: Введите целое число!");
                        scanner.next();
                    }
                }
            }

            int sum = 0;
            int count = 0;

            for (int num : array) {
                if (num > 0) {
                    sum += num;
                    count++;
                }
            }

            if (count == 0) {
                throw new IllegalArgumentException("В массиве нет положительных элементов");
            }

            double average = (double) sum / count;

            System.out.println("\nРЕЗУЛЬТАТЫ");
            System.out.print("Исходный массив: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println("\nКоличество положительных элементов: " + count);
            System.out.println("Сумма положительных элементов: " + sum);
            System.out.println("Среднее значение: " + average);

            success = true;

        } catch (InputMismatchException e) {
            System.out.println("КРИТИЧЕСКАЯ ОШИБКА: Несоответствие типа данных");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("ОШИБКА: " + e);
            System.out.println("Невозможно вычислить среднее значение.");
        } catch (Exception e) {
            System.out.println("НЕПРЕДВИДЕННАЯ ОШИБКА: " + e);
            e.printStackTrace();
        } finally {
            System.out.println("\nПрограмма завершила выполнение.");
            scanner.close();
        }

        if (success) {
            System.out.println("Вычисление выполнено успешно!");
        }
    }
}