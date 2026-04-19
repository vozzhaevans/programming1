package Lr11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Example10 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();

        System.out.println("\n" + "Исходный список чисел: " + "\n");

        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(100));
            System.out.println(integers.get(i));
        }

        int threshold = 50;
        List<Integer> integersAfter = filterNumbersGreaterThan(integers, threshold);

        System.out.println("\n" + "Числа меньше " + threshold + ": " + "\n");
        for (Integer i : integersAfter) {
            System.out.println(i);
        }

    }

    private static List<Integer> filterNumbersGreaterThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(x -> x < threshold)
                .collect(Collectors.toList());
    }

}