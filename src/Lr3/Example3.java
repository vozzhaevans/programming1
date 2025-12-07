package Lr3;

import java.util.Scanner;
import java.util.Arrays;

public class Example3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("ВВедите кол-во чисел в массиве: ");

        int a = in.nextInt();

        int [] fib = new int [a];

        fib [0] = 1;

        fib [1] = 1;

        for (int i = 2 ; i < fib.length ; i++) {
            fib [i] = fib [i-2] + fib [i-1];
        }

        System.out.println("Массив: " + Arrays.toString(fib));

    }


}