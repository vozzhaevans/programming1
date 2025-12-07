package Lr3;

import java.util.Scanner;

public class Example4_1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("ВВедите два разных целых числа: ");

        int a = in.nextInt();
        int b = in.nextInt();
        int count = 0;

        if (a > b) {
            count = b;
            while (count <= a){
                System.out.println(count);
                count++;
            }
        } else if (a<b) {
            count = a;
            while (count <= b){
                System.out.println(count);
                count++;
            }
        } else {
            System.out.println("ВВедено одно и тоже число: " + a + " " + b);
        }



    }


}