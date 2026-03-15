package Lr9.example6;

import java.util.HashMap;
import java.util.Map;

public class Example1{
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(0, "Zero Fruit");
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        map.put(4, "Date");
        map.put(5, "Elderberry");
        map.put(6, "Fig");
        map.put(7, "Grape");
        map.put(8, "Honeydew");
        map.put(9, "Indian Fig");

        System.out.println("Исходный :");
        printMap(map);

        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println("  ключ: " + entry.getKey() + ", значение: " + entry.getValue());
            }
        }

        System.out.print("Строки с ключом = 0: ");
        boolean hasKeyZero = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                System.out.print(entry.getValue());
                hasKeyZero = true;
                break;
            }
        }
        if (!hasKeyZero) {
            System.out.print("нет элементов с ключом 0");
        }
        System.out.println("\n");

        long product = 1;
        boolean hasElements = false;

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                hasElements = true;
                System.out.println("  ключ: " + entry.getKey() + ", значение: \"" +
                        entry.getValue() + "\" (длина: " + entry.getValue().length() + ")");
            }
        }

        if (hasElements) {
            System.out.println("Произведение ключей (где длина строки > 5): " + product);
        } else {
            System.out.println("Нет элементов с длиной строки > 5");
        }
    }

    public static void printMap(HashMap<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}