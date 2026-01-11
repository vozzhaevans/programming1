package Lr7.Example3;

public class Main {
    public static void main(String[] args) {
        FirstClass obj1 = new FirstClass(42);
        String className = obj1.toString();
        System.out.println(className);

        SecondClass obj2 = new SecondClass(100, 'A');
        String className2 = obj2.toString();
        System.out.println(className2);

        ThirdClass obj3 = new ThirdClass(2024, 'Z', "Hi");
        String className3 = obj3.toString();
        System.out.println(className3);

    }
}
