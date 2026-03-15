package Lr9.compare.test2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> arrayList = createArrayList(2_000_000);
        List<Integer> linkedList = createLinkedList(2_000_000);

        System.out.println("СРАВНЕНИЕ ВРЕМЕНИ ДОБАВЛЕНИЯ ОДНОГО ЭЛЕМЕНТА В КОНЕЦ");
        System.out.println("Размер коллекции до добавления: 2 000 000 элементов");
        System.out.println("\n");

        System.out.println("Время выполнения операции добавления в конец ArrayList  = "
                + getArrayListAddLastTime(arrayList) + " мс");
        System.out.println("Время выполнения операции добавления в конец LinkedList = "
                + getLinkedListAddLastTime(linkedList) + " мс");
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



    private static long getArrayListAddLastTime(List<Integer> list) {
        long start = System.nanoTime();
        list.add(-1);
        long end = System.nanoTime();
        list.remove(list.size() - 1);
        return (end - start) / 1_000_000;
    }

    private static long getLinkedListAddLastTime(List<Integer> list) {
        long start = System.nanoTime();
        list.add(-1);
        long end = System.nanoTime();
        list.remove(list.size() - 1);
        return (end - start) / 1_000_000;
    }

}
