package Lr3;

import java.util.Arrays;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scanner.nextInt();

        if (size > 0){
            int numbers [] = new int[size];
            int j = 0;

            for ( int i = 0; j < size; i++) {
                if (i % 5 == 2) {
                    numbers[j] = i;
                    j++;
                }
            }
            System.out.println(Arrays.toString(numbers));
        }else{
            System.out.println("Размер должен быть больше нуля");
        }



    }
}