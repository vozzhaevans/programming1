package Lr9.compare.test5;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Создаем коллекции с 2 000 000 элементов
        List<Integer> arrayList = createArrayList(2_000_000);
        List<Integer> linkedList = createLinkedList(2_000_000);

        System.out.println("СРАВНЕНИЕ ВРЕМЕНИ УДАЛЕНИЯ ОДНОГО ЭЛЕМЕНТА В КОНЦЕ");
        System.out.println("Размер коллекции до удаления: 2 000 000 элементов");
        System.out.println("\n");

        System.out.println("Время выполнения операции удаления в конце ArrayList  = "
                + getArrayListRemoveLastTime(arrayList) + " мс");
        System.out.println("Время выполнения операции удаления в конце LinkedList = "
                + getLinkedListRemoveLastTime(linkedList) + " мс");
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

    private static long getArrayListRemoveLastTime(List<Integer> list) {
        long start = System.nanoTime();
        int lastIndex = list.size() - 1;
        int removedValue = list.remove(lastIndex);
        long end = System.nanoTime();
        list.add(removedValue);
        return (end - start) / 1_000_000;
    }

    private static long getLinkedListRemoveLastTime(List<Integer> list) {
        long start = System.nanoTime();
        int removedValue = ((LinkedList<Integer>) list).removeLast();
        long end = System.nanoTime();
        ((LinkedList<Integer>) list).addLast(removedValue);
        return (end - start) / 1_000_000;
    }

}