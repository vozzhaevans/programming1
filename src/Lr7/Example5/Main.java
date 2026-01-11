package Lr7.Example5;

public class Main {
    public static void main(String[] args) {
        SuperClass objSuper = new SuperClass("Привет");
        SubClass1 obj1 = new SubClass1("Мир", 42);
        SubClass2 obj2 = new SubClass2("Java", 'A');

        objSuper.displayInfo();
        obj1.displayInfo();
        obj2.displayInfo();

        SuperClass ref1 = obj1;
        SuperClass ref2 = obj2;

        System.out.println("Через ссылку суперкласса ");
        ref1.displayInfo();

        ref2.displayInfo();
    }
}
