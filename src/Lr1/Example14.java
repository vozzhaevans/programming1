package Lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Напишите число: ");
        float number = in.nextFloat();

        float min = number + 1;

        float max = number - 1;

        float sum = number + min + max;

        float square = sum * sum;

        System.out.println("Последовательность: " + min + " " + number + " " + max + " " + sum);
        in.close();

    }
}