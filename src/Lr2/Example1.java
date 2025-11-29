package Lr2;

import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("ВВедите целое число: ");

        int x = in.nextInt();

        int result = x % 3;

        if (result == 0) {
            System.out.println("ВВеденное число делится на три");
        } else {
            System.out.println("ВВеденное число не делится на три");
        }
    }

}
