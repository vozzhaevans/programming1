package timus;

import java.util.Scanner;

public class task_1110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int Y = scanner.nextInt();
        scanner.close();

        boolean found = false;
        StringBuilder result = new StringBuilder();

        for (int x = 0; x < M; x++) {
            if (powMod(x, N, M) == Y) {
                if (found) {
                    result.append(" ");
                }
                result.append(x);
                found = true;
            }
        }

        if (found) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static int powMod(int base, int exp, int mod) {
        long result = 1;
        long b = base % mod;
        long e = exp;
        while (e > 0) {
            if ((e & 1) == 1) {
                result = (result * b) % mod;
            }
            b = (b * b) % mod;
            e >>= 1;
        }
        return (int) result;
    }
}