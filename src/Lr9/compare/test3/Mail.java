package Lr9.compare.test3;

import java.util.*;

public class Mail {

    public static void main(String[] args) {

        // Создаем коллекции с 2 000 000 элементов
        List<Integer> arrayList = createArrayList(2_000_000);
        List<Integer> linkedList = createLinkedList(2_000_000);

        System.out.println("СРАВНЕНИЕ ВРЕМЕНИ ДОБАВЛЕНИЯ ОДНОГО ЭЛЕМЕНТА В СЕРЕДИНУ");
        System.out.println("Размер коллекции до добавления: 2 000 000 элементов");
        System.out.println("\n");

        System.out.println("Время выполнения операции добавления в середину ArrayList  = "
                + getArrayListAddMiddleTime(arrayList) + " мс");
        System.out.println("Время выполнения операции добавления в середину LinkedList = "
                + getLinkedListAddMiddleTime(linkedList) + " мс");

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

    private static SortedSet<Integer> createTreeSet(int size) {
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            set.add(i);
        }
        return set;
    }

    private static long getArrayListAddMiddleTime(List<Integer> list) {
        int middleIndex = list.size() / 2;
        long start = System.nanoTime();
        list.add(middleIndex, -1);
        long end = System.nanoTime();
        list.remove(middleIndex);
        return (end - start) / 1_000_000;
    }

    private static long getLinkedListAddMiddleTime(List<Integer> list) {
        int middleIndex = list.size() / 2;
        long start = System.nanoTime();
        list.add(middleIndex, -1);
        long end = System.nanoTime();
        list.remove(middleIndex);
        return (end - start) / 1_000_000;
    }


}