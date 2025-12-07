package timus;

import java.util.Scanner;
public class task_1787 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int n = in.nextInt();
        int a = 0;

        for (int i = 0 ; i < n ; i++){
            int x = in.nextInt();
            a = a + x - k;
            if (a < 0) {
                a =0;
            }
        }
        System.out.println(a);
    }

}
