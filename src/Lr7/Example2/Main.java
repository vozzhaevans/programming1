package Lr7.Example2;

public class Main {
    public static void main(String[] args) {
        SubClass obj = new SubClass("Hello", 42);

        System.out.println("Исходные значения:");
        System.out.println("Текст: " + obj.getText());
        System.out.println("Число: " + obj.getNumber());
        System.out.println("Длина текста: " + obj.getTextLength());

        obj.setText();
        System.out.println("\nТекст: " + obj.getText());
        System.out.println("Число: " + obj.getNumber());

        // С текстовым параметром
        obj.setText("World");
        System.out.println("\nТекст: " + obj.getText());
        System.out.println("Число: " + obj.getNumber());

        // С целочисленным параметром
        obj.setText(100);
        System.out.println("\nТекст: " + obj.getText());
        System.out.println("Число: " + obj.getNumber());

        // С текстовым и целочисленным параметром
        obj.setText("Java", 2024);
        System.out.println("\nТекст: " + obj.getText());
        System.out.println("Число: " + obj.getNumber());
        System.out.println("Длина текста: " + obj.getTextLength());
    }
}
