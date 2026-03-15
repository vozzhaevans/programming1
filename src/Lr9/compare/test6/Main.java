package Lr9.compare.test6;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Создаем коллекции с 2 000 000 элементов
        List<Integer> arrayList = createArrayList(2_000_000);
        List<Integer> linkedList = createLinkedList(2_000_000);

        System.out.println("СРАВНЕНИЕ ВРЕМЕНИ УДАЛЕНИЯ ОДНОГО ЭЛЕМЕНТА В СЕРЕДИНЕ");
        System.out.println("Размер коллекции до удаления: 2 000 000 элементов");
        System.out.println("\n");

        System.out.println("Время выполнения операции удаления в середине ArrayList  = "
                + getArrayListRemoveMiddleTime(arrayList) + " мс");
        System.out.println("Время выполнения операции удаления в середине LinkedList = "
                + getLinkedListRemoveMiddleTime(linkedList) + " мс");
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

    private static long getArrayListRemoveMiddleTime(List<Integer> list) {
        int middleIndex = list.size() / 2;
        int removedValue = list.get(middleIndex);
        long start = System.nanoTime();
        list.remove(middleIndex);
        long end = System.nanoTime();
        list.add(middleIndex, removedValue);
        return (end - start) / 1_000_000;
    }

    private static long getLinkedListRemoveMiddleTime(List<Integer> list) {
        int middleIndex = list.size() / 2;
        int removedValue = list.get(middleIndex);
        long start = System.nanoTime();
        list.remove(middleIndex);
        long end = System.nanoTime();
        list.add(middleIndex, removedValue);
        return (end - start) / 1_000_000;
    }

}