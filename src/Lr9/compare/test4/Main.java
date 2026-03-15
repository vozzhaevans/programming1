package Lr9.compare.test4;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Создаем коллекции с 2 000 000 элементов
        List<Integer> arrayList = createArrayList(2_000_000);
        List<Integer> linkedList = createLinkedList(2_000_000);

        System.out.println("СРАВНЕНИЕ ВРЕМЕНИ УДАЛЕНИЯ ОДНОГО ЭЛЕМЕНТА В НАЧАЛЕ");
        System.out.println("Размер коллекции до удаления: 2 000 000 элементов");
        System.out.println("\n");

        System.out.println("Время выполнения операции удаления в начале ArrayList  = "
                + getArrayListRemoveFirstTime(arrayList) + " мс");
        System.out.println("Время выполнения операции удаления в начале LinkedList = "
                + getLinkedListRemoveFirstTime(linkedList) + " мс");
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

    private static long getArrayListRemoveFirstTime(List<Integer> list) {

        long start = System.nanoTime();
        list.remove(0);
        long end = System.nanoTime();
        list.add(0, 0);

        return (end - start) / 1_000_000;
    }


    private static long getLinkedListRemoveFirstTime(List<Integer> list) {
        long start = System.nanoTime();
        ((LinkedList<Integer>) list).removeFirst();
        long end = System.nanoTime();
        ((LinkedList<Integer>) list).addFirst(0);

        return (end - start) / 1_000_000;
    }

}