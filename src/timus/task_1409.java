package timus;

import java.util.Scanner;
import java.io.PrintWriter;
public class task_1409 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = in.nextInt();

        int b = in.nextInt();

        int sum = a + b - 1;

        int Harry = sum - a;

        int Larry = sum - b;

        out.println(Harry + " " + Larry);
        out.flush();
    }

}