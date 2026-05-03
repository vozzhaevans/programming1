package timus;

import java.util.Scanner;

public class task_2025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int q = n / k;
            int r = n % k;

            long inside = (long) r * (q + 1) * q / 2 + (long) (k - r) * q * (q - 1) / 2;
            long totalPairs = (long) n * (n - 1) / 2;
            long result = totalPairs - inside;

            System.out.println(result);
        }
        sc.close();
    }
}
