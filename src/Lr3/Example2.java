package Lr3;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("ВВедите день недели с большой буквы: ");

        String a = in.nextLine();
        switch (a) {
            case "Понедельник": System.out.println("1");
                break;
            case "Вторник": System.out.println("2");
                break;
            case "Среда": System.out.println("3");
                break;
            case "Четверг": System.out.println("4");
                break;
            case "Пятница": System.out.println("5");
                break;
            case "Суббота": System.out.println("6");
                break;
            case "Воскресенье": System.out.println("7");
                break;
            default: System.out.println("Введены некорректные данные");
                break;
        }


    }


}
