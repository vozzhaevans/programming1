package timus;

import java.util.Scanner;
import java.io.PrintWriter;
public class task_2012 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int f = in.nextInt();

        int time = 60 + (12 - f)*45;

        if (time <= 300) {
            out.println("YES");
        } else {
            out.println("NO");
        }

        out.flush();
    }

}
