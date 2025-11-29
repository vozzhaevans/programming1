package timus;

import java.util.Scanner;
import java.io.PrintWriter;
public class task_2001 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a1 = in.nextInt();
        int b1 = in.nextInt();
        int a2 = in.nextInt();
        int b2 = in.nextInt();
        int a3 = in.nextInt();
        int b3 = in.nextInt();

        int a = a1 - a3;
        int b = b1 - b2;

        out.println(a + " " + b);
        out.flush();
    }

}

