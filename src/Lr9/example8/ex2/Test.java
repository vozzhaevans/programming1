package Lr9.example8.ex2;


public class Test {
    public static void main(String[] args) {
        RecursiveList list = new RecursiveList();

        list.createHeadRec(1, 2, 3, 4, 5);
        System.out.println("createHeadRec: " + list); // 1 2 3 4 5

        list.createTailRec(10, 20, 30);
        System.out.println("createTailRec: " + list); // 10 20 30
    }
}