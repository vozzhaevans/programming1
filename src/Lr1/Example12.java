package Lr1;

import java.util.Scanner;
import java.time.Year;

public class Example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        System.out.println("Напишите свой возраст: ");
        int age = in.nextInt();

        int year = Year.now().getValue();

        int birth = year - age;

        System.out.println( "Ваш год рожденияя: " + birth );
        in.close();

    }
}