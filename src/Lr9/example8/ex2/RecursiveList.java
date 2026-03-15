package Lr9.example8.ex2;

public class RecursiveList {
    private Node head;

    private static class Node {
        int value;
        Node next;

        Node(int v, Node n) {
            value = v;
            next = n;
        }
    }

    // Рекурсивное создание с головы
    public void createHeadRec(int... vals) {
        head = createHeadRec(vals, vals.length - 1);
    }

    private Node createHeadRec(int[] v, int i) {
        return i < 0 ? null : new Node(v[i], createHeadRec(v, i - 1));
    }

    // Рекурсивное создание с хвоста
    public void createTailRec(int... vals) {
        head = createTailRec(vals, 0);
    }

    private Node createTailRec(int[] v, int i) {
        return i >= v.length ? null : new Node(v[i], createTailRec(v, i + 1));
    }

    // Рекурсивный вывод
    @Override
    public String toString() {
        return head == null ? "[]" : toStringRec(head);
    }

    private String toStringRec(Node n) {
        return n.next == null ? String.valueOf(n.value) : n.value + " " + toStringRec(n.next);
    }
}
