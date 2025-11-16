package Lr1;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Напишите название месяца: ");
        String month = in.nextLine();

        System.out.println("Напишите к-во дней в месяце: ");
        int day = in.nextInt();

        System.out.println( month + " содержит "+ day + " дней");
        in.close();

    }
}