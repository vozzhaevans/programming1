package Lr3;

import java.util.Arrays;
import java.util.Random;

public class Example9 {
    public static void main(String[] args) {

        int n = 10;
        int [] Array = new int[n];
        Random random = new Random();
        for (int i = 0 ; i < Array.length ; i++) {
            Array[i] = random.nextInt(100);
            System.out.println("Элемент массива ["+i+"]: " + Array[i]);
        }

        int min = Arrays.stream(Array).min().getAsInt();
        System.out.println("Минимальное число: " + min);
        System.out.print("Индексы минимального элемента: ");

        boolean first = true;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (Array[i] == min) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(i);
                first = false;
                count++;
            }
        }
    }
}