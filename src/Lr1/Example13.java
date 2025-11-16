package Lr1;

import java.util.Scanner;

public class Example13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Напишите первое число: ");
        float one = in.nextFloat();

        System.out.println("Напишите второе число: ");
        float two = in.nextFloat();

        float sum = one + two;

        System.out.println("Сумма чисел: " + sum);
        in.close();

    }
}