package Lr2;

import java.util.Scanner;

public class Example4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("ВВедите целое число: ");

        int x = in.nextInt();

        if (x >= 5 && x <= 10) {
            System.out.println("ВВеденное число соответствует критериям");
        } else {
            System.out.println("ВВеденное число не соответствует критериям");
        }
    }

}