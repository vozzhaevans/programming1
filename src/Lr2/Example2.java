package Lr2;

import java.util.Scanner;

public class Example2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("ВВедите целое число, при делении которого на 5 в остатке получается 2, а при делении на 7 в остатке получается 1: ");

        int x = in.nextInt();

        int result = x % 5;

        int result1 = x % 7;

        if (result == 2 && result1 == 1) {
            System.out.println("ВВеденное число соответствует критериям");
        } else {
            System.out.println("ВВеденное число не соответствует критериям");
        }
    }

}
