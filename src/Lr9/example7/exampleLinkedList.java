package Lr9.example7;

import java.util.LinkedList;
import java.util.Scanner;

public class exampleLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество человек (N): ");
        int N = scanner.nextInt();

        LinkedList<Integer> people = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        System.out.println("Начальный круг: " + people);

        int index = 0;

        while (people.size() > 1) {
            index = (index + 1) % people.size();

            System.out.println("Удаляется человек: " + people.get(index));
            people.remove(index);

            System.out.println("Остались: " + people);
        }

        System.out.println("\nПоследний оставшийся человек: " + people.get(0));

        scanner.close();
    }
}