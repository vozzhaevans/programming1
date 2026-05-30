package timus;

import java.util.Scanner;

public class task_1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        String[] a = new String[n + 1];

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                sb.append("sin(").append(j);
                if (j < i) {
                    sb.append((j % 2 == 1) ? "-" : "+");
                }
            }
            for (int j = 1; j <= i; j++) {
                sb.append(")");
            }
            a[i] = sb.toString();
        }

        StringBuilder res = new StringBuilder();
        res.append(a[1]).append("+").append(n);
        for (int i = 2; i <= n; i++) {
            res.insert(0, "(").append(")").append(a[i]).append("+").append(n - i + 1);
        }

        System.out.println(res);
    }
}
