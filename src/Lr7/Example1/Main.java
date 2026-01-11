package Lr7.Example1;

public class Main {
    public static void main(String[] args) {
        SuperClass superClassObject =
                new SuperClass("передал в конструктор суперкласаа");
        String className = superClassObject.toString();
        System.out.println(className);

        SubClass subClassObject1 =
                new SubClass("передал в конструктор подкласса");
        String subClassName = subClassObject1.toString();
        System.out.println(subClassName);

        SubClass subClassObject2 =
                new SubClass("передал в конструктор подкласса", "где два параметра!");
        String subClassName2= subClassObject2.toString();
        System.out.println(subClassName2);
    }
}
