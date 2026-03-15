package Lr9.example3;

import java.util.Scanner;

public class Example1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Введите элементы массива:");
        input(array, 0);

        System.out.println("\nВведенный массив:");
        output(array, 0);

        scanner.close();
    }

    public static void input(int[] arr, int index) {
        if (index < arr.length) {
            System.out.print("arr[" + index + "] = ");
            arr[index] = scanner.nextInt();
            input(arr, index + 1);
        }
    }

    public static void output(int[] arr, int index) {
        if (index < arr.length) {
            System.out.print(arr[index] + " ");
            output(arr, index + 1);
        }
    }
}
