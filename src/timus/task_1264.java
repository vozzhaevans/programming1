package timus;

import java.util.Scanner;

public class task_1264 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int m2 = m +1;
        int result = n * m2;

        System.out.println(result);
    }
}
