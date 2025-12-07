package Lr3;

import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;

public class Example10 {
    public static void main(String[] args) {

        int n = 10;
        int [] Array = new int[n];
        Random random = new Random();
        for (int i = 0 ; i < Array.length ; i++) {
            Array[i] = random.nextInt(100);
        }
        int[] sortedArr = Arrays.stream(Array)
                .boxed() // Преобразуем в поток Integer
                .sorted(Comparator.reverseOrder()) // Сортируем по убыванию
                .mapToInt(Integer::intValue) // Обратно в int
                .toArray(); // Преобразуем в массив
        System.out.println(Arrays.toString(sortedArr));

    }
}