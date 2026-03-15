package Lr9.example5;

public class test2 {
    public static void main(String[] args) {
        Node head = null;
        for (int i = 9; i >=0; i--) {
            head = new Node(i, head);
        }
        Node ref = head;
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}
