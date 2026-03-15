package Lr9.compare.test7;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Создаем коллекции с 2 000 000 элементов
        List<Integer> arrayList = createArrayList(2_000_000);
        List<Integer> linkedList = createLinkedList(2_000_000);

        System.out.println("СРАВНЕНИЕ ВРЕМЕНИ ПОЛУЧЕНИЯ ЭЛЕМЕНТА ПО ИНДЕКСУ");
        System.out.println("Размер коллекции: 2 000 000 элементов");
        System.out.println("\n");

        System.out.println("Время выполнения операции получения элемента по индексу ArrayList  = "
                + getArrayListGetTime(arrayList) + " нс");
        System.out.println("Время выполнения операции получения элемента по индексу LinkedList = "
                + getLinkedListGetTime(linkedList) + " нс");
    }

    private static List<Integer> createArrayList(int size) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    private static List<Integer> createLinkedList(int size) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }


    private static long getArrayListGetTime(List<Integer> list) {
        int index = list.size() / 2;
        long start = System.nanoTime();
        int value = list.get(index);
        long end = System.nanoTime();
        return end - start;
    }

    private static long getLinkedListGetTime(List<Integer> list) {
        int index = list.size() / 2;
        long start = System.nanoTime();
        int value = list.get(index);
        long end = System.nanoTime();
        return end - start;
    }

}