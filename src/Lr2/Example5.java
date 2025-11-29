package Lr2;

import java.util.Scanner;

public class Example5 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("ВВедите число больше тысячи: ");

        int x = in.nextInt();

        int ths = (x / 1000) % 10;

        System.out.println("В данном числе " + ths + " тысяч");

    }

}
