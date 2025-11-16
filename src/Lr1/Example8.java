package Lr1;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Напишите текущий день недели: ");
        String week = in.nextLine();

        System.out.println("Напишите название месяца: ");
        String month = in.nextLine();

        System.out.println("Напишите номер дня в месяце: ");
        int day = in.nextInt();

        System.out.println("Сегодняшняя дата: " + week + " "+ day + " " + month);
        in.close();

    }
}