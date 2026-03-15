package timus;

import java.util.Scanner;

public class task_1607 {
            public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                int d = in.nextInt();

                while (a < c) {
                    if (a + b > c) {
                        a = c;
                        break;
                    }
                    a += b;

                    if (c - d < a) {
                        break;
                    }
                    c -= d;
                }

                System.out.println(a);
            }
        }
