package timus;

import java.io.PrintWriter;
import java.util.Scanner;

public class task_1877 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        if (n1 % 2 == 0 || n2 % 2 != 0) {
        System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
