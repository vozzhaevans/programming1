package Lr9.example8.ex1;


public class Test {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ ОДНОСВЯЗНОГО СПИСКА ===\n");

        // 1. Создание списка с головы
        System.out.println("1. createHead() с массива [1, 2, 3, 4, 5]:");
        LinkedList list1 = new LinkedList();
        list1.createHead(new int[]{1, 2, 3, 4, 5});
        System.out.println("Результат: " + list1.toString());

        // 2. Создание списка с хвоста
        System.out.println("2. createTail() с массива [10, 20, 30, 40]:");
        LinkedList list2 = new LinkedList();
        list2.createTail(new int[]{10, 20, 30, 40});
        System.out.println("Результат: " + list2.toString());

        // 3. Тестирование AddFirst()
        System.out.println("3. addFirst(100) к списку " + list2);
        list2.addFirst(100);
        System.out.println("Результат: " + list2.toString());

        // 4. Тестирование AddLast()
        System.out.println("4. addLast(200) к списку " + list2);
        list2.addLast(200);
        System.out.println("Результат: " + list2.toString());

        // 5. Тестирование Insert()
        System.out.println("5. insert(2, 300) в список " + list2);
        list2.insert(2, 300);
        System.out.println("Результат: " + list2.toString());

        // 6. Тестирование RemoveFirst()
        System.out.println("6. removeFirst() от списка " + list2);
        list2.removeFirst();
        System.out.println("Результат: " + list2.toString());

        // 7. Тестирование RemoveLast()
        System.out.println("7. removeLast() от списка " + list2);
        list2.removeLast();
        System.out.println("Результат: " + list2.toString());

        // 8. Тестирование Remove() по индексу
        System.out.println("8. remove(2) от списка " + list2);
        list2.remove(2);
        System.out.println("Результат: " + list2.toString());

    }
}