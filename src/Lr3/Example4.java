package Lr3;

import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("ВВедите два разных целых числа: ");

        int a = in.nextInt();
        int b = in.nextInt();


        if (a > b) {
            for (int i = b ; i <= a ; i++){
                System.out.println(i);
            }
        } else if (a<b) {
            for (int i = a ; i <= b ; i++) {
                System.out.println(i);
            }
        } else {
            System.out.println("ВВедено одно и тоже число: " + a + " " + b);
        }



    }


}