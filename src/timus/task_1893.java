package timus;

import java.util.Scanner;

public class task_1893 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        sc.close();

        int i = 0;
        while (i < input.length() && Character.isDigit(input.charAt(i))) {
            i++;
        }
        int row = Integer.parseInt(input.substring(0, i));
        char letter = input.charAt(i);

        String result;

        if (row <= 2) {
            if (letter == 'A' || letter == 'D') {
                result = "window";
            } else {
                result = "aisle";
            }
        } else if (row <= 20) {
            if (letter == 'A' || letter == 'F') {
                result = "window";
            } else {
                result = "aisle";
            }
        } else {
            if (letter == 'A' || letter == 'K') {
                result = "window";
            } else if (letter == 'C' || letter == 'D' || letter == 'G' || letter == 'H') {
                result = "aisle";
            } else {
                result = "neither";
            }
        }

        System.out.println(result);
    }
}