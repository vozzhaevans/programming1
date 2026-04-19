package Lr11;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер массива:");
        int size = in.nextInt();

        System.out.println("Введите число-делитель:");
        int divisor = in.nextInt();

        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100) + 1;
        }

        System.out.println("\nИсходный массив arr: ");
        System.out.println(Arrays.toString(arr));

        int[] arrResult = filterNumbersByDivisor(arr, divisor);
        System.out.println("\nМассив arrResult: ");
        System.out.println(Arrays.toString(arrResult));
    }

    private static int[] filterNumbersByDivisor(int[] arr, int divisor) {
        return Arrays.stream(arr)
                .filter(x -> x % divisor == 0)
                .toArray();
    }

}