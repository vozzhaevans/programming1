package Lr6.Example1;

public class Main {
    public static void main(String[] args) {
        Example1 ex1 = new Example1();
        ex1.setAb('b');
        ex1.show();
        ex1.setAb("abcd");
        ex1.show();
        ex1.setAb (new char[]{'a', 'd', 'f'} );
        ex1.show();
    }
}
