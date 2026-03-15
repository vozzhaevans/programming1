package Lr9.example8.ex1;

public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public void createHead(int[] values) {
        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node(values[i], head);
        }
    }

    public void createHead() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Введите значение " + (i + 1) + ": ");
            int value = scanner.nextInt();
            head = new Node(value, head);
        }
    }

    public void createTail(int[] values) {
        for (int value : values) {
            this.addLast(value);
        }
    }

    public void createTail() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Введите значение " + (i + 1) + ": ");
            int value = scanner.nextInt();
            this.addLast(value);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;

        while (current != null) {
            result.append(current.value);
            if (current.next != null) {
                result.append(" -> ");
            }
            current = current.next;
        }

        return result.toString();
    }

    public void addFirst(int value) {
        head = new Node(value, head);
    }

    public void addLast(int value) {
        if (head == null) {
            head = new Node(value, null);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value, null);
    }

    public void insert(int index, int value) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным");
        }

        if (index == 0) {
            addFirst(value);
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Индекс превышает размер списка");
            }
            current = current.next;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Индекс превышает размер списка");
        }

        current.next = new Node(value, current.next);
    }

    public void removeFirst() {
        if (head == null) {
            throw new IllegalStateException("Список пуст");
        }
        head = head.next;
    }

    public void removeLast() {
        if (head == null) {
            throw new IllegalStateException("Список пуст");
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // и) удаление элемента с указанным номером Remove()
    public void remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным");
        }

        if (head == null) {
            throw new IllegalStateException("Список пуст");
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.next == null) {
                throw new IndexOutOfBoundsException("Индекс превышает размер списка");
            }
            current = current.next;
        }

        if (current.next == null) {
            throw new IndexOutOfBoundsException("Индекс превышает размер списка");
        }

        current.next = current.next.next;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void createFromArray(int[] values, boolean fromHead) {
        if (fromHead) {
            createHead(values);
        } else {
            createTail(values);
        }
    }
}