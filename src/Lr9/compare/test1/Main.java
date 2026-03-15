package Lr9.compare.test1;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = createArrayList(2_000_000);
        LinkedList<Integer> linkedList = createLinkedList(2_000_000);
        SortedSet<Integer> treeSet = createTreeSet(2_000_000);

        System.out.println("СРАВНЕНИЕ ВРЕМЕНИ ДОБАВЛЕНИЯ ОДНОГО ЭЛЕМЕНТА В НАЧАЛО");
        System.out.println("Размер коллекции до добавления: 2 000 000 элементов");
        System.out.println("\n");

        System.out.println("Время выполнения операции добавления в начало ArrayList  = "
                + getArrayListAddFirstTime(arrayList) + " мс");
        System.out.println("Время выполнения операции добавления в начало LinkedList = "
                + getLinkedListAddFirstTime(linkedList) + " мс");
    }

    private static ArrayList<Integer> createArrayList(int size) {
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    private static LinkedList<Integer> createLinkedList(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    private static TreeSet<Integer> createTreeSet(int size) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            set.add(i);
        }
        return set;
    }

    private static long getArrayListAddFirstTime(ArrayList<Integer> list) {
        long start = System.nanoTime();
        list.add(0, -1);
        long end = System.nanoTime();
        list.remove(0);
        return (end - start) / 1_000_000;
    }

    private static long getLinkedListAddFirstTime(LinkedList<Integer> list) {
        long start = System.nanoTime();
        list.addFirst(-1);
        long end = System.nanoTime();
        list.removeFirst();
        return (end - start) / 1_000_000;
    }

}