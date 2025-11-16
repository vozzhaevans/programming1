package Lr1;

import java.util.Scanner;
import java.time.Year;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        System.out.println("Напишите свой год рождения: ");
        int birth = in.nextInt();

        int year = Year.now().getValue();

        int age = year - birth;

        System.out.println( "Ваш возраст: " + age );
        in.close();

    }
}
